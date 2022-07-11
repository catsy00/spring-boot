package com.kepco.facility.service;

import java.util.HashMap;
import java.util.List;

import com.kepco.facility.domain.CameraCheckVO;
import com.kepco.facility.domain.FacilityBarCheckDateVO;
import com.kepco.facility.domain.FacilityBarCheckVO;
import com.kepco.facility.domain.FacilityCheckDateVO;
import com.kepco.facility.domain.FacilityCheckVO;
import com.kepco.facility.domain.FacilityVO;
import com.kepco.facility.domain.reportFacilityVO;
import com.kepco.facility.domain.searchThresholdVO;

public interface FacilityService {
	
	//설비 건수 조회
	public List<FacilityVO> cntTotFacility(HashMap<String, Object> map) throws Exception;
	
	//설비 정상총건수 조회
	public List<FacilityVO> cntFacility(HashMap<String, Object> map) throws Exception;
	
	//operation_view 모달창 카메라에러 이름 조회
	public List<CameraCheckVO> checkCamera(HashMap<String, Object> map) throws Exception;
	
	//operation_view 모달창 카메라에러 이름 조회(날짜입력후)
	public List<CameraCheckVO> checkDateCamera(HashMap<String, Object> map) throws Exception;
	
	//operation_view 모달창 출입리더기에러 이름 조회(날짜입력후)
	public List<CameraCheckVO> checkDateReader(HashMap<String, Object> map) throws Exception;
	
	//operation_view 모달창 경보주장치 에러 이름 조회(날짜입력후)
	public List<CameraCheckVO> checkDateAlter(HashMap<String, Object> map) throws Exception;
	
	//operation_view 모달창 카메라에러 녹화 에러 이름 조회(날짜입력후)
	public List<CameraCheckVO> checkDateCameraVdo(HashMap<String, Object> map) throws Exception;

	//operation_view 모달창 출입리더기에러 이름 조회(날짜입력없이)
	public List<CameraCheckVO> checkReader(HashMap<String, Object> map) throws Exception;
	
	//operation_view 모달창 경보주장치 에러 이름 조회(날짜입력없이)
	public List<CameraCheckVO> checkAlter(HashMap<String, Object> map) throws Exception;
	
	//operation_view 모달창 카메라에러 녹화 에러 이름 조회(날짜입력없이)
	public List<CameraCheckVO> checkCameraVdo(HashMap<String, Object> map) throws Exception;
	
		
	//operation_view 모달창 bar게이지 정보 조회(날짜입력없이)
	public List<FacilityBarCheckVO> checkBarFacility(HashMap<String, Object> map) throws Exception;
	
	//설비 전체 에러 정보 조회(날짜입력 없이)
	public List<FacilityCheckVO> cntCheckFacility(HashMap<String, Object> map) throws Exception;
	
	//operation_view 모달창 bar게이지 정보 조회(날짜입력후)
	public List<FacilityBarCheckDateVO> checkBarDateFacility(HashMap<String, Object> map) throws Exception;
	
	//설비 전체 에러 정보 조회(날짜입력 후)
	public List<FacilityCheckDateVO> cntCheckDateFacility(HashMap<String, Object> map) throws Exception;
	
	//엑셀다운로드 본부기준(날짜입력없이)
	public List<reportFacilityVO> reportFacility1(HashMap<String, Object> map) throws Exception;
	
	//엑셀다운로드 본부기준(날짜입력 후)
	public List<reportFacilityVO> reportFacility1_1(HashMap<String, Object> map) throws Exception;
	
	//엑셀다운로드 지사기준(날짜입력없이)
	public List<reportFacilityVO> reportFacility2(HashMap<String, Object> map) throws Exception;
	
	//엑셀다운로드 지사기준(날짜입력후)
	public List<reportFacilityVO> reportFacility2_1(HashMap<String, Object> map) throws Exception;
	
	//엑셀다운로드 변전소기준(날짜입력없이)
	public List<reportFacilityVO> reportFacility3(HashMap<String, Object> map) throws Exception;
	
	//엑셀다운로드 변전소기준(날짜입력 후)
	public List<reportFacilityVO> reportFacility3_1(HashMap<String, Object> map) throws Exception;
	
	//임계치 조회
	public List<searchThresholdVO> searchThreshold(String pssCd) throws Exception;


}
