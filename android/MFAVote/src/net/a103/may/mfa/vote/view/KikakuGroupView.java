package net.a103.may.mfa.vote.view;

import net.a103.may.mfa.vote.R;
import net.a103.may.mfa.vote.model.Kikaku;
import net.a103.may.mfa.vote.model.KikakuGroup;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class KikakuGroupView extends LinearLayout {
	
	private static final int COL = 3;
	
	private KikakuGroup group;

	public KikakuGroupView(Context context, KikakuGroup group, KikakuViewOnClickListener listener) {
		super(context);
		
		this.group = group;
		
		inflate(context, R.layout.kikaku_group, this);
		
		((TextView) findViewById(R.id.title)).setText(this.group.getTitle());
		
		TableLayout table = (TableLayout) findViewById(R.id.table);
		
		Kikaku[] list = this.group.getKikakuList();
		
		for(int i = 0; i < list.length; i += COL) {
			TableRow row = new TableRow(context);
			
			for(int j = 0; j < COL; j++) {
				int index = i + j;
				if(index >= list.length)
					break;
				KikakuView view = new KikakuView(context, list[index], listener);
				row.addView(view);
			}
			
			table.addView(row);
		}
	}
	
	public String getTitle() {
		return group.getTitle();
	}

}
