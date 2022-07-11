package com.kepco.facility.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kepco.facility.persistence.ListDAO;
import com.kepco.facility.domain.ListDto;
import com.kepco.facility.domain.ListInputDto;
import com.kepco.facility.domain.PagingDto;
import com.kepco.facility.service.ListService;

@Service("ListService")
public class ListServiceImpl implements ListService {

	@Resource(name = "ListDAO")
	private ListDAO listdao;

	// 임계치
	@Override
	public float selectThrs(String flc_cd) throws Exception {
		return listdao.selectThrs(flc_cd);
	}

	// 01 통합제어장치 전체건수
	@Override
	public int selectTotCntfacility01(ListInputDto dto) throws Exception {
		return listdao.selectTotCntfacility01(dto);
	}

	// 01 통합제어장치조회
	@Override
	public List<ListDto> selectfacility01(ListInputDto dto) throws Exception {
		return listdao.selectfacility01(dto);
	}

	// 02 녹화장치 전체건수
	@Override
	public int selectTotCntfacility02(ListInputDto dto) throws Exception {
		return listdao.selectTotCntfacility02(dto);
	}

	// 02 녹화장치 조회
	@Override
	public List<ListDto> selectfacility02(ListInputDto dto) throws Exception {
		return listdao.selectfacility02(dto);
	}

	// 03 카메라 전체건수
	@Override
	public int selectTotCntfacility03(ListInputDto dto) throws Exception {
		return listdao.selectTotCntfacility03(dto);
	}

	// 03 카메라 조회
	@Override
	public List<ListDto> selectfacility03(ListInputDto dto) throws Exception {
		return listdao.selectfacility03(dto);
	}

	// 04출입리더기 전체건수
	@Override
	public int selectTotCntfacility04(ListInputDto dto) throws Exception {
		return listdao.selectTotCntfacility04(dto);
	}

	// 04출입리더기 조회
	@Override
	public List<ListDto> selectfacility04(ListInputDto dto) throws Exception {
		return listdao.selectfacility04(dto);
	}

	// 05 경보주장치 전체건수
	@Override
	public int selectTotCntfacility05(ListInputDto dto) throws Exception {
		return listdao.selectTotCntfacility05(dto);
	}

	// 05 경보주장치 조회
	@Override
	public List<ListDto> selectfacility05(ListInputDto dto) throws Exception {
		return listdao.selectfacility05(dto);
	}

	// 00 전체건수
	@Override
	public int selectTotCntfacility00(ListInputDto dto) throws Exception {
		return listdao.selectTotCntfacility00(dto);
	}

	// 00 전체 조회
	@Override
	public List<ListDto> selectfacility00(ListInputDto dto) throws Exception {
		return listdao.selectfacility00(dto);
	}

	// err 01 통합제어장치 전체건수
	@Override
	public int selectErrTotCntfacility01(ListInputDto dto) throws Exception {
		return listdao.selectErrTotCntfacility01(dto);
	}

	// err 01 통합제어장치조회
	@Override
	public List<ListDto> selectErrFacility01(ListInputDto dto) throws Exception {
		return listdao.selectErrFacility01(dto);
	}

	// err 02 녹화장치 전체건수
	@Override
	public int selectErrTotCntfacility02(ListInputDto dto) throws Exception {
		return listdao.selectErrTotCntfacility02(dto);
	}

	// err 02 녹화장치 조회
	@Override
	public List<ListDto> selectErrFacility02(ListInputDto dto) throws Exception {
		return listdao.selectErrFacility02(dto);
	}

	// err 03 카메라 전체건수
	@Override
	public int selectErrTotCntfacility03(ListInputDto dto) throws Exception {
		return listdao.selectErrTotCntfacility03(dto);
	}

	// err 03 카메라 조회
	@Override
	public List<ListDto> selectErrFacility03(ListInputDto dto) throws Exception {
		return listdao.selectErrFacility03(dto);
	}

	// err 04 출입리더기 전체건수
	@Override
	public int selectErrTotCntfacility04(ListInputDto dto) throws Exception {
		return listdao.selectErrTotCntfacility04(dto);
	}

	// err 04 출입리더기 조회
	@Override
	public List<ListDto> selectErrFacility04(ListInputDto dto) throws Exception {
		return listdao.selectErrFacility04(dto);
	}
	
	// err 05 주경보장치 전체건수
		@Override
		public int selectErrTotCntfacility05(ListInputDto dto) throws Exception {
			return listdao.selectErrTotCntfacility05(dto);
		}

		// err 05 주경보장치 조회
		@Override
		public List<ListDto> selectErrFacility05(ListInputDto dto) throws Exception {
			return listdao.selectErrFacility05(dto);
		}
}