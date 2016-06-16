package Database;

import java.util.ArrayList;

public class SRCardLimited extends Card {
	ArrayList<Card> info = new ArrayList<Card>();
	public SRCardLimited() {
	}
	public SRCardLimited(String lev, String type, String name, boolean limited) {
		super(lev,type,name,limited);
	}
	public ArrayList<Card> info(){
		info.add(new Card("SR","Cool","[흑진주의 반짝임] 쿠로카와 치아키",true));
		info.add(new Card("SR","Cool","[할로윈 나이트메어] 시라사카 코우메",true));
		info.add(new Card("SR","Passion","[치유의 만월] 오이카와 시즈쿠",true));
		info.add(new Card("SR","Cute","[스위트 크리스마스] 이가라시 쿄코",true));
		info.add(new Card("SR","Cute","[대기만성] 도묘지 카린",true));
		info.add(new Card("SR","Cool","[작은 자신가] 와키야마 타마미",true));
		info.add(new Card("SR","Cute","[프리티 파티쉐] 나카노 유카",true));
		info.add(new Card("SR","Cute","[모범생/고냥이] 마에카와 미쿠",true));
		info.add(new Card("SR","Cute","[자칭 귀요미] 코시미즈 사치코",true));
		info.add(new Card("SR","Passion","[알레그로 기분] 마츠야마 쿠미코",true));
		info.add(new Card("SR","Passion","[해피 브라이덜] 나탈리아",true));
		info.add(new Card("SR","Passion","[아름다운 신부] 와쿠이 루미",true));
		return info;
	}
}