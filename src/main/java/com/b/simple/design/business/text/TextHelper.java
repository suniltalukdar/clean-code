package com.b.simple.design.business.text;

public class TextHelper {

	public String swapLastTwoCharacters(String str) {
		
		if(str.length()>=2) {
			int lastIndex = str.length()-1;
			int index = lastIndex-1;
			return swap(str, index, lastIndex);
		}
		
		return str;
	}
	//After stashing
	private String swap(String str, int firstIndex, int secondIndex) {
		char[] temp = str.toCharArray();
		
		char var = temp[secondIndex];
		temp[secondIndex] = temp[firstIndex];
		temp[firstIndex] = var;
		
		return String.valueOf(temp);
	}
	
	public String truncateAInFirst2Positions(String str) {
		return null;
	}
}
