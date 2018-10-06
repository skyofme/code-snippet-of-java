package com.lambda;

public class Test2 {

	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer();
		int value = 18 & 0x07;
		System.out.println(value);
		value = (18 >>> 3) & 0x07;  
		System.out.println(value);
	}
	
}
