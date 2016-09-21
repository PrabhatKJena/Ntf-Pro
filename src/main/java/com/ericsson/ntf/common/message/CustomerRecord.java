package com.ericsson.ntf.common.message;

//import static com.ericsson.ntf.common.util.NtfUtils.safeEquals;

/**
 * This class holds the customer record data that is used by Notif
 *
 * @author eashapr
 *
 */
public class CustomerRecord {
    private String language;
    private Boolean notifyFlag;
    private String startTime;
    private String endTime;
    private String channel;
    private String email;
    private String timeZone;
    private String msisdn;
    private String partyNameATitle;
    private String partyNameFamPrefix;
    private String partyNameFamily;
    private String partyNameFormOfAddress;
    private String partyNameFormatted;
    private String partyNameGiven;
    private String partyNamePrefGiven;
    private String partyNameQualifications;
    private String partyNameMiddle;

    public String getLanguage() {
	return language;
    }

    public void setLanguage(String language) {
	this.language = language;
    }

    public Boolean getNotifyFlag() {
	return notifyFlag;
    }

    public void setNotifyFlag(Boolean notifyFlag) {
	this.notifyFlag = notifyFlag;
    }

    public String getStartTime() {
	return startTime;
    }

    public void setStartTime(String startTime) {
	this.startTime = startTime;
    }

    public String getEndTime() {
	return endTime;
    }

    public void setEndTime(String endTime) {
	this.endTime = endTime;
    }

    public String getChannel() {
	return channel;
    }

    public void setChannel(String channel) {
	this.channel = channel;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getTimeZone() {
	return timeZone;
    }

    public void setTimeZone(String timeZone) {
	this.timeZone = timeZone;
    }

    public String getMsisdn() {
	return msisdn;
    }

    public void setMsisdn(String msisdn) {
	this.msisdn = msisdn;
    }

    public String getPartyNameATitle() {
	return partyNameATitle;
    }

    public void setPartyNameATitle(String partyNameATitle) {
	this.partyNameATitle = partyNameATitle;
    }

    public String getPartyNameFamPrefix() {
	return partyNameFamPrefix;
    }

    public void setPartyNameFamPrefix(String partyNameFamPrefix) {
	this.partyNameFamPrefix = partyNameFamPrefix;
    }

    public String getPartyNameFamily() {
	return partyNameFamily;
    }

    public void setPartyNameFamily(String partyNameFamily) {
	this.partyNameFamily = partyNameFamily;
    }

    public String getPartyNameFormOfAddress() {
	return partyNameFormOfAddress;
    }

    public void setPartyNameFormOfAddress(String partyNameFormOfAddress) {
	this.partyNameFormOfAddress = partyNameFormOfAddress;
    }

    public String getPartyNameFormatted() {
	return partyNameFormatted;
    }

    public void setPartyNameFormatted(String partyNameFormatted) {
	this.partyNameFormatted = partyNameFormatted;
    }

    public String getPartyNameGiven() {
	return partyNameGiven;
    }

    public void setPartyNameGiven(String partyNameGiven) {
	this.partyNameGiven = partyNameGiven;
    }

    public String getPartyNamePrefGiven() {
	return partyNamePrefGiven;
    }

    public void setPartyNamePrefGiven(String partyNamePrefGiven) {
	this.partyNamePrefGiven = partyNamePrefGiven;
    }

    public String getPartyNameQualifications() {
	return partyNameQualifications;
    }

    public void setPartyNameQualifications(String partyNameQualifications) {
	this.partyNameQualifications = partyNameQualifications;
    }

    public String getPartyNameMiddle() {
	return partyNameMiddle;
    }

    public void setPartyNameMiddle(String partyNameMiddle) {
	this.partyNameMiddle = partyNameMiddle;
    }

    @Override
    public String toString() {
	StringBuffer buffer = new StringBuffer();
	buffer.append("{");
	buffer.append("\"language\": \"").append(language).append("\", ");
	buffer.append("\"notifyFlag\": ").append(notifyFlag).append(", ");
	buffer.append("\"startTime\": \"").append(startTime).append("\", ");
	buffer.append("\"endTime\": \"").append(endTime).append("\", ");
	buffer.append("\"channel\": \"").append(channel).append("\", ");
	buffer.append("\"email\": \"").append(email).append("\", ");
	buffer.append("\"timeZone\": \"").append(timeZone).append("\", ");
	buffer.append("\"MSISDN\": \"").append(msisdn).append("\", ");
	buffer.append("\"customerName\": \"").append(partyNamePrefGiven);
	buffer.append("\"}");
	return buffer.toString();

    }

    @Override
    public boolean equals(Object thatObj) {
	if (thatObj == this) {
	    return true; // identical object
	}
	if (thatObj == null || this.getClass() != thatObj.getClass()) {
	    return false; // not same schema
	}
	CustomerRecord that = (CustomerRecord) thatObj;
	/*return safeEquals(notifyFlag, that.notifyFlag) && safeEquals(language, that.language)
		&& safeEquals(startTime, that.startTime) && safeEquals(channel, that.channel)
		&& safeEquals(email, that.email) && safeEquals(endTime, that.endTime)
		&& safeEquals(timeZone, that.timeZone) && safeEquals(msisdn, that.msisdn)
		&& safeEquals(partyNameATitle, that.partyNameATitle)
		&& safeEquals(partyNameFamPrefix, that.partyNameFamPrefix)
		&& safeEquals(partyNameFamily, that.partyNameFamily)
		&& safeEquals(partyNameFormOfAddress, that.partyNameFormOfAddress)
		&& safeEquals(partyNameFormatted, that.partyNameFormatted)
		&& safeEquals(partyNameGiven, that.partyNameGiven)
		&& safeEquals(partyNamePrefGiven, that.partyNamePrefGiven)
		&& safeEquals(partyNameQualifications, that.partyNameQualifications)
		&& safeEquals(partyNameMiddle, that.partyNameMiddle);*/
	return true;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((channel == null) ? 0 : channel.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
	result = prime * result + ((language == null) ? 0 : language.hashCode());
	result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
	result = prime * result + ((notifyFlag == null) ? 0 : notifyFlag.hashCode());
	result = prime * result + ((partyNameATitle == null) ? 0 : partyNameATitle.hashCode());
	result = prime * result + ((partyNameFamPrefix == null) ? 0 : partyNameFamPrefix.hashCode());
	result = prime * result + ((partyNameFamily == null) ? 0 : partyNameFamily.hashCode());
	result = prime * result + ((partyNameFormOfAddress == null) ? 0 : partyNameFormOfAddress.hashCode());
	result = prime * result + ((partyNameFormatted == null) ? 0 : partyNameFormatted.hashCode());
	result = prime * result + ((partyNameGiven == null) ? 0 : partyNameGiven.hashCode());
	result = prime * result + ((partyNameMiddle == null) ? 0 : partyNameMiddle.hashCode());
	result = prime * result + ((partyNamePrefGiven == null) ? 0 : partyNamePrefGiven.hashCode());
	result = prime * result + ((partyNameQualifications == null) ? 0 : partyNameQualifications.hashCode());
	result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
	result = prime * result + ((timeZone == null) ? 0 : timeZone.hashCode());
	return result;
    }

}
