package Menu;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import Database.Card;
import GachaChargeMenu.TXTSave;

public class User{
	    public int jewel;
	    public int yen;
	    public int giftcard;
	    public int usedyen;
	    public int won;
	    public int usedwon;
	    public int usedjewel;
	    public int usedgiftcard;
		
	    public String name;
	    public int gameid;
		
	    public boolean limited;
	    public String limit;
	    
	    public ArrayList<Card> SSR = new ArrayList<Card>();
	    public ArrayList<Card> SR = new ArrayList<Card>();
	    public ArrayList<Card> R = new ArrayList<Card>();
	    public ArrayList<Card> LSSR = new ArrayList<Card>();
	    public ArrayList<Card> LSR = new ArrayList<Card>();
	    
	    public Card FCard=null;

		public int SSRNumber;
		public int SRNumber;
		public int RNumber;
		public int LSSRNumber;
		public int LSRNumber;
		
		public int cute=0;
		public int cool=0;
		public int passion=0;
		
		public int LSSRp=8;
		public int SSRp=14;
		public int LSRp=74;
		public int SRp=114;
		public int Rp=999;
		
		public double tempSSR=1.5;
		public double tempSR=10.0;
		
		public int Gacha=0;
		public int Yuncha=0;
		
		public int GachausedJewel=0;
		
		public int TypeGachaSetting=0;

		
		public void UserInfo(User user){
			String TypeGacha=null;
			if(TypeGachaSetting==0){TypeGacha="전속성";}
			else if(TypeGachaSetting==1){TypeGacha="큐트";}
			else if(TypeGachaSetting==2){TypeGacha="쿨";}
			else if(TypeGachaSetting==3){TypeGacha="패션";}
			
    		System.out.println("\t");
    		
    		System.out.println("기본정보");
    		System.out.println("프로듀서명 : "+name);
    		System.out.println("게임 ID : "+gameid);
    		try{System.out.println("선호 아이돌 : "+FCard.Valueof());}
    		catch(NullPointerException e){System.out.println("선호 아이돌 : 없음 ");}
    		if(limited){limit="yes";}else if(!limited){limit="no";}
    		System.out.println("한정 가챠 카드 출현 여부  : "+limit);
    		System.out.println("속성가챠 적용 여부 : "+TypeGacha);
    		System.out.println("\t"); 
    		System.out.println("소지 쥬엘 및 돈");
			System.out.println("소지 쥬엘 : "+jewel);
			System.out.println("소지 돈 : "+yen);
			System.out.println("소지 기프트카드 : "+giftcard);
			System.out.println();
			System.out.println("소지 카드");
    		if(RNumber!=0){System.out.println("R : "+RNumber);}
    		if(SRNumber!=0){System.out.println("SR : "+SRNumber);}
    		if(SSRNumber!=0){System.out.println("SSR : "+SSRNumber);}
    		if(LSRNumber!=0){System.out.println("한정SR : "+LSRNumber);}
    		if(LSSRNumber!=0){System.out.println("한정SSR : "+LSSRNumber);}
			System.out.println();
    		if(cute!=0){System.out.println("큐트 : "+cute);}
    		if(cool!=0){System.out.println("쿨 : "+cool);}
    		if(passion!=0){System.out.println("패션 : "+passion);}
			System.out.println();
			System.out.println("누적 정보");
			System.out.println("지금까지 결재된 기프트카드 : "+usedgiftcard);
			System.out.println("지금까지 결제된 돈(엔) : "+usedyen);
			System.out.println("지금까지 결제된 쥬엘 : "+usedjewel);
			System.out.println("지금까지 돌린 단챠의 횟수 : "+Gacha);
			System.out.println("지금까지 돌린 연챠의 횟수 : "+Yuncha);
			System.out.println("지금까지 사용된 쥬엘 : "+GachausedJewel);
    		System.out.println("\t");
		}
		
    	public void noCard(User user){
			System.out.println("소지하고 있는 카드가 없습니다");

    	}
		public void CardShow(User user){
			if(SSRNumber==0&&SRNumber==0&&RNumber==0&&LSSRNumber==0&&LSRNumber==0){
				this.noCard(user);
				System.out.println("엔터를 눌러 메인메뉴로 이동합니다");
				
				String temp;
				Scanner scanner = new Scanner(System.in);
				temp=scanner.nextLine();
				MainMenu.mainmenu(user);
			}
			if(!(SSRNumber==0)){
    		System.out.println("소지 카드 수");
    		System.out.println("SSR : "+SSRNumber);
            for (int i = 0; i<user.SSR.size(); i++) {
                System.out.println("SSR : " + SSR.get(i).Valueof());
            }}
			if(!(SRNumber==0)){
    		System.out.println("\t");
    		System.out.println("SR : "+SRNumber);
            for (int i = 0; i<user.SR.size(); i++) {
                System.out.println("SR : " + SR.get(i).Valueof());
            }}
            if(!(RNumber==0)){
    		System.out.println("\t");
    		System.out.println("R : "+RNumber);
	        for (int i = 0; i<user.R.size(); i++) {
	            System.out.println("R : " + R.get(i).Valueof());
	        }}
	        if(!(LSSRNumber==0)){
    		System.out.println("\t");
    		System.out.println("한정SSR : "+LSSRNumber);
            for (int i = 0; i<user.LSSR.size(); i++) {
                System.out.println("LSSR : " + LSSR.get(i).Valueof());
            }}
            if(!(LSRNumber==0)){
    		System.out.println("\t");
    		System.out.println("한정SR : "+LSRNumber);
            for (int i = 0; i<user.LSR.size(); i++) {
                System.out.println("LSR : " + LSR.get(i).Valueof());
            }}
//            this.datasave(user);
		}
		
		public void datasave(User user){
			Scanner scanner = new Scanner(System.in);
			System.out.print("이 정보를 txt로 저장하시겠습니까? (Y/N) >> ");
    		char choose2=scanner.next().charAt(0);
    		switch(choose2){
    		case'Y': case'y':{TXTSave.UserCardSave(user);}
       		case'N': case'n':{this.dialogshow(); MainMenu.mainmenu(user);}
    		default:{System.out.println("잘못 누르셨습니다.");this.datasave(user);}}
		}
		
		
		public void finalresult(User user){
			System.out.println("\t");
			    if(usedyen!=0){
			        System.out.println("지금까지 "+usedyen+"엔을 소비하여 "+(SSRNumber+LSSRNumber)+"개의 SSR,"+(SRNumber+LSRNumber)+"개의 SR, "+RNumber+"개의 R을 획득하셨습니다.");
			        if((SSRNumber+LSSRNumber)==0){
				        System.out.println("저런,"+usedyen+"엔을 써도 SSR을 획득하지 못했군요 ㅠㅠ");
			        } else if((SSRNumber+LSSRNumber)>0){
				        System.out.println(usedyen+"엔을 사용하고 "+(SSRNumber+LSSRNumber)+"장의 SSR을 획득하셨네요. 축하드립니다");
			        }
			    } else if(usedyen==0){
				    System.out.println("무과금 유저로 남으시는거군요. 그냥 지르시지.. - 센카와 치히로");
			}
			    this.finalquestion(user);
			    
		}
		
		public void finalquestion(User user){
			char temp;
			System.out.println("\t");
			System.out.print("더 돌리시는게 어떨까요? Y/N >> ");
			Scanner scanner = new Scanner(System.in);
    		temp=scanner.next().charAt(0);
    		switch(temp){
    		case 'Y': case'y':{
    		System.out.println("\t");System.out.println("자! 그럼 더 돌려봐여!");
    		MainMenu.mainmenu(user);
			break;
			}
    		case 'N': case'n':{	    		
    		System.out.println("\t");
    		System.out.println("May be ssrare in with you.. ");
    	    Robot tRobot = null;
			try {
				tRobot = new Robot();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    tRobot.delay(4500); 
    		System.exit(0);}
    	    default:{
    		    System.out.println("잘못 입력하셨습니다."); this.finalquestion(user);}
    	        }
			}

		
		
		public void thingreset(User user){
			char choose;
			char choose2;
			System.out.println("\t");
			System.out.println("무엇을 초기화하시겠습니까?");
			System.out.println("쥬엘 : Q ");
			System.out.println("기프트카드 : W");
			System.out.println("돈 : E");
			System.out.println("카드 : R");
			System.out.println("메인 메뉴로 : M");
			System.out.print("하실 일을 선택하세요 >> ");
			int yesno=4;
			Scanner scanner = new Scanner(System.in);
    		choose=scanner.next().charAt(0);
    		String thing=null;
			switch(choose){
    		case'Q': case'q':{thing="쥬엘";System.out.println(thing+"을 초기화 합니다.");yesno=0;break;}
    		case'W': case'w':{thing="기프트카드";System.out.println(thing+"를 초기화 합니다.");yesno=1;break;}
    		case'E': case'e':{thing="돈";System.out.println(thing+"을 초기화 합니다.");yesno=2;break;}
    		case'R': case'r':{thing="카드";System.out.println(thing+"를 초기화 합니다.");yesno=3;break;}
	    	case'M' : case'm':{user.dialogshow();MainMenu.mainmenu(user);break;}
    		default:{System.out.println("잘못 누르셨습니다.");MainMenu.mainmenu(user);}}
			System.out.println("정말"+thing+"을 초기화하시겠습니까?(Y/N) 다시 되돌릴 수 없습니다.");
    		choose2=scanner.next().charAt(0);
    		switch(choose2){
    		case'Y': case'y':{
    			if(yesno==0){System.out.println(thing+"이 초기화 되었습니다.");jewel=0;break;}
    			if(yesno==1){System.out.println(thing+"이 초기화 되었습니다.");giftcard=0;break;}
    			if(yesno==2){System.out.println(thing+"이 초기화 되었습니다.");won=0;yen=0;break;}
    			if(yesno==3){System.out.println(thing+"이 초기화 되었습니다.");
    			SSR.clear();
    			R.clear();
    			SR.clear();
    			LSSR.clear();
    			LSR.clear();
    			SSRNumber=0;
    			SRNumber=0;
    			RNumber=0;
    			LSSRNumber=0;
    			LSRNumber=0;
    		    break;}}
       		case'N': case'n':{System.out.println(thing+"이 초기화 되지 않습니다.");break;}
    		default:{System.out.println("잘못 누르셨습니다.");}}
		}
		
		public void dialogshow(){
			System.out.println("엔터를 눌러 메인메뉴로 이동합니다");
			String temp;
			Scanner scanner = new Scanner(System.in);
			temp=scanner.nextLine();
		}
		
		public void reinput(User user){
		    Scanner scanner = new Scanner(System.in);
//		    System.out.println("프로듀서 이름을 한글로 할 수 있습니다.");
		    System.out.print("프로듀서 이름을 입력하세요 >> ");

		    user.name=scanner.next();
			System.out.println("프로듀서 이름은 "+user.name+"입니다.");
		    do{System.out.print("게임 ID를 입력하세요 >> ");
			try {user.gameid = scanner.nextInt();}
			catch(InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다.");
				scanner.next();continue;}
			System.out.println("게임 ID는 "+user.gameid+"입니다.");
			MainMenu.mainmenu(user);}while(true);
		}
		
		public void FCardSelect(User user){
			ArrayList<Card> FCardList = new ArrayList<Card>();
			
		}
		
}
