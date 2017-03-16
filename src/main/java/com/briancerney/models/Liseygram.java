package com.briancerney.models;

import java.util.List;

public class Liseygram {
	private String originalSentence;
	private String encodedSentence;
	private List<String> encodedList;
	private List<String> decodedList;
	
	public Liseygram() {

	}
	
	public void setOriginalSentence(String sentence) {
		this.originalSentence = sentence;
	}
	
	public String getOriginalSentence() {
		return originalSentence;
	}

}
