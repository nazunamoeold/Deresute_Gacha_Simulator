package Database;
public class SSRCard extends Card {
	Card[] info = new Card [super.SSRCardnumber];
	public Card[] inforeturn(){
		return info;
	}
	public Card info(int k){

		info[0]=new Card();
		info[0].settype("cute");
		info[0].setname("[미스틱 엘릭서] 이치노세 시키 ");

		info[1]=new Card();
		info[1].settype("passion");
		info[1].setname("[그레이트 프레젠트] 모로보시 키라리");		

		info[2]=new Card();
		info[2].settype("cute");
		info[2].setname("[자칭·완벽] 코시미즈 사치코 ");	

		info[3]=new Card();
		info[3].settype("cute");
		info[3].setname("[필 마이 하트] 사쿠마 마유 ");	

		info[4]=new Card();
		info[4].settype("cute");
		info[4].setname("[캣 파티] 마에카와 미쿠");

		info[5]=new Card();
		info[5].settype("cute");
		info[5].setname("[게으른 왕국] 후타바 안즈");		

		info[6]=new Card();
		info[6].settype("cute");
		info[6].setname("[스테이지 오브 매직] 시마무라 우즈키");

		info[7]=new Card();
		info[7].settype("cool");
		info[7].setname("[빛나는 한때] 호죠 카렌 ");

		info[8]=new Card();
		info[8].settype("cool");
		info[8].setname("[오버 더 레인보우] 카미야 나오 ");

		info[9]=new Card();
		info[9].settype("cool");
		info[9].setname("[엔들리스 나이트] 하야미 카나데 ");

		info[10]=new Card();
		info[10].settype("cool");
		info[10].setname("[브라이트 메모리즈] 사기사와 후미카 ");

		info[11]=new Card();
		info[11].settype("cool");
		info[11].setname("[노블 비너스] 닛타 미나미 ");

		info[12]=new Card();
		info[12].settype("cool");
		info[12].setname("[장미의 암희] 칸자키 란코");

		info[13]=new Card();
		info[13].settype("cool");
		info[13].setname("[스테이지 오브 매직] 시부야 린");

		info[14]=new Card();
		info[14].settype("passion");
		info[14].setname("[매쉬업★볼테이지] 호시 쇼코");

		info[15]=new Card();
		info[15].settype("passion");
		info[15].setname("[손으로 만드는 행복] 타카모리 아이코");

		info[16]=new Card();
		info[16].settype("passion");
		info[16].setname("[풀스윙☆엘] 히메카와 유키");		

		info[17]=new Card();
		info[17].settype("passion");
		info[17].setname("[친구가 잔뜩] 이치하라 니나");		

		info[18]=new Card();
		info[18].settype("passion");
		info[18].setname("[스테이지 오브 매직] 혼다 미오");

		info[19]=new Card();
		info[19].settype("passion");
		info[19].setname("[키라데코☆퍼레이드] 죠가사키 리카");			

		info[20]=new Card();
		info[20].settype("cute");
		info[20].setname("[꽃잎 흩날리는 절경] 코바야카와 사에");
		//
		
		info[21]=new Card();
		info[21].settype("cool");
		info[21].setname("[《우상》의 프래그먼트] 니노미야 아스카 ");
		
		info[22]=new Card();
		info[22].settype("passion");
		info[22].setname("[꿈꾸는 프린세스] 키타 히나코");
		
		info[23]=new Card();
		info[23].settype("cute");
		info[23].setname("[따뜻한 하트] 이가라시 쿄코");
		
		info[24]=new Card();
		info[24].settype("cool");
		info[24].setname("[전율의 밤] 시라사카 코우메");
		
		info[25]=new Card();
		info[25].settype("cool");
		info[25].setname("[애비뉴 모드] 미야모토 프레데리카");
		
		info[26]=new Card();
		info[26].settype("passion");
		info[26].setname("[해신의 인도자] 요리타 요시노");
		
		info[27]=new Card();
		info[27].settype("passion");
		info[27].setname("[발랄 하베스트] 오이카와 시즈쿠");
		
		for(int i=0; i<super.SSRCardnumber; i++){
			info[i].setlev("SSR");
			info[i].setlimited(false);
		}
		return info[k];
	    
//	return info[k];

	}}

/*
		case k:{
		info[k].settype("");
		info[k].setname("");
		return info[k];		
		}
		
*/
