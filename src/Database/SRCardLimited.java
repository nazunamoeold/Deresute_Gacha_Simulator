package Database;
public class SRCardLimited extends Card {
	Card[] info = new Card [super.SRCardLimitednumber];
	public Card[] inforeturn(){
		return info;
	}
	public Card info(int k){
		
		info[0] = new Card();
		info[0].settype("cool");
		info[0].setname("[흑진주의 반짝임] 쿠로카와 치아키");
		
		info[1] = new Card();
		info[1].settype("cool");
		info[1].setname("[할로윈 나이트메어] 시라사카 코우메");
		
		info[2] = new Card();
		info[2].settype("passion");
		info[2].setname("[치유의 만월] 오이카와 시즈쿠");
		
		info[3] = new Card();
		info[3].settype("cute");
		info[3].setname("[스위트 크리스마스] 이가라시 쿄코");
		
		info[4] = new Card();
		info[4].settype("cute");
		info[4].setname("[대기만성] 도묘지 카린 ");
		
		info[5] = new Card();
		info[5].settype("cool");
		info[5].setname("[작은 자신가] 와키야마 타마미");
		
		info[6] = new Card();
		info[6].settype("cute");
		info[6].setname("[프리티 파티쉐] 나카노 유카");
		
		info[7] = new Card();
		info[7].settype("cute");
		info[7].setname("[모범생/고냥이] 마에카와 미쿠");
		
		info[8] = new Card();
		info[8].settype("cute");
		info[8].setname("[자칭 귀요미] 코시미즈 사치코");
		
		info[8] = new Card();
		info[8].settype("passion");
		info[8].setname("[알레그로 기분] 마츠야마 쿠미코");
		
		info[9] = new Card();
		info[9].settype("passion");
		info[9].setname("[해피 브라이덜] 나탈리아");
		
		info[10] = new Card();
		info[10].settype("passion");
		info[10].setname("[아름다운 신부] 와쿠이 루미");
		for(int i=0; i<super.SRCardLimitednumber; i++){
			info[i].setlev("SR");
			info[i].setlimited(true);
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