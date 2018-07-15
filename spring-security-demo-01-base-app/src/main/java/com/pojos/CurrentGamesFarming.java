package com.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CurrentGamesFarming {
	private String GameName;
    private long CardsRemaining;
	public String getGameName() {
		return GameName;
	}
	public void setGameName(String gameName) {
		GameName = gameName;
	}
	public long getCardsRemaining() {
		return CardsRemaining;
	}
	public void setCardsRemaining(long cardsRemaining) {
		CardsRemaining = cardsRemaining;
	}    
}
