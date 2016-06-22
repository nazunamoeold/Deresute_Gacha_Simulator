package Gacha;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import Menu.User;
import Database.*;
public class Gacha extends Card{
	CardList lists = new CardList();
    Scanner scanner = new Scanner(System.in);
    SSRCard ssr = new SSRCard();
    SRCard sr = new SRCard();
    RCard r = new RCard();
    CardList r2 = new CardList();
    SSRCardLimited lssr = new SSRCardLimited();
    SRCardLimited lsr = new SRCardLimited();
    Card returncard = null;
	int cute=0;
	int cool=0;
	int passion=0;
    
    public boolean TXT=true;
	public String txt="Yes";
		
	public void ProbabilityChangeGUI(User user, Double ssrp, Double srp){
		user.tempSSR=ssrp;
		user.tempSR=srp;
		user.SSRp=(int) (999*(ssrp*0.01));
		user.LSSRp=(int) (user.SSRp/7*4);
	    user.SRp=(int) (999*(srp*0.01));
		user.LSRp=(int) (user.SRp/7*4);
		}
	
		public Double ProbabilityShowGUI(User user, int i){
			switch(i){
			case 0:{return user.tempSSR;}
			case 1:{return user.tempSR;}
			case 2:{return 100-(user.tempSSR+user.tempSR);}
			default:{}
			}
			return null;
		}
	
		public Card ReturnToGUILimited(User user, int i){
			Random random = new Random();
			int temp;
			if(i==0){temp=random.nextInt(999);
   			if(temp<=user.SSRp){return this.SSRadd(user, user.TypeGachaSetting);}
   				else if(temp<=user.SRp){return this.SRadd(user);}
   				else if(temp<=user.Rp){return this.Radd(user);} 	
   				else {return null;}}
			else if(i==1){temp=random.nextInt(114);
				if(temp<=user.SSRp){return this.SSRadd(user, user.TypeGachaSetting);}
				else if(temp<=user.SRp){return this.SRadd(user);}
				else {return null;}}
			else {return null;}
		}
		
		public Card ReturnToGUIUnlimited(User user, int i){
			Random random = new Random();
			int temp;
			temp=random.nextInt(999);
			if(i==0){temp=random.nextInt(999);
				if(temp<=user.LSSRp){return this.LSSRadd(user, user.TypeGachaSetting);}
				else if(temp<=user.SSRp){return this.SSRadd(user, user.TypeGachaSetting);}
				else if(temp<=user.LSRp){return this.LSRadd(user);}
   				else if(temp<=user.SRp){return this.SRadd(user);}
   				else if(temp<=user.Rp){return this.Radd(user);} 	
   				else {return null;}}
			else if(i==1){temp=random.nextInt(114);
				if(temp<=user.LSSRp){return this.LSSRadd(user, user.TypeGachaSetting);}
				else if(temp<=user.SSRp){return this.SSRadd(user, user.TypeGachaSetting);}
				else if(temp<=user.LSRp){return this.LSRadd(user);}
				else if(temp<=user.SRp){return this.SRadd(user);}
				else {return null;}}
			else {return null;}
		}
		
		public void counttype(User user,Card card){
			switch(card.gettype()){
			case"Å¥Æ®":{cute++;user.cute++;
				switch(card.getlev()){
				case"SSR":{user.listssrcute.add(card);break;}
				case"SR":{user.listsrcute.add(card);break;}
				case"R":{user.listrcute.add(card);break;}
				}
				break;
				}
			case"Äð":{cool++;user.cool++;
				switch(card.getlev()){
				case"SSR":{user.listssrcool.add(card);break;}
				case"SR":{user.listsrcool.add(card);break;}
				case"R":{user.listrcool.add(card);break;}
				}
				break;
				}
			case"ÆÐ¼Ç":{passion++;user.passion++;
				switch(card.getlev()){
				case"SSR":{user.listssrpassion.add(card);break;}
				case"SR":{user.listsrpassion.add(card);break;}
				case"R":{user.listrpassion.add(card);break;}
				}
				break;
				}
			}
		}
		
		public void unlimited(User user, int i, int y){
			Random random = new Random();
			int temp;
			int x=1;
			
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
    		++user.LSSRNumber;
    		lssr.info().get(k);
    		if(j==0){
    			k = random.nextInt(lssr.info().size());
        		user.SSR.add(lssr.info().get(k));
        		returncard=lssr.info().get(k);
    		}
    		else if(j==1){
    			k = random.nextInt(CuteSSRLimitedList().size());
        		user.SSR.add(CuteSSRLimitedList().get(k));
        		cute++;user.cute++;
        		returncard=CuteSSRLimitedList().get(k);
    		}
    		else if(j==2){
    			k = random.nextInt(CoolSSRLimitedList().size());
        		user.SSR.add(CoolSSRLimitedList().get(k));
        		cool++;user.cool++;
        		returncard=CoolSSRLimitedList().get(k);
    		}
    		else if(j==3){
    			k = random.nextInt(PassionSSRLimitedList().size());
        		user.SSR.add(PassionSSRLimitedList().get(k));
        		passion++;user.passion++;
        		returncard=PassionSSRLimitedList().get(k);
    		}this.counttype(user, returncard); 
    		return returncard;
    	}
    	public Card SSRadd(User user, int j){
    		Random random = new Random();
    		int k = 0; 
    		ssr.info().get(k);
    		++user.SSRNumber;
    		if(j==0){
    			k = random.nextInt(ssr.info().size());
        		user.SSR.add(ssr.info().get(k));
        		returncard=ssr.info().get(k);
    		}
    		else if(j==1){
    			k = random.nextInt(CuteSSRList().size());
        		user.SSR.add(CuteSSRList().get(k));
        		cute++;user.cute++;
        		returncard=CuteSSRList().get(k);
    		}
    		else if(j==2){
    			k = random.nextInt(CoolSSRList().size());
        		user.SSR.add(CoolSSRList().get(k));
        		cool++;user.cool++;
        		returncard=CoolSSRList().get(k);
    		}
    		else if(j==3){
    			k = random.nextInt(PassionSSRList().size());
        		user.SSR.add(PassionSSRList().get(k));
        		passion++;user.passion++;
        		returncard=PassionSSRList().get(k);
    		}this.counttype(user, returncard); 
    		return returncard;
    	}
    	public Card LSRadd(User user){
    		Random random = new Random();
    		int k = 0;
    		lsr.info().get(k);
    		++user.LSRNumber;
    		k = random.nextInt(lsr.info().size());
    		user.LSR.add(lsr.info().get(k));
    		returncard=lsr.info().get(k);
    		this.counttype(user, returncard); 
    		return returncard;
    	}
    	public Card SRadd(User user){
    		Random random = new Random();
    		int k=0;
    		sr.info().get(k);
    		++user.SRNumber;
    		k = random.nextInt(sr.info().size());
    		user.SR.add(sr.info().get(k));
    		returncard=sr.info().get(k);
    		this.counttype(user, returncard); 
    		return returncard;
    	}
    	public Card Radd(User user){
    		Random random = new Random();
    		int k=0;
    		++user.RNumber;
    		k = random.nextInt(r.info().size());
    		user.R.add(r.info().get(k));
    		returncard=r.info().get(k);
    		this.counttype(user, returncard); 
    		return returncard;
    	}
    	
    	
    	public ArrayList<Card> returnUnitedCard(){
    		return super.UnitedCardList();
    	}
}