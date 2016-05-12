package GUI;

import java.awt.*;
import javax.swing.*;

public class main extends JFrame {
	
	JPanel gacha = new JPanel();
	JPanel money = new JPanel();
	JPanel info = new JPanel();
	JPanel titlebar = new JPanel();
	
	JButton exit = new JButton("Á¾·á");

	
	Container a = getContentPane();
	main(){

		setTitle("µ¥·¹½ºÅ× °¡Ã­ ½Ã¹Ä·¹ÀÌÅÍ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel Title = new JLabel ("µ¥·¹½ºÅ× °¡Ã­ ½Ã¹Ä·¹ÀÌÅÍ v2.0 beta1");
		titlebar.setLayout(new BorderLayout(50,50));
		titlebar.add(Title,BorderLayout.WEST);
		titlebar.add(exit,BorderLayout.EAST);
		Title.setFont(new Font("¸¼Àº °íµñ",0,25));
		a.setLayout(new BorderLayout(5,5));
		a.add(titlebar,BorderLayout.NORTH);
		
		JTabbedPane tab = new JTabbedPane();
		tab.add(money,"°ú±Ý");
		tab.add(gacha,"°¡Ã­");
		tab.add(info,"Á¤º¸");
		
		money.setLayout(null);
		gacha.setLayout(null);
		info.setLayout(null);
		
		JLabel gachatitle = new JLabel("°¡Ã­ ¸Þ´º");
		JLabel moneytitle = new JLabel("°ú±Ý ¸Þ´º");
		JLabel infotitle = new JLabel("Á¤º¸ ¸Þ´º");
		
		Font title = new Font("¸¼Àº °íµñ",0,25);
		gachatitle.setFont(title);
		moneytitle.setFont(title);
		infotitle.setFont(title);
		
		gacha.add(gachatitle);
		gachatitle.setSize(110,30);
		gachatitle.setLocation(345,10);
		
		money.add(moneytitle);
		moneytitle.setSize(110,30);
		moneytitle.setLocation(345,10);
		
		info.add(infotitle);
		infotitle.setSize(110,30);
		infotitle.setLocation(345,10);
		
		tab.setFont(new Font("¸¼Àº °íµñ",0,20));
		a.add(tab,BorderLayout.CENTER);
		
		setSize(800,500);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String[] args){
		new main();
	}
}
