package Database;

import java.util.ArrayList;

public class SRCard extends Card {
	ArrayList<Card> info = new ArrayList<Card>();
	public SRCard() {
	}
	public SRCard(String lev, String type, String name, boolean limited) {
		super(lev,type,name,limited);
	}
	public ArrayList<Card> info(){
		info.add(new Card("SR","Cute","[섹시 캣] 마에카와 미쿠",false));
		info.add(new Card("SR","Cute","[포근한 스마일] 미무라 카나코",false));
		info.add(new Card("SR","Cute","[수줍은 소녀] 코히나타 미호",false));
		info.add(new Card("SR","Cute","[소악마 메이드] 미야모토 프레데리카",false));
		info.add(new Card("SR","Cute","[퓨어리 걸] 오쿠야마 사오리",false));
		info.add(new Card("SR","Cute","[겨울의 멜로디] 오가타 치에리",false));
		info.add(new Card("SR","Cute","[리틀 프린세스] 후쿠야마 마이",false));
		info.add(new Card("SR","Cool","[신비의 여신] 타카가키 카에데",false));
		info.add(new Card("SR","Cool","[반짝이는 소녀] 호죠 카렌",false));
		info.add(new Card("SR","Cool","[미소의 여신] 닛타 미나미",false));
		info.add(new Card("SR","Cool","[신춘 록커] 타다 리이나",false));
		info.add(new Card("SR","Cool","[스타리 비치] 아나스타샤",false));
		info.add(new Card("SR","Cool","[쁘띠 마드모아젤] 사죠 유키미",false));
		info.add(new Card("SR","Cool","[블루 플로트 파티] 아라키 히나",false));
		info.add(new Card("SR","Passion","[스위트 발렌타인] 토토키 아이리",false));
		info.add(new Card("SR","Cute","[복슬복슬 꼬리] 아카기 미리아",false));
		info.add(new Card("SR","Passion","[카리스마 GAL] 죠가사키 미카",false));
		info.add(new Card("SR","Passion","[카리스마 미니 GAL] 죠가사키 리카",false));
		info.add(new Card("SR","Passion","[전력 치어걸] 히메카와 유키",false));
		info.add(new Card("SR","Cool","[록킹 러버] 키무라 나츠키",false));
		info.add(new Card("SR","Passion","[선플라워 옐로] 류자키 카오루",false));
		info.add(new Card("SR","Passion","[부드러운 소녀] 타카모리 아이코",false));
		info.add(new Card("SR","Cute","[안경 프린세스] 카미죠 하루나",false));
		info.add(new Card("SR","Passion","[프레쉬 치어걸] 와카바야시 토모카",false));
		info.add(new Card("SR","Cute","[퍼퓸 트리퍼] 이치노세 시키",false));
		info.add(new Card("SR","Passion","[문라이트 플라워] 아이바 유미",false));
		info.add(new Card("SR","Cool","[브라이트 메모리즈] 사기사와 후미카",false));
		info.add(new Card("SR","Cool","[록킹 보컬리스트] 마츠나가 료",false));
		info.add(new Card("SR","Cute","[파이팅 치어] 나카노 유카",false));
		info.add(new Card("SR","Cool","[나이트 엘레강스] 아이카와 치나츠",false));
		info.add(new Card("SR","Passion","[데인져러스 어덜티] 카타기리 사나에",false));
		info.add(new Card("SR","Cute","[매지컬☆프리티 하트] 요코야마 치카",false));
		info.add(new Card("SR","Cool","[영원한 공주님] 카와시마 미즈키",false));
		info.add(new Card("SR","Passion","[일진 소녀] 무카이 타쿠미",false));
		info.add(new Card("SR","Cute","[해피 매지션] 쿠도 시노부",false));
		info.add(new Card("SR","Passion","[소녀의 공부] 메어리 코크란",false));
		info.add(new Card("SR","Cool","[쇼콜라 발렌타인] 모리쿠보 노노",false));
		info.add(new Card("SR","Passion","[나니와의 화려한 아가씨] 남바 에미",false));
		info.add(new Card("SR","Cute","[장밋빛 공주님] 사쿠라이 모모카",false));
		info.add(new Card("SR","Cool","[치유의 여신] 미후네 미유",false));
		info.add(new Card("SR","Passion","[천일야화 무희] 나탈리아",false));
		info.add(new Card("SR","Passion","[화려한 쿠노이치] 하마구치 아야메",false));
		info.add(new Card("SR","Cute","[팬시 걸] 이마이 카나",false));
		info.add(new Card("SR","Cool","[질풍의 스트라이커] 유우키 하루",false));
		info.add(new Card("SR","Cool","[두근두근☆챌린지] 아야세 호노카",false));
		info.add(new Card("SR","Passion","[인형옷 푹신푹신] 이치하라 니나",false));
		info.add(new Card("SR","Cute","[청순한 아가씨] 미즈모토 유카리",false));
		info.add(new Card("SR","Cool","[꼬마 스테이지] 와키야마 타마미",false));
		info.add(new Card("SR","Cute","[꽃밭의 봄바람] 사이온지 코토카",false));
		info.add(new Card("SR","Passion","[고민할 나이] 야구치 미우",false));
		info.add(new Card("SR","Cool","[섹시 뷰티] 마츠모토 사리나",false));
		info.add(new Card("SR","Cute","[비치 웨이브] 무라마츠 사쿠라",false));
		return info;
	}
}