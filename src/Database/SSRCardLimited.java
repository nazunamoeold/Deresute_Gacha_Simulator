package Database;
public class SSRCardLimited extends Card {
	Card[] ssrinfo=new Card [super.SSRCardLimitednumber];
	public Card[] ssrinforeturn(){
		return ssrinfo;
	}
	public Card ssrinfo (int k){
		
		ssrinfo[0] = new Card();
		ssrinfo[0].settype("passion");
		ssrinfo[0].setname("[해피 휩] 아카기 미리아 ");

		ssrinfo[1] = new Card();
		ssrinfo[1].settype("cool");
		ssrinfo[1].setname("[히트&비트] 타다 리이나 ");

		ssrinfo[2] = new Card();
		ssrinfo[2].settype("cool");
		ssrinfo[2].setname("[크리스탈 스노우] 아나스타샤");

		ssrinfo[3] = new Card();
		ssrinfo[3].settype("cool");
		ssrinfo[3].setname("[럭셔리 메모리] 카와시마 미즈키 ");

		ssrinfo[4] = new Card();
		ssrinfo[4].settype("cool");
		ssrinfo[4].setname("[밤바람의 유혹] 타카가키 카에데");

		ssrinfo[5] = new Card();
		ssrinfo[5].settype("cute");
		ssrinfo[5].setname("[화이트 위치] 미무라 카나코 ");

		ssrinfo[6] = new Card();
		ssrinfo[6].settype("cute");
		ssrinfo[6].setname("[꿈빛 클로버] 오가타 치에리 ");

		ssrinfo[7] = new Card();
		ssrinfo[7].settype("cute");
		ssrinfo[7].setname("[탱글탱글 우사밍] 아베 나나 ");

		ssrinfo[8] = new Card();
		ssrinfo[8].settype("cute");
		ssrinfo[8].setname("[유스풀 로맨스] 코히나타 미호 ");

		ssrinfo[9] = new Card();		
		ssrinfo[9].settype("passion");
		ssrinfo[9].setname("[하트★오버플로우] 죠가사키 미카");

		ssrinfo[10] = new Card();
		ssrinfo[10].settype("passion");
		ssrinfo[10].setname("[버닝 프레젠트] 히노 아카네");		

		ssrinfo[11] = new Card();
		ssrinfo[11].settype("passion");
		ssrinfo[11].setname("[펌프킨 파티] 토토키 아이리");		

		ssrinfo[12] = new Card();
		ssrinfo[12].settype("cute");
		ssrinfo[12].setname("[로즈 플뢰르] 사쿠라이 모모카");		

		ssrinfo[13] = new Card();
		ssrinfo[13].settype("passion");
		ssrinfo[13].setname("[권화상등] 무카이 타쿠미");		
		
		ssrinfo[14] = new Card();
		ssrinfo[14].settype("cool");
		ssrinfo[14].setname("[처음 짓는 표정] 타치바나 아리스");		
		
		ssrinfo[15] = new Card();
		ssrinfo[15].settype("passion");
		ssrinfo[15].setname("[이모셔널 비트] 키무라 나츠키");	
		
		ssrinfo[16] = new Card();
		ssrinfo[16].settype("cool");
		ssrinfo[16].setname("[기다려지는 운명의 사람] 칸자키 란코");

		ssrinfo[17] = new Card();
		ssrinfo[17].settype("cute");
		ssrinfo[17].setname("[드리밍 브라이드] 마에카와 미쿠");
		
		for(int i=0; i<super.SSRCardLimitednumber; i++){
			ssrinfo[i].setlev("SSR"); 
			ssrinfo[i].setlimited(true);
		}
		return ssrinfo[k];
	}
}


