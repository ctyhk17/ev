package kr.co.mcmall.mcm.mal.itr.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.mcmall.mcm.mal.itr.service.McmMalItr001Service;
import kr.co.mcmall.mcm.mal.itr.service.McmMalItr001VO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : McmShpOrd001ServiceImpl.java
 * @Description : McmShpOrd001ServiceImpl Service Implements Class
 *                주문 서비스 인터페이스
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

@Service("mcmMalItr001Service")
public class McmMalItr001ServiceImpl extends EgovAbstractServiceImpl implements McmMalItr001Service {

	/** DAO 선언 */
	@Resource(name = "mcmMalItr001DAO")
	private McmMalItr001DAO mcmMalItr001DAO;

	/**
	 * 상품목록 조회
	 * @param mcmMalItr001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectGdsList(McmMalItr001VO mcmMalItr001VO) throws Exception{
		return mcmMalItr001DAO.selectGdsList(mcmMalItr001VO);
	}
	
	/**
	 * 상품목록 건수 조회
	 * @param mcmMalItr001VO
	 * @return
	 * @throws Exception
	 */
	public int selectGdsListTotCnt(McmMalItr001VO mcmMalItr001VO) throws Exception{
		return mcmMalItr001DAO.selectGdsListTotCnt(mcmMalItr001VO);
	}
	
	
	/**
	 * 상점 설정 정보 조회
	 * @param mcmMalItr001VO
	 * @return
	 * @throws Exception
	 */
	public Map<?,?> selectStrInfo(McmMalItr001VO mcmMalItr001VO) throws Exception{
		return mcmMalItr001DAO.selectStrInfo(mcmMalItr001VO);
	}
	
	
	/**
	 * 카테고리 목록 조회
	 * @return
	 * @throws Exception
	 */
	public List<?> selectCtgrList()  throws Exception{
		return mcmMalItr001DAO.selectCtgrList();
	}

}

