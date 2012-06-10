package net.a103.may.mfa.vote;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;

public abstract class AbstractActivity extends Activity {

	protected final static int PROGRESS_DIALOG = 1;

	protected final static String MESSAGE = "msg";
	protected final static String DIM = "dim";
	
	
	private boolean goNext = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        findViewById(android.R.id.content).setSystemUiVisibility(View.STATUS_BAR_HIDDEN);
	}

	protected void showProgressDialog(String message) {
		showProgressDialog(message, false);
	}
	
	protected void showProgressDialog(String message, boolean dim) {
		Bundle args = new Bundle();
		args.putString(MESSAGE, message);
		args.putBoolean(DIM, dim);
		showDialog(PROGRESS_DIALOG, args);
	}

	@Override
	protected void onResume() {
		goNext = false;
		super.onResume();
	}

	@Override
	public void startActivity(Intent intent) {
		goNext = true;
		super.startActivity(intent);
	}

	@Override
	protected void onPause() {
		if(!goNext) {
			System.out.println("illegal pause");
		}else {
			System.out.println("valid pause");
		}
		super.onPause();
	}

	@Override
	protected Dialog onCreateDialog(int id, Bundle args) {
		if (id == PROGRESS_DIALOG) {
			ProgressDialog dialog = new ProgressDialog(this);
			dialog.setMessage(args.getString(MESSAGE));
			dialog.setCancelable(false);
			
			if(args.getBoolean(DIM)) {
				dialog.getWindow().setFlags(0 ,WindowManager.LayoutParams.FLAG_DIM_BEHIND); 
			}

			return dialog;
		}

		return super.onCreateDialog(id, args);
	}
	
	@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK){
			finish();
		}	
		
		return super.onKeyDown(keyCode, event);
	}

	protected void removeDialogIfNeeded(int id) {
		try {
			removeDialog(id);
		} catch (IllegalStateException e) {
			// Ignore
		}
	}
}
