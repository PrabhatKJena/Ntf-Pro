package com.ericsson.ntf.ref.data.tblentities;

public class NtfUnitOfMeasurement extends NtfTableEntityBase {
	private String uom;
	private String measure;
	private long scaleFactorNum;
	private long scaleFactorDenoExp;
	private boolean baseUnitFlag;
	private String symbol;

	public NtfUnitOfMeasurement(){

	}
	public NtfUnitOfMeasurement(String uom, String measure, long scaleFactorNum, long scaleFactorDenoExp,
                                boolean baseUnitFlag, String symbol, String description) {
		super();
		this.uom = uom;
		this.measure = measure;
		this.scaleFactorNum = scaleFactorNum;
		this.scaleFactorDenoExp = scaleFactorDenoExp;
		this.baseUnitFlag = baseUnitFlag;
		this.symbol = symbol;
		super.setDescription(description);
	}

	public String getUom() {
		return uom;
	}
	
	public void setUom(String uom) {
		this.uom = uom;
	}
	
	public String getMeasure() {
		return measure;
	}
	
	public void setMeasure(String measure) {
		this.measure = measure;
	}
	
	public long getScaleFactorNum() {
		return scaleFactorNum;
	}
	
	public void setScaleFactorNum(long scaleFactorNum) {
		this.scaleFactorNum = scaleFactorNum;
	}
	
	public long getScaleFactorDenoExp() {
		return scaleFactorDenoExp;
	}

	public void setScaleFactorDenoExp(long scaleFactorDenoExp) {
		this.scaleFactorDenoExp = scaleFactorDenoExp;
	}
	
	public boolean isBaseUnitFlag() {
		return baseUnitFlag;
	}
	
	public void setBaseUnitFlag(boolean baseUnitFlag) {
		this.baseUnitFlag = baseUnitFlag;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {
		return "NtfUnitOfMeasurement [uom=" + uom + ", measure=" + measure + ", scaleFactorNum=" + scaleFactorNum
				+ ", scaleFactorDenoExp=" + scaleFactorDenoExp + ", baseUnitFlag=" + baseUnitFlag + ", symbol=" + symbol
				+ ", description=" + description + "]";
	}

}
