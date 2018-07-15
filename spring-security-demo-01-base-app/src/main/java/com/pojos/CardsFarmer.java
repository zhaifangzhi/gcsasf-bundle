package com.pojos;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CardsFarmer {
	private CurrentGamesFarming cgf;

	public CurrentGamesFarming getCgf() {
		return cgf;
	}

	public void setCgf(CurrentGamesFarming cgf) {
		this.cgf = cgf;
	}

}
