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
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Database.*;
import Gacha.*;

interface userthing{
	User user = new User();
	Gacha g = new Gacha();
	CardList lists = new CardList();
}

 class Menu extends JFrame implements userthing {
	int tempCardNumber[] = new int[6];
	Color back = Color.WHITE;
	Color fore = Color.DARK_GRAY;
	
	Border border = new LineBorder(Color.GRAY,1);
	
	JLabel fcardimage = new JLabel();
	JLabel usedjewel = new JLabel("»ç¿ëÇÑ Áê¿¤ : "+user.usedjewel);
	JLabel usedyen = new JLabel("»ç¿ëÇÑ µ·   "+user.usedyen);
	JLabel SSRInfo = new JLabel("SSR : "+user.SSRNumber);
	JLabel SRInfo = new JLabel("SR : "+user.SRNumber);
	JLabel RInfo = new JLabel("R : "+user.RNumber);
	JLabel CuteInfo = new JLabel("Cute : "+user.cute);
	JLabel CoolInfo = new JLabel("Cool : "+user.cool);
	JLabel PassionInfo = new JLabel("Passion : "+user.passion);
	
	JTextArea skillstr = new JTextArea("");
	JTextArea result = new JTextArea(9,10);
	JTextArea usercard = new JTextArea(9,10);
	JTextField searchtable = new JTextField(20);
	JTextField usersearch = new JTextField(20);
	
	ArrayList<Card> filter = new ArrayList<Card>();
	ArrayList<Card> resulttemp = new ArrayList<Card>();
	
	JLabel moneystat3 = new JLabel();
	JLabel jewelstat3 = new JLabel();
	JLabel infoname = new JLabel("ÀÌ¸§ : ");
	JLabel infotype = new JLabel("¼Ó¼º : ");
	JLabel infolev = new JLabel("µî±Þ : ");
	JLabel skilltitle = new JLabel("½ºÅ³ : ");
	JLabel appealtitleb = new JLabel("Æ¯ÈÆ Àü");
	JLabel appealtitlea = new JLabel("Æ¯ÈÆ ÈÄ");
	JLabel vocal = new JLabel("º¸ÄÃ : ");
	JLabel dance = new JLabel("´í½º : ");
	JLabel visual = new JLabel("ºñÁê¾ó : ");
	JLabel life = new JLabel("¶óÀÌÇÁ : ");
	JLabel vocalb = new JLabel();
	JLabel danceb = new JLabel();
	JLabel visualb = new JLabel();
	JLabel lifeb = new JLabel();
	JLabel vocala = new JLabel();
	JLabel dancea = new JLabel();
	JLabel visuala = new JLabel();
	JLabel lifea = new JLabel();
	JLabel centertitle = new JLabel("¼¾ÅÍ ½ºÅ³  : ");
	JLabel centerstr = new JLabel("");
	JLabel resultssr = new JLabel("SSR : ");
	JLabel resultsr = new JLabel("SR : ");
	JLabel resultr = new JLabel("R : ");
	JLabel resultcute = new JLabel("Cute : ");
	JLabel resultcool = new JLabel("Cool : ");
	JLabel resultpassion = new JLabel("Passion : ");

	String jewel ="Áê¿¤ : ";
	String yen = "µ· : ";
	JLabel jewellists = new JLabel("Áê¿¤ ¸ñ·Ï");
	
	JPanel gacha = new JPanel();
	JPanel money = new JPanel();
	JPanel info = new JPanel();
	JPanel titlebar = new JPanel();
	JPanel statbar = new JPanel();
	JPanel cardinfo = new JPanel();
	
	JTextField yenchargefield = new JTextField();
	
	Card resultcard = new Card();
	JRadioButton limited = new JRadioButton("ÇÑÁ¤");
	JRadioButton nojewel = new JRadioButton("³ëÁê¿¤");
	
	String cardlog="";
	StringBuffer cardlogbuffer = new StringBuffer(cardlog);
	
	JRadioButton filterssr = new JRadioButton("ssr");
	JRadioButton filtersr = new JRadioButton("sr");	
	JRadioButton filterr = new JRadioButton("r");
	JRadioButton filtercute = new JRadioButton("cute");	
	JRadioButton filtercool = new JRadioButton("cool");
	JRadioButton filterpassion = new JRadioButton("passion");	

	Iterator<Card> search = resulttemp.iterator();

	JButton exit = new JButton("Á¾·á");
	
	public Container a = getContentPane();
	
	JRadioButton cute = new JRadioButton("Cute");
	JRadioButton cool = new JRadioButton("Cool");
	JRadioButton passion = new JRadioButton("Passion");
	JRadioButton alltype = new JRadioButton("All");
	
	boolean nojewelset;

//	JComboBox jewellist = new JComboBox();
	String select="";
	
	ArrayList<String> jewels2 = new ArrayList<String>();
	String [] jewels ={"A: Áê¿¤ 60°³ - 120¿£","B: Áê¿¤ 360°³ - 480¿£",
			"C: Áê¿¤ 760°³ - 960¿£","D: Áê¿¤ 1300°³ - 1600¿£","E: Áê¿¤ 2650°³ - 3200¿£",
			"F: Áê¿¤ 4200°³ - 5000¿£","G: Áê¿¤ 8400°³ - 9800¿£"};
	JList jewellist = new JList(jewels);
	JList cardinfolist = new JList(lists.returncardinfo("All","All").toArray());
	JScrollPane cardinfolistpane = new JScrollPane(cardinfolist);
	boolean coolc=true;
	boolean cutec=true;
	boolean passionc=true;
	boolean ssr=true;
	boolean sr=true;
	boolean r=true;
}

public class MainMenu extends Menu implements userthing {
	
	JLabel moneystat3 = new JLabel();
	JLabel jewelstat3 = new JLabel();

	MainMenu(){
		
		nojewelset=false;
		Image moneyimage =null;
		Image debugimage =null;
		Image titleimage = null;
		Image titleimage2 = null;
		Image moneyimage2 = null;
		user.limited=false;
		
		Font mainfont = new Font("¸¼Àº °íµñ",0,15);
		Font mainfont2 = new Font("¸¼Àº °íµñ",0,13);
		Font mainfont3 = new Font("¸¼Àº °íµñ",0,11);
		Container back = getContentPane();
		back.setBackground(this.back);
		back.setForeground(this.fore);
		setTitle("µ¥·¹½ºÅ× °¡Ã­ ½Ã¹Ä·¹ÀÌÅÍ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try{File sourceimage = new File("Image/moneymenu/main");
		moneyimage = ImageIO.read(sourceimage);}
		catch(IOException e){}
		try{File sourceimage2 = new File("Image/cardimage/asukassr-before");
		debugimage = ImageIO.read(sourceimage2);}
		catch(IOException e){}
		try{File sourceimage2 = new File("Image/mainimage/title");
		titleimage = ImageIO.read(sourceimage2);}
		catch(IOException e){}
		try{File sourceimage2 = new File("Image/cardimage/test");
		titleimage2 = ImageIO.read(sourceimage2);}
		catch(IOException e){}
		try{File sourceimage2 = new File("Image/moneymenu/sign");
		moneyimage2 = ImageIO.read(sourceimage2);}
		catch(IOException e){}
		
		JLabel Title = new JLabel (new ImageIcon(titleimage));
		titlebar.setLayout(new BorderLayout(50,50));
		titlebar.add(Title,BorderLayout.WEST);
		titlebar.setBackground(this.back);
		titlebar.setForeground(this.fore);
		
		Title.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,20));
		
		a.setLayout(new BorderLayout(5,5));
		
		a.add(titlebar,BorderLayout.NORTH);
		a.add(statbar, BorderLayout.SOUTH);
		
		exit.setFont(mainfont);
		JTabbedPane tab = new JTabbedPane();
		tab.setUI(new AquaBarTabbedPaneUI());
		tab.setBackground(this.back);
		tab.setForeground(this.fore);
		tab.add(money,"°ú±Ý");
		tab.add(gacha,"°¡Ã­");
		tab.add(info,"Á¤º¸");
		tab.add(cardinfo, "Ä«µåÁ¤º¸");
	
		money.setLayout(null);
		gacha.setLayout(null);
		info.setLayout(null);
		statbar.setLayout(new GridLayout(1,3,50,5));
		money.setBackground(this.back);
		gacha.setBackground(this.back);
		info.setBackground(this.back);
		statbar.setBackground(this.back);
		money.setForeground(this.fore);
		gacha.setForeground(this.fore);
		info.setForeground(this.fore);
		statbar.setForeground(this.fore);
		
		// »óÅÂ¹Ù Ç×¸ñ
		JButton exit2 = new JButton("Á¾·á");
		moneystat3.setText(yen);
		jewelstat3.setText("Áê¿¤ : ");
		
		statbar.add(jewelstat3);
		statbar.add(moneystat3);
		statbar.add(exit2);
		
		jewelstat3.setFont(mainfont);
		moneystat3.setFont(mainfont);
		exit2.setFont(mainfont);
		
		exit2.setBorder(this.border);
		
		exit2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			int result =JOptionPane.showConfirmDialog(a, "Á¾·áÇÏ½Ã°Ú½À´Ï±î?","Á¾·á",JOptionPane.YES_OPTION);
			if(result ==JOptionPane.YES_OPTION){
			System.exit(0);
			}
			}
		});
		exit2.setBorder(new LineBorder(Color.WHITE,1));
		exit2.setBackground(this.back);
		exit2.setForeground(this.fore);
		jewelstat3.setForeground(this.fore);
		moneystat3.setForeground(this.fore);
		
		// Ä«µå Á¤º¸ ¸Þ´º Ç×¸ñ
		cardinfo.setBackground(this.back);
		
		JLabel cardinfoname = new JLabel("Ä«µå Á¤º¸ ÀÏ¶÷");
		cardinfoname.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,20));
		final JLabel testimage = new JLabel();
		cardinfo.setLayout(null);
		cardinfo.add(testimage);
		cardinfo.add(cardinfoname);
		cardinfo.add(cardinfolistpane);
		cardinfo.add(infoname);
		cardinfo.add(infotype);
		cardinfo.add(infolev);
		cardinfo.add(skillstr);
		cardinfo.add(skilltitle);
		cardinfo.add(appealtitleb);
		cardinfo.add(appealtitlea);
		cardinfo.add(vocal);
		cardinfo.add(visual);
		cardinfo.add(dance);
		cardinfo.add(life);
		cardinfo.add(vocalb);
		cardinfo.add(visualb);
		cardinfo.add(danceb);
		cardinfo.add(lifeb);
		cardinfo.add(vocala);
		cardinfo.add(visuala);
		cardinfo.add(dancea);
		cardinfo.add(lifea);
		cardinfo.add(centerstr);
		cardinfo.add(centertitle);
		
		testimage.setLocation(303,6);
		cardinfoname.setLocation(65, 6);
		cardinfolistpane.setLocation(6,35);
		infotype.setLocation(297,76);
		infolev.setLocation(297,92);
		infoname.setLocation(297,108);
		skillstr.setLocation(297,140);
		skilltitle.setLocation(297,124);
		centertitle.setLocation(297,190);
		centerstr.setLocation(297,206);
		appealtitleb.setLocation(425,3);
		appealtitlea.setLocation(495,3);
		vocal.setLocation(375,17);
		dance.setLocation(375,33);
		visual.setLocation(375,49);
		life.setLocation(375,65);
		vocalb.setLocation(425,17);
		danceb.setLocation(425,33);
		visualb.setLocation(425,49);
		lifeb.setLocation(425,65);
		vocala.setLocation(495,17);
		dancea.setLocation(495,33);
		visuala.setLocation(495,49);
		lifea.setLocation(495,65);
		
		testimage.setSize(66,66);
		cardinfoname.setSize(150,20);
		cardinfolistpane.setSize(284,190);
		infotype.setSize(150,15);
		infolev.setSize(150,15);
		infoname.setSize(290,15);
		skillstr.setSize(270,45);
		skilltitle.setSize(190,15);
		centertitle.setSize(150,15);
		centerstr.setSize(290,15);
		appealtitleb.setSize(140,15);
		appealtitlea.setSize(140,15);
		vocal.setSize(90,15);
		dance.setSize(90,15);
		visual.setSize(90,15);
		life.setSize(90,15);
		vocalb.setSize(120,15);
		danceb.setSize(120,15);
		visualb.setSize(120,15);
		lifeb.setSize(120,15);
		vocala.setSize(120,15);
		dancea.setSize(120,15);
		visuala.setSize(120,15);
		lifea.setSize(120,15);

		cardinfolist.setFont(mainfont3);
		infotype.setFont(mainfont3);
		infolev.setFont(mainfont3);
		infoname.setFont(mainfont3);
		skilltitle.setFont(mainfont3);
		appealtitleb.setFont(mainfont3);
		appealtitlea.setFont(mainfont3);
		vocal.setFont(mainfont3);
		dance.setFont(mainfont3);
		visual.setFont(mainfont3);
		life.setFont(mainfont3);
		centerstr.setFont(mainfont3);
		centertitle.setFont(mainfont3);
		vocalb.setFont(mainfont3);
		danceb.setFont(mainfont3);
		visualb.setFont(mainfont3);
		lifeb.setFont(mainfont3);
		vocala.setFont(mainfont3);
		dancea.setFont(mainfont3);
		visuala.setFont(mainfont3);
		lifea.setFont(mainfont3);
		
		skillstr.setLineWrap(true);
		skillstr.setFont(mainfont3);
		skillstr.setEditable(false);
		skillstr.setDragEnabled(false);

		cardinfolistpane.setBorder(new LineBorder(Color.WHITE,0));
		cardinfolistpane.setBackground(this.back);
		cardinfolistpane.setForeground(this.fore);
		
		cardinfolist.setSelectionBackground(Color.pink);
		cardinfolist.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e) {
				JList source = (JList)e.getSource();
				int a=source.getSelectedIndex();
//				System.out.println(lists.unlimitedinfo().get(a).getImagea().toString());
				infoname.setText("ÀÌ¸§ : "+lists.unlimitedinfo().get(a).getname());
				infotype.setText("¼Ó¼º : "+lists.unlimitedinfo().get(a).gettype());
				infolev.setText("µî±Þ : "+lists.unlimitedinfo().get(a).getlev());
				vocalb.setText(""+lists.unlimitedinfo().get(a).getvocal());
				danceb.setText(""+lists.unlimitedinfo().get(a).getdance());
				visualb.setText(""+lists.unlimitedinfo().get(a).getvisual());
				lifeb.setText(""+lists.unlimitedinfo().get(a).getlife());
				vocala.setText(""+lists.unlimitedinfo().get(a).gettvocal());
				dancea.setText(""+lists.unlimitedinfo().get(a).gettdance());
				visuala.setText(""+lists.unlimitedinfo().get(a).gettvisual());
				lifea.setText(""+lists.unlimitedinfo().get(a).gettlife());
				skilltitle.setText("½ºÅ³ : "+lists.unlimitedinfo().get(a).getskilltitle());
				skillstr.setText(lists.unlimitedinfo().get(a).getskillstr());
				centertitle.setText("¼¾ÅÍ ½ºÅ³ : "+lists.unlimitedinfo().get(a).getcentertitle());
				centerstr.setText(lists.unlimitedinfo().get(a).getcenter());
			}
		});
		
		// °ú±Ý ¸Þ´º Ç×¸ñ
		JLabel moneyimagee = new JLabel(new ImageIcon(moneyimage));

		JButton yengacha = new JButton("¿£È­·Î °áÁ¦");
		JButton jewelcharge = new JButton("Áê¿¤ ÃæÀü");
		
		
		for(int i=0; i<jewels.length; i++){
			jewels2.add(jewels[i]);
		}
		
		jewellist = new JList<Object>(jewels);
		jewellist.setDragEnabled(false);
		jewellist.setSelectionMode(JList.VERTICAL);
		jewellist.setSelectedIndex(0);
		jewellist.setSelectionBackground(Color.PINK);
		JLabel sign = new JLabel(new ImageIcon(moneyimage2));
		money.add(moneyimagee);
		money.add(yengacha);
		money.add(jewelcharge);
		money.add(jewellist);
		money.add(yenchargefield);
		money.add(jewellists);
		money.add(sign);
		
		moneyimagee.setLocation(0,8);
		yengacha.setLocation(450,58);
		jewelcharge.setLocation(450,96);
		jewellist.setLocation(256,48);
		yenchargefield.setLocation(450,23);
		jewellists.setLocation(256,18);
		sign.setLocation(440,142);
		
		moneyimagee.setSize(250,208);
		yengacha.setSize(105,30);
		jewelcharge.setSize(105,30);
		jewellist.setSize(180,190);
		yenchargefield.setSize(105,30);
		jewellists.setSize(115,30);
		sign.setSize(128,83);

		yengacha.setFont(mainfont);
		jewelcharge.setFont(mainfont);
		jewellist.setFont(mainfont);
		yenchargefield.setFont(mainfont);
		jewellists.setFont(new Font("¸¼Àº °íµñ",Font.PLAIN,24));
		
		jewellist.setBackground(this.back);
		yengacha.setBackground(this.back);
		jewelcharge.setBackground(this.back);
		jewellist.setForeground(this.fore);
		yengacha.setForeground(this.fore);
		jewelcharge.setForeground(this.fore);
		
		jewellist.setBorder(new LineBorder(Color.WHITE,3));
		yengacha.setBorder(this.border);
		jewelcharge.setBorder(this.border);
		
		yengacha.addActionListener(new moneylistener());
		jewelcharge.addActionListener(new jewelcharge());
		jewellist.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e) {
				JList source = (JList)e.getSource();
				select = String.valueOf(source.getSelectedIndex());
				switch(source.getSelectedIndex()){
				case 0:{select=jewels2.get(0);break;}
				case 1:{select=jewels2.get(1);break;}
				case 2:{select=jewels2.get(2);break;}
				case 3:{select=jewels2.get(3);break;}
				case 4:{select=jewels2.get(4);break;}
				case 5:{select=jewels2.get(5);break;}
				case 6:{select=jewels2.get(6);break;}
				}
			}
		});
		
		//°¡Ã­ ¸Þ´º Ç×¸ñ
		JLabel typegacha = new JLabel("¼Ó¼ºº° °¡Ã­");
		JLabel gachatitle = new JLabel("°¡Ã­ °á°ú");
		
		JButton gachago = new JButton("1È¸ °¡Ã­");
		JButton yunchago = new JButton("10È¸ °¡Ã­");
		JButton yungumgo = new JButton("¿¬±Ý °¡Ã­");
		JButton searchbtn = new JButton("°Ë»ö");
		final JButton infinite = new JButton("¹«ÇÑ °¡Ã­");
		JButton hawkryul = new JButton("È®·ü Á¶Á¤");
		
		JRadioButton image = new JRadioButton("ÀÌ¹ÌÁö ¸ðµå");
		
	    final JScrollPane scrollPane= new JScrollPane(result);
	    final JPanel gacharesult = new JPanel ();
	    gacharesult.setLayout(new GridLayout(2,5,5,5));
	    JScrollPane a2 = new JScrollPane(gacharesult, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    a2.setPreferredSize(new Dimension(32,199));
	    a2.setBorder(new LineBorder(Color.WHITE,1));
	    a2.setBackground(this.back);
	    a2.setForeground(this.fore);
	    gacharesult.setBackground(this.back);
	    
		gacha.setLayout(null);
		gacha.add(gachago);
		gacha.add(yunchago);
		gacha.add(yungumgo);
		gacha.add(scrollPane);
		gacha.add(a2);
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
		gacha.add(resultssr);
		gacha.add(resultsr);
		gacha.add(resultr);
		gacha.add(resultcute);
		gacha.add(resultcool);
		gacha.add(resultpassion);
		gacha.add(image);
		
		a2.setVisible(true);
		a2.setSize(372,189);
		a2.setLocation(196,33);

		gachago.setSize(94,30);
		yunchago.setSize(94,30);
		yungumgo.setSize(94,30);
		scrollPane.setSize(372,199);
		searchtable.setSize(224,20);
		searchbtn.setSize(65,25);
		limited.setSize(60,20);
		gachatitle.setSize(365,20);
		cute.setSize(60,20);
		cool.setSize(90,20);
		passion.setSize(90,20);
		typegacha.setSize(110,20);
		alltype.setSize(60,20);
		infinite.setSize(94,30);
		nojewel.setSize(65,20);
		hawkryul.setSize(94,30);
		resultssr.setSize(60,15);
		resultsr.setSize(60,15);
		resultr.setSize(60,15);
		resultcute.setSize(60,15);
		resultcool.setSize(60,15);
		resultpassion.setSize(60,15);
		image.setSize(96,15);
		
		gachago.setLocation(2,10);
		yunchago.setLocation(98,10);
		yungumgo.setLocation(2,42);
		scrollPane.setLocation(196,33);
		searchtable.setLocation(266,10);
		searchbtn.setLocation(500,6);
		limited.setLocation(2,107);
		gachatitle.setLocation(196,8);
		cute.setLocation(2,150);
		cool.setLocation(2,172);
		passion.setLocation(2,194);
		typegacha.setLocation(2,128);
		alltype.setLocation(62,150);
		infinite.setLocation(98,42);
		nojewel.setLocation(62,107);
		hawkryul.setLocation(100,182);
		resultssr.setLocation(2,76);
		resultsr.setLocation(60,76);
		resultr.setLocation(118,76);
		resultcute.setLocation(2,90);
		resultcool.setLocation(60,90);
		resultpassion.setLocation(118,90);
		image.setLocation(102,133);
		
		gachago.setFont(mainfont2);
		yunchago.setFont(mainfont2);
		yungumgo.setFont(mainfont2);
		scrollPane.setFont(mainfont3);
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
		result.setFont(mainfont2);
		resultssr.setFont(mainfont3);
		resultsr.setFont(mainfont3);
		resultr.setFont(mainfont3);
		resultcute.setFont(mainfont3);
		resultcool.setFont(mainfont3);
		resultpassion.setFont(mainfont3);
		image.setFont(mainfont2);
		
		image.setEnabled(false);
		
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
		image.setBackground(this.back);
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
		image.setForeground(this.fore);
		scrollPane.setBorder(new LineBorder(Color.WHITE,3));
		searchbtn.setBorder(new LineBorder(Color.WHITE,3));
		
		gachago.addActionListener(new GachaAction());
		yunchago.addActionListener(new GachaAction());
		yungumgo.addActionListener(new GachaAction());
		infinite.addActionListener(new GachaAction());
		searchbtn.addActionListener(new GachaAction());
		exit.addActionListener(new GachaAction());
		limited.addItemListener(new limitedconfigbutton());
		cute.addItemListener(new typebutton());
		cool.addItemListener(new typebutton());
		passion.addItemListener(new typebutton());
		alltype.addItemListener(new typebutton());
		nojewel.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() ==ItemEvent.SELECTED){
					nojewelset=true;
				} else {nojewelset=false;}
			}
		});
		hawkryul.addActionListener(new GachaAction());
		image.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				if(e.getStateChange()==ItemEvent.SELECTED){
					scrollPane.setVisible(false);
					gacharesult.setVisible(true);
					infinite.setEnabled(false);
				}else if(e.getStateChange()==ItemEvent.DESELECTED){
					gacharesult.setVisible(false);
					scrollPane.setVisible(true);
					infinite.setEnabled(true);
				}
			}
		});
	
		alltype.setSelected(true);
		result.setEditable(false);
		
		tab.setFont(mainfont);
		a.add(tab,BorderLayout.CENTER);
		
		
		// Á¤º¸ ¸Þ´º Ç×¸ñ
		fcardimage = new JLabel(new ImageIcon(debugimage));

		JLabel cardinfo = new JLabel("¼ÒÁö Ä«µå Á¤º¸");
		JLabel fcardtitle = new JLabel("¼±È£ ¾ÆÀÌµ¹");
		JButton reset = new JButton("Ä«µå ÃÊ±âÈ­");
		JButton resetjewel = new JButton("Áê¿¤ ÃÊ±âÈ­");
		JButton resetyen = new JButton("µ· ÃÊ±âÈ­");
		JButton usersearchbtn = new JButton("°Ë»ö");
		
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
		scrollPaneu.setLocation(265,38);
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
	    scrollPaneu.setSize(310,185);
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
		cardinfo.setFont(new Font(("¸¼Àº °íµñ"),Font.BOLD,20));
		SSRInfo.setFont(mainfont);
		SRInfo.setFont(mainfont);
		RInfo.setFont(mainfont);
		CuteInfo.setFont(mainfont);
		CoolInfo.setFont(mainfont);
		PassionInfo.setFont(mainfont);
		fcardtitle.setFont(mainfont);
		reset.setFont(mainfont2);
		resetjewel.setFont(mainfont2);
		resetyen.setFont(mainfont2);
		usersearch.setFont(mainfont);
		usersearchbtn.setFont(mainfont);
		usercard.setFont(mainfont2);
		
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
		
		scrollPaneu.setBorder(new LineBorder(Color.WHITE,3));
		usersearchbtn.setBorder(new LineBorder(Color.WHITE,3));
		reset.setBorder(new LineBorder(Color.WHITE,1));
		resetjewel.setBorder(new LineBorder(Color.WHITE,1));
		resetyen.setBorder(new LineBorder(Color.WHITE,1));
		
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
					}String countshow = "°Ë»ö °á°ú "+count+"°³\n";
					searchresult = countshow+searchbuffer.toString();
				}if(count==0){JOptionPane.showMessageDialog(a,"°Ë»ö °á°ú°¡ ¾ø½À´Ï´Ù.","°Ë»ö °á°ú",JOptionPane.INFORMATION_MESSAGE);}else{
				JOptionPane.showMessageDialog(a,searchresult,"°Ë»ö °á°ú",JOptionPane.INFORMATION_MESSAGE);
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
				int result =JOptionPane.showConfirmDialog(a, "Á¤¸» ÃÊ±âÈ­ÇÕ´Ï±î?"," ÃÊ±âÈ­",JOptionPane.YES_OPTION);
				if(result ==JOptionPane.YES_OPTION){
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
				int result =JOptionPane.showConfirmDialog(a, "Á¤¸» ÃÊ±âÈ­ÇÕ´Ï±î?"," ÃÊ±âÈ­",JOptionPane.YES_OPTION);
				if(result ==JOptionPane.YES_OPTION){
				user.jewelreset();
				jewelstat3.setText("Áê¿¤   ");
				}
			}
		});
		
		resetyen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int result =JOptionPane.showConfirmDialog(a, "Á¤¸» ÃÊ±âÈ­ÇÕ´Ï±î?"," ÃÊ±âÈ­",JOptionPane.YES_OPTION);
				if(result ==JOptionPane.YES_OPTION){
				user.moneyreset();
				moneystat3.setText("µ·   ");
				}
			}
		});
		
		setSize(580,380);
		setVisible(true);
		setResizable(false);
		
	}
	
	public void refresh() {
		resultssr.setText("SSR : "+tempCardNumber[0]);
		resultsr.setText("SR : "+tempCardNumber[1]);
		resultr.setText("R : "+tempCardNumber[2]);
		resultcute.setText("Cute : ");
		resultcool.setText("Cool : ");
		resultpassion.setText("Passion : ");
		moneystat3.setText("µ·   "+user.yen);
		jewelstat3.setText("Áê¿¤    "+user.jewel);
		usedjewel.setText("»ç¿ëÇÑ Áê¿¤   "+user.usedjewel);
		if(user.SSRNumber==0){SSRInfo.setText("SSR");}else{
		SSRInfo.setText("SSR  "+user.SSRNumber);}
		if(user.SRNumber==0){SRInfo.setText("SR");}else{
		SRInfo.setText("SR  "+user.SRNumber);}
		if(user.RNumber==0){RInfo.setText("R");}else{
		RInfo.setText("R  "+user.RNumber);}
		if(user.cute==0){CuteInfo.setText("Cute");}else{
		CuteInfo.setText("Cute  "+user.cute);}
		if(user.cool==0){CoolInfo.setText("Cool");}else{
		CoolInfo.setText("Cool  "+user.cool);}
		if(user.passion==0){PassionInfo.setText("Passion");}else{
		PassionInfo.setText("Passion  "+user.passion);}
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
	
	public class GachaAction implements ActionListener{
		
		public void checkcard(Card card){
			
			switch(card.gettype()){
			case"Å¥Æ®":{tempCardNumber[3]++;
				switch(card.getlev()){
				case"SSR":{tempCardNumber[0]++;break;}
				case"SR":{tempCardNumber[1]++;break;}
				case"R":{tempCardNumber[2]++;break;}
				}
				break;
				}
			case"Äð":{tempCardNumber[4]++;
				switch(card.getlev()){
				case"SSR":{tempCardNumber[0]++;break;}
				case"SR":{tempCardNumber[1]++;break;}
				case"R":{tempCardNumber[2]++;break;}
				}
				break;
				}
			case"ÆÐ¼Ç":{tempCardNumber[5]++;
				switch(card.getlev()){
				case"SSR":{tempCardNumber[0]++;break;}
				case"SR":{tempCardNumber[1]++;break;}
				case"R":{tempCardNumber[2]++;break;}
				}
				break;
				}
			}
		}
		
		public void showerror(){
			JOptionPane.showMessageDialog(a, "Áê¿¤ÀÌ ºÎÁ·ÇÕ´Ï´Ù"," Áê¿¤ ºÎÁ·",JOptionPane.ERROR_MESSAGE);
		}
		
		public boolean checkjewel(User user, int jewel){
			if(nojewelset){return true;}else{
			if(user.jewel<jewel){
				return false;
			}else if(user.jewel>=jewel) {user.usedjewel+=jewel;return true;}
			return true;}
		}
		
		public void refresh(){
			resultssr.setText("SSR : "+tempCardNumber[0]);
			resultsr.setText("SR : "+tempCardNumber[1]);
			resultr.setText("R : "+tempCardNumber[2]);
			resultcute.setText("Cute : "+tempCardNumber[3]);
			resultcool.setText("Cool : "+tempCardNumber[4]);
			resultpassion.setText("Passion : "+tempCardNumber[5]);
			
			moneystat3.setText("µ·   "+user.yen);
			jewelstat3.setText("Áê¿¤    "+user.jewel);
			usedjewel.setText("»ç¿ëÇÑ Áê¿¤   "+user.usedjewel);
			if(user.SSRNumber==0){SSRInfo.setText("SSR");}else{
			SSRInfo.setText("SSR  "+user.SSRNumber);}
			if(user.SRNumber==0){SRInfo.setText("SR");}else{
			SRInfo.setText("SR  "+user.SRNumber);}
			if(user.RNumber==0){RInfo.setText("R");}else{
			RInfo.setText("R  "+user.RNumber);}
			if(user.cute==0){CuteInfo.setText("Cute");}else{
			CuteInfo.setText("Cute  "+user.cute);}
			if(user.cool==0){CoolInfo.setText("Cool");}else{
			CoolInfo.setText("Cool  "+user.cool);}
			if(user.passion==0){PassionInfo.setText("Passion");}else{
			PassionInfo.setText("Passion  "+user.passion);}
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
					cardlogbuffer.append(user.listrpassion.get(i).Valueof()+"\n");}
			}
			cardlog=cardlogbuffer.toString();
			usercard.setText(cardlog);
		}
		
		public void actionPerformed(ActionEvent e){
			String menu = e.getActionCommand();
			switch(menu){
			case"1È¸ °¡Ã­":{
				for(int i=0; i<6; i++){
					tempCardNumber[i]=0;
				}
				if(this.checkjewel(user, 250)){
				resulttemp.clear();
				result.setText("");
				if(!nojewelset){user.jewel-=250;}
				StringBuffer gachatext = new StringBuffer();
				if(user.limited){
					resultcard=g.ReturnToGUIUnlimited(user, 0);
					this.checkcard(resultcard);
					gachatext.append(resultcard.Valueof()+"\n");
					resulttemp.add(resultcard);}
				else {
					resultcard=g.ReturnToGUILimited(user, 0);
					this.checkcard(resultcard);
					gachatext.append(resultcard.Valueof()+"\n");
					resulttemp.add(resultcard);}
				String gacharesult=gachatext.toString();
				result.setText(result.getText()+gacharesult);
				this.refresh();
				break;}else{this.showerror();break;}}
			case"10È¸ °¡Ã­":{
				for(int i=0; i<6; i++){
					tempCardNumber[i]=0;
				}
				if(this.checkjewel(user, 2500)){
				resulttemp.clear();
				result.setText("");
				if(!nojewelset){user.jewel-=2500;}
				StringBuffer gachatext = new StringBuffer();
				if(user.limited){
				for(int i=0; i<9; i++){
					resultcard=g.ReturnToGUIUnlimited(user, 0);
					this.checkcard(resultcard);
					gachatext.append(resultcard.Valueof()+"\n");
					resulttemp.add(resultcard);
					}resultcard=g.ReturnToGUIUnlimited(user, 1);
					this.checkcard(resultcard);
					gachatext.append(resultcard.Valueof());
					resulttemp.add(resultcard);
				} else {for(int i=0; i<9; i++){
					resultcard=g.ReturnToGUILimited(user, 0);
					this.checkcard(resultcard);
					gachatext.append(resultcard.Valueof()+"\n");
					resulttemp.add(resultcard);
					}resultcard=g.ReturnToGUILimited(user, 1);
					this.checkcard(resultcard);
					gachatext.append(resultcard.Valueof());
					resulttemp.add(resultcard);
				}
				String gacharesult=gachatext.toString();
				result.setText(result.getText()+gacharesult);
				this.refresh();
				break;}else{this.showerror();break;}}
			case"¿¬±Ý °¡Ã­":{
				for(int i=0; i<6; i++){
					tempCardNumber[i]=0;
				}
				if(this.checkjewel(user, 60)){
				resulttemp.clear();
				result.setText("");
				if(!nojewelset){user.jewel-=60;}
				StringBuffer gachatext = new StringBuffer();
				if(user.limited){
					resultcard=g.ReturnToGUILimited(user, 0);
					this.checkcard(resultcard);
					gachatext.append(resultcard.Valueof()+"\n");
					resulttemp.add(resultcard);}
				else {
					resultcard=g.ReturnToGUIUnlimited(user, 0);
					this.checkcard(resultcard);
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
					if(resulttemp.get(i).getname().contains(searchtext)){
						count++;
						searchbuffer.append(resulttemp.get(i).Valueof()+"\n");
					}String countshow = "°Ë»ö °á°ú "+count+"°³\n";
					searchresult = countshow+searchbuffer.toString();
				}if(count==0){JOptionPane.showMessageDialog(a,"°Ë»ö °á°ú°¡ ¾ø½À´Ï´Ù.","°Ë»ö °á°ú",JOptionPane.INFORMATION_MESSAGE);}else{
				JOptionPane.showMessageDialog(a,searchresult,"°Ë»ö °á°ú",JOptionPane.INFORMATION_MESSAGE);
				}break;}break;}
			case"¹«ÇÑ °¡Ã­":{
				for(int i=0; i<6; i++){
					tempCardNumber[i]=0;
				}
				
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
						this.checkcard(resultcard);
						if(resultcard.getlev().equals("SSR")){gachatext.append(resultcard.Valueof());}
						else{gachatext.append(resultcard.Valueof()+"\n");}
						resulttemp.add(resultcard);
						count++;
						this.refresh();
						String gacharesult=gachatext.toString();
						if(!this.checkjewel(user, 250)){
							JOptionPane.showMessageDialog(a, "SSRÀ» »ÌÁö ¸øÇßÁö¸¸ Áê¿¤ÀÌ ºÎÁ·ÇÕ´Ï´Ù", " ¿¡·¯", JOptionPane.ERROR_MESSAGE);
							result.setText(result.getText()+gacharesult);
							break;
						}
						if(resultcard.getlev().equals("SSR")){
							result.setText(result.getText()+gacharesult);
							JOptionPane.showMessageDialog(a,count+"¹ø ¸¸¿¡ SSRÀÌ ³ª¿Ô½À´Ï´Ù.","¹«ÇÑ °¡Ã­",JOptionPane.INFORMATION_MESSAGE);
							break;
							}
						}
					else {
						resultcard=g.ReturnToGUILimited(user, 0);
						this.checkcard(resultcard);
						if(resultcard.getlev().equals("SSR")){gachatext.append(resultcard.Valueof());}
						else{gachatext.append(resultcard.Valueof()+"\n");}
						resulttemp.add(resultcard);
						count++;
						this.refresh();
						String gacharesult=gachatext.toString();
						if(!this.checkjewel(user, 250)){
							JOptionPane.showMessageDialog(a, "SSRÀ» »ÌÁö ¸øÇßÁö¸¸ Áê¿¤ÀÌ ºÎÁ·ÇÕ´Ï´Ù", " ¿¡·¯", JOptionPane.ERROR_MESSAGE);
							result.setText(result.getText()+gacharesult);
							break;
						}
						if(resultcard.getlev().equals("SSR")){				
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
				yen=yenchargefield.getText();
				try{
					if(yen.equals("")){
						break;
					}
					else{
						try{yencharge=Integer.valueOf(yen);}
						catch(NumberFormatException i){
							JOptionPane.showMessageDialog(a,"Àß¸ø ÀÔ·ÂÇÏ¼Ì½À´Ï´Ù. Á¤¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä"," ¿¡·¯ ¹ß»ý",JOptionPane.ERROR_MESSAGE);
							yenchargefield.setText("");
							continue;
						}
						user.yen+=yencharge;
						user.usedyen+=yencharge;
						moneystat3.setText("µ·   "+user.yen);
						usedyen.setText("»ç¿ëÇÑ µ·   "+user.usedyen);
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
	public class jewelcharge implements ActionListener{
		public void checkmoney (User user, int money, int jewel){
			if(user.yen<money){
				JOptionPane.showMessageDialog(a, "µ·ÀÌ ºÎÁ·ÇÕ´Ï´Ù"," ÃæÀü ¿ä¸Á",JOptionPane.ERROR_MESSAGE);
			} else{
				user.jewel+=jewel;
				user.yen-=money;
				this.refresh();
				}
		}
		public void refresh(){
			moneystat3.setText("µ· : "+user.yen);
			jewelstat3.setText("Áê¿¤ : "+user.jewel);
		}
		
		public void actionPerformed(ActionEvent e){
			jewellist.getSelectedIndex();
			if(jewellist.getSelectedIndex()==0){
				this.checkmoney(user, 120, 60);
			}else if(jewellist.getSelectedIndex()==1){
				this.checkmoney(user, 480, 360);
			}else if(jewellist.getSelectedIndex()==2){
				this.checkmoney(user, 960, 760);
			}else if(jewellist.getSelectedIndex()==3){
				this.checkmoney(user, 1600, 1300);
			}else if(jewellist.getSelectedIndex()==4){
				this.checkmoney(user, 3200, 2650);
			}else if(jewellist.getSelectedIndex()==5){
				this.checkmoney(user, 5000, 4200);
			}else if(jewellist.getSelectedIndex()==6){
				this.checkmoney(user, 9800, 8400);
			}
		}
	}
	
	public static void main(String[] args){
//		g.loadimages();
		new MainMenu();}}