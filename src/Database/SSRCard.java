package Database;

import java.util.ArrayList;

public class SSRCard extends Card {
	ArrayList<Card> info = new ArrayList<Card>();
	public SSRCard() {
	}
	public SSRCard(String lev, String type, String name, boolean limited) {
		super(lev,type,name,limited);
	}
	public ArrayList<Card> info(){
		info.add(new Card("SSR","Cute","[미스틱 엘릭서] 이치노세 시키",false));
		info.add(new Card("SSR","Cute","[자칭·완벽] 코시미즈 사치코",false));
		info.add(new Card("SSR","Cute","[필 마이 하트] 사쿠마 마유",false));
		info.add(new Card("SSR","Cute","[캣 파티] 마에카와 미쿠",false));
		info.add(new Card("SSR","Cute","[게으른 왕국] 후타바 안즈",false));
		info.add(new Card("SSR","Cute","[스테이지 오브 매직] 시마무라 우즈키",false));
		info.add(new Card("SSR","Cute","[꽃잎 흩날리는 절경] 코바야카와 사에",false));
		info.add(new Card("SSR","Cute","[따뜻한 하트] 이가라시 쿄코",false));
		info.add(new Card("SSR","Cute","[애비뉴 모드] 미야모토 프레데리카",false));
		info.add(new Card("SSR","Cool","[빛나는 한때] 호죠 카렌",false));
		info.add(new Card("SSR","Cool","[오버 더 레인보우] 카미야 나오",false));
		info.add(new Card("SSR","Cool","[엔들리스 나이트] 하야미 카나데",false));
		info.add(new Card("SSR","Cool","[브라이트 메모리즈] 사기사와 후미카",false));
		info.add(new Card("SSR","Cool","[노블 비너스] 닛타 미나미",false));
		info.add(new Card("SSR","Cool","[장미의 암희] 칸자키 란코",false));
		info.add(new Card("SSR","Cool","[스테이지 오브 매직] 시부야 린",false));
		info.add(new Card("SSR","Cool","[《우상》의 프래그먼트] 니노미야 아스카",false));
		info.add(new Card("SSR","Cool","[전율의 밤] 시라사카 코우메",false));
		info.add(new Card("SSR","Passion","[매쉬업★볼테이지] 호시 쇼코",false));
		info.add(new Card("SSR","Passion","[손으로 만드는 행복] 타카모리 아이코",false));
		info.add(new Card("SSR","Passion","[풀스윙☆엘] 히메카와 유키",false));
		info.add(new Card("SSR","Passion","[친구가 잔뜩] 이치하라 니나",false));
		info.add(new Card("SSR","Passion","[스테이지 오브 매직] 혼다 미오",false));
		info.add(new Card("SSR","Passion","[키라데코☆퍼레이드] 죠가사키 리카",false));
		info.add(new Card("SSR","Passion","[그레이트 프레젠트] 모로보시 키라리",false));
		info.add(new Card("SSR","Passion","[꿈꾸는 프린세스] 키타 히나코",false));
		info.add(new Card("SSR","Passion","[해신의 인도자] 요리타 요시노",false));
		info.add(new Card("SSR","Passion","[발랄 하베스트] 오이카와 시즈쿠",false));
		return info;
	}
}
