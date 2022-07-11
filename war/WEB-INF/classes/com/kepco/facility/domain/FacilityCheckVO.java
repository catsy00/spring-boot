package com.kepco.facility.domain;

public class FacilityCheckVO {
	
	private int IDX;
	
	private int ACHECK;
	private int BCHECK;
	private int CCHECK;
	private int CCHECK2;
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
	private String fcl_nm;
	private int vdoFileCHECK;
	private String bVdoFileYn;
	private String vdo_fcl_nm;
	

	
	public int getCCHECK2() {
		return CCHECK2;
	}

	public void setCCHECK2(int cCHECK2) {
		CCHECK2 = cCHECK2;
	}

	public String getVdo_fcl_nm() {
		return vdo_fcl_nm;
	}

	public void setVdo_fcl_nm(String vdo_fcl_nm) {
		this.vdo_fcl_nm = vdo_fcl_nm;
	}

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


	public String getFcl_nm() {
		return fcl_nm;
	}

	public void setFcl_nm(String fcl_nm) {
		this.fcl_nm = fcl_nm;
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
	//ACHECK, BCHECK, CCHECK, DCHECK, ECHECK

	@Override
	public String toString() {
		return "FacilityCheckVO [IDX=" + IDX + ", ACHECK=" + ACHECK + ", BCHECK=" + BCHECK + ", CCHECK=" + CCHECK
				+ ", DCHECK=" + DCHECK + ", ECHECK=" + ECHECK + ", PSSNM=" + PSSNM + ", aCpuUseQnt=" + aCpuUseQnt
				+ ", aRamUsrQnt=" + aRamUsrQnt + ", aHddUseQnt=" + aHddUseQnt + ", bCpuUseQnt=" + bCpuUseQnt
				+ ", bRamUsrQnt=" + bRamUsrQnt + ", bHddUseQnt=" + bHddUseQnt + "]";
	}
	
    
    
}