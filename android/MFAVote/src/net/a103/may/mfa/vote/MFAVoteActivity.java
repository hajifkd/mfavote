package net.a103.may.mfa.vote;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class MFAVoteActivity extends AbstractActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void cellphoneInput(View v) {
    	Intent intent = new Intent(this, CellphoneInputActivity.class);
    	startActivity(intent);
    }
    
    public void voteNow(View v) {
    	Intent intent = new Intent(this, VoteActivity.class);
    	startActivity(intent);
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