package Database;
public class SSRCardLimited extends Card {
	Card[] info=new Card [super.SSRCardLimitednumber];
	public Card[] inforeturn(){
		return info;
	}
	public Card info (int k){
		
		info[0] = new Card();
		info[0].settype("passion");
		info[0].setname("[해피 휩] 아카기 미리아 ");

		info[1] = new Card();
		info[1].settype("cool");
		info[1].setname("[히트&비트] 타다 리이나 ");

		info[2] = new Card();
		info[2].settype("cool");
		info[2].setname("[크리스탈 스노우] 아나스타샤");

		info[3] = new Card();
		info[3].settype("cool");
		info[3].setname("[럭셔리 메모리] 카와시마 미즈키 ");

		info[4] = new Card();
		info[4].settype("cool");
		info[4].setname("[밤바람의 유혹] 타카가키 카에데");

		info[5] = new Card();
		info[5].settype("cute");
		info[5].setname("[화이트 위치] 미무라 카나코 ");

		info[6] = new Card();
		info[6].settype("cute");
		info[6].setname("[꿈빛 클로버] 오가타 치에리 ");

		info[7] = new Card();
		info[7].settype("cute");
		info[7].setname("[탱글탱글 우사밍] 아베 나나 ");

		info[8] = new Card();
		info[8].settype("cute");
		info[8].setname("[유스풀 로맨스] 코히나타 미호 ");

		info[9] = new Card();		
		info[9].settype("passion");
		info[9].setname("[하트★오버플로우] 죠가사키 미카");

		info[10] = new Card();
		info[10].settype("passion");
		info[10].setname("[버닝 프레젠트] 히노 아카네");		

		info[11] = new Card();
		info[11].settype("passion");
		info[11].setname("[펌프킨 파티] 토토키 아이리");		

		info[12] = new Card();
		info[12].settype("cute");
		info[12].setname("[로즈 플뢰르] 사쿠라이 모모카");		

		info[13] = new Card();
		info[13].settype("passion");
		info[13].setname("[권화상등] 무카이 타쿠미");		
		
		info[14] = new Card();
		info[14].settype("cool");
		info[14].setname("[처음 짓는 표정] 타치바나 아리스");		
		
		info[15] = new Card();
		info[15].settype("passion");
		info[15].setname("[이모셔널 비트] 키무라 나츠키");	
		
		info[16] = new Card();
		info[16].settype("cool");
		info[16].setname("[기다려지는 운명의 사람] 칸자키 란코");

		info[17] = new Card();
		info[17].settype("cute");
		info[17].setname("[드리밍 브라이드] 마에카와 미쿠");
		
		for(int i=0; i<super.SSRCardLimitednumber; i++){
			info[i].setlev("SSR"); 
			info[i].setlimited(true);
		}
		return info[k];
	}
}


