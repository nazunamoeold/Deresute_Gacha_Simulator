package Database;
public class SRCard extends Card {
	Card[] info = new Card [super.SRCardnumber];
	public Card[] inforeturn(){
		return info;
	}
	public Card info(int k){
		
		info[0] = new Card();
		info[0].settype("cute");
		info[0].setname("[섹시 캣] 마에카와 미쿠");
		
		info[1] = new Card();
		info[1].settype("cute");
		info[1].setname("[포근한 스마일] 미무라 카나코");
		
		info[2] = new Card();
		info[2].settype("cute");
		info[2].setname("[수줍은 소녀] 코히나타 미호");
		
		info[3] = new Card();
		info[3].settype("cute");
		info[3].setname("[소악마 메이드] 미야모토 프레데리카");
		
		info[4] = new Card();
		info[4].settype("cute");
		info[4].setname("[퓨어리 걸] 오쿠야마 사오리");
		
		info[5] = new Card();
		info[5].settype("cute");
		info[5].setname("[겨울의 멜로디] 오가타 치에리");
		
		info[6] = new Card();
		info[6].settype("cute");
		info[6].setname("[리틀 프린세스] 후쿠야마 마이");
		
		info[7] = new Card();
		info[7].settype("cool");
		info[7].setname("[신비의 여신] 타카가키 카에데");
		
		info[8] = new Card();
		info[8].settype("cool");
		info[8].setname("[반짝이는 소녀] 호죠 카렌 ");
		
		info[9] = new Card();
		info[9].settype("cool");
		info[9].setname("[미소의 여신] 닛타 미나미");
		
		info[10] = new Card();
		info[10].settype("cool");
		info[10].setname("[신춘 록커] 타다 리이나");
		
		info[11] = new Card();
		info[11].settype("cool");
		info[11].setname("[스타리 비치] 아나스타샤");
		
		info[12] = new Card();
		info[12].settype("cool");
		info[12].setname("[쁘띠 마드모아젤] 사죠 유키미");
		
		info[13] = new Card();
		info[13].settype("cool");
		info[13].setname("[블루 플로트 파티] 아라키 히나");
		
		info[14] = new Card();
		info[14].settype("passion");
		info[14].setname("[스위트 발렌타인] 토토키 아이리");
		
		info[15] = new Card();
		info[15].settype("cute");
		info[15].setname("[복슬복슬 꼬리] 아카기 미리아");
		
		info[16] = new Card();
		info[16].settype("passion");
		info[16].setname("[카리스마 GAL] 죠가사키 미카");
		
		info[17] = new Card();
		info[17].settype("passion");
		info[17].setname("[카리스마 미니 GAL] 죠가사키 리카");
		
		info[18] = new Card();
		info[18].settype("passion");
		info[18].setname("[전력 치어걸] 히메카와 유키");
		
		info[19] = new Card();
		info[19].settype("cool");
		info[19].setname("[록킹 러버] 키무라 나츠키");
		
		info[20] = new Card();
		info[20].settype("passion");
		info[20].setname("[선플라워 옐로] 류자키 카오루");
		
		info[21] = new Card();
		info[21].settype("passion");
		info[21].setname("[부드러운 소녀] 타카모리 아이코");
		
		info[22] = new Card();
		info[22].settype("cute");
		info[22].setname("[안경 프린세스] 카미죠 하루나");
		
		info[23] = new Card();
		info[23].settype("passion");
		info[23].setname("[프레쉬 치어걸] 와카바야시 토모카");
		
		info[24] = new Card();
		info[24].settype("cute");
		info[24].setname("[퍼퓸 트리퍼] 이치노세 시키");
		
		info[25] = new Card();
		info[25].settype("passion");
		info[25].setname("[문라이트 플라워] 아이바 유미");
		
		info[26] = new Card();
		info[26].settype("cool");
		info[26].setname("[브라이트 메모리즈] 사기사와 후미카");
		
		info[27] = new Card();
		info[27].settype("cool");
		info[27].setname("[록킹 보컬리스트] 마츠나가 료");
		
		info[28] = new Card();
		info[28].settype("cute");
		info[28].setname("[파이팅 치어] 나카노 유카 ");
		
		info[29] = new Card();
		info[29].settype("cool");
		info[29].setname("[나이트 엘레강스] 아이카와 치나츠");
		
		info[30] = new Card();
		info[30].settype("passion");
		info[30].setname("[데인져러스 어덜티] 카타기리 사나에");
		
		info[31] = new Card();
		info[31].settype("cute");
		info[31].setname("[매지컬☆프리티 하트] 요코야마 치카 ");
		
		info[32] = new Card();
		info[32].settype("cool");
		info[32].setname("[영원한 공주님] 카와시마 미즈키");
		
		info[33] = new Card();
		info[33].settype("passion");
		info[33].setname("[일진 소녀] 무카이 타쿠미 ");
		
		info[34] = new Card();
		info[34].settype("cute");
		info[34].setname("[해피 매지션] 쿠도 시노부 ");
		
		info[35] = new Card();
		info[35].settype("passion");
		info[35].setname("[소녀의 공부] 메어리 코크란");
		
		info[36] = new Card();
		info[36].settype("cool");
		info[36].setname("[쇼콜라 발렌타인] 모리쿠보 노노");
		
		info[37] = new Card();
		info[37].settype("passion");
		info[37].setname("[나니와의 화려한 아가씨] 남바 에미");
		
		info[38] = new Card();
		info[38].settype("cute");
		info[38].setname("[장밋빛 공주님] 사쿠라이 모모카");
		
		info[39] = new Card();
		info[39].settype("cool");
		info[39].setname("[치유의 여신] 미후네 미유 ");
		
		info[40] = new Card();
		info[40].settype("passion");
		info[40].setname("[천일야화 무희] 나탈리아");
		
		info[41] = new Card();
		info[41].settype("passion");
		info[41].setname("[화려한 쿠노이치] 하마구치 아야메");
		
		info[42] = new Card();
		info[42].settype("cute");
		info[42].setname("[팬시 걸] 이마이 카나 ");
		
		info[43] = new Card();
		info[43].settype("cool");
		info[43].setname("[질풍의 스트라이커] 유우키 하루");
		
		info[44] = new Card();
		info[44].settype("cool");
		info[44].setname("[두근두근☆챌린지] 아야세 호노카");
		
		info[45] = new Card();
		info[45].settype("passion");
		info[45].setname("[인형옷 푹신푹신] 이치하라 니나");
		
		info[46] = new Card();
		info[46].settype("cute");
		info[46].setname("[청순한 아가씨] 미즈모토 유카리");
		
		info[47] = new Card();
		info[47].settype("cool");
		info[47].setname("[꼬마 스테이지] 와키야마 타마미");
		
		info[48] = new Card();
		info[48].settype("cute");
		info[48].setname("[꽃밭의 봄바람] 사이온지 코토카");
		
		info[49] = new Card();
		info[49].settype("passion");
		info[49].setname("[고민할 나이] 야구치 미우");
		
		info[50] = new Card();
		info[50].settype("cool");
		info[50].setname("[섹시 뷰티] 마츠모토 사리나");
		
		info[51] = new Card();
		info[51].settype("cute");
		info[51].setname("[비치 웨이브] 무라마츠 사쿠라");
		
		for(int i=0; i<super.SRCardnumber; i++){
			info[i].setlev("SR");
			info[i].setlimited(false);
		}
		return info[k];
	}
}
/*
case k:{
info[k].settype("");
info[k].setname("");
return info[k];		
}

*/