package Gacha;

import java.util.ArrayList;
import java.util.Calendar;

import Database.Card;
import Menu.User;

import java.io.*;
 
public class TXTSave {
	
    public static void GachaResultSave(ArrayList<Card> tempgacha,int i,int ssr, int sr, int r, int limitedssr, int limitedsr)
    {
    	Calendar cal = Calendar.getInstance();
    	String dateString;
        dateString = String.format("%02d-%02d-%02d", cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE) + 1, cal.get(Calendar.SECOND));
    	
        try
        {
        	
        	FileWriter fw = new FileWriter("가챠결과 "+dateString+".txt");
            BufferedWriter bw = new BufferedWriter(fw);
			bw.write("뽑은 카드");
            bw.newLine();
            for(int k=0; k<i; k++){
        		bw.write(tempgacha.get(k).Valueof());
                bw.newLine();
            }
            bw.newLine();
			bw.write("결과 발표");
            bw.newLine();
			bw.write("SSR : "+ssr);
            bw.newLine();
			bw.write("SR : "+sr);
            bw.newLine();
			bw.write("R : "+r);
            bw.newLine();
			bw.write("한정 SSR : "+limitedssr);
            bw.newLine();
			bw.write("한정 SR : "+limitedsr);
            bw.newLine();
			bw.newLine();
			bw.newLine();
			bw.newLine();
			if(ssr>=1){bw.write("SSR을 "+ssr+"장 뽑으셨습니다. 축하드립니다!");}
			if(limitedssr>=1){bw.write("한정 SSR을 "+limitedssr+"장 뽑으셨습니다. 축하드립니다!");}
            bw.close();
        }
        catch (IOException e)
        {
            System.err.println(e); 
            System.exit(1);
        }
    }
    
    public static void UserCardSave(User user){

        try
        {
    	Calendar cal = Calendar.getInstance();
    	String dateString;
        dateString = String.format("%02d-%02d-%02d", cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE) + 1, cal.get(Calendar.SECOND));
    	FileWriter fw = new FileWriter("소지카드 "+dateString+".txt");
        BufferedWriter bw = new BufferedWriter(fw);
    	bw.write("소지 카드 수");
    	bw.newLine();
    	bw.write("SSR : "+user.SSRNumber);
    	bw.newLine();
    	bw.write("\t");
    	bw.newLine();
        for (int i = 0; i<user.SSR.size(); i++) {
        	bw.write("SSR : " + user.SSR.get(i).Valueof());
            bw.newLine();
        }
        bw.write("\t");
        bw.newLine();
        bw.write("SR : "+user.SRNumber);
        bw.newLine();
        bw.write("\t");
        bw.newLine();
        for (int i = 0; i<user.SR.size(); i++) {
        	bw.write("SR : " + user.SR.get(i).Valueof());
            bw.newLine();
        }
        bw.write("\t");
        bw.newLine();
        bw.write("R : "+user.RNumber);
        bw.newLine();
        bw.write("\t");
        bw.newLine();
        for (int i = 0; i<user.R.size(); i++) {
        	bw.write("R : " + user.R.get(i).Valueof());
            bw.newLine();
        }
        bw.write("\t");
        bw.newLine();
        bw.write("한정SSR : "+user.LSSRNumber);
        bw.newLine();
        bw.write("\t");
        bw.newLine();
        for (int i = 0; i<user.LSSR.size(); i++) {
        	bw.write("LSSR : " + user.LSSR.get(i).Valueof());
            bw.newLine();
        }
        bw.write("\t");
        bw.newLine();
        bw.write("한정SR : "+user.LSRNumber);
        bw.newLine();
        bw.write("\t");
        bw.newLine();
        for (int i = 0; i<user.LSR.size(); i++) {
        	bw.write("LSR : " + user.LSR.get(i).Valueof());
            bw.newLine();
        }
        bw.close();
        }
        catch (IOException e)
        {
            System.err.println(e); 
            System.exit(1);
        }
    }
}