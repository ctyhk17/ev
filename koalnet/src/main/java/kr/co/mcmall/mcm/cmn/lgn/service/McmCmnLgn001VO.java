
package kr.co.mcmall.mcm.cmn.lgn.service;

import kr.co.mcmall.cmn.service.CommonVO;


/**
 * @Class Name : FmsCmnLgn001VO.java
 * @Description : FmsCmnLgn001VO Class
 *                로그인 VO
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
public class McmCmnLgn001VO extends CommonVO {
	
	private String usrId;
	private String usrPwd;
	private String usrNm;
	private String telNo;
	private String emailAddr;
	private String areaCd;
	private String bnkCd;
	private String accNo;
	private String dpstNm;
	private String joinDt;
	
	private String usrPwdCheck;
	
	
	private String returnUrl;
	private String gdsId;
	private String ordCnt;
	
	
	
	
	
	
	public String getReturnUrl() {
		return returnUrl;
	}
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	public String getGdsId() {
		return gdsId;
	}
	public void setGdsId(String gdsId) {
		this.gdsId = gdsId;
	}
	public String getOrdCnt() {
		return ordCnt;
	}
	public void setOrdCnt(String ordCnt) {
		this.ordCnt = ordCnt;
	}
	private String searchIdByUsrNm;
	private String searchIdByTelNo;
	
	private String searchPwdByUsrId;
	private String searchPwdByUsrNm;
	private String searchPwdByTelNo;
	
	
	
	
	
	public String getSearchIdByUsrNm() {
		return searchIdByUsrNm;
	}
	public void setSearchIdByUsrNm(String searchIdByUsrNm) {
		this.searchIdByUsrNm = searchIdByUsrNm;
	}
	public String getSearchIdByTelNo() {
		return searchIdByTelNo;
	}
	public void setSearchIdByTelNo(String searchIdByTelNo) {
		this.searchIdByTelNo = searchIdByTelNo;
	}
	public String getSearchPwdByUsrId() {
		return searchPwdByUsrId;
	}
	public void setSearchPwdByUsrId(String searchPwdByUsrId) {
		this.searchPwdByUsrId = searchPwdByUsrId;
	}
	public String getSearchPwdByUsrNm() {
		return searchPwdByUsrNm;
	}
	public void setSearchPwdByUsrNm(String searchPwdByUsrNm) {
		this.searchPwdByUsrNm = searchPwdByUsrNm;
	}
	public String getSearchPwdByTelNo() {
		return searchPwdByTelNo;
	}
	public void setSearchPwdByTelNo(String searchPwdByTelNo) {
		this.searchPwdByTelNo = searchPwdByTelNo;
	}
	public String getUsrPwdCheck() {
		return usrPwdCheck;
	}
	public void setUsrPwdCheck(String usrPwdCheck) {
		this.usrPwdCheck = usrPwdCheck;
	}
	
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getUsrPwd() {
		return usrPwd;
	}
	public void setUsrPwd(String usrPwd) {
		this.usrPwd = usrPwd;
	}
	public String getUsrNm() {
		return usrNm;
	}
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getEmailAddr() {
		return emailAddr;
	}
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}
	public String getAreaCd() {
		return areaCd;
	}
	public void setAreaCd(String areaCd) {
		this.areaCd = areaCd;
	}
	public String getBnkCd() {
		return bnkCd;
	}
	public void setBnkCd(String bnkCd) {
		this.bnkCd = bnkCd;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getDpstNm() {
		return dpstNm;
	}
	public void setDpstNm(String dpstNm) {
		this.dpstNm = dpstNm;
	}
	public String getJoinDt() {
		return joinDt;
	}
	public void setJoinDt(String joinDt) {
		this.joinDt = joinDt;
	}
	
	
	
		
	
	
}
