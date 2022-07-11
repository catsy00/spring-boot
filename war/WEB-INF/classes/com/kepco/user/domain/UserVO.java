package com.kepco.user.domain;

import java.util.Date;


public class UserVO {
	
	private int IDX;
	
	private String USER_ID;
    private String EMAIL;
    private String USER_NM;
    private String PASSWORD;
    private String POWER_BIZP_CD;
    
	
	public String getUSER_NM() {
		return USER_NM;
	}
	public void setUSER_NM(String uSER_NM) {
		USER_NM = uSER_NM;
	}
	private int GRADE;
    private Date REGDATE;
    
    public boolean matchPassword(String password) {
    	return this.PASSWORD.equals(password);
    }
   
	public String getPOWER_BIZP_CD() {
		return POWER_BIZP_CD;
	}
	public void setPOWER_BIZP_CD(String pOWER_BIZP_CD) {
		POWER_BIZP_CD = pOWER_BIZP_CD;
	}
	public int getIDX() {
		return IDX;
	}
	public void setIDX(int iDX) {
		IDX = iDX;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public int getGRADE() {
		return GRADE;
	}
	public void setGRADE(int gRADE) {
		GRADE = gRADE;
	}
	public Date getREGDATE() {
		return REGDATE;
	}
	public void setREGDATE(Date rEGDATE) {
		REGDATE = rEGDATE;
	}

}