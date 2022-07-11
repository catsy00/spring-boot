package com.kepco.facility.controller;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kepco.common.exception.IdPasswordNotMatchingException;
import com.kepco.facility.domain.CameraCheckVO;
import com.kepco.facility.domain.FacilityBarCheckDateVO;
import com.kepco.facility.domain.FacilityBarCheckVO;
import com.kepco.facility.domain.FacilityCheckDateVO;
import com.kepco.facility.domain.FacilityCheckVO;
import com.kepco.facility.domain.FacilityVO;
import com.kepco.facility.domain.ListDto;
import com.kepco.facility.domain.ListInputDto;
import com.kepco.facility.domain.reportFacilityVO;
import com.kepco.facility.domain.searchThresholdVO;
import com.kepco.facility.service.FacilityService;
import com.kepco.facility.service.FacilityServiceImpl;
import com.kepco.user.util.AuthInfo;
import com.kepco.user.util.LoginCommand;
import com.kepco.user.util.RegisterRequest;
import com.kepco.user.service.UserService;



@Controller
@RequestMapping(value = "/check")
public class FacilityController {

	private String sdate; // operation_view 화면에서 날짜를 선택하고 모달창을 눌렀을떄 동일한 날짜4에 맞는 데이터 출력
	private int flag = 0;

	@Resource(name = "facilityService")
	private FacilityService pacilitySer;

	@Resource(name = "facilityService")
	private FacilityServiceImpl facilityServiceImpl;

	@RequestMapping(value = "/operation_list", method = RequestMethod.GET)
	public ModelAndView cntFacilityGET(LoginCommand loginCommand,
			@CookieValue(value = "REMEMBER", required = false) Cookie rememberCookie) throws Exception {
		String pssCd = "D368"; // 금천변전소 변전소코드
		List<FacilityVO> result = null; // 설비 정상건수 조회
		List<FacilityCheckVO> result2 = null; // 설비 전체 에러 정보 조회
		List<searchThresholdVO> result5 = null; // 임계치값

		result5 = pacilitySer.searchThreshold(pssCd);

		double thVal1 = 0; // 임계치1
		double thVal2 = 0; // 임계치2

		for (int i = 0; i < result5.size(); i++) {
			if (result5.get(i).getFCL_CL_CD().equals("01")) {
				thVal1 = Double.parseDouble(result5.get(i).getTHRS_VAL());

			} else if (result5.get(i).getFCL_CL_CD().equals("02")) {
				thVal1 = Double.parseDouble(result5.get(i).getTHRS_VAL());
			} else {
				thVal1 = 90.0;
				thVal2 = 90.0;
			}
		}

		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("pssCd", pssCd);
		map.put("thVal1", thVal1);
		map.put("thVal2", thVal2);

		result = pacilitySer.cntFacility(map);
		result2 = pacilitySer.cntCheckFacility(map);

		ModelAndView mav = new ModelAndView();

		mav.setViewName("/facility/check/operation_list");
		mav.addObject("result", result);
		mav.addObject("result2", result2);
		mav.addObject("result5", result5);

		return mav;
	}

	@RequestMapping(value = "/select", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> select(HttpServletRequest request) throws Exception {

		String pssCd = "D368"; // 금천변전소 변전소코드
		List<FacilityVO> result = null; // 설비 총건수 조회
		List<FacilityCheckVO> result2 = null; // 설비 전체 에러 정보 조회
		List<searchThresholdVO> result5 = null; // 임계치값

		Map<String, Object> mav = new HashMap<String, Object>();
		result5 = pacilitySer.searchThreshold(pssCd);

		double thVal1 = 0; // 임계치1
		double thVal2 = 0; // 임계치2

		for (int i = 0; i < result5.size(); i++) {
			if (result5.get(i).getFCL_CL_CD().equals("01")) {
				thVal1 = Double.parseDouble(result5.get(i).getTHRS_VAL());

			} else if (result5.get(i).getFCL_CL_CD().equals("02")) {
				thVal1 = Double.parseDouble(result5.get(i).getTHRS_VAL());
			} else {
				thVal1 = 90.0;
				thVal2 = 90.0;
			}
		}

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pssCd", pssCd);
		map.put("thVal1", thVal1);
		map.put("thVal2", thVal2);

		result = pacilitySer.cntFacility(map);
		System.out.println("controller map : " + map);
		result2 = pacilitySer.cntCheckFacility(map);

		mav.put("result", result);
		mav.put("result2", result2);
		mav.put("result5", result5);
		return mav;

	}

	// 처음 접속할떄
	@RequestMapping(value = "/operation_view", method = RequestMethod.GET)
	public ModelAndView cntDetailPacilityGET(LoginCommand loginCommand,
			@CookieValue(value = "REMEMBER", required = false) Cookie rememberCookie) throws Exception {

		String pssCd = "D368"; // 금천변전소 변전소코드
		List<FacilityVO> result = null; // 설비 총건수 조회
		List<FacilityCheckVO> result2 = null; // 설비 전체 에러 정보 조회
		List<FacilityBarCheckVO> result3 = null; // operation_view 모달창 bar게이지 정보 조회
		List<CameraCheckVO> result4 = null; // operation_view 모달창 카메라에러 정보 조회
		List<searchThresholdVO> result5 = null; // 임계치값
		List<CameraCheckVO> reader = null; // 출입리더기 장애정보
		List<CameraCheckVO> alter = null; // 경보주장치 장애정보
		List<CameraCheckVO> camVdo = null; // 카메라 실시간 녹화 파일 장애 정보


		result5 = pacilitySer.searchThreshold(pssCd);

		double thVal1 = 0; // 임계치1
		double thVal2 = 0; // 임계치2

		for (int i = 0; i < result5.size(); i++) {
			if (result5.get(i).getFCL_CL_CD().equals("01")) {
				thVal1 = Double.parseDouble(result5.get(i).getTHRS_VAL());

			} else if (result5.get(i).getFCL_CL_CD().equals("02")) {
				thVal1 = Double.parseDouble(result5.get(i).getTHRS_VAL());
			} else {
				thVal1 = 90.0;
				thVal2 = 90.0;
			}
		}

		sdate = "";

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pssCd", pssCd);
		map.put("thVal1", thVal1);
		map.put("thVal2", thVal2);

		result = pacilitySer.cntTotFacility(map);
		result2 = pacilitySer.cntCheckFacility(map);
		result3 = pacilitySer.checkBarFacility(map);
		result4 = pacilitySer.checkCamera(map);
		reader =  pacilitySer.checkReader(map);
		alter =  pacilitySer.checkAlter(map);
		camVdo =  pacilitySer.checkCameraVdo(map);
		
		int cameCnt = 0;
		int cameCnt2 = 0;
		for (int j = 0; j < result2.size(); j++) {
			cameCnt = result2.get(j).getCCHECK2();
		}

		for (int j = 0; j < result2.size(); j++) {
			cameCnt2 = result2.get(j).getVdoFileCHECK();
		}
		//String cameraJson =result4.toString();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("/facility/check/operation_view");
		mv.addObject("result", result);
		mv.addObject("result2", result2);
		mv.addObject("result3", result3);
		mv.addObject("cameCnt", cameCnt);
		mv.addObject("cameCnt2", cameCnt2);
		mv.addObject("cameraJson", result4);
		mv.addObject("reader", reader);
		mv.addObject("readerCnt", reader.size());
		mv.addObject("alter", alter);
		mv.addObject("alterCnt", alter.size());
		mv.addObject("camVdo", camVdo);
		mv.addObject("camVdoCnt", camVdo.size());
		
		return mv;
	}

	// 날짜선택해서 들어올때
	@RequestMapping(value = "/operation_view_Date", method = RequestMethod.GET)
	public ModelAndView cntDetailPacilityGET3(LoginCommand loginCommand,
			@CookieValue(value = "REMEMBER", required = false) Cookie rememberCookie, String date) throws Exception {
		String pssCd = "D368"; // 금천변전소 변전소코드
		List<FacilityVO> result = null; // 설비 총건수 조회
		List<FacilityCheckDateVO> result2 = null; // 설비 전체 에러 정보 조회
		List<FacilityBarCheckDateVO> result3 = null; // operation_view 모달창 bar게이지 정보 조회
		List<CameraCheckVO> result4 = null; // operation_view 모달창 카메라에러 정보 조회
		List<CameraCheckVO> reader = null; // 출입리더기 장애정보
		List<CameraCheckVO> alter = null; // 경보주장치 장애정보
		List<CameraCheckVO> camVdo = null; // 카메라 실시간 녹화 파일 장애 정보

		System.out.println("상세조회 date : " + date);

		sdate = date; // operation_view 화면에서 날짜를 선택하고 모달창을 눌렀을떄 동일한 날짜에 맞는 데이터 출력

		List<searchThresholdVO> result5 = null; // 임계치값
		result5 = pacilitySer.searchThreshold(pssCd);

		double thVal1 = 0; // 임계치1
		double thVal2 = 0; // 임계치2

		for (int i = 0; i < result5.size(); i++) {
			if (result5.get(i).getFCL_CL_CD().equals("01")) {
				thVal1 = Double.parseDouble(result5.get(i).getTHRS_VAL());

			} else if (result5.get(i).getFCL_CL_CD().equals("02")) {
				thVal2 = Double.parseDouble(result5.get(i).getTHRS_VAL());
			} else {
				thVal1 = 90.0;
				thVal2 = 90.0;
			}
		}

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pssCd", pssCd);
		map.put("thVal1", thVal1);
		map.put("thVal2", thVal2);
		map.put("date", date);

		result = pacilitySer.cntTotFacility(map);
		result2 = pacilitySer.cntCheckDateFacility(map);
		result3 = pacilitySer.checkBarDateFacility(map);
		result4 = pacilitySer.checkDateCamera(map);
		reader =  pacilitySer.checkDateReader(map);
		alter =  pacilitySer.checkDateAlter(map);
		camVdo =  pacilitySer.checkDateCameraVdo(map);
		
		int cameCnt = 0;
		int cameCnt2 = 0;
		for (int j = 0; j < result2.size(); j++) {
			cameCnt = result2.get(j).getCCHECK2();
		}

		for (int j = 0; j < result2.size(); j++) {
			cameCnt2 = result2.get(j).getVdoFileCHECK();
		}

		//String cameraJson = result4.toString();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("/facility/check/operation_view");
		mv.addObject("result", result);
		mv.addObject("result2", result2);
		mv.addObject("sdate", sdate);
		mv.addObject("result3", result3);
		mv.addObject("cameCnt", cameCnt);
		mv.addObject("cameCnt2", cameCnt2);
		mv.addObject("cameraJson", result4);
		mv.addObject("reader", reader);
		mv.addObject("readerCnt", reader.size());
		mv.addObject("alter", alter);
		mv.addObject("alterCnt", alter.size());
		mv.addObject("camVdo", camVdo);
		mv.addObject("camVdoCnt", camVdo.size());
		
		return mv;
	}

	// 모달창 상세 날짜를 선택해서 들어올때
	@ResponseBody
	@RequestMapping(value = "/operation_view_Detail_Date", method = RequestMethod.POST)
	public ModelAndView cntDetailPacilityGET2(LoginCommand loginCommand,
			@CookieValue(value = "REMEMBER", required = false) Cookie rememberCookie, String date) throws Exception {
		System.out.println("/////operation_view_Detail_Date//// : ");
		
		String pssCd = "D368"; // 금천변전소 변전소코드
		List<FacilityVO> result = null; // 설비 총건수 조회
		List<FacilityCheckDateVO> result2 = null; // 설비 전체 에러 정보 조회
		List<FacilityBarCheckDateVO> result3 = null; // operation_view 모달창 bar게이지 정보 조회
		List<CameraCheckVO> result4 = null; // operation_view 모달창 카메라에러 정보 조회
		List<CameraCheckVO> reader = null; // 출입리더기 장애정보
		List<CameraCheckVO> alter = null; // 경보주장치 장애정보
		List<CameraCheckVO> camVdo = null; // 카메라 실시간 녹화 파일 장애 정보

		sdate = date; // operation_view 화면에서 날짜를 선택하고 모달창을 눌렀을떄 동일한 날짜에 맞는 데이터 출력
		System.out.println(" operation_view_Detail_Date sdate: " +  sdate);
		List<searchThresholdVO> result5 = null; // 임계치값
		result5 = pacilitySer.searchThreshold(pssCd);

		double thVal1 = 0; // 임계치1
		double thVal2 = 0; // 임계치2

		for (int i = 0; i < result5.size(); i++) {
			if (result5.get(i).getFCL_CL_CD().equals("01")) {
				thVal1 = Double.parseDouble(result5.get(i).getTHRS_VAL());

			} else if (result5.get(i).getFCL_CL_CD().equals("02")) {
				thVal2 = Double.parseDouble(result5.get(i).getTHRS_VAL());
			} else {
				thVal1 = 90.0;
				thVal2 = 90.0;
			}
		}

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pssCd", pssCd);
		map.put("thVal1", thVal1);
		map.put("thVal2", thVal2);
		map.put("date", date);

		result = pacilitySer.cntTotFacility(map);
		result2 = pacilitySer.cntCheckDateFacility(map);
		result3 = pacilitySer.checkBarDateFacility(map);
		result4 = pacilitySer.checkDateCamera(map);
		reader =  pacilitySer.checkDateReader(map);
		alter =  pacilitySer.checkDateAlter(map);
		camVdo =  pacilitySer.checkDateCameraVdo(map);
		
		flag = 1;

		int cameCnt = 0;
		int cameCnt2 = 0;
		for (int j = 0; j < result2.size(); j++) {
			cameCnt = result2.get(j).getCCHECK();
		}

		for (int j = 0; j < result2.size(); j++) {
			cameCnt2 = result2.get(j).getVdoFileCHECK();
		}

		//String cameraJson = result4.toString();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/facility/check/operation_view");
		mv.addObject("result", result);
		mv.addObject("result2", result2);
		mv.addObject("modal", flag);
		mv.addObject("sdate", sdate);
		mv.addObject("result3", result3);
		mv.addObject("cameCnt", cameCnt);
		mv.addObject("cameCnt2", cameCnt2);
		mv.addObject("cameraJson", result4);
		mv.addObject("reader", reader);
		mv.addObject("readerCnt", reader.size());
		mv.addObject("alter", alter);
		mv.addObject("alterCnt", alter.size());
		mv.addObject("camVdo", camVdo);
		mv.addObject("camVdoCnt", camVdo.size());
		
		return mv;
	}
	

	//ajax 모달용
	@RequestMapping(value = "/operation_view_modal", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> selectOperationView(HttpServletRequest request) throws Exception {
		Map<String, Object> mainResult = new HashMap<String, Object>();
		
		String pssCd = "D368"; // 금천변전소 변전소코드
		List<FacilityVO> result = null; // 설비 총건수 조회
		List<FacilityCheckDateVO> result2 = null; // 설비 전체 에러 정보 조회
		List<FacilityBarCheckDateVO> result3 = null; // operation_view 모달창 bar게이지 정보 조회
		List<CameraCheckVO> result4 = null; // operation_view 모달창 카메라에러 정보 조회
		List<CameraCheckVO> reader = null; // 출입리더기 장애정보
		List<CameraCheckVO> alter = null; // 경보주장치 장애정보
		List<CameraCheckVO> camVdo = null; // 카메라 실시간 녹화 파일 장애 정보
		
		sdate = request.getParameter("date"); // operation_view 화면에서 날짜를 선택하고 모달창을 눌렀을떄 동일한 날짜에 맞는 데이터 출력
	
		System.out.println("상세조회 date : " + sdate);
		List<searchThresholdVO> result5 = null; // 임계치값
		result5 = pacilitySer.searchThreshold(pssCd);

		double thVal1 = 0; // 임계치1
		double thVal2 = 0; // 임계치2

		for (int i = 0; i < result5.size(); i++) {
			if (result5.get(i).getFCL_CL_CD().equals("01")) {
				thVal1 = Double.parseDouble(result5.get(i).getTHRS_VAL());

			} else if (result5.get(i).getFCL_CL_CD().equals("02")) {
				thVal2 = Double.parseDouble(result5.get(i).getTHRS_VAL());
			} else {
				thVal1 = 90.0;
				thVal2 = 90.0;
			}
		}

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pssCd", pssCd);
		map.put("thVal1", thVal1);
		map.put("thVal2", thVal2);
		map.put("date", sdate);

		result = pacilitySer.cntTotFacility(map);
		result2 = pacilitySer.cntCheckDateFacility(map);
		result3 = pacilitySer.checkBarDateFacility(map);
		result4 = pacilitySer.checkDateCamera(map);
		reader =  pacilitySer.checkDateReader(map);
		alter =  pacilitySer.checkDateAlter(map);
		camVdo =  pacilitySer.checkDateCameraVdo(map);
		
		
		flag = 1;

		int cameCnt = 0;
		int cameCnt2 = 0;
		for (int j = 0; j < result2.size(); j++) {
			cameCnt = result2.get(j).getCCHECK();
		}

		for (int j = 0; j < result2.size(); j++) {
			cameCnt2 = result2.get(j).getVdoFileCHECK();
		}
		
		mainResult.put("result", result);
		mainResult.put("result2", result2);
		mainResult.put("modal", flag);
		mainResult.put("sdate", sdate);
		mainResult.put("result3", result3);
		mainResult.put("cameCnt", cameCnt);
		mainResult.put("cameCnt2", cameCnt2);
		mainResult.put("cameraJson", result4);
		mainResult.put("reader", reader);
		mainResult.put("alter", alter);
		mainResult.put("camVdo", camVdo);
		
		return mainResult;
	}

	@RequestMapping(value = "/operation_view_Date", method = RequestMethod.POST)
	public ModelAndView cntDetailPacilityPOST(LoginCommand loginCommand,
			@CookieValue(value = "REMEMBER", required = false) Cookie rememberCookie, String date) throws Exception {
		String pssCd = "D368";
		List<FacilityCheckDateVO> result = null;

		List<searchThresholdVO> result5 = null; // 임계치값
		result5 = pacilitySer.searchThreshold(pssCd);

		double thVal1 = 0; // 임계치1
		double thVal2 = 0; // 임계치2

		for (int i = 0; i < result5.size(); i++) {
			if (result5.get(i).getFCL_CL_CD().equals("01")) {
				thVal1 = Double.parseDouble(result5.get(i).getTHRS_VAL());

			} else if (result5.get(i).getFCL_CL_CD().equals("02")) {
				thVal2 = Double.parseDouble(result5.get(i).getTHRS_VAL());
			} else {
				thVal1 = 90f;
				thVal2 = 90f;
			}
		}

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pssCd", pssCd);
		map.put("thVal1", thVal1);
		map.put("thVal2", thVal2);
		map.put("date", date);

		result = pacilitySer.cntCheckDateFacility(map);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("/facility/check/operation_view");
		mv.addObject("result", result);
		return mv;
	}
	
	@Resource(name="userService")
	private UserService userSer;

	@GetMapping("/download")
	public void excelDownload(HttpServletRequest request, HttpServletResponse response, String date,HttpSession session, LoginCommand loginCommand)
			throws IOException {

		String pssCd = "D368"; // 금천변전소 변전소코드
		String hdqrCd = "2450"; // 광주전남본부 본부코드
		int idx = 0;
		
		AuthInfo authInfo = null;
		try {
			authInfo = userSer.loginAuth(loginCommand);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		//session.setAttribute("authInfo", authInfo);
		//System.out.println(" userName : " +  session.getAttribute("userName"));


		// 날짜데이터 처리
		if (date.equals("")) {
			if (sdate == null || sdate == "") {
				idx = 1;
				date = "now()"; // operation_view , 모달창에서 아무런 날짜를 입력받지 못하면 현재시간 기준으로 엑셀추출
			} else {
				date = sdate; // operation_view , 모달창에서 아무런 날짜를 입력받으면 해당 날짜에 맞게 엑셀추출
			}
		}

		List<searchThresholdVO> result5 = null; // 임계치값
		try {
			result5 = pacilitySer.searchThreshold(pssCd);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		double thVal1 = 0; // 임계치1
		double thVal2 = 0; // 임계치2

		for (int i = 0; i < result5.size(); i++) {
			if (result5.get(i).getFCL_CL_CD().equals("01")) {
				thVal1 = Double.parseDouble(result5.get(i).getTHRS_VAL());
			} else if (result5.get(i).getFCL_CL_CD().equals("02")) {
				thVal1 = Double.parseDouble(result5.get(i).getTHRS_VAL());
			} else {
				thVal1 = 90.0;
				thVal2 = 90.0;
			}
		}

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("hdqrCd", hdqrCd);
		map.put("thVal1", thVal1);
		map.put("thVal2", thVal2);
		map.put("date", date);

		// 엑셀양식가져오기 테스트
		String fileName = "";
		request.setCharacterEncoding("EUC-KR");

		String formPath = request.getSession().getServletContext().getRealPath("/resources/static/excel/report1.xlsx");
		InputStream fis = new FileInputStream(formPath);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date time = new Date();
		String time1 = format.format(time);

		List<reportFacilityVO> result = null;

		try {
			if (idx == 1) {
				result = pacilitySer.reportFacility1(map);
			} else {
				result = pacilitySer.reportFacility1_1(map);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheetAt(0);
//        Sheet sheet = wb.createSheet("광주전남본부_점검보고서_테스트");
		Row row = null;
		Cell cell = null;
		int rowNum = 9;

		// 폰트 설정
		Font RedBold1 = wb.createFont();
		RedBold1.setFontName("나눔고딕"); // 글씨체
		RedBold1.setBold(true);
		RedBold1.setFontHeight((short) (14 * 20)); // 사이즈
		RedBold1.setUnderline((byte) 1);

		CellStyle bodyStyle = wb.createCellStyle();
		bodyStyle.setAlignment(HorizontalAlignment.CENTER);
		bodyStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		bodyStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);

		CellStyle headerStyle = wb.createCellStyle();
		headerStyle.setAlignment(HorizontalAlignment.LEFT);
		headerStyle.setVerticalAlignment(VerticalAlignment.TOP);
		headerStyle.setFillForegroundColor(HSSFColorPredefined.GREY_80_PERCENT.getIndex());
		headerStyle.setBorderTop(BorderStyle.MEDIUM);

		row = sheet.createRow(rowNum++);

		for (reportFacilityVO exData : result) {
			row = sheet.createRow(rowNum++);
			cell = row.createCell(0);
			cell.setCellValue(rowNum - 10);
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(1);
			cell.setCellValue(exData.getCHK_DT());
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(2);
			cell.setCellValue(exData.getPower_bizp_nm());
			cell = row.createCell(3);
			cell.setCellValue(exData.getPSS_NM());
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(4);
			cell.setCellValue(exData.getFcl_NM());
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(6);
			cell.setCellValue(exData.getStatus());
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(7);
			cell.setCellValue(exData.getCpu_use_qnt());
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(8);
			cell.setCellValue(exData.getRam_use_qnt());
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(9);
			cell.setCellValue(exData.getHdd_use_qnt());
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(10);
			cell.setCellValue(exData.getStatusCheck());
			cell.setCellStyle(bodyStyle);
			sheet.getRow(2).createCell(1).setCellValue(exData.getHDQR_NM());
			sheet.getRow(4).createCell(1).setCellValue(session.getAttribute("userName").toString());
			sheet.getRow(4).createCell(3).setCellValue(time1);

		}
		// 컨텐츠 타입과 파일명 지정
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment;filename=excelDown1.xlsx");

		// Excel File Output
		wb.write(response.getOutputStream());
		wb.close();
	}

	@GetMapping("/download2")
	public void excelDownload2(HttpServletRequest request, HttpServletResponse response, String date, HttpSession session, LoginCommand loginCommand)
			throws IOException {

		String pssCd = "D368"; // 금천변전소 변전소코드
		String hdqrCd = "2450"; // 광주전남본부 본부코드
		String powBizpCd = "2461"; // 직할지사 지사코드
		int idx = 0;

		AuthInfo authInfo = null;
		try {
			authInfo = userSer.loginAuth(loginCommand);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		//session.setAttribute("authInfo", authInfo);
		
		System.out.println("downLoad2 sdate : " + sdate);
		// 날짜데이터 처리
		if (date.equals("")) {
			if (sdate == null || sdate == "") {
				idx = 1;
				date = "now()"; // operation_view , 모달창에서 아무런 날짜를 입력받지 못하면 현재시간 기준으로 엑셀추출
			} else {
				date = sdate; // operation_view , 모달창에서 아무런 날짜를 입력받으면 해당 날짜에 맞게 엑셀추출
			}
		}

		List<searchThresholdVO> result5 = null; // 임계치값

		try {
			result5 = pacilitySer.searchThreshold(pssCd);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		double thVal1 = 0; // 임계치1
		double thVal2 = 0; // 임계치2

		for (int i = 0; i < result5.size(); i++) {
			if (result5.get(i).getFCL_CL_CD().equals("01")) {
				thVal1 = Double.parseDouble(result5.get(i).getTHRS_VAL());

			} else if (result5.get(i).getFCL_CL_CD().equals("02")) {
				thVal1 = Double.parseDouble(result5.get(i).getTHRS_VAL());
			} else {
				thVal1 = 90.0;
				thVal2 = 90.0;
			}
		}

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("hdqrCd", hdqrCd);
		map.put("thVal1", thVal1);
		map.put("thVal2", thVal2);
		map.put("powBizpCd", powBizpCd);
		map.put("date", date);

		System.out.println("download2 controller map : " + map);

		// 엑셀양식가져오기 테스트
		String fileName = "";
		request.setCharacterEncoding("EUC-KR");

		String formPath = request.getSession().getServletContext().getRealPath("/resources/static/excel/report2.xlsx");
		InputStream fis = new FileInputStream(formPath);
		// getServletContext().getRealPath("excel/sample.xlsx");

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date time = new Date();
		String time1 = format.format(time);

		List<reportFacilityVO> result = null;

		try {
			if (idx == 1) {
				result = pacilitySer.reportFacility2(map);
			} else {
				result = pacilitySer.reportFacility2_1(map);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheetAt(0);
//        Sheet sheet = wb.createSheet("전력지사별_점검보고서");
		Row row = null;
		Cell cell = null;
		int rowNum = 9;

		// 폰트 설정
		Font RedBold1 = wb.createFont();
		RedBold1.setFontName("나눔고딕"); // 글씨체
		RedBold1.setBold(true);
		RedBold1.setFontHeight((short) (14 * 20)); // 사이즈
		RedBold1.setUnderline((byte) 1);

		CellStyle bodyStyle = wb.createCellStyle();
		bodyStyle.setAlignment(HorizontalAlignment.CENTER);
		bodyStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		bodyStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);

		CellStyle headerStyle = wb.createCellStyle();
		headerStyle.setAlignment(HorizontalAlignment.LEFT);
		headerStyle.setVerticalAlignment(VerticalAlignment.TOP);
		headerStyle.setFillForegroundColor(HSSFColorPredefined.GREY_80_PERCENT.getIndex());
		headerStyle.setBorderTop(BorderStyle.MEDIUM);

		row = sheet.createRow(rowNum++);

		for (reportFacilityVO exData : result) {
			row = sheet.createRow(rowNum++);
			cell = row.createCell(0);
			cell.setCellValue(rowNum - 10);
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(1);
			cell.setCellValue(exData.getCHK_DT());
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(2);
			cell.setCellValue(exData.getPSS_NM());
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(3);
			cell.setCellValue(exData.getFcl_NM());
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(6);
			cell.setCellValue(exData.getStatus());
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(7);
			cell.setCellValue(exData.getCpu_use_qnt());
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(8);
			cell.setCellValue(exData.getRam_use_qnt());
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(9);
			cell.setCellValue(exData.getHdd_use_qnt());
			cell.setCellStyle(bodyStyle);
			sheet.getRow(2).createCell(1).setCellValue(exData.getHDQR_NM());
			sheet.getRow(4).createCell(1).setCellValue(session.getAttribute("userName").toString());
			sheet.getRow(2).createCell(3).setCellValue(exData.getPower_bizp_nm());
			sheet.getRow(4).createCell(3).setCellValue(time1);
		}

		// 컨텐츠 타입과 파일명 지정
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment;filename=excelDown2.xlsx");

		// Excel File Output
		wb.write(response.getOutputStream());
		wb.close();
	}

	@GetMapping("/download3")
	public void excelDownload3(HttpServletRequest request, HttpServletResponse response, String date, HttpSession session, LoginCommand loginCommand)
			throws IOException {
		int idx = 0;
		String pssCd = "D368"; // 금천변전소 변전소코드
		String hdqrCd = "2450"; // 광주전남본부 본부코드
		String powBizpCd = "2461"; // 직할지사 지사코드
		
		AuthInfo authInfo = null;
		try {
			authInfo = userSer.loginAuth(loginCommand);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		//session.setAttribute("authInfo", authInfo);

		if (date.equals("")) {
			if (sdate == null || sdate == "") {
				idx = 1;
				date = "now()"; // operation_view , 모달창에서 아무런 날짜를 입력받지 못하면 현재시간 기준으로 엑셀추출
			} else {
				date = sdate; // operation_view , 모달창에서 아무런 날짜를 입력받으면 해당 날짜에 맞게 엑셀추출
			}
		}

		List<searchThresholdVO> result5 = null; // 임계치값
		try {
			result5 = pacilitySer.searchThreshold(pssCd);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		double thVal1 = 0; // 임계치1
		double thVal2 = 0; // 임계치2

		for (int i = 0; i < result5.size(); i++) {
			if (result5.get(i).getFCL_CL_CD().equals("01")) {
				thVal1 = Double.parseDouble(result5.get(i).getTHRS_VAL());

			} else if (result5.get(i).getFCL_CL_CD().equals("02")) {
				thVal1 = Double.parseDouble(result5.get(i).getTHRS_VAL());
			} else {
				thVal1 = 90.0;
				thVal2 = 90.0;
			}
		}

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("hdqrCd", hdqrCd);
		map.put("thVal1", thVal1);
		map.put("thVal2", thVal2);
		map.put("powBizpCd", powBizpCd);
		map.put("pssCd", pssCd);
		map.put("date", date);

		// 엑셀양식가져오기 테스트
		String fileName = "";
		request.setCharacterEncoding("EUC-KR");

		String formPath = request.getSession().getServletContext().getRealPath("/resources/static/excel/report3.xlsx");
		InputStream fis = new FileInputStream(formPath);
		// getServletContext().getRealPath("excel/sample.xlsx");

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date time = new Date();
		String time1 = format.format(time);

		List<reportFacilityVO> result = null;

		try {
			if (idx == 1) {
				result = pacilitySer.reportFacility3(map);
			} else {
				result = pacilitySer.reportFacility3_1(map);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheetAt(0);
		Row row = null;
		Cell cell = null;
		int rowNum = 9;

		// 폰트 설정
		Font RedBold1 = wb.createFont();
		RedBold1.setFontName("나눔고딕"); // 글씨체
		RedBold1.setBold(true);
		RedBold1.setFontHeight((short) (14 * 20)); // 사이즈
		RedBold1.setUnderline((byte) 1);

		CellStyle bodyStyle = wb.createCellStyle();
		bodyStyle.setAlignment(HorizontalAlignment.CENTER);
		bodyStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		bodyStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);

		CellStyle headerStyle = wb.createCellStyle();
		headerStyle.setAlignment(HorizontalAlignment.LEFT);
		headerStyle.setVerticalAlignment(VerticalAlignment.TOP);
		headerStyle.setFillForegroundColor(HSSFColorPredefined.GREY_80_PERCENT.getIndex());
		headerStyle.setBorderTop(BorderStyle.MEDIUM);

		row = sheet.createRow(rowNum++);

		for (reportFacilityVO exData : result) {
			row = sheet.createRow(rowNum++);
			cell = row.createCell(0);
			cell.setCellValue(rowNum - 10);
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(1);
			cell.setCellValue(exData.getCHK_DT());
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(2);
			cell.setCellValue(exData.getPSS_NM());
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(3);
			cell.setCellValue(exData.getFcl_NM());
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(6);
			cell.setCellValue(exData.getStatus());
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(7);
			cell.setCellValue(exData.getCpu_use_qnt());
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(8);
			cell.setCellValue(exData.getRam_use_qnt());
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(9);
			cell.setCellValue(exData.getHdd_use_qnt());
			cell.setCellStyle(bodyStyle);
			sheet.getRow(2).createCell(1).setCellValue(exData.getHDQR_NM());
			sheet.getRow(4).createCell(1).setCellValue(session.getAttribute("userName").toString());
			sheet.getRow(2).createCell(3).setCellValue(exData.getPower_bizp_nm());
			sheet.getRow(4).createCell(3).setCellValue(time1);
		}

		// 컨텐츠 타입과 파일명 지정
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment;filename=excelDown3.xlsx");

		// Excel File Output
		wb.write(response.getOutputStream());
		wb.close();
	}

	@RequestMapping(value = "/operation_view", method = RequestMethod.POST)
	public ModelAndView cntDetailPacilityPOST(@Valid LoginCommand loginCommand, BindingResult bindingResult,
			HttpSession session, HttpServletResponse response) throws Exception {

		ModelAndView mv = new ModelAndView();

		System.out.println("operation_view로 POST 이동");

		if (bindingResult.hasErrors()) {
			System.out.println("에러나서 pacility list로 이동");
			mv.setViewName("/check/operation_list");
			return mv;
		}

		try {
			Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getId());
			rememberCookie.setPath("/");
			
			if (loginCommand.isRememberId()) {
				rememberCookie.setMaxAge(60 * 60 * 24 * 7);
			} else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);

		} catch (IdPasswordNotMatchingException e) {
			bindingResult.rejectValue("password", "notMatch", "���̵�� ��й�ȣ�� �����ʽ��ϴ�.");
			mv.setViewName("/user/loginForm2");
			return mv;
		}
		
		mv.setViewName("redirect:/check/operation_view");
		return mv;
	}

	@RequestMapping(value = "/real_list", method = RequestMethod.POST)
	public ModelAndView real_listPost(@RequestParam(value = "agree", defaultValue = "false") Boolean agree)
			throws Exception {

		ModelAndView mv = new ModelAndView();
		agree = true;
		System.out.println("real_list post방식으로 접근(facility Controller");

		mv.setViewName("/facility/check/real_list");
		mv.addObject("registerRequest", new RegisterRequest());
		return mv;

	}

	@RequestMapping(value = "/real_list", method = RequestMethod.GET)
	public ModelAndView real_listGet(@RequestParam(value = "agree", defaultValue = "false") Boolean agree)
			throws Exception {

		ModelAndView mv = new ModelAndView();
		agree = true;

		System.out.println("real_list get방식으로 접근");

		mv.setViewName("/facility/check/real_list");
		mv.addObject("registerRequest", new RegisterRequest());
		return mv;

	}

}