package net.a103.may.mfa.vote;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

public class DescriptionActivity extends Activity {
	
	private Timer timer;
	private Handler handler;
	private int index = 0;
	private final int[][] ids = new int[][] {
			new int[] {
					R.id.select_kikaku, R.id.select_kikaku_arrow
			},
			new int[] {
					R.id.filter, R.id.filter_arrow,
					R.id.view_kikaku, R.id.view_kikaku_arrow,
					R.id.initial, R.id.initial_arrow
					
			},
			new int[] {
					R.id.vote_kikaku, R.id.vote_kikaku_arrow,
					R.id.sort, R.id.sort_arrow
			},
			new int[] {
					R.id.desc_again, R.id.desc_again_arrow
			},
	};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND, 
        //		WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        findViewById(android.R.id.content).setSystemUiVisibility(View.STATUS_BAR_HIDDEN);
        handler = new Handler();
        //setTimer();
        transition();
    }
    
    public void next(View v) {
    	transition();
    }
    
    private void setTimer() {
    	if(timer != null) {
    		return;
    	}
    	timer = new Timer();
    	TimerTask task = new TimerTask(){
			@Override
			public void run() {
				transition();
			}
    	};
    	timer.schedule(task, 0, 2000);
    }
    
    private void transition() {
    	
    	System.out.println(index);
    	
    	if(index == ids.length - 1) {
    		((Button) findViewById(R.id.next_button)).setText(R.string.close);
    	}
    	
    	if(index == ids.length) {
    		//show all descriptions
    		if(timer != null) {
    			timer.cancel();
    		}
    		
    		handler.post(new Runnable(){
    			public void run() {
    				finish();
    			}
    		});
    		return;
    	}
    	
    	if(index != 0) {
    		//hide previous descriptions
    		int prevIndex = index - 1;
    		int[] fadeOutIds = ids[prevIndex];
    		for(int id : fadeOutIds) {
    			final int f_id = id;
    			handler.post(new Runnable(){
        			public void run() {
        				//Animation fadeOut = AnimationUtils.loadAnimation(DescriptionActivity.this, R.anim.fadeout);
            			//findViewById(f_id).startAnimation(fadeOut);
        				findViewById(f_id).setAlpha(0);
        			}
        		});
    		}
    	}
    	
    	//show descriptions
    	int[] fadeInIds = ids[index];
    	for(int id : fadeInIds) {
    		final int f_id = id;
    		handler.post(new Runnable(){
    			public void run() {
    				findViewById(f_id).setAlpha(1);
    				//Animation fadeIn = AnimationUtils.loadAnimation(DescriptionActivity.this, R.anim.fadein);
    				//findViewById(f_id).startAnimation(fadeIn);
    			}
    		});
    	}
    	
    	index++;
    	
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
