package kr.co.mcmall.cmn.web;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.cmn.service.CommonService;
import kr.co.mcmall.mcm.mal.gds.service.McmMalGds001Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.rte.fdl.property.EgovPropertyService;

/**
 * @Class Name : McmCommonController.java
 * @Description : McmCommonController Controller Class
 *                공통 컨트롤러
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2017-05-10           최초생성
 *
 * @author 개발팀
 * @since 2017-05-10
 * @version 1.0
 * @see
 *  
 */

@Controller
public class CommonController {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	@Resource(name = "mcmMalGds001Service")
	private McmMalGds001Service mcmMalGds001Service;

	
	/**
	 * 상품 이미지 다운로드
	 * @param mcmTplTpl001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmGdsMnImg.do")
	public void getViewMcmGdsImg(
			@RequestParam(value = "gdsId") String gdsId,
			@RequestParam(value = "divCd") String divCd,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		String mimeType = "application/x-msdownload; charset=utf-8";
		
		Map paramMap = new HashMap();
		paramMap.put("gdsId", gdsId);
		paramMap.put("divCd", divCd);
		
		
		String saveFileNm = "";
		String orgFileNm = "";
		if(divCd.equals("1")){
			Map fileInfoMap = mcmMalGds001Service.selectMcmMalGds001ImgInfo(paramMap);
			
			saveFileNm = (String)fileInfoMap.get("gdsAttImgPath"); 
			orgFileNm   = (String)fileInfoMap.get("gdsAttMnImg");
		}else{
			Map fileInfoMap = mcmMalGds001Service.selectMcmMalGds001ImgInfo(paramMap);
			
			saveFileNm = (String)fileInfoMap.get("gdsAttSnImgPath"); 
			orgFileNm   = (String)fileInfoMap.get("gdsAttSnImg");
			
		}
		// 테스트
		//String saveFileNm  = "/data/wasapp_upload_file/dangdang/gds/gdsId_0_20170627135833667_.jpg"; 
		//String orgFileNm   = "국화.jpg";

		File file    = new File(saveFileNm);
		int fileSize = (int)file.length();

		if (fileSize > 0) {
			try{
				response.setBufferSize(fileSize);
				response.setContentType(mimeType);
				response.setHeader("Content-Disposition", "attachment; filename=\"" + java.net.URLEncoder.encode(orgFileNm,"UTF-8") + "\"");
				response.setContentLength(fileSize);
	
				BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
				
				FileCopyUtils.copy(in, response.getOutputStream());
				in.close();
			} catch(FileNotFoundException e){
				
			}finally{
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}
			
		}
		/*
		 * else {
		 
			//setContentType을 프로젝트 환경에 맞추어 변경
			//response.setContentType("application/x-msdownload; charset=utf-8");
			response.setContentType(mimetype);
			PrintWriter printwriter = response.getWriter();
			printwriter.println("<html>");
			printwriter.println("<br><br><br><h2>Could not get file name:<br>"
					+ requestedFile + "</h2>");
			printwriter
					.println("<br><br><br><center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>");
			printwriter.println("<br><br><br>&copy; webAccess");
			printwriter.println("</html>");
			printwriter.flush();
			printwriter.close();
		}
		*/
		
	}
	@RequestMapping(value = "/McmGdsDtlImg.do")
	public void getViewMcmMalGds001M02R(@RequestParam(value="gdsId") String gdsId,
										@RequestParam(value="seqNo", required=false) String seqNo,
										ModelMap model,
										HttpSession session,
										HttpServletRequest request,
										HttpServletResponse response
										) throws Exception {
		
		String mimeType = "application/x-msdownload; charset=utf-8";
		
		Map<String,Object> paramMap = new HashMap();
		paramMap.put("gdsId", gdsId);
		paramMap.put("seqNo", seqNo);
			/*db*/
			
			Map fileInfoMap = mcmMalGds001Service.selectMcmMalGds001ImgDetailInfo(paramMap);
			
			String saveFileNm = (String) fileInfoMap.get("gdsAttImgPath");
			String orgFileNm = (String) fileInfoMap.get("gdsAttImg");
			
			File file    = new File(saveFileNm);
			int fileSize = (int)file.length();
	
			if (fileSize > 0) {
				try{
					response.setBufferSize(fileSize);
					response.setContentType(mimeType);
					response.setHeader("Content-Disposition", "attachment; filename=\"" + java.net.URLEncoder.encode(orgFileNm,"UTF-8") + "\"");
					response.setContentLength(fileSize);
		
					BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
					
					FileCopyUtils.copy(in, response.getOutputStream());
					in.close();
				} catch(FileNotFoundException e){
					
				}finally{
					response.getOutputStream().flush();
					response.getOutputStream().close();
				}
			}
		}
}
