package Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Gacha.Gacha;
public class ProbabilityInfo extends JFrame implements userthing{
	JTextField SSRP = new JTextField(4);
	JTextField SRP = new JTextField(4);
	JTextField RP = new JTextField(4);
	JLabel prostat = new JLabel();
	Double tempR = 100-(user.tempSSR+user.tempSR);
	JComboBox prolists = new JComboBox();
	Container a = getContentPane();
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
		
		prolists = new JComboBox<Object>(prolist);
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
