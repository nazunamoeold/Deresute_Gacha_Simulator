package Menu;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MainWindow {
	public static void main(String[] args){
		System.out.println("==============================");
		System.out.println("                              ");
		System.out.println("Deresute Gacha Simulator v1.62");
		System.out.println("                       ");
		System.out.println("==============================");
		System.out.println("제작자 : nazunamoe (트위터 @nazunamoe)");
		System.out.println("버그가 발견되면 트위터 계정 @nazunamoe로 연락주세요.");
		System.out.println("==============================");
		System.out.println("                       ");
		User user = new User();
	    Scanner scanner = new Scanner(System.in);
//	    System.out.println("프로듀서 이름을 한글로 할 수 있습니다.");
	    System.out.print("프로듀서 이름을 입력하세요 >> ");
	    user.name=scanner.next();
	    do{System.out.print("게임 ID를 입력하세요 >> ");
		try {user.gameid = scanner.nextInt();}
		catch(InputMismatchException e) {
			System.out.println("잘못 입력하셨습니다.");
			scanner.next();continue;}
		MainMenu.mainmenu(user);}while(true);
	    
	}
	
	 public void openBrower(String url)  {
	        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
	        if( !desktop.isSupported( java.awt.Desktop.Action.BROWSE ) ) {
	            System.err.println( "Desktop doesn't support web browser action" );
	        }
	        try {
	            java.net.URI uri = new java.net.URI( url );
	            desktop.browse( uri );
	        }        
	        catch (IOException _e) {
	            System.err.println( _e.getMessage() );
	        } 
	        catch (URISyntaxException _e) {
	            System.err.println( _e.getMessage() );
	        }
	    }
	}


