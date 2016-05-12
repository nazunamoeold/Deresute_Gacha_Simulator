package Menu;

import java.util.Scanner;

import Database.Card;
import GachaChargeMenu.ChargeJewel;
import GachaChargeMenu.ChargeYen;
import GachaChargeMenu.Gacha;
public class MainMenu {

	public static void mainmenu(User user) {
//		user.limited=true;
		if(user.limited){user.limit="yes";}else if(!user.limited){user.limit="no";}
		do{
    		System.out.println();
    		System.out.println("          Main Menu           ");
    		System.out.println("과금 메뉴로 이동 : M");
    		System.out.println("쥬엘 충전 : C");
    		
   			System.out.println("한정 가챠 아이돌 드랍 여부 : "+user.limit+" 조정 : L");
   			System.out.println("아이돌 검색 : Z               ");
    		System.out.println("가챠 메뉴로 이동 : G                 ");
    		System.out.println("가챠 확률 조정 : J                 ");
    		System.out.println("프로듀서 정보 확인 : P                ");
    		System.out.println("소유중인 카드 확인 : Q                ");
    		System.out.println("선호 아이돌 설정 : D                ");
    		System.out.println("프로듀서 정보 재입력 : R               ");
    		System.out.println("초기화 메뉴 : H                    ");
    		System.out.println("제작자 홈페이지 방문하기  : B            ");
    		System.out.println("종료하기  : F            ");
    		System.out.println();
    		char choose = 0;
    		System.out.print("하실 일을 선택하세요 >> ");
    		Scanner scanner = new Scanner(System.in);
    		choose=scanner.next().charAt(0);
    		
    		Gacha gacha = new Gacha();
    		Card Card = new Card();
    		
    		switch(choose){

    		
    		//-------------------------------------------------------------------------
    		

    		case 'M': case'm':{
    			ChargeYen yen = new ChargeYen();
    			yen.yenchargemenu(user);
    			continue;
    		}    		
    		
    		
    		case 'C': case'c':{
    			ChargeJewel jewel = new ChargeJewel();
    			jewel.chargemenu(user);
    			gacha.dialogshow();
    			continue;
    			}

    		//-------------------------------------------------------------------------
    		
    		case 'L': case'l':{
    			user.limited=!user.limited;
    			System.out.println("\t");
    			if(user.limited){user.limit="yes";}else if(!user.limited){user.limit="no";}
    			System.out.println("한정 가챠 아이돌 드랍 여부 : "+user.limit);
    			gacha.dialogshow();
    			continue;
    		}
    		
    		case 'G': case'g':{
    			gacha.gachamenu(user);
    			continue;
    			}
    		
    		case'z': case'Z':{Card.SearchIdol(user);user.dialogshow();continue;}
    		
	    	case 'J': case'j':{
    			gacha.Probability(user);
    			continue;
	    	}
    		//-------------------------------------------------------------------------


	    	case 'P': case'p':{
	    		user.UserInfo(user);
	    		user.dialogshow();
	    		continue;
	    	    }
    		
	    	case 'H': case'h':{
	    		user.thingreset(user);
	    		user.dialogshow();
    			continue;
    			}
	    	
	    	case 'R': case'r':{
    			user.reinput(user);
    			gacha.yunchaone(user);
    			continue;
	    	    }
	    	
	    	case 'Q':case'q':{user.CardShow(user);continue;}
    		/*
    		 * 0:쥬엘 초기화
    		 * 1:기프트카드 초기화
    		 * 2:돈 초기화
    		 * 3:소지 카드 초기화
    		 */
    		//-------------------------------------------------------------------------
	    	
	   
	    	case 'F': case'f':{
	    		user.finalresult(user);
	    		user.finalquestion(user);
	    		scanner.close();
	    		continue;
	    	    }
	    	
	    	case'B': case'b':{
	    		MainWindow m = new MainWindow();
	    		m.openBrower("https://aoskp.tistory.com");
	    		continue;
	    	}
	    	
	    	case'D':case'd':{Card.FCardSelect(user);continue;}
//	    	
//	    	case 'i':{gacha.InfiniteGacha(user);continue;}
	    	
		    default:{
			    System.out.println("잘못 입력하셨습니다."); continue;}
		        }
    		
		}while(true);
		
		
	}
}

