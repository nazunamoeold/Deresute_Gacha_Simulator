package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.*;
import Database.*;
import GachaChargeMenu.*;
import Menu.*;

public class MainMenu extends JFrame {

	String jewel ="Áê¿¤ : ";
	String yen = "µ· : ";
	
	JLabel moneystat3 = new JLabel();
	JLabel jewelstat3 = new JLabel();
	
	JPanel gacha = new JPanel();
	JPanel money = new JPanel();
	JPanel info = new JPanel();
	JPanel titlebar = new JPanel();
	JPanel statbar = new JPanel();
	
	ArrayList<Card> resulttemp = new ArrayList<Card>();
	
	JRadioButton limited = new JRadioButton("ÇÑÁ¤");
	JRadioButton nojewel = new JRadioButton("³ëÁê¿¤");	
	
	Card resultcard = new Card();
	
	Gacha g = new Gacha();
	
	Iterator<Card> search = resulttemp.iterator();
	
	JTextArea result = new JTextArea(9,10);
    
	JTextField searchtable = new JTextField(20);
	
	JButton exit = new JButton("Á¾·á");
	
	User user = new User();
	
	Container a = getContentPane();
	
	JRadioButton cute = new JRadioButton("Cute");
	JRadioButton cool = new JRadioButton("Cool");
	JRadioButton passion = new JRadioButton("Passion");
	JRadioButton alltype = new JRadioButton("All");
	
	boolean nojewelset;
	
	JComboBox jewellist = new JComboBox();
	String select="";
	
	ArrayList<String> jewels2 = new ArrayList<String>();
	String [] jewels ={"¼±ÅÃ ¾ÈÇÔ","A: Áê¿¤ 60°³ - 120¿£","B: Áê¿¤ 360°³ - 480¿£",
			"C: Áê¿¤ 760°³ - 960¿£","D: Áê¿¤ 1300°³ - 1600¿£","E: Áê¿¤ 2650°³ - 3200¿£",
			"F: Áê¿¤ 4200°³ - 5000¿£","G: Áê¿¤ 8400°³ - 9800¿£"};
	

	
	MainMenu(){
		nojewelset=false;
		Image moneyimage =null;
		
		user.limited=false;
		
		Font mainfont = new Font("¸¼Àº °íµñ",0,15);
		Font mainfont2 = new Font("¸¼Àº °íµñ",0,13);
		
		setTitle("µ¥·¹½ºÅ× °¡Ã­ ½Ã¹Ä·¹ÀÌÅÍ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try{File sourceimage = new File("cihiro");
		moneyimage = ImageIO.read(sourceimage);}
		catch(IOException e){}
		JLabel Title = new JLabel (" µ¥·¹½ºÅ× °¡Ã­ ½Ã¹Ä·¹ÀÌÅÍ v2.0.0 Beta 5");
		titlebar.setLayout(new BorderLayout(50,50));
		titlebar.add(Title,BorderLayout.WEST);
		titlebar.add(exit,BorderLayout.EAST);
		
		Title.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,18));
		
		a.setLayout(new BorderLayout(5,5));
		
		a.add(titlebar,BorderLayout.NORTH);
		a.add(statbar, BorderLayout.SOUTH);
		
		exit.setFont(mainfont);
		JTabbedPane tab = new JTabbedPane();
		
		tab.add(money,"°ú±Ý");
		tab.add(gacha,"°¡Ã­");
		tab.add(info,"Á¤º¸");
	
		money.setLayout(null);
		gacha.setLayout(null);
		info.setLayout(null);
		statbar.setLayout(new GridLayout(1,3,5,5));
		
		// »óÅÂ¹Ù Ç×¸ñ
		moneystat3.setText(yen+user.yen);
		jewelstat3.setText("Áê¿¤ : "+user.jewel);
		
		statbar.add(jewelstat3);
		statbar.add(moneystat3);
		
		jewelstat3.setFont(mainfont);
		moneystat3.setFont(mainfont);
		
		// °ú±Ý ¸Þ´º Ç×¸ñ
		JLabel moneyimagee = new JLabel(new ImageIcon(moneyimage));

		JButton yengacha = new JButton("¿£È­·Î °áÁ¦");
		JButton jewelcharge = new JButton("Áê¿¤ ÃæÀü");
		
		
		for(int i=0; i<jewels.length; i++){
			jewels2.add(jewels[i]);
		}
		
		jewellist = new JComboBox(jewels);
		
		money.add(moneyimagee);
		money.add(yengacha);
		money.add(jewelcharge);
		money.add(jewellist);
		
		moneyimagee.setLocation(5,5);
		yengacha.setLocation(260,5);
		jewelcharge.setLocation(260,75);
		jewellist.setLocation(260,40);
		
		moneyimagee.setSize(250,160);
		yengacha.setSize(225,30);
		jewelcharge.setSize(225,30);
		jewellist.setSize(225,30);

		yengacha.setFont(mainfont);
		jewelcharge.setFont(mainfont);
		jewellist.setFont(mainfont);
		
		yengacha.addActionListener(new moneylistener());
		jewelcharge.addActionListener(new moneylistener());
		jewellist.addActionListener(new listaction());
		jewelcharge.addActionListener(new jewelcharge());
		
		//°¡Ã­ ¸Þ´º Ç×¸ñ
		JLabel typegacha = new JLabel("¼Ó¼ºº° °¡Ã­");
		JLabel gachatitle = new JLabel("°¡Ã­ °á°ú");
		
		JButton gachago = new JButton("´ÜÃ­");
		JButton yunchago = new JButton("¿¬Ã­");
		JButton yungumgo = new JButton("¿¬±Ý");
		JButton searchbtn = new JButton("°Ë»ö");
		JButton infinite = new JButton("¹«ÇÑ");
		JButton hawkryul = new JButton("È®·ü Á¶Á¤");
		
	    JScrollPane scrollPane = new JScrollPane(result);
		
		gacha.setLayout(null);
		gacha.add(gachago);
		gacha.add(yunchago);
		gacha.add(yungumgo);
		gacha.add(scrollPane);
		gacha.add(searchtable);
		gacha.add(searchbtn);
		gacha.add(limited);
		gacha.add(gachatitle);
		gacha.add(cute);
		gacha.add(cool);
		gacha.add(passion);
		gacha.add(alltype);
		gacha.add(typegacha);
		gacha.add(infinite);
		gacha.add(nojewel);
		gacha.add(hawkryul);
		
		gachago.setSize(64,30);
		yunchago.setSize(64,30);
		yungumgo.setSize(64,30);
		scrollPane.setSize(352,185);
		searchtable.setSize(224,20);
		searchbtn.setSize(65,18);
		limited.setSize(60,20);
		gachatitle.setSize(365,20);
		cute.setSize(60,20);
		cool.setSize(110,20);
		passion.setSize(110,20);
		typegacha.setSize(110,20);
		alltype.setSize(60,20);
		infinite.setSize(64,30);
		nojewel.setSize(65,20);
		hawkryul.setSize(130,26);
		
		gachago.setLocation(2,2);
		yunchago.setLocation(68,2);
		yungumgo.setLocation(2,34);
		scrollPane.setLocation(136,25);
		searchtable.setLocation(196,2);
		searchbtn.setLocation(420,2);
		limited.setLocation(2,95);
		gachatitle.setLocation(136,0);
		cute.setLocation(2,142);
		cool.setLocation(2,164);
		passion.setLocation(2,186);
		typegacha.setLocation(2,120);
		alltype.setLocation(62,142);
		infinite.setLocation(68,34);
		nojewel.setLocation(62,95);
		hawkryul.setLocation(2,66);
		
		gachago.setFont(mainfont2);
		yunchago.setFont(mainfont2);
		yungumgo.setFont(mainfont2);
		scrollPane.setFont(mainfont);
		searchtable.setFont(mainfont2);
		searchbtn.setFont(mainfont2);
		limited.setFont(mainfont2);
		gachatitle.setFont(mainfont2);
		cute.setFont(mainfont2);
		cool.setFont(mainfont2);
		passion.setFont(mainfont2);
		typegacha.setFont(mainfont);
		alltype.setFont(mainfont2);
		infinite.setFont(mainfont2);
		nojewel.setFont(mainfont2);
		hawkryul.setFont(mainfont2);
		
		gachago.addActionListener(new gachaaction());
		yunchago.addActionListener(new gachaaction());
		yungumgo.addActionListener(new gachaaction());
		infinite.addActionListener(new gachaaction());
		searchbtn.addActionListener(new gachaaction());
		exit.addActionListener(new gachaaction());
		limited.addItemListener(new limitedconfigbutton());
		cute.addItemListener(new typebutton());
		cool.addItemListener(new typebutton());
		passion.addItemListener(new typebutton());
		alltype.addItemListener(new typebutton());
		nojewel.addItemListener(new nojewelbutton());
		hawkryul.addActionListener(new gachaaction());
		
		alltype.setSelected(true);
		result.setEditable(false);
		
		tab.setFont(mainfont);
		a.add(tab,BorderLayout.CENTER);
		
		setSize(500,345);
		setVisible(true);
		setResizable(false);
	}
	

	
	public class gachaaction implements ActionListener{
		
		public void showerror(){
			JOptionPane.showMessageDialog(a, "Áê¿¤ÀÌ ºÎÁ·ÇÕ´Ï´Ù"," Áê¿¤ ºÎÁ·",JOptionPane.ERROR_MESSAGE);
		}
		
		public boolean checkjewel(User user, int jewel){
			if(nojewelset){return true;}else{
			if(user.jewel<jewel){
				return false;
			}else if(user.jewel>=jewel) {return true;}
			return true;}
		}
		
		public void refresh(){
			moneystat3.setText("µ· : "+user.yen);
			jewelstat3.setText("Áê¿¤ : "+user.jewel);
		}
		
		public void actionPerformed(ActionEvent e){
			String menu = e.getActionCommand();
			switch(menu){
			case"´ÜÃ­":{
				if(this.checkjewel(user, 250)){
				resulttemp.clear();
				result.setText("");
				if(!nojewelset){user.jewel-=250;}
				StringBuffer gachatext = new StringBuffer();
				if(user.limited){
					resultcard=g.ReturnToGUIUnlimited(user, 0);
					gachatext.append(resultcard.Valueof()+"\n");
					resulttemp.add(resultcard);}
				else {
					resultcard=g.ReturnToGUILimited(user, 0);
					gachatext.append(resultcard.Valueof()+"\n");
					resulttemp.add(resultcard);}
				String gacharesult=gachatext.toString();
				result.setText(result.getText()+gacharesult);
				this.refresh();
				break;}else{this.showerror();break;}}
			case"¿¬Ã­":{
				if(this.checkjewel(user, 2500)){
				resulttemp.clear();
				result.setText("");
				if(!nojewelset){user.jewel-=2500;}
				StringBuffer gachatext = new StringBuffer();
				if(user.limited){
				for(int i=0; i<9; i++){
					resultcard=g.ReturnToGUIUnlimited(user, 0);
					gachatext.append(resultcard.Valueof()+"\n");
					resulttemp.add(resultcard);
					}resultcard=g.ReturnToGUIUnlimited(user, 1);
					gachatext.append(resultcard.Valueof());
					resulttemp.add(resultcard);
				} else {for(int i=0; i<9; i++){
					resultcard=g.ReturnToGUILimited(user, 0);
					gachatext.append(resultcard.Valueof()+"\n");
					resulttemp.add(resultcard);
					}resultcard=g.ReturnToGUILimited(user, 1);
					gachatext.append(resultcard.Valueof());
					resulttemp.add(resultcard);
				}
				String gacharesult=gachatext.toString();
				result.setText(result.getText()+gacharesult);
				this.refresh();
				break;}else{this.showerror();break;}}
			case"¿¬±Ý":{
				if(this.checkjewel(user, 60)){
				resulttemp.clear();
				result.setText("");
				if(!nojewelset){user.jewel-=60;}
				StringBuffer gachatext = new StringBuffer();
				if(user.limited){
					resultcard=g.ReturnToGUILimited(user, 0);
					gachatext.append(resultcard.Valueof()+"\n");
					resulttemp.add(resultcard);}
				else {
					resultcard=g.ReturnToGUIUnlimited(user, 0);
					gachatext.append(resultcard.Valueof()+"\n");
					resulttemp.add(resultcard);}
				String gacharesult=gachatext.toString();
				result.setText(result.getText()+gacharesult);
				this.refresh();
				break;}else{this.showerror();break;}}
			case"°Ë»ö":{
				int count=0;
				if(resulttemp.isEmpty()){}else{
				String searchtext = searchtable.getText();
				String searchresult = "";
				StringBuffer searchbuffer = new StringBuffer(searchresult);
				for(int i=0;i<resulttemp.size();i++){
					if(resulttemp.get(i).name.contains(searchtext)){
						count++;
						searchbuffer.append(resulttemp.get(i).Valueof()+"\n");
					}String countshow = "°Ë»ö °á°ú "+count+"°³\n";
					searchresult = countshow+searchbuffer.toString();
				}if(count==0){JOptionPane.showMessageDialog(a,"°Ë»ö °á°ú°¡ ¾ø½À´Ï´Ù.","°Ë»ö °á°ú",JOptionPane.INFORMATION_MESSAGE);}else{
				JOptionPane.showMessageDialog(a,searchresult,"°Ë»ö °á°ú",JOptionPane.INFORMATION_MESSAGE);
				}break;}break;}
			case"¹«ÇÑ":{
				int count=0;
				resulttemp.clear();
				result.setText("");
				StringBuffer gachatext = new StringBuffer();
				if(this.checkjewel(user, 250)){
				do{
					if(!nojewelset){user.jewel-=250;}
					this.refresh();
					if(user.limited){
						resultcard=g.ReturnToGUIUnlimited(user, 0);
						if(resultcard.lev.equals("SSR")){gachatext.append(resultcard.Valueof());}
						else{gachatext.append(resultcard.Valueof()+"\n");}
						gachatext.append(resultcard.Valueof()+"\n");
						resulttemp.add(resultcard);
						count++;
						String gacharesult=gachatext.toString();
						if(!this.checkjewel(user, 250)){
							JOptionPane.showMessageDialog(a, "SSRÀ» »ÌÁö ¸øÇßÁö¸¸ Áê¿¤ÀÌ ºÎÁ·ÇÕ´Ï´Ù", " ¿¡·¯", JOptionPane.ERROR_MESSAGE);
							result.setText(result.getText()+gacharesult);
							break;
						}
						if(resultcard.lev.equals("SSR")){
							result.setText(result.getText()+gacharesult);
							JOptionPane.showMessageDialog(a,count+"¹ø ¸¸¿¡ SSRÀÌ ³ª¿Ô½À´Ï´Ù.","¹«ÇÑ °¡Ã­",JOptionPane.INFORMATION_MESSAGE);
							break;
							}
						}
					else {
						resultcard=g.ReturnToGUILimited(user, 0);
						if(resultcard.lev.equals("SSR")){gachatext.append(resultcard.Valueof());}
						else{gachatext.append(resultcard.Valueof()+"\n");}
						resulttemp.add(resultcard);
						count++;
						String gacharesult=gachatext.toString();
						if(!this.checkjewel(user, 250)){
							JOptionPane.showMessageDialog(a, "SSRÀ» »ÌÁö ¸øÇßÁö¸¸ Áê¿¤ÀÌ ºÎÁ·ÇÕ´Ï´Ù", " ¿¡·¯", JOptionPane.ERROR_MESSAGE);
							result.setText(result.getText()+gacharesult);
							break;
						}
						if(resultcard.lev.equals("SSR")){				
							result.setText(result.getText()+gacharesult);
							JOptionPane.showMessageDialog(a,count+"¹ø ¸¸¿¡ SSRÀÌ ³ª¿Ô½À´Ï´Ù.","¹«ÇÑ °¡Ã­",JOptionPane.INFORMATION_MESSAGE);
							break;
						}
					}
				}while(true);
				break;}else{this.showerror();break;}
			}
			case"È®·ü Á¶Á¤":{
				new ProbabilityInfo();
				break;
			}
			case"Á¾·á":{int result =JOptionPane.showConfirmDialog(a, "Á¾·áÇÏ½Ã°Ú½À´Ï±î?","Á¾·á",JOptionPane.YES_OPTION);
			if(result ==JOptionPane.YES_OPTION){
			System.exit(0);}
			}}
		}
	}
	
	public class limitedconfigbutton implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() ==ItemEvent.DESELECTED){
				user.limited=false;
			} else {user.limited=true;}
		}
	}
	
	public class typebutton implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			AbstractButton sel = (AbstractButton)e.getItemSelectable();
			switch(sel.getText()){
			case"Cute":{
				user.TypeGachaSetting=1;
				if(e.getStateChange()==ItemEvent.SELECTED){
					cool.setEnabled(false);
					passion.setEnabled(false);
					alltype.setEnabled(false);}
				else if(e.getStateChange()==ItemEvent.DESELECTED){
					cool.setEnabled(true);
					passion.setEnabled(true);
					alltype.setEnabled(true);}
				break;}
			case"Cool":{
				user.TypeGachaSetting=2;
				if(e.getStateChange()==ItemEvent.SELECTED){
					cute.setEnabled(false);
					passion.setEnabled(false);
					alltype.setEnabled(false);}
				else if(e.getStateChange()==ItemEvent.DESELECTED){
					cute.setEnabled(true);
					passion.setEnabled(true);
					alltype.setEnabled(true);}break;}
			case"Passion":{
				user.TypeGachaSetting=3;
				if(e.getStateChange()==ItemEvent.SELECTED){
					cool.setEnabled(false);
					cute.setEnabled(false);
					alltype.setEnabled(false);}
				else if(e.getStateChange()==ItemEvent.DESELECTED){
					cool.setEnabled(true);
					cute.setEnabled(true);
					alltype.setEnabled(true);}break;}
			case"All":{
				if(e.getStateChange()==ItemEvent.SELECTED){
					user.TypeGachaSetting=0;
					cool.setEnabled(false);
					passion.setEnabled(false);
					cute.setEnabled(false);}
				else if(e.getStateChange()==ItemEvent.DESELECTED){
					cool.setEnabled(true);
					passion.setEnabled(true);
					cute.setEnabled(true);}break;}
			}
		}
	}

	public class moneylistener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			switch(e.getActionCommand()){
			case"¿£È­·Î °áÁ¦":{
				String yen;
				int yencharge;
				do{
				yen=JOptionPane.showInputDialog(a,"ÃæÀüÇÒ ¿£À» ÀÔ·ÂÇÏ¼¼¿ä");
				try{
					if(yen.equals("")){
						break;
					}
					else{
						try{yencharge=Integer.valueOf(yen);}
						catch(NumberFormatException i){
							JOptionPane.showMessageDialog(a,"Àß¸ø ÀÔ·ÂÇÏ¼Ì½À´Ï´Ù. Á¤¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä"," ¿¡·¯ ¹ß»ý",JOptionPane.ERROR_MESSAGE);
							continue;
						}
						user.yen+=yencharge;
						moneystat3.setText("µ· : "+user.yen);
					}
				}catch(Exception a){
					break;
				}break;
			}while(true);break;
			}
			case"Áê¿¤ ÃæÀüÇÏ±â":{
			}
			default:{}
			}
		}
	}
	
	public class listaction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==jewellist){
				select = (String)jewellist.getSelectedItem();
			}
		}
	}
	
	public class jewelcharge implements ActionListener{
		public void refresh(){
			moneystat3.setText("µ· : "+user.yen);
			jewelstat3.setText("Áê¿¤ : "+user.jewel);
		}
		
		public void checkmoney (User user, int money, int jewel){
			if(user.yen<money){
				JOptionPane.showMessageDialog(a, "µ·ÀÌ ºÎÁ·ÇÕ´Ï´Ù"," ÃæÀü ¿ä¸Á",JOptionPane.ERROR_MESSAGE);
			} else{
				user.jewel+=jewel;
				user.yen-=money;
				this.refresh();
				}
		}
		public void actionPerformed(ActionEvent e){
			String jewelselect=(String)jewellist.getSelectedItem();
			if(jewelselect==jewels2.get(0)){
				JOptionPane.showMessageDialog(a, "±¸ÀÔÇÒ Áê¿¤À» ¼±ÅÃÇØÁÖ¼¼¿ä"," °í¸£½Ã¿À",JOptionPane.INFORMATION_MESSAGE);
			}else if(jewelselect==jewels2.get(1)){
				this.checkmoney(user, 120, 60);
			}else if(jewelselect==jewels2.get(2)){
				this.checkmoney(user, 360, 480);
			}else if(jewelselect==jewels2.get(3)){
				this.checkmoney(user, 760, 960);
			}else if(jewelselect==jewels2.get(4)){
				this.checkmoney(user, 1300, 1600);
			}else if(jewelselect==jewels2.get(5)){
				this.checkmoney(user, 2650, 3200);
			}else if(jewelselect==jewels2.get(6)){
				this.checkmoney(user, 4200, 5000);
			}else if(jewelselect==jewels2.get(7)){
				this.checkmoney(user, 8400, 9800);
			}
			
		}
	}
	
	public class nojewelbutton implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() ==ItemEvent.SELECTED){
				nojewelset=true;
			} else {nojewelset=false;}
		}
	}
	

	public static void main(String[] args){new MainMenu();}}

