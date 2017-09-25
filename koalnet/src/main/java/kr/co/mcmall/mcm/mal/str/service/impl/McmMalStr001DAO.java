package kr.co.mcmall.mcm.mal.str.service.impl;

import java.util.List;
import java.util.Map;

import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz002VO;
import kr.co.mcmall.mcm.mal.str.service.McmMalStr001VO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : FundTpltDAO.java
 * @Description : FundTpltDAO DAO Class
 *                템플릿 DAO 클래스
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

@Repository("mcmMalStr001DAO")
public class McmMalStr001DAO extends EgovAbstractDAO {

	
	/**
	 *  목록을 조회한다.
	 * @param mcmMalStr001VO - 조회할 정보가 담긴 VO
	 * @return 목록
	 * @exception Exception
	 */
	public List<?> selectMcmMalStr001M01List(McmMalStr001VO mcmMalStr001VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.str.McmMalStr001.selectMcmMalStr001M01List", mcmMalStr001VO);
	}

	/**
	 *  목록 갯수를 조회한다. 
	 * @param mcmMalStr001VO - 조회할 정보가 담긴 VO
	 * @return 목록 총 갯수
	 * @exception
	 */
	public int selectMcmMalStr001M01Paging(McmMalStr001VO mcmMalStr001VO){
		return (Integer)select("kr.co.mcmall.mcm.mal.str.McmMalStr001.selectMcmMalStr001M01Paging", mcmMalStr001VO);
	}
	

	/**
	 *  상세내용을 조회한다.
	 * @param mcmMalStr001VO - 조회할 정보가 담긴 mcmMalStr001VO
	 * @return  상세정보
	 * @exception Exception
	 */
	public Map<?, ?> selectMcmMalStr001M02Info(McmMalStr001VO mcmMalStr001VO) throws Exception{
		return (Map<?, ?>)select("kr.co.mcmall.mcm.mal.str.McmMalStr001.selectMcmMalStr001M02Info", mcmMalStr001VO);
	}

	
	/**
	 *  정보을 등록한다.
	 * @param mcmMalStr001VO
	 * @return
	 * @throws Exception
	 */
	public String insertTemplatetInfo(McmMalStr001VO mcmMalStr001VO) throws Exception{
		return (String)insert("kr.co.mcmall.mcm.mal.str.McmMalStr001.insertTemplatetInfo", mcmMalStr001VO);
	}
	
	/**
	 *  정보를 수정한다.
	 * @param mcmMalStr001VO
	 * @return
	 * @throws Exception
	 */
	public void updateMcmMalStr001M03UP(McmMalStr001VO mcmMalStr001VO) throws Exception{
		update("kr.co.mcmall.mcm.mal.str.McmMalStr001.updateMcmMalStr001M03UP", mcmMalStr001VO);
	}
	
	/**
	 *  정보를 삭제한다.
	 * @param mcmMalStr001VO
	 * @return
	 * @throws Exception
	 */
	public int deleteTemplatetInfo(McmMalStr001VO mcmMalStr001VO) throws Exception{
		return delete("kr.co.mcmall.mcm.mal.str.McmMalStr001.deleteTemplatetInfo", mcmMalStr001VO);
	}
	
	// 상점 리스트 조회
	public List<?> selectMcmMalStr001M01StrList(McmMalStr001VO mcmMalStr001VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.str.McmMalStr001.selectMcmMalStr001M01StrList",mcmMalStr001VO);
	}
	
	// 대표전화번호 변경
	public void updateMcmMalStr001M04UP(McmMalStr001VO mcmMalStr001VO) throws Exception{
		update("kr.co.mcmall.mcm.mal.str.McmMalStr001.updateMcmMalStr001M04UP", mcmMalStr001VO);
	}
	
	// 팩스번호변경
	public void updateMcmMalStr001M05UP(McmMalStr001VO mcmMalStr001VO) throws Exception{
		update("kr.co.mcmall.mcm.mal.str.McmMalStr001.updateMcmMalStr001M05UP", mcmMalStr001VO);
	}
	
	// 은행코드변경
	public void updateMcmMalStr001M06UP(McmMalStr001VO mcmMalStr001VO) throws Exception{
		update("kr.co.mcmall.mcm.mal.str.McmMalStr001.updateMcmMalStr001M06UP", mcmMalStr001VO);
	}
	
	// 계좌번호 변경
	public void updateMcmMalStr001M07UP(McmMalStr001VO mcmMalStr001VO) throws Exception{
		update("kr.co.mcmall.mcm.mal.str.McmMalStr001.updateMcmMalStr001M07UP", mcmMalStr001VO);
	}
	
	// 예금주 변경
	public void updateMcmMalStr001M08UP(McmMalStr001VO mcmMalStr001VO) throws Exception{
		update("kr.co.mcmall.mcm.mal.str.McmMalStr001.updateMcmMalStr001M08UP", mcmMalStr001VO);
	}
	
	// 이메일 변경
	public void updateMcmMalStr001M09UP(McmMalStr001VO mcmMalStr001VO) throws Exception{
		update("kr.co.mcmall.mcm.mal.str.McmMalStr001.updateMcmMalStr001M09UP", mcmMalStr001VO);
	}
	

}
