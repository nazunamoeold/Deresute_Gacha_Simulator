package GUI;

import javax.swing.JOptionPane;

public class test {

public static void main(String[] args) {
	String s;
	int i;
	for(i=0;i<100;i++){
			s = JOptionPane.showInputDialog(null,"What is your favorite fruit ?");
			try{
				if(s.equals(""))  {
					JOptionPane.showMessageDialog(null," Enter your answer !!!"," ^-^ Information^-^ ",JOptionPane.INFORMATION_MESSAGE);
					i=2;
				}
				else  {
					JOptionPane.showMessageDialog(null," s = "+s," ^-^ Information^-^ ",JOptionPane.INFORMATION_MESSAGE);
					i=100;
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Cancle answer !!!"," ^-^ Information^-^ ",JOptionPane.INFORMATION_MESSAGE);
				i=100;
			}
	}
	}
}