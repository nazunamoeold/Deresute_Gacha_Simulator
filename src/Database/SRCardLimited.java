package Database;
public class SRCardLimited extends Card {
	Card[] srinfo = new Card [super.SRCardLimitednumber];
	public Card[] srinforeturn(){
		return srinfo;
	}
	public Card srinfo(int k){
		
		srinfo[0] = new Card();
		srinfo[0].settype("cool");
		srinfo[0].setname("[흑진주의 반짝임] 쿠로카와 치아키");
		
		srinfo[1] = new Card();
		srinfo[1].settype("cool");
		srinfo[1].setname("[할로윈 나이트메어] 시라사카 코우메");
		
		srinfo[2] = new Card();
		srinfo[2].settype("passion");
		srinfo[2].setname("[치유의 만월] 오이카와 시즈쿠");
		
		srinfo[3] = new Card();
		srinfo[3].settype("cute");
		srinfo[3].setname("[스위트 크리스마스] 이가라시 쿄코");
		
		srinfo[4] = new Card();
		srinfo[4].settype("cute");
		srinfo[4].setname("[대기만성] 도묘지 카린 ");
		
		srinfo[5] = new Card();
		srinfo[5].settype("cool");
		srinfo[5].setname("[작은 자신가] 와키야마 타마미");
		
		srinfo[6] = new Card();
		srinfo[6].settype("cute");
		srinfo[6].setname("[프리티 파티쉐] 나카노 유카");
		
		srinfo[7] = new Card();
		srinfo[7].settype("cute");
		srinfo[7].setname("[모범생/고냥이] 마에카와 미쿠");
		
		srinfo[8] = new Card();
		srinfo[8].settype("cute");
		srinfo[8].setname("[자칭 귀요미] 코시미즈 사치코");
		
		srinfo[8] = new Card();
		srinfo[8].settype("passion");
		srinfo[8].setname("[알레그로 기분] 마츠야마 쿠미코");
		
		srinfo[9] = new Card();
		srinfo[9].settype("passion");
		srinfo[9].setname("[해피 브라이덜] 나탈리아");
		
		srinfo[10] = new Card();
		srinfo[10].settype("passion");
		srinfo[10].setname("[아름다운 신부] 와쿠이 루미");
		for(int i=0; i<super.SRCardLimitednumber; i++){
			srinfo[i].setlev("SR");
			srinfo[i].setlimited(true);
		}
		
		return srinfo[k];
	}
	
}
/*
case k:{
srinfo[k].settype("");
srinfo[k].setname("");
return srinfo[k];		
}

*/