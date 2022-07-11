package com.kepco.facility.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kepco.common.persistence.AbstractDAO;
import com.kepco.facility.domain.ListDto;
import com.kepco.facility.domain.ListInputDto;

@Repository("ListDAO")
public class ListDAO extends AbstractDAO {

	@Autowired
	private SqlSession sqlSession;

	// 임계치
	public float selectThrs(String flc_cd) {

		return sqlSession.selectOne("facilityList.selectThrs", flc_cd);
	}

	// 01 통합제어장치 전체건수
	public int selectTotCntfacility01(ListInputDto dto) {

		return sqlSession.selectOne("facilityList.selectTotCntfacility01", dto);
	}

	// 01 통합제어장치 조회
	public List<ListDto> selectfacility01(ListInputDto dto) {

		return sqlSession.selectList("facilityList.selectfacility01", dto);
	}

	// 02 녹화장치 전체건수
	public int selectTotCntfacility02(ListInputDto dto) {

		return sqlSession.selectOne("facilityList.selectTotCntfacility02", dto);
	}

	// 02 녹화장치 조회
	public List<ListDto> selectfacility02(ListInputDto dto) {

		return sqlSession.selectList("facilityList.selectfacility02", dto);
	}

	// 03 카메라 전체건수
	public int selectTotCntfacility03(ListInputDto dto) {

		return sqlSession.selectOne("facilityList.selectTotCntfacility03", dto);
	}

	// 03 카메라 조회
	public List<ListDto> selectfacility03(ListInputDto dto) {

		return sqlSession.selectList("facilityList.selectfacility03", dto);
	}

	// 04 출입리더기 전체건수
	public int selectTotCntfacility04(ListInputDto dto) {

		return sqlSession.selectOne("facilityList.selectTotCntfacility04", dto);
	}

	// 04 출입리더기 조회
	public List<ListDto> selectfacility04(ListInputDto dto) {

		return sqlSession.selectList("facilityList.selectfacility04", dto);
	}

	// 05 경보주장치 전체건수
	public int selectTotCntfacility05(ListInputDto dto) {

		return sqlSession.selectOne("facilityList.selectTotCntfacility05", dto);
	}

	// 05 경보주장치 조회
	public List<ListDto> selectfacility05(ListInputDto dto) {

		return sqlSession.selectList("facilityList.selectfacility05", dto);
	}

	// 00 전체건수
	public int selectTotCntfacility00(ListInputDto dto) {

		return sqlSession.selectOne("facilityList.selectTotCntfacility00", dto);
	}

	// 00 전체 조회
	public List<ListDto> selectfacility00(ListInputDto dto) {

		return sqlSession.selectList("facilityList.selectfacility00", dto);
	}

	// err 01 통합제어장치 전체건수
	public int selectErrTotCntfacility01(ListInputDto dto) {

		return sqlSession.selectOne("facilityList.selectErrTotCntfacility01", dto);
	}

	// err 01 통합제어장치 조회
	public List<ListDto> selectErrFacility01(ListInputDto dto) {

		return sqlSession.selectList("facilityList.selectErrFacility01", dto);
	}

	// err 02 녹화장치 전체건수
	public int selectErrTotCntfacility02(ListInputDto dto) {

		return sqlSession.selectOne("facilityList.selectErrTotCntfacility02", dto);
	}

	// err 02 녹화장치 조회
	public List<ListDto> selectErrFacility02(ListInputDto dto) {

		return sqlSession.selectList("facilityList.selectErrFacility02", dto);
	}

	// err 03 카메라 전체건수
	public int selectErrTotCntfacility03(ListInputDto dto) {

		return sqlSession.selectOne("facilityList.selectErrTotCntfacility03", dto);
	}

	// err 03 카메라 조회
	public List<ListDto> selectErrFacility03(ListInputDto dto) {

		return sqlSession.selectList("facilityList.selectErrFacility03", dto);
	}

	// err 04 출입리더기 전체건수
	public int selectErrTotCntfacility04(ListInputDto dto) {

		return sqlSession.selectOne("facilityList.selectErrTotCntfacility04", dto);
	}

	// err 04 출입리더기 조회
	public List<ListDto> selectErrFacility04(ListInputDto dto) {

		return sqlSession.selectList("facilityList.selectErrFacility04", dto);
	}

	// err 05 주경보장치 전체건수
	public int selectErrTotCntfacility05(ListInputDto dto) {

		return sqlSession.selectOne("facilityList.selectErrTotCntfacility05", dto);
	}

	// err 05 주경보장치 조회
	public List<ListDto> selectErrFacility05(ListInputDto dto) {

		return sqlSession.selectList("facilityList.selectErrFacility05", dto);
	}
}