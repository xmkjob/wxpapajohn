package com.papa.wx.web.util;

import java.util.Random;



public class RandomGenerate {
	
	public static String generateBonusCode(){
		
		Random random = new Random();
		
		String verCode = "";
		
		for(int i=0; i<10; i++){
			verCode += random.nextInt(i+1);
		}
		

		return verCode;
	}

}
