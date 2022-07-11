package com.kepco.facility.domain;

public class ListDto {
	
	/**
	 * 공통 변수
	 */
	String id, chk_dt, ins_plce_nm, power_bizp_nm, pss_nm, fd_nm, check_yn, errResult, pss_cd;
	
	
	/**
	 * 공통 사용 TABLE
	 * facility_check_01 서버장치류 점검내역
	 * facility_check_02 녹화장치 점검내역
	 */
	String  vdo_file_yn;
	Double  cpu_use_qnt, cpu_use_rate, ram_use_qnt, ram_use_rate, hdd_use_qnt, hdd_tot_qnt, hdd_tot_qnt2,hdd_use_qnt2, hdd_tot_qnt3,hdd_use_qnt3, hdd_use_rate,hdd_use_rate2,hdd_use_rate3, ram_tot_qnt;
	
	

	public Double getHdd_tot_qnt() {
		return hdd_tot_qnt;
	}

	public Double getHdd_tot_qnt2() {
		return hdd_tot_qnt2;
	}

	public void setHdd_tot_qnt2(Double hdd_tot_qnt2) {
		this.hdd_tot_qnt2 = hdd_tot_qnt2;
	}

	public Double getHdd_use_qnt2() {
		return hdd_use_qnt2;
	}

	public void setHdd_use_qnt2(Double hdd_use_qnt2) {
		this.hdd_use_qnt2 = hdd_use_qnt2;
	}

	public Double getHdd_tot_qnt3() {
		return hdd_tot_qnt3;
	}

	public void setHdd_tot_qnt3(Double hdd_tot_qnt3) {
		this.hdd_tot_qnt3 = hdd_tot_qnt3;
	}

	public Double getHdd_use_qnt3() {
		return hdd_use_qnt3;
	}

	public void setHdd_use_qnt3(Double hdd_use_qnt3) {
		this.hdd_use_qnt3 = hdd_use_qnt3;
	}

	public void sethdd_tot_qnt(Double hdd_tot_qnt) {
		this.hdd_tot_qnt = hdd_tot_qnt;
	}

	/**
	 * 사용 TABLE
	 * facility_check_03 카메라 점검내역
	 * facility_check_04 출입리더기 점검내역
	 * facility_check_05 경보주장치 점검내역
	 */
	String cnn_ss, cnn_sts_yn;
	
	String fcl_cl_cd;
	
	

	public String getCnn_ss() {
		return cnn_ss;
	}

	public void setCnn_ss(String cnn_ss) {
		this.cnn_ss = cnn_ss;
	}

	public String getCnn_sts_yn() {
		return cnn_sts_yn;
	}

	public void setCnn_sts_yn(String cnn_sts_yn) {
		this.cnn_sts_yn = cnn_sts_yn;
	}

	public String getVdo_file_yn() {
		return vdo_file_yn;
	}

	public void setVdo_file_yn(String vdo_file_yn) {
		this.vdo_file_yn = vdo_file_yn;
	}

	int rn;

	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getCpu_use_qnt() {
		return cpu_use_qnt;
	}

	public void setCpu_use_qnt(Double cpu_use_qnt) {
		this.cpu_use_qnt = cpu_use_qnt;
	}

	public Double getCpu_use_rate() {
		return cpu_use_rate;
	}

	public void setCpu_use_rate(Double cpu_use_rate) {
		this.cpu_use_rate = cpu_use_rate;
	}

	public Double getRam_use_qnt() {
		return ram_use_qnt;
	}

	public void setRam_use_qnt(Double ram_use_qnt) {
		this.ram_use_qnt = ram_use_qnt;
	}

	public Double getRam_use_rate() {
		return ram_use_rate;
	}

	public void setRam_use_rate(Double ram_use_rate) {
		this.ram_use_rate = ram_use_rate;
	}

	public Double gethdd_use_qnt() {
		return hdd_use_qnt;
	}

	public void sethdd_use_qnt(Double hdd_use_qnt) {
		this.hdd_use_qnt = hdd_use_qnt;
	}

	public Double getHdd_use_rate() {
		return hdd_use_rate;
	}

	public void setHdd_use_rate(Double hdd_use_rate) {
		this.hdd_use_rate = hdd_use_rate;
	}
	

	public Double getHdd_use_rate2() {
		return hdd_use_rate2;
	}

	public void setHdd_use_rate2(Double hdd_use_rate2) {
		this.hdd_use_rate2 = hdd_use_rate2;
	}

	public Double getHdd_use_rate3() {
		return hdd_use_rate3;
	}

	public void setHdd_use_rate3(Double hdd_use_rate3) {
		this.hdd_use_rate3 = hdd_use_rate3;
	}

	public Double getRam_tot_qnt() {
		return ram_tot_qnt;
	}

	public void setRam_tot_qnt(Double ram_tot_qnt) {
		this.ram_tot_qnt = ram_tot_qnt;
	}

	public void setHdd_tot_qnt(Double hdd_tot_qnt) {
		this.hdd_tot_qnt = hdd_tot_qnt;
	}

	public String getChk_dt() {
		return chk_dt;
	}

	public void setChk_dt(String chk_dt) {
		this.chk_dt = chk_dt;
	}

	public String getIns_plce_nm() {
		return ins_plce_nm;
	}

	public void setIns_plce_nm(String ins_plce_nm) {
		this.ins_plce_nm = ins_plce_nm;
	}

	public String getPower_bizp_nm() {
		return power_bizp_nm;
	}

	public void setPower_bizp_nm(String power_bizp_nm) {
		this.power_bizp_nm = power_bizp_nm;
	}
	
	

	public String getPss_cd() {
		return pss_cd;
	}

	public void setPss_cd(String pss_cd) {
		this.pss_cd = pss_cd;
	}

	public String getPss_nm() {
		return pss_nm;
	}

	public void setPss_nm(String pss_nm) {
		this.pss_nm = pss_nm;
	}
	

	public String getFd_nm() {
		return fd_nm;
	}

	public void setFd_nm(String fd_nm) {
		this.fd_nm = fd_nm;
	}

	public String getCheck_yn() {
		return check_yn;
	}

	public void setCheck_yn(String check_yn) {
		this.check_yn = check_yn;
	}

	public String getErrResult() {
		return errResult;
	}

	public void setErrResult(String errResult) {
		this.errResult = errResult;
	}

	public String getFcl_cl_cd() {
		return fcl_cl_cd;
	}

	public void setFcl_cl_cd(String fcl_cl_cd) {
		this.fcl_cl_cd = fcl_cl_cd;
	}

	
}
