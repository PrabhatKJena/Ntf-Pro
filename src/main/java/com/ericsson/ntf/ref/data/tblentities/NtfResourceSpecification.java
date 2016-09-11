package com.ericsson.ntf.ref.data.tblentities;

public class NtfResourceSpecification {
	private String key;
	private String id;
	
	public String getKey() {
		return this.key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String toString() {
		return "NtfResourceSpecification [key=" + key + ", id=" + id  + "]";
	}
}
