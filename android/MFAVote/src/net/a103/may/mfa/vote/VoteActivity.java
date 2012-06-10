package net.a103.may.mfa.vote;

import java.util.ArrayList;
import java.util.List;

import net.a103.may.mfa.vote.model.Kikaku;
import net.a103.may.mfa.vote.model.Kikaku.Filter;
import net.a103.may.mfa.vote.model.KikakuGroup;
import net.a103.may.mfa.vote.model.Kind;
import net.a103.may.mfa.vote.model.Place;
import net.a103.may.mfa.vote.view.KikakuGroupView;
import net.a103.may.mfa.vote.view.KikakuViewOnClickListener;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class VoteActivity extends AbstractActivity {

	private abstract class AddViewTask extends
			AsyncTask<Void, Void, KikakuGroupView[]> {
				
		private Runnable callback;
				
		public AddViewTask() {
			callback = null;
		}
		
		@SuppressWarnings("unused")
		public AddViewTask(Runnable callback) {
			this.callback = callback;
		}

		abstract protected KikakuGroup[] getGroups();

		protected KikakuGroupView[] doInBackground(Void... params) {
			KikakuGroup[] groups = getGroups();
			List<KikakuGroupView> glist = new ArrayList<KikakuGroupView>();
			for (KikakuGroup group : groups) {
				if (group == null || group.getSize() == 0)
					continue;
				glist.add(new KikakuGroupView(VoteActivity.this, group,
						new KikakuViewOnClickListener() {
							@Override
							public void onClick(Kikaku kikaku) {
								voteConfirm(kikaku);
							}
						}));
			}

			return glist.toArray(new KikakuGroupView[glist.size()]);
		}

		@Override
		protected void onPostExecute(KikakuGroupView[] views) {
			groups = views;
			kikakuList.removeAllViews();
			
			if(callback != null) {
				callback.run();
			}
			
			for (KikakuGroupView view : views) {
				kikakuList.addView(view);
			}

			final Handler handler = new Handler();
			final Runnable func = new Runnable() {
				@Override
				public void run() {
					removeDialogIfNeeded(PROGRESS_DIALOG);
				}
			};

			new Thread(new Runnable() {
				@Override
				public void run() {
					try { 
						// timeout
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					handler.post(func);
				}
			}).start();
		}

		@Override
		protected void onPreExecute() {
			showProgressDialog("ロード中...");
		}
	}

	private LinearLayout kikakuList;
	private Filter filter = null;
	private Place filterPlace = null;
	private Kind filterKind = null;
	private Kikaku[] votedKikaku = new Kikaku[3];
	//private boolean firstTime = true;
	private int[] kikakuLabels = new int[] { R.id.kikaku1, R.id.kikaku2,
			R.id.kikaku3 };
	private int[] kikakuButtons = new int[] { R.id.kikaku_button1,
			R.id.kikaku_button2, R.id.kikaku_button3 };
	private int[] initialLabels = new int[] { R.id.label_a, R.id.label_k,
			R.id.label_s, R.id.label_t, R.id.label_n, R.id.label_h, R.id.label_m, R.id.label_y,
			R.id.label_r, R.id.label_w, };
	private String[] initials = new String[] {
			"あ", "か", "さ", "た", "な", "は", "ま", "や", "ら", "わ"
	};
	private KikakuGroupView[] groups;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kikaku_list);
		kikakuList = (LinearLayout) findViewById(R.id.kikaku_list);

		final Spinner sortBy = (Spinner) findViewById(R.id.sort_by);
		ArrayAdapter<String> sortByAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, new String[] { //"ID順",
						"企画名五十音順", "団体名五十音順" });
		sortByAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sortBy.setAdapter(sortByAdapter);
		sortBy.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int index, long arg3) {
				sortKikaku(index);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		Spinner kind = (Spinner) findViewById(R.id.kind);
		kind.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int index, long arg3) {
				switch (index) {
				case 0:
					filterKind = null;
					break;
				case 1:
					filterKind = Kind.MOGI;
					break;
				case 2:
					filterKind = Kind.CULTURE;
					break;
				case 3:
					filterKind = Kind.MUSIC;
					break;
				}

				makeFilter();
				sortKikaku(sortBy.getSelectedItemPosition());
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		Spinner place = (Spinner) findViewById(R.id.place);
		final Place[] places = Place.values();
		String[] values = new String[places.length + 1];
		values[0] = "指定なし";
		for (int i = 0; i < places.length; i++) {
			values[i + 1] = places[i].getName();
		}
		ArrayAdapter<String> placeAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, values);
		placeAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		place.setAdapter(placeAdapter);
		place.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int index, long arg3) {
				if (index == 0) {
					filterPlace = null;
				} else {
					filterPlace = places[index - 1];
				}

				makeFilter();
				sortKikaku(sortBy.getSelectedItemPosition());
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		for (int i = 0; i < kikakuButtons.length; i++) {
			final int index = i;
			findViewById(kikakuButtons[i]).setOnClickListener(
					new OnClickListener() {
						@Override
						public void onClick(View v) {
							if (votedKikaku[index] != null) {
								votedKikaku[index] = null;
								refreshKikaku();
							}
						}
					});
		}
		
		for (int i = 0; i < initialLabels.length; i++) {
			int labelId = initialLabels[i];
			TextView label = (TextView) findViewById(labelId);
			final String initial = initials[i];
			label.setClickable(true);
			label.setText(initial);
			label.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					for(KikakuGroupView kv : groups) {
						if(kv.getTitle().startsWith(initial)) {
							ScrollView scrollArea = (ScrollView) findViewById(R.id.scroll_area);
							scrollArea.scrollTo(0, kv.getTop());
							return;
						}
					}
					
					Toast.makeText(VoteActivity.this, "該当企画はありません。", Toast.LENGTH_SHORT).show();
				}
				
			});
		}

		refreshKikaku();
		sortBy.setSelection(0);
		
		/*if(firstTime) {
			Intent intent = new Intent(this, DescriptionActivity.class);
			startActivity(intent);
			firstTime = false;
		}*/
	}

	private void sortKikaku(int index) {		
		switch (index) {
		/*case 0:
			new AddViewTask() {
				@Override
				protected KikakuGroup[] getGroups() {
					return Kikaku.groupById(filter);
				}
			}.execute();
			break;*/
		case 0:
			new AddViewTask() {
				@Override
				protected KikakuGroup[] getGroups() {
					return Kikaku.groupByKikakuName(filter);
				}
			}.execute();
			break;
		case 1:
			new AddViewTask() {
				@Override
				protected KikakuGroup[] getGroups() {
					return Kikaku.groupByOrgName(filter);
				}
			}.execute();
			break;
		}
	}

	private void makeFilter() {
		if (filterPlace == null && filterKind == null) {
			filter = null;
		} else if (filterPlace == null) {
			filter = new Filter() {
				@Override
				public boolean filter(Kikaku kikaku) {
					return kikaku.getKind() == filterKind;
				}
			};
		} else if (filterKind == null) {
			filter = new Filter() {
				@Override
				public boolean filter(Kikaku kikaku) {
					return kikaku.getPlace() == filterPlace;
				}
			};
		} else {
			filter = new Filter() {
				@Override
				public boolean filter(Kikaku kikaku) {
					return kikaku.getKind() == filterKind
							&& kikaku.getPlace() == filterPlace;
				}
			};
		}
	}

	private void voteConfirm(final Kikaku k) {
		if (checkFull()) {
			Toast.makeText(this, "すでに三企画選んでいます。これ以上は選べません。", Toast.LENGTH_SHORT)
					.show();
			return;
		}

		if (isSelected(k)) {
			Toast.makeText(this, "同じ企画は二度選べません。", Toast.LENGTH_SHORT).show();
			return;
		}

		AlertDialog.Builder alert = new AlertDialog.Builder(this);
		alert.setMessage(k.getKikakuName() + "に投票しますか？");

		DialogInterface.OnClickListener vote = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				if (checkFull()) {
					Toast.makeText(VoteActivity.this,
							"すでに三企画選んでいます。これ以上は選べません。", Toast.LENGTH_SHORT)
							.show();
					return;
				}

				if (isSelected(k)) {
					Toast.makeText(VoteActivity.this, "同じ企画は二度選べません。",
							Toast.LENGTH_SHORT).show();
					return;
				}

				vote(k);
			}
		};

		DialogInterface.OnClickListener cancel = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// do nothing
			}
		};

		alert.setPositiveButton("はい", vote);
		alert.setNegativeButton("いいえ", cancel);
		alert.setCancelable(true);
		alert.show();
	}

	private boolean isSelected(Kikaku k) {
		for (Kikaku v : votedKikaku) {
			if (v != null && v.getKikakuId() == k.getKikakuId())
				return true;
		}

		return false;
	}

	private boolean checkFull() {
		for (Kikaku v : votedKikaku) {
			if (v == null)
				return false;
		}

		return true;
	}

	private boolean checkEmpty() {
		for (Kikaku v : votedKikaku) {
			if (v != null)
				return false;
		}

		return true;
	}

	private void vote(Kikaku k) {
		for (int i = 0; i < votedKikaku.length; i++) {
			if (votedKikaku[i] == null) {
				votedKikaku[i] = k;
				refreshKikaku();
				return;
			}
		}
	}

	private void refreshKikaku() {
		for (int i = 0; i < votedKikaku.length; i++) {
			TextView label = (TextView) findViewById(kikakuLabels[i]);
			Button button = (Button) findViewById(kikakuButtons[i]);
			if (votedKikaku[i] == null) {
				label.setText(getResources().getString(R.string.not_yet));
				button.setEnabled(false);
			} else {
				label.setText(votedKikaku[i].getKikakuName());
				button.setEnabled(true);
			}
		}

		Button sendButton = (Button) findViewById(R.id.send_button);
		sendButton.setEnabled(!checkEmpty());
	}

	public void send(View v) {
		Integer[] ids = {0, 0, 0};
		
		for(int i = 0; i < votedKikaku.length; i++) {
			Kikaku k = votedKikaku[i];
			
			if(k != null) {
				ids[i] = k.getKikakuId();
			}
		}
		
		MFAApplication app = (MFAApplication) getApplicationContext();
		app.vote(ids);
		
		Intent intent = new Intent(this, EnqueteActivity.class);
		startActivity(intent);
		finish();
	}
	
	public void description(View v) {
		Intent intent = new Intent(this, DescriptionActivity.class);
		startActivity(intent);
	}

}
