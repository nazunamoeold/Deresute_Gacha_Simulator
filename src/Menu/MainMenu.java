package Menu;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import Database.*;
import GachaChargeMenu.*;
import Menu.*;

public class MainMenu extends JFrame {
	
	Color back = Color.WHITE;
	Color fore = Color.DARK_GRAY;

	JLabel fcardimage = new JLabel();
	
	String jewel ="쥬엘 : ";
	String yen = "돈 : ";
	
	JLabel moneystat3 = new JLabel();
	JLabel jewelstat3 = new JLabel();
	
	JPanel gacha = new JPanel();
	JPanel money = new JPanel();
	JPanel info = new JPanel();
	JPanel titlebar = new JPanel();
	JPanel statbar = new JPanel();

	ArrayList<Card> filter = new ArrayList<Card>();
	ArrayList<Card> resulttemp = new ArrayList<Card>();
	
	JRadioButton limited = new JRadioButton("한정");
	JRadioButton nojewel = new JRadioButton("노쥬엘");
	
	String cardlog="";
	StringBuffer cardlogbuffer = new StringBuffer(cardlog);
	
	JRadioButton filterssr = new JRadioButton("ssr");
	JRadioButton filtersr = new JRadioButton("sr");	
	JRadioButton filterr = new JRadioButton("r");
	JRadioButton filtercute = new JRadioButton("cute");	
	JRadioButton filtercool = new JRadioButton("cool");
	JRadioButton filterpassion = new JRadioButton("passion");	
	
	Card resultcard = new Card();
	
	Gacha g = new Gacha();
	
	Iterator<Card> search = resulttemp.iterator();
	
	JTextArea result = new JTextArea(9,10);
	JTextArea usercard = new JTextArea(9,10);
    
	JTextField searchtable = new JTextField(20);
	JTextField usersearch = new JTextField(20);
	
	JButton exit = new JButton("종료");
	
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
	String [] jewels ={"선택 안함","A: 쥬엘 60개 - 120엔","B: 쥬엘 360개 - 480엔",
			"C: 쥬엘 760개 - 960엔","D: 쥬엘 1300개 - 1600엔","E: 쥬엘 2650개 - 3200엔",
			"F: 쥬엘 4200개 - 5000엔","G: 쥬엘 8400개 - 9800엔"};
	
	JLabel usedjewel = new JLabel("사용한 쥬엘 : "+user.usedjewel);
	JLabel usedyen = new JLabel("사용한 돈   "+user.usedyen);
	JLabel SSRInfo = new JLabel("SSR : "+user.SSRNumber);
	JLabel SRInfo = new JLabel("SR : "+user.SRNumber);
	JLabel RInfo = new JLabel("R : "+user.RNumber);
	JLabel CuteInfo = new JLabel("Cute : "+user.cute);
	JLabel CoolInfo = new JLabel("Cool : "+user.cool);
	JLabel PassionInfo = new JLabel("Passion : "+user.passion);

	boolean coolc=true;
	boolean cutec=true;
	boolean passionc=true;
	boolean ssr=true;
	boolean sr=true;
	boolean r=true;

	MainMenu(){
		
		
		nojewelset=false;
		Image moneyimage =null;
		Image debugimage =null;
		Image titleimage = null;
		
		user.limited=false;
		
		Font mainfont = new Font("맑은 고딕",0,15);
		Font mainfont2 = new Font("맑은 고딕",0,13);
		Container back = getContentPane();
		back.setBackground(this.back);
		back.setForeground(this.fore);
		setTitle("데레스테 가챠 시뮬레이터");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try{File sourceimage = new File("image/moneymenu/main");
		moneyimage = ImageIO.read(sourceimage);}
		catch(IOException e){}
		try{File sourceimage2 = new File("image/cardimage/asukassr-before");
		debugimage = ImageIO.read(sourceimage2);}
		catch(IOException e){}
		try{File sourceimage2 = new File("image/mainimage/title");
		titleimage = ImageIO.read(sourceimage2);}
		catch(IOException e){}
		
		JLabel Title = new JLabel (new ImageIcon(titleimage));
		titlebar.setLayout(new BorderLayout(50,50));
		titlebar.add(Title,BorderLayout.WEST);
		titlebar.setBackground(this.back);
		titlebar.setForeground(this.fore);
		
		Title.setFont(new Font("맑은 고딕",Font.BOLD,20));
		
		a.setLayout(new BorderLayout(5,5));
		
		a.add(titlebar,BorderLayout.NORTH);
		a.add(statbar, BorderLayout.SOUTH);
		
		exit.setFont(mainfont);
		JTabbedPane tab = new JTabbedPane();
		tab.setUI(new AquaBarTabbedPaneUI());
		tab.setBackground(this.back);
		tab.setForeground(this.fore);
		tab.add(money,"과금");
		tab.add(gacha,"가챠");
		tab.add(info,"정보");
		
	
		money.setLayout(null);
		gacha.setLayout(null);
		info.setLayout(null);
		statbar.setLayout(new GridLayout(1,3,5,5));
		money.setBackground(this.back);
		gacha.setBackground(this.back);
		info.setBackground(this.back);
		statbar.setBackground(this.back);
		money.setForeground(this.fore);
		gacha.setForeground(this.fore);
		info.setForeground(this.fore);
		statbar.setForeground(this.fore);
		
		// 상태바 항목
		JButton exit2 = new JButton("종료");
		moneystat3.setText(yen+user.yen);
		jewelstat3.setText("쥬엘 : "+user.jewel);
		
		statbar.add(jewelstat3);
		statbar.add(moneystat3);
		statbar.add(exit2);
		
		jewelstat3.setFont(mainfont);
		moneystat3.setFont(mainfont);
		exit2.setFont(mainfont);
		
		exit2.addActionListener(new gachaaction());
		
		exit2.setBackground(this.back);
		exit2.setForeground(this.fore);
		jewelstat3.setForeground(this.fore);
		moneystat3.setForeground(this.fore);
		// 과금 메뉴 항목
		JLabel moneyimagee = new JLabel(new ImageIcon(moneyimage));

		JButton yengacha = new JButton("엔화로 결제");
		JButton jewelcharge = new JButton("쥬엘 충전");
		
		
		for(int i=0; i<jewels.length; i++){
			jewels2.add(jewels[i]);
		}
		
		jewellist = new JComboBox(jewels);
		
		money.add(moneyimagee);
		money.add(yengacha);
		money.add(jewelcharge);
		money.add(jewellist);
		
		moneyimagee.setLocation(5,8);
		yengacha.setLocation(300,13);
		jewelcharge.setLocation(300,83);
		jewellist.setLocation(300,48);
		
		moneyimagee.setSize(250,208);
		yengacha.setSize(225,30);
		jewelcharge.setSize(225,30);
		jewellist.setSize(225,30);

		yengacha.setFont(mainfont);
		jewelcharge.setFont(mainfont);
		jewellist.setFont(mainfont);
		
		jewellist.setBackground(this.back);
		yengacha.setBackground(this.back);
		jewelcharge.setBackground(this.back);
		jewellist.setForeground(this.fore);
		yengacha.setForeground(this.fore);
		jewelcharge.setForeground(this.fore);
		
		yengacha.addActionListener(new moneylistener());
		jewelcharge.addActionListener(new moneylistener());
		jewellist.addActionListener(new listaction());
		jewelcharge.addActionListener(new jewelcharge());
		
		//가챠 메뉴 항목
		JLabel typegacha = new JLabel("속성별 가챠");
		JLabel gachatitle = new JLabel("가챠 결과");
		
		JButton gachago = new JButton("단챠");
		JButton yunchago = new JButton("연챠");
		JButton yungumgo = new JButton("연금");
		JButton searchbtn = new JButton("검색");
		JButton infinite = new JButton("무한");
		JButton hawkryul = new JButton("확률 조정");
		
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
		
		gachago.setLocation(2,10);
		yunchago.setLocation(68,10);
		yungumgo.setLocation(2,42);
		scrollPane.setLocation(136,33);
		searchtable.setLocation(196,10);
		searchbtn.setLocation(420,10);
		limited.setLocation(2,103);
		gachatitle.setLocation(136,8);
		cute.setLocation(2,150);
		cool.setLocation(2,172);
		passion.setLocation(2,194);
		typegacha.setLocation(2,128);
		alltype.setLocation(62,150);
		infinite.setLocation(68,42);
		nojewel.setLocation(62,103);
		hawkryul.setLocation(2,74);
		
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
		
		gachago.setBackground(this.back);
		yunchago.setBackground(this.back);
		yungumgo.setBackground(this.back);
		searchtable.setBackground(this.back);
		searchbtn.setBackground(this.back);
		limited.setBackground(this.back);
		gachatitle.setBackground(this.back);
		cute.setBackground(this.back);
		cool.setBackground(this.back);
		passion.setBackground(this.back);
		alltype.setBackground(this.back);
		infinite.setBackground(this.back);
		nojewel.setBackground(this.back);
		typegacha.setBackground(this.back);
		hawkryul.setBackground(this.back);
		result.setBackground(this.back);
		gachago.setForeground(this.fore);
		yunchago.setForeground(this.fore);
		yungumgo.setForeground(this.fore);
		searchtable.setForeground(this.fore);
		searchbtn.setForeground(this.fore);
		limited.setForeground(this.fore);
		gachatitle.setForeground(this.fore);
		cute.setForeground(this.fore);
		cool.setForeground(this.fore);
		passion.setForeground(this.fore);
		alltype.setForeground(this.fore);
		infinite.setForeground(this.fore);
		nojewel.setForeground(this.fore);
		hawkryul.setForeground(this.fore);
		typegacha.setForeground(this.fore);
		result.setForeground(this.fore);
		
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
		
		
		// 정보 메뉴 항목
		fcardimage = new JLabel(new ImageIcon(debugimage));

		JLabel cardinfo = new JLabel("소지 카드 정보");
		JLabel fcardtitle = new JLabel("선호 아이돌");
		JButton reset = new JButton("카드 초기화");
		JButton resetjewel = new JButton("쥬엘 초기화");
		JButton resetyen = new JButton("돈 초기화");
		JButton usersearchbtn = new JButton("검색");
		
	    JScrollPane scrollPaneu = new JScrollPane(usercard);
		
		info.setLayout(null);
		
		info.add(usedjewel);
		info.add(usedyen);
		info.add(cardinfo);
		info.add(SSRInfo);
		info.add(SRInfo);
		info.add(RInfo);
		info.add(CuteInfo);
		info.add(CoolInfo);
		info.add(PassionInfo);
		info.add(fcardimage);
		info.add(fcardtitle);
		info.add(reset);
		info.add(resetjewel);
		info.add(resetyen);
		info.add(scrollPaneu);
		info.add(filterssr);
		info.add(filtersr);
		info.add(filterr);
		info.add(filtercute);
		info.add(filtercool);
		info.add(filterpassion);
		info.add(usersearch);
		info.add(usersearchbtn);
		
		usedjewel.setLocation(128,11);
		usedyen.setLocation(128,33);
		cardinfo.setLocation(128,61);
		SSRInfo.setLocation(148,88);
		SRInfo.setLocation(148,108);
		RInfo.setLocation(148,128);
		CuteInfo.setLocation(148,148);
		CoolInfo.setLocation(148,168);
		PassionInfo.setLocation(148,188);
		fcardimage.setLocation(8,31);
		fcardtitle.setLocation(8,11);
		reset.setLocation(8,148);
		resetjewel.setLocation(8,171);
		resetyen.setLocation(8,194);
		scrollPaneu.setLocation(275,38);
		filterssr.setLocation(128,88);
		filtersr.setLocation(128,108);
		filterr.setLocation(128,128);
		filtercute.setLocation(128,148);
		filtercool.setLocation(128,168);
		filterpassion.setLocation(128,188);
		usersearch.setLocation(275,11);
		usersearchbtn.setLocation(505,11);
		
	    usedjewel.setSize(210,18);
	    usedyen.setSize(210,18);
	    cardinfo.setSize(140,20);
	    SSRInfo.setSize(90,18);
	    SRInfo.setSize(90,18);
	    RInfo.setSize(90,18);
	    CuteInfo.setSize(980,18);
	    CoolInfo.setSize(90,18);
	    PassionInfo.setSize(90,18);
	    fcardimage.setSize(116,116);
	    fcardtitle.setSize(116,20);
	    reset.setSize(116,20);
	    resetjewel.setSize(116,20);
	    resetyen.setSize(116,20);
	    scrollPaneu.setSize(295,185);
	    filterssr.setSize(20,20);
	    filtersr.setSize(20,20);
	    filterr.setSize(20,20);
	    filtercute.setSize(20,20);
	    filtercool.setSize(20,20);
	    filterpassion.setSize(20,20);
	    usersearch.setSize(230,24);
	    usersearchbtn.setSize(64,23);
		
		usedjewel.setFont(mainfont);
		usedyen.setFont(mainfont);
		cardinfo.setFont(new Font(("맑은 고딕"),Font.BOLD,20));
		SSRInfo.setFont(mainfont);
		SRInfo.setFont(mainfont);
		RInfo.setFont(mainfont);
		CuteInfo.setFont(mainfont);
		CoolInfo.setFont(mainfont);
		PassionInfo.setFont(mainfont);
		fcardtitle.setFont(mainfont);
		reset.setFont(mainfont);
		resetjewel.setFont(mainfont);
		resetyen.setFont(mainfont);
		usersearch.setFont(mainfont);
		usersearchbtn.setFont(mainfont);
		
		filterssr.setBackground(this.back);
		filtersr.setBackground(this.back);
		filterr.setBackground(this.back);
		filtercute.setBackground(this.back);
		filtercool.setBackground(this.back);
		filterpassion.setBackground(this.back);
		reset.setBackground(this.back);
		resetjewel.setBackground(this.back);
		resetyen.setBackground(this.back);
		usersearch.setBackground(this.back);
		usercard.setBackground(this.back);
		usersearchbtn.setBackground(this.back);
		
		filterssr.setForeground(this.fore);
		filtersr.setForeground(this.fore);
		filterr.setForeground(this.fore);
		filtercute.setForeground(this.fore);
		filtercool.setForeground(this.fore);
		filterpassion.setForeground(this.fore);
		reset.setForeground(this.fore);
		resetjewel.setForeground(this.fore);
		resetyen.setForeground(this.fore);
		usersearch.setForeground(this.fore);
		usercard.setForeground(this.fore);
		usersearchbtn.setForeground(this.fore);
		
		SSRInfo.setForeground(this.fore);
		SRInfo.setForeground(this.fore);
		RInfo.setForeground(this.fore);
		CuteInfo.setForeground(this.fore);
		CoolInfo.setForeground(this.fore);
		PassionInfo.setForeground(this.fore);
		usedjewel.setForeground(this.fore);
		usedyen.setForeground(this.fore);
		cardinfo.setForeground(this.fore);
		
		usersearchbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(coolc){
					if(ssr){
						for(int i=0; i<user.listssrcool.size(); i++){
							cardlogbuffer.append(user.listssrcool.get(i).Valueof()+"\n");
							filter.add(user.listssrcool.get(i));
							}
						}
					if(sr){
						for(int i=0; i<user.listsrcool.size(); i++){
							cardlogbuffer.append(user.listsrcool.get(i).Valueof()+"\n");
							filter.add(user.listsrcool.get(i));
							}
						}
					if(r){
						for(int i=0; i<user.listrcool.size(); i++){
							cardlogbuffer.append(user.listrcool.get(i).Valueof()+"\n");
							filter.add(user.listrcool.get(i));
							}
						}
				}
				if(cutec){	
					if(ssr){
						for(int i=0; i<user.listssrcute.size(); i++){
							cardlogbuffer.append(user.listssrcute.get(i).Valueof()+"\n");
							filter.add(user.listssrcute.get(i));
							}
					}
					if(sr){
						for(int i=0; i<user.listsrcute.size(); i++){
							cardlogbuffer.append(user.listsrcute.get(i).Valueof()+"\n");
							filter.add(user.listsrcute.get(i));
							}
						}
					if(r){
						for(int i=0; i<user.listrcute.size(); i++){
							cardlogbuffer.append(user.listrcute.get(i).Valueof()+"\n");
							filter.add(user.listrcute.get(i));
							}
						}
				}
				if(passionc){
					if(ssr){
						for(int i=0; i<user.listssrpassion.size(); i++){
							cardlogbuffer.append(user.listssrpassion.get(i).Valueof()+"\n");
							filter.add(user.listssrpassion.get(i));
							}
						}
					if(sr){
						for(int i=0; i<user.listsrpassion.size(); i++){
							cardlogbuffer.append(user.listsrpassion.get(i).Valueof()+"\n");
							filter.add(user.listsrpassion.get(i));
							}
						}
					if(r){
						for(int i=0; i<user.listrpassion.size(); i++){
							cardlogbuffer.append(user.listrpassion.get(i).Valueof()+"\n");
							filter.add(user.listrpassion.get(i));
							}
						}
				}
				int count=0;
				if(filter.isEmpty()){}else{
				String searchtext = usersearch.getText();
				String searchresult = "";
				StringBuffer searchbuffer = new StringBuffer(searchresult);
				for(int i=0;i<filter.size();i++){
					if(filter.get(i).getname().contains(searchtext)){
						count++;
						searchbuffer.append(filter.get(i).Valueof()+"\n");
					}String countshow = "검색 결과 "+count+"개\n";
					searchresult = countshow+searchbuffer.toString();
				}if(count==0){JOptionPane.showMessageDialog(a,"검색 결과가 없습니다.","검색 결과",JOptionPane.INFORMATION_MESSAGE);}else{
				JOptionPane.showMessageDialog(a,searchresult,"검색 결과",JOptionPane.INFORMATION_MESSAGE);
			}
		}}});
		
		usercard.setEditable(false);
		
		filterssr.addItemListener(new filteraction());
		filtersr.addItemListener(new filteraction());
		filterr.addItemListener(new filteraction());
		filtercute.addItemListener(new filteraction());
		filtercool.addItemListener(new filteraction());
		filterpassion.addItemListener(new filteraction());
		filterssr.setSelected(true);
		filtersr.setSelected(true);
		filterr.setSelected(true);
		filtercute.setSelected(true);
		filtercool.setSelected(true);
		filterpassion.setSelected(true);
		
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				filter.clear();
				int result =JOptionPane.showConfirmDialog(a, "정말 초기화합니까?"," 초기화",JOptionPane.YES_OPTION);
				if(result ==JOptionPane.YES_OPTION){
				ArrayList<Card> empty = new ArrayList<Card>();
				user.cardreset();
				user.listrcool.clear();
				user.listsrcool.clear();
				user.listssrcool.clear();
				user.listrcute.clear();
				user.listsrcute.clear();
				user.listssrcute.clear();
				user.listrpassion.clear();
				user.listsrpassion.clear();
				user.listssrpassion.clear();
				SSRInfo.setText("SSR  ");
				SRInfo.setText("SR  ");
				RInfo.setText("R  ");
				CuteInfo.setText("Cute  ");
				CoolInfo.setText("Cool  ");
				PassionInfo.setText("Passion  ");
				cardlogbuffer=new StringBuffer("");
				usercard.setText("");}
			}
		});
		
		resetjewel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int result =JOptionPane.showConfirmDialog(a, "정말 초기화합니까?"," 초기화",JOptionPane.YES_OPTION);
				if(result ==JOptionPane.YES_OPTION){
				user.jewelreset();
				jewelstat3.setText("쥬엘   ");
				}
			}
		});
		
		resetyen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int result =JOptionPane.showConfirmDialog(a, "정말 초기화합니까?"," 초기화",JOptionPane.YES_OPTION);
				if(result ==JOptionPane.YES_OPTION){
				user.moneyreset();
				moneystat3.setText("돈   ");
				}
			}
		});
		
		setSize(580,365);
		setVisible(true);
		setResizable(false);
		
	}
	
	public void refresh() {
		moneystat3.setText("돈   "+user.yen);
		jewelstat3.setText("쥬엘    "+user.jewel);
		usedjewel.setText("사용한 쥬엘   "+user.usedjewel);
		if(user.SSRNumber==0){SSRInfo.setText("SSR");}else{
		SSRInfo.setText("SSR  "+(user.returncards("SSR", "cute")+user.returncards("SSR", "cool")+user.returncards("SSR", "passion")));}
		if(user.SRNumber==0){SRInfo.setText("SR");}else{
		SRInfo.setText("SR  "+(user.returncards("SR", "cute")+user.returncards("SR", "cool")+user.returncards("SR", "passion")));}
		if(user.RNumber==0){RInfo.setText("R");}else{
		RInfo.setText("R  "+(user.returncards("R", "cute")+user.returncards("R", "cool")+user.returncards("R", "passion")));}
		if(user.cute==0){CuteInfo.setText("Cute");}else{
		CuteInfo.setText("Cute  "+(user.returncards("SSR", "cute")+user.returncards("SR", "cute")+user.returncards("R", "cute")));}
		if(user.cool==0){CoolInfo.setText("Cool");}else{
		CoolInfo.setText("Cool  "+(user.returncards("SSR", "cool")+user.returncards("SR", "cool")+user.returncards("R", "cool")));}
		if(user.passion==0){PassionInfo.setText("Passion");}else{
		PassionInfo.setText("Passion  "+(user.returncards("SSR", "passion")+user.returncards("SR", "passion")+user.returncards("R", "passion")));}
		cardlog="";
		cardlogbuffer.setLength(0);
		cardlogbuffer=new StringBuffer(cardlog);
		
		if(coolc){
			if(ssr){
				for(int i=0; i<user.listssrcool.size(); i++){
					cardlogbuffer.append(user.listssrcool.get(i).Valueof());
					cardlogbuffer.append("\n");
					filter.add(user.listssrcool.get(i));
					}
				}
			if(sr){
				for(int i=0; i<user.listsrcool.size(); i++){
					cardlogbuffer.append(user.listsrcool.get(i).Valueof());
					cardlogbuffer.append("\n");
					filter.add(user.listsrcool.get(i));
					}
				}
			if(r){
				for(int i=0; i<user.listrcool.size(); i++){
					cardlogbuffer.append(user.listrcool.get(i).Valueof());
					if(i==user.listrcool.size()-1){break;}
					cardlogbuffer.append("\n");
					
					filter.add(user.listrcool.get(i));
					}
				}
		}
		if(cutec){
			if(ssr){
				for(int i=0; i<user.listssrcute.size(); i++){
					cardlogbuffer.append(user.listssrcute.get(i).Valueof());
					cardlogbuffer.append("\n");
					filter.add(user.listssrcute.get(i));
					}
				}
			if(sr){
				for(int i=0; i<user.listsrcute.size(); i++){
					cardlogbuffer.append(user.listsrcute.get(i).Valueof());
					cardlogbuffer.append("\n");
					filter.add(user.listsrcute.get(i));
					}
				}
			if(r){
				for(int i=0; i<user.listrcute.size(); i++){
					cardlogbuffer.append(user.listrcute.get(i).Valueof());
					if(i==user.listrcute.size()-1){break;}
					cardlogbuffer.append("\n");
					filter.add(user.listrcute.get(i));
					}
				}
		}
		if(passionc){
			if(ssr){
				for(int i=0; i<user.listssrpassion.size(); i++){
					cardlogbuffer.append(user.listssrpassion.get(i).Valueof());
					cardlogbuffer.append("\n");
					filter.add(user.listssrpassion.get(i));
					}
				}
			if(sr){
				for(int i=0; i<user.listsrpassion.size(); i++){
					cardlogbuffer.append(user.listsrpassion.get(i).Valueof());
					cardlogbuffer.append("\n");
					filter.add(user.listsrpassion.get(i));
					}
				}
			if(r){
				for(int i=0; i<user.listrpassion.size(); i++){
					cardlogbuffer.append(user.listrpassion.get(i).Valueof());
					if(i==user.listrpassion.size()-1){break;}
					cardlogbuffer.append("\n");
					filter.add(user.listrpassion.get(i));
					}
				}
		}
		cardlog=cardlogbuffer.toString();
		usercard.setText(cardlog);
	}
	
	public class filteraction implements ItemListener{
		public void itemStateChanged(ItemEvent t){
			
			String a =t.getSource().toString();
			StringBuffer b = new StringBuffer(a);
			switch(b.substring(b.length()-4, b.length())){
			case"ssr]":{
				if(t.getStateChange() ==ItemEvent.DESELECTED){
					ssr=false;refresh();break;
				} else {ssr=true;refresh();break;}
			}
			case"=sr]":{
				if(t.getStateChange() ==ItemEvent.DESELECTED){
					sr=false;refresh();break;
				} else {sr=true;refresh();break;}
			}
			case"t=r]":{
				if(t.getStateChange() ==ItemEvent.DESELECTED){
					r=false;refresh();break;
				} else {r=true;refresh();break;}
			}
			case"ute]":{
				if(t.getStateChange() ==ItemEvent.DESELECTED){
					cutec=false;refresh();break;
				} else {cutec=true;refresh();break;}
			}
			case"ool]":{
				if(t.getStateChange() ==ItemEvent.DESELECTED){
					coolc=false;refresh();break;
				} else {coolc=true;refresh();break;}
			}
			case"ion]":{
				if(t.getStateChange() ==ItemEvent.DESELECTED){
					passionc=false;refresh();break;
				} else {passionc=true;refresh();break;}
			}
			}
		}
	}
	
	public class gachaaction implements ActionListener{
		
		public void showerror(){
			JOptionPane.showMessageDialog(a, "쥬엘이 부족합니다"," 쥬엘 부족",JOptionPane.ERROR_MESSAGE);
		}
		
		public boolean checkjewel(User user, int jewel){
			if(nojewelset){return true;}else{
			if(user.jewel<jewel){
				return false;
			}else if(user.jewel>=jewel) {user.usedjewel+=jewel;return true;}
			return true;}
		}
		
		public void refresh(){
			moneystat3.setText("돈   "+user.yen);
			jewelstat3.setText("쥬엘   "+user.jewel);
			usedjewel.setText("사용한 쥬엘   "+user.usedjewel);
			if(user.SSRNumber==0){SSRInfo.setText("SSR");}else{
			SSRInfo.setText("SSR  "+(user.returncards("SSR", "cute")+user.returncards("SSR", "cool")+user.returncards("SSR", "passion")));}
			if(user.SRNumber==0){SRInfo.setText("SR");}else{
			SRInfo.setText("SR  "+(user.returncards("SR", "cute")+user.returncards("SR", "cool")+user.returncards("SR", "passion")));}
			if(user.RNumber==0){RInfo.setText("R");}else{
			RInfo.setText("R  "+(user.returncards("R", "cute")+user.returncards("R", "cool")+user.returncards("R", "passion")));}
			if(user.cute==0){CuteInfo.setText("Cute");}else{
			CuteInfo.setText("Cute  "+(user.returncards("SSR", "cute")+user.returncards("SR", "cute")+user.returncards("R", "cute")));}
			if(user.cool==0){CoolInfo.setText("Cool");}else{
			CoolInfo.setText("Cool  "+(user.returncards("SSR", "cool")+user.returncards("SR", "cool")+user.returncards("R", "cool")));}
			if(user.passion==0){PassionInfo.setText("Passion");}else{
			PassionInfo.setText("Passion  "+(user.returncards("SSR", "passion")+user.returncards("SR", "passion")+user.returncards("R", "passion")));}
			cardlog="";
			cardlogbuffer.setLength(0);
			cardlogbuffer=new StringBuffer(cardlog);
			if(coolc){
				for(int i=0; i<user.listssrcool.size(); i++){
					cardlogbuffer.append(user.listssrcool.get(i).Valueof()+"\n");}
				for(int i=0; i<user.listsrcool.size(); i++){
					cardlogbuffer.append(user.listsrcool.get(i).Valueof()+"\n");}
				for(int i=0; i<user.listrcool.size(); i++){
					cardlogbuffer.append(user.listrcool.get(i).Valueof()+"\n");}
			}
			if(cutec){
				for(int i=0; i<user.listssrcute.size(); i++){
					cardlogbuffer.append(user.listssrcute.get(i).Valueof()+"\n");}
				for(int i=0; i<user.listsrcute.size(); i++){
					cardlogbuffer.append(user.listsrcute.get(i).Valueof()+"\n");}
				for(int i=0; i<user.listrcute.size(); i++){
					cardlogbuffer.append(user.listrcute.get(i).Valueof()+"\n");}
			}
			if(passionc){
				for(int i=0; i<user.listssrpassion.size(); i++){
					cardlogbuffer.append(user.listssrpassion.get(i).Valueof()+"\n");}
				for(int i=0; i<user.listsrpassion.size(); i++){
					cardlogbuffer.append(user.listsrpassion.get(i).Valueof()+"\n");}
				for(int i=0; i<user.listrpassion.size(); i++){
					if(i==user.listrpassion.size()-1&&i>2){cardlogbuffer.append(user.listrpassion.get(i).Valueof());}else{
					cardlogbuffer.append(user.listrpassion.get(i).Valueof()+"\n");}}
			}
			cardlog=cardlogbuffer.toString();
			usercard.setText(cardlog);
		}
		
		public void actionPerformed(ActionEvent e){
			String menu = e.getActionCommand();
			switch(menu){
			case"단챠":{
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
			case"연챠":{
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
			case"연금":{
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
			case"검색":{
				int count=0;
				if(resulttemp.isEmpty()){}else{
				String searchtext = searchtable.getText();
				String searchresult = "";
				StringBuffer searchbuffer = new StringBuffer(searchresult);
				for(int i=0;i<resulttemp.size();i++){
					if(resulttemp.get(i).getname().contains(searchtext)){
						count++;
						searchbuffer.append(resulttemp.get(i).Valueof()+"\n");
					}String countshow = "검색 결과 "+count+"개\n";
					searchresult = countshow+searchbuffer.toString();
				}if(count==0){JOptionPane.showMessageDialog(a,"검색 결과가 없습니다.","검색 결과",JOptionPane.INFORMATION_MESSAGE);}else{
				JOptionPane.showMessageDialog(a,searchresult,"검색 결과",JOptionPane.INFORMATION_MESSAGE);
				}break;}break;}
			case"무한":{
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
						if(resultcard.getlev().equals("SSR")){gachatext.append(resultcard.Valueof());}
						else{gachatext.append(resultcard.Valueof()+"\n");}
						resulttemp.add(resultcard);
						count++;
						this.refresh();
						String gacharesult=gachatext.toString();
						if(!this.checkjewel(user, 250)){
							JOptionPane.showMessageDialog(a, "SSR을 뽑지 못했지만 쥬엘이 부족합니다", " 에러", JOptionPane.ERROR_MESSAGE);
							result.setText(result.getText()+gacharesult);
							break;
						}
						if(resultcard.getlev().equals("SSR")){
							result.setText(result.getText()+gacharesult);
							JOptionPane.showMessageDialog(a,count+"번 만에 SSR이 나왔습니다.","무한 가챠",JOptionPane.INFORMATION_MESSAGE);
							break;
							}
						}
					else {
						resultcard=g.ReturnToGUILimited(user, 0);
						if(resultcard.getlev().equals("SSR")){gachatext.append(resultcard.Valueof());}
						else{gachatext.append(resultcard.Valueof()+"\n");}
						resulttemp.add(resultcard);
						count++;
						this.refresh();
						String gacharesult=gachatext.toString();
						if(!this.checkjewel(user, 250)){
							JOptionPane.showMessageDialog(a, "SSR을 뽑지 못했지만 쥬엘이 부족합니다", " 에러", JOptionPane.ERROR_MESSAGE);
							result.setText(result.getText()+gacharesult);
							break;
						}
						if(resultcard.getlev().equals("SSR")){				
							result.setText(result.getText()+gacharesult);
							JOptionPane.showMessageDialog(a,count+"번 만에 SSR이 나왔습니다.","무한 가챠",JOptionPane.INFORMATION_MESSAGE);
							break;
						}
					}
				}while(true);
				break;}else{this.showerror();break;}
			}
			case"확률 조정":{
				new ProbabilityInfo();
				break;
			}
			case"종료":{int result =JOptionPane.showConfirmDialog(a, "종료하시겠습니까?","종료",JOptionPane.YES_OPTION);
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
			case"엔화로 결제":{
				String yen;
				int yencharge;
				do{
				yen=JOptionPane.showInputDialog(a,"충전할 엔을 입력하세요");
				try{
					if(yen.equals("")){
						break;
					}
					else{
						try{yencharge=Integer.valueOf(yen);}
						catch(NumberFormatException i){
							JOptionPane.showMessageDialog(a,"잘못 입력하셨습니다. 정수를 입력하세요"," 에러 발생",JOptionPane.ERROR_MESSAGE);
							continue;
						}
						user.yen+=yencharge;
						user.usedyen+=yencharge;
						moneystat3.setText("돈   "+user.yen);
						usedyen.setText("사용한 돈   "+user.usedyen);
					}
				}catch(Exception a){
					break;
				}break;
			}while(true);break;
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
			moneystat3.setText("돈 : "+user.yen);
			jewelstat3.setText("쥬엘 : "+user.jewel);
		}
		
		public void checkmoney (User user, int jewel, int money){
			if(user.yen<money){
				JOptionPane.showMessageDialog(a, "돈이 부족합니다"," 충전 요망",JOptionPane.ERROR_MESSAGE);
			} else{
				user.jewel+=jewel;
				user.yen-=money;
				this.refresh();
				}
		}
		public void actionPerformed(ActionEvent e){
			String jewelselect=(String)jewellist.getSelectedItem();
			if(jewelselect==jewels2.get(0)){
				JOptionPane.showMessageDialog(a, "구입할 쥬엘을 선택해주세요"," 고르시오",JOptionPane.INFORMATION_MESSAGE);
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
	
	public class ProbabilityInfo extends JFrame{
		JTextField SSRP = new JTextField(4);
		JTextField SRP = new JTextField(4);
		JTextField RP = new JTextField(4);
		JLabel prostat = new JLabel();
		Double tempR = 100-(user.tempSSR+user.tempSR);
		JComboBox prolists = new JComboBox();
		
		public class prolistaction implements ItemListener{
			public void itemStateChanged(ItemEvent e) {
				String item=e.getItem().toString();
				switch(item){
				case"사용자 설정":{
					SSRP.setText("");
					SRP.setText("");
					RP.setText("");
					break;
				}
				case"기본 설정값":{
					SSRP.setText("1.5");
					SRP.setText("10.0");
					break;
				}
				case"신데페스":{
					SSRP.setText("3.0");
					SRP.setText("10.0");
					break;
				}
				}
			}
		}
		
		ProbabilityInfo(){
			Color back = Color.WHITE;
			Color fore = Color.BLACK;
			Font info2 = new Font("맑은 고딕",0,14);
			
			Gacha g = new Gacha();
			setTitle("확률 조정");
			Container c = getContentPane();
			c.setLayout(new BorderLayout(2,2));
			JLabel title = new JLabel(" 가챠 확률 조정 메뉴");
			JButton exit = new JButton("종료");
			c.setBackground(back);
			c.setForeground(fore);
			JPanel info = new JPanel();
			info.setBackground(back);
			JPanel titlebar = new JPanel();
			titlebar.setBackground(back);
			titlebar.setLayout(new BorderLayout(10,10));
			
			info.setLayout(null);
			titlebar.add(exit,BorderLayout.EAST);
			titlebar.add(title,BorderLayout.WEST);
			
			exit.setLocation(259,1);
			title.setLocation(1,1);
			
			exit.setSize(40,40);
			title.setSize(15,15);
			
			c.add(info, BorderLayout.CENTER);
			c.add(titlebar,BorderLayout.NORTH);
			
			title.setFont(new Font("맑은 고딕",Font.BOLD,20));
			exit.setFont(new Font("맑은 고딕",0,15));
			
			exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			// title 
			
			prostat.setText("현재 확률  SSR : "+user.tempSSR+"  SR : "+user.tempSR+"  R : "+tempR);
			JLabel warning = new JLabel("    SSR+SR확률을 100 이상으로 하거나");
			JLabel warning2 = new JLabel("   둘중 하나를 100으로 설정하지 마세요");
			
			JLabel SSR = new JLabel("SSR");
			JLabel SR = new JLabel("SR");
			JLabel R = new JLabel("R");
			
			JButton OK = new JButton("저장");
			
			RP.setEditable(false);
			String [] prolist ={"사용자 설정","기본 설정값","신데페스"};
			ArrayList<String> prolistarray = new ArrayList<String>();
			for(int i=0; i<prolist.length;i++){
				prolistarray.add(prolist[i]);
			}
			
			prolists = new JComboBox(prolist);
			prolists.addItemListener(new prolistaction());

			info.add(prostat);
			info.add(warning);
			info.add(warning2);
			info.add(SSR);
			info.add(SR);
			info.add(R);
			info.add(SSRP);
			info.add(SRP);
			info.add(RP);
			info.add(OK);
			info.add(prolists);
			
			prostat.setSize(300,40);
			warning.setSize(300,80);
			warning2.setSize(300,80);
			SSR.setSize(30,15);
			SR.setSize(30,15);
			R.setSize(30,15);
			SSRP.setSize(35,30);
			SRP.setSize(35,30);
			RP.setSize(35,30);
			OK.setSize(95,20);
			prolists.setSize(95,20);
			
			prostat.setLocation(20,0);
			warning.setLocation(10,2);
			warning2.setLocation(10,19);
			SSR.setLocation(14,70);
			SR.setLocation(74,70);
			R.setLocation(134,70);
			SSRP.setLocation(10,90);
			SRP.setLocation(70,90);
			RP.setLocation(130,90);
			OK.setLocation(185,100);
			prolists.setLocation(185,75);
			
			prostat.setFont(info2);
			warning.setFont(info2);
			SSR.setFont(info2);
			SR.setFont(info2);
			R.setFont(info2);
			SSRP.setFont(info2);
			SRP.setFont(info2);
			RP.setFont(info2);
			OK.setFont(info2);
			prolists.setFont(info2);
			warning2.setFont(info2);
			
			OK.addActionListener(new OKaction());
			
			setSize(300,200);
			setResizable(false);
			setVisible(true);	
		}
		
		public class OKaction implements ActionListener{
				
			public void showerror(){
				JOptionPane.showMessageDialog(a, "잘못 입력하셨습니다"," 잘못 입력",JOptionPane.ERROR_MESSAGE);
			}
			public void actionPerformed(ActionEvent e) {
				Double ssrp=0.0;
				Double srp=0.0;
				Double rp=0.0;
				try{ssrp=Double.parseDouble(SSRP.getText());
				srp=Double.parseDouble(SRP.getText());
				if(ssrp+srp>=100){
					this.showerror();
					SSRP.setText("");
					SRP.setText("");
					RP.setText("");
				}else{
				RP.setText(String.valueOf(100-(ssrp+srp)));
				rp=Double.parseDouble(RP.getText());
				g.ProbabilityChangeGUI(user, ssrp, srp);
				prostat.setText("현재 확률  SSR : "+user.tempSSR+"  SR : "+user.tempSR+"  R : "+g.ProbabilityShowGUI(user, 2));}}
				catch(NumberFormatException a){
					this.showerror();
					SSRP.setText("");
					SRP.setText("");
					RP.setText("");
				}
			}
		}
	}
	
	public static void main(String[] args){new MainMenu();}}