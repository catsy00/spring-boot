package com.kepco.facility.domain;

public class ListInputDto {
	private int start, end;
	private int cntPage = 5;
	private double thrs, thrs01, thrs02;
    String id, pssCd, checkCd ;
    String endDate, startDate, checkDt;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getCntPage() {
		return cntPage;
	}

	public void setCntPage(int cntPage) {
		this.cntPage = cntPage;
	}

	public String getPssCd() {
		return pssCd;
	}

	public void setPssCd(String pssCd) {
		this.pssCd = pssCd;
	}

	public String getCheckCd() {
		return checkCd;
	}

	public void setCheckCd(String checkCd) {
		this.checkCd = checkCd;
	}

	public double getThrs() {
		return thrs;
	}

	public void setThrs(double thrs) {
		this.thrs = thrs;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public double getThrs01() {
		return thrs01;
	}

	public void setThrs01(double thrs01) {
		this.thrs01 = thrs01;
	}

	public double getThrs02() {
		return thrs02;
	}

	public void setThrs02(double thrs02) {
		this.thrs02 = thrs02;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCheckDt() {
		return checkDt;
	}

	public void setCheckDt(String checkDt) {
		this.checkDt = checkDt;
	}
	
	
	
	
	
	

}
