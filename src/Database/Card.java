package Database;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Menu.MainMenu;
import Menu.User;

public class Card {
	public String type;
	public String lev;
	public String name;
	public boolean limited;
	
	public final int SSRCardnumber = 28;
	public final int SRCardnumber = 52;
	public final int RCardnumber= 70;
	public final int SRCardLimitednumber = 11;
	public final int SSRCardLimitednumber = 18;
	
//	public int life;
//	public int dance;
//	public int vocal;
//	public int visual;
//	public int sum=dance+vocal+visual;
//	
//	public String CenterSkill;
//	public String Skill;
	
//	public String ImagePath;
//	public File CardImage = new File(ImagePath);
	
	public File getImage(String path){
		File returnimage = new File(path);
		return returnimage;
	}
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
	public ArrayList<Card> CoolSSR = new ArrayList<Card>();
	public ArrayList<Card> CuteSSR = new ArrayList<Card>();
	public ArrayList<Card> PassionSSR = new ArrayList<Card>();
	public ArrayList<Card> CoolSSRLimited = new ArrayList<Card>();
	public ArrayList<Card> CuteSSRLimited = new ArrayList<Card>();
	public ArrayList<Card> PassionSSRLimited = new ArrayList<Card>();


	public ArrayList<Card> CuteSSRLimitedList() {
		if(!CuteSSRLimited.isEmpty()){}
		else{
		for(int i=0; i<this.UnitedLimitedCardList().size(); i++){
			if(this.UnitedLimitedCardList().get(i).gettype().equals("cute")){
				if(this.UnitedLimitedCardList().get(i).getlev().equals("SSR")){
					CuteSSRLimited.add(this.UnitedLimitedCardList().get(i));}
				}
			}
		}
		return CuteSSRLimited;
	}
	
	public ArrayList<Card> CuteSSRList() {
		if(!CuteSSR.isEmpty()){}else{
		for(int i=0; i<this.UnitedCardList().size(); i++){
			if(this.UnitedCardList().get(i).gettype().equals("cute")){
				if(this.UnitedCardList().get(i).getlev().equals("SSR")){
					CuteSSR.add(this.UnitedCardList().get(i));}
				}
			}
		}
		return CuteSSR;
	}
	
	public ArrayList<Card> CoolSSRLimitedList() {
		if(!CoolSSRLimited.isEmpty()){}
		else{
		for(int i=0; i<this.UnitedLimitedCardList().size(); i++){
			if(this.UnitedLimitedCardList().get(i).gettype().equals("cool")){
				if(this.UnitedLimitedCardList().get(i).getlev().equals("SSR")){
					CoolSSRLimited.add(this.UnitedLimitedCardList().get(i));}
				}
			}
		}
		return CoolSSRLimited;
	}
	
	public ArrayList<Card> CoolSSRList() {
		if(!CoolSSR.isEmpty()){}else{
		for(int i=0; i<this.UnitedCardList().size(); i++){
			if(this.UnitedCardList().get(i).gettype().equals("cool")){
				if(this.UnitedCardList().get(i).getlev().equals("SSR")){
					CoolSSR.add(this.UnitedCardList().get(i));}
				}
			}
		}
		return CoolSSR;
	}
	
	public ArrayList<Card> PassionSSRLimitedList() {
		if(!PassionSSRLimited.isEmpty()){}
		else{
		for(int i=0; i<this.UnitedLimitedCardList().size(); i++){
			if(this.UnitedLimitedCardList().get(i).gettype().equals("passion")){
				if(this.UnitedLimitedCardList().get(i).getlev().equals("SSR")){
					PassionSSRLimited.add(this.UnitedLimitedCardList().get(i));}
				}
			}
		}
		return PassionSSRLimited;
	}
	
	public ArrayList<Card> PassionSSRList() {
		if(!PassionSSR.isEmpty()){}else{
		for(int i=0; i<this.UnitedCardList().size(); i++){
			if(this.UnitedCardList().get(i).gettype().equals("passion")){
				if(this.UnitedCardList().get(i).getlev().equals("SSR")){
					PassionSSR.add(this.UnitedCardList().get(i));}
				}
			}
		}
		return PassionSSR;
	}
	
	public ArrayList<Card> UnitedCardList(){
		ArrayList<Card> UnitedCard = new ArrayList<Card>();
		if(!UnitedCard.isEmpty()){return UnitedCard;}else{
		SSRCard SSRCard = new SSRCard();
		SRCard SRCard = new SRCard();
		RCard RCard = new RCard();
		for(int i=0; i<SSRCard.ssrinforeturn().length; i++){UnitedCard.add(SSRCard.ssrinfo(i));}
		for(int i=0; i<SRCard.srinforeturn().length; i++){UnitedCard.add(SRCard.srinfo(i));}
		for(int i=0; i<RCard.rinforeturn().length; i++){UnitedCard.add(RCard.rinfo(i));}
		return UnitedCard;}
	}
	
	public ArrayList<Card> UnitedLimitedCardList(){
		ArrayList<Card> UnitedLimitedCard = new ArrayList<Card>();
		if(!UnitedLimitedCard.isEmpty()){return UnitedLimitedCard;}else{
		SSRCard SSRCard = new SSRCard();
		SRCard SRCard = new SRCard();
		RCard RCard = new RCard();
		SSRCardLimited SSRCardLimited = new SSRCardLimited();
		SRCardLimited SRCardLimited = new SRCardLimited();
		for(int i=0; i<SSRCard.ssrinforeturn().length; i++){UnitedLimitedCard.add(SSRCard.ssrinfo(i));}
		for(int i=0; i<SRCard.srinforeturn().length; i++){UnitedLimitedCard.add(SRCard.srinfo(i));}
		for(int i=0; i<RCard.rinforeturn().length; i++){UnitedLimitedCard.add(RCard.rinfo(i));}
		for(int i=0; i<SSRCardLimited.ssrinforeturn().length; i++){UnitedLimitedCard.add(SSRCardLimited.ssrinfo(i));}
		for(int i=0; i<SRCardLimited.srinforeturn().length; i++){UnitedLimitedCard.add(SRCardLimited.srinfo(i));}
		return UnitedLimitedCard;}
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
