package com.social.sointeractive.framework.generic;

public enum PropertyFileKeys {

	BROWSER("browser"), URL("url"), USERNAME("username"), PASSWORD("password"),TIMEOUT("timeout");
	
	
	private String keys;
	private PropertyFileKeys(String keys) {
		this.keys=keys;
	}
	public String convertToString() {
		return keys.toString();
	}
}
