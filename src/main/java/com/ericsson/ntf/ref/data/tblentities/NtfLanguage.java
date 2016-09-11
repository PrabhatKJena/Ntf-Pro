package com.ericsson.ntf.ref.data.tblentities;

public class NtfLanguage extends NtfTableEntityBase {
	private String alpha2Code;
	private String name;

	public NtfLanguage(){

	}
	public NtfLanguage(String alpha2Code, String name, String description) {
		super();
		this.alpha2Code = alpha2Code;
		this.name = name;
		super.setDescription(description);
	}

	public String getAlpha2Code() {
		return alpha2Code;
	}

	public void setAlpha2Code(String alpha2Code) {
		this.alpha2Code = alpha2Code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	@Override
	public String toString() {
		return "NtfLanguage [alpha2Code=" + alpha2Code + ", name=" + name + ", description=" + description + "]";
	}

}
