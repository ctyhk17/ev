package kr.co.mcmall.mcm.cmn.lgn.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.cmn.service.UserInfoVO;
import kr.co.mcmall.mcm.cmn.lgn.service.McmCmnLgn001Service;
import kr.co.mcmall.mcm.cmn.lgn.service.McmCmnLgn001VO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : FmsCmnLgn001ServiceImpl.java
 * @Description : FmsCmnLgn001ServiceImpl Service Implements Class
 *                로그인 인터페이스
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

@Service("mcmCmnLgn001Service")
public class McmCmnLgn001ServiceImpl extends EgovAbstractServiceImpl implements McmCmnLgn001Service {

	/** DAO 선언 */
	@Resource(name = "mcmCmnLgn001DAO")
	private McmCmnLgn001DAO mcmCmnLgn001DAO;

	
	/**
	 * 로그인 정보 조회
	 */
	public Map<?,?> selectUsrInfo(McmCmnLgn001VO mcmCmnLgn001VO) throws Exception{
		return mcmCmnLgn001DAO.selectUsrInfo(mcmCmnLgn001VO);
	}
	
	
	/**
	 * 로그인 처리
	 */
	public void procLoginInfo(HttpSession session, Map loginInfoMap) throws Exception{
		
		UserInfoVO userInfoVO = new UserInfoVO();
		
		userInfoVO.setUsrId((String)loginInfoMap.get("usrId"));
		userInfoVO.setUsrNm((String)loginInfoMap.get("usrNm"));
		userInfoVO.setTelNo((String)loginInfoMap.get("telNo"));
		userInfoVO.setEmailAddr((String)loginInfoMap.get("emailAddr"));
		
		
		
		List<?> athCdList = selectAthCdList(userInfoVO.getUsrId());

		// 권한 목록 설정
		userInfoVO.setAthCdList(athCdList);
		
		
		// 권한 맵 설정
		
		
		if(athCdList != null)
		{
			Map<String,String> athCdMap = new HashMap<String,String>();
			
			for(int i=0; i<athCdList.size(); i++)
			{
				String athCd = (String)((Map<?,?>)athCdList.get(i)).get("athCd");
				
				athCdMap.put(athCd, athCd);
			}
			
			userInfoVO.setAthCdMap(athCdMap);
		}
		
		session.setAttribute("userInfoVO", userInfoVO);
		
	}
	
	
	/**
	 * 권한 목록 조회
	 */
	public List<?> selectAthCdList(String usrId) throws Exception{
		return mcmCmnLgn001DAO.selectAthCdList(usrId);
	}
	
	
	/**
	 * ID 중복확인
	 * @param 
	 * @return
	 * @throws Exception
	 */
	public String selectExistsId(String usrId) throws Exception{
		return mcmCmnLgn001DAO.selectExistsId(usrId);
	}
	
	
	/**
	 * 사용자 아이디 목록 조회
	 */
	public List<?> selectUsrIdList(McmCmnLgn001VO mcmCmnLgn001VO) throws Exception{
		return mcmCmnLgn001DAO.selectUsrIdList(mcmCmnLgn001VO);
	}
	
	
	/**
	 * 임시비밀번호 업데이트
	 */
	public void updateTmpUsrPwd(Map<?,?> paramMap) throws Exception{
		mcmCmnLgn001DAO.updateTmpUsrPwd(paramMap);
	}
	
	
	
	public Map <?,?> selectUsrInfoForPwd(McmCmnLgn001VO mcmCmnLgn001VO) throws Exception{
		return mcmCmnLgn001DAO.selectUsrInfoForPwd(mcmCmnLgn001VO);
	}
	
	
	
	
	
	
	
	
	

}
