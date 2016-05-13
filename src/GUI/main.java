package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import Database.*;
import GachaChargeMenu.*;
import Menu.*;

public class main extends JFrame {
	
	JPanel gacha = new JPanel();
	JPanel money = new JPanel();
	JPanel info = new JPanel();
	JPanel titlebar = new JPanel();
	ArrayList<Card> resulttemp = new ArrayList<Card>();
	JRadioButton limited = new JRadioButton("한정 카드");
	Card resultcard = new Card();
	Gacha g = new Gacha();
	Iterator<Card> search = resulttemp.iterator();
	JTextArea result = new JTextArea(30,10);
    JTextField searchtable = new JTextField(20);
	JButton exit = new JButton("종료");
	User user = new User();
	Container a = getContentPane();
	JRadioButton cute = new JRadioButton("Cute");
	JRadioButton cool = new JRadioButton("Cool");
	JRadioButton passion = new JRadioButton("Passion");
	JRadioButton alltype = new JRadioButton("All");
	main(){
		user.limited=false;
		Font mainfont = new Font("맑은 고딕",0,15);
		Font mainfont2 = new Font("맑은 고딕",0,13);
		setTitle("데레스테 가챠 시뮬레이터");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel Title = new JLabel (" 데레스테 가챠 시뮬레이터 v2.0.0 beta 2");
		titlebar.setLayout(new BorderLayout(50,50));
		titlebar.add(Title,BorderLayout.WEST);
		titlebar.add(exit,BorderLayout.EAST);
		Title.setFont(new Font("맑은 고딕",Font.BOLD,18));
		a.setLayout(new BorderLayout(5,5));
		a.add(titlebar,BorderLayout.NORTH);
		exit.setFont(mainfont);

		JTabbedPane tab = new JTabbedPane();
		tab.add(money,"과금");
		tab.add(gacha,"가챠");
		tab.add(info,"정보");
		
		String jewel ="쥬엘 : ";
		JLabel jewelstat = new JLabel(jewel+user.jewel);
		JLabel typegacha = new JLabel("속성별 가챠");
		
		
		money.setLayout(null);
		gacha.setLayout(null);
		info.setLayout(null);
		
		//가챠 메뉴 항목
		JButton gachago = new JButton("단챠");
		JButton yunchago = new JButton("연챠");
		JButton yungumgo = new JButton("연금");
		JButton searchbtn = new JButton("검색");
		JLabel gachatitle = new JLabel("가챠 결과");
	    JScrollPane scrollPane = new JScrollPane(result);

		
		gacha.setLayout(null);
		gacha.add(gachago);
		gacha.add(yunchago);
		gacha.add(jewelstat);
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
		
		gachago.setSize(60,30);
		yunchago.setSize(60,30);
		yungumgo.setSize(60,30);
		jewelstat.setSize(110,20);
		scrollPane.setSize(360,180);
		searchtable.setSize(232,20);
		searchbtn.setSize(65,18);
		limited.setSize(110,20);
		gachatitle.setSize(365,20);
		cute.setSize(60,20);
		cool.setSize(110,20);
		passion.setSize(110,20);
		typegacha.setSize(110,20);
		alltype.setSize(60,20);
		
		gachago.setLocation(2,2);
		yunchago.setLocation(64,2);
		yungumgo.setLocation(2,34);
		jewelstat.setLocation(2,69);
		scrollPane.setLocation(128,25);
		searchtable.setLocation(188,2);
		searchbtn.setLocation(420,2);
		limited.setLocation(2,91);
		gachatitle.setLocation(128,3);
		cute.setLocation(2,137);
		cool.setLocation(2,159);
		passion.setLocation(2,181);
		typegacha.setLocation(2,115);
		alltype.setLocation(62,137);
		
		gachago.setFont(mainfont2);
		yunchago.setFont(mainfont2);
		yungumgo.setFont(mainfont2);
		jewelstat.setFont(mainfont);
		scrollPane.setFont(mainfont);
		searchtable.setFont(mainfont);
		searchbtn.setFont(mainfont2);
		limited.setFont(mainfont);
		gachatitle.setFont(mainfont2);
		cute.setFont(mainfont);
		cool.setFont(mainfont);
		passion.setFont(mainfont);
		typegacha.setFont(mainfont);
		alltype.setFont(mainfont);
		
		gachago.addActionListener(new gachaaction());
		yunchago.addActionListener(new gachaaction());
		yungumgo.addActionListener(new gachaaction());
		searchbtn.addActionListener(new gachaaction());
		exit.addActionListener(new gachaaction());
		limited.addItemListener(new limitedconfigbutton());
		
		result.setEditable(false);
		
		tab.setFont(mainfont);
		a.add(tab,BorderLayout.CENTER);
		
		setSize(500,310);
		setVisible(true);
		setResizable(false);
	}
	
	public class gachaaction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String menu = e.getActionCommand();
			switch(menu){
			case"단챠":{
				resulttemp.clear();
				result.setText("");
				user.jewel=-250;
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
				
				break;}
			case"연챠":{
				resulttemp.clear();
				result.setText("");
				user.jewel=-2500;
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
				break;}
			case"연금단챠":{
				resulttemp.clear();
				result.setText("");
				user.jewel=-60;
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
				break;}
			case"검색":{
				int count=0;
				if(resulttemp.isEmpty()){}else{
				String searchtext = searchtable.getText();
				String searchresult = "";
				StringBuffer searchbuffer = new StringBuffer(searchresult);
				for(int i=0;i<resulttemp.size();i++){
					if(resulttemp.get(i).name.contains(searchtext)){
						count++;
						searchbuffer.append(resulttemp.get(i).Valueof()+"\n");
					}String countshow = "검색 결과 "+count+"개\n";
					searchresult = countshow+searchbuffer.toString();
				}if(count==0){JOptionPane.showMessageDialog(a,"검색 결과가 없습니다.","검색 결과",JOptionPane.INFORMATION_MESSAGE);}else{
				JOptionPane.showMessageDialog(a,searchresult,"검색 결과",JOptionPane.INFORMATION_MESSAGE);
				}break;}break;}
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
	
	public static void main(String[] args){
		
		new main();
	}
}
