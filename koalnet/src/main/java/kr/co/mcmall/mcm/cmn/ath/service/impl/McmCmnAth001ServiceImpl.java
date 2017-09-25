package kr.co.mcmall.mcm.cmn.ath.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.mcmall.mcm.cmn.ath.service.McmCmnAth001Service;
import kr.co.mcmall.mcm.cmn.ath.service.McmCmnAth002VO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : FundTpltServiceImpl.java
 * @Description : FundTplt Service Implements Class
 *                템플릿 인터페이스 구현 클래스
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

@Service("mcmCmnAth001Service")
public class McmCmnAth001ServiceImpl extends EgovAbstractServiceImpl implements McmCmnAth001Service {

	/** DAO 선언 */
	@Resource(name = "mcmCmnAth001DAO")
	private McmCmnAth001DAO mcmCmnAth001DAO;

	
	
	/**
	 * 권한코드 목록조회
	 * @param mcmCmnAth002VO - 조회할 정보가 담긴 VO
	 * @return 목록
	 * @exception Exception
	 */
	public List<?> selectMcmCmnAth002M01List(McmCmnAth002VO mcmCmnAth002VO) throws Exception{
		return mcmCmnAth001DAO.selectMcmCmnAth002M01List(mcmCmnAth002VO);
	}

	/**
	 * 목록 갯수 조회 
	 * @param mcmCmnAth002VO - 조회할 정보가 담긴 VO
	 * @return 목록 총 갯수
	 * @exception
	 */
	public int selectTemplatetListTotCnt(McmCmnAth002VO mcmCmnAth002VO){
		return mcmCmnAth001DAO.selectTemplatetListTotCnt(mcmCmnAth002VO);
	}
	

	/**
	 * 상세내용을 조회한다.
	 * @param mcmCmnAth002VO - 조회할 정보가 담긴 mcmCmnAth002VO
	 * @return  상세정보
	 * @exception Exception
	 */
	public Map<?, ?> selectTemplatetInfo(McmCmnAth002VO mcmCmnAth002VO) throws Exception{
		return mcmCmnAth001DAO.selectTemplatetInfo(mcmCmnAth002VO);
	}

	
	/**
	 * 정보을 등록한다.
	 * @param mcmCmnAth002VO
	 * @return
	 * @throws Exception
	 */
	public String insertTemplatetInfo(McmCmnAth002VO mcmCmnAth002VO) throws Exception{
		return mcmCmnAth001DAO.insertTemplatetInfo(mcmCmnAth002VO);
	}
	
	/**
	 * 정보를 수정한다.
	 * @param mcmCmnAth002VO
	 * @return
	 * @throws Exception
	 */
	public void updateTemplatetInfo(McmCmnAth002VO mcmCmnAth002VO) throws Exception{
		mcmCmnAth001DAO.updateTemplatetInfo(mcmCmnAth002VO);
	}
	
	/**
	 * 정보를 삭제한다.
	 * @param mcmCmnAth002VO
	 * @return
	 * @throws Exception
	 */
	public int deleteTemplatetInfo(McmCmnAth002VO mcmCmnAth002VO) throws Exception{
		return mcmCmnAth001DAO.deleteTemplatetInfo(mcmCmnAth002VO);
	}
	
	

}
