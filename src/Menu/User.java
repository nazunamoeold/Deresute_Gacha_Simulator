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
		
	    public String name="";
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
		
		public ArrayList<Card> filteredlist = new ArrayList<Card>();
		
		public ArrayList<Card> listssrcute = new ArrayList<Card>();
		public ArrayList<Card> listssrcool = new ArrayList<Card>();
		public ArrayList<Card> listssrpassion = new ArrayList<Card>();
		public ArrayList<Card> listsrcute = new ArrayList<Card>();
		public ArrayList<Card> listsrcool = new ArrayList<Card>();
		public ArrayList<Card> listsrpassion = new ArrayList<Card>();
		public ArrayList<Card> listrcute = new ArrayList<Card>();
		public ArrayList<Card> listrcool = new ArrayList<Card>();
		public ArrayList<Card> listrpassion = new ArrayList<Card>();
		public void cardreset(){
			SSR.clear();
			R.clear();
			SR.clear();
			LSSR.clear();
			LSR.clear();
			
			cute=0;
			cool=0;
			passion=0;
			SSRNumber=0;
			SRNumber=0;
			RNumber=0;
			LSSRNumber=0;
			LSRNumber=0;
		}
		
		public void jewelreset(){
			jewel=0;
		}
		
		public void moneyreset(){
			yen=0;
		}
		
		
		public int returncards(String lev, String type){
			int returns=0;
			switch(type){
			case"cute":{
				switch(lev){
				case"SSR":{returns+=listssrcute.size();break;}
				case"SR":{returns+=listsrcute.size();break;}
				case"R":{returns+=listrcute.size();break;}
				}
				break;
				}
			case"cool":{
				switch(lev){
				case"SSR":{returns+=listssrcool.size();break;}
				case"SR":{returns+=listsrcool.size();break;}
				case"R":{returns+=listrcool.size();break;}
				}
				break;
				}
			case"passion":{
				switch(lev){
				case"SSR":{returns+=listssrpassion.size();break;}
				case"SR":{returns+=listsrpassion.size();break;}
				case"R":{returns+=listrpassion.size();break;}
				}
				break;
				}
			}return returns;
			}
		}

