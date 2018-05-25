package com.javaegitimleri.app;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="personel")
public class PersonelProperties {

	
	private boolean displayOwner=false;

	public boolean isDisplayOwner() {
		return displayOwner;
	}
	
	public void setDisplayOwner(boolean displayOwner) {
		this.displayOwner = displayOwner;
	}
	
	
}
