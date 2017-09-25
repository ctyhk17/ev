package kr.co.mcmall.mcm.mal.biz.service;

import java.sql.Timestamp;

import kr.co.mcmall.cmn.service.CommonVO;

/**
 * @Class Name : McmMalBiz003VO.java
 * @author : 신현민
 * @since : 2017. 6. 20.
 * @Description : 사업자 관리 VO
 *
 */
public class McmMalBiz003VO extends CommonVO  {

	private String[] lcsId;                // 사업자ID
	private String strId;                // 상점ID
	private String usrId;                // 회원ID
	private String upLcsId;              // 상위사업자ID
	private String lcsDivCd;             // 사업자구분코드
	private String lstUdtId;             // 최종수정자ID
    private Timestamp lstUdtDt;          // 최종수정일자
    private String lstUdtIp;             // 최종수정자IP
    private String telNo;                // 회원 연락처  
    private String usrNm;                // 회원 이름
    private String emailAddr;            // 이메일주소
    private String strNm;                // 상점 이름
    private String strDm;                // 상점 도메인
    private String strCnts;              // 상점 설명
    private String searchLcsId;  
    private String searchUsrId;
    private String searchUsrNm;
    private String searchStrId;
    private String lcsId2;
                   
   
    
	public String getLcsId2() {
		return lcsId2;
	}
	public void setLcsId2(String lcsId2) {
		this.lcsId2 = lcsId2;
	}
	public String getSearchStrId() {
		return searchStrId;
	}
	public void setSearchStrId(String searchStrId) {
		this.searchStrId = searchStrId;
	}
	public String getSearchLcsId() {
		return searchLcsId;
	}
	public void setSearchLcsId(String searchLcsId) {
		this.searchLcsId = searchLcsId;
	}
	public String getSearchUsrId() {
		return searchUsrId;
	}
	public void setSearchUsrId(String searchUsrId) {
		this.searchUsrId = searchUsrId;
	}
	public String getSearchUsrNm() {
		return searchUsrNm;
	}
	public void setSearchUsrNm(String searchUsrNm) {
		this.searchUsrNm = searchUsrNm;
	}
	public String getStrNm() {
		return strNm;
	}
	public void setStrNm(String strNm) {
		this.strNm = strNm;
	}
	public String getStrDm() {
		return strDm;
	}
	public void setStrDm(String strDm) {
		this.strDm = strDm;
	}
	public String getStrCnts() {
		return strCnts;
	}
	public void setStrCnts(String strCnts) {
		this.strCnts = strCnts;
	}
	public String getEmailAddr() {
		return emailAddr;
	}
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getUsrNm() {
		return usrNm;
	}
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	public String[] getLcsId() {
		return lcsId;
	}
	public void setLcsId(String[] lcsId) {
		this.lcsId = lcsId;
	}
	public String getStrId() {
		return strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getUpLcsId() {
		return upLcsId;
	}
	public void setUpLcsId(String upLcsId) {
		this.upLcsId = upLcsId;
	}
	public String getLcsDivCd() {
		return lcsDivCd;
	}
	public void setLcsDivCd(String lcsDivCd) {
		this.lcsDivCd = lcsDivCd;
	}
	public String getLstUdtId() {
		return lstUdtId;
	}
	public void setLstUdtId(String lstUdtId) {
		this.lstUdtId = lstUdtId;
	}
	public Timestamp getLstUdtDt() {
		return lstUdtDt;
	}
	public void setLstUdtDt(Timestamp lstUdtDt) {
		this.lstUdtDt = lstUdtDt;
	}
	public String getLstUdtIp() {
		return lstUdtIp;
	}
	public void setLstUdtIp(String lstUdtIp) {
		this.lstUdtIp = lstUdtIp;
	}
	@Override
	public String toString() {
		return "McmMalBiz003VO [lcsId=" + lcsId + ", strId=" + strId
				+ ", usrId=" + usrId + ", upLcsId=" + upLcsId + ", lcsDivCd="
				+ lcsDivCd + ", lstUdtId=" + lstUdtId + ", lstUdtDt="
				+ lstUdtDt + ", lstUdtIp=" + lstUdtIp + ", telNo=" + telNo
				+ ", usrNm=" + usrNm + ", emailAddr=" + emailAddr + ", strNm="
				+ strNm + ", strDm=" + strDm + ", strCnts=" + strCnts + "]";
	}
	
	
	
    
    
	
    
    
}
