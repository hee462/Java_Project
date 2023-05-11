package com.blackjack.models;

public class CardDto {
    private String pattern;
    private String denomination;
    
    public CardDto() {
    	super();
    }
    
    public CardDto(String pattern, String denomination) {
    	super();
    	this.pattern = pattern;
    	this.denomination = denomination;
    	
    }
    
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	@Override
	public String toString() {
		return "CardDto [pattern=" + pattern + ", denomination=" + denomination + "]";
	}
    
    
}
