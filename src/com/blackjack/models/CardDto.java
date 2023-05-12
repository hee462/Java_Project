package com.blackjack.models;

public class CardDto {
    private String pattern;
    private String dNum;
    
    public CardDto() {
    	super();
    }
    
    public CardDto(String pattern, String dNum) {
    	super();
    	this.pattern = pattern;
    	this.dNum = dNum;
    	
    }
    
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getDNum() {
		return dNum;
	}
	public void setDNum(String dNum) {
		this.dNum = dNum;
	}
	@Override
	public String toString() {
		return "CardDto [pattern=" + pattern + ", dNum=" + dNum + "]";
	}
    
    
}
