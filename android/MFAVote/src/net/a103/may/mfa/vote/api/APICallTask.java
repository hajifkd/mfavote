package net.a103.may.mfa.vote.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

public class APICallTask extends AsyncTask<Void, Void, JSONObject> {

	public static final int HTTP_ERROR = -1;

	public static String makeQuery(String name, String[][][] args) {
		StringBuilder sb = new StringBuilder("pass=kerokero&");
		
		JSONArray array = new JSONArray();

		for (String[][] arg : args) {
			JSONObject obj = new JSONObject();
			
			for(String[] el : arg) {
				try {
					obj.put(el[0], el[1]);
				} catch (JSONException e) {
					e.printStackTrace();
				}	
			}
			array.put(obj);
		}
		
		sb.append(name);
		sb.append("=");
		
		try {
			sb.append(URLEncoder.encode(array.toString(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sb.toString();
	}

	public static String makeQuery(String name, String[] code) {
		StringBuilder sb = new StringBuilder("pass=kerokero&");

		sb.append(name);
		sb.append("=");

		JSONArray array = new JSONArray();

		for (String s : code) {
			array.put(s);
		}

		try {
			sb.append(URLEncoder.encode(array.toString(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return sb.toString();
	}

	public static String makeQuery(String name, Integer[] code) {
		StringBuilder sb = new StringBuilder("pass=kerokero&");

		sb.append(name);
		sb.append("=");

		JSONArray array = new JSONArray();

		for (int s : code) {
			array.put(s);
		}

		try {
			sb.append(URLEncoder.encode(array.toString(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sb.toString();
	}

	private APIListener listener;
	private String args;
	private String url;
	private List<? extends Object> list;

	public APICallTask(APIListener listener, String args, String url, List<? extends Object> list) {
		this.listener = listener;
		this.args = args;
		this.url = url;
		this.list = list;
	}

	private HttpRequestBase createRequest() throws UnsupportedEncodingException {
		HttpPost request = new HttpPost(url);

		StringEntity paramEntity = new StringEntity(args);
		
		paramEntity.setChunked(false);
		paramEntity.setContentType("application/x-www-form-urlencoded");
		
		request.setEntity(paramEntity);

		// request.addHeader("Content-Type", "application/json");
		// The code below may be unnecessary for Android 2.3 or later.
		// request.getParams().setBooleanParameter(
		// CoreProtocolPNames.USE_EXPECT_CONTINUE, false);

		return request;
	}

	private HttpClient createClient() {
		HttpParams params =  new BasicHttpParams();

		HttpConnectionParams.setConnectionTimeout(params, 3000);
		HttpConnectionParams.setSoTimeout(params, 3000);
		
		SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
		
		SingleClientConnManager mgr = new SingleClientConnManager(params, schemeRegistry);
		
		HttpClient client = new DefaultHttpClient(mgr, params);
		

		return client;
	}

	@Override
	protected JSONObject doInBackground(Void... params) {
		synchronized (list) {
			if(list.size() == 0) 
				return null;
			HttpRequestBase method;
			try {
				method = createRequest();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return null;
			}
			if (method == null)
				return null;
			HttpClient client = createClient();
			Log.d(this.getClass().getName(), method.getURI().toString());
			HttpResponse response = null;
			try {
				response = client.execute(method);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				JSONObject json = getJSON(response);
				return json;
			}
			return null;
		}
	}

	private JSONObject getJSON(HttpResponse response) {
		String body = null;
		try {
			body = convertStreamToString(response.getEntity().getContent(),
					"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		if (body == null)
			return null;
		
		if("".equals(body))
			return new JSONObject();

		try {
			return new JSONObject(body);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

	private String convertStreamToString(InputStream inputStream, String encode) {
		try {
			BufferedReader responseReader = new BufferedReader(
					new InputStreamReader(inputStream, encode));
			StringBuilder responseBuilder = new StringBuilder();
			String line;

			while ((line = responseReader.readLine()) != null) {
				responseBuilder.append(line).append("\n");
			}
			responseReader.close();

			return responseBuilder.toString();

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	protected void onCancelled() {
		listener.onError(HTTP_ERROR);
	}

	@Override
	protected void onPostExecute(JSONObject result) {
		if (result == null) {
			listener.onError(HTTP_ERROR);
		} else if (result.has("error")) {
			try {
				listener.onError(result.getInt("error"));
			} catch (JSONException e) {
				// never reach
				e.printStackTrace();
				listener.onError(HTTP_ERROR);
			}
		} else {
			listener.onSuccess();
		}
	}

}
