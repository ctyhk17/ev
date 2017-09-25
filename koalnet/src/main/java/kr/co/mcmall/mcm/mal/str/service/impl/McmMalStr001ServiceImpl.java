package kr.co.mcmall.mcm.mal.str.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.mcmall.mcm.mal.str.service.McmMalStr001Service;
import kr.co.mcmall.mcm.mal.str.service.McmMalStr001VO;

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

@Service("mcmMalStr001Service")
public class McmMalStr001ServiceImpl extends EgovAbstractServiceImpl implements McmMalStr001Service {

	/** DAO 선언 */
	@Resource(name = "mcmMalStr001DAO")
	private McmMalStr001DAO mcmMalStr001DAO;

	
	
	/**
	 * 목록조회
	 * @param mcmMalStr001VO - 조회할 정보가 담긴 VO
	 * @return 목록
	 * @exception Exception
	 */
	public List<?> selectMcmMalStr001M01List(McmMalStr001VO mcmMalStr001VO) throws Exception{
		return mcmMalStr001DAO.selectMcmMalStr001M01List(mcmMalStr001VO);
	}

	/**
	 * 목록 갯수 조회 
	 * @param mcmMalStr001VO - 조회할 정보가 담긴 VO
	 * @return 목록 총 갯수
	 * @exception
	 */
	public int selectMcmMalStr001M01Paging(McmMalStr001VO mcmMalStr001VO){
		return mcmMalStr001DAO.selectMcmMalStr001M01Paging(mcmMalStr001VO);
	}
	

	/**
	 * 상세내용을 조회한다.
	 * @param mcmMalStr001VO - 조회할 정보가 담긴 mcmMalStr001VO
	 * @return  상세정보
	 * @exception Exception
	 */
	public Map<?, ?> selectMcmMalStr001M02Info(McmMalStr001VO mcmMalStr001VO) throws Exception{
		return mcmMalStr001DAO.selectMcmMalStr001M02Info(mcmMalStr001VO);
	}

	
	/**
	 * 정보을 등록한다.
	 * @param mcmMalStr001VO
	 * @return
	 * @throws Exception
	 */
	public String insertTemplatetInfo(McmMalStr001VO mcmMalStr001VO) throws Exception{
		return mcmMalStr001DAO.insertTemplatetInfo(mcmMalStr001VO);
	}
	
	/**
	 * 정보를 수정한다.
	 * @param mcmMalStr001VO
	 * @return
	 * @throws Exception
	 */
	public void updateMcmMalStr001M03UP(McmMalStr001VO mcmMalStr001VO) throws Exception{
		mcmMalStr001DAO.updateMcmMalStr001M03UP(mcmMalStr001VO);
	}
	
	/**
	 * 정보를 삭제한다.
	 * @param mcmMalStr001VO
	 * @return
	 * @throws Exception
	 */
	public int deleteTemplatetInfo(McmMalStr001VO mcmMalStr001VO) throws Exception{
		return mcmMalStr001DAO.deleteTemplatetInfo(mcmMalStr001VO);
	}

	// 상점리스트조회
	public List<?> selectMcmMalStr001M01StrList(McmMalStr001VO mcmMalStr001VO)
			throws Exception {
		return mcmMalStr001DAO.selectMcmMalStr001M01StrList(mcmMalStr001VO);
	}

	public void updateMcmMalStr001M04UP(McmMalStr001VO mcmMalStr001VO)
			throws Exception {
		mcmMalStr001DAO.updateMcmMalStr001M04UP(mcmMalStr001VO);
	}

	public void updateMcmMalStr001M05UP(McmMalStr001VO mcmMalStr001VO)
			throws Exception {
		mcmMalStr001DAO.updateMcmMalStr001M05UP(mcmMalStr001VO);
	}

	public void updateMcmMalStr001M06UP(McmMalStr001VO mcmMalStr001VO)
			throws Exception {
		mcmMalStr001DAO.updateMcmMalStr001M06UP(mcmMalStr001VO);
	}

	public void updateMcmMalStr001M07UP(McmMalStr001VO mcmMalStr001VO)
			throws Exception {
		mcmMalStr001DAO.updateMcmMalStr001M07UP(mcmMalStr001VO);
	}

	public void updateMcmMalStr001M08UP(McmMalStr001VO mcmMalStr001VO)
			throws Exception {
		mcmMalStr001DAO.updateMcmMalStr001M08UP(mcmMalStr001VO);
	}

	public void updateMcmMalStr001M09UP(McmMalStr001VO mcmMalStr001VO)
			throws Exception {
		mcmMalStr001DAO.updateMcmMalStr001M09UP(mcmMalStr001VO);
	}
	
	

}
