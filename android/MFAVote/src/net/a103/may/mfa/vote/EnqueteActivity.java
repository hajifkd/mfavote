package net.a103.may.mfa.vote;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;

public class EnqueteActivity extends AbstractActivity {

	private Spinner age;
	private RadioButton male;
	private RadioButton female;
	private int[] checkBoxIds = { R.id.where1, R.id.where2, R.id.where3,
			R.id.where4, R.id.where5, R.id.where6, R.id.where7, R.id.where8,
			R.id.where9, };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.enquete);

		age = (Spinner) findViewById(R.id.age);
		male = (RadioButton) findViewById(R.id.male);
		female = (RadioButton) findViewById(R.id.female);

		age.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				validate();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}

		});
		
		for(int id : checkBoxIds) {
			CheckBox cb = (CheckBox) findViewById(id);
			cb.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					validate();
				}
				
			});
		}
	}
	
	private boolean isChecked() {
		for(int id : checkBoxIds) {
			if(((CheckBox) findViewById(id)).isChecked())
				return true;
		}
		
		return false;
	}
	
	private void validate() {
		View v = findViewById(R.id.send_button);
		if(isChecked() && age.getSelectedItemPosition() != 0) {
			v.setEnabled(true);
		}else {
			v.setEnabled(false);
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode != KeyEvent.KEYCODE_BACK) {
			return super.onKeyDown(keyCode, event);
		} else {
			return false;
		}
	}

	public void send(View v) {
		String gender = male.isChecked() ? "男性" : "女性";
		String ages = age.getSelectedItem().toString();
		List<String> list = new ArrayList<String>();
		
		for(int id : checkBoxIds) {
			CheckBox cb = (CheckBox) findViewById(id);
			if(cb.isChecked()) {
				list.add(cb.getText().toString());
			}
		}
		
		String[] where = list.toArray(new String[list.size()]);
		
		MFAApplication app = (MFAApplication) getApplicationContext();
		
		app.enquete(ages, gender, where);
		
		Intent intent = new Intent(this, CompletedActivity.class);
		startActivity(intent);
		finish();
	}
}
