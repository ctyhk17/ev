package kr.co.mcmall.mcm.mal.biz.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kr.co.mcmall.cmn.service.CommonVO;

/**
 * @Class Name : McmMalBiz001VO.java
 * @author : 신현민
 * @since : 2017. 6. 20.
 * @Description : 사업자 관리 VO
 *
 */
public class McmMalBiz001VO extends CommonVO  {

	private String lcsId;                // 사업자ID
	private String usrId;                // 회원ID
	private String upLcsId;              // 상위사업자ID
	private String lcsDivCd;             // 사업자구분코드
    private String telNo;                // 회원 연락처  
    private String usrNm;                // 회원 이름
    private String emailAddr;            // 이메일주소
    private String strNm;                // 상점 이름
    private String strDm;                // 상점 도메인
    private String strCnts;              // 상점 설명
    private String searchLcsId;  
    private String searchUsrId;
    private String searchUsrNm;
    private String upLcsCk;
    private String athCd;
    private String searchStrId;
    private String searchTelNo;
	private String[] usrIdArray;
	private List usrIdList = new ArrayList();
	private String usrPwd;
	private String feePayYn;
	private String joinDt;
	private String upUsrId;
	
	
    
    
	public String getUpUsrId() {
		return upUsrId;
	}
	public void setUpUsrId(String upUsrId) {
		this.upUsrId = upUsrId;
	}
	public String getUsrPwd() {
		return usrPwd;
	}
	public void setUsrPwd(String usrPwd) {
		this.usrPwd = usrPwd;
	}
	public String getFeePayYn() {
		return feePayYn;
	}
	public void setFeePayYn(String feePayYn) {
		this.feePayYn = feePayYn;
	}
	public String getJoinDt() {
		return joinDt;
	}
	public void setJoinDt(String joinDt) {
		this.joinDt = joinDt;
	}
	public String[] getUsrIdArray() {
		return usrIdArray;
	}
	public void setUsrIdArray(String[] usrIdArray) {
		this.usrIdArray = usrIdArray;
	}
	public List getUsrIdList() {
		return usrIdList;
	}
	public void setUsrIdList(List usrIdList) {
		this.usrIdList = usrIdList;
	}
	public String getSearchTelNo() {
		return searchTelNo;
	}
	public void setSearchTelNo(String searchTelNo) {
		this.searchTelNo = searchTelNo;
	}
	public String getSearchStrId() {
		return searchStrId;
	}
	public void setSearchStrId(String searchStrId) {
		this.searchStrId = searchStrId;
	}
	public String getAthCd() {
		return athCd;
	}
	public void setAthCd(String athCd) {
		this.athCd = athCd;
	}
	public String getUpLcsCk() {
		return upLcsCk;
	}
	public void setUpLcsCk(String upLcsCk) {
		this.upLcsCk = upLcsCk;
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
	public String getLcsId() {
		return lcsId;
	}
	public void setLcsId(String lcsId) {
		this.lcsId = lcsId;
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
	
	@Override
	public String toString() {
		return "McmMalBiz001VO [lcsId=" + lcsId + ", usrId=" + usrId
				+ ", upLcsId=" + upLcsId + ", lcsDivCd=" + lcsDivCd
				+ ", telNo=" + telNo + ", usrNm=" + usrNm + ", emailAddr="
				+ emailAddr + ", strNm=" + strNm + ", strDm=" + strDm
				+ ", strCnts=" + strCnts + ", searchLcsId=" + searchLcsId
				+ ", searchUsrId=" + searchUsrId + ", searchUsrNm="
				+ searchUsrNm + ", upLcsCk=" + upLcsCk + ", athCd=" + athCd
				+ ", searchStrId=" + searchStrId + ", searchTelNo="
				+ searchTelNo + ", usrIdArray=" + Arrays.toString(usrIdArray)
				+ ", usrIdList=" + usrIdList + ", usrPwd=" + usrPwd
				+ ", feePayYn=" + feePayYn + ", joinDt=" + joinDt + "]";
	}
	
	
	
    
    
	
    
    
}
