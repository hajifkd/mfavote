package net.a103.may.mfa.vote.model;

import java.util.ArrayList;
import java.util.List;

public class KikakuGroup {
	
	private Kikaku[] kikakuList;
	private String title;
	
	public KikakuGroup(String title, Kikaku[] kikakuList) {
		
		List<Kikaku> list = new ArrayList<Kikaku>();
		
		addloop:
		for(Kikaku k : kikakuList) {
			for(Kikaku t : list) {
				if(k.getKikakuId() == t.getKikakuId()){
					continue addloop;
				}
			}
			
			list.add(k);
		}
		
		this.kikakuList = list.toArray(new Kikaku[list.size()]);
		this.title = title;
	}

	public Kikaku[] getKikakuList() {
		return kikakuList.clone();
	}

	public String getTitle() {
		return title;
	}
	
	public int getSize() {
		return kikakuList.length;
	}

}
