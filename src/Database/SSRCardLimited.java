package Database;
public class SSRCardLimited extends Card {
	public Card ssrinfo (int k){
		Card[] ssrinfo=new Card [super.SSRCardLimitednumber];
		
		ssrinfo[0] = new Card();
		ssrinfo[0].type="passion";
		ssrinfo[0].name="[해피 휩] 아카기 미리아 ";

		ssrinfo[1] = new Card();
		ssrinfo[1].type="cool";
		ssrinfo[1].name="[히트&비트] 타다 리이나 ";

		ssrinfo[2] = new Card();
		ssrinfo[2].type="cool";
		ssrinfo[2].name="[크리스탈 스노우] 아나스타샤";

		ssrinfo[3] = new Card();
		ssrinfo[3].type="cool";
		ssrinfo[3].name="[럭셔리 메모리] 카와시마 미즈키 ";

		ssrinfo[4] = new Card();
		ssrinfo[4].type="cool";
		ssrinfo[4].name="[밤바람의 유혹] 타카가키 카에데";

		ssrinfo[5] = new Card();
		ssrinfo[5].type="cute";
		ssrinfo[5].name="[화이트 위치] 미무라 카나코 ";

		ssrinfo[6] = new Card();
		ssrinfo[6].type="cute";
		ssrinfo[6].name="[꿈빛 클로버] 오가타 치에리 ";

		ssrinfo[7] = new Card();
		ssrinfo[7].type="cute";
		ssrinfo[7].name="[탱글탱글 우사밍] 아베 나나 ";

		ssrinfo[8] = new Card();
		ssrinfo[8].type="cute";
		ssrinfo[8].name="[유스풀 로맨스] 코히나타 미호 ";

		ssrinfo[9] = new Card();		
		ssrinfo[9].type="passion";
		ssrinfo[9].name="[하트★오버플로우] 죠가사키 미카";

		ssrinfo[10] = new Card();
		ssrinfo[10].type="passion";
		ssrinfo[10].name="[버닝 프레젠트] 히노 아카네";		

		ssrinfo[11] = new Card();
		ssrinfo[11].type="passion";
		ssrinfo[11].name="[펌프킨 파티] 토토키 아이리";		

		ssrinfo[12] = new Card();
		ssrinfo[12].type="cute";
		ssrinfo[12].name="[로즈 플뢰르] 사쿠라이 모모카";		

		ssrinfo[13] = new Card();
		ssrinfo[13].type="passion";
		ssrinfo[13].name="[권화상등] 무카이 타쿠미";		
		
		ssrinfo[14] = new Card();
		ssrinfo[14].type="cool";
		ssrinfo[14].name="[처음 짓는 표정] 타치바나 아리스 ";		
		
		ssrinfo[15] = new Card();
		ssrinfo[15].type="passion";
		ssrinfo[15].name="[이모셔널 비트] 키무라 나츠키 ";		
		
		for(int i=0; i<super.SSRCardLimitednumber; i++){
			ssrinfo[i].lev="SSR"; 
			ssrinfo[i].limited=true;
		}
		return ssrinfo[k];
	}
}


