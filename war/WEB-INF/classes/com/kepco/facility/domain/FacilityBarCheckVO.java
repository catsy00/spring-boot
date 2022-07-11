package com.kepco.facility.domain;

public class FacilityBarCheckVO {
	
	private int IDX;
	
	private int ACHECK;
	private int BCHECK;
	private int CCHECK;
	private int DCHECK;
	private int ECHECK;
	private String PSSNM;
	private int aCpuUseQnt;
	private int aRamUsrQnt;
	private int aHddUseQnt;
	private int bCpuUseQnt;
	private int bRamUsrQnt;
	private int bHddUseQnt;
	private int bHddUseQnt2;
	private int bHddUseQnt3;
	private String bVdoFileYn;
	private int vdoFileCHECK;
	
	public String getbVdoFileYn() {
		return bVdoFileYn;
	}
	public void setbVdoFileYn(String bVdoFileYn) {
		this.bVdoFileYn = bVdoFileYn;
	}
	
	
	public int getVdoFileCHECK() {
		return vdoFileCHECK;
	}
	public void setVdoFileCHECK(int vdoFileCHECK) {
		this.vdoFileCHECK = vdoFileCHECK;
	}
	public int getIDX() {
		return IDX;
	}
	public void setIDX(int iDX) {
		IDX = iDX;
	}
	public int getACHECK() {
		return ACHECK;
	}
	public void setACHECK(int aCHECK) {
		ACHECK = aCHECK;
	}
	public int getBCHECK() {
		return BCHECK;
	}
	public void setBCHECK(int bCHECK) {
		BCHECK = bCHECK;
	}
	public int getCCHECK() {
		return CCHECK;
	}
	public void setCCHECK(int cCHECK) {
		CCHECK = cCHECK;
	}
	public int getDCHECK() {
		return DCHECK;
	}
	public void setDCHECK(int dCHECK) {
		DCHECK = dCHECK;
	}
	public int getECHECK() {
		return ECHECK;
	}
	public void setECHECK(int eCHECK) {
		ECHECK = eCHECK;
	}
	public String getPSSNM() {
		return PSSNM;
	}
	public void setPSSNM(String pSSNM) {
		PSSNM = pSSNM;
	}
	public int getaCpuUseQnt() {
		return aCpuUseQnt;
	}
	public void setaCpuUseQnt(int aCpuUseQnt) {
		this.aCpuUseQnt = aCpuUseQnt;
	}
	public int getaRamUsrQnt() {
		return aRamUsrQnt;
	}
	public void setaRamUsrQnt(int aRamUsrQnt) {
		this.aRamUsrQnt = aRamUsrQnt;
	}
	public int getaHddUseQnt() {
		return aHddUseQnt;
	}
	public void setaHddUseQnt(int aHddUseQnt) {
		this.aHddUseQnt = aHddUseQnt;
	}
	public int getbCpuUseQnt() {
		return bCpuUseQnt;
	}
	public void setbCpuUseQnt(int bCpuUseQnt) {
		this.bCpuUseQnt = bCpuUseQnt;
	}
	public int getbRamUsrQnt() {
		return bRamUsrQnt;
	}
	public void setbRamUsrQnt(int bRamUsrQnt) {
		this.bRamUsrQnt = bRamUsrQnt;
	}
	public int getbHddUseQnt() {
		return bHddUseQnt;
	}
	public void setbHddUseQnt(int bHddUseQnt) {
		this.bHddUseQnt = bHddUseQnt;
	}
	
	public int getbHddUseQnt2() {
		return bHddUseQnt2;
	}
	public void setbHddUseQnt2(int bHddUseQnt2) {
		this.bHddUseQnt2 = bHddUseQnt2;
	}
	public int getbHddUseQnt3() {
		return bHddUseQnt3;
	}
	public void setbHddUseQnt3(int bHddUseQnt3) {
		this.bHddUseQnt3 = bHddUseQnt3;
	}
	@Override
	public String toString() {
		return "FacilityBarCheckVO [IDX=" + IDX + ", ACHECK=" + ACHECK + ", BCHECK=" + BCHECK + ", CCHECK=" + CCHECK
				+ ", DCHECK=" + DCHECK + ", ECHECK=" + ECHECK + ", PSSNM=" + PSSNM + ", aCpuUseQnt=" + aCpuUseQnt
				+ ", aRamUsrQnt=" + aRamUsrQnt + ", aHddUseQnt=" + aHddUseQnt + ", bCpuUseQnt=" + bCpuUseQnt
				+ ", bRamUsrQnt=" + bRamUsrQnt + ", bHddUseQnt=" + bHddUseQnt + ", bVdoFileYn=" + bVdoFileYn + "]";
	}

    
}