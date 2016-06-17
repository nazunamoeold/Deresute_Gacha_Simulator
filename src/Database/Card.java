package Database;

import java.io.File;
import java.util.ArrayList;

public class Card{
	private String type;
	private String lev;
	private String name;
	private boolean limited;
	
	private int life;
	private int dance;
	private int vocal;
	private int visual;
	private int tlife;
	private int tdance;
	private int tvocal;
	private int tvisual;
	private String skillstr;
	private String skilltitle;
	private String centerstr;
	private String centertitle;
//	public String ImagePath;
//	public File CardImage = new File(ImagePath);
	
	public File getImage(String path){
		File returnimage = new File(path);
		return returnimage;
	}
	public String Valueof() {return "[" + this.getlev() + "] [" + this.gettype() + "] " + this.getname() ;}
	public String getlev(){return lev;}
	public String getname(){return name;}
	public String gettype(){return type;}
	public boolean getlimited(){return limited;}
	public void setlev(String lev){this.lev=lev;}
	public void setname(String name){this.name=name;}
	public void settype(String type){this.type=type;}
	public void setlimited(boolean limited){this.limited=limited;}
	
	public void setlife(int life){this.life=life;}
	public void setvocal(int vocal){this.vocal=vocal;}
	public void setdance(int dance){this.dance=dance;}
	public void setvisual(int visual){this.visual=visual;}
	public void settlife(int life){this.tlife=life;}
	public void settvocal(int vocal){this.tvocal=vocal;}
	public void settdance(int dance){this.tdance=dance;}
	public void settvisual(int visual){this.tvisual=visual;}
	public void setskillstr(String skillstr){this.skillstr=skillstr;}
	public void setskilltitle (String skilltitle){this.skilltitle=skilltitle;}
	public void setcenter(String center){this.centerstr=center;}
	public void setcentertitle(String centertitle){this.centertitle=centertitle;}
	
	public int getlife(){return life;}
	public int getvocal(){return vocal;}
	public int getdance(){return dance;}
	public int getvisual(){return visual;}
	public int gettlife(){return tlife;}
	public int gettvocal(){return tvocal;}
	public int gettdance(){return tdance;}
	public int gettvisual(){return tvisual;}
	public String getskillstr(){return skillstr;}
	public String getskilltitle (){return skilltitle;}
	public String getcenter(){return centerstr;}
	public String getcentertitle(){return centertitle;}
	
	
	public Card(String lev, String type, String name, boolean limited){
		this.setlev(lev);
		this.settype(type);
		this.setname(name);
		this.setlimited(limited);
	}
	public Card(String lev, String type, String name, boolean limited,int life, int vocal, 
			int dance,int visual,int tlife, int tvocal, int tdance,int tvisual,String skill,
			String skilltitle,String center,int intervaltime, double pro, 
			int term, int effect, int overload,int centereffect){
		this.setlev(lev);
		this.settype(type);
		this.setname(name);
		this.setlimited(limited);
		this.setlife(life);
		this.setvocal(vocal);
		this.setdance(dance);
		this.setvisual(visual);
		this.settlife(tlife);
		this.settvocal(tvocal);
		this.settdance(tdance);
		this.settvisual(tvisual);
		this.setskilltitle(skilltitle);
		switch(skill){
		case"o":{
			this.setskillstr(intervaltime+" 초 마다 "+pro+"% 확률로 라이프를"+overload+"만큼 소모하여"+term+"초 동안  PERFECT 스코어가"+effect+"% 상승, NICE/BAD여도 COMBO가 끊기지 않음");
			break;
		}
		case"s":{
			switch(lev){
			case"SSR":{this.setskillstr(intervaltime+"초 마다 "+pro+"% 확률로 "+term+"초 동안, PERFECT/GREAT 스코어가 "+effect+"% 상승");break;}
			default:{this.setskillstr(intervaltime+"초 마다 "+pro+"% 확률로 "+term+"초 동안, PERFECT 스코어가 "+effect+"% 상승");break;}
			}break;
		}
		case"c":{
			this.setskillstr(intervaltime+"초 마다 "+pro+"% 확률로 "+term+"초 동안, COMBO 보너스 "+effect+"% 상승");
			break;
			}
		case"p":{
			switch(lev){
			case"SSR":{this.setskillstr(intervaltime+"초 마다 "+pro+"% 확률로"+term+"초 동안 GREAT/NICE/BAD를 PERFECT로 만듬");break;}
			case"SR":{this.setskillstr(intervaltime+"초 마다 "+pro+"% 확률로"+term+"초 동안 GREAT/NICE를 PERFECT로 만듬");break;}
			case"R":{this.setskillstr(intervaltime+"초 마다 "+pro+"% 확률로"+term+"초 동안 GREAT를 PERFECT로 만듬");break;}
			}
			break;
			}
		case"m":{
			this.setskillstr(intervaltime+" 초 마다 "+term+"초 동안 라이프가 감소하지 않음");
			break;
		}
		case"h":{
			this.setskillstr(intervaltime+" 초 마다 "+term+"초 동안 PERFECT로 라이프 "+effect+" 회복");
			break;
		}
		}
		switch(center){
		case"a":{
			this.setcentertitle(type+" 브릴리언스");
			this.setcenter(type+"아이돌의 모든 어필 수치 "+centereffect+"% 상승");
			break;
		}
		case"v":{
			this.setcentertitle(type+" 보이스");
			this.setcenter(type+"아이돌의 보컬 어필 수치 "+centereffect+"% 상승");
			break;
		}
		case"d":{
			this.setcentertitle(type+" 스텝");
			this.setcenter(type+"아이돌의 댄스 어필 수치 "+centereffect+"% 상승");
			break;
		}
		case"i":{
			this.setcentertitle(type+" 메이크");
			this.setcenter(type+"아이돌의 비쥬얼 어필 수치 "+centereffect+"% 상승");
			break;
		}
		case"s":{
			this.setcentertitle(type+" 어빌리티");
			this.setcenter(type+"아이돌의 스킬 발동율 "+centereffect+"% 상승");
			break;
		}
		case"l":{
			this.setcentertitle(type+" 에너지");
			this.setcenter(type+"아이돌의 라이프 "+centereffect+"% 상승");
			break;
		}
		}
	}
	public Card(){}


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
			if(this.UnitedLimitedCardList().get(i).gettype().equals("큐트")){
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
			if(this.UnitedCardList().get(i).gettype().equals("큐트")){
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
			if(this.UnitedLimitedCardList().get(i).gettype().equals("쿨")){
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
			if(this.UnitedCardList().get(i).gettype().equals("쿨")){
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
			if(this.UnitedLimitedCardList().get(i).gettype().equals("패션")){
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
			if(this.UnitedCardList().get(i).gettype().equals("패션")){
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
		RCard RCard = new RCard();
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
	
