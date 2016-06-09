package Database;
public class SSRCard extends Card {
	Card[] ssrinfo = new Card [super.SSRCardnumber];
	public Card[] ssrinforeturn(){
		return ssrinfo;
	}
	public Card ssrinfo(int k){
		

		ssrinfo[0]=new Card();
		ssrinfo[0].settype("cute");
		ssrinfo[0].setname("[미스틱 엘릭서] 이치노세 시키 ");

		ssrinfo[1]=new Card();
		ssrinfo[1].settype("passion");
		ssrinfo[1].setname("[그레이트 프레젠트] 모로보시 키라리");		

		ssrinfo[2]=new Card();
		ssrinfo[2].settype("cute");
		ssrinfo[2].setname("[자칭·완벽] 코시미즈 사치코 ");	

		ssrinfo[3]=new Card();
		ssrinfo[3].settype("cute");
		ssrinfo[3].setname("[필 마이 하트] 사쿠마 마유 ");	

		ssrinfo[4]=new Card();
		ssrinfo[4].settype("cute");
		ssrinfo[4].setname("[캣 파티] 마에카와 미쿠");

		ssrinfo[5]=new Card();
		ssrinfo[5].settype("cute");
		ssrinfo[5].setname("[게으른 왕국] 후타바 안즈");		

		ssrinfo[6]=new Card();
		ssrinfo[6].settype("cute");
		ssrinfo[6].setname("[스테이지 오브 매직] 시마무라 우즈키");

		ssrinfo[7]=new Card();
		ssrinfo[7].settype("cool");
		ssrinfo[7].setname("[빛나는 한때] 호죠 카렌 ");

		ssrinfo[8]=new Card();
		ssrinfo[8].settype("cool");
		ssrinfo[8].setname("[오버 더 레인보우] 카미야 나오 ");

		ssrinfo[9]=new Card();
		ssrinfo[9].settype("cool");
		ssrinfo[9].setname("[엔들리스 나이트] 하야미 카나데 ");

		ssrinfo[10]=new Card();
		ssrinfo[10].settype("cool");
		ssrinfo[10].setname("[브라이트 메모리즈] 사기사와 후미카 ");

		ssrinfo[11]=new Card();
		ssrinfo[11].settype("cool");
		ssrinfo[11].setname("[노블 비너스] 닛타 미나미 ");

		ssrinfo[12]=new Card();
		ssrinfo[12].settype("cool");
		ssrinfo[12].setname("[장미의 암희] 칸자키 란코");

		ssrinfo[13]=new Card();
		ssrinfo[13].settype("cool");
		ssrinfo[13].setname("[스테이지 오브 매직] 시부야 린");

		ssrinfo[14]=new Card();
		ssrinfo[14].settype("passion");
		ssrinfo[14].setname("[매쉬업★볼테이지] 호시 쇼코");

		ssrinfo[15]=new Card();
		ssrinfo[15].settype("passion");
		ssrinfo[15].setname("[손으로 만드는 행복] 타카모리 아이코");

		ssrinfo[16]=new Card();
		ssrinfo[16].settype("passion");
		ssrinfo[16].setname("[풀스윙☆엘] 히메카와 유키");		

		ssrinfo[17]=new Card();
		ssrinfo[17].settype("passion");
		ssrinfo[17].setname("[친구가 잔뜩] 이치하라 니나");		

		ssrinfo[18]=new Card();
		ssrinfo[18].settype("passion");
		ssrinfo[18].setname("[스테이지 오브 매직] 혼다 미오");

		ssrinfo[19]=new Card();
		ssrinfo[19].settype("passion");
		ssrinfo[19].setname("[키라데코☆퍼레이드] 죠가사키 리카");			

		ssrinfo[20]=new Card();
		ssrinfo[20].settype("cute");
		ssrinfo[20].setname("[꽃잎 흩날리는 절경] 코바야카와 사에");
		//
		
		ssrinfo[21]=new Card();
		ssrinfo[21].settype("cool");
		ssrinfo[21].setname("[《우상》의 프래그먼트] 니노미야 아스카 ");
		
		ssrinfo[22]=new Card();
		ssrinfo[22].settype("passion");
		ssrinfo[22].setname("[꿈꾸는 프린세스] 키타 히나코");
		
		ssrinfo[23]=new Card();
		ssrinfo[23].settype("cute");
		ssrinfo[23].setname("[따뜻한 하트] 이가라시 쿄코");
		
		ssrinfo[24]=new Card();
		ssrinfo[24].settype("cool");
		ssrinfo[24].setname("[전율의 밤] 시라사카 코우메");
		
		ssrinfo[25]=new Card();
		ssrinfo[25].settype("cool");
		ssrinfo[25].setname("[애비뉴 모드] 미야모토 프레데리카");
		
		ssrinfo[26]=new Card();
		ssrinfo[26].settype("passion");
		ssrinfo[26].setname("[해신의 인도자] 요리타 요시노");
		
		ssrinfo[27]=new Card();
		ssrinfo[27].settype("passion");
		ssrinfo[27].setname("[발랄 하베스트] 오이카와 시즈쿠");
		
		for(int i=0; i<super.SSRCardnumber; i++){
			ssrinfo[i].setlev("SSR");
			ssrinfo[i].setlimited(false);
		}
		return ssrinfo[k];
	    
//	return ssrinfo[k];

	}}

/*
		case k:{
		ssrinfo[k].settype("");
		ssrinfo[k].setname("");
		return ssrinfo[k];		
		}
		
*/
