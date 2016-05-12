package GachaChargeMenu;

import java.util.InputMismatchException;
import java.util.Scanner;
import Menu.User;
import Menu.MainMenu;

public class ChargeYen {
	Gacha gacha = new Gacha();
	 public void chargemoney(User user){
		 System.out.println();
		System.out.println("엔화로 결제합니다.");
		System.out.println();
		System.out.print("얼마를 결제하시겠습니까? ");
	    
		Scanner scanner = new Scanner(System.in);
		int yen=0;
		try {yen= scanner.nextInt();}
		catch(InputMismatchException e) {
			System.out.println("잘못 입력하셨습니다.");
			System.out.println("\t");
			scanner.next();
			MainMenu.mainmenu(user);
		}
		this.chargemoney(user, yen);
		gacha.dialogshow();
	}
	 
	void chargemoney(User user, int yen){
		System.out.println("\t");
		user.yen+=yen;
		
		System.out.println(yen+"엔을 결제하였습니다. 감사합니다.");
	}
	 
	public void giftcard(User user){
		System.out.println("기프트카드를 구입합니다.");
		System.out.println("\t");
 		System.out.println("구입할 기프트카드 선택");
 		System.out.println("A: 1500엔");
 		System.out.println("B: 3000엔");
 		System.out.println("C: 5000엔");
 		System.out.println("D: 10000엔");
		System.out.println("메인 메뉴로 : M");
 		System.out.print(">> ");
 		char choose=0;
 		Scanner scanner = new Scanner(System.in);
 		choose=scanner.next().charAt(0);
 		switch(choose){
 		case'A':case'a':{this.charge(user,1500);break;}
 		case'B':case'b':{this.charge(user,3000);break;}
 		case'C':case'c':{this.charge(user,5000);break;}
 		case'D':case'd':{this.charge(user,10000);break;}
 		case'M' : case'm':{user.dialogshow();MainMenu.mainmenu(user);break;}
 		default:{System.out.println("잘못 입력하였습니다.");break;}
 		}
	}
	
	void charge(User user, int yen){
		user.giftcard=user.giftcard+yen;
		
		System.out.println("\t");
		System.out.println(yen+"엔을 소비하여 "+yen+"엔 어치의 기프트카드를 구입하였습니다.");
	}
	
	public void giftcardtoyen (User user){
		if (user.giftcard==0){
			System.out.println("\t");
			System.out.println("기프트 카드가 없습니다.");
			gacha.dialogshow();
			MainMenu.mainmenu(user);
		}
		System.out.println("\t");
		user.yen+=user.giftcard;
		user.usedgiftcard+=user.giftcard;
		System.out.println(user.giftcard+"엔 만큼의 기프트카드가 결재되었습니다.");
		user.giftcard-=user.giftcard;
	}
	
	public void yenchargemenu(User user){
    	char temp;
    	Scanner scanner = new Scanner(System.in);
    	System.out.println();
		System.out.println("          Charge Menu         ");
    	System.out.println("어떻게 과금하시겠습니까?");
    	System.out.println();
    	System.out.println("기프트카드 구입 : G");
    	System.out.println("구입한 기프트카드 결제 : O");
    	System.out.println("엔화 결제 : E");
    	System.out.println("메인 메뉴로 : M");
    	System.out.print(">> ");
    	temp=scanner.next().charAt(0);
    	switch(temp){
    	case'G': case'g':{this.giftcard(user);break;}
    	case'O': case'o':{this.charge(user, user.giftcard);break;}
    	case'E': case'e':{this.chargemoney(user);break;}
    	case'M' : case'm':{user.dialogshow();MainMenu.mainmenu(user);break;}
    	default:{System.out.println("잘못 입력하셨습니다.");this.yenchargemenu(user);break;}
	}
	
}}
	

