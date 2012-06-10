package net.a103.may.mfa.vote.model;

public enum Kind {
	MOGI("模擬店・喫茶店部門"), //模擬店・喫茶店部門
	CULTURE("学術・文化・展示部門"), //学術・文化・展示部門
	MUSIC("音楽・パフォーマンス部門"); //音楽・パフォーマンス部門
	
	private String name;
	
	private Kind(String name) {this.name = name;}
	public String getName() {return name;}
}
