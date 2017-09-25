package kr.co.mcmall.mcm.mal.gds.service;

import java.util.ArrayList;
import java.util.List;

import kr.co.mcmall.cmn.service.CommonVO;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Class Name : McmMalGds001VO.java
 * @Description : McmMalGds001VO VO Class
 *                McmMalGds001VO VO 클래스 ( 상품관리 )
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2017-06-20           최초생성
 *
 * @author 개발팀
 * @since 2017-06-20
 * @version 1.0
 * @see
 *  
 */

public class McmMalGds001VO extends CommonVO {

	private String gdsId;		// 상품ID
	private String lcsId;		// 사업자ID
	private String gdsNm;		// 상품명
	private String lstUdtId;	// 최종수정ID
	private String lstUdtDt;	// 최종수정날짜
	private String lstUdtIp;	// 최종수정IP
	private String gdsAttMnImg;	// 상품이미지
	private String gdsAttSnImg;	// 상품썸네일이미지
	private String gdsImgNm;	// 상품이미지이름
	private String gdsImgNm2;	// 상품이미지이름
	private String gdsTempImgNm;// 상품임시이미지이름
	private String gdsIdSeach;	// 상품ID 검색
	private String gdsNmSeach;	// 상품명 검색
	private String useYnSearch;	// 상품노출 검색
	private String gdsAttImgPath;	// 이미지 경로
	
	private String gdsEnvDivCd;	// 설정구분코드
	private String gdsEnvVal;	// 설정구분값
	private String gdsCnts;
	
	private String gdsCnts1;	// 설정구분설명
	private String gdsCnts2;	// 설정구분설명
	private String gdsCnts3;	// 설정구분설명
	private String gdsCnts4;	// 설정구분설명
	private String gdsCnts5;	// 설정구분설명
	private String gdsAttImg;	// 상세설정이미지
	
	private String gds001001;	// 회원판매가
	private String gds001002;	// 상품수량
	
	private MultipartFile fileNm;			
	private List<MultipartFile> fileImgList;
	
	private String kwdNm;
	private String seqNo;
	private String kwdNm1;		// 키워드명
	private String kwdNm2;		// 키워드명
	private String kwdNm3;		// 키워드명
	private String kwdNm4;		// 키워드명
	private String kwdNm5;		// 키워드명
	private String kwdSttCd;	// 진행상태
	private String kwdRssUrl1;	// 키워드RSSURL
	private String kwdRssUrl2;	// 키워드RSSURL
	private String kwdRssUrl3;	// 키워드RSSURL
	private String kwdRssUrl4;	// 키워드RSSURL
	private String kwdRssUrl5;	// 키워드RSSURL
	private String kwdRssUrl;
	private String usrId;		// 사용자아이디
	private String seqNo1;
	private String seqNo2;
	private String seqNo3;
	private String seqNo4;
	private String seqNo5;
	
	
	private String gdsUseYn;	//	상품사용여부
	private String[] checkGdsId; // 체크상품아이디
	private String stProdDt;	// 날짜검색 시작
	private String endProdDt;	// 날짜검색 종료
	
	private List gdsIdList = new ArrayList();
	private String gdsAttSnImgPath;
	
	private String selCnt;		
	private String gds001003;	// 일반판매가 
	private String gds001004;	// 할인판매여부
	private String gds001005;	// 할인판매가
	
	private String cd;			// 카테고리ID
	
	
	
	
	
	
	
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public String getGds001003() {
		return gds001003;
	}
	public void setGds001003(String gds001003) {
		this.gds001003 = gds001003;
	}
	public String getSelCnt() {
		return selCnt;
	}
	public void setSelCnt(String selCnt) {
		this.selCnt = selCnt;
	}
	public String getGds001004() {
		return gds001004;
	}
	public void setGds001004(String gds001004) {
		this.gds001004 = gds001004;
	}
	public String getGds001005() {
		return gds001005;
	}
	public void setGds001005(String gds001005) {
		this.gds001005 = gds001005;
	}
	public String getGdsAttSnImgPath() {
		return gdsAttSnImgPath;
	}
	public void setGdsAttSnImgPath(String gdsAttSnImgPath) {
		this.gdsAttSnImgPath = gdsAttSnImgPath;
	}
	public String getGdsImgNm2() {
		return gdsImgNm2;
	}
	public void setGdsImgNm2(String gdsImgNm2) {
		this.gdsImgNm2 = gdsImgNm2;
	}
	public List getGdsIdList() {
		return gdsIdList;
	}
	public void setGdsIdList(List gdsIdList) {
		this.gdsIdList = gdsIdList;
	}
	
	
	
	public String getStProdDt() {
		return stProdDt;
	}
	public void setStProdDt(String stProdDt) {
		this.stProdDt = stProdDt;
	}
	public String getEndProdDt() {
		return endProdDt;
	}
	public void setEndProdDt(String endProdDt) {
		this.endProdDt = endProdDt;
	}
	public String[] getCheckGdsId() {
		return checkGdsId;
	}
	public void setCheckGdsId(String[] checkGdsId) {
		this.checkGdsId = checkGdsId;
	}
	public String getGdsUseYn() {
		return gdsUseYn;
	}
	public void setGdsUseYn(String gdsUseYn) {
		this.gdsUseYn = gdsUseYn;
	}
	public String getKwdRssUrl1() {
		return kwdRssUrl1;
	}
	public void setKwdRssUrl1(String kwdRssUrl1) {
		this.kwdRssUrl1 = kwdRssUrl1;
	}
	public String getKwdRssUrl2() {
		return kwdRssUrl2;
	}
	public void setKwdRssUrl2(String kwdRssUrl2) {
		this.kwdRssUrl2 = kwdRssUrl2;
	}
	public String getKwdRssUrl3() {
		return kwdRssUrl3;
	}
	public void setKwdRssUrl3(String kwdRssUrl3) {
		this.kwdRssUrl3 = kwdRssUrl3;
	}
	public String getKwdRssUrl4() {
		return kwdRssUrl4;
	}
	public void setKwdRssUrl4(String kwdRssUrl4) {
		this.kwdRssUrl4 = kwdRssUrl4;
	}
	public String getKwdRssUrl5() {
		return kwdRssUrl5;
	}
	public void setKwdRssUrl5(String kwdRssUrl5) {
		this.kwdRssUrl5 = kwdRssUrl5;
	}
	public String getSeqNo1() {
		return seqNo1;
	}
	public void setSeqNo1(String seqNo1) {
		this.seqNo1 = seqNo1;
	}
	public String getSeqNo2() {
		return seqNo2;
	}
	public void setSeqNo2(String seqNo2) {
		this.seqNo2 = seqNo2;
	}
	public String getSeqNo3() {
		return seqNo3;
	}
	public void setSeqNo3(String seqNo3) {
		this.seqNo3 = seqNo3;
	}
	public String getSeqNo4() {
		return seqNo4;
	}
	public void setSeqNo4(String seqNo4) {
		this.seqNo4 = seqNo4;
	}
	public String getSeqNo5() {
		return seqNo5;
	}
	public void setSeqNo5(String seqNo5) {
		this.seqNo5 = seqNo5;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public String getKwdNm() {
		return kwdNm;
	}
	public void setKwdNm(String kwdNm) {
		this.kwdNm = kwdNm;
	}
	public String getKwdNm1() {
		return kwdNm1;
	}
	public void setKwdNm1(String kwdNm1) {
		this.kwdNm1 = kwdNm1;
	}
	public String getKwdNm2() {
		return kwdNm2;
	}
	public void setKwdNm2(String kwdNm2) {
		this.kwdNm2 = kwdNm2;
	}
	public String getKwdNm3() {
		return kwdNm3;
	}
	public void setKwdNm3(String kwdNm3) {
		this.kwdNm3 = kwdNm3;
	}
	public String getKwdNm4() {
		return kwdNm4;
	}
	public void setKwdNm4(String kwdNm4) {
		this.kwdNm4 = kwdNm4;
	}
	public String getKwdNm5() {
		return kwdNm5;
	}
	public void setKwdNm5(String kwdNm5) {
		this.kwdNm5 = kwdNm5;
	}
	public String getKwdSttCd() {
		return kwdSttCd;
	}
	public void setKwdSttCd(String kwdSttCd) {
		this.kwdSttCd = kwdSttCd;
	}
	public String getKwdRssUrl() {
		return kwdRssUrl;
	}
	public void setKwdRssUrl(String kwdRssUrl) {
		this.kwdRssUrl = kwdRssUrl;
	}
	public String getGdsCnts() {
		return gdsCnts;
	}
	public void setGdsCnts(String gdsCnts) {
		this.gdsCnts = gdsCnts;
	}
	public String getGdsCnts1() {
		return gdsCnts1;
	}
	public void setGdsCnts1(String gdsCnts1) {
		this.gdsCnts1 = gdsCnts1;
	}
	public String getGdsCnts2() {
		return gdsCnts2;
	}
	public void setGdsCnts2(String gdsCnts2) {
		this.gdsCnts2 = gdsCnts2;
	}
	public String getGdsCnts3() {
		return gdsCnts3;
	}
	public void setGdsCnts3(String gdsCnts3) {
		this.gdsCnts3 = gdsCnts3;
	}
	public String getGdsCnts4() {
		return gdsCnts4;
	}
	public void setGdsCnts4(String gdsCnts4) {
		this.gdsCnts4 = gdsCnts4;
	}
	public String getGdsCnts5() {
		return gdsCnts5;
	}
	public void setGdsCnts5(String gdsCnts5) {
		this.gdsCnts5 = gdsCnts5;
	}
	public List<MultipartFile> getFileImgList() {
		return fileImgList;
	}
	public void setFileImgList(List<MultipartFile> fileImgList) {
		this.fileImgList = fileImgList;
	}
	public String getGdsAttImg() {
		return gdsAttImg;
	}
	public void setGdsAttImg(String gdsAttImg) {
		this.gdsAttImg = gdsAttImg;
	}
	public String getGdsAttImgPath() {
		return gdsAttImgPath;
	}
	public void setGdsAttImgPath(String gdsAttImgPath) {
		this.gdsAttImgPath = gdsAttImgPath;
	}
	public String getGdsTempImgNm() {
		return gdsTempImgNm;
	}
	public void setGdsTempImgNm(String gdsTempImgNm) {
		this.gdsTempImgNm = gdsTempImgNm;
	}
	public MultipartFile getFileNm() {
		return fileNm;
	}
	public void setFileNm(MultipartFile fileNm) {
		this.fileNm = fileNm;
	}
	public String getGds001001() {
		return gds001001;
	}
	public void setGds001001(String gds001001) {
		this.gds001001 = gds001001;
	}
	public String getGds001002() {
		return gds001002;
	}
	public void setGds001002(String gds001002) {
		this.gds001002 = gds001002;
	}
	public String getGdsEnvDivCd() {
		return gdsEnvDivCd;
	}
	public void setGdsEnvDivCd(String gdsEnvDivCd) {
		this.gdsEnvDivCd = gdsEnvDivCd;
	}
	public String getGdsEnvVal() {
		return gdsEnvVal;
	}
	public void setGdsEnvVal(String gdsEnvVal) {
		this.gdsEnvVal = gdsEnvVal;
	}
	public String getGdsIdSeach() {
		return gdsIdSeach;
	}
	public void setGdsIdSeach(String gdsIdSeach) {
		this.gdsIdSeach = gdsIdSeach;
	}
	public String getGdsNmSeach() {
		return gdsNmSeach;
	}
	public void setGdsNmSeach(String gdsNmSeach) {
		this.gdsNmSeach = gdsNmSeach;
	}
	public String getGdsId() {
		return gdsId;
	}
	public void setGdsId(String gdsId) {
		this.gdsId = gdsId;
	}
	public String getLcsId() {
		return lcsId;
	}
	public void setLcsId(String lcsId) {
		this.lcsId = lcsId;
	}
	public String getGdsNm() {
		return gdsNm;
	}
	public void setGdsNm(String gdsNm) {
		this.gdsNm = gdsNm;
	}
	public String getLstUdtId() {
		return lstUdtId;
	}
	public void setLstUdtId(String lstUdtId) {
		this.lstUdtId = lstUdtId;
	}
	public String getLstUdtDt() {
		return lstUdtDt;
	}
	public void setLstUdtDt(String lstUdtDt) {
		this.lstUdtDt = lstUdtDt;
	}
	public String getLstUdtIp() {
		return lstUdtIp;
	}
	public void setLstUdtIp(String lstUdtIp) {
		this.lstUdtIp = lstUdtIp;
	}
	public String getGdsImgNm() {
		return gdsImgNm;
	}
	public void setGdsImgNm(String gdsImgNm) {
		this.gdsImgNm = gdsImgNm;
	}
	public String getGdsAttMnImg() {
		return gdsAttMnImg;
	}
	public void setGdsAttMnImg(String gdsAttMnImg) {
		this.gdsAttMnImg = gdsAttMnImg;
	}
	public String getGdsAttSnImg() {
		return gdsAttSnImg;
	}
	public void setGdsAttSnImg(String gdsAttSnImg) {
		this.gdsAttSnImg = gdsAttSnImg;
	}
	public String getUseYnSearch() {
		return useYnSearch;
	}
	public void setUseYnSearch(String useYnSearch) {
		this.useYnSearch = useYnSearch;
	}
	
	
	@Override
	public String toString() {
		return "McmMalGds001VO [gdsId=" + gdsId + ", lcsId=" + lcsId
				+ ", gdsNm=" + gdsNm + ", lstUdtId=" + lstUdtId + ", lstUdtDt="
				+ lstUdtDt + ", lstUdtIp=" + lstUdtIp + ", gdsAttMnImg="
				+ gdsAttMnImg + ", gdsAttSnImg=" + gdsAttSnImg + ", gdsImgNm="
				+ gdsImgNm + ", gdsTempImgNm=" + gdsTempImgNm + ", gdsIdSeach="
				+ gdsIdSeach + ", gdsNmSeach=" + gdsNmSeach
				+ ", gdsAttImgPath=" + gdsAttImgPath + ", gdsEnvDivCd="
				+ gdsEnvDivCd + ", gdsEnvVal=" + gdsEnvVal + ", gdsCnts1="
				+ gdsCnts1 + ", gdsCnts2=" + gdsCnts2 + ", gdsCnts3="
				+ gdsCnts3 + ", gdsCnts4=" + gdsCnts4 + ", gdsCnts5="
				+ gdsCnts5 + ", gdsAttImg=" + gdsAttImg + ", gds001001="
				+ gds001001 + ", gds001002=" + gds001002 + ", fileNm=" + fileNm
				+ ", fileImgList=" + fileImgList + "]";
	}
	
	
	
}
