package com.kepco.facility.domain;

public class searchThresholdVO {
	
	
	
	private String FCL_CL_CD;
	private String THRS_VAL;
	
	
	
	public String getFCL_CL_CD() {
		return FCL_CL_CD;
	}



	public void setFCL_CL_CD(String fCL_CL_CD) {
		FCL_CL_CD = fCL_CL_CD;
	}



	public String getTHRS_VAL() {
		return THRS_VAL;
	}



	public void setTHRS_VAL(String tHRS_VAL) {
		THRS_VAL = tHRS_VAL;
	}



	@Override
	public String toString() {
		return "searchThresholdVO [FCL_CL_CD=" + FCL_CL_CD + ", THRS_VAL=" + THRS_VAL + "]";
	}


}