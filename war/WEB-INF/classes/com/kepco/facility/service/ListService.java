package com.kepco.facility.service;

import java.util.List;

import com.kepco.facility.domain.ListDto;
import com.kepco.facility.domain.ListInputDto;

public interface ListService {

	// 임계치조회
	public float selectThrs(String flc_cd) throws Exception;

	// 01 통합제어 장치 전체건수
	public int selectTotCntfacility01(ListInputDto dt) throws Exception;

	// 01 통합제어장치 조회
	public List<ListDto> selectfacility01(ListInputDto dto) throws Exception;

	// 02 녹화장치 전체건수
	public int selectTotCntfacility02(ListInputDto dt) throws Exception;

	// 02 녹화장치 조회
	public List<ListDto> selectfacility02(ListInputDto dto) throws Exception;

	// 03 카메라 전체건수
	public int selectTotCntfacility03(ListInputDto dt) throws Exception;

	// 03 카메라 조회
	public List<ListDto> selectfacility03(ListInputDto dto) throws Exception;

	// 04 출입리더기 전체건수
	public int selectTotCntfacility04(ListInputDto dt) throws Exception;

	// 04 출입리더기 조회
	public List<ListDto> selectfacility04(ListInputDto dto) throws Exception;

	// 05 경보주장치 전체건수
	public int selectTotCntfacility05(ListInputDto dt) throws Exception;

	// 05 경보주장치 조회
	public List<ListDto> selectfacility05(ListInputDto dto) throws Exception;

	// 00 전체 건수조회
	public int selectTotCntfacility00(ListInputDto dto) throws Exception;

	// 00 전체 조회
	public List<ListDto> selectfacility00(ListInputDto dto) throws Exception;

	// err 01 통합제어 장치 전체건수
	public int selectErrTotCntfacility01(ListInputDto dt) throws Exception;

	// err01 통합제어장치 조회
	public List<ListDto> selectErrFacility01(ListInputDto dto) throws Exception;

	// err 02 녹화장치 전체건수
	public int selectErrTotCntfacility02(ListInputDto dt) throws Exception;

	// err02 녹화장치 조회
	public List<ListDto> selectErrFacility02(ListInputDto dto) throws Exception;

	// err 03 카메라 전체건수
	public int selectErrTotCntfacility03(ListInputDto dt) throws Exception;

	// err03 카메라 조회
	public List<ListDto> selectErrFacility03(ListInputDto dto) throws Exception;

	// err 04 출입리더기 전체건수
	public int selectErrTotCntfacility04(ListInputDto dt) throws Exception;

	// err04 출입리더기 조회
	public List<ListDto> selectErrFacility04(ListInputDto dto) throws Exception;

	// err 05 주경보장치 전체건수
	public int selectErrTotCntfacility05(ListInputDto dt) throws Exception;

	// err05 주경보장치 조회
	public List<ListDto> selectErrFacility05(ListInputDto dto) throws Exception;

}
