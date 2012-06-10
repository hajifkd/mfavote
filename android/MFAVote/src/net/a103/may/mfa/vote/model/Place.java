package net.a103.may.mfa.vote.model;

public enum Place {
	PLACE_1("七徳堂"),
	PLACE_2("三四郎坂"),
	PLACE_3("伊藤国際学術センター"),
	PLACE_4("化学本館前"),
	PLACE_5("医学部前"),
	PLACE_6("医学部各教室"),
	PLACE_7("医学部本館"),
	PLACE_8("合格通り"),
	PLACE_9("図書館前"),
	PLACE_10("図書館前広場"),
	PLACE_11("図書館前広場木下"),
	PLACE_12("学生支援センター"),
	PLACE_13("安田講堂"),
	PLACE_14("安田講堂前ステージ"),
	PLACE_15("安田講堂脇坂道"),
	PLACE_16("工学部11号館"),
	PLACE_17("工学部13号館"),
	PLACE_18("工学部14号館"),
	PLACE_19("工学部1号館"),
	PLACE_20("工学部2号館"),
	PLACE_21("工学部4号館"),
	PLACE_22("工学部5号館"),
	PLACE_23("工学部6号館"),
	PLACE_24("工学部7号館"),
	PLACE_25("工学部8号館"),
	PLACE_26("工学部前"),
	PLACE_27("工学部前広場"),
	PLACE_28("御殿下グラウンド"),
	PLACE_29("教育学部棟"),
	PLACE_30("文学部3号館北東"),
	PLACE_31("文学部3号館南西"),
	PLACE_32("正赤通り"),
	PLACE_33("正門前"),
	PLACE_34("法文1号館アーケード下"),
	PLACE_35("法文1号館（東）"),
	PLACE_36("法文1号館（西）"),
	PLACE_37("法文2号館"),
	PLACE_38("法文横丁"),
	PLACE_39("理1号館下,三四郎池脇(雨天時中止)"),
	PLACE_40("理学部1号館"),
	PLACE_41("理学部4号館"),
	PLACE_42("理学部化学本館"),
	PLACE_43("生協第二食堂"),
	PLACE_44("育徳堂"),
	PLACE_45("薬学部棟"),
	PLACE_46("赤門前特殊ブロック"),
	PLACE_47("赤門総合研究棟"),
	PLACE_48("赤門総合研究棟東"),
	PLACE_49("赤門通り"),
	PLACE_50("農学部"),
	PLACE_51("農学部1号館"),
	PLACE_52("農学部2号館"),
	PLACE_53("農学部3号館"),
	PLACE_54("農学部グラウンド"),
	PLACE_55("農学部ステージ"),
	PLACE_56("農学部特殊ブロック"),
	PLACE_57("銀杏並木");
	
	private String name;
	
	private Place(String name) {this.name = name;}
	public String getName() {return name;}
}