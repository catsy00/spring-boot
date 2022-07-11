package com.kepco.facility.persistence;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kepco.common.persistence.AbstractDAO;
import com.kepco.facility.domain.CameraCheckVO;
import com.kepco.facility.domain.FacilityBarCheckDateVO;
import com.kepco.facility.domain.FacilityBarCheckVO;
import com.kepco.facility.domain.FacilityCheckDateVO;
import com.kepco.facility.domain.FacilityCheckVO;
import com.kepco.facility.domain.FacilityVO;
import com.kepco.facility.domain.reportFacilityVO;
import com.kepco.facility.domain.searchThresholdVO;

@Repository("facilityDAO")
public class FacilityDAO extends AbstractDAO {

	@Autowired
	private SqlSession sqlSession;
	
	// 설비 총건수 조회
	public List<FacilityVO> cntTotFacility(HashMap<String, Object> map) throws Exception {

		return sqlSession.selectList("facility.cntTotFacility", map);
	}

	// 설비 정상총건수 조회
	public List<FacilityVO> cntFacility(HashMap<String, Object> map) throws Exception {

		return sqlSession.selectList("facility.cntFacility", map);
	}


	// operation_view 모달창 카메라에러 녹화 에러 이름 조회
	public List<CameraCheckVO> checkCamera(HashMap<String, Object> map) throws Exception {
		return sqlSession.selectList("facility.checkCamera", map);
	}
	
	// operation_view 모달창 카메라에러 이름 조회(날짜입력후)
	public List<CameraCheckVO> checkDateCamera(HashMap<String, Object> map) throws Exception {
		return sqlSession.selectList("facility.checkDateCamera", map);
	}

	// operation_view 모달창 카메라에러 녹화 에러 이름 조회
	public List<CameraCheckVO> checkCameraVdo(HashMap<String, Object> map) throws Exception {
		return sqlSession.selectList("facility.checkCameraVdo", map);
	}

	// operation_view 모달창 카메라에러 녹화 에러 이름 조회(날짜입력후)
	public List<CameraCheckVO> checkDateCameraVdo(HashMap<String, Object> map) throws Exception {
		return sqlSession.selectList("facility.checkDateCameraVdo", map);
	}

	// operation_view 모달창 출입리더기에러 이름 조회
	public List<CameraCheckVO> checkReader(HashMap<String, Object> map) throws Exception {
		return sqlSession.selectList("facility.checkReader", map);
	}

	// operation_view 모달창 경보주장치 에러 이름 조회
	public List<CameraCheckVO> checkAlter(HashMap<String, Object> map) throws Exception {
		return sqlSession.selectList("facility.checkAlter", map);
	}

	// operation_view 모달창 출입리더기에러 이름 조회(날짜입력후)
	public List<CameraCheckVO> checkDateReader(HashMap<String, Object> map) throws Exception {
		return sqlSession.selectList("facility.checkDateReader", map);
	}

	// operation_view 모달창 경보주장치 에러 이름 조회(날짜입력후)
	public List<CameraCheckVO> checkDateAlter(HashMap<String, Object> map) throws Exception {
		return sqlSession.selectList("facility.checkDateAlter", map);
	}

	// operation_view 모달창 bar게이지 정보 조회(날짜입력없이)
	public List<FacilityBarCheckVO> checkBarFacility(HashMap<String, Object> map) throws Exception {
		return sqlSession.selectList("facility.checkBarFacility", map);
	}

	// 설비 전체 에러 정보 조회(날짜입력 없이)
	public List<FacilityCheckVO> cntCheckFacility(HashMap<String, Object> map) throws Exception {

		System.out.println("map : " + sqlSession.selectOne("facility.checkFacility", map));

		return sqlSession.selectList("facility.checkFacility", map);
	}

	// operation_view 모달창 bar게이지 정보 조회(날짜입력후)
	public List<FacilityBarCheckDateVO> checkBarDateFacility(HashMap<String, Object> map) throws Exception {
		return sqlSession.selectList("facility.checkBarDateFacility", map);
	}

	// 설비 전체 에러 정보 조회(날짜입력 후)
	public List<FacilityCheckDateVO> cntCheckDateFacility(HashMap<String, Object> map) throws Exception {
		return sqlSession.selectList("facility.checkDateFacility", map);
	}

	// 엑셀다운로드 본부기준(날짜입력없이)
	public List<reportFacilityVO> reportFacility1(HashMap<String, Object> map) throws Exception {

		return sqlSession.selectList("facility.reportFacility1", map);
	}

	// 엑셀다운로드 본부기준(날짜입력 후)
	public List<reportFacilityVO> reportFacility1_1(HashMap<String, Object> map) throws Exception {

		return sqlSession.selectList("facility.reportFacility1_1", map);
	}

	// 엑셀다운로드 지사기준(날짜입력없이)
	public List<reportFacilityVO> reportFacility2(HashMap<String, Object> map) throws Exception {

		return sqlSession.selectList("facility.reportFacility2", map);
	}

	// 엑셀다운로드 지사기준(날짜입력후)
	public List<reportFacilityVO> reportFacility2_1(HashMap<String, Object> map) throws Exception {

		return sqlSession.selectList("facility.reportFacility2_1", map);
	}

	// 엑셀다운로드 변전소기준(날짜입력없이)
	public List<reportFacilityVO> reportFacility3(HashMap<String, Object> map) throws Exception {

		return sqlSession.selectList("facility.reportFacility3", map);
	}

	// 엑셀다운로드 변전소기준(날짜입력 후)
	public List<reportFacilityVO> reportFacility3_1(HashMap<String, Object> map) throws Exception {

		return sqlSession.selectList("facility.reportFacility3_1", map);
	}

	// 임계치 조회
	public List<searchThresholdVO> searchThreshold(String pssCd) throws Exception {

		return sqlSession.selectList("facility.searchThreshold", pssCd);
	}

}