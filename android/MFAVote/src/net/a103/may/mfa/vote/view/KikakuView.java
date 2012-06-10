package net.a103.may.mfa.vote.view;

import net.a103.may.mfa.vote.R;
import net.a103.may.mfa.vote.model.Kikaku;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class KikakuView extends LinearLayout {
	
	
	private Kikaku kikaku;
	private KikakuViewOnClickListener listener;

	public KikakuView(Context context, Kikaku kikaku, KikakuViewOnClickListener listener) {
		super(context);
		this.kikaku = kikaku;
		this.listener = listener;
		
		//inflate view
		inflate(context, R.layout.item, this);
		
		//initialize views
		//((TextView) findViewById(R.id.id)).setText("ID:" + this.kikaku.getKikakuId());
		((TextView) findViewById(R.id.kikaku_name)).setText(this.kikaku.getKikakuName());
		((TextView) findViewById(R.id.org_name)).setText(this.kikaku.getOrgName());
		//((TextView) findViewById(R.id.kind)).setText(this.kikaku.getKind().getName());
		//((TextView) findViewById(R.id.place)).setText(this.kikaku.getPlace().getName());
		
		//register onclicklistener
		findViewById(R.id.root).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				KikakuView.this.listener.onClick(KikakuView.this.kikaku);
			}
		});
	}

}
