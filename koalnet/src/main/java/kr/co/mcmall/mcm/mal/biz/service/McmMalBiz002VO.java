package kr.co.mcmall.mcm.mal.biz.service;

import java.sql.Timestamp;

import kr.co.mcmall.cmn.service.CommonVO;

/**
 * @Class Name : McmMalBiz002VO.java
 * @author : 신현민
 * @since : 2017. 6. 20.
 * @Description : 홍보물 관리 VO
 *
 */
public class McmMalBiz002VO extends CommonVO  {

	private String lcsId;                // 사업자ID
	private String gdsId;                // 상품ID
	private String seqNo;                // 홍보물순번
	private String itrCnts;              // 인사말
	private String brcUrlAddr;           // 홍보URL주소
	private String note;                 // 해당 홍보물에 대한 메모 
	private String lstUdtId;             // 최종수정자ID
    private Timestamp lstUdtDt;          // 최종수정일자
    private String lstUdtIp;             // 최종수정자IP
    private String searchLcsId;
    private String searchGdsId;
    private String searchStrId;
    private String searchUsrNm;
    private String strCnts;
    private String strDm;
    private String strNm;
    private String gdsNm;
    private String usrId;
    private String searchUsrId;
    private String lcsId2;
    
    
	public String getLcsId2() {
		return lcsId2;
	}
	public void setLcsId2(String lcsId2) {
		this.lcsId2 = lcsId2;
	}
	public String getSearchUsrId() {
		return searchUsrId;
	}
	public void setSearchUsrId(String searchUsrId) {
		this.searchUsrId = searchUsrId;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getGdsNm() {
		return gdsNm;
	}
	public void setGdsNm(String gdsNm) {
		this.gdsNm = gdsNm;
	}
	public String getStrCnts() {
		return strCnts;
	}
	public void setStrCnts(String strCnts) {
		this.strCnts = strCnts;
	}
	public String getStrDm() {
		return strDm;
	}
	public void setStrDm(String strDm) {
		this.strDm = strDm;
	}
	public String getStrNm() {
		return strNm;
	}
	public void setStrNm(String strNm) {
		this.strNm = strNm;
	}
	public String getSearchUsrNm() {
		return searchUsrNm;
	}
	public void setSearchUsrNm(String searchUsrNm) {
		this.searchUsrNm = searchUsrNm;
	}
	public String getSearchLcsId() {
		return searchLcsId;
	}
	public void setSearchLcsId(String searchLcsId) {
		this.searchLcsId = searchLcsId;
	}
	public String getSearchGdsId() {
		return searchGdsId;
	}
	public void setSearchGdsId(String searchGdsId) {
		this.searchGdsId = searchGdsId;
	}
	public String getSearchStrId() {
		return searchStrId;
	}
	public void setSearchStrId(String searchStrId) {
		this.searchStrId = searchStrId;
	}
	public String getLcsId() {
		return lcsId;
	}
	public void setLcsId(String lcsId) {
		this.lcsId = lcsId;
	}
	public String getGdsId() {
		return gdsId;
	}
	public void setGdsId(String gdsId) {
		this.gdsId = gdsId;
	}
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public String getItrCnts() {
		return itrCnts;
	}
	public void setItrCnts(String itrCnts) {
		this.itrCnts = itrCnts;
	}
	public String getBrcUrlAddr() {
		return brcUrlAddr;
	}
	public void setBrcUrlAddr(String brcUrlAddr) {
		this.brcUrlAddr = brcUrlAddr;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
		return "McmMalBiz002VO [lcsId=" + lcsId + ""  
				+ ", gdsId=" + gdsId + ", seqNo=" + seqNo + ", itrCnts="
				+ itrCnts + ", brcUrlAddr=" + brcUrlAddr + ", note=" + note
				+ ", lstUdtId=" + lstUdtId + ", lstUdtDt=" + lstUdtDt
				+ ", lstUdtIp=" + lstUdtIp + "]";
	}
    
    
    
}
