package GachaChargeMenu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import Menu.User;
import Database.*;
public class Gacha extends Card{
	
	int tempCardNumber[] = new int[5];
    Scanner scanner = new Scanner(System.in);
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
			case"cute":{
				switch(card.getlev()){
				case"SSR":{user.listssrcute.add(card);break;}
				case"SR":{user.listsrcute.add(card);break;}
				case"R":{user.listrcute.add(card);break;}
				}
				break;
				}
			case"cool":{
				switch(card.getlev()){
				case"SSR":{user.listssrcool.add(card);break;}
				case"SR":{user.listsrcool.add(card);break;}
				case"R":{user.listrcool.add(card);break;}
				}
				break;
				}
			case"passion":{
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
    		lssr.info(k);
    		if(j==0){
    			k = random.nextInt(SSRCardLimitednumber);
        		user.SSR.add(lssr.info(k));
        		this.typecount(user, lssr.info(k));
        		returncard=lssr.info(k);
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
    		tempCardNumber[0]++; 
    		ssr.info(k);
    		++user.SSRNumber;
    		if(j==0){
    			k = random.nextInt(SSRCardnumber);
        		this.typecount(user, ssr.info(k));
        		user.SSR.add(ssr.info(k));
        		returncard=ssr.info(k);
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
    		tempCardNumber[4]++;
    		lsr.info(k);
    		++user.LSRNumber;
    		k = random.nextInt(SRCardLimitednumber);
       		this.typecount(user, lsr.info(k));
    		user.LSR.add(lsr.info(k));
    		returncard=lsr.info(k);
    		this.counttype(user, returncard); 
    		return returncard;
    	}
    	public Card SRadd(User user){
    		Random random = new Random();
    		int k=0;
    		tempCardNumber[1]++;
    		sr.info(k);
    		++user.SRNumber;
    		k = random.nextInt(sr.SRCardnumber);
    		this.typecount(user, sr.info(k));
    		user.SR.add(sr.info(k));
    		returncard=sr.info(k);
    		this.counttype(user, returncard); 
    		return returncard;
    	}
    	public Card Radd(User user){
    		Random random = new Random();
    		int k=0;
    		tempCardNumber[2]++; 
    		++user.RNumber;
    		k = random.nextInt(r.RCardnumber);
    		this.typecount(user, r.info(k));
    		user.R.add(r.info(k));
    		returncard=r.info(k);
    		this.counttype(user, returncard); 
    		return returncard;
    	}
    	
    	public void typecount(User user, Card card){
    		if(card.gettype().equals("cute")){cute++;user.cute++;}
    		else if(card.gettype().equals("cool")){cool++;user.cool++;}
    		else if(card.gettype().equals("passion")){passion++;user.passion++;}
    	}
    	
    	public void debuginput(User user){
    		Random random = new Random();
    		int k=random.nextInt(CoolSSRList().size());
    		System.out.println(CoolSSRList().get(k).Valueof());
    	}    	
    	
}