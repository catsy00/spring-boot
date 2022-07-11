package com.kepco.facility.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kepco.facility.domain.CameraCheckVO;
import com.kepco.facility.domain.FacilityBarCheckDateVO;
import com.kepco.facility.domain.FacilityBarCheckVO;
import com.kepco.facility.domain.FacilityCheckDateVO;
import com.kepco.facility.domain.FacilityCheckVO;
import com.kepco.facility.domain.FacilityVO;
import com.kepco.facility.domain.reportFacilityVO;
import com.kepco.facility.domain.searchThresholdVO;
import com.kepco.facility.persistence.FacilityDAO;

@Service("facilityService")
public class FacilityServiceImpl implements FacilityService {

	@Resource(name = "facilityDAO")
	private FacilityDAO facilityDAO;
	
	
	// 설비 총건수 조회
	public List<FacilityVO> cntTotFacility(HashMap<String, Object> map) throws Exception {
		List<FacilityVO> cnt = facilityDAO.cntTotFacility(map);
		return cnt;
	}


	// 설비 정상건수 조회
	public List<FacilityVO> cntFacility(HashMap<String, Object> map) throws Exception {
		List<FacilityVO> cnt = facilityDAO.cntFacility(map);
		return cnt;
	}

	@Override
	public List<CameraCheckVO> checkCamera(HashMap<String, Object> map) throws Exception {
		List<CameraCheckVO> cnt = facilityDAO.checkCamera(map);
		return cnt;
	}


	// operation_view 모달창 카메라에러 이름 조회(날짜입력후)
	public List<CameraCheckVO> checkDateCamera(HashMap<String, Object> map) throws Exception {
		List<CameraCheckVO> cnt = facilityDAO.checkDateCamera(map);
		return cnt;
	}

	//// operation_view 모달창 카메라에러 녹화 에러 이름 조회
	public List<CameraCheckVO> checkCameraVdo(HashMap<String, Object> map) throws Exception {
		List<CameraCheckVO> cnt = facilityDAO.checkCameraVdo(map);
		return cnt;
	}

	//// operation_view 모달창 카메라에러 녹화 에러 이름 조회(날짜입력후)
	public List<CameraCheckVO> checkDateCameraVdo(HashMap<String, Object> map) throws Exception {
		List<CameraCheckVO> cnt = facilityDAO.checkDateCameraVdo(map);
		return cnt;
	}

	// operation_view 모달창 출입리더기에러 이름 조회
	public List<CameraCheckVO> checkReader(HashMap<String, Object> map) throws Exception {
		List<CameraCheckVO> cnt = facilityDAO.checkReader(map);
		return cnt;
	}

	// operation_view 모달창 경보주장치 에러 이름 조회
	public List<CameraCheckVO> checkAlter(HashMap<String, Object> map) throws Exception {
		List<CameraCheckVO> cnt = facilityDAO.checkAlter(map);
		return cnt;
	}

	// operation_view 모달창 출입리더기에러 이름 조회(날짜입력후)
	public List<CameraCheckVO> checkDateReader(HashMap<String, Object> map) throws Exception {
		List<CameraCheckVO> cnt = facilityDAO.checkDateReader(map);
		return cnt;
	}

	// operation_view 모달창 경보주장치 에러 이름 조회(날짜입력후)
	public List<CameraCheckVO> checkDateAlter(HashMap<String, Object> map) throws Exception {
		List<CameraCheckVO> cnt = facilityDAO.checkDateAlter(map);
		return cnt;
	}

	// operation_view 모달창 bar게이지 정보 조회(날짜입력없이)
	public List<FacilityBarCheckVO> checkBarFacility(HashMap<String, Object> map) throws Exception {
		List<FacilityBarCheckVO> cnt = facilityDAO.checkBarFacility(map);
		return cnt;
	}

	// 설비 전체 에러 정보 조회(날짜입력 없이)
	public List<FacilityCheckVO> cntCheckFacility(HashMap<String, Object> map) throws Exception {
		List<FacilityCheckVO> cnt = facilityDAO.cntCheckFacility(map);
		return cnt;
	}

	// operation_view 모달창 bar게이지 정보 조회(날짜입력후)
	public List<FacilityBarCheckDateVO> checkBarDateFacility(HashMap<String, Object> map) throws Exception {
		List<FacilityBarCheckDateVO> cnt = facilityDAO.checkBarDateFacility(map);
		return cnt;
	}

	// 설비 전체 에러 정보 조회(날짜입력 후)
	public List<FacilityCheckDateVO> cntCheckDateFacility(HashMap<String, Object> map) throws Exception {
		List<FacilityCheckDateVO> cnt = facilityDAO.cntCheckDateFacility(map);
		return cnt;
	}

	// 엑셀다운로드 본부기준(날짜입력없이)
	public List<reportFacilityVO> reportFacility1(HashMap<String, Object> map) throws Exception {

		List<reportFacilityVO> cnt = facilityDAO.reportFacility1(map);
		return cnt;
	}

	// 엑셀다운로드 본부기준(날짜입력 후)
	public List<reportFacilityVO> reportFacility1_1(HashMap<String, Object> map) throws Exception {

		List<reportFacilityVO> cnt = facilityDAO.reportFacility1_1(map);
		return cnt;
	}

	// 엑셀다운로드 지사기준(날짜입력없이)
	public List<reportFacilityVO> reportFacility2(HashMap<String, Object> map) throws Exception {

		List<reportFacilityVO> cnt = facilityDAO.reportFacility2(map);
		return cnt;
	}

	// 엑셀다운로드 지사기준(날짜입력후)
	public List<reportFacilityVO> reportFacility2_1(HashMap<String, Object> map) throws Exception {

		List<reportFacilityVO> cnt = facilityDAO.reportFacility2_1(map);
		return cnt;
	}

	// 엑셀다운로드 변전소기준(날짜입력없이)
	public List<reportFacilityVO> reportFacility3(HashMap<String, Object> map) throws Exception {

		List<reportFacilityVO> cnt = facilityDAO.reportFacility3(map);
		return cnt;
	}

	// 엑셀다운로드 변전소기준(날짜입력 후)
	public List<reportFacilityVO> reportFacility3_1(HashMap<String, Object> map) throws Exception {

		List<reportFacilityVO> cnt = facilityDAO.reportFacility3_1(map);
		return cnt;
	}

	// 임계치 조회
	public List<searchThresholdVO> searchThreshold(String pssCd) throws Exception {

		List<searchThresholdVO> cnt = facilityDAO.searchThreshold(pssCd);

		return cnt;
	}

	
}
