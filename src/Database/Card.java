package Database;

import java.io.File;
import java.util.ArrayList;

public class Card {
	private String type;
	private String lev;
	private String name;
	private boolean limited;
	
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
	public boolean getlimited(){
		return limited;
	}
	public void setlev(String lev){
		this.lev=lev;
	}
	public void setname(String name){
		this.name=name;
	}
	public void settype(String type){
		this.type=type;
	}
	public void setlimited(boolean limited){
		this.limited=limited;
	}
	
	public Card(String lev, String type, String name, boolean limited){
		this.setlev(lev);
		this.settype(type);
		this.setname(name);
		this.setlimited(limited);
	}
	
	public Card(){
		
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
		RCard RCard = new RCard(lev, lev, lev, limited);
		for(int i=0; i<SSRCard.info().size(); i++){UnitedCard.add(SSRCard.info.get(i));}
		for(int i=0; i<SRCard.info().size(); i++){UnitedCard.add(SRCard.info.get(i));}
		for(int i=0; i<RCard.info().size(); i++){UnitedCard.add(RCard.info.get(i));}
		return UnitedCard;}
	}
	
	public ArrayList<Card> UnitedLimitedCardList(){
		ArrayList<Card> UnitedLimitedCard = new ArrayList<Card>();
		if(!UnitedLimitedCard.isEmpty()){return UnitedLimitedCard;}else{
		SSRCard SSRCard = new SSRCard();
		SRCard SRCard = new SRCard();
		RCard RCard = new RCard(lev, lev, lev, limited);
		SSRCardLimited SSRCardLimited = new SSRCardLimited();
		SRCardLimited SRCardLimited = new SRCardLimited();
		for(int i=0; i<SSRCard.info().size(); i++){UnitedLimitedCard.add(SSRCard.info.get(i));}
		for(int i=0; i<SRCard.info().size(); i++){UnitedLimitedCard.add(SRCard.info.get(i));}
		for(int i=0; i<RCard.info().size(); i++){UnitedLimitedCard.add(RCard.info.get(i));}
		for(int i=0; i<SSRCardLimited.info().size(); i++){UnitedLimitedCard.add(SSRCardLimited.info.get(i));}
		for(int i=0; i<SRCardLimited.info().size(); i++){UnitedLimitedCard.add(SRCardLimited.info.get(i));}
		return UnitedLimitedCard;}
	}
}
	
