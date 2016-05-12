package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import Database.*;
import GachaChargeMenu.*;
import Menu.*;

public class main extends JFrame {
	
	JPanel gacha = new JPanel();
	JPanel money = new JPanel();
	JPanel info = new JPanel();
	JPanel titlebar = new JPanel();
	
	JRadioButton limited = new JRadioButton("ÇÑÁ¤ Ä«µå");
	
	Gacha g = new Gacha();
	
	JTextArea result = new JTextArea(30,10);
	
	JButton exit = new JButton("Á¾·á");
	User user = new User();
	Container a = getContentPane();
	main(){
		
		Font mainfont = new Font("¸¼Àº °íµñ",0,15);
		setTitle("µ¥·¹½ºÅ× °¡Ã­ ½Ã¹Ä·¹ÀÌÅÍ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel Title = new JLabel (" µ¥·¹½ºÅ× °¡Ã­ ½Ã¹Ä·¹ÀÌÅÍ v2.0 beta1");
		titlebar.setLayout(new BorderLayout(50,50));
		titlebar.add(Title,BorderLayout.WEST);
		titlebar.add(exit,BorderLayout.EAST);
		Title.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,18));
		a.setLayout(new BorderLayout(5,5));
		a.add(titlebar,BorderLayout.NORTH);
		exit.setFont(mainfont);

		JTabbedPane tab = new JTabbedPane();
		tab.add(money,"°ú±Ý");
		tab.add(gacha,"°¡Ã­");
		tab.add(info,"Á¤º¸");
		
		String jewel ="Áê¿¤ : ";
		JLabel jewelstat = new JLabel(jewel+user.jewel);
		
		money.setLayout(null);
		gacha.setLayout(null);
		info.setLayout(null);
		
		//°¡Ã­ ¸Þ´º Ç×¸ñ
		JButton gachago = new JButton("´ÜÃ­");
		JButton yunchago = new JButton("¿¬Ã­");
		JButton yungumgo = new JButton("¿¬±Ý´ÜÃ­");
		
		JButton searchbtn = new JButton("°Ë»ö");
	    JScrollPane scrollPane = new JScrollPane(result);
	    JTextField search = new JTextField(20);
		
		gacha.setLayout(null);
		gacha.add(gachago);
		gacha.add(yunchago);
		gacha.add(jewelstat);
		gacha.add(yungumgo);
		gacha.add(scrollPane);
		gacha.add(search);
		gacha.add(searchbtn);
		gacha.add(limited);
		
		gachago.setSize(110,30);
		yunchago.setSize(110,30);
		yungumgo.setSize(110,30);
		jewelstat.setSize(110,20);
		scrollPane.setSize(365,140);
		search.setSize(300,20);
		searchbtn.setSize(65,20);
		limited.setSize(110,20);
		
		gachago.setLocation(5,5);
		yunchago.setLocation(5,40);
		yungumgo.setLocation(5,75);
		jewelstat.setLocation(5,115);
		scrollPane.setLocation(120,5);
		search.setLocation(120,150);
		searchbtn.setLocation(420,150);
		limited.setLocation(5,140);
		
		gachago.setFont(mainfont);
		yunchago.setFont(mainfont);
		yungumgo.setFont(mainfont);
		jewelstat.setFont(mainfont);
		scrollPane.setFont(mainfont);
		search.setFont(mainfont);
		searchbtn.setFont(mainfont);
		limited.setFont(mainfont);
		
		gachago.addActionListener(new gachaaction());
		yunchago.addActionListener(new gachaaction());
		yungumgo.addActionListener(new gachaaction());
		searchbtn.addActionListener(new gachaaction());
		exit.addActionListener(new gachaaction());
		
		result.setEditable(false);
		
		tab.setFont(mainfont);
		a.add(tab,BorderLayout.CENTER);
		
		setSize(500,270);
		setVisible(true);
		setResizable(false);
	}
	
	public class gachaaction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String menu = e.getActionCommand();
			switch(menu){
			case"´ÜÃ­":{
				user.jewel=-250;
				result.setText("°¡Ã­ °á°ú\n");
				StringBuffer gachatext = new StringBuffer();
				gachatext.append(g.ReturnToGUILimited(user, 0).Valueof()+"\n");
				String gacharesult=gachatext.toString();
				result.setText(result.getText()+gacharesult);
				break;}
			case"¿¬Ã­":{
				user.jewel=-250;
				result.setText("°¡Ã­ °á°ú\n");
				StringBuffer gachatext = new StringBuffer();
				for(int i=0; i<9; i++){
				gachatext.append(g.ReturnToGUILimited(user, 0).Valueof()+"\n");
				}gachatext.append(g.ReturnToGUILimited(user, 1).Valueof());
				String gacharesult=gachatext.toString();
				result.setText(result.getText()+gacharesult);
				break;}
			case"¿¬±Ý´ÜÃ­":{
				user.jewel=-60;
				result.setText("°¡Ã­ °á°ú\n");
				StringBuffer gachatext = new StringBuffer();
				gachatext.append(g.ReturnToGUILimited(user, 0).Valueof()+"\n");
				String gacharesult=gachatext.toString();
				result.setText(result.getText()+gacharesult);
				break;}
			case"°Ë»ö":{break;}
			case"Á¾·á":{int result =JOptionPane.showConfirmDialog(a, "Á¾·áÇÏ½Ã°Ú½À´Ï±î?","Á¾·á",JOptionPane.YES_OPTION);
			if(result ==JOptionPane.YES_OPTION){
			System.exit(0);}
			}}
		}
	}
	
	public static void main(String[] args){
		new main();
	}
}
