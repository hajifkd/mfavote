package net.a103.may.mfa.vote;

import net.a103.may.mfa.vote.api.APIListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DebugActivity extends AbstractActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.debug);
		
		LinearLayout root = (LinearLayout) findViewById(R.id.root);
		
		Button setting = new Button(this);
		setting.setText("設定に行く");
		setting.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent=new Intent("android.settings.SETTINGS");
				startActivity(intent);
			}
			
		});
		
		root.addView(setting);
		
		Button vote = new Button(this);
		vote.setText("企画に投票([301,302,303])");
		vote.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				MFAApplication app = (MFAApplication) getApplication();
				app.vote(new Integer[]{301, 302, 303});
			}
			
		});
		
		root.addView(vote);
		
		Button showid = new Button(this);
		showid.setText("ネットワークエラー未投票ID");
		showid.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				MFAApplication app = (MFAApplication) getApplication();
				Toast.makeText(DebugActivity.this, app.getNotYetIds(), Toast.LENGTH_LONG).show();
			}
			
		});
		
		root.addView(showid);
		
		final EditText et = new EditText(this);
		root.addView(et);
		
		Button code = new Button(this);
		code.setText("コード送信");
		code.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				MFAApplication app = (MFAApplication) getApplication();
				app.sendPhoneCode(et.getText().toString(), new APIListener(){

					@Override
					public void onSuccess() {
						Toast.makeText(DebugActivity.this, "success", Toast.LENGTH_LONG).show();
					}

					@Override
					public void onError(int code) {
						Toast.makeText(DebugActivity.this, "fail", Toast.LENGTH_LONG).show();
					}
					
				});
			}
			
		});
		
		root.addView(code);
		
		Button showcode = new Button(this);
		showcode.setText("ネットワークエラー未投票コード");
		showcode.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				MFAApplication app = (MFAApplication) getApplication();
				Toast.makeText(DebugActivity.this, app.getNotYetCode(), Toast.LENGTH_LONG).show();
			}
			
		});
		
		root.addView(showcode);
		
		Button enquete = new Button(this);
		enquete.setText("アンケート(幼稚園、女、嫌儲、アフィブログ)");
		enquete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				MFAApplication app = (MFAApplication) getApplication();
				app.enquete("幼稚園", "女", new String[]{"嫌儲", "アフィブログ"});
			}
			
		});
		
		root.addView(enquete);
		
		Button showenq = new Button(this);
		showenq.setText("ネットワークエラー未投票アンケート");
		showenq.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				MFAApplication app = (MFAApplication) getApplication();
				Toast.makeText(DebugActivity.this, app.getNotYetEnquete(), Toast.LENGTH_LONG).show();
			}
			
		});
		
		root.addView(showenq);
	}

}
