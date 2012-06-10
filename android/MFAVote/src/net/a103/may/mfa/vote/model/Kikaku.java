package net.a103.may.mfa.vote.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Kikaku {
	
	public interface Filter{
		public boolean filter(Kikaku kikaku);
	}
	
	private static Comparator<Kikaku> SORT_BY_ID = new Comparator<Kikaku>() {
		@Override
		public int compare(Kikaku lhs, Kikaku rhs) {
			return lhs.kikakuId - rhs.kikakuId;
		}		
	};
	
	private static Comparator<Kikaku> SORT_BY_KIKAKU_NAME = new Comparator<Kikaku>() {
		@Override
		public int compare(Kikaku lhs, Kikaku rhs) {
			return lhs.phoneticKinakuName.compareTo(rhs.phoneticKinakuName);
		}		
	};
	
	private static Comparator<Kikaku> SORT_BY_ORG_NAME = new Comparator<Kikaku>() {
		@Override
		public int compare(Kikaku lhs, Kikaku rhs) {
			return lhs.phoneticOrgName.compareTo(rhs.phoneticOrgName);
		}		
	};
	
	private static Kikaku[] KIKAKU_LIST = new Kikaku[] {
		new Kikaku(301,Place.PLACE_7,Kind.MUSIC,"鉄門ピアノの会五月祭演奏会","鉄門ピアノの会","てつもんぴあののかいごがつさいえんそうかい","てつもんぴあののかい"),
		new Kikaku(302,Place.PLACE_17,Kind.CULTURE,"近未来体験企画","EEIC（工学部電気電子情報系）","きんみらいたいけんきかく","こうがくぶでんきでんしじょうほうけい"),
		new Kikaku(302,Place.PLACE_20,Kind.CULTURE,"近未来体験企画","EEIC（工学部電気電子情報系）","きんみらいたいけんきかく","こうがくぶでんきでんしじょうほうけい"),
		new Kikaku(302,Place.PLACE_20,Kind.CULTURE,"近未来体験企画","EEIC（工学部電気電子情報系）","きんみらいたいけんきかく","こうがくぶでんきでんしじょうほうけい"),
		new Kikaku(303,Place.PLACE_49,Kind.MOGI,"オレペのチュロス","オレンジペコテニスサークル","おれぺのちゅろす","おれんじぺこてにすさーくる"),
		new Kikaku(304,Place.PLACE_29,Kind.CULTURE,"教育系学部の大学生に関する実態調査","教育学部比較教育社会学コース","きょういくけいがくぶのだいがくせいにかんするじったいちょうさ","きょういくがくぶひかくきょういくしゃかいがくこーす"),
		new Kikaku(304,Place.PLACE_29,Kind.CULTURE,"教育系学部の大学生に関する実態調査","教育学部比較教育社会学コース","きょういくけいがくぶのだいがくせいにかんするじったいちょうさ","きょういくがくぶひかくきょういくしゃかいがくこーす"),
		new Kikaku(305,Place.PLACE_10,Kind.CULTURE,"民族舞踊デモンストレーション","東京大学・お茶の水女子大学民族舞踊研究会","みんぞくぶようでもんすとれーしょん","とうきょうだいがくおちゃのみずじょしだいがくみんぞくぶようけんきゅうかい"),
		new Kikaku(305,Place.PLACE_10,Kind.CULTURE,"民族舞踊デモンストレーション","東京大学・お茶の水女子大学民族舞踊研究会","みんぞくぶようでもんすとれーしょん","とうきょうだいがくおちゃのみずじょしだいがくみんぞくぶようけんきゅうかい"),
		new Kikaku(305,Place.PLACE_10,Kind.CULTURE,"民族舞踊デモンストレーション","東京大学・お茶の水女子大学民族舞踊研究会","みんぞくぶようでもんすとれーしょん","とうきょうだいがくおちゃのみずじょしだいがくみんぞくぶようけんきゅうかい"),
		new Kikaku(305,Place.PLACE_10,Kind.CULTURE,"民族舞踊デモンストレーション","東京大学・お茶の水女子大学民族舞踊研究会","みんぞくぶようでもんすとれーしょん","とうきょうだいがくおちゃのみずじょしだいがくみんぞくぶようけんきゅうかい"),
		new Kikaku(305,Place.PLACE_25,Kind.CULTURE,"民族舞踊デモンストレーション","東京大学・お茶の水女子大学民族舞踊研究会","みんぞくぶようでもんすとれーしょん","とうきょうだいがくおちゃのみずじょしだいがくみんぞくぶようけんきゅうかい"),
		new Kikaku(305,Place.PLACE_27,Kind.CULTURE,"民族舞踊デモンストレーション","東京大学・お茶の水女子大学民族舞踊研究会","みんぞくぶようでもんすとれーしょん","とうきょうだいがくおちゃのみずじょしだいがくみんぞくぶようけんきゅうかい"),
		new Kikaku(305,Place.PLACE_27,Kind.CULTURE,"民族舞踊デモンストレーション","東京大学・お茶の水女子大学民族舞踊研究会","みんぞくぶようでもんすとれーしょん","とうきょうだいがくおちゃのみずじょしだいがくみんぞくぶようけんきゅうかい"),
		new Kikaku(306,Place.PLACE_47,Kind.MUSIC,"東京大学箏曲研究会五月祭演奏会","筝曲研究会","とうきょうだいがくそうきょくけんきゅうかいごがつさいえんそうかい","そうきょくけんきゅうかい"),
		new Kikaku(306,Place.PLACE_47,Kind.MUSIC,"東京大学箏曲研究会五月祭演奏会","筝曲研究会","とうきょうだいがくそうきょくけんきゅうかいごがつさいえんそうかい","そうきょくけんきゅうかい"),
		new Kikaku(307,Place.PLACE_8,Kind.MOGI,"愛知の味噌串カツ","愛知学生会館","あいちのみそくしかつ","あいちがくせいかいかん"),
		new Kikaku(308,Place.PLACE_28,Kind.MUSIC,"ラクロス部・五月祭試合","ラクロス部","らくろすぶ・ごがつさいしあい","らくろすぶ"),
		new Kikaku(309,Place.PLACE_25,Kind.CULTURE,"自作プラネ、はじめました。","PLANETARIAN","じさくぷらね、はじめました。","ぷらねたりあん"),
		new Kikaku(310,Place.PLACE_19,Kind.CULTURE,"クイズ本郷アカデミー2012","クイズ研究会","くいずほんごうあかでみーにせんじゅうに","くいずけんきゅうかい"),
		new Kikaku(311,Place.PLACE_26,Kind.MOGI,"アナザーウェイ","アナザーウェイ","あなざーうぇい","あなざーうぇい"),
		new Kikaku(312,Place.PLACE_13,Kind.MUSIC,"ブラアカ五月祭演奏会","ブラスアカデミー","ぶらあかごがつさいえんそうかい","ぶらすあかでみー"),
		new Kikaku(312,Place.PLACE_13,Kind.MUSIC,"ブラアカ五月祭演奏会","ブラスアカデミー","ぶらあかごがつさいえんそうかい","ぶらすあかでみー"),
		new Kikaku(313,Place.PLACE_57,Kind.MOGI,"テク飯","TECKTECK","てくめし","てくてく"),
		new Kikaku(314,Place.PLACE_13,Kind.MUSIC,"第64回模擬裁判「MIST-真相心裏-」","法律相談所","だいろくじゅうよんかいもぎさいばん「みすと―しんそうしんり」","ほうりつそうだんじょ"),
		new Kikaku(314,Place.PLACE_13,Kind.MUSIC,"第64回模擬裁判「MIST-真相心裏-」","法律相談所","だいろくじゅうよんかいもぎさいばん「みすと―しんそうしんり」","ほうりつそうだんじょ"),
		new Kikaku(314,Place.PLACE_13,Kind.MUSIC,"第64回模擬裁判「MIST-真相心裏-」","法律相談所","だいろくじゅうよんかいもぎさいばん「みすと―しんそうしんり」","ほうりつそうだんじょ"),
		new Kikaku(314,Place.PLACE_13,Kind.MUSIC,"第64回模擬裁判「MIST-真相心裏-」","法律相談所","だいろくじゅうよんかいもぎさいばん「みすと―しんそうしんり」","ほうりつそうだんじょ"),
		new Kikaku(314,Place.PLACE_35,Kind.MUSIC,"第64回模擬裁判「MIST-真相心裏-」","法律相談所","だいろくじゅうよんかいもぎさいばん「みすと―しんそうしんり」","ほうりつそうだんじょ"),
		new Kikaku(315,Place.PLACE_8,Kind.MOGI,"アムレのお店","アムレット","あむれのおみせ","あむれっと"),
		new Kikaku(316,Place.PLACE_16,Kind.CULTURE,"なるほど実感！サイエンスミュージアム＠本郷","サイエンスコミュニケーションサークル　CAST","なるほどじっかん！さいえんすみゅーじあむあっとほんごう","さいえんすこみゅにけーしょんさーくる　きゃすと"),
		new Kikaku(317,Place.PLACE_27,Kind.MUSIC,"書道パフォーマンス","書道研究会","しょどうぱふぉーまんす","しょどうけんきゅうかい"),
		new Kikaku(317,Place.PLACE_27,Kind.MUSIC,"書道パフォーマンス","書道研究会","しょどうぱふぉーまんす","しょどうけんきゅうかい"),
		new Kikaku(318,Place.PLACE_36,Kind.MOGI,"生演奏ジャズ喫茶 Keystone Corner","ジャズ研究会","なまえんそうじゃずきっさ きーすとーんこーなー","じゃずけんきゅうかい"),
		new Kikaku(318,Place.PLACE_36,Kind.MOGI,"生演奏ジャズ喫茶 Keystone Corner","ジャズ研究会","なまえんそうじゃずきっさ きーすとーんこーなー","じゃずけんきゅうかい"),
		new Kikaku(319,Place.PLACE_36,Kind.MUSIC,"HONGO 　SALOON","現代舞踊音楽研究会","ほんごうさろーん","げんだいぶようおんがくけんきゅうかい"),
		new Kikaku(320,Place.PLACE_1,Kind.MUSIC,"運動会合気道部五月祭演武会","合気道部","うんどうかいあいきどうぶごがつさいえんぶかい","あいきどうぶ"),
		new Kikaku(321,Place.PLACE_40,Kind.CULTURE,"明日使える地学知識","理学部地球惑星環境学科","あしたつかえるむだじゃないちしき","りがくぶちきゅうわくせいかんきょうがっか"),
		new Kikaku(322,Place.PLACE_45,Kind.CULTURE,"クスリと生きる","薬学部３年生","くすりといきる","やくがくぶさんねんせい"),
		new Kikaku(323,Place.PLACE_5,Kind.CULTURE,"にがおえや","美術サークル","にがおえや","びじゅつさーくる"),
		new Kikaku(324,Place.PLACE_32,Kind.CULTURE,"似顔絵屋","まんがくらぶ","にがおえや","まんがくらぶ"),
		new Kikaku(325,Place.PLACE_25,Kind.MUSIC,"五月寄席","落語研究会","ごがつよせ","らくごけんきゅうかい"),
		new Kikaku(325,Place.PLACE_25,Kind.MUSIC,"五月寄席","落語研究会","ごがつよせ","らくごけんきゅうかい"),
		new Kikaku(326,Place.PLACE_12,Kind.MUSIC,"NSR from 新潟","自転車部旅行班","えぬえすあーるふろーむにいがた","じてんしゃぶりょこうはん"),
		new Kikaku(326,Place.PLACE_33,Kind.MUSIC,"NSR from 新潟","自転車部旅行班","えぬえすあーるふろーむにいがた","じてんしゃぶりょこうはん"),
		new Kikaku(327,Place.PLACE_37,Kind.CULTURE,"東大LEGO部五月祭展示","LEGO部","とうだいれごぶごがつさいてんじ","れごぶ"),
		new Kikaku(328,Place.PLACE_47,Kind.MUSIC,"The Beatles LIVE!!","アビーロード","ざびーとるずらいぶ","あびーろーど"),
		new Kikaku(328,Place.PLACE_47,Kind.MUSIC,"The Beatles LIVE!!","アビーロード","ざびーとるずらいぶ","あびーろーど"),
		new Kikaku(329,Place.PLACE_14,Kind.MUSIC,"maguro","maguro","まぐろ","まぐろ"),
		new Kikaku(329,Place.PLACE_35,Kind.MUSIC,"maguro","maguro","まぐろ","まぐろ"),
		new Kikaku(330,Place.PLACE_26,Kind.MOGI,"SOTO INDONESIA","在日インドネシア留学生協会東京大学支部","そといんどねしあ","ざいにちいんどねしありゅうがくせいきょうかいとうきょうだいがくしぶ"),
		new Kikaku(331,Place.PLACE_21,Kind.MUSIC,"サイエンスミュージアム　オンステージ","サイエンスコミュニケーションサークル　CAST","さいえんすみゅーじあむ　おんすてーじ","さいえんすこみゅにけーしょんさーくる　きゃすと"),
		new Kikaku(331,Place.PLACE_27,Kind.MUSIC,"サイエンスミュージアム　オンステージ","サイエンスコミュニケーションサークル　CAST","さいえんすみゅーじあむ　おんすてーじ","さいえんすこみゅにけーしょんさーくる　きゃすと"),
		new Kikaku(331,Place.PLACE_27,Kind.MUSIC,"サイエンスミュージアム　オンステージ","サイエンスコミュニケーションサークル　CAST","さいえんすみゅーじあむ　おんすてーじ","さいえんすこみゅにけーしょんさーくる　きゃすと"),
		new Kikaku(331,Place.PLACE_27,Kind.MUSIC,"サイエンスミュージアム　オンステージ","サイエンスコミュニケーションサークル　CAST","さいえんすみゅーじあむ　おんすてーじ","さいえんすこみゅにけーしょんさーくる　きゃすと"),
		new Kikaku(331,Place.PLACE_27,Kind.MUSIC,"サイエンスミュージアム　オンステージ","サイエンスコミュニケーションサークル　CAST","さいえんすみゅーじあむ　おんすてーじ","さいえんすこみゅにけーしょんさーくる　きゃすと"),
		new Kikaku(332,Place.PLACE_20,Kind.CULTURE,"2010年代のコンテンツの未来","情報学環教育部自治会","にせんじゅうねんだいのこんてんつのみらい","じょうほうがくかんきょういくぶじちかい"),
		new Kikaku(333,Place.PLACE_13,Kind.MUSIC,"五月祭合唱祭","合唱団連盟","ごがつさいがっしょうさい","がっしょうだんれんめい"),
		new Kikaku(334,Place.PLACE_7,Kind.MUSIC,"鉄門室内楽の会 五月祭演奏会","鉄門室内楽の会","てつもんしつないがくのかいごがつさいえんそうかい","てつもんしつないがくのかい"),
		new Kikaku(335,Place.PLACE_36,Kind.MUSIC,"二分間劇場","二分間劇場","にふんかんげきじょう","にふんかんげきじょう"),
		new Kikaku(336,Place.PLACE_9,Kind.MOGI,"エストのクレープ","エストレーラ","えすとのくれーぷ","えすとれーら"),
		new Kikaku(337,Place.PLACE_36,Kind.CULTURE,"折紙美術館'12 in 本郷","折紙サークルOrist","おりがみびじゅつかんいんほんごう","おりがみさーくるおりすと"),
		new Kikaku(338,Place.PLACE_13,Kind.MUSIC,"フィロムジカ交響楽団五月祭演奏会","フィロムジカ交響楽団","ふぃろむじかこうきょうがくだんごがつさいえんそうかい","ふぃろむじかこうきょうがくだん"),
		new Kikaku(338,Place.PLACE_13,Kind.MUSIC,"フィロムジカ交響楽団五月祭演奏会","フィロムジカ交響楽団","ふぃろむじかこうきょうがくだんごがつさいえんそうかい","ふぃろむじかこうきょうがくだん"),
		new Kikaku(338,Place.PLACE_13,Kind.MUSIC,"フィロムジカ交響楽団五月祭演奏会","フィロムジカ交響楽団","ふぃろむじかこうきょうがくだんごがつさいえんそうかい","ふぃろむじかこうきょうがくだん"),
		new Kikaku(338,Place.PLACE_13,Kind.MUSIC,"フィロムジカ交響楽団五月祭演奏会","フィロムジカ交響楽団","ふぃろむじかこうきょうがくだんごがつさいえんそうかい","ふぃろむじかこうきょうがくだん"),
		new Kikaku(338,Place.PLACE_22,Kind.MUSIC,"フィロムジカ交響楽団五月祭演奏会","フィロムジカ交響楽団","ふぃろむじかこうきょうがくだんごがつさいえんそうかい","ふぃろむじかこうきょうがくだん"),
		new Kikaku(338,Place.PLACE_22,Kind.MUSIC,"フィロムジカ交響楽団五月祭演奏会","フィロムジカ交響楽団","ふぃろむじかこうきょうがくだんごがつさいえんそうかい","ふぃろむじかこうきょうがくだん"),
		new Kikaku(338,Place.PLACE_43,Kind.MUSIC,"フィロムジカ交響楽団五月祭演奏会","フィロムジカ交響楽団","ふぃろむじかこうきょうがくだんごがつさいえんそうかい","ふぃろむじかこうきょうがくだん"),
		new Kikaku(339,Place.PLACE_10,Kind.MUSIC,"マラバリスタ大道芸ステージ","マラバリスタ","まらばりすただいどうげいすてーじ","まらばりすた"),
		new Kikaku(339,Place.PLACE_10,Kind.MUSIC,"マラバリスタ大道芸ステージ","マラバリスタ","まらばりすただいどうげいすてーじ","まらばりすた"),
		new Kikaku(339,Place.PLACE_23,Kind.MUSIC,"マラバリスタ大道芸ステージ","マラバリスタ","まらばりすただいどうげいすてーじ","まらばりすた"),
		new Kikaku(339,Place.PLACE_27,Kind.MUSIC,"マラバリスタ大道芸ステージ","マラバリスタ","まらばりすただいどうげいすてーじ","まらばりすた"),
		new Kikaku(339,Place.PLACE_27,Kind.MUSIC,"マラバリスタ大道芸ステージ","マラバリスタ","まらばりすただいどうげいすてーじ","まらばりすた"),
		new Kikaku(339,Place.PLACE_51,Kind.MUSIC,"マラバリスタ大道芸ステージ","マラバリスタ","まらばりすただいどうげいすてーじ","まらばりすた"),
		new Kikaku(339,Place.PLACE_51,Kind.MUSIC,"マラバリスタ大道芸ステージ","マラバリスタ","まらばりすただいどうげいすてーじ","まらばりすた"),
		new Kikaku(339,Place.PLACE_55,Kind.MUSIC,"マラバリスタ大道芸ステージ","マラバリスタ","まらばりすただいどうげいすてーじ","まらばりすた"),
		new Kikaku(340,Place.PLACE_8,Kind.MOGI,"サンデーのタピオカ","サンデーキッカーズ","さんでーのたぴおか","さんでーきっかーず"),
		new Kikaku(341,Place.PLACE_36,Kind.MUSIC,"テーブルマジックショー","奇術愛好会","てーぶるまじっくしょー","きじゅつあいこうかい"),
		new Kikaku(342,Place.PLACE_32,Kind.MOGI,"赤門焼蕎麦","情報学環教育部自治会","あかもんやきそば","じょうほうがっかんきょういくぶじちかい"),
		new Kikaku(344,Place.PLACE_9,Kind.MOGI,"COSMOS","COSMOS","こすもす","こすもす"),
		new Kikaku(345,Place.PLACE_23,Kind.MUSIC,"ラテンアメリカ音楽演奏","Estudiantina Komaba","らてんあめりかおんがくえんそう","えすとぅでぃあんてぃーなこまば"),
		new Kikaku(345,Place.PLACE_23,Kind.MUSIC,"ラテンアメリカ音楽演奏","Estudiantina Komaba","らてんあめりかおんがくえんそう","えすとぅでぃあんてぃーなこまば"),
		new Kikaku(347,Place.PLACE_23,Kind.CULTURE,"工学博覧会","工学部応用物理系学科","こうがくはくらんかい","こうがくぶおうようぶつりけいがっか"),
		new Kikaku(348,Place.PLACE_8,Kind.CULTURE,"鉄門水泳部の性格診断☆","鉄門水泳部","てつもんすいえいぶのせいかくしんだん","てつもんすいえいぶ"),
		new Kikaku(349,Place.PLACE_23,Kind.CULTURE,"NGOネットUT講演会","NGOネットUT","えぬじーおーねっとゆーてぃーこうえんかい","えぬじーおーねっとゆーてぃー"),
		new Kikaku(350,Place.PLACE_24,Kind.CULTURE,"人の力で空を飛ぶ！","人力飛行機サークル　F-tec","ひとのちからでそらをとぶ！","じんりきひこうきさーくる　えふてっく"),
		new Kikaku(351,Place.PLACE_13,Kind.MUSIC,"東京大学吹奏楽部五月祭演奏会","吹奏楽部","とうきょうだいがくすいそうがくぶごがつさいえんそうかい","すいそうがくぶ"),
		new Kikaku(351,Place.PLACE_13,Kind.MUSIC,"東京大学吹奏楽部五月祭演奏会","吹奏楽部","とうきょうだいがくすいそうがくぶごがつさいえんそうかい","すいそうがくぶ"),
		new Kikaku(351,Place.PLACE_22,Kind.MUSIC,"東京大学吹奏楽部五月祭演奏会","吹奏楽部","とうきょうだいがくすいそうがくぶごがつさいえんそうかい","すいそうがくぶ"),
		new Kikaku(351,Place.PLACE_22,Kind.MUSIC,"東京大学吹奏楽部五月祭演奏会","吹奏楽部","とうきょうだいがくすいそうがくぶごがつさいえんそうかい","すいそうがくぶ"),
		new Kikaku(351,Place.PLACE_43,Kind.MUSIC,"東京大学吹奏楽部五月祭演奏会","吹奏楽部","とうきょうだいがくすいそうがくぶごがつさいえんそうかい","すいそうがくぶ"),
		new Kikaku(351,Place.PLACE_43,Kind.MUSIC,"東京大学吹奏楽部五月祭演奏会","吹奏楽部","とうきょうだいがくすいそうがくぶごがつさいえんそうかい","すいそうがくぶ"),
		new Kikaku(351,Place.PLACE_43,Kind.MUSIC,"東京大学吹奏楽部五月祭演奏会","吹奏楽部","とうきょうだいがくすいそうがくぶごがつさいえんそうかい","すいそうがくぶ"),
		new Kikaku(351,Place.PLACE_43,Kind.MUSIC,"東京大学吹奏楽部五月祭演奏会","吹奏楽部","とうきょうだいがくすいそうがくぶごがつさいえんそうかい","すいそうがくぶ"),
		new Kikaku(351,Place.PLACE_43,Kind.MUSIC,"東京大学吹奏楽部五月祭演奏会","吹奏楽部","とうきょうだいがくすいそうがくぶごがつさいえんそうかい","すいそうがくぶ"),
		new Kikaku(352,Place.PLACE_35,Kind.CULTURE,"五月祭書道展","書道研究会","ごがつさいしょどうてん","しょどうけんきゅうかい"),
		new Kikaku(353,Place.PLACE_14,Kind.MUSIC,"下駄×TAP＝下駄っぱーず","早稲田大学下駄っぱーず","げたかけるたっぷいこーるげたっぱーず","わせだだいがくげたっぱーず"),
		new Kikaku(353,Place.PLACE_22,Kind.MUSIC,"下駄×TAP＝下駄っぱーず","早稲田大学下駄っぱーず","げたかけるたっぷいこーるげたっぱーず","わせだだいがくげたっぱーず"),
		new Kikaku(354,Place.PLACE_26,Kind.MOGI,"はっしーの牛くし","スポーツ愛好会サッカーパート","はっしーのぎゅうくし","すぽーつあいこうかいさっかーぱーと"),
		new Kikaku(355,Place.PLACE_35,Kind.CULTURE,"中澤工講演会","新月お茶の会","なかざわたくみこうえんかい","しんげつおちゃのかい"),
		new Kikaku(355,Place.PLACE_35,Kind.CULTURE,"中澤工講演会","新月お茶の会","なかざわたくみこうえんかい","しんげつおちゃのかい"),
		new Kikaku(355,Place.PLACE_35,Kind.CULTURE,"中澤工講演会","新月お茶の会","なかざわたくみこうえんかい","しんげつおちゃのかい"),
		new Kikaku(356,Place.PLACE_49,Kind.MOGI,"ベルタコス","ベルスターズ","べるたこす","べるすたーず"),
		new Kikaku(357,Place.PLACE_31,Kind.CULTURE,"FM楓庵","放送研究会","えふえむかえであん","ほうそうけんきゅうかい"),
		new Kikaku(358,Place.PLACE_4,Kind.MOGI,"りばけビール園","理学部化学科","りばけびーるえん","りがくぶかがくか"),
		new Kikaku(359,Place.PLACE_14,Kind.MUSIC,"みすたーちるどれん","おーじ","みすたーちるどれん","おーじ"),
		new Kikaku(360,Place.PLACE_20,Kind.CULTURE,"【ホバリング】空中姿勢制御実験【実際飛ぶ】","工学部丁友会アビオニクス研究会","くうちゅうしせいせいぎょじっけん","こうがくぶていゆうかいあびおにくすけんきゅうかい"),
		new Kikaku(361,Place.PLACE_57,Kind.MOGI,"サンセットのお好み焼き","サンセット","さんせっとのお好み焼き","さんせっと"),
		new Kikaku(362,Place.PLACE_20,Kind.CULTURE,"ゲーム試遊空間","同人サークルノンリニア","げーむしゆうくうかん","どうじんさーくるのんりにあ"),
		new Kikaku(363,Place.PLACE_8,Kind.MOGI,"歌う焼きそば屋Tutti","音楽部合唱団コールアカデミー","うたうやきそばやつっちー","おんがくぶがっしょうだんこーるあかでみー"),
		new Kikaku(364,Place.PLACE_25,Kind.CULTURE,"UT-かてきょ","学生団体UT-かてきょ","ゆーてぃーかてきょ","がくせいだんたいゆーてぃーかてきょ"),
		new Kikaku(365,Place.PLACE_20,Kind.MUSIC,"五月祭マンドリンコンサート","マンドリンクラブ","ごがつさいまんどりんこんさーと","まんどりんくらぶ"),
		new Kikaku(366,Place.PLACE_1,Kind.MUSIC,"五月祭大演武会","少林寺拳法部","ごがつさいだいえんぶかい","しょうりんじけんぽうぶ"),
		new Kikaku(367,Place.PLACE_49,Kind.MOGI,"レスリング部の模擬店","レスリング部","れすりんぐぶのもぎてん","れすりんぐぶ"),
		new Kikaku(368,Place.PLACE_38,Kind.CULTURE,"作品頒布","ジェンダー研究会","さくひんはんぷ","じぇんだーけんきゅうかい"),
		new Kikaku(369,Place.PLACE_2,Kind.MOGI,"たい焼き屋ピンキー","ラクロス部","たいやきやぴんきー","らくろすぶ"),
		new Kikaku(370,Place.PLACE_37,Kind.MUSIC,"ソロギターライブ","Nature spirits","そろぎたーらいぶ","ねいちゃースピリッツ"),
		new Kikaku(371,Place.PLACE_30,Kind.MOGI,"Sound Kitchen あらぐさ","合唱団あらぐさ","さうんどきっちんあらぐさ","がっしょうだんあらぐさ"),
		new Kikaku(372,Place.PLACE_53,Kind.CULTURE,"東大の農力-ラボ紹介と米粉のお店","農学部１類","とうだいののうりょく-らぼしょうかいとこめこのおみせ","のうがくぶいちるい"),
		new Kikaku(372,Place.PLACE_56,Kind.CULTURE,"東大の農力-ラボ紹介と米粉のお店","農学部１類","とうだいののうりょく-らぼしょうかいとこめこのおみせ","のうがくぶいちるい"),
		new Kikaku(373,Place.PLACE_5,Kind.MOGI,"焼く学部","薬学部３年","やくがくぶ","やくがくぶ3ねん"),
		new Kikaku(374,Place.PLACE_14,Kind.MUSIC,"Bon hommage","文京事変","ぼん・おまーじゅ","ぶんきょうじへん"),
		new Kikaku(375,Place.PLACE_36,Kind.MOGI,"恋愛IQカフェ","教育学部教育心理学コース","れんあいあいきゅうかふぇ","きょういくがくぶきょういくしんりがくこーす"),
		new Kikaku(376,Place.PLACE_36,Kind.CULTURE,"ペンシルパズル博物館","ペンシルパズル同好会","ぺんしるぱずるはくぶつかん","ぺんしるぱずるどうこうかい"),
		new Kikaku(377,Place.PLACE_34,Kind.CULTURE,"東大生協古本市","生協本郷学生委員会","とうだいせいきょうふるほんいち","せいきょうほんごうがくせいいいんかい"),
		new Kikaku(378,Place.PLACE_9,Kind.MOGI,"ポップ☆ こまっけろのキャラメルコーン","駒場祭委員会","ぽっぷこまっけろのきゃらめるこーん","こまばさいいいんかい"),
		new Kikaku(379,Place.PLACE_12,Kind.MOGI,"裏千家五月祭茶会","裏千家茶道同好会","うらせんけごがつさいちゃかい","うらせんけさどうどうこうかい"),
		new Kikaku(380,Place.PLACE_40,Kind.CULTURE,"地球と惑星～Dynamicな世界を探る～","理学部地球惑星物理学科","ちきゅうとわくせい～だいなみっくなせかいをさぐる～","りがくぶちきゅうわくせいぶつりがっか"),
		new Kikaku(382,Place.PLACE_38,Kind.MOGI,"ビール屋さん","高専会","びーるやさん","こうせんかい"),
		new Kikaku(383,Place.PLACE_36,Kind.CULTURE,"無限次☆計画―ろくっ！","無限次☆計画","むげんじけいかくーろくっ！","むげんじけいかく"),
		new Kikaku(384,Place.PLACE_26,Kind.MOGI,"アプリのフランクフルト","アプリコット","あぷりのふらんくふると","あぷりこっと"),
		new Kikaku(385,Place.PLACE_36,Kind.MUSIC,"Jazz Junk Workshop","Jazz Junk Workshop","じゃずじゃんくわーくしょっぷ","じゃずじゃんくわーくしょっぷ"),
		new Kikaku(385,Place.PLACE_36,Kind.MUSIC,"Jazz Junk Workshop","Jazz Junk Workshop","じゃずじゃんくわーくしょっぷ","じゃずじゃんくわーくしょっぷ"),
		new Kikaku(386,Place.PLACE_26,Kind.MOGI,"パキスタン留学生協会","Pakistan Student Association Japan - Tokyo Univers","ぱきすたんりゅうがくせいきょうかいにほん","ぱきすたんすちゅーでんとあそしえーしょんじゃぱん"),
		new Kikaku(387,Place.PLACE_9,Kind.MOGI,"トルコ本場☆デリシャスケバブ","デリシャスケバブ","とるこほんば☆でりしゃすけばぶ","でりしゃすけばぶ"),
		new Kikaku(388,Place.PLACE_50,Kind.MOGI,"shocker","バレーボールサークルshocker","しょっかー","ばれーぼーるさーくるしょっかー"),
		new Kikaku(389,Place.PLACE_19,Kind.CULTURE,"D+9 workshop","designing plus nine","でざいにんぐぷらすないんわぁくしょっぷ","でざいにんぐぷらすないん"),
		new Kikaku(390,Place.PLACE_51,Kind.CULTURE,"英語即興ディベート","英語ディベート部","えいごそっきょうでぃべーと","えいごでぃべーとぶ"),
		new Kikaku(391,Place.PLACE_2,Kind.MOGI,"ナンドッグってなんなん!?","ゴルフ部","なんどっぐってなんなん","ごるふぶ"),
		new Kikaku(392,Place.PLACE_38,Kind.MOGI,"バレパの牛串","スポーツ愛好会バレーボールパート","ばれぱのぎゅうくし","すぽーつあいこうかいばれーぼーるぱーと"),
		new Kikaku(393,Place.PLACE_9,Kind.MUSIC,"タコスは飛んで行く","民族音楽愛好会","たこすはとんでいく","みんぞくおんがくあいこうかい"),
		new Kikaku(393,Place.PLACE_35,Kind.MUSIC,"タコスは飛んで行く","民族音楽愛好会","たこすはとんでいく","みんぞくおんがくあいこうかい"),
		new Kikaku(395,Place.PLACE_32,Kind.MOGI,"Joyful！ワッフル！Gaufre!!","理ⅡⅢ22組","じょいふる！わっふる！ゴーフル!!","り2 3 22くみ"),
		new Kikaku(396,Place.PLACE_14,Kind.MUSIC,"精密工学科クラスバンド","工学部精密工学科","せいみつこうがくかくらすばんど","こうがくぶせいみつこうがくか"),
		new Kikaku(397,Place.PLACE_15,Kind.MUSIC,"T.U.D.C. WISH Street Dance Performance \"GUSH\"","T.U.Dancing Club WISH","てぃーゆーでぃーしーうぃっしゅすとりーとだんすぱふぉーまんすがっしゅ","てぃーゆーだんしんぐくらぶうぃっしゅ"),
		new Kikaku(397,Place.PLACE_35,Kind.MUSIC,"T.U.D.C. WISH Street Dance Performance \"GUSH\"","T.U.Dancing Club WISH","てぃーゆーでぃーしーうぃっしゅすとりーとだんすぱふぉーまんすがっしゅ","てぃーゆーだんしんぐくらぶうぃっしゅ"),
		new Kikaku(398,Place.PLACE_24,Kind.CULTURE,"2012年空宙の旅","工学部航空宇宙工学科","にせんじゅうにねんくうちゅうのたび","こうがくぶこうくううちゅうこうがくか"),
		new Kikaku(399,Place.PLACE_42,Kind.CULTURE,"りばけ五月祭研究発表","2012年度理学部化学科3年生","りばけごがつさいけんきゅうはっぴょう","りがくぶかがくかさんねんせい"),
		new Kikaku(400,Place.PLACE_36,Kind.MUSIC,"エレクトーンコンサート2012","エレクトーンクラブ","えれくとーんこんさーとにせんじゅうに","えれくとーんくらぶ"),
		new Kikaku(400,Place.PLACE_36,Kind.MUSIC,"エレクトーンコンサート2012","エレクトーンクラブ","えれくとーんこんさーとにせんじゅうに","えれくとーんくらぶ"),
		new Kikaku(401,Place.PLACE_13,Kind.MUSIC,"東大フィル第１５回五月祭演奏会","フィルハーモニー管弦楽団","とうだいふぃるだいじゅうごかいごがつさいえんそうかい","ふぃるはーもにーかんげんがくだん"),
		new Kikaku(401,Place.PLACE_13,Kind.MUSIC,"東大フィル第１５回五月祭演奏会","フィルハーモニー管弦楽団","とうだいふぃるだいじゅうごかいごがつさいえんそうかい","ふぃるはーもにーかんげんがくだん"),
		new Kikaku(401,Place.PLACE_22,Kind.MUSIC,"東大フィル第１５回五月祭演奏会","フィルハーモニー管弦楽団","とうだいふぃるだいじゅうごかいごがつさいえんそうかい","ふぃるはーもにーかんげんがくだん"),
		new Kikaku(401,Place.PLACE_22,Kind.MUSIC,"東大フィル第１５回五月祭演奏会","フィルハーモニー管弦楽団","とうだいふぃるだいじゅうごかいごがつさいえんそうかい","ふぃるはーもにーかんげんがくだん"),
		new Kikaku(402,Place.PLACE_14,Kind.MUSIC,"ALIVE","ALIVE","あらいぶ","あらいぶ"),
		new Kikaku(403,Place.PLACE_51,Kind.CULTURE,"iGEM UT-Tokyo","iGEM UT-Tokyo","あいじぇむゆーてぃーとうきょう","あいじぇむゆーてぃーとうきょう"),
		new Kikaku(404,Place.PLACE_43,Kind.MUSIC,"博麗幻奏之儀 弐部","幻想郷","はくれいげんそうのぎにぶ","げんそうきょう"),
		new Kikaku(404,Place.PLACE_43,Kind.MUSIC,"博麗幻奏之儀 弐部","幻想郷","はくれいげんそうのぎにぶ","げんそうきょう"),
		new Kikaku(405,Place.PLACE_14,Kind.MUSIC,"めぐめぐバンド","めぐめぐバンド","めぐめぐばんど","めぐめぐばんど"),
		new Kikaku(406,Place.PLACE_38,Kind.MOGI,"EAGLESのチュロス","EAGLES","いーぐるすのちゅろす","いーぐるす"),
		new Kikaku(407,Place.PLACE_26,Kind.MOGI,"ゆるーつくんのゴマ団子","roots","ゆるーつくんのごまだんご","るーつ"),
		new Kikaku(408,Place.PLACE_36,Kind.CULTURE,"地理部の駄菓子屋","地文研究会地理部","ちりぶのだがしや","ちもんけんきゅうかいちりぶ"),
		new Kikaku(409,Place.PLACE_14,Kind.MUSIC,"かじかる！","かじかる！","かじかる","かじかる"),
		new Kikaku(410,Place.PLACE_20,Kind.CULTURE,"機械系五月祭展示","工学部機械系","きかいけいごがつさいてんじ","こうがくぶきかいけい"),
		new Kikaku(410,Place.PLACE_20,Kind.CULTURE,"機械系五月祭展示","工学部機械系","きかいけいごがつさいてんじ","こうがくぶきかいけい"),
		new Kikaku(410,Place.PLACE_20,Kind.CULTURE,"機械系五月祭展示","工学部機械系","きかいけいごがつさいてんじ","こうがくぶきかいけい"),
		new Kikaku(411,Place.PLACE_47,Kind.MUSIC,"FGA五月祭ライブ","FGA","えふじーえーごがつさいらいぶ〜","えふじーえー"),
		new Kikaku(411,Place.PLACE_47,Kind.MUSIC,"FGA五月祭ライブ","FGA","えふじーえーごがつさいらいぶ〜","えふじーえー"),
		new Kikaku(412,Place.PLACE_23,Kind.CULTURE,"神社研五月祭企画","神社神道研究会","じんじゃけんごがつさいきかく","じんじゃしんとうけんきゅうかい"),
		new Kikaku(412,Place.PLACE_23,Kind.CULTURE,"神社研五月祭企画","神社神道研究会","じんじゃけんごがつさいきかく","じんじゃしんとうけんきゅうかい"),
		new Kikaku(413,Place.PLACE_32,Kind.MOGI,"たこオール","LOVEALL","たこおーる","らぶおーる"),
		new Kikaku(414,Place.PLACE_29,Kind.CULTURE,"東大美術サークル展示","美術サークル","とうだいびじゅつさーくるてんじ","びじゅつさーくる"),
		new Kikaku(414,Place.PLACE_29,Kind.CULTURE,"東大美術サークル展示","美術サークル","とうだいびじゅつさーくるてんじ","びじゅつさーくる"),
		new Kikaku(415,Place.PLACE_51,Kind.CULTURE,"天鳳＠本郷","麻雀サークル白","てんほうあっとほんごう","まーじゃんさーくるはく"),
		new Kikaku(416,Place.PLACE_51,Kind.CULTURE,"第四回五月祭デュエル大会","遊戯王デュエルサークル","だいよんかいごがつさいでゅえるたいかい","ゆうぎおうでゅえるさーくる"),
		new Kikaku(417,Place.PLACE_14,Kind.MUSIC,"第３回東大Produce Project!!","放送研究会","だいさんかいとうだいぷろでゅーすぷろじぇくと！！","ほうそうけんきゅうかい"),
		new Kikaku(417,Place.PLACE_35,Kind.MUSIC,"第３回東大Produce Project!!","放送研究会","だいさんかいとうだいぷろでゅーすぷろじぇくと！！","ほうそうけんきゅうかい"),
		new Kikaku(417,Place.PLACE_35,Kind.MUSIC,"第３回東大Produce Project!!","放送研究会","だいさんかいとうだいぷろでゅーすぷろじぇくと！！","ほうそうけんきゅうかい"),
		new Kikaku(418,Place.PLACE_35,Kind.CULTURE,"『飛翔』の児童文学","児童文学を読む会","ひしょうのじどうぶんがく","じどうぶんがくをよむかい"),
		new Kikaku(419,Place.PLACE_57,Kind.MOGI,"星空屋台","地文研究会天文部","ほしぞら屋台","ちもんけんきゅうかいてんもんぶ"),
		new Kikaku(420,Place.PLACE_18,Kind.CULTURE,"コミックアカデミー04","コミックアカデミー実行委員会","こみっくあかでみー04","こみっくあかでみーじっこういいんかい"),
		new Kikaku(421,Place.PLACE_47,Kind.MUSIC,"BR　Live!","British Rock研究会","びーあーるらいぶ","ぶりてぃっしゅろっくけんきゅうかい"),
		new Kikaku(421,Place.PLACE_47,Kind.MUSIC,"BR　Live!","British Rock研究会","びーあーるらいぶ","ぶりてぃっしゅろっくけんきゅうかい"),
		new Kikaku(422,Place.PLACE_38,Kind.MOGI,"アゲぽよアイス","理ⅡⅢ18組","あげぽよあいす","り2 3 18くみ"),
		new Kikaku(423,Place.PLACE_8,Kind.MOGI,"アンプラの豚キムチヂミ","アンプラグド","あんぷらのぶたきむちぢみ","あんぷらぐど"),
		new Kikaku(423,Place.PLACE_35,Kind.MOGI,"アンプラの豚キムチヂミ","アンプラグド","あんぷらのぶたきむちぢみ","あんぷらぐど"),
		new Kikaku(424,Place.PLACE_35,Kind.CULTURE,"五月祭講演会","行政機構研究会","ごがつさいこうえんかい","ぎょうせいきこうけんきゅうかい"),
		new Kikaku(424,Place.PLACE_35,Kind.CULTURE,"五月祭講演会","行政機構研究会","ごがつさいこうえんかい","ぎょうせいきこうけんきゅうかい"),
		new Kikaku(425,Place.PLACE_38,Kind.MOGI,"ぷーのアメリカンドッグ","ドンキー","ぷーのあめりかんどっぐ","どんきー"),
		new Kikaku(426,Place.PLACE_19,Kind.CULTURE,"写真展","土井ゼミ中国班","しゃしんてん","どいぜみちゅうごくはん"),
		new Kikaku(427,Place.PLACE_25,Kind.MUSIC,"五月祭コンサート","東京大学・東京女子大学古典ギター愛好会","ごがつさいこんさーと","とうきょうだいがくとうきょうじょしだいがくこてんぎたーあいこうかい"),
		new Kikaku(427,Place.PLACE_25,Kind.MUSIC,"五月祭コンサート","東京大学・東京女子大学古典ギター愛好会","ごがつさいこんさーと","とうきょうだいがくとうきょうじょしだいがくこてんぎたーあいこうかい"),
		new Kikaku(428,Place.PLACE_47,Kind.CULTURE,"写真文化会展示","写真文化会","しゃしんぶんかかいてんじ","しゃしんぶんかかい"),
		new Kikaku(429,Place.PLACE_14,Kind.MUSIC,"WEEKEND LIVE","the 1ch-Cuartet","うぃーくえんど　らいぶ","ざ　わんちゃんかるてっと"),
		new Kikaku(430,Place.PLACE_36,Kind.MUSIC,"襖張替実演","襖クラブ","ふすまはりかえじつえん","ふすまくらぶ"),
		new Kikaku(431,Place.PLACE_14,Kind.MUSIC,"水圏LIVE2012～蒲焼の香り～","the Electric EELS","すいけんらいぶにせんじゅうに　かばやきのかおり","じえれくとりっくいーるず"),
		new Kikaku(432,Place.PLACE_36,Kind.MOGI,"合唱喫茶Green Echo","法学部緑会合唱団","がっしょうきっさぐりーんえこー","ほうがくぶみどりかいがっしょうだん"),
		new Kikaku(433,Place.PLACE_32,Kind.MOGI,"奈良県名物大仏焼き","奈良弥生門会","ならけんめいぶつだいぶつやき","ならやよいもんかい"),
		new Kikaku(434,Place.PLACE_29,Kind.CULTURE,"東大映研、上映会。","映画研究会","とうだいえいけんじょうえいかい","えいがけんきゅうかい"),
		new Kikaku(435,Place.PLACE_53,Kind.MOGI,"水圏うなぎ屋水族館","農学部水圏","すいけんうなぎやすいぞくかん","のうがくぶすいけん"),
		new Kikaku(436,Place.PLACE_14,Kind.MUSIC,"BUMPコピーバンド","TRY HARDER","ばんぷコピーバンド","とらいはーだー"),
		new Kikaku(437,Place.PLACE_39,Kind.MOGI,"東京大学茶道部五月祭茶会","茶道部","とうきょうだいがくさどうぶごがつさいちゃかい","さどうぶ"),
		new Kikaku(438,Place.PLACE_18,Kind.CULTURE,"コミックアカデミー　コスプレ広場","コミックアカデミー実行委員会","こみっくあかでみー　こすぷれひろば","こみっくあかでみーじっこういいんかい"),
		new Kikaku(438,Place.PLACE_18,Kind.CULTURE,"コミックアカデミー　コスプレ広場","コミックアカデミー実行委員会","こみっくあかでみー　こすぷれひろば","こみっくあかでみーじっこういいんかい"),
		new Kikaku(438,Place.PLACE_18,Kind.CULTURE,"コミックアカデミー　コスプレ広場","コミックアカデミー実行委員会","こみっくあかでみー　こすぷれひろば","こみっくあかでみーじっこういいんかい"),
		new Kikaku(438,Place.PLACE_18,Kind.CULTURE,"コミックアカデミー　コスプレ広場","コミックアカデミー実行委員会","こみっくあかでみー　こすぷれひろば","こみっくあかでみーじっこういいんかい"),
		new Kikaku(438,Place.PLACE_18,Kind.CULTURE,"コミックアカデミー　コスプレ広場","コミックアカデミー実行委員会","こみっくあかでみー　こすぷれひろば","こみっくあかでみーじっこういいんかい"),
		new Kikaku(439,Place.PLACE_35,Kind.CULTURE,"COM CD SALE","TOKYO COM","こむしーでぃーせーる","とうきょうこむ"),
		new Kikaku(440,Place.PLACE_57,Kind.MOGI,"中華小籠包・水餃子","中国留学生学友会","ちゅうかしょうろんぽ・すいぎょうざ","ちゅうごくりゅうがくせいがくゆうかい"),
		new Kikaku(442,Place.PLACE_19,Kind.CULTURE,"東大SSA五月祭企画","アニメーション研究会","とうだいえすえすえーごがつさいきかく","あにめーしょんけんきゅうかい"),
		new Kikaku(442,Place.PLACE_23,Kind.CULTURE,"東大SSA五月祭企画","アニメーション研究会","とうだいえすえすえーごがつさいきかく","あにめーしょんけんきゅうかい"),
		new Kikaku(443,Place.PLACE_54,Kind.CULTURE,"空宙Walker","工学部航空宇宙工学科　実演班","くうちゅううぉーかー","こうがくぶこうくううちゅうこうがくか　じつえんはん"),
		new Kikaku(444,Place.PLACE_14,Kind.MUSIC,"(The Fall of)","Ringo Stardust & The Beetles from Mars","ざふぉーるおぶ","りんごすたーだすとあんどざびーとるずふろむまーず"),
		new Kikaku(445,Place.PLACE_9,Kind.MOGI,"ファラオの集い","サブ留会","ふぁらおのつどい","さぶりゅうかい"),
		new Kikaku(446,Place.PLACE_26,Kind.MOGI,"ブルの宮焼きそば","Wimbledon","ぶるのみややきそば","うぃんぶるどん"),
		new Kikaku(447,Place.PLACE_2,Kind.MOGI,"ラーメソ二郎　本郷店","ラーメン二郎愛好会","らーめそじろう　ほんごうてん","らーめんじろうあいこうかい"),
		new Kikaku(448,Place.PLACE_13,Kind.MUSIC,"東大歌劇団五月祭演奏会","歌劇団","とうだいかげきだんごがつさいえんそうかい","かげきだん"),
		new Kikaku(448,Place.PLACE_13,Kind.MUSIC,"東大歌劇団五月祭演奏会","歌劇団","とうだいかげきだんごがつさいえんそうかい","かげきだん"),
		new Kikaku(448,Place.PLACE_13,Kind.MUSIC,"東大歌劇団五月祭演奏会","歌劇団","とうだいかげきだんごがつさいえんそうかい","かげきだん"),
		new Kikaku(449,Place.PLACE_47,Kind.MOGI,"Book Cafe","キリスト者学生会","ぶっくかふぇ","きりすとしゃがくせいかい"),
		new Kikaku(450,Place.PLACE_11,Kind.MUSIC,"東京大学フラメンコ舞踏団第32回定期公演","フラメンコ舞踏団","とうきょうだいがくふらめんこぶとうだんだいさんじゅうにかいていきこうえん","ふらめんこぶとうだん"),
		new Kikaku(450,Place.PLACE_11,Kind.MUSIC,"東京大学フラメンコ舞踏団第32回定期公演","フラメンコ舞踏団","とうきょうだいがくふらめんこぶとうだんだいさんじゅうにかいていきこうえん","ふらめんこぶとうだん"),
		new Kikaku(450,Place.PLACE_20,Kind.MUSIC,"東京大学フラメンコ舞踏団第32回定期公演","フラメンコ舞踏団","とうきょうだいがくふらめんこぶとうだんだいさんじゅうにかいていきこうえん","ふらめんこぶとうだん"),
		new Kikaku(450,Place.PLACE_20,Kind.MUSIC,"東京大学フラメンコ舞踏団第32回定期公演","フラメンコ舞踏団","とうきょうだいがくふらめんこぶとうだんだいさんじゅうにかいていきこうえん","ふらめんこぶとうだん"),
		new Kikaku(451,Place.PLACE_8,Kind.MOGI,"つーぱーずのお店","TWOPERS","つーぱーずのおみせ","つーぱーず"),
		new Kikaku(452,Place.PLACE_22,Kind.CULTURE,"工学部化生系五月祭展示","工学部化学生命系三学科","こうがくぶかせいけいごがつさいてんじ","こうがくぶかがくせいめいけいさんがっか"),
		new Kikaku(452,Place.PLACE_22,Kind.CULTURE,"工学部化生系五月祭展示","工学部化学生命系三学科","こうがくぶかせいけいごがつさいてんじ","こうがくぶかがくせいめいけいさんがっか"),
		new Kikaku(452,Place.PLACE_22,Kind.CULTURE,"工学部化生系五月祭展示","工学部化学生命系三学科","こうがくぶかせいけいごがつさいてんじ","こうがくぶかがくせいめいけいさんがっか"),
		new Kikaku(453,Place.PLACE_29,Kind.MUSIC,"LaVoceアカペラストリートライブ","アカペラバンドサークルLaVoce","らぼーちぇあかぺらすとりーとらいぶ","あかぺらばんどさーくるらぼーちぇ"),
		new Kikaku(453,Place.PLACE_46,Kind.MUSIC,"LaVoceアカペラストリートライブ","アカペラバンドサークルLaVoce","らぼーちぇあかぺらすとりーとらいぶ","あかぺらばんどさーくるらぼーちぇ"),
		new Kikaku(454,Place.PLACE_27,Kind.MUSIC,"LaVoceアカペラステージライブ","アカペラバンドサークルLaVoce","らぼーちぇあかぺらすてーじらいぶ","あかぺらばんどさーくるらぼーちぇ"),
		new Kikaku(454,Place.PLACE_27,Kind.MUSIC,"LaVoceアカペラステージライブ","アカペラバンドサークルLaVoce","らぼーちぇあかぺらすてーじらいぶ","あかぺらばんどさーくるらぼーちぇ"),
		new Kikaku(454,Place.PLACE_35,Kind.MUSIC,"LaVoceアカペラステージライブ","アカペラバンドサークルLaVoce","らぼーちぇあかぺらすてーじらいぶ","あかぺらばんどさーくるらぼーちぇ"),
		new Kikaku(454,Place.PLACE_35,Kind.MUSIC,"LaVoceアカペラステージライブ","アカペラバンドサークルLaVoce","らぼーちぇあかぺらすてーじらいぶ","あかぺらばんどさーくるらぼーちぇ"),
		new Kikaku(455,Place.PLACE_13,Kind.MUSIC,"フォイヤーヴェルク管弦楽団五月祭演奏会","フォイヤーヴェルク管弦楽団","ふぉいやーゔぇるくかんげんがくだんごがつさいえんそうかい","ふぉいやーゔぇるくかんげんがくだん"),
		new Kikaku(456,Place.PLACE_2,Kind.MOGI,"絶品！ソースやきそば！","BlueSpot","ぜっぴん！そーすやきそば！","ぶるーすぽっと"),
		new Kikaku(457,Place.PLACE_56,Kind.MOGI,"本格炭火焼き鳥","生物素材化学専修","ほんかくすみびやきとり","せいぶつそざいかがくせんしゅう"),
		new Kikaku(458,Place.PLACE_14,Kind.MUSIC,"松井Project","工学部３年有志","まついぷろじぇくと","こうがくぶさんねんゆうし"),
		new Kikaku(459,Place.PLACE_10,Kind.MUSIC,"応援部パレード・デモンストレーション","応援部","おうえんぶぱれーど・でもんすとれーしょん","おうえんぶ"),
		new Kikaku(460,Place.PLACE_26,Kind.MOGI,"角切り元祖松坂牛","ダイニンぐ～キネシン～","かくぎりがんそまつざかぎゅう","だいにんぐきねしん"),
		new Kikaku(461,Place.PLACE_57,Kind.MOGI,"はっぴー１０ｔｈ","文Ⅲ10組","はっぴーてんす","ぶん3 10くみ"),
		new Kikaku(462,Place.PLACE_32,Kind.CULTURE,"東京大学新聞社による新聞・書籍販売","公益財団法人東京大学新聞社","とうきょうだいがくしんぶんしゃによるしんぶん・しょせきはんばい","こうえきざいだんほうじんとうきょうだいがくしんぶんしゃ"),
		new Kikaku(463,Place.PLACE_57,Kind.MOGI,"えるべのフランクフルト","LBJ ski team","えるべのふらんくふると","えるびーじぇーすきーちーむ"),
		new Kikaku(464,Place.PLACE_32,Kind.MOGI,"いもがいいもん♪","コーロ・ソーノ合唱団","いもがいいもん","こーろそーのがっしょうだん"),
		new Kikaku(465,Place.PLACE_14,Kind.MUSIC,"M.Kg's Solo Live","M.Kg","えむけーじーずそろらいぶ","えむけーじー"),
		new Kikaku(466,Place.PLACE_2,Kind.MOGI,"おでん","CHERISH","おでん","ちぇりっしゅ"),
		new Kikaku(467,Place.PLACE_23,Kind.CULTURE,"東大病院現役医師の語る小児医療の最先端","マイハウス","とうだいびょういんげんえきいしのかたるしょうにいりょうのさいせんたん","まいはうす"),
		new Kikaku(467,Place.PLACE_23,Kind.CULTURE,"東大病院現役医師の語る小児医療の最先端","マイハウス","とうだいびょういんげんえきいしのかたるしょうにいりょうのさいせんたん","まいはうす"),
		new Kikaku(468,Place.PLACE_26,Kind.CULTURE,"ムスリム・バザール","イスラム文化研究会","むすりむ・ばざぁる","いすらむぶんかけんきゅうかい"),
		new Kikaku(469,Place.PLACE_26,Kind.MOGI,"兎亭","ラビットアルペンスキーチーム","うさぎてい","らびっとあるぺんすきーちーむ"),
		new Kikaku(470,Place.PLACE_8,Kind.MOGI,"伝統のタピオカ屋","理Ⅰ11組","でんとうのたぴおか","り1 11くみ"),
		new Kikaku(471,Place.PLACE_1,Kind.MUSIC,"東京大学合気道気錬会五月祭演武会","合気道気練会","とうきょうだいがくあいきどうきれんかいごがつさいえんぶかい","あいきどうきれんかい"),
		new Kikaku(471,Place.PLACE_29,Kind.MUSIC,"東京大学合気道気錬会五月祭演武会","合気道気練会","とうきょうだいがくあいきどうきれんかいごがつさいえんぶかい","あいきどうきれんかい"),
		new Kikaku(471,Place.PLACE_35,Kind.MUSIC,"東京大学合気道気錬会五月祭演武会","合気道気練会","とうきょうだいがくあいきどうきれんかいごがつさいえんぶかい","あいきどうきれんかい"),
		new Kikaku(472,Place.PLACE_9,Kind.MOGI,"BBのお店","Big Box's","びーびーのおみせ","びっぐぼっくすず"),
		new Kikaku(473,Place.PLACE_5,Kind.MOGI,"鉄門野球部フランクフルト","鉄門野球部","てつもんやきゅうぶふらんくふると","てつもんやきゅうぶ"),
		new Kikaku(475,Place.PLACE_8,Kind.MOGI,"東大剣友会36期","剣友会","とうだいけんゆうかい３６き","けんゆうかい"),
		new Kikaku(476,Place.PLACE_14,Kind.MUSIC,"a chilly actor LIVE","a chilly actor","ちりーあくたーらいぶ","ちりーあくたー"),
		new Kikaku(477,Place.PLACE_26,Kind.MOGI,"すぺしゃの牛串","すぺーすしゃとる","すぺしゃのぎゅうくし","すぺーすしゃとる"),
		new Kikaku(478,Place.PLACE_47,Kind.MOGI,"Moco's kitchen","料理愛好会","もこずきっちん","りょうりあいこうかい"),
		new Kikaku(479,Place.PLACE_14,Kind.MUSIC,"イッパチバンド","イッパチバンド","いっぱちばんど","いっぱちばんど"),
		new Kikaku(480,Place.PLACE_23,Kind.CULTURE,"GEIL2012主催瀧本哲史講演会","学生のための政策立案コンテストGEIL2012実行委員会","がいる2012しゅさいたきもとてつふみこうえんかい","がくせいのためのせいさくりつあんこんてすとがいる2012じっこういいんかい"),
		new Kikaku(480,Place.PLACE_35,Kind.CULTURE,"GEIL2012主催瀧本哲史講演会","学生のための政策立案コンテストGEIL2012実行委員会","がいる2012しゅさいたきもとてつふみこうえんかい","がくせいのためのせいさくりつあんこんてすとがいる2012じっこういいんかい"),
		new Kikaku(481,Place.PLACE_43,Kind.MUSIC,"東大オケ小演奏会＆室内楽演奏会","音楽部管弦楽団","とうだいおけしょうえんそうかいあんどしつないがくえんそうかい","おんがくぶかんげんがくだん"),
		new Kikaku(481,Place.PLACE_43,Kind.MUSIC,"東大オケ小演奏会＆室内楽演奏会","音楽部管弦楽団","とうだいおけしょうえんそうかいあんどしつないがくえんそうかい","おんがくぶかんげんがくだん"),
		new Kikaku(481,Place.PLACE_43,Kind.MUSIC,"東大オケ小演奏会＆室内楽演奏会","音楽部管弦楽団","とうだいおけしょうえんそうかいあんどしつないがくえんそうかい","おんがくぶかんげんがくだん"),
		new Kikaku(481,Place.PLACE_43,Kind.MUSIC,"東大オケ小演奏会＆室内楽演奏会","音楽部管弦楽団","とうだいおけしょうえんそうかいあんどしつないがくえんそうかい","おんがくぶかんげんがくだん"),
		new Kikaku(481,Place.PLACE_43,Kind.MUSIC,"東大オケ小演奏会＆室内楽演奏会","音楽部管弦楽団","とうだいおけしょうえんそうかいあんどしつないがくえんそうかい","おんがくぶかんげんがくだん"),
		new Kikaku(482,Place.PLACE_36,Kind.CULTURE,"「瞳にうつる」写真・絵の展覧会","中国留学生学友会","ひとみにうつる」しゃしん・えのてんらんかい","ちゅうごくりゅうがくせいがくゆうかい"),
		new Kikaku(483,Place.PLACE_12,Kind.MUSIC,"東大オケ五月祭特別演奏会","音楽部管弦楽団","とうだいおけごがつさいとくべつえんそうかい","おんがくぶかんげんがくだん"),
		new Kikaku(483,Place.PLACE_13,Kind.MUSIC,"東大オケ五月祭特別演奏会","音楽部管弦楽団","とうだいおけごがつさいとくべつえんそうかい","おんがくぶかんげんがくだん"),
		new Kikaku(483,Place.PLACE_13,Kind.MUSIC,"東大オケ五月祭特別演奏会","音楽部管弦楽団","とうだいおけごがつさいとくべつえんそうかい","おんがくぶかんげんがくだん"),
		new Kikaku(483,Place.PLACE_13,Kind.MUSIC,"東大オケ五月祭特別演奏会","音楽部管弦楽団","とうだいおけごがつさいとくべつえんそうかい","おんがくぶかんげんがくだん"),
		new Kikaku(483,Place.PLACE_13,Kind.MUSIC,"東大オケ五月祭特別演奏会","音楽部管弦楽団","とうだいおけごがつさいとくべつえんそうかい","おんがくぶかんげんがくだん"),
		new Kikaku(484,Place.PLACE_10,Kind.MUSIC,"東大踊々夢","まるきゅうProject","とうだいようようむ","まるきゅうぷろじぇくと"),
		new Kikaku(484,Place.PLACE_10,Kind.MUSIC,"東大踊々夢","まるきゅうProject","とうだいようようむ","まるきゅうぷろじぇくと"),
		new Kikaku(484,Place.PLACE_18,Kind.MUSIC,"東大踊々夢","まるきゅうProject","とうだいようようむ","まるきゅうぷろじぇくと"),
		new Kikaku(484,Place.PLACE_18,Kind.MUSIC,"東大踊々夢","まるきゅうProject","とうだいようようむ","まるきゅうぷろじぇくと"),
		new Kikaku(484,Place.PLACE_18,Kind.MUSIC,"東大踊々夢","まるきゅうProject","とうだいようようむ","まるきゅうぷろじぇくと"),
		new Kikaku(484,Place.PLACE_18,Kind.MUSIC,"東大踊々夢","まるきゅうProject","とうだいようようむ","まるきゅうぷろじぇくと"),
		new Kikaku(484,Place.PLACE_22,Kind.MUSIC,"東大踊々夢","まるきゅうProject","とうだいようようむ","まるきゅうぷろじぇくと"),
		new Kikaku(485,Place.PLACE_32,Kind.MOGI,"Taiyaki skywalker","Tokyo skywalker","たいやきすかいうぉーかー","とうきょうすかいうぉーかー"),
		new Kikaku(486,Place.PLACE_50,Kind.MOGI,"ユーフォリアの模擬店","EUPHORIA","ゆーふぉりあのもぎてん","ゆーふぉりあ"),
		new Kikaku(487,Place.PLACE_43,Kind.MUSIC,"クラリネット・サクソフォン合同演奏会","クラリネット・サクソフォン同好会","くらりねっと・さくそふぉんごうどうえんそうかい","くらりねっと・さくそふぉんどうこうかい"),
		new Kikaku(487,Place.PLACE_43,Kind.MUSIC,"クラリネット・サクソフォン合同演奏会","クラリネット・サクソフォン同好会","くらりねっと・さくそふぉんごうどうえんそうかい","くらりねっと・さくそふぉんどうこうかい"),
		new Kikaku(487,Place.PLACE_43,Kind.MUSIC,"クラリネット・サクソフォン合同演奏会","クラリネット・サクソフォン同好会","くらりねっと・さくそふぉんごうどうえんそうかい","くらりねっと・さくそふぉんどうこうかい"),
		new Kikaku(488,Place.PLACE_8,Kind.MOGI,"KEBABoooo!!!","NIRIEM","けばぶ","にりえむ"),
		new Kikaku(489,Place.PLACE_27,Kind.MUSIC,"ABADA-CAPOEIRA","アバタ・カポエイラ","あばだ・カポエイラ","あばだ-かぽえいら"),
		new Kikaku(489,Place.PLACE_35,Kind.MUSIC,"ABADA-CAPOEIRA","アバタ・カポエイラ","あばだ・カポエイラ","あばだ-かぽえいら"),
		new Kikaku(490,Place.PLACE_40,Kind.CULTURE,"PHYSICS LAB. 2012","理学部物理学科","ふぃじっくすらぼにせんじゅうに","りがくぶぶつりがっか"),
		new Kikaku(490,Place.PLACE_40,Kind.CULTURE,"PHYSICS LAB. 2012","理学部物理学科","ふぃじっくすらぼにせんじゅうに","りがくぶぶつりがっか"),
		new Kikaku(490,Place.PLACE_40,Kind.CULTURE,"PHYSICS LAB. 2012","理学部物理学科","ふぃじっくすらぼにせんじゅうに","りがくぶぶつりがっか"),
		new Kikaku(490,Place.PLACE_40,Kind.CULTURE,"PHYSICS LAB. 2012","理学部物理学科","ふぃじっくすらぼにせんじゅうに","りがくぶぶつりがっか"),
		new Kikaku(490,Place.PLACE_40,Kind.CULTURE,"PHYSICS LAB. 2012","理学部物理学科","ふぃじっくすらぼにせんじゅうに","りがくぶぶつりがっか"),
		new Kikaku(492,Place.PLACE_35,Kind.CULTURE,"教育フォーラム","教育NPO・ROJE","きょういくふぉーらむ","きょういくえぬぴーおー・ろじぇ"),
		new Kikaku(492,Place.PLACE_35,Kind.CULTURE,"教育フォーラム","教育NPO・ROJE","きょういくふぉーらむ","きょういくえぬぴーおー・ろじぇ"),
		new Kikaku(492,Place.PLACE_35,Kind.CULTURE,"教育フォーラム","教育NPO・ROJE","きょういくふぉーらむ","きょういくえぬぴーおー・ろじぇ"),
		new Kikaku(493,Place.PLACE_32,Kind.MOGI,"エルピの焼きそば","エルピラータ","えるぴのやきそば","えるぴらーた"),
		new Kikaku(494,Place.PLACE_20,Kind.MUSIC,"東京大学奇術愛好会ステージマジックショー","奇術愛好会","とうきょうだいがくきじゅつあいこうかいすてーじまじっくしょー","きじゅつあいこうかい"),
		new Kikaku(494,Place.PLACE_20,Kind.MUSIC,"東京大学奇術愛好会ステージマジックショー","奇術愛好会","とうきょうだいがくきじゅつあいこうかいすてーじまじっくしょー","きじゅつあいこうかい"),
		new Kikaku(495,Place.PLACE_9,Kind.MOGI,"K-project","K-project","けーぷろじぇくと","けーぷろじぇくと"),
		new Kikaku(496,Place.PLACE_2,Kind.MOGI,"酒屋兼高橋克典受験恋愛就職相談所","理Ⅰ7組","さかやけんたかはしかつのりじゅけんれんあいしゅうしょくそうだんじょ","り1 7くみ"),
		new Kikaku(497,Place.PLACE_35,Kind.CULTURE,"国際ＮＧＯの力学","MPJユース","こくさいえぬじーおーのりきがく","えむぴーじぇいゆーす"),
		new Kikaku(497,Place.PLACE_35,Kind.CULTURE,"国際ＮＧＯの力学","MPJユース","こくさいえぬじーおーのりきがく","えむぴーじぇいゆーす"),
		new Kikaku(497,Place.PLACE_35,Kind.CULTURE,"国際ＮＧＯの力学","MPJユース","こくさいえぬじーおーのりきがく","えむぴーじぇいゆーす"),
		new Kikaku(499,Place.PLACE_20,Kind.CULTURE,"REFORMATION & REBELLION IN ゲームパーク","マイコンクラブ","れふぉーめーしょんあんどりべりおんいんげーむぱーく","まいこんくらぶ"),
		new Kikaku(500,Place.PLACE_32,Kind.MOGI,"Ker(T)","理Ⅰ23組","かーねるてぃー","り1 23くみ"),
		new Kikaku(501,Place.PLACE_26,Kind.MOGI,"ケバ部","留学生交流会","けばぶ","りゅうがくせいこうりゅうかい"),
		new Kikaku(502,Place.PLACE_20,Kind.CULTURE,"五月祭+ゲー研の野望","ゲーム研究会","ごがつさいぷらすげーけんのやぼう","げーむけんきゅうかい"),
		new Kikaku(503,Place.PLACE_8,Kind.MOGI,"すぽるとのからあげ棒","すぽると","すぽるとのからあげぼう","すぽると"),
		new Kikaku(504,Place.PLACE_38,Kind.MOGI,"maruの牛串","maru","まるのぎゅうくし","まる"),
		new Kikaku(505,Place.PLACE_19,Kind.CULTURE,"鉄道研究会","鉄道研究会","てつどうけんきゅうかい","てつどうけんきゅうかい"),
		new Kikaku(506,Place.PLACE_27,Kind.MUSIC,"極真空手演武","極真空手同好会","きょくしんからてえんぶ","きょくしんからてどうこうかい"),
		new Kikaku(506,Place.PLACE_29,Kind.MUSIC,"極真空手演武","極真空手同好会","きょくしんからてえんぶ","きょくしんからてどうこうかい"),
		new Kikaku(507,Place.PLACE_38,Kind.MOGI,"Vegetarianの食生活","慈済青年隊","べじたりあんのしょくせいかつ","つーちーせいねんたい"),
		new Kikaku(508,Place.PLACE_19,Kind.CULTURE,"「人」の支援をめざして ～宮城県南三陸町での復興支援活動～","UT-OAK震災救援団","ひとのしえんをめざしてみやぎけんみなみさんりくちょうでのふっこうしえんかつどう","ゆーてぃーおーくしんさいきゅうえんだん"),
		new Kikaku(509,Place.PLACE_50,Kind.MOGI,"焼鳥ヤンヤン","農学部生命化学工学科","やきとりやんやん","のうがくぶせいめいかがくこうがくか"),
		new Kikaku(511,Place.PLACE_1,Kind.MUSIC,"東京大学運動会躰道部五月祭演武会","躰道部","とうきょうだいがくうんどうかいたいどうぶごがつさいえんぶかい","たいどうぶ"),
		new Kikaku(512,Place.PLACE_10,Kind.MUSIC,"ブラアカ路上ライブ!!","ブラスアカデミー","ぶらあかろじょうらいぶ","ぶらすあかでみー"),
		new Kikaku(513,Place.PLACE_38,Kind.MOGI,"2011年度入学理二三17組","理ⅡⅢ17組","にせんじゅういちねんどにゅうがくりにさんじゅうななくみ","り2 3 17くみ"),
		new Kikaku(515,Place.PLACE_8,Kind.MOGI,"スラィリーの揚げもみじ饅頭","広島東洋カープ応援サークルスラィリー","すらぃりーのあげもみじまんじゅう","ひろしまとうようかーぷおうえんさーくるすらぃりー"),
		new Kikaku(516,Place.PLACE_56,Kind.CULTURE,"木質材料セルフビルド建造物の展示","木質材料学研究室・木質構造学研究室","もくしつざいりょうせるふびるどけんぞうぶつのてんじ","もくしつざいりょうがくけんきゅうしつ・もくしつこうぞうがくけんきゅうしつ"),
		new Kikaku(517,Place.PLACE_47,Kind.MOGI,"カクテルホストクラブ","起業サークルTNK","かくてるホストクラブ","きぎょうさーくるてぃーえぬけー"),
		new Kikaku(518,Place.PLACE_32,Kind.MOGI,"シグマの焼き鳥","Sigmaテニスサークル","しぐまのやきとり","しぐまてにすさーくる"),
		new Kikaku(519,Place.PLACE_16,Kind.MUSIC,"室内楽の会 五月祭演奏会","室内楽の会","しつないがくのかい　ごがつさいえんそうかい","しつないがくのかい"),
		new Kikaku(519,Place.PLACE_16,Kind.MUSIC,"室内楽の会 五月祭演奏会","室内楽の会","しつないがくのかい　ごがつさいえんそうかい","しつないがくのかい"),
		new Kikaku(519,Place.PLACE_25,Kind.MUSIC,"室内楽の会 五月祭演奏会","室内楽の会","しつないがくのかい　ごがつさいえんそうかい","しつないがくのかい"),
		new Kikaku(519,Place.PLACE_25,Kind.MUSIC,"室内楽の会 五月祭演奏会","室内楽の会","しつないがくのかい　ごがつさいえんそうかい","しつないがくのかい"),
		new Kikaku(519,Place.PLACE_25,Kind.MUSIC,"室内楽の会 五月祭演奏会","室内楽の会","しつないがくのかい　ごがつさいえんそうかい","しつないがくのかい"),
		new Kikaku(519,Place.PLACE_25,Kind.MUSIC,"室内楽の会 五月祭演奏会","室内楽の会","しつないがくのかい　ごがつさいえんそうかい","しつないがくのかい"),
		new Kikaku(520,Place.PLACE_37,Kind.CULTURE,"シンポジウム：日本サッカーの未来","ア式蹴球部（サッカー部）","しんぽじうむ：にほんさっかーのみらい","あしきしゅうきゅうぶ（さっかーぶ）"),
		new Kikaku(521,Place.PLACE_47,Kind.MUSIC,"東大エフ研","fken","とうだいえふけん","えふけん"),
		new Kikaku(521,Place.PLACE_47,Kind.MUSIC,"東大エフ研","fken","とうだいえふけん","えふけん"),
		new Kikaku(522,Place.PLACE_14,Kind.MUSIC,"KMB４８","KMB４８","けーえむびーふぉーてぃーえいと","けーえむびーふぉーてぃーえいと"),
		new Kikaku(522,Place.PLACE_55,Kind.MUSIC,"KMB４８","KMB４８","けーえむびーふぉーてぃーえいと","けーえむびーふぉーてぃーえいと"),
		new Kikaku(523,Place.PLACE_57,Kind.MOGI,"OLK焼きそば","OLK","おーえるけーやきそば","おーえるけー"),
		new Kikaku(524,Place.PLACE_14,Kind.MUSIC,"バンド演奏","バンド演奏","ばんどえんそう","ばんどえんそう"),
		new Kikaku(525,Place.PLACE_35,Kind.CULTURE,"五月祭弁論大会","第一高等学校・東京大学弁論部","ごがつさいべんろんたいかい","だいいちこうとうがっこう・とうきょうだいがくべんろんぶ"),
		new Kikaku(525,Place.PLACE_35,Kind.CULTURE,"五月祭弁論大会","第一高等学校・東京大学弁論部","ごがつさいべんろんたいかい","だいいちこうとうがっこう・とうきょうだいがくべんろんぶ"),
		new Kikaku(525,Place.PLACE_35,Kind.CULTURE,"五月祭弁論大会","第一高等学校・東京大学弁論部","ごがつさいべんろんたいかい","だいいちこうとうがっこう・とうきょうだいがくべんろんぶ"),
		new Kikaku(526,Place.PLACE_20,Kind.CULTURE,"自動車運転シミュレータ","EVクラブUTECH","じどうしゃうんてんしみゅれーた","いーぶいくらぶゆーてっく"),
		new Kikaku(527,Place.PLACE_26,Kind.MOGI,"GFのお好み焼き","Group　Flates","じーえふのおこのみやき","ぐるーぷふれーつ"),
		new Kikaku(528,Place.PLACE_26,Kind.MOGI,"スキー部のホットドッグ屋","スキー部","すきーぶのほっとどっぐや","すきーぶ"),
		new Kikaku(529,Place.PLACE_12,Kind.CULTURE,"コンテンツゼミ講演会","情報学環教育部自治会コンテンツゼミ","こんてんつぜみこうえんかい","じょうほうがっかんきょういくぶじちかいこんてんつぜみ"),
		new Kikaku(529,Place.PLACE_22,Kind.CULTURE,"コンテンツゼミ講演会","情報学環教育部自治会コンテンツゼミ","こんてんつぜみこうえんかい","じょうほうがっかんきょういくぶじちかいこんてんつぜみ"),
		new Kikaku(529,Place.PLACE_35,Kind.CULTURE,"コンテンツゼミ講演会","情報学環教育部自治会コンテンツゼミ","こんてんつぜみこうえんかい","じょうほうがっかんきょういくぶじちかいこんてんつぜみ"),
		new Kikaku(531,Place.PLACE_32,Kind.MOGI,"イカの店","Grand Bleu","いかのみせ","ぐらんぶるー"),
		new Kikaku(532,Place.PLACE_2,Kind.MOGI,"Thirsty!!FastDrink!!","WISH31st","さーすてぃふぁすとどりんく","うぃっしゅさんじゅういちだい"),
		new Kikaku(533,Place.PLACE_57,Kind.MOGI,"たこ焼き敬天","新敬天寮","たこやきけいてん","しんけいてんりょう"),
		new Kikaku(534,Place.PLACE_10,Kind.MUSIC,"和太鼓演奏","和太鼓集団だるま","わだいこえんそう","わだいこしゅうだんだるま"),
		new Kikaku(534,Place.PLACE_10,Kind.MUSIC,"和太鼓演奏","和太鼓集団だるま","わだいこえんそう","わだいこしゅうだんだるま"),
		new Kikaku(534,Place.PLACE_29,Kind.MUSIC,"和太鼓演奏","和太鼓集団だるま","わだいこえんそう","わだいこしゅうだんだるま"),
		new Kikaku(534,Place.PLACE_47,Kind.MUSIC,"和太鼓演奏","和太鼓集団だるま","わだいこえんそう","わだいこしゅうだんだるま"),
		new Kikaku(535,Place.PLACE_37,Kind.MOGI,"輪廻のタロットネコ","Tカード同好会","りんねのたろっとねこ","てぃーかーどどうこうかい"),
		new Kikaku(536,Place.PLACE_44,Kind.MUSIC,"鳴弦の儀","弓術部","めいげんのぎ","きゅうじゅつぶ"),
		new Kikaku(537,Place.PLACE_6,Kind.CULTURE,"医学部四年生五月祭企画","医学部医学科四年生","いがくぶよねんせいごがつさいきかく","いがくぶいがくかよねんせい"),
		new Kikaku(538,Place.PLACE_1,Kind.MUSIC,"東京大学合氣道会五月祭大演武会","合氣道会","とうきょうだいがくあいきどうかいごがつさいだいえんぶかい","あいきどうかい"),
		new Kikaku(540,Place.PLACE_8,Kind.MOGI,"2010年度　文１・２　１０組","文ⅠⅡ10組","ぶんいちに　じゅっくみ","ぶん1 2 10くみ"),
		new Kikaku(541,Place.PLACE_29,Kind.MUSIC,"KOMAMO'12","Fruth","こまも","ふるーす"),
		new Kikaku(541,Place.PLACE_48,Kind.MUSIC,"KOMAMO'12","Fruth","こまも","ふるーす"),
		new Kikaku(542,Place.PLACE_35,Kind.CULTURE,"けんぴー","研究プロデュースゼミ","けんぴー","けんきゅうぷろでゅーすぜみ"),
		new Kikaku(543,Place.PLACE_36,Kind.MUSIC,"フルート喫茶","フルート同好会","ふるーときっさ","ふるーとどうこうかい"),
		new Kikaku(544,Place.PLACE_57,Kind.MOGI,"ベスターの焼鳥","ベスターT.T.","べすたーのやきとり","べすたーてにすちーむ"),
		new Kikaku(545,Place.PLACE_32,Kind.MOGI,"麦の伝道師","駒場麦酒研究会","むぎのでんどうし","こまばばくしゅけんきゅうかい"),
		new Kikaku(546,Place.PLACE_35,Kind.CULTURE,"成瀬心美トークショー","成瀬心美同好会東大支部","なるせここみとーくしょー","なるせここみどうこうかいとうだいしぶ"),
		new Kikaku(546,Place.PLACE_37,Kind.CULTURE,"成瀬心美トークショー","成瀬心美同好会東大支部","なるせここみとーくしょー","なるせここみどうこうかいとうだいしぶ"),
		new Kikaku(547,Place.PLACE_50,Kind.MOGI,"トーストのからあげ","トースト","とーすとのからあげ","とーすと"),
		new Kikaku(548,Place.PLACE_57,Kind.MOGI,"炎の焼きラーメン","なかよしさいくる","ほのおのやきらーめん","なかよしさいくる"),
		new Kikaku(549,Place.PLACE_14,Kind.MUSIC,"きじねこりんプロジェクト","理一５組","きじねこりんぷろじぇくと","りいちごくみ"),
		new Kikaku(549,Place.PLACE_29,Kind.MUSIC,"きじねこりんプロジェクト","理一５組","きじねこりんぷろじぇくと","りいちごくみ"),
		new Kikaku(550,Place.PLACE_32,Kind.CULTURE,"月刊『恒河沙』の販売","時代錯誤社","げっかん『こうかしゃ』のはんばい","じだいさくごしゃ"),
		new Kikaku(551,Place.PLACE_32,Kind.MOGI,"茶柱","国際交流サークル茶柱","ちゃばしら","とうきょうだいがくこくさいこうりゅうさーくるちゃばしら"),
		new Kikaku(553,Place.PLACE_35,Kind.CULTURE,"土井香苗ゼミ　講演会","土井香苗ゼミ","どいかなえぜみ　こうえんかい","どいかなえぜみ"),
		new Kikaku(553,Place.PLACE_35,Kind.CULTURE,"土井香苗ゼミ　講演会","土井香苗ゼミ","どいかなえぜみ　こうえんかい","どいかなえぜみ"),
		new Kikaku(553,Place.PLACE_37,Kind.CULTURE,"土井香苗ゼミ　講演会","土井香苗ゼミ","どいかなえぜみ　こうえんかい","どいかなえぜみ"),
		new Kikaku(553,Place.PLACE_37,Kind.CULTURE,"土井香苗ゼミ　講演会","土井香苗ゼミ","どいかなえぜみ　こうえんかい","どいかなえぜみ"),
		new Kikaku(554,Place.PLACE_14,Kind.MUSIC,"文三６組＋１","文三６組＋１","ぶんさんろっくみぷらすいち","ぶんさんろっくみぷらすいち"),
		new Kikaku(556,Place.PLACE_36,Kind.CULTURE,"あっとはんど手芸バザー","あっとはんど","あっとはんどしゅげいばざー","あっとはんど"),
		new Kikaku(557,Place.PLACE_38,Kind.MOGI,"だーつ","スケート部アイスホッケー部門","だーつ","すけーとぶあいすほっけーぶもん"),
		new Kikaku(558,Place.PLACE_35,Kind.CULTURE,"「国防」講演会","国家安全保障研究会","こくぼうこうえんかい","こっかあんぜんほしょうけんきゅうかい"),
		new Kikaku(558,Place.PLACE_37,Kind.CULTURE,"「国防」講演会","国家安全保障研究会","こくぼうこうえんかい","こっかあんぜんほしょうけんきゅうかい"),
		new Kikaku(559,Place.PLACE_36,Kind.MUSIC,"演劇・映画・雑誌団体","ここに顔","えんげき・えいが・ざっしだんたい","ここにかお"),
		new Kikaku(560,Place.PLACE_14,Kind.MUSIC,"Cocktail","合唱団あらぐさ","かくてる","がっしょうだんあらぐさ"),
		new Kikaku(561,Place.PLACE_1,Kind.MUSIC,"東京大学運動会空手部五月祭大演武会","空手部","とうきょうだいがくうんどうかいごがつさいだいえんぶかい","からてぶ"),
		new Kikaku(562,Place.PLACE_20,Kind.CULTURE,"五月祭ロボコン","工学部丁友会RoboTech","ごがつさいろぼこん","こうがくぶていゆうかい　ろぼてっく"),
		new Kikaku(563,Place.PLACE_20,Kind.CULTURE,"学内企画","WORLD CITIZEN","がくないきかく","わーるどしてぃずん"),
		new Kikaku(565,Place.PLACE_20,Kind.CULTURE,"フォーミュラカー展示","フォーミュラファクトリー","ふぉーみゅらかーてんじ","ふぉーみゅらふぁくとりー"),
		new Kikaku(566,Place.PLACE_26,Kind.MOGI,"アールの焼きそば","HALE","あーるのやきそば","あーる"),
		new Kikaku(568,Place.PLACE_52,Kind.MOGI,"利き酒2012","農2 4年生","ききざけ2012","のうによねんせい"),
		new Kikaku(569,Place.PLACE_57,Kind.MOGI,"海洋研究会","海洋研究会","かいようけんきゅうかい","かいようけんきゅうかい"),
		new Kikaku(570,Place.PLACE_32,Kind.MOGI,"じゃがバター屋台プロジェクト","日本教育再興連盟","じゃがばたーやたいぷろじぇくと","にほんきょういくさいこうれんめい"),
		new Kikaku(571,Place.PLACE_32,Kind.CULTURE,"文芸・同人誌即売会","出版系サークル合同企画","ぶんげい・どうじんしそくばいかい","しゅっぱんけいさーくるごうどうきかく"),
		new Kikaku(572,Place.PLACE_38,Kind.MOGI,"ハワイアン　ホットドック","フラサークルkawelina","はわいあんほっとどっく","ふらさーくるかぶぇりな"),
		new Kikaku(573,Place.PLACE_36,Kind.CULTURE,"五月祭合同華展","華道部、華道弥生会","ごがつさいごうどうかてん","かどうぶ、かどうやよいかい"),
		new Kikaku(574,Place.PLACE_13,Kind.CULTURE,"立木秀学講演会","Happy Science","ついきしゅうがくこうえんかい","はっぴーさいえんす"),
		new Kikaku(575,Place.PLACE_1,Kind.MUSIC,"鹿島神流演武","鹿島神流","かしましんりゅうえんぶ","かしましんりゅう"),
		new Kikaku(576,Place.PLACE_32,Kind.MOGI,"ひこうせんの焼きそば","ひこうせん","ひこうせんのやきそば","ひこうせん"),
		new Kikaku(577,Place.PLACE_10,Kind.MUSIC,"アコースティックライヴ","三年有志","あこーすてぃっくらいぶ","さんねんゆうし"),
		new Kikaku(578,Place.PLACE_9,Kind.MOGI,"バードストライク","航空部","ばーどすとらいく","こうくうぶ"),
		new Kikaku(579,Place.PLACE_26,Kind.MOGI,"台湾の夜市人生","台湾留学生会","たいわんのよいちじんせい","たいわんりゅうがくせいかい"),
		new Kikaku(580,Place.PLACE_51,Kind.MOGI,"植木市","森林科学専攻４年","うえきいち","しんりんかがくせんこうよねん"),
		new Kikaku(580,Place.PLACE_56,Kind.MOGI,"植木市","森林科学専攻４年","うえきいち","しんりんかがくせんこうよねん"),
		new Kikaku(581,Place.PLACE_26,Kind.MOGI,"ペイサーズ","ペイサーズ","ぺいさーず","ぺいさーず"),
		new Kikaku(582,Place.PLACE_10,Kind.MUSIC,"KaWelinaフラステージ","フラサークルKaWelina","かヴぇりなふらすてーじ","ふらさーくるかぶぇりな"),
		new Kikaku(582,Place.PLACE_10,Kind.MUSIC,"KaWelinaフラステージ","フラサークルKaWelina","かヴぇりなふらすてーじ","ふらさーくるかぶぇりな"),
		new Kikaku(582,Place.PLACE_23,Kind.MUSIC,"KaWelinaフラステージ","フラサークルKaWelina","かヴぇりなふらすてーじ","ふらさーくるかぶぇりな"),
		new Kikaku(583,Place.PLACE_14,Kind.MUSIC,"BURST!!!","ジャズダンスサークルFreeD","ばーすと","じゃずだんすさーくるふりーでぃー"),
		new Kikaku(583,Place.PLACE_22,Kind.MUSIC,"BURST!!!","ジャズダンスサークルFreeD","ばーすと","じゃずだんすさーくるふりーでぃー"),
		new Kikaku(583,Place.PLACE_35,Kind.MUSIC,"BURST!!!","ジャズダンスサークルFreeD","ばーすと","じゃずだんすさーくるふりーでぃー"),
		new Kikaku(585,Place.PLACE_2,Kind.MOGI,"けばぶ君のケバブ","リコーダー同好会と文ⅠⅡ２６組","けばぶくんのけばぶ","りこーだーどうこうかいとぶんいちににじゅうろっくみ"),
		new Kikaku(586,Place.PLACE_32,Kind.MOGI,"ウッドペッカーアメリカンドッグ","ウッドペッカー","うっどぺっかーあめりかんどっぐ","うっどぺっかー"),
		new Kikaku(587,Place.PLACE_14,Kind.MUSIC,"Live at UTMF","maara","らいぶあっとゆーてぃーえむえふ","まーら"),
		new Kikaku(588,Place.PLACE_47,Kind.MUSIC,"東大POMP　五月祭ライブ","POMP","とうだいぽんぷ　ごがつさいらいぶ","ぽんぷ"),
		new Kikaku(588,Place.PLACE_47,Kind.MUSIC,"東大POMP　五月祭ライブ","POMP","とうだいぽんぷ　ごがつさいらいぶ","ぽんぷ"),
		new Kikaku(589,Place.PLACE_49,Kind.MOGI,"ゆみの会のふわふわ時間","ゆみの会","ゆみのかいのふわふわたいむ","ゆみのかい"),
		new Kikaku(590,Place.PLACE_2,Kind.MOGI,"ベトナムの香り","ベトナム人留学生会","べとなむのかおり","べとなむじんりゅうがくせいかい"),
		new Kikaku(591,Place.PLACE_51,Kind.CULTURE,"地域主義とグローバリゼーションを考える","Linking East Asian Future","ちきしゅぎとぐろーばりぜーしょんをかんがえる","りんきんぐいーすとえいじゃんふゅーちゃー"),
		new Kikaku(591,Place.PLACE_51,Kind.CULTURE,"地域主義とグローバリゼーションを考える","Linking East Asian Future","ちきしゅぎとぐろーばりぜーしょんをかんがえる","りんきんぐいーすとえいじゃんふゅーちゃー"),
		new Kikaku(591,Place.PLACE_51,Kind.CULTURE,"地域主義とグローバリゼーションを考える","Linking East Asian Future","ちきしゅぎとぐろーばりぜーしょんをかんがえる","りんきんぐいーすとえいじゃんふゅーちゃー"),
		new Kikaku(591,Place.PLACE_51,Kind.CULTURE,"地域主義とグローバリゼーションを考える","Linking East Asian Future","ちきしゅぎとぐろーばりぜーしょんをかんがえる","りんきんぐいーすとえいじゃんふゅーちゃー"),
		new Kikaku(592,Place.PLACE_22,Kind.CULTURE,"真剣東大しゃべり場　-科学について-","SITP2012","しんけんとうだいしゃべりば　-かがくについて-","えすあいてぃーぴーにせんじゅうに"),
		new Kikaku(593,Place.PLACE_16,Kind.MUSIC,"東京大学ピアノの会五月祭大演奏会","ピアノの会","とうきょうだいがくぴあののかいごがつさいだいえんそうかい","ぴあののかい"),
		new Kikaku(593,Place.PLACE_16,Kind.MUSIC,"東京大学ピアノの会五月祭大演奏会","ピアノの会","とうきょうだいがくぴあののかいごがつさいだいえんそうかい","ぴあののかい"),
		new Kikaku(593,Place.PLACE_16,Kind.MUSIC,"東京大学ピアノの会五月祭大演奏会","ピアノの会","とうきょうだいがくぴあののかいごがつさいだいえんそうかい","ぴあののかい"),
		new Kikaku(593,Place.PLACE_25,Kind.MUSIC,"東京大学ピアノの会五月祭大演奏会","ピアノの会","とうきょうだいがくぴあののかいごがつさいだいえんそうかい","ぴあののかい"),
		new Kikaku(593,Place.PLACE_25,Kind.MUSIC,"東京大学ピアノの会五月祭大演奏会","ピアノの会","とうきょうだいがくぴあののかいごがつさいだいえんそうかい","ぴあののかい"),
		new Kikaku(594,Place.PLACE_49,Kind.MOGI,"焼烤小陽関","中国語中国文学研究室","しゃおかおしゃおやんぐあん","ちゅうごくごちゅうごくぶんがくけんきゅうしつ"),
		new Kikaku(596,Place.PLACE_26,Kind.MOGI,"イラン・バザール","イラン学生友会","いらんばざぁる","いらんがくせいゆうかい"),
		new Kikaku(597,Place.PLACE_28,Kind.MUSIC,"サッカー招待試合","ア式蹴球部","さっかーしょうたいじあい","あしきしゅうきゅうぶ"),
		new Kikaku(598,Place.PLACE_50,Kind.MOGI,"じゅう獣焼き","獣医3年","じゅうじゅうやき","じゅうい3ねん"),
		new Kikaku(599,Place.PLACE_57,Kind.MOGI,"ALL-UTのたい焼き！","ALL-UT","おーるゆーてぃーのたいやき！","おーるゆーてぃー"),
		new Kikaku(601,Place.PLACE_5,Kind.MOGI,"A-DASHのフランクフルト","A-DASH テニスクラブ","えーだっしゅのふらんくふると","えーだっしゅ てにすくらぶ"),
		new Kikaku(602,Place.PLACE_57,Kind.MOGI,"マレーシア料理店","マレーシア留学生会","まれーしありょうりてん","まれーしありゅうがくせいかい"),
		new Kikaku(603,Place.PLACE_19,Kind.CULTURE,"SIM研究発表","工学部システム創成学科数理・シミュレーションコース","しむけんきゅうはっぴょう","こうがくぶしすてむそうせいがっかすうりしみゅれーしょんこーす"),
		new Kikaku(605,Place.PLACE_57,Kind.MOGI,"FX牛串","学生投資活動団体SGT","えふえっくすぎゅうくし","がくせいとうしかつどうだんたいえすじーてぃー"),
		new Kikaku(606,Place.PLACE_26,Kind.MOGI,"うまいフランクフルト","弓道同好会","うまいふらんくふると","きゅうどうどうこうかい"),
		new Kikaku(607,Place.PLACE_26,Kind.MOGI,"エジプト文化展示","エジプト学生友会","えじぷとぶんかてんじ","えじぷとがくせいゆうかい"),
		new Kikaku(608,Place.PLACE_3,Kind.CULTURE,"TEDxUTokyo","TEDxUTokyo実行委員会","てでっくすゆーときょー","てでっくすゆーとーきょーじっこういいんかい"),
		new Kikaku(609,Place.PLACE_26,Kind.MOGI,"チュニジアへようこそ","チュニジア友会","ちゅにじあへようこそ","ちゅにじあゆうかい"),
		new Kikaku(610,Place.PLACE_26,Kind.MOGI,"バナナ巻くがや、揚げるがや、食べるがや","社会基盤学科有志","ばななまくがや、あげるがや、たべるがや","しゃかいきばんがっかゆうし"),
		new Kikaku(611,Place.PLACE_18,Kind.MOGI,"精密WORLD！","精密工学科","せいみつわーるど","せいみつこうがくか"),
		new Kikaku(612,Place.PLACE_26,Kind.MOGI,"ボーダーかき氷","スノーボーダー","ぼーだーかきごおり","すのーぼーだー"),
		new Kikaku(613,Place.PLACE_35,Kind.CULTURE,"リーダーシップ～今、何をすべきか～","グローバル・ネクストリーダーズ・フォーラム","りーだーしっぷ～いま、なにをすべきか～","ぐろーばるねくすとりーだーずふぉーらむ"),
		new Kikaku(613,Place.PLACE_37,Kind.CULTURE,"リーダーシップ～今、何をすべきか～","グローバル・ネクストリーダーズ・フォーラム","りーだーしっぷ～いま、なにをすべきか～","ぐろーばるねくすとりーだーずふぉーらむ"),
		new Kikaku(614,Place.PLACE_57,Kind.MOGI,"牛串","DNL","ぎゅうくし","でぃーえぬえる"),
		new Kikaku(615,Place.PLACE_35,Kind.CULTURE,"呉智英のつぎはぎ仏教マンガ入門","仏教青年会","くれともふさのつぎはぎぶっきょうまんがにゅうもん","ぶっきょうせいねんかい"),
		new Kikaku(615,Place.PLACE_37,Kind.CULTURE,"呉智英のつぎはぎ仏教マンガ入門","仏教青年会","くれともふさのつぎはぎぶっきょうまんがにゅうもん","ぶっきょうせいねんかい"),
		new Kikaku(616,Place.PLACE_49,Kind.MOGI,"ユータスくん大判焼き","射撃部","ゆーたすくんおおばんやき","しゃげきぶ"),
		new Kikaku(617,Place.PLACE_19,Kind.CULTURE,"エネルギーカードゲーム！","学生団体STEP","えねるぎーかーどげーむ","がくせいだんたいすてっぷ"),
		new Kikaku(618,Place.PLACE_12,Kind.MUSIC,"ももコマ春の一大事2012","ももいろコマーバーZ","ももこまはるのいちだいじにせんじゅうに","ももいろこまーばーぜっと"),
		new Kikaku(618,Place.PLACE_14,Kind.MUSIC,"ももコマ春の一大事2012","ももいろコマーバーZ","ももこまはるのいちだいじにせんじゅうに","ももいろこまーばーぜっと"),
		new Kikaku(619,Place.PLACE_12,Kind.MUSIC,"安田講堂前バンド","B'z","やすだこうどうまえばんど","びーず"),
		new Kikaku(619,Place.PLACE_14,Kind.MUSIC,"安田講堂前バンド","B'z","やすだこうどうまえばんど","びーず"),
		new Kikaku(620,Place.PLACE_9,Kind.MOGI,"やきそば","Windy Bounds","やきそば","うぃんでぃーばうんず"),
		new Kikaku(621,Place.PLACE_26,Kind.CULTURE,"ムスリム・バザール模擬店","イスラム文化研究会(2)","むすりむ・ばざぁるもぎてん","いすらむぶんかけんきゅうかい2"),
		new Kikaku(623,Place.PLACE_25,Kind.CULTURE,"社会科学系有志研究発表","社会科学系院生有志","しゃかいかがくけいゆうしけんきゅうはっぴょう","しゃかいかがくけいいんせいゆうし"),
		new Kikaku(626,Place.PLACE_14,Kind.MUSIC,"Break Out","ストリートダンスサークル Boiled","ぶれーくあうと","すとりーとだんすさーくる ぼいるど"),
		new Kikaku(626,Place.PLACE_37,Kind.MUSIC,"Break Out","ストリートダンスサークル Boiled","ぶれーくあうと","すとりーとだんすさーくる ぼいるど"),
		new Kikaku(626,Place.PLACE_51,Kind.MUSIC,"Break Out","ストリートダンスサークル Boiled","ぶれーくあうと","すとりーとだんすさーくる ぼいるど"),
		new Kikaku(626,Place.PLACE_55,Kind.MUSIC,"Break Out","ストリートダンスサークル Boiled","ぶれーくあうと","すとりーとだんすさーくる ぼいるど"),
		new Kikaku(628,Place.PLACE_26,Kind.MOGI,"フランスのクレープ","東大のヨーロッパの学生の団体","ふらんすのくれえぷ","とおだいのよおろっぱのがくせいのだんたい"),
		new Kikaku(629,Place.PLACE_47,Kind.MUSIC,"コントリーマアム","コントリーマアム","こんとりーまあむ","こんとりーまあむ"),
		new Kikaku(629,Place.PLACE_47,Kind.MUSIC,"コントリーマアム","コントリーマアム","こんとりーまあむ","こんとりーまあむ"),
		new Kikaku(629,Place.PLACE_47,Kind.MUSIC,"コントリーマアム","コントリーマアム","こんとりーまあむ","こんとりーまあむ"),
		new Kikaku(630,Place.PLACE_8,Kind.MOGI,"AirWalkのフランクフルト！","Airwalk","えあうぉーくのふらんくふると！","えあうぉーく"),
		new Kikaku(630,Place.PLACE_35,Kind.MOGI,"AirWalkのフランクフルト！","Airwalk","えあうぉーくのふらんくふると！","えあうぉーく"),
		new Kikaku(630,Place.PLACE_35,Kind.MOGI,"AirWalkのフランクフルト！","Airwalk","えあうぉーくのふらんくふると！","えあうぉーく"),
		new Kikaku(631,Place.PLACE_8,Kind.MOGI,"TEIYU たこ焼き","丁友会テニス部","ていゆうたこやき","ていゆうかいてにすぶ"),
		new Kikaku(632,Place.PLACE_2,Kind.MOGI,"オカラ・デ・ポン","環境三四郎","おから・で・ぽん","かんきょうさんしろう"),
		new Kikaku(634,Place.PLACE_47,Kind.MUSIC,"東大音感五月祭ライブ","音感","とうだいおんかんごがつさいらいぶ","おんかん"),
		new Kikaku(634,Place.PLACE_47,Kind.MUSIC,"東大音感五月祭ライブ","音感","とうだいおんかんごがつさいらいぶ","おんかん"),
		new Kikaku(635,Place.PLACE_36,Kind.MOGI,"★国関相関が送る「世界ふ酒ぎ発見」","教養学部総合社会科学科","こっかんそうかんがおくるせかいふしゅぎはっけん","きょうようがくぶそうごうしゃかいかがっか"),
		new Kikaku(636,Place.PLACE_5,Kind.MOGI,"けんずばー","スポーツ愛好会22","すぽーつ愛好会22","すぽーつあいこうかい22"),
		new Kikaku(637,Place.PLACE_50,Kind.MOGI,"Кремль","日本ロシア学生交流会","くれむりん","にほんろしあがくせいこうりゅうかい"),
		new Kikaku(639,Place.PLACE_49,Kind.MOGI,"セローリのサイコロステーキ","セローリ","せろーりのさいころすてーき","せろーり"),
		new Kikaku(641,Place.PLACE_38,Kind.MOGI,"Food Trip: More Fun in the Philippines","フィリピン留学生協会","ふーど　とりっぷ：　もあ　ふぁん　いん　ふぃりぴん","ふぃりぴんりゅうがくせいきょうかい"),
		new Kikaku(642,Place.PLACE_47,Kind.MOGI,"Bar Chuchu","法学部三類懇親会","ばーちゅうちゅう","ほうがくぶさんるいこんしんかい"),
		new Kikaku(643,Place.PLACE_14,Kind.MUSIC,"あげぽよちゃん","あげぽよちゃん","あげぽよちゃん","あげぽよちゃん"),
		new Kikaku(644,Place.PLACE_32,Kind.MOGI,"ｓ１３６","理Ⅰ36組","りいちさんじゅうろく","り1 36くみ"),
		new Kikaku(645,Place.PLACE_50,Kind.MOGI,"てにぱ","スポーツ愛好会テニスパート","てにぱ","すぽーつあいこうかいてにすぱーと"),
		new Kikaku(646,Place.PLACE_56,Kind.MOGI,"伊豆の石窯ピザ屋","全学体験ゼミナール「伊豆に学ぶ」","いずのいしがまぴざや","ぜんがくたいけんぜみなーる「いずにまなぶ」ゆうし"),
		new Kikaku(647,Place.PLACE_50,Kind.MOGI,"Speranza.FC～嵐の屋台～","Speranza.FC","すぺらんつぁえふしー","すぺらんつぁえふしー"),
		new Kikaku(648,Place.PLACE_47,Kind.MOGI,"ファッションゼミ","ファッションゼミ","ふぁっしょんぜみ","ふぁっしょんぜみ"),
		new Kikaku(649,Place.PLACE_41,Kind.CULTURE,"初めて作る！生物フィギュア","2012度東京大学理学部生物学科","はじめてつくる！せいぶつふぃぎゅあ","りがくぶせいぶつがっか"),
		new Kikaku(650,Place.PLACE_25,Kind.MUSIC,"ダブルダッチの宴 in 五月祭2012","D-act","だぶるだっちのうたげ　いんごがつさいにせんじゅうに","でぃーあくと"),
		new Kikaku(650,Place.PLACE_27,Kind.MUSIC,"ダブルダッチの宴 in 五月祭2012","D-act","だぶるだっちのうたげ　いんごがつさいにせんじゅうに","でぃーあくと"),
		new Kikaku(650,Place.PLACE_27,Kind.MUSIC,"ダブルダッチの宴 in 五月祭2012","D-act","だぶるだっちのうたげ　いんごがつさいにせんじゅうに","でぃーあくと"),
		new Kikaku(650,Place.PLACE_27,Kind.MUSIC,"ダブルダッチの宴 in 五月祭2012","D-act","だぶるだっちのうたげ　いんごがつさいにせんじゅうに","でぃーあくと"),
		new Kikaku(650,Place.PLACE_27,Kind.MUSIC,"ダブルダッチの宴 in 五月祭2012","D-act","だぶるだっちのうたげ　いんごがつさいにせんじゅうに","でぃーあくと"),
		new Kikaku(650,Place.PLACE_27,Kind.MUSIC,"ダブルダッチの宴 in 五月祭2012","D-act","だぶるだっちのうたげ　いんごがつさいにせんじゅうに","でぃーあくと"),
		new Kikaku(650,Place.PLACE_27,Kind.MUSIC,"ダブルダッチの宴 in 五月祭2012","D-act","だぶるだっちのうたげ　いんごがつさいにせんじゅうに","でぃーあくと"),
		new Kikaku(651,Place.PLACE_35,Kind.CULTURE,"東京大学法律相談所交流会","法律相談所","とうきょうだいがくほうりつそうだんしょこうりゅうかい","ほうりつそうだんじょ"),
		new Kikaku(652,Place.PLACE_16,Kind.MUSIC,"イタリアを歌う","ベルカント研究ゼミナール","いたりあをうたう","べるかんとけんきゅうぜみなーる"),
		new Kikaku(652,Place.PLACE_25,Kind.MUSIC,"イタリアを歌う","ベルカント研究ゼミナール","いたりあをうたう","べるかんとけんきゅうぜみなーる"),
		new Kikaku(652,Place.PLACE_25,Kind.MUSIC,"イタリアを歌う","ベルカント研究ゼミナール","いたりあをうたう","べるかんとけんきゅうぜみなーる"),
		new Kikaku(653,Place.PLACE_10,Kind.MUSIC,"ダンス・パフォーマンス　- 春の祭典","Komaba Performing Arts Studies","だんす・ぱふぉーまんす　はるのさいてん","こまば　ぱふぉーみんぐ　あーつ　すたでぃーず"),
		new Kikaku(653,Place.PLACE_55,Kind.MUSIC,"ダンス・パフォーマンス　- 春の祭典","Komaba Performing Arts Studies","だんす・ぱふぉーまんす　はるのさいてん","こまば　ぱふぉーみんぐ　あーつ　すたでぃーず"),
		new Kikaku(654,Place.PLACE_51,Kind.CULTURE,"夢ランドボンナー7人の雀聖","何でも愛好会麻雀パート","ゆめらんどぼんなーしちにんのじゃんせい","なんでもあいこうかいまーじゃんぱーと"),
		new Kikaku(655,Place.PLACE_36,Kind.MOGI,"占い・喫茶　憩いの里","学生団体NEXT","うらないきっさいこいのさと","がくせいだんたいねくすと"),
		new Kikaku(656,Place.PLACE_32,Kind.MOGI,"理一21組","理Ⅰ21組","りいちにじゅういちくみ","り1 21くみ"),
		new Kikaku(657,Place.PLACE_36,Kind.CULTURE,"ぼらんたす","ぼらんたす","ぼらんたす","ぼらんたす"),
		new Kikaku(658,Place.PLACE_14,Kind.MUSIC,"MILIN","s2-13","みりん","えすにじゅうさん"),
		new Kikaku(662,Place.PLACE_20,Kind.CULTURE,"東大ガイダンス2012@五月祭","ガイダンス運営委員会","とうだいがいだんす2012あっとごがつさい","がいだんすうんえいいいんかい"),
		new Kikaku(663,Place.PLACE_36,Kind.CULTURE,"挑戦的映画劇場","映画制作スピカ１８９５","ちょうせんてきえいがげきじょう","えいがせいさくすぴかいちはちきゅうご"),
		new Kikaku(664,Place.PLACE_26,Kind.MOGI,"しゅわっちさん家のたい焼き","手話サークルしゅわっち","しゅわっちさんちのたいやき","しゅわさーくるしゅわっち"),
		new Kikaku(666,Place.PLACE_19,Kind.CULTURE,"教養とはなにか—佐々木中講演会","見聞伝ゼミナール","きょうようとはなにか—ささきあたるこうえんかい","けんぶんでんぜみなーる"),
		new Kikaku(667,Place.PLACE_25,Kind.MOGI,"帰ってきたビール万国博覧会","しばっちFC","かえってきたびーるばんこくはくらんかい","しばっちえふしー"),
		new Kikaku(668,Place.PLACE_27,Kind.MUSIC,"まるみ-In Tokyo-","まるみ","まるみいんとうきょう","まるみ"),
		new Kikaku(668,Place.PLACE_55,Kind.MUSIC,"まるみ-In Tokyo-","まるみ","まるみいんとうきょう","まるみ"),
		new Kikaku(668,Place.PLACE_55,Kind.MUSIC,"まるみ-In Tokyo-","まるみ","まるみいんとうきょう","まるみ"),
		new Kikaku(669,Place.PLACE_57,Kind.MOGI,"カステラ手すか","理ⅡⅢ15組","かすてらですか","り2 3 15くみ"),
		new Kikaku(670,Place.PLACE_57,Kind.MOGI,"ナマステインディア","東京大学インド学生協会","なますていんでぃあ","いんどがくせいきょうかい"),
		new Kikaku(672,Place.PLACE_50,Kind.MOGI,"焼き饂飩展","うどん部","やきうどんてん","うどんぶ"),
		new Kikaku(674,Place.PLACE_50,Kind.MOGI,"アイセック屋台","アイセック東京大学委員会","あいせっくやたい","あいせっくとうきょうだいがくいいんかい"),
		new Kikaku(675,Place.PLACE_50,Kind.MOGI,"BLENDY屋台","BLENDY","ぶれんでぃーやたい","ぶれんでぃー"),
		new Kikaku(676,Place.PLACE_50,Kind.MOGI,"クレヨンの焼きそば！","クレヨン","くれよんのやきそば","くれよん"),
		new Kikaku(678,Place.PLACE_50,Kind.MOGI,"クラウドナインのカットパイン","クラウドナイン","くらうどないんのかっとぱいん","くらうどないん"),
		new Kikaku(679,Place.PLACE_50,Kind.MOGI,"世界のビール","E&E","せかいのびーる","いーあんどいー"),
		new Kikaku(680,Place.PLACE_50,Kind.MOGI,"kmb４８","kmb４８","けーえむびーふぉーてぃーえいと","けいえむびいふぉーてぃーえいと"),
		new Kikaku(681,Place.PLACE_36,Kind.MOGI,"シルクロードの最終の目的地:トルコ","トルコ協会","しるくろーどのさいごのもくてきち:とるこ","とるこきょうかい"),
		new Kikaku(682,Place.PLACE_35,Kind.CULTURE,"オセロのGORO","オセロサークルGORO","おせろのゴロー","おせろサークルゴロー"),
		new Kikaku(683,Place.PLACE_36,Kind.CULTURE,"サステナ環境フォーラム","SUS+","さすてなかんきょうふぉーらむ","さすぷらす"),
		new Kikaku(684,Place.PLACE_26,Kind.MOGI,"Hot spurs 模擬店","Hot Spurs","ほっとすぱあずもぎてん","ほっとすぱあず"),
		new Kikaku(685,Place.PLACE_20,Kind.CULTURE,"環境・エネルギーポスター発表","学生団体STEP","かんきょう・えねるぎーぽすたーはっぴょう","がくせいだんたいすてっぷ"),
		new Kikaku(687,Place.PLACE_47,Kind.MUSIC,"五月祭演奏会","尺八部","ごがつさいえんそうかい","しゃくはちぶ"),
		new Kikaku(687,Place.PLACE_47,Kind.MUSIC,"五月祭演奏会","尺八部","ごがつさいえんそうかい","しゃくはちぶ"),
		new Kikaku(687,Place.PLACE_47,Kind.MUSIC,"五月祭演奏会","尺八部","ごがつさいえんそうかい","しゃくはちぶ"),
		new Kikaku(689,Place.PLACE_26,Kind.MOGI,"男気ご飯","ランチ愛好会","おとこぎごはん","らんちあいこうかい"),
		new Kikaku(690,Place.PLACE_50,Kind.MOGI,"ぼぎーずのスップリ","BOGEYS","ぼぎーずのスップリ","ぼぎーず"),
		new Kikaku(691,Place.PLACE_23,Kind.CULTURE,"東京大学神社・神道研究会　神楽部会発表","神社神道研究会","じんじゃしんとうけんきゅうかいかぐらぶかいはっぴょう","じんじゃしんとうけんきゅうかい"),
		new Kikaku(691,Place.PLACE_27,Kind.CULTURE,"東京大学神社・神道研究会　神楽部会発表","神社神道研究会","じんじゃしんとうけんきゅうかいかぐらぶかいはっぴょう","じんじゃしんとうけんきゅうかい"),
		new Kikaku(692,Place.PLACE_50,Kind.MOGI,"bootles","beatle mania","ぶトルズ","びーとるマニア"),
		new Kikaku(694,Place.PLACE_56,Kind.MOGI,"世界のバイオエタノール(販売有)","生物・環境工学専修","せかいのばいおえたのーる","せいぶつかんきょうこうがくせんしゅう"),
		new Kikaku(695,Place.PLACE_56,Kind.MOGI,"伊豆の燻製屋","伊豆ゼミ","いずのくんせいや","いずぜみ"),
		new Kikaku(696,Place.PLACE_14,Kind.MUSIC,"タピオカ飲んでバンド","文科三類19組","たぴおかのんでばんど","とうきょうだいがくぶんかさんるいじゅうきゅうくみ"),
		new Kikaku(697,Place.PLACE_10,Kind.MUSIC,"新サークル笑論法　お笑い初ライブ","お笑いライブプロデュースサークル　笑論法","しんさーくるしょうろんぽう　おわらいはつらいぶ","おわらいらいぶぷろでゅーすさーくる　しょうろんぽう"),
		new Kikaku(698,Place.PLACE_21,Kind.MUSIC,"研究展示「マテリアルを体感してみよう」","工学部マテリアル工学科","けんきゅうてんじまてりあるをたいかんしてみよう","こうがくぶまてりあるこうがくか"),
		new Kikaku(801,Place.PLACE_57,Kind.MOGI,"肉みそモッフル","2012年度入学理科一類14組","にくみそもっふる","にせんじゅうにねんどにゅうがくりかいちるいじゅうよんくみ"),
		new Kikaku(802,Place.PLACE_57,Kind.MOGI,"やきそバブ","2012年度入学理科二・三類20組","やきそばぶ","にせんじゅうにねんどにゅうがくりかにさんるいにじっくみ"),
		new Kikaku(803,Place.PLACE_9,Kind.MOGI,"赤門餃子","2012年度入学文科一・二類15組","あかもんぎょうざ","にせんじゅうにねんどにゅうがくぶんかいちにるいじゅうごくみ"),
		new Kikaku(804,Place.PLACE_38,Kind.MOGI,"ああ、からあげ。。","2012年度入学理科二・三類16組","ああ、からあげ。。","にせんじゅうにねんどにゅうがくりかにさんるいじゅうろくくみ"),
		new Kikaku(805,Place.PLACE_38,Kind.MOGI,"元祖・原田の焼きそば","2012年度入学理科一類21組","がんそはらだのやきそば","りかいちるいにじゅういちくみ"),
		new Kikaku(806,Place.PLACE_32,Kind.MOGI,"じゃがぱち","2012年度入学理科二・三類18組","じゃがぱち","にせんじゅうにねんどにゅうがくりかにさんるいじゅうはちくみ"),
		new Kikaku(807,Place.PLACE_26,Kind.MOGI,"タピオカの泉","2012年度入学文科一・二類8組","たぴおかのいずみ","にせんじゅうにねんどぶんかいちにるいはちくみ"),
		new Kikaku(808,Place.PLACE_2,Kind.MOGI,"金環どおなっつ","2012年度入学理科一類38組","きんかんどおなっつ","にせんじゅうにねんどにゅうがくりかいちるいさんじゅうはちくみ"),
		new Kikaku(809,Place.PLACE_8,Kind.MOGI,"たいやきやいた","2012年度入学理科二・三類10組","たいやきやいた","にせんじゅうにねんどにゅうがくりかにさんるいじっくみ"),
		new Kikaku(810,Place.PLACE_26,Kind.MOGI,"みっしょんいんもっふる","2012年度入学理科一類9組","みっしょんいんもっふる","にせんじゅうにねんどにゅうがくりかいちるいきゅうくみ"),
		new Kikaku(811,Place.PLACE_8,Kind.MOGI,"WcDonald","2012年度入学理科一類20組","わくどなるど","にせんじゅうにねんどにゅうがくりかいちるいにじゅっくみ"),
		new Kikaku(812,Place.PLACE_9,Kind.MOGI,"UT～うまいたい焼き～","2012年度入学理科一類36組","ゆーてぃー～うまいたいやき～","にせんじゅうにねんどにゅうがくりかいちるい36くみ"),
		new Kikaku(813,Place.PLACE_57,Kind.MOGI,"本日特売日!おいしい今川焼のみせ","2012年度入学理科一類35組","ほんじつとくばいび!おいしいいまがわやきのみせ","にせんじゅうにねんどにゅうがくりかいちるいさんじゅうごくみ"),
		new Kikaku(815,Place.PLACE_38,Kind.MOGI,"★本郷焼き★","2012年度入学文科一・二類14組","ほんごうやき","にせんじゅうにねんどにゅうがくぶんかいち・にるいじゅうよんくみ"),
		new Kikaku(816,Place.PLACE_32,Kind.MOGI,"ゲルマンチュロス","2012年度入学文科一・二類21組","げるまんちゅろす","にせんじゅうにねんどにゅうがくぶんかいち・にるいにじゅういちくみ"),
		new Kikaku(817,Place.PLACE_49,Kind.MOGI,"ジャンボ牛串","2012年度入学文科一・二類20組","じゃんぼぎゅうくし","にせんじゅうにねんどにゅうがくぶんかいち・にるいにじっくみ"),
		new Kikaku(818,Place.PLACE_38,Kind.MOGI,"タピオカ屋荒木","2012年度入学文科三類8組","たぴおかやあらき","にせんじゅうにねんどにゅうがくぶんかさんるいはちくみ"),
		new Kikaku(819,Place.PLACE_2,Kind.MOGI,"シャカ＊シャカポテト","2012年度入学文科三類7組","しゃかしゃかぽてと","にせんじゅうにねんどにゅうがくぶんかさんるいななくみ"),
		new Kikaku(820,Place.PLACE_38,Kind.MOGI,"冷えたあなたに愛“揚げます”～揚げアイス～","2012年度入学理科一類26組","ひえたあなたにあいあげますあげあいす","にせんじゅうにねんどにゅうがくりかいちるいにじゅうろっくみ"),
		new Kikaku(821,Place.PLACE_38,Kind.MOGI,"焼き鳥屋 福ちゃん","2012年度入学理科一類15組","やきとりや ふくちゃん","にせんじゅうにねんどにゅうがくりかいちるいじゅうごくみ"),
		new Kikaku(822,Place.PLACE_8,Kind.MOGI,"チョコバナナBuono!!","2012年度入学理科二・三類15組","ちょこバナナボーノ","にせんじゅうにねんどにゅうがくりかにさんるいじゅうごくみ"),
		new Kikaku(823,Place.PLACE_26,Kind.MOGI,"ポップ☆コーン","2012年度入学理科二・三類13組","ぽっぷこーん","にせんじゅうにねんどにゅうがくりかにさんるいじゅうさんくみ"),
		new Kikaku(824,Place.PLACE_57,Kind.MOGI,"なんのこれしき…ピロシキ！","2012年度入学理科一・二・三類4組","なんのこれしきぴろしき","にせんじゅうにねんどにゅうがくりかいちにさんるいよんくみ"),
		new Kikaku(825,Place.PLACE_2,Kind.MOGI,"タピオカキッチン","2012年度入学理科一類23組","たぴおかきっちん","にせんじゅうにねんどにゅうがくりかいちるいにじゅうさんくみ"),
		new Kikaku(826,Place.PLACE_57,Kind.MOGI,"モッフル mucho gusto","2012年度入学文科三類9組","もっふる　むちょ　ぐすと","にせんジュウニネンドニュウガクブンカサンルイキュウクミ"),
		new Kikaku(827,Place.PLACE_8,Kind.MOGI,"焼きそば盛っCHINA","2012年度入学文一・二19組","やきそばもっちゃいな","ぶんいちにじゅうきゅうくみ"),
		new Kikaku(828,Place.PLACE_32,Kind.MOGI,"FrankなFrankfurt","2012年度入学理科一類28組","えふらんくなふらんくふると","にせんじゅうにねんどにゅうがくりかいちるいにじゅうはちくみ"),
		new Kikaku(829,Place.PLACE_32,Kind.MOGI,"えびせんバーガー","2012年度入学インタークラス","えびせんばーがー","いんたーくらす"),
		new Kikaku(830,Place.PLACE_57,Kind.MOGI,"くれーぷ屋さんきゅ","2012年度入学理科一類39組","くれーぷやさんきゅ","にせんじゅうにねんどにゅうがくりかいちるいさんじゅうきゅうくみ"),
		new Kikaku(831,Place.PLACE_32,Kind.MOGI,"五月祭名物クロックムッシュ","2012年度入学理科一類37組","ごがつさいめいぶつくろっくむっしゅ","にせんじゅうにねんどにゅうがくりかいちるいさんじゅうななくみ"),
		new Kikaku(832,Place.PLACE_9,Kind.MOGI,"スペナーナ・タピオカーナ","2012年度入学文科一・二類７組","すぺなーな・たぴおかーな","にせんじゅうにねんどぶんかいち・にるいななくみ"),
		new Kikaku(833,Place.PLACE_5,Kind.MOGI,"ぐっぴーの作りたて工房～スウィーツ餃子～","2012年度入学理科二・三類24組","ぐっぴーのつくりたてこうぼう　すうぃーつぎょうざ","にせんじゅうにねんどにゅうがくりかにさんるいにじゅうよんくみ"),
		new Kikaku(834,Place.PLACE_8,Kind.MOGI,"揚げ揚げアイス","2012年度入学文科一・二類18組","あげあげあいす","にせんじゅうにねんどにゅうがくぶんかいち・にるい18くみ"),
		new Kikaku(835,Place.PLACE_57,Kind.MOGI,"こけこっこー（°θ°）","2012年度入学理科二・三類23組","こけこっこー","にせんじゅうにねんどにゅうがくりかに・さんるいにじゅうさんくみ"),
		new Kikaku(836,Place.PLACE_32,Kind.MOGI,"S'mores×2","2012年度入学文科一・二類27組","すもーるず すもーるず","とうきょうだいがくぶんかいちにるいにじゅうななくみ"),
		new Kikaku(837,Place.PLACE_9,Kind.MOGI,"東大ばな奈　「ちょこつけたっ」","2012年度入学理科一類27組","とうだいばなな　ちょこつけたっ","にせんじゅうにねんどにゅうがくりかいちるいにじゅうななくみ"),
		new Kikaku(838,Place.PLACE_57,Kind.MOGI,"オクトPASS焼き","2012年度入学文科一・二類22組","おくとぱすやき","にせんじゅうにねんどにゅうがくぶんかいちにるいにじゅうにくみ"),
		new Kikaku(839,Place.PLACE_32,Kind.MOGI,"たこ八","2012年度入学理科二・三類8組","たこはち","にせんじゅうにねんどにゅうがくりかにさんるいはちくみ"),
		new Kikaku(840,Place.PLACE_49,Kind.MOGI,"イタリア風春巻きのお店","2012年度入学文科一・二・三類6組","いたりあふうはるまきのおみせ","にせんじゅうねんどにゅうがくぶんかいちにさんるいろっくみ"),
		new Kikaku(841,Place.PLACE_32,Kind.MOGI,"僕のワッフルに溶ける君のアイス","2012年度入学文科三類18組","ぼくのわっふるにとけるきみのあいす","にせんねんどにゅうがくぶんかさんるい１８くみ"),
		new Kikaku(842,Place.PLACE_49,Kind.MOGI,"びっくりたこ焼き","2012年度入学文科三類16組","びっくりたこやき","にせんじゅうにねんどにゅうがくぶんかさんるいじゅうろっくみ"),
		new Kikaku(843,Place.PLACE_32,Kind.MOGI,"爆玉米花","2012年度入学文科三類13組","ばくたまこめはな","にせんじゅうにねんどにゅうがくぶんかさんるいじゅうさんくみ"),
		new Kikaku(844,Place.PLACE_26,Kind.MOGI,"やきそばーばパパ","2012年度入学文科一・二類23組","やきそばーばぱぱ","にせん十二年度入学ぶんかいち・にるいにじゅうさんくみ"),
		new Kikaku(845,Place.PLACE_2,Kind.MOGI,"Frankfurt","2012年度入学理科二・三類19組","ふらんくふると","にせんじゅうにねんどにゅうがくりかにさんるいじゅうきゅうくみ"),
		new Kikaku(846,Place.PLACE_8,Kind.MOGI,"焼うどん","2012年度入学理科一類18組","やきうどん","にせんじゅうにねんどにゅうがくりかいちるいじゅうはちくみ"),
		new Kikaku(847,Place.PLACE_57,Kind.MOGI,"タピオカピ","2012年度入学文科三類19組","たぴおかぴ","にせんじゅうにねんどにゅうがくぶんかさんるいじゅうきゅうくみ"),
		new Kikaku(848,Place.PLACE_32,Kind.MOGI,"まっちゃんの ぎょうざピザ","2012年度入学理科一類16組","まっちゃんのぎょうざぴざ","にせんじゅうにねんどにゅうがくりかいちるいじゅうろっくみ"),
		new Kikaku(849,Place.PLACE_32,Kind.MOGI,"パンが無ければラスクでいいじゃん！","2012年度入学文科三類20組","ぱんがなければらすくでいいじゃん！","にせんじゅうにねんどにゅうがくぶんかさんるいにじゅうくみ"),
		new Kikaku(850,Place.PLACE_2,Kind.MOGI,"ドキ²たこ焼き～女の子がフーフー～","2012年度入学理科二・三類11組","どきどきたこやきおんなのこがふーふー","にせんじゅうにねんどりかにさんるいじゅういちくみ"),
		new Kikaku(851,Place.PLACE_32,Kind.MOGI,"ミニポテト","2012年度入学理科一類32組","みにぽてと","にせんじゅうにねんどにゅうがくりかいちるいさんじゅうにくみ"),
		new Kikaku(852,Place.PLACE_32,Kind.MOGI,"東大ばなな。","2012年度入学理科一類11組","とうだいばなな。","にせんじゅうにねんにゅうがくりかいちるいじゅういちくみ"),
		new Kikaku(853,Place.PLACE_32,Kind.MOGI,"牛串パラダイス","2012年度入学文科一・二類10組","ぎゅうくしぱらだいす","にせんじゅうにねんどにゅうがくぶんかいちにるい10くみ"),
		new Kikaku(854,Place.PLACE_2,Kind.MOGI,"フランク売ると","2012年度入学文科一・二類24組","ふらんくうると","にせんじゅうにねんどにゅうがくぶんかいち・にるいにじゅうよんくみ"),
		new Kikaku(855,Place.PLACE_49,Kind.MOGI,"おくさんのタピオカ","2012年度入学理科二・三類22組","おくさんのたぴおか","とうきょうだいがくにゅうがくりかにさんるいにじゅうにくみ"),
		new Kikaku(856,Place.PLACE_38,Kind.MOGI,"ワッンダフル","2012年度入学理科二・三類7組","わっんだふる","にせんじゅうにねんどにゅうがくりかにるいさんるいななくみ"),
		new Kikaku(857,Place.PLACE_57,Kind.MOGI,"アイス揚げちゃいました","2012年度入学理科一類7組","あいすあげちゃいました","にせんじゅうにねんどにゅうがくりかいちるいななくみ"),
		new Kikaku(858,Place.PLACE_57,Kind.MOGI,"タピはらワフみ","2012年度入学文科一・二類11組","たぴはらわふみ","にせんじゅうにねんどにゅうがくぶんかいち・にるいじゅういちくみ"),
		new Kikaku(859,Place.PLACE_26,Kind.MOGI,"BARタピオカ","2012年度入学理科一類25組","ばーたぴおか","にせんじゅうにねんどにゅうがくりかいちるいにじゅうごくみ"),
		new Kikaku(860,Place.PLACE_38,Kind.MOGI,"フランクなんとか","2012年度入学文科三類14組","ふらんくなんとか","にせんじゅうにねんどにゅうがくぶんかさんるいじゅうよんくみ"),
		new Kikaku(861,Place.PLACE_57,Kind.MOGI,"チヂミ屋","2012年度入学文科三類15組","ちぢみや","にせんじゅうにねんどにゅうがくぶんかさんるいじゅうごくみ"),
		new Kikaku(862,Place.PLACE_32,Kind.MOGI,"黄金の玉こんにゃくfrom東北","2012年度入学文科一・二類13組","おうごんのたまこんにゃくふろむとうほく","にせんじゅうにねんどにゅうがくぶんかいちにるいじゅうさんくみ"),
		new Kikaku(863,Place.PLACE_9,Kind.MOGI,"韓国のおやつ“ホットク”","2012年度入学理科一類5組","かんこくのおやつほっとく","にせんじゅうにねんどにゅうがくりかいちるいごくみ"),
		new Kikaku(864,Place.PLACE_8,Kind.MOGI,"肉食系うしさんだよ","2012年度入学文科一・二類12組","にくしょくけいうしさんだよ","にせんじゅうにねんどにゅうがくぶんかいちにるいじゅうにくみ"),
		new Kikaku(865,Place.PLACE_2,Kind.MOGI,"おみくじわたがし","2012年度入学理科二・三類14組","おみくじわたがし","にせんじゅうにねんどにゅうがくりかにさんるいじゅうよんくみ"),
		new Kikaku(866,Place.PLACE_32,Kind.MOGI,"日本一のころころホットケーキ","2012年度入学理科二・三類17組","にほんいちのころころほっとけーき","にせんじゅうにねんどにゅうがくりかに・さんるいじゅうななくみ"),
		new Kikaku(867,Place.PLACE_2,Kind.MOGI,"幸せの青い鳥","2012年度入学理科一類12組","しあわせのあおいとり","にせんじゅうにねんどにゅうがくりかいちるいじゅうにくみ"),
		new Kikaku(868,Place.PLACE_8,Kind.MOGI,"いいことあるぞ ミスターアンダギー","2012年度入学文科三類11組","いいことあるぞ みすたーあんだぎー","にせんじゅうにねんどにゅうがくぶんかさんるい11くみ"),
		new Kikaku(870,Place.PLACE_57,Kind.MOGI,"チュロス＆フロート","2012年度入学理科一類17組","ちゅろすあんどふろーと","にせんじゅうにねんどにゅうがくりかいちるいじゅうんくみ"),
		new Kikaku(871,Place.PLACE_57,Kind.MOGI,"アゲ☆アゲ","2012年度入学文科一・二類17組","あげあげ","にせんじゅうにねんどにゅうがくぶんかいちにるいじゅうななくみ"),
		new Kikaku(872,Place.PLACE_8,Kind.MOGI,"もふもふもっふる","2012年度入学理科一類13組","もふもふもっふる","にせんじゅうにねんどにゅうがくりかいちるいじゅうさんくみ"),
		new Kikaku(873,Place.PLACE_8,Kind.MOGI,"きむさんちの焼肉サンド","ごくみーず2012","きむさんちのやきにくさんど","ごくみーずにせんじゅうに"),
		new Kikaku(874,Place.PLACE_38,Kind.MOGI,"-選んで楽しい!!-フッテリア","2012年度入学文科三類10組","えらんでたのしい！！-ふってりあ","にせんじゅうにねんどにゅうがくぶんかさんるいじっくみ"),
		new Kikaku(875,Place.PLACE_26,Kind.MOGI,"走れチュロス","2012年度入学理科一類22組","はしれちゅろす","にせんじゅうにねんどにゅうがくりかいちるいにじゅうにくみ"),
		new Kikaku(876,Place.PLACE_9,Kind.MOGI,"ヤキモチ妬くなら、そばばぼ～ん!!　","2012年度入学文科三類17組","やきもちやくなら、そばばぼ～ん!!　","にせんじゅうにねんどにゅうがくぶんかさんるいじゅうななくみ"),
		new Kikaku(877,Place.PLACE_49,Kind.MOGI,"下から読んでも焼き鳥屋","2012年度入学理科一類33組","したからよんでもやきとりや","にせんじゅうにねんどにゅうがくりかいちるいさんじゅうさんくみ"),
		new Kikaku(878,Place.PLACE_8,Kind.MOGI,"31(揚げ)アイスクリーム","2012年度入学理科一類31組","さんじゅういちあげあいすくりいむ","にせんじゅうにねんどにゅうがくりかいちるいさんじゅういちくみ"),
		new Kikaku(879,Place.PLACE_8,Kind.MOGI,"フライドポテト","2012年度入学理科一類29組","ふらいどぽてと","にせんじゅうにねんどにゅうがくりかいちるいにじゅうきゅうくみ"),
		new Kikaku(880,Place.PLACE_9,Kind.MOGI,"ちゅっ、ちゅっ、ちゅろす","2012年度入学理科一類30組","ちゅっ、ちゅっ、ちゅろす","にせんじゅうにねんどにゅうがくりかいちるいさんじゅっくみ"),
		new Kikaku(881,Place.PLACE_2,Kind.MOGI,"はしまきまきまき","2012年度入学理科二・三類12組","はしまきまきまき","にせんじゅうにねんどにゅうがくりかに・さんるいじゅうにくみ"),
		new Kikaku(882,Place.PLACE_9,Kind.MOGI,"TMS 21","2012年度入学理科二・三類21組","てぃーえむえす にじゅういち","にせんじゅうにねんどにゅうがくりかにさんるいにじゅういちくみ"),
		new Kikaku(883,Place.PLACE_38,Kind.MOGI,"東京大學芋","2012年度入学文科三類12組","とうきょうだいがくいも","にせんじゅうにねんどにゅうがくぶんかさんるいじゅうにくみ"),
		new Kikaku(884,Place.PLACE_32,Kind.MOGI,"わくわくワッフル","2012年度入学理科一類10組","わくわくわっふる","にせんじゅうにねんどにゅうがくりかいちるいじゅっくみ"),
		new Kikaku(885,Place.PLACE_26,Kind.MOGI,"PANIWAY","2012年度入学文科一・二類26組","ぱにうぇい","にせんじゅうにねんどにゅうがくぶんかいち・にるいにじゅうろくくみ"),
		new Kikaku(886,Place.PLACE_26,Kind.MOGI,"ニコニコやきそば","2012年度入学文科一・二類25組","にこにこやきそば","にせんじゅうにねんどにゅうがくぶんかいち・にるいにじゅうごくみ"),
		new Kikaku(887,Place.PLACE_26,Kind.MOGI,"PIZZA COSI COSI ","2012年度入学理科一・二・三類６組","ぴざこーじーこーじー","とうきょうだいがくにせんじゅうにねんどにゅうがくりかいちにさんるいろっくみ"),
		new Kikaku(888,Place.PLACE_49,Kind.MOGI,"ちょこ☆ばなな","2012年度入学理科一類24組","ちょこばなな","にせんじゅうにねんどりかいちるいにじゅうよんくみ"),
		new Kikaku(889,Place.PLACE_38,Kind.MOGI,"もみ☆あげ↑～本郷で、あげもみじ～","2012年度入学文科一・二類28組","もみ☆あげあげ～ほんごうで、あげもみじ～","にせんじゅうにねんどにゅうがくぶんかいちにるいにじゅうはちくみ"),
		new Kikaku(890,Place.PLACE_5,Kind.MOGI,"クレープ屋さん","2012年度入学文科一・二類16組","くれーぷやさん","にせんじゅうにねんどにゅうがくぶんかいちにるいじゅうろっくみ"),
		new Kikaku(891,Place.PLACE_5,Kind.MOGI,"焼鳥取","2012年度入学文科一・二類9組","やきとりんどる","にせんじゅうにねんどにゅうがくぶんかいちにるいきゅうくみ"),
		new Kikaku(892,Place.PLACE_57,Kind.MOGI,"私とあなたでCHU!ろす♡","2012年度入学理科二・三類9組","わたしとあなたでちゅろす","にせんじゅうにねんどにゅうがくりかにさんるいきゅうくみ"),
		new Kikaku(893,Place.PLACE_26,Kind.MOGI,"ロシアのキッチン","2012年入学文科一・二・三類4組","ろしあのきっちん","にせんじゅうにねんどにゅうがくぶんかいち・に・さんるいよんくみ"),
		new Kikaku(894,Place.PLACE_8,Kind.MOGI,"揚げパンアイス","2012年度入学理科一類19組","あげぱんあいす","にせんじゅうにねんどにゅうがくりかいちるいじゅうきゅうくみ"),
		new Kikaku(895,Place.PLACE_32,Kind.MOGI,"たません、たべません？","2012年度入学理科一類8組","たません、たべません？","にせんじゅうにねんどにゅうがくりかいちるいはっくみ"),
		new Kikaku(896,Place.PLACE_26,Kind.MOGI,"DANGO!!","2012年度入学理科一類34組","だんご","にせんじゅうにねんどにゅうがくりかいちるいさんじゅうよんくみ"),
	};
	
	public static KikakuGroup[] groupById(Filter filter) {
		KikakuGroup[] result = new KikakuGroup[8];
		
		Kikaku[] list = getKikakuList(filter);
		Arrays.sort(list, SORT_BY_ID);
		
		List<Kikaku> group = null;
		int threshold = 300;
		int index = 0;
		
		for(int i = 0; i < list.length; i++) {
			if(list[i].getKikakuId() > threshold - 1) {
				if(group != null) {
					Kikaku[] array = group.toArray(new Kikaku[group.size()]);
					result[index++] = new KikakuGroup(String.format("ID%d番台", threshold - 100), array);
				}
				
				group = new ArrayList<Kikaku>();
				while(list[i].getKikakuId() > threshold - 1)
					threshold += 100;
			}
			
			group.add(list[i]);
		}
		
		Kikaku[] array = group == null ? new Kikaku[0] : group.toArray(new Kikaku[group.size()]);
		result[index++] = new KikakuGroup(String.format("ID%d番台", threshold - 100), array);
		
		return result;
	}
	
	private static char[] PHONETIC_ORDER = new char[]{
		'あ', 'か', 'さ', 'た', 'な', 'は', 'ま', 'や', 'ら', 'わ', 'ん' //番兵
	};
	
	public static KikakuGroup[] groupByKikakuName(Filter f) {
		KikakuGroup[] result = new KikakuGroup[PHONETIC_ORDER.length + 3];
		
		Kikaku[] list = getKikakuList(f);
		Arrays.sort(list, SORT_BY_KIKAKU_NAME);
		
		List<Kikaku> group = new ArrayList<Kikaku>();;
		char threshold = PHONETIC_ORDER[1];
		int index = 0;

		for(int i = 0; i < list.length; i++) {
			char c = list[i].getPhoneticKinakuName().charAt(0);
			if(c >= threshold) {
				if(group != null) {
					Kikaku[] array = group.toArray(new Kikaku[group.size()]);
					result[index] = new KikakuGroup(String.format("%s行", String.valueOf(PHONETIC_ORDER[index])), array);
					index++;
				}
				
				group = new ArrayList<Kikaku>();
				
				do{
					threshold = PHONETIC_ORDER[index + 1];
					index++;
				}while(c >= threshold);
				
				index--;
			}
			
			group.add(list[i]);
		}
		
		Kikaku[] array = group == null ? new Kikaku[0] : group.toArray(new Kikaku[group.size()]);
		if(index != 0)
			result[index] = new KikakuGroup(String.format("%s行", String.valueOf(PHONETIC_ORDER[index])), array);
		
		return result;
	}
	
	public static KikakuGroup[] groupByOrgName(Filter f) {
		KikakuGroup[] result = new KikakuGroup[PHONETIC_ORDER.length + 3];
		
		Kikaku[] list = getKikakuList(f);
		Arrays.sort(list, SORT_BY_ORG_NAME);
		
		List<Kikaku> group = new ArrayList<Kikaku>();
		char threshold = PHONETIC_ORDER[1];
		int index = 0;
		
		for(int i = 0; i < list.length; i++) {
			char c = list[i].getPhoneticOrgName().charAt(0);
			if(c >= threshold) {
				if(group != null) {
					Kikaku[] array = group.toArray(new Kikaku[group.size()]);
					result[index] = new KikakuGroup(String.format("%s行", String.valueOf(PHONETIC_ORDER[index])), array);
					index++;
				}
				
				group = new ArrayList<Kikaku>();
				
				do{
					threshold = PHONETIC_ORDER[index + 1];
					index++;
				}while(c >= threshold);
				
				index--;
			}
			
			group.add(list[i]);
		}
		
		Kikaku[] array = group == null ? new Kikaku[0] : group.toArray(new Kikaku[group.size()]);
		if(index != 0)
			result[index] = new KikakuGroup(String.format("%s行", String.valueOf(PHONETIC_ORDER[index])), array);
		
		return result;
	}
	
	public static Kikaku[] getKikakuList(Filter f) {
		Kikaku[] k = KIKAKU_LIST.clone(); //copy
		if(f == null) {
			return k;
		}else {
			List<Kikaku> list = new ArrayList<Kikaku>();
			for(Kikaku kikaku : k){
				if(f.filter(kikaku))
					list.add(kikaku);
			}
			
			return list.toArray(new Kikaku[list.size()]);
		}	
	}
	
	public static Kikaku[] getKikakuList() {
		return getKikakuList(null);
	}
	
	private Kikaku(int kikakuId, Place place, Kind kind, String kikakuName,
			String orgName, String phoneticKinakuName, String phoneticOrgName) {
		this.kikakuId = kikakuId;
		this.place = place;
		this.kind = kind;
		this.kikakuName = kikakuName;
		this.orgName = orgName;
		this.phoneticKinakuName = phoneticKinakuName;
		this.phoneticOrgName = phoneticOrgName;
	}
	
	private int kikakuId;
	private Place place;
	private Kind kind;
	private String kikakuName;
	private String orgName;
	private String phoneticKinakuName;
	private String phoneticOrgName;
	
	public int getKikakuId() {
		return kikakuId;
	}
	public Place getPlace() {
		return place;
	}
	public Kind getKind() {
		return kind;
	}
	public String getKikakuName() {
		return kikakuName;
	}
	public String getOrgName() {
		return orgName;
	}
	public String getPhoneticKinakuName() {
		return phoneticKinakuName;
	}
	public String getPhoneticOrgName() {
		return phoneticOrgName;
	}

}
