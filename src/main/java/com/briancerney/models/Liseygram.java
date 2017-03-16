package com.briancerney.models;

import java.util.ArrayList;
import java.util.List;

public class Liseygram {
	private String originalSentence;
	private String encodedSentence;
	private List<String> encodedList;
	private List<String> decodedList;
	
	public Liseygram() {
		
	}
	
	public void setUpGram() {
		setEncodedSentence();
		setEncodedList();
		setDecodedList();
	}
	
	public void setEncodedList() {
		String[] encodedSplitArray = getEncodedSentence().split("");
		List<String> encodedList = new ArrayList<String>();
		
		for (int i=0; i < encodedSplitArray.length; i++) {
			encodedList.add(encodedSplitArray[i]);
		}
		this.encodedList = encodedList;
	}
	
	public void setDecodedList() {
		List<String> decodedList = new ArrayList<String>();
		
		for (int i=0; i < getEncodedList().size(); i++) {
			decodedList.add(" ");
		}
		this.decodedList = decodedList;
	}
	
	public List<String> getDecodedList() {
		return this.decodedList;
	}
	
	public List<String> getEncodedList() {
		return this.encodedList;
	}
	
	public void setOriginalSentence(String sentence) {
		this.originalSentence = sentence;
	}
	
	public String getOriginalSentence() {
		return originalSentence;
	}
	
	private void setEncodedSentence() {
		String originalSentence = this.getOriginalSentence(),
				alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
				alphabetOffsetBy13 = "NOPQRSTUVWXYZABCDEFGHIJKLM",
				encodedSentence = "";
        
        for (int i = 0; i < originalSentence.length(); i++) {
            int nextCharIndex = alphabet.indexOf(originalSentence.charAt(i));
            if (nextCharIndex > -1) {
                encodedSentence += alphabetOffsetBy13.charAt(nextCharIndex);
            }
            else {
                encodedSentence += originalSentence.charAt(i);
            }
        }
        this.encodedSentence = encodedSentence;
	}
	
	public String getEncodedSentence() {
		return encodedSentence;
	}
	
	public void guessLetter(String from, String to) {
        
        for (int i = 0; i < this.decodedList.size(); i++) {
            if (this.encodedList.get(i).equals(from)) {
                this.decodedList.set(i, to);
            }
        }
    }
}
