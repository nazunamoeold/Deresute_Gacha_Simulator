package GachaChargeMenu;

import java.util.Scanner;
import Menu.MainMenu;
import Menu.User;
public class ChargeJewel {
	User user = new User();
	public void chargemenu(User user){
		System.out.println("");
		System.out.println("       Jewel Charge Menu      ");
		System.out.println("");
 		System.out.println("±¸ÀÔÇÒ Áê¿¤ ¼±ÅÃ");
 		System.out.println("A: Áê¿¤ 60°³ - 120¿£");
 		System.out.println("B: Áê¿¤ 360°³ - 480¿£");
 		System.out.println("C: Áê¿¤ 760°³ - 960¿£");
 		System.out.println("D: Áê¿¤ 1300°³ - 1600¿£");
 		System.out.println("E: Áê¿¤ 2650°³ - 3200¿£");
 		System.out.println("F: Áê¿¤ 4200°³ - 5000¿£");
 		System.out.println("G: Áê¿¤ 8400°³ - 9800¿£");
		System.out.println("¸ŞÀÎ ¸Ş´º·Î : M");
 		System.out.print("¼±ÅÃÇÏ¼¼¿ä >> ");
 		char choose=0;
 		Scanner scanner = new Scanner(System.in);
 		choose=scanner.next().charAt(0);
 		switch(choose){
 		case'A':case'a':{this.charge(user,60,120);break;}
 		case'B':case'b':{this.charge(user,360,480);break;}
 		case'C':case'c':{this.charge(user,760,960);break;}
 		case'D':case'd':{this.charge(user,1300,1600);break;}
 		case'E':case'e':{this.charge(user,2650,3200);break;}
 		case'F':case'f':{this.charge(user,4200,5000);break;}
 		case'G':case'g':{this.charge(user,8400,9800);break;}
 		case'M' : case'm':{user.dialogshow();MainMenu.mainmenu(user);break;}
 		default:{System.out.println("Àß¸ø ÀÔ·ÂÇÏ¿´½À´Ï´Ù.");break;}
 		
 		}
	}
	void charge(User user, int jewel, int yen){
		if(user.yen<yen){
			this.chargefail(user, jewel, yen);
		}
		else if(user.yen>=yen){
			this.chargesuccess(user, jewel, yen);
		}
	}
	void chargesuccess(User user, int jewel, int yen){
		user.yen=user.yen-yen;
		user.jewel=user.jewel+jewel;
		user.usedyen+=yen;
		System.out.println(yen+"¿£À» ¼ÒºñÇÏ¿© "+jewel+"°³ÀÇ Áê¿¤À» ±¸ÀÔÇÏ¿´½À´Ï´Ù.");
	}
	void chargefail(User user, int jewel, int yen){
		System.out.println("\t");
		System.out.println(yen-user.yen+"¿£ÀÌ ºÎÁ·ÇÏ¿© ±¸ÀÔÇÏÁö ¸øÇß½À´Ï´Ù.");
 		}
	}

