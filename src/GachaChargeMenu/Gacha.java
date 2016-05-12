package GachaChargeMenu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import Menu.User;
import Menu.MainMenu;
import Database.*;
public class Gacha{
	

	int tempCardNumber[] = new int[5];
    Scanner scanner = new Scanner(System.in);
    Card card = new Card();
    SSRCard ssr = new SSRCard();
    SRCard sr = new SRCard();
    RCard r = new RCard();
    SSRCardLimited lssr = new SSRCardLimited();
    SRCardLimited lsr = new SRCardLimited();
    Card returncard = null;
	int cute=0;
	int cool=0;
	int passion=0;
    
    public boolean TXT=true;
	public String txt="Yes";
	public int FCard=0;

        private void Probabilityreset(User user){
        	user.LSSRp=8;
        	user.SSRp=14;
        	user.LSRp=74;
        	user.SRp =114;
        	user.Rp=999;
        }
	    
	    public void Probability(User user){
	    	
	    	char temp;
	    	System.out.println();
	    	System.out.println("   Probability Change Menu");
	    	System.out.println("기본 설정으로 복귀 : G");
	    	System.out.println("신데렐라 페스 설정 (SSR확률 3%) : P");
	    	System.out.println("사용자 직접 설정 : E");
	    	System.out.println("현재 확률 확인 : H");
	    	System.out.println("메인 메뉴로 이동 : M");

	    	System.out.println();
	    	System.out.print("하실 일을 선택하세요 >> ");
	    	temp=scanner.next().charAt(0);
	    	switch(temp){
	    	case'G': case'g':{	
	    		user.LSSRp=8;
	    		user.SSRp=14;
	    		user.LSRp=74;
	    		user.SRp=114;
	    		user.Rp=999;
	    		user.tempSSR=1.5;
	    		user.tempSR=10.0;
	    		this.ProbabilityCheck(user);
	    		break;}
	    	case'P': case'p':{
	    		user.LSSRp=16;
	    		user.SSRp=29;
	    		user.LSRp=79;
	    		user.SRp=129;
	    		user.Rp=999;
	    		user.tempSSR=3.0;
	    		user.tempSR=10.0;
	    		this.ProbabilityCheck(user);
	    		break;}
	    	case'E': case'e':{
	    		this.ProbabilityChange(user);
	    		break;}
	    	case'H': case'h':{
	    		this.ProbailityInfo(user);
	    		break;
	    	}

	    	case'M': case'm':{MainMenu.mainmenu(user);
	    		
	    	}
	    	default:{System.out.println("잘못 입력하셨습니다.");break;}
	    	}	
	    }
	    
	    private void ProbabilityChange(User user){
    		System.out.println();
    		System.out.print("SSR확률 >> ");
    		try{user.tempSSR=scanner.nextDouble();}
			catch(InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다.");
				this.ProbabilityChange(user);
			}
    		user.SSRp=(int) (999*(user.tempSSR*0.01));

    		if(user.tempSSR>=100){
    			System.out.println("SSR확률은 100을 넘을 수 없습니다.");
				this.ProbabilityChange(user);
    		}
    		user.LSSRp=(int) (user.SSRp/7*4);
    	    System.out.print("SR확률 >> ");
    	    try{user.tempSR=scanner.nextDouble();}
			catch(InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다.");
				this.ProbabilityChange(user);
			}
    	    user.SRp=(int) (999*(user.tempSR*0.01));

    		if(user.tempSR>=100){
    			System.out.println("SR확률은 100을 넘을 수 없습니다.");
				this.ProbabilityChange(user);
    		}
    		if(user.tempSR+user.tempSSR>=100){
    			System.out.println("SR확률+SSR확률이 100을 넘을 수 없습니다.");
				this.ProbabilityChange(user);
    		}
    		user.LSRp=(int) (user.SRp/7*4);
    		System.out.println("R확률은 자동으로 정해집니다.");
    		this.ProbabilityCheck(user);
	    }
	    
	    public void ProbabilityCheck(User user){
    		System.out.println();
    		System.out.println("확률을 아래와 같이 지정합니다");
    		System.out.println("SSR 확률 : "+user.tempSSR+"%");
    		System.out.println("SR 확률 : "+user.tempSR+"%");
    		System.out.println("R 확률 : "+(100-(user.tempSSR+user.tempSR))+"%");
    		System.out.println();
    		System.out.print("이대로 저장하시려면 Y, 다시 정하시려면 N을 눌러 주십시오. >> ");
    		char temp;
	    	temp=scanner.next().charAt(0);
	    	switch(temp){
	    	case'Y': case'y':{this.dialogshow();break;}
	    	case'N' : case'n':{this.Probability(user);break;}
	    	default:{System.out.println("잘못 입력하셨습니다.");this.ProbabilityCheck(user);break;}}
	    }
	    
	    public void ProbailityInfo(User user){
    		System.out.println("SSR 확률 : "+user.tempSSR+"%");
    		System.out.println("SR 확률 : "+user.tempSR+"%");
    		System.out.println("R 확률 : "+(100-(user.tempSSR+user.tempSR))+"%");
    		this.dialogshow();
	    }
	    
	    public void TXT(){
			TXT=!TXT;
			System.out.println("\t");
			if(TXT){txt="yes";}else if(!TXT){txt="no";}
			System.out.println("TXT저장 여부 : "+txt);
	    	}
	    

		public void gachago (User user,int i, int y){
		    System.out.println();
		    System.out.println("뽑은 카드");
	    	for(int k=0; k<5; k++){
	    		tempCardNumber[k]=0;}
	    	if(user.limited){this.unlimited(user, i,y);}
	    	if(!user.limited){this.limited(user,i,y);}
	    	System.out.println();
		    System.out.println("결과 발표");
		    if(!(tempCardNumber[0]==0)){System.out.println("SSR : "+tempCardNumber[0]);}
		    if(!(tempCardNumber[1]==0)){System.out.println("SR : "+tempCardNumber[1]);}
		    if(!(tempCardNumber[2]==0)){System.out.println("R : "+tempCardNumber[2]);}
		    if(!(tempCardNumber[3]==0)){System.out.println("한정 SSR : "+tempCardNumber[3]);}
		    if(!(tempCardNumber[4]==0)){System.out.println("한정 SR : "+tempCardNumber[4]);}
		    System.out.println();
		    if(cute!=0){System.out.println("큐트 : "+cute);}
		    if(cool!=0){System.out.println("쿨 : "+cool);}
		    if(passion!=0){System.out.println("패션 : "+passion);}
//		    if(!(FCard==0)){System.out.println("선호 아이돌 : "+FCard);}
		    System.out.println();
//	    	if(this.TXT){
//	    		System.out.println("가챠 결과를 txt파일로 저장합니다.");
//		    	TXTSave.GachaResultSave(tempGachaCard, i+y, tempCardNumber[0], tempCardNumber[1], tempCardNumber[2], tempCardNumber[3], tempCardNumber[4]);
//	    	}
		    this.dialogshow();}
	    	

	    
	    public void gachamenu (User user){
	    	char temp;

	    	Scanner scanner = new Scanner(System.in);
	    	System.out.println();
			System.out.println("          Gacha Menu         ");
	    	System.out.println("어떤 가챠를 돌리시겠습니까?");
	    	System.out.println();
	    	System.out.println("단챠 : D");
	    	System.out.println("연챠 : Y");
	    	System.out.println("연금단챠 : E");
	    	System.out.println("연속단챠 : T");
	    	System.out.println("연속연챠 : R");
	    	if(TXT){txt="yes";}else if(!TXT){txt="no";}
//	    	System.out.println("TXT파일 저장 여부 : "+txt+" 조정 : L");
	    	System.out.println("속성가챠 : P");
	    	System.out.println("SSR나올 때까지 무한단챠 : I");
	    	System.out.println("메인 메뉴로 : M");
	    	System.out.println();
	    	System.out.print("하실 일을 선택하세요 >> ");
	    	temp=scanner.next().charAt(0);
	    	switch(temp){
//	    	case'L': case'l':{this.TXT();this.gachamenu(user);break;}
	    	case'D': case'd':{this.danchaone(user);break;}
	    	case'Y': case'y':{this.yunchaone(user);break;}
	    	case'E': case'e':{this.yungumdancha(user);break;}
	    	case'R': case'r':{this.yunchas(user);break;}
	    	case'T': case't':{this.danchas(user);break;}
	    	case'P': case'p':{this.typegachamenu(user);break;}
	    	case'I': case'i':{this.InfiniteGacha(user);break;}
	    	case'M' : case'm':{user.dialogshow();MainMenu.mainmenu(user);break;}
	    	default:{System.out.println("잘못 입력하셨습니다.");this.gachamenu(user);break;}
	    	}
	    }
	    
	    public void typegachamenu (User user){
	    	Scanner scanner = new Scanner(System.in);
	    	System.out.println();
			System.out.println("        Type Gacha Menu       ");
	    	System.out.println("어떤 SSR 카드만 나오게 하시겠습니까?");
	    	System.out.println();
	    	System.out.println("전속성 : A");
	    	System.out.println("큐트 : C");
	    	System.out.println("쿨 : O");
	    	System.out.println("패션 : P");
	    	System.out.println("전 메뉴로 : M");
	    	char temp=scanner.next().charAt(0);
	    	switch(temp){
	    	case'A': case'a':{user.TypeGachaSetting=0;break;}
	    	case'C': case'c':{user.TypeGachaSetting=1;break;}
	    	case'O': case'o':{user.TypeGachaSetting=2;break;}
	    	case'P': case'p':{user.TypeGachaSetting=3;break;}
	    	case'M' : case'm':{user.dialogshow();this.gachamenu(user);break;}
	    	default:{System.out.println("잘못 입력하셨습니다.");this.typegachamenu(user);break;}
	    	}
	    }
	    
	    public int checknumber (User user){
    		System.out.println("\t");
    		System.out.print("돌릴 횟수를 입력하세요 >> ");
    		int temp=0;
    		Scanner scanner = new Scanner(System.in);
    		try {temp = scanner.nextInt();}
    		catch(InputMismatchException e) {
    			System.out.println("잘못 입력하셨습니다.");
    			System.out.println("\t");
    			scanner.next();
    			MainMenu.mainmenu(user);
    		}
    		return temp;
	    }
	    
	    
	    public boolean checkjewel(User user, int i){
	    	if(user.jewel<i){
	    		int n;
	    		n=i-user.jewel;
	    		System.out.println("쥬엘이 "+n+"개 부족합니다. 쥬엘을 충전하세요.");
	    		this.dialogshow();
	    		MainMenu.mainmenu(user);
	    		return false;
	    	}
	    	return true;
	    	
	    }
		
	    public void danchaone(User user){
			System.out.println("\t");
			System.out.println("단챠를 돌리겠습니다.");
			this.dancha(user);
		}
	    
		public void dancha(User user){
			this.checkjewel(user, 250);			
			user.jewel=user.jewel-250;
			user.GachausedJewel+=250;
			user.Gacha+=1;
			this.gachago(user,1,0);
		}
		
		public void danchas(User user){
			int temp=this.checknumber(user);
			this.checkjewel(user, 250*temp);			
			user.jewel=user.jewel-(250*temp);
			user.GachausedJewel+=(250*temp);
			user.Gacha+=(1*temp);
			this.gachago(user,temp,0);
		}
		
		public void yunchas(User user){
			System.out.println("\t");
			System.out.println("연챠를 돌리겠습니다.");
			int temp=this.checknumber(user);
			this.checkjewel(user, 2500*temp);
			user.jewel=user.jewel-(2500*temp);
			user.GachausedJewel+=(2500*temp);
			user.Yuncha+=(1*temp);
			this.gachago(user,(9*temp)+(temp-1),1);
		}
		
		public void yunchaone(User user){
			System.out.println("\t");
			System.out.println("연챠를 돌리겠습니다.");
			this.checkjewel(user, 2500);
			user.jewel=user.jewel-2500;
			user.GachausedJewel+=2500;
			user.Yuncha+=1;
			this.gachago(user, 9,1);
		}
		
		public void yungumdancha(User user){
			System.out.println("\t");
			this.checkjewel(user, 60);
			System.out.println("연금가챠를 돌리겠습니다.");
			user.Gacha+=1;
			user.GachausedJewel+=60;
			this.dancha(user);
			user.jewel+=190;
		}
		
		public void dialogshow(){
			System.out.println("엔터를 눌러 메인메뉴로 이동합니다");
			Scanner scanner = new Scanner(System.in);
			String temp=scanner.nextLine();
		}
		
		public void unlimited(User user, int i, int y){
			Random random = new Random();
			int temp;
			int x=1;
			int t=0;
			
			for(int j=0; j<i; j++){
    			temp=random.nextInt(999);
    			if(temp<=user.LSSRp){System.out.println(this.LSSRadd(user, user.TypeGachaSetting).Valueof());}
    			else if(temp<=user.SSRp){System.out.println(this.SSRadd(user, user.TypeGachaSetting).Valueof());}
    			else if(temp<=user.LSRp){System.out.println(this.LSRadd(user).Valueof());}
    			else if(temp<=user.SRp){System.out.println(this.SRadd(user).Valueof());}
    			else if(temp<=user.Rp){System.out.println(this.Radd(user).Valueof());}    	
    		if(j==((9*x)-1)&&y==1){
    			j++;
    			temp=random.nextInt(user.SRp);
    			if(temp<=user.LSSRp){System.out.println(this.LSSRadd(user, user.TypeGachaSetting).Valueof());}
    			else if(temp<=user.SSRp){System.out.println(this.SSRadd(user, user.TypeGachaSetting).Valueof());}
    			else if(temp<=user.LSRp){System.out.println(this.LSRadd(user).Valueof());}
    			else if(temp<=user.SRp){System.out.println(this.SRadd(user).Valueof());}
    			x++;}
//			TXTSave.GachaResultSave(tempGachaCard, i, tempCardNumber[0], tempCardNumber[1], tempCardNumber[2], tempCardNumber[3], tempCardNumber[4]);
			}    				
		}
		
		public void limited(User user, int i, int y){
			Random random = new Random();
			int temp;
			int x=1;
    		for(int j=0; j<i; j++){
    			temp=random.nextInt(999);
    			if(temp<=user.SSRp){System.out.println(this.SSRadd(user, user.TypeGachaSetting).Valueof());}
    			else if(temp<=user.SRp){System.out.println(this.SRadd(user).Valueof());}
    			else if(temp<=user.Rp){System.out.println(this.Radd(user).Valueof());} 	
    		if(j==((9*x)-1)&&y==1){
    			j++;
    			temp=random.nextInt(user.SRp);
    			if(temp<=user.SSRp){System.out.println(this.SSRadd(user,user.TypeGachaSetting).Valueof());}
    			else if(temp<=user.SRp){System.out.println(this.SRadd(user).Valueof());}
    		x++;}
//    		TXTSave.GachaResultSave(tempGachaCard, i, tempCardNumber[0], tempCardNumber[1], tempCardNumber[2], tempCardNumber[3], tempCardNumber[4]);
		}		

    }
	   	public Card LSSRadd(User user, int j){
	   		
    		Random random = new Random();
    		int k=0;
    		tempCardNumber[3]++; 
    		++user.LSSRNumber;
    		lssr.ssrinfo(k);
    		if(j==0){
    			k = random.nextInt(card.SSRCardLimitednumber);
        		user.SSR.add(lssr.ssrinfo(k));
        		this.typecount(user, lssr.ssrinfo(k));
        		returncard=lssr.ssrinfo(k);
    		}
    		else if(j==1){
    			k = random.nextInt(card.CuteSSRLimitedList().size());
        		user.SSR.add(card.CuteSSRLimitedList().get(k));
        		cute++;user.cute++;
        		returncard=card.CuteSSRLimitedList().get(k);
    		}
    		else if(j==2){
    			k = random.nextInt(card.CoolSSRLimitedList().size());
        		user.SSR.add(card.CoolSSRLimitedList().get(k));
        		cool++;user.cool++;
        		returncard=card.CoolSSRLimitedList().get(k);
    		}
    		else if(j==3){
    			k = random.nextInt(card.PassionSSRLimitedList().size());
        		user.SSR.add(card.PassionSSRLimitedList().get(k));
        		passion++;user.passion++;
        		returncard=card.PassionSSRLimitedList().get(k);
    		}  return returncard;
    	}
    	public Card SSRadd(User user, int j){
    		Random random = new Random();
    		int k = 0;
    		tempCardNumber[0]++; 
    		ssr.ssrinfo(k);
    		++user.SSRNumber;
    		if(j==0){
    			k = random.nextInt(card.SSRCardnumber);
        		this.typecount(user, ssr.ssrinfo(k));
        		user.SSR.add(ssr.ssrinfo(k));
        		returncard=ssr.ssrinfo(k);
    		}
    		else if(j==1){
    			k = random.nextInt(card.CuteSSRList().size());
        		user.SSR.add(card.CuteSSRList().get(k));
        		cute++;user.cute++;
        		returncard=card.CuteSSRList().get(k);
    		}
    		else if(j==2){
    			k = random.nextInt(card.CoolSSRList().size());
        		user.SSR.add(card.CoolSSRList().get(k));
        		cool++;user.cool++;
        		returncard=card.CoolSSRList().get(k);
    		}
    		else if(j==3){
    			k = random.nextInt(card.PassionSSRList().size());
        		user.SSR.add(card.PassionSSRList().get(k));
        		passion++;user.passion++;
        		returncard=card.PassionSSRList().get(k);
    		}return returncard;
    	}
    	public Card LSRadd(User user){
    		Random random = new Random();
    		int k = 0;
    		tempCardNumber[4]++;
    		lsr.srinfo(k);
    		++user.LSRNumber;
    		k = random.nextInt(card.SRCardLimitednumber);
       		this.typecount(user, lsr.srinfo(k));
    		user.LSR.add(lsr.srinfo(k));
    		returncard=lsr.srinfo(k);
    		return returncard;
    	}
    	public Card SRadd(User user){
    		Random random = new Random();
    		int k=0;
    		tempCardNumber[1]++;
    		sr.srinfo(k);
    		++user.SRNumber;
    		k = random.nextInt(sr.SRCardnumber);
    		this.typecount(user, sr.srinfo(k));
    		user.SR.add(sr.srinfo(k));
    		returncard=sr.srinfo(k);
    		return returncard;
    	}
    	public Card Radd(User user){
    		Random random = new Random();
    		int k=0;
    		tempCardNumber[2]++; 
    		++user.RNumber;
    		k = random.nextInt(r.RCardnumber);
    		this.typecount(user, r.rinfo(k));
    		user.R.add(r.rinfo(k));
    		returncard=r.rinfo(k);
    		return returncard;
    	}
    	
    	public void typecount(User user, Card card){
    		if(card.type.equals("cute")){cute++;user.cute++;}
    		else if(card.type.equals("cool")){cool++;user.cool++;}
    		else if(card.type.equals("passion")){passion++;user.passion++;}
    	}
    	
    	public void debuginput(User user){
    		Random random = new Random();
    		int k=random.nextInt(card.CoolSSRList().size());
    		System.out.println(card.CoolSSRList().get(k).Valueof());
    	}    	
    	
    	public void InfiniteGacha(User user){
    		System.out.println("SSR이 나올때까지 단챠를 반복합니다");
	    	for(int k=0; k<5; k++){
    		tempCardNumber[k]=0;}
	    	
	    	this.checkjewel(user, 250);
	    	
	    	do{if(this.checkjeweladv(user, 250)==false){System.out.println("SSR을 뽑진 못했지만 쥬엘이 부족합니다!");break;}user.GachausedJewel+=250;user.jewel-=250;user.Gacha++;
	    	if(user.limited){this.unlimited(user, 1,0);}
    		if(!user.limited){this.limited(user, 1,0);}
    		if(tempCardNumber[0]==1){break;}if(tempCardNumber[3]==1){break;}}while(true);
	    	
	    	System.out.println();
		    System.out.println("결과 발표");
		    if(!(tempCardNumber[0]==0)){System.out.println("SSR : "+tempCardNumber[0]);}
		    if(!(tempCardNumber[1]==0)){System.out.println("SR : "+tempCardNumber[1]);}
		    if(!(tempCardNumber[2]==0)){System.out.println("R : "+tempCardNumber[2]);}
		    if(!(tempCardNumber[3]==0)){System.out.println("한정 SSR : "+tempCardNumber[3]);}
		    if(!(tempCardNumber[4]==0)){System.out.println("한정 SR : "+tempCardNumber[4]);}
		    if(tempCardNumber[0]==0){}
		    System.out.println();
		    if(cute!=0){System.out.println("큐트 : "+cute);}
		    if(cool!=0){System.out.println("쿨 : "+cool);}
		    if(passion!=0){System.out.println("패션 : "+passion);}
	    	}
    	
    	public boolean checkjeweladv(User user, int i){
    	    if(user.jewel<i){
    	    	return false;
    	   	}
    	   	return true;   	
    	}
    	
    	
    	
    	public void debugshow(User user){
     		for(int l=0; l<user.LSSR.size(); l++){
     			ArrayList<Card> LSSR = new ArrayList<Card>();
     			System.out.println(LSSR.get(l).Valueof());
     		}

    	}

}			
