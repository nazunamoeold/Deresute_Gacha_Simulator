package Database;

import java.util.ArrayList;
import java.util.Scanner;

import Menu.MainMenu;
import Menu.User;

public class Card {
	
	ArrayList<Card> CuteSSR = new ArrayList<Card>();
	ArrayList<Card> CoolSSR = new ArrayList<Card>();
	ArrayList<Card> PassionSSR = new ArrayList<Card>();
	
	public String type;
	public String lev;
	public String name;
	public boolean limited;
	
	public final int SSRCardnumber = 25;
	public final int SRCardnumber = 49;
	public final int RCardnumber= 66;
	public final int SRCardLimitednumber = 9;
	public final int SSRCardLimitednumber = 16;
	
//	public int life;
//	public int dance;
//	public int vocal;
//	public int visual;
//	public int sum=dance+vocal+visual;
//	
//	public String CenterSkill;
//	public String Skill;
	public String Valueof() {
		return "[" + this.getlev() + "] [" + this.gettype() + "] " + this.getname() ;
	}
	public String getlev(){
		return lev;
	}
	public String getname(){
		return name;
	}
	public String gettype(){
		return type;
	}
	
	public ArrayList<Card> CuteSSRList() {
		SSRCard SSRCard = new SSRCard();
		SSRCardLimited SSRCardLimited = new SSRCardLimited();
		
		for(int i=0; i<SSRCardnumber; i++){
			if(SSRCard.ssrinfo(i).gettype().equals("cute")){CuteSSR.add(SSRCard.ssrinfo(i));}
		}
		for(int i=0; i<SSRCardLimitednumber; i++){
			if(SSRCardLimited.ssrinfo(i).gettype().equals("cute")){CuteSSR.add(SSRCardLimited.ssrinfo(i));}
		}
		return CuteSSR;
	}
	
	public ArrayList<Card> CuteSSRLimitedList() {
		SSRCard SSRCard = new SSRCard();
		SSRCardLimited SSRCardLimited = new SSRCardLimited();
		
		for(int i=0; i<SSRCardnumber; i++){
			if(SSRCard.ssrinfo(i).gettype().equals("cute")){CuteSSR.add(SSRCard.ssrinfo(i));}
		}
		return CuteSSR;
	}
	
	public ArrayList<Card> CoolSSRList() {
		SSRCard SSRCard = new SSRCard();
		SSRCardLimited SSRCardLimited = new SSRCardLimited();
		
		for(int i=0; i<SSRCardnumber; i++){
			if(SSRCard.ssrinfo(i).gettype().equals("cool")){CoolSSR.add(SSRCard.ssrinfo(i));}
		}
		for(int i=0; i<SSRCardLimitednumber; i++){
			if(SSRCardLimited.ssrinfo(i).gettype().equals("cool")){CoolSSR.add(SSRCardLimited.ssrinfo(i));}
		}
		return CoolSSR;
	}
	
	public ArrayList<Card> CoolSSRLimitedList() {
		SSRCard SSRCard = new SSRCard();
		SSRCardLimited SSRCardLimited = new SSRCardLimited();
		
		for(int i=0; i<SSRCardnumber; i++){
			if(SSRCard.ssrinfo(i).gettype().equals("cool")){CoolSSR.add(SSRCard.ssrinfo(i));}
		}
		return CoolSSR;
	}
	
	public ArrayList<Card> PassionSSRList() {
		SSRCard SSRCard = new SSRCard();
		SSRCardLimited SSRCardLimited = new SSRCardLimited();
		
		for(int i=0; i<SSRCardnumber; i++){
			if(SSRCard.ssrinfo(i).gettype().equals("passion")){PassionSSR.add(SSRCard.ssrinfo(i));}
		}
		for(int i=0; i<SSRCardLimitednumber; i++){
			if(SSRCardLimited.ssrinfo(i).gettype().equals("passion")){PassionSSR.add(SSRCardLimited.ssrinfo(i));}
		}
		return PassionSSR;
	}
	
	public ArrayList<Card> PassionSSRLimitedList() {
		SSRCard SSRCard = new SSRCard();
		SSRCardLimited SSRCardLimited = new SSRCardLimited();
		
		for(int i=0; i<SSRCardnumber; i++){
			if(SSRCard.ssrinfo(i).gettype().equals("passion")){PassionSSR.add(SSRCard.ssrinfo(i));}
		}
		return PassionSSR;
	}
	
	public void SearchIdol(User user){
		SSRCard SSRCard = new SSRCard();
        SRCard SRCard = new SRCard();
	    RCard RCard = new RCard();
	    SSRCardLimited SSRCardLimited  = new SSRCardLimited();
        SRCardLimited SRCardLimited  = new SRCardLimited();
		String name;
        int t = 0;
		System.out.print("아이돌 이름을 입력하세요 >> ");
		Scanner scanner = new Scanner(System.in);
		name=scanner.next();
		for(int i=0;i<SSRCardLimitednumber;i++){
			if(SSRCardLimited.ssrinfo(i).name.contains(name)){
				System.out.println(SSRCardLimited.ssrinfo(i).Valueof());
				t=1;
			}
		} 
		
		for(int i=0;i<SSRCardnumber;i++){
			if(SSRCard.ssrinfo(i).name.contains(name)){
				System.out.println(SSRCard.ssrinfo(i).Valueof());
				t=1;
			}
		}
		for(int i=0;i<SRCardLimitednumber;i++){
			if(SRCardLimited.srinfo(i).name.contains(name)){
				System.out.println(SRCardLimited.srinfo(i).Valueof());
				t=1;
			}
		}
		for(int i=0;i<SRCardnumber;i++){
			if(SRCard.srinfo(i).name.contains(name)){
				System.out.println(SRCard.srinfo(i).Valueof());
				t=1;
			}
		}
		for(int i=0;i<RCardnumber;i++){
			if(RCard.rinfo(i).name.contains(name)){
				System.out.println(RCard.rinfo(i).Valueof());
				t=1;
			}
			if(!RCard.rinfo(i).name.contains(name)){
				t=0;
			}			
		}
		if(t=='0'){}
	}
	public void FCardSelect(User user){
		SSRCard SSRCard = new SSRCard();
        SSRCardLimited SSRCardLimited  = new SSRCardLimited();
		Scanner scanner = new Scanner(System.in);
		for(int i=0;i<SSRCardLimitednumber;i++){
			char yesno='n';
				System.out.print(SSRCardLimited.ssrinfo(i).name+"-> 선호 아이돌로 선택하시겠습니까? (y/n) >> ");
				yesno=scanner.next().charAt(0);
				switch(yesno){
				case'Y': case'y':{user.FCard=SSRCardLimited.ssrinfo(i);MainMenu.mainmenu(user);}
				case'N': case'n':{continue;}
				default:{continue;}
			}
		}
		for(int i=0;i<SSRCardnumber;i++){
			char yesno='n';
				System.out.print(SSRCard.ssrinfo(i).name+"-> 선호 아이돌로 선택하시겠습니까? (y/n) >> ");
				yesno=scanner.next().charAt(0);
				switch(yesno){
				case'Y': case'y':{user.FCard=SSRCard.ssrinfo(i);MainMenu.mainmenu(user);}
				case'N': case'n':{continue;}
				default:{continue;}
			}
		}
		System.out.println("선택하지 않았습니다");
	}



}
