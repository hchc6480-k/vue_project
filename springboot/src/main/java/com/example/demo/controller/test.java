package com.example.demo.controller;

import java.math.BigDecimal;
import java.math.BigInteger;

public class test {
	public static void main(String[] args) {
		int x = 1231;
		
		String s = Integer.toString(x);
		
		int div = 1;
		String result=null;
				
		while(x / div >=10) {
			div *= 10;
		}
		
		while(x!=0) {
			int left = x / div;
			int right = x % 10;
			
			if(left != right) {
				System.out.println("불일");
				break;
			}
			
			x = (x%div)/10;
			div /= 100;
		}
		
	}
	
}
