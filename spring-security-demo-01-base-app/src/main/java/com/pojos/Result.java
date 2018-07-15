package com.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.api.client.util.DateTime;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Result {
    private long MemoryUsage;
    private DateTime ProcessStartTime;
    private String BotName;
    private CardsFarmer cf;
    private boolean IsPlayingPossible;
    private long SteamID;
	public String getBotName() {
		return BotName;
	}
	public void setBotName(String botName) {
		BotName = botName;
	}
	public CardsFarmer getCf() {
		return cf;
	}
	public void setCf(CardsFarmer cf) {
		this.cf = cf;
	}
	public boolean isIsPlayingPossible() {
		return IsPlayingPossible;
	}
	public void setIsPlayingPossible(boolean isPlayingPossible) {
		IsPlayingPossible = isPlayingPossible;
	}
	public long getSteamID() {
		return SteamID;
	}
	public void setSteamID(long steamID) {
		SteamID = steamID;
	}
	public long getMemoryUsage() {
		return MemoryUsage;
	}
	public void setMemoryUsage(long memoryUsage) {
		MemoryUsage = memoryUsage;
	}
	public DateTime getProcessStartTime() {
		return ProcessStartTime;
	}
	public void setProcessStartTime(DateTime processStartTime) {
		ProcessStartTime = processStartTime;
	}
}
