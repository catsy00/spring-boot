package com.kepco.facility.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kepco.facility.domain.ListDto;
import com.kepco.facility.domain.ListInputDto;
import com.kepco.facility.domain.PagingDto;
import com.kepco.facility.service.ListService;
import com.kepco.user.util.RegisterRequest;

@Controller
@RequestMapping(value = "/facility")
public class realTimeController {

	@Resource(name = "ListService")
	private ListService listService;

	@RequestMapping(value = "/real_list", method = RequestMethod.GET)
	public ModelAndView real_listGet(HttpServletRequest request, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws Exception {

		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/facility/check/real_list");
		mv.addObject("registerRequest", new RegisterRequest());

		return mv;

	}
	@RequestMapping(value = "/selectRealList", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> selectRealList(HttpServletRequest request) throws Exception {

		Map<String, Object> result = new HashMap<String, Object>();

		// 검색조건 초기 값
		String fclClCd = "00";
		String pssCd = "D368"; // 설비구분코드, 변전소 코드
		String checkCd = "3"; // 설비상태
		String page;
		String startDate, endDate;
		int nowPage, cntPerPage;
		// 설비구분
		if (request.getParameter("fcl_cl_cd") != null) {
			fclClCd = request.getParameter("fcl_cl_cd").toString();
		} else {
			fclClCd = "00";
		}

		// 뱐전소코드
		if (!("0000").equals(request.getParameter("pss_cd"))) {
			pssCd = request.getParameter("pss_cd").toString();
		} else {
			pssCd = "D368";
		}

		// 페이지
		if (request.getParameter("page") != null) {
			page = request.getParameter("page");
		} else {
			page = "1";
		}
		// 설비상태
		if (!("").equals(request.getParameter("check_cd"))) {
			checkCd = request.getParameter("check_cd").toString();
		} else {
			checkCd = "3";
		}

		// 조회일자
		if (!("").equals(request.getParameter("startDate_list"))) {
			startDate = request.getParameter("startDate_list").toString();
		} else {
			startDate = "3";
		}

		if (!("").equals(request.getParameter("endDate_list"))) {
			endDate = request.getParameter("endDate_list").toString();
		} else {
			endDate = "3";
		}

		// 임계치
		double thrs = 0;
		double thrs01 = 0;
		double thrs02 = 0;
		// 전체건수
		int total;
		// 비정상원인
		String resutl;

		List<ListDto> list;
		ListInputDto listInput = new ListInputDto();

		// 페이징
		if (page == "1") {
			nowPage = 1;
			cntPerPage = 10;
			listInput.setStart(nowPage);
			listInput.setEnd(cntPerPage);
			System.out.println("입력값! listInput = "+listInput.getStart());  
			System.out.println("입력값! listInput = "+listInput.getEnd());  
		} else {
			int pageInt = Integer.parseInt(page);
			listInput.setStart(pageInt + (9 * (pageInt - 1)));
			listInput.setEnd(pageInt * 10);
		}

		// 변전소코드
		listInput.setPssCd(pssCd);
		// 설비상태코드(정상 비정상)
		listInput.setCheckCd(checkCd);
		// 조회일자
		listInput.setStartDate(startDate);
		listInput.setEndDate(endDate);

		// 01: 서버장치 | 02: 녹화장치 | 03: 카메라 | 04: 출입리더기 | 05: 경보주장치
		if (("01").equals(fclClCd)) {
			thrs = listService.selectThrs("01");
			listInput.setThrs(thrs);
			total = listService.selectTotCntfacility01(listInput);
			list = listService.selectfacility01(listInput);

		} else if (("02").equals(fclClCd)) {
			thrs = listService.selectThrs("02");
			listInput.setThrs(thrs);
			total = listService.selectTotCntfacility02(listInput);
			list = listService.selectfacility02(listInput);

		} else if (("03").equals(fclClCd)) { // 03 카메라
			total = listService.selectTotCntfacility03(listInput);
			list = listService.selectfacility03(listInput);

		} else if (("04").equals(fclClCd)) { // 03 카메라

			total = listService.selectTotCntfacility04(listInput);
			list = listService.selectfacility04(listInput);

		} else if (("05").equals(fclClCd)) { // 03 카메라

			total = listService.selectTotCntfacility05(listInput);
			list = listService.selectfacility05(listInput);

		} else {
			thrs01 = listService.selectThrs("01");
			thrs02 = listService.selectThrs("02");
			listInput.setThrs01(thrs01);
			listInput.setThrs02(thrs02);
			total = listService.selectTotCntfacility00(listInput);
			list = listService.selectfacility00(listInput);
		}

		// 비정상 원인 추가
		for (int i = 0; i < list.size(); i++) {
			resutl = "";
			if (("01").equals(fclClCd) || ("02").equals(fclClCd)) {
				if (Double.valueOf(list.get(i).getCpu_use_rate()) > thrs) {
					resutl += "CPU ";
				}
				if (Double.valueOf(list.get(i).getRam_use_rate()) > thrs) {
					resutl += "RAM ";
				}
				if (Double.valueOf(list.get(i).getHdd_use_rate()) > thrs) {
					resutl += "DISK#1 ";
				}
				if (("02").equals(fclClCd)) {
					if (Double.valueOf(list.get(i).getHdd_use_rate2()) > thrs) {
						resutl += "DISK#2 ";
					}
					if (Double.valueOf(list.get(i).getHdd_use_rate3()) > thrs) {
						resutl += "DISK#3 ";
					}
				}
			} else if (("00").equals(fclClCd)) {
				if (("01").equals(list.get(i).getFcl_cl_cd())) {
					thrs = thrs01;
				} else {
					thrs = thrs02;
				}

				if (Double.valueOf(list.get(i).getCpu_use_rate()) > thrs) {
					resutl += "CPU ";
				}

				if (("02").equals(list.get(i).getFcl_cl_cd())) {
					if (list.get(i).getHdd_tot_qnt() != 0.0) {
						if (Double.valueOf(list.get(i).getHdd_use_rate()) > thrs) {
							resutl += "DISK#1 ";
						}
						if (Double.valueOf(list.get(i).getHdd_use_rate2()) > thrs) {
							resutl += "DISK#2 ";
						}
						if (Double.valueOf(list.get(i).getHdd_use_rate3()) > thrs) {
							resutl += "DISK#3 ";
						}
					}
				} else {
					if (list.get(i).getHdd_tot_qnt() != 0.0) {
						if (Double.valueOf(list.get(i).getHdd_use_rate()) > thrs) {
							resutl += "DISK ";
						}
					}
				}
				
				if (list.get(i).getRam_tot_qnt() != 0.0) {
					if (Double.valueOf(list.get(i).getRam_use_rate()) > thrs) {
						resutl += "RAM ";
					}
				}
				if (("1").equals(list.get(i).getVdo_file_yn())) {
					resutl += "VIDEO ";
				}
				if (("1").equals(list.get(i).getCnn_sts_yn())) {
					resutl += "네트쿼크 연결 ";
				}
			} else if (("03").equals(fclClCd)) {
				if (("1").equals(list.get(i).getCheck_yn())) {
					resutl += "네트쿼크 연결 ";
				}
				if (("1").equals(list.get(i).getVdo_file_yn())) {
					resutl += "녹화상태";
				}
				
			} else {
			
				if (("1").equals(list.get(i).getCheck_yn())) {
					resutl += "네트쿼크 연결 ";
				}
			}
			list.get(i).setErrResult(resutl);
		}

		result.put("list", list);
		result.put("totCnt", total);

		return result;

	}

	@RequestMapping(value = "/selectDetailList", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> selectDetailList(HttpServletRequest request) throws Exception {

		Map<String, Object> result = new HashMap<String, Object>();

		// 검색조건 초기 값
		String fclClCd = "00";
		String id = "";
		String chkDt = "";
		String page;
		// 임계치
		double thrs = 0;
		double thrs01 = 0;
		double thrs02 = 0;
		// 전체건수
		int total;
		int nowPage, cntPerPage;
		// 비정상원인
		String resutl;

		// 설비구분
		if (!(request.getParameter("fclClCd")).isEmpty()) {
			fclClCd = request.getParameter("fclClCd").toString();
		}
		// 설비ID
		if (!(request.getParameter("id")).isEmpty()) {
			id = request.getParameter("id").toString();
		}

		// 점검일자
		if (!(request.getParameter("chkDt")).isEmpty()) {
			chkDt = request.getParameter("chkDt").toString();
		}

		// 페이지
		if (request.getParameter("page") != null) {
			page = request.getParameter("page");
		} else {
			page = "1";
		}

		List<ListDto> list;
		ListInputDto listInput = new ListInputDto();

		listInput.setId(id);
		listInput.setCheckDt(chkDt);

		// 페이징
		if (page == "1") {
			nowPage = 1;
			cntPerPage = 10;
			listInput.setStart(nowPage);
			listInput.setEnd(cntPerPage);
		} else {
			int pageInt = Integer.parseInt(page);
			listInput.setStart(pageInt + (9 * (pageInt - 1)));
			listInput.setEnd(pageInt * 10);
		}

		// 통합제어장치
		if (("01").equals(fclClCd)) {
			thrs = listService.selectThrs(fclClCd);
			listInput.setThrs(thrs);
			thrs01 = thrs;
			total = listService.selectErrTotCntfacility01(listInput);
			list = listService.selectErrFacility01(listInput);
		} else if (("02").equals(fclClCd)) {
			thrs = listService.selectThrs(fclClCd);
			listInput.setThrs(thrs);
			thrs02 = thrs;
			total = listService.selectErrTotCntfacility02(listInput);
			list = listService.selectErrFacility02(listInput);
		} else if (("03").equals(fclClCd)) {
			total = listService.selectErrTotCntfacility03(listInput);
			list = listService.selectErrFacility03(listInput);
		} else if (("04").equals(fclClCd)) {
			total = listService.selectErrTotCntfacility04(listInput);
			list = listService.selectErrFacility04(listInput);
		} else if (("05").equals(fclClCd)) {
			total = listService.selectErrTotCntfacility05(listInput);
			list = listService.selectErrFacility05(listInput);
		} else {
			thrs = listService.selectThrs(fclClCd);
			listInput.setThrs(thrs);
			total = listService.selectErrTotCntfacility01(listInput);
			list = listService.selectErrFacility01(listInput);
		}

		// 비정상 원인 추가
		for (int i = 0; i < list.size(); i++) {
			resutl = "";
			if (("01").equals(fclClCd) || ("02").equals(fclClCd)) {
				if (Double.valueOf(list.get(i).getCpu_use_rate()) > thrs) {
					resutl += "CPU ";
				}
				
				if (("01").equals(fclClCd)) {
					if (Double.valueOf(list.get(i).getHdd_use_rate()) > thrs) {
						resutl += "DISK ";
					}
				}else {
					if (Double.valueOf(list.get(i).getHdd_use_rate()) > thrs) {
						resutl += "DISK#1 ";
					}
					if (Double.valueOf(list.get(i).getHdd_use_rate2()) > thrs) {
						resutl += "DISK#2 ";
					}
					if (Double.valueOf(list.get(i).getHdd_use_rate3()) > thrs) {
						resutl += "DISK#3 ";
					}
				}
				
				if (Double.valueOf(list.get(i).getRam_use_rate()) > thrs) {
					resutl += "RAM ";
				}
				if (("1").equals(list.get(i).getVdo_file_yn())) {
					resutl += "VIDEO";
				}
			} else {
				if (("1").equals(list.get(i).getCheck_yn())) {
					resutl += "네트쿼크 연결 ";
				}
			}
			list.get(i).setErrResult(resutl);
		}
		result.put("list", list);
		result.put("totCnt", total);

		return result;

	}


}
