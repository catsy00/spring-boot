package com.kepco.facility.domain;

public class reportFacilityVO {
	
	private int IDX;
	
	//TA.upd_dt, TA.hdqr_nm, TA.pss_nm, TA.fcl_nm,TB.cpu_use_qnt,TB.ram_use_qnt,TB.hdd_use_qnt,TA.power_bizp_nm, TB.status
	private String CHK_DT;
	private String HDQR_NM;
	private String PSS_NM;
	private String fcl_NM;
	private int cpu_use_qnt;
	private int ram_use_qnt;
	private int hdd_use_qnt;
	private String power_bizp_nm;
	private String status;
	private String statusCheck;
	
	public String getPower_bizp_nm() {
		return power_bizp_nm;
	}
	public void setPower_bizp_nm(String power_bizp_nm) {
		this.power_bizp_nm = power_bizp_nm;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getIDX() {
		return IDX;
	}
	public void setIDX(int iDX) {
		IDX = iDX;
	}
	
	
	public String getStatusCheck() {
		return statusCheck;
	}
	public void setStatusCheck(String statusCheck) {
		this.statusCheck = statusCheck;
	}
	public String getCHK_DT() {
		return CHK_DT;
	}
	public void setCHK_DT(String cHK_DT) {
		CHK_DT = cHK_DT;
	}
	public String getHDQR_NM() {
		return HDQR_NM;
	}
	public void setHDQR_NM(String hDQR_NM) {
		HDQR_NM = hDQR_NM;
	}
	public String getPSS_NM() {
		return PSS_NM;
	}
	public void setPSS_NM(String pSS_NM) {
		PSS_NM = pSS_NM;
	}
	
	public String getFcl_NM() {
		return fcl_NM;
	}
	public void setFcl_NM(String fcl_NM) {
		this.fcl_NM = fcl_NM;
	}
	public int getCpu_use_qnt() {
		return cpu_use_qnt;
	}
	public void setCpu_use_qnt(int cpu_use_qnt) {
		this.cpu_use_qnt = cpu_use_qnt;
	}
	public int getRam_use_qnt() {
		return ram_use_qnt;
	}
	public void setRam_use_qnt(int ram_use_qnt) {
		this.ram_use_qnt = ram_use_qnt;
	}
	public int getHdd_use_qnt() {
		return hdd_use_qnt;
	}
	public void setHdd_use_qnt(int hdd_use_qnt) {
		this.hdd_use_qnt = hdd_use_qnt;
	}
	
	
    
    
}