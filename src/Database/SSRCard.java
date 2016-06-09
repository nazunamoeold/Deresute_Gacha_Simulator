package Database;
public class SSRCard extends Card {
	Card[] ssrinfo = new Card [super.SSRCardnumber];
	public Card[] ssrinforeturn(){
		return ssrinfo;
	}
	public Card ssrinfo(int k){
		

		ssrinfo[0]=new Card();
		ssrinfo[0].type="cute";
		ssrinfo[0].name="[미스틱 엘릭서] 이치노세 시키 ";

		ssrinfo[1]=new Card();
		ssrinfo[1].type="passion";
		ssrinfo[1].name="[그레이트 프레젠트] 모로보시 키라리";		

		ssrinfo[2]=new Card();
		ssrinfo[2].type="cute";
		ssrinfo[2].name="[자칭·완벽] 코시미즈 사치코 ";	

		ssrinfo[3]=new Card();
		ssrinfo[3].type="cute";
		ssrinfo[3].name="[필 마이 하트] 사쿠마 마유 ";	

		ssrinfo[4]=new Card();
		ssrinfo[4].type="cute";
		ssrinfo[4].name="[캣 파티] 마에카와 미쿠";

		ssrinfo[5]=new Card();
		ssrinfo[5].type="cute";
		ssrinfo[5].name="[게으른 왕국] 후타바 안즈";		

		ssrinfo[6]=new Card();
		ssrinfo[6].type="cute";
		ssrinfo[6].name="[스테이지 오브 매직] 시마무라 우즈키";

		ssrinfo[7]=new Card();
		ssrinfo[7].type="cool";
		ssrinfo[7].name="[빛나는 한때] 호죠 카렌 ";

		ssrinfo[8]=new Card();
		ssrinfo[8].type="cool";
		ssrinfo[8].name="[오버 더 레인보우] 카미야 나오 ";

		ssrinfo[9]=new Card();
		ssrinfo[9].type="cool";
		ssrinfo[9].name="[엔들리스 나이트] 하야미 카나데 ";

		ssrinfo[10]=new Card();
		ssrinfo[10].type="cool";
		ssrinfo[10].name="[브라이트 메모리즈] 사기사와 후미카 ";

		ssrinfo[11]=new Card();
		ssrinfo[11].type="cool";
		ssrinfo[11].name="[노블 비너스] 닛타 미나미 ";

		ssrinfo[12]=new Card();
		ssrinfo[12].type="cool";
		ssrinfo[12].name="[장미의 암희] 칸자키 란코";

		ssrinfo[13]=new Card();
		ssrinfo[13].type="cool";
		ssrinfo[13].name="[스테이지 오브 매직] 시부야 린";

		ssrinfo[14]=new Card();
		ssrinfo[14].type="passion";
		ssrinfo[14].name="[매쉬업★볼테이지] 호시 쇼코";

		ssrinfo[15]=new Card();
		ssrinfo[15].type="passion";
		ssrinfo[15].name="[손으로 만드는 행복] 타카모리 아이코";

		ssrinfo[16]=new Card();
		ssrinfo[16].type="passion";
		ssrinfo[16].name="[풀스윙☆엘] 히메카와 유키";		

		ssrinfo[17]=new Card();
		ssrinfo[17].type="passion";
		ssrinfo[17].name="[친구가 잔뜩] 이치하라 니나";		

		ssrinfo[18]=new Card();
		ssrinfo[18].type="passion";
		ssrinfo[18].name="[스테이지 오브 매직] 혼다 미오";

		ssrinfo[19]=new Card();
		ssrinfo[19].type="passion";
		ssrinfo[19].name="[키라데코☆퍼레이드] 죠가사키 리카";			

		ssrinfo[20]=new Card();
		ssrinfo[20].type="cute";
		ssrinfo[20].name="[꽃잎 흩날리는 절경] 코바야카와 사에";
		//
		
		ssrinfo[21]=new Card();
		ssrinfo[21].type="cool";
		ssrinfo[21].name="[《우상》의 프래그먼트] 니노미야 아스카 ";
		
		ssrinfo[22]=new Card();
		ssrinfo[22].type="passion";
		ssrinfo[22].name="[꿈꾸는 프린세스] 키타 히나코";
		
		ssrinfo[23]=new Card();
		ssrinfo[23].type="cute";
		ssrinfo[23].name="[따뜻한 하트] 이가라시 쿄코";
		
		ssrinfo[24]=new Card();
		ssrinfo[24].type="cool";
		ssrinfo[24].name="[전율의 밤] 시라사카 코우메";
		
		ssrinfo[25]=new Card();
		ssrinfo[25].type="cool";
		ssrinfo[25].name="[애비뉴 모드] 미야모토 프레데리카";
		
		ssrinfo[26]=new Card();
		ssrinfo[26].type="passion";
		ssrinfo[26].name="[해신의 인도자] 요리타 요시노";
		
		ssrinfo[27]=new Card();
		ssrinfo[27].type="passion";
		ssrinfo[27].name="[발랄 하베스트] 오이카와 시즈쿠 [1]";
		
		for(int i=0; i<super.SSRCardnumber; i++){
			ssrinfo[i].lev="SSR"; 
			ssrinfo[i].limited=false;
		}
		return ssrinfo[k];
	    
//	return ssrinfo[k];

	}}

/*
		case k:{
		ssrinfo[k].type="";
		ssrinfo[k].name="";
		return ssrinfo[k];		
		}
		
*/
