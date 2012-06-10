package net.a103.may.mfa.vote;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import net.a103.may.mfa.vote.api.APIListener;
import net.a103.may.mfa.vote.api.APICallTask;

import android.app.Application;

public class MFAApplication extends Application {

	private List<String> phoneCodeList = new LinkedList<String>();
	private List<Integer> idList = new ArrayList<Integer>();
	private List<String[][]> enqueteList = new ArrayList<String[][]>();


	public void sendPhoneCode(String code, final APIListener listener) {
		APIListener wrapper = new APIListener() {
			@Override
			public void onSuccess() {
				phoneCodeList.clear();
				if (listener != null)
					listener.onSuccess();
			}

			@Override
			public void onError(int code) {

				if (code == APICallTask.HTTP_ERROR) {
					if (listener != null)
						listener.onSuccess();
				} else {
					phoneCodeList.clear();
					if (listener != null)
						listener.onError(code);
				}

			}
		};

		if (code != null)
			phoneCodeList.add(0, code);

		new APICallTask(wrapper, APICallTask.makeQuery("codes",
				phoneCodeList.toArray(new String[phoneCodeList.size()])),
				"https://www.a103.net/may/85/system/mfa/validate_code",
				phoneCodeList)
				.execute();
	}

	public void sendPhoneCode() {
		sendPhoneCode(null, null);
	}
	
	public String getNotYetCode() {
		return phoneCodeList.toString();
	}

	public void vote(Integer[] id) {
		APIListener wrapper = new APIListener() {
			@Override
			public void onSuccess() {
				idList.clear();
			}

			@Override
			public void onError(int code) {

				if (code != APICallTask.HTTP_ERROR) {
					idList.clear();
				}

			}
		};

		for(Integer i : id) 
			if(i > 100)
				idList.add(i);

		new APICallTask(wrapper, APICallTask.makeQuery("ids",
				idList.toArray(new Integer[idList.size()])),
				"https://www.a103.net/may/85/system/mfa/vote",
				idList).execute();
	}

	public void vote() {
		vote(new Integer[]{0});
	}
	
	public String getNotYetIds() {
		return idList.toString();
	}

	public void enquete(String age, String gender, String[] where) {
		APIListener wrapper = new APIListener() {
			@Override
			public void onSuccess() {
				enqueteList.clear();
			}

			@Override
			public void onError(int code) {

				if (code != APICallTask.HTTP_ERROR) {
					enqueteList.clear();
				}

			}
		};

		if (age != null) {
			StringBuilder sb = new StringBuilder();

			for (String w : where) {
				sb.append(w);
				sb.append(", ");
			}

			enqueteList.add(new String[][] { new String[] { "age", age },
					new String[] { "gender", gender },
					new String[] { "where", sb.toString() } });
		}

		new APICallTask(wrapper, APICallTask.makeQuery("enquetes",
				enqueteList.toArray(new String[enqueteList.size()][][])),
				"https://www.a103.net/may/85/system/mfa/enquete",
				enqueteList).execute();
	}

	public void enquete() {
		enquete(null, null, null);
	}
	
	public String getNotYetEnquete() {
		return enqueteList.toString();
	}

}
