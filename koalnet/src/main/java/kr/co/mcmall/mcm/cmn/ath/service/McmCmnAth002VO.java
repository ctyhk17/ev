package kr.co.mcmall.mcm.cmn.ath.service;

import java.util.ArrayList;

import java.util.List;

import kr.co.mcmall.cmn.service.CommonVO;


/**
 * @Class Name : FundTpltVO.java
 * @Description : FundTpltVO VO Class
 *                매칭펀드 템플릿 VO
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

public class McmCmnAth002VO extends CommonVO {
	
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
	private String[] usrIdArray;
	private List usrIdList = new ArrayList();
	
	private String searchUsrId;
	private String searchUsrNm;
	private String searchTelNo;
	private String searchEmailAddr;

	private String searchJoinDtFrom;
	private String searchJoinDtTo;
	
	private String searchUseYn;
	private String useYn;
	private String feePayYn;
	private String searchFeePayYn;
	
	private String athCd;
	private String athCnts;
	private String athCntsModify;
	private String athCntsAdd;
	private String athChecked;
	private String lcsId;
	private String upLcsId;
	
	
	
	public String getUpLcsId() {
		return upLcsId;
	}
	public void setUpLcsId(String upLcsId) {
		this.upLcsId = upLcsId;
	}
	public String getLcsId() {
		return lcsId;
	}
	public void setLcsId(String lcsId) {
		this.lcsId = lcsId;
	}
	public List getUsrIdList() {
		return usrIdList;
	}
	public void setUsrIdList(List usrIdList) {
		this.usrIdList = usrIdList;
	}
	public String[] getUsrIdArray() {
		return usrIdArray;
	}
	public void setUsrIdArray(String[] usrIdArray) {
		this.usrIdArray = usrIdArray;
	}
	public String getAthChecked() {
		return athChecked;
	}
	public void setAthChecked(String athChecked) {
		this.athChecked = athChecked;
	}
	public String getAthCntsAdd() {
		return athCntsAdd;
	}
	public void setAthCntsAdd(String athCntsAdd) {
		this.athCntsAdd = athCntsAdd;
	}
	public String getAthCntsModify() {
		return athCntsModify;
	}
	public void setAthCntsModify(String athCntsModify) {
		this.athCntsModify = athCntsModify;
	}
	public String getAthCnts() {
		return athCnts;
	}
	public void setAthCnts(String athCnts) {
		this.athCnts = athCnts;
	}
	public String getAthCd() {
		return athCd;
	}
	public void setAthCd(String athCd) {
		this.athCd = athCd;
	}
	public String getFeePayYn() {
		return feePayYn;
	}
	public void setFeePayYn(String feePayYn) {
		this.feePayYn = feePayYn;
	}
	public String getSearchFeePayYn() {
		return searchFeePayYn;
	}
	public void setSearchFeePayYn(String searchFeePayYn) {
		this.searchFeePayYn = searchFeePayYn;
	}
	public String getSearchUseYn() {
		return searchUseYn;
	}
	public void setSearchUseYn(String searchUseYn) {
		this.searchUseYn = searchUseYn;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
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
	public String getSearchTelNo() {
		return searchTelNo;
	}
	public void setSearchTelNo(String searchTelNo) {
		this.searchTelNo = searchTelNo;
	}
	public String getSearchEmailAddr() {
		return searchEmailAddr;
	}
	public void setSearchEmailAddr(String searchEmailAddr) {
		this.searchEmailAddr = searchEmailAddr;
	}
	public String getSearchJoinDtFrom() {
		return searchJoinDtFrom;
	}
	public void setSearchJoinDtFrom(String searchJoinDtFrom) {
		this.searchJoinDtFrom = searchJoinDtFrom;
	}
	public String getSearchJoinDtTo() {
		return searchJoinDtTo;
	}
	public void setSearchJoinDtTo(String searchJoinDtTo) {
		this.searchJoinDtTo = searchJoinDtTo;
	}
	@Override
	public String toString() {
		return "McmCmnAth002VO [usrId=" + usrId + ", usrPwd=" + usrPwd
				+ ", usrNm=" + usrNm + ", telNo=" + telNo + ", emailAddr="
				+ emailAddr + ", areaCd=" + areaCd + ", bnkCd=" + bnkCd
				+ ", accNo=" + accNo + ", dpstNm=" + dpstNm + ", joinDt="
				+ joinDt + ", searchUsrId=" + searchUsrId + ", searchUsrNm="
				+ searchUsrNm + ", searchTelNo=" + searchTelNo
				+ ", searchEmailAddr=" + searchEmailAddr
				+ ", searchJoinDtFrom=" + searchJoinDtFrom
				+ ", searchJoinDtTo=" + searchJoinDtTo + ", searchUseYn="
				+ searchUseYn + ", useYn=" + useYn + "]";
	}
	
	
	
	
	
}
