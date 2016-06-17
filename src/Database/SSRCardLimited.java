package Database;

import java.util.ArrayList;

public class SSRCardLimited extends Card {
	ArrayList<Card> info = new ArrayList<Card>();
	public SSRCardLimited() {
	}
	public SSRCardLimited(String lev, String type, String name, boolean limited) {
		super(lev,type,name,limited);
	}
	public ArrayList<Card> info(){
		info.add(new Card("SSR","큐트","[화이트 위치] 미무라 카나코",true));
		info.add(new Card("SSR","큐트","[꿈빛 클로버] 오가타 치에리",true));
		info.add(new Card("SSR","큐트","[탱글탱글 우사밍] 아베 나나",true));
		info.add(new Card("SSR","큐트","[유스풀 로맨스] 코히나타 미호",true));
		info.add(new Card("SSR","큐트","[로즈 플뢰르] 사쿠라이 모모카",true));
		info.add(new Card("SSR","큐트","[드리밍 브라이드] 마에카와 미쿠",true));
		info.add(new Card("SSR","쿨","[히트&비트] 타다 리이나",true));
		info.add(new Card("SSR","쿨","[럭셔리 메모리] 카와시마 미즈키",true));
		info.add(new Card("SSR","쿨","[밤바람의 유혹] 타카가키 카에데",true));
		info.add(new Card("SSR","쿨","[크리스탈 스노우] 아나스타샤",true));
		info.add(new Card("SSR","쿨","[처음 짓는 표정] 타치바나 아리스",true));
		info.add(new Card("SSR","쿨","[기다려지는 운명의 사람] 칸자키 란코",true));
		info.add(new Card("SSR","패션","[해피 휩] 아카기 미리아",true));
		info.add(new Card("SSR","패션","[하트★오버플로우] 죠가사키 미카",true));
		info.add(new Card("SSR","패션","[버닝 프레젠트] 히노 아카네",true));
		info.add(new Card("SSR","패션","[펌프킨 파티] 토토키 아이리",true));
		info.add(new Card("SSR","패션","[권화상등] 무카이 타쿠미",true));
		info.add(new Card("SSR","패션","[이모셔널 비트] 키무라 나츠키",true));
		return info;
	}
}