package net.a103.may.mfa.vote;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;

public class CompletedActivity extends AbstractActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.completed);
		
		final Handler handler = new Handler();
		final Runnable func = new Runnable() {
			@Override
			public void run() {
				finish();
			}
		};

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// timeout
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				handler.post(func);
			}
		}).start();
	}
	
	@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode != KeyEvent.KEYCODE_BACK){
			return super.onKeyDown(keyCode, event);
		}else{
			return false;
		}	
	}
}
