package com.kepco.facility.domain;

public class FacilityVO {
	
	private int IDX;
	
	private int ACNT;
	private int BCNT;
	private int CCNT;
	private int DCNT;
	private int ECNT;
	private String PSSNM;
	public String getPSSNM() {
		return PSSNM;
	}
	public void setPSSNM(String pSSNM) {
		PSSNM = pSSNM;
	}
	public int getIDX() {
		return IDX;
	}
	public void setIDX(int iDX) {
		IDX = iDX;
	}
	public int getACNT() {
		return ACNT;
	}
	public void setACNT(int aCNT) {
		ACNT = aCNT;
	}
	public int getBCNT() {
		return BCNT;
	}
	public void setBCNT(int bCNT) {
		BCNT = bCNT;
	}
	public int getCCNT() {
		return CCNT;
	}
	public void setCCNT(int cCNT) {
		CCNT = cCNT;
	}
	public int getDCNT() {
		return DCNT;
	}
	public void setDCNT(int dCNT) {
		DCNT = dCNT;
	}
	public int getECNT() {
		return ECNT;
	}
	public void setECNT(int eCNT) {
		ECNT = eCNT;
	}
	
	@Override
	public String toString() {
		return "IDX=" + IDX + ", ACNT=" + ACNT + ", BCNT=" + BCNT + ", CCNT=" + CCNT
				+ ", DCNT=" + DCNT + ", ECNT=" + ECNT;
	}
    
    
}