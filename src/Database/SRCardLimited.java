package Database;


public class SRCardLimited extends Card {
	public Card srinfo(int k){
		Card[] srinfo = new Card [super.SRCardLimitednumber];
		
		srinfo[0] = new Card();
		srinfo[0].type="cool";
		srinfo[0].name="[흑진주의 반짝임] 쿠로카와 치아키";
		
		srinfo[1] = new Card();
		srinfo[1].type="cool";
		srinfo[1].name="[할로윈 나이트메어] 시라사카 코우메";
		
		srinfo[2] = new Card();
		srinfo[2].type="passion";
		srinfo[2].name="[치유의 만월] 오이카와 시즈쿠";
		
		srinfo[3] = new Card();
		srinfo[3].type="cute";
		srinfo[3].name="[스위트 크리스마스] 이가라시 쿄코";
		
		srinfo[4] = new Card();
		srinfo[4].type="cute";
		srinfo[4].name="[대기만성] 도묘지 카린 ";
		
		srinfo[5] = new Card();
		srinfo[5].type="cool";
		srinfo[5].name="[작은 자신가] 와키야마 타마미";
		
		srinfo[6] = new Card();
		srinfo[6].type="cute";
		srinfo[6].name="[프리티 파티쉐] 나카노 유카";
		
		srinfo[7] = new Card();
		srinfo[7].type="cute";
		srinfo[7].name="[모범생/고냥이] 마에카와 미쿠";
		
		srinfo[8] = new Card();
		srinfo[8].type="cute";
		srinfo[8].name="[자칭 귀요미] 코시미즈 사치코 ";
		
		srinfo[8] = new Card();
		srinfo[8].type="passion";
		srinfo[8].name="[알레그로 기분] 마츠야마 쿠미코  ";
		
//		srinfo[8] = new Card();
//		srinfo[8].type="passion";
//		srinfo[8].name="[하이파이☆데이즈] 류자키 카오루 ";	

		for(int i=0; i<super.SRCardLimitednumber; i++){
			srinfo[i].lev="SR";
			srinfo[i].limited=true;
		}
		
		return srinfo[k];
	}
	
}
/*
case k:{
srinfo[k].type="";
srinfo[k].name="";
return srinfo[k];		
}

*/