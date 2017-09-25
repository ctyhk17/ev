<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.io.*" %>
<%@page import="java.net.URLEncoder" %>


<%@page import="java.util.HashMap"%>
<%@page import="org.apache.commons.httpclient.*" %>
<%@page import="org.apache.commons.httpclient.methods.*" %>
<%@page import="org.apache.commons.httpclient.methods.GetMethod" %> 
<%@page import="org.apache.commons.httpclient.params.HttpMethodParams" %>



<%

System.out.println("mx_rnext.jsp ----------- start");

	/////////////////////////////////////////////////////////////////////////////
	///// 1. 변수 초기화 및 POST 인증값 받음                                 ////
	/////////////////////////////////////////////////////////////////////////////
	request.setCharacterEncoding("euc-kr");
	
	String P_STATUS = request.getParameter("P_STATUS");			// 인증 상태
	String P_RMESG1 = request.getParameter("P_RMESG1");			// 인증 결과 메시지
	String P_TID = request.getParameter("P_TID");				// 인증 거래번호
	String P_REQ_URL = request.getParameter("P_REQ_URL");		// 결제요청 URL
	String P_NOTI = request.getParameter("P_NOTI");				// 기타주문정보
	
	
	System.out.println("=======================");
	System.out.println("P_STATUS : " + P_STATUS);
	System.out.println("P_RMESG1 : " + P_RMESG1);
	
	HashMap<String, String> map = new HashMap<String, String>();
	
	
	/////////////////////////////////////////////////////////////////////////////
	///// 2. 상점 아이디 설정 :                                              ////
	/////    결제요청 페이지에서 사용한 MID값과 동일하게 세팅해야 함...      ////
	/////////////////////////////////////////////////////////////////////////////
	String P_MID = "INIpayTest";  



	if(P_STATUS.equals("01")) { // 인증결과가 실패일 경우
%>
		<script type="text/javascript">
			alert('<%= P_RMESG1 %>');
			var win = window.open('', '_self'); 
			win.close();
		</script>
<%		
		
	// 인증결과가 성공일 경우
	} else { 
		
		P_STATUS = "";
		
		
		

		/////////////////////////////////////////////////////////////////////////////
		///// 3. 승인요청 :                                                      ////
		/////    인증값을 가지고 P_REQ_URL로 승인요청을 함...                    ////
		///// 
		/////////////////////////////////////////////////////////////////////////////
	
	
		// 승인요청할 데이터
		P_REQ_URL = P_REQ_URL + "?P_TID=" + P_TID + "&P_MID=" + P_MID;
		
		// Create an instance of HttpClient.
		HttpClient client = new HttpClient();
	
		// Create a method instance.
		GetMethod method = new GetMethod(P_REQ_URL);
	   
		// Provide custom retry handler is necessary
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
    
    
    	
    
    	try 
    	{
			// Execute the method.
			int statusCode = client.executeMethod(method);

			if (statusCode != HttpStatus.SC_OK) {
				//System.err.println("Method failed: " + method.getStatusLine());
				out.print("Method failed: " + method.getStatusLine());
			}

			// Read the response body.
			byte[] responseBody = method.getResponseBody();   //  승인결과 파싱
			String[] values = new String(responseBody, "euc-kr").split("&"); 
      
      	
	  
			for( int x = 0; x < values.length; x++ ) 
			{
				out.print(values[x]);  // 승인결과를 출력
				out.print("<br>");
			
			
				// 승인결과를 파싱값 잘라 hashmap에 저장
				int i = values[x].indexOf("=");			
				String key1 = values[x].substring(0, i).trim();
				String value1 = values[x].substring(i+1).trim();
				
				System.out.println("key1 : " + key1 + "===" + "value1 : " + value1);
				
				
				map.put(key1, value1);	
	 
			}
			
			P_STATUS = (String)map.get("P_STATUS");
			P_RMESG1 = (String)map.get("P_RMESG1");
			
			
					

		} catch (HttpException e) {      		
	    	out.print("Fatal protocol violation: " + e.getMessage());
      		e.printStackTrace();
    	} catch (IOException e) {
      		out.print("Fatal transport error: " + e.getMessage());
      		e.printStackTrace();
    	} finally {
      		// Release the connection.
      		method.releaseConnection();
    	}
    	
	}
	
	
	if("00".equals(P_STATUS)){
		//DB 저장
    	
		
	    String pOid    = URLEncoder.encode((String)map.get("P_OID"), "UTF-8");
	    String pAmt    = URLEncoder.encode((String)map.get("P_AMT"), "UTF-8");
	    String pTid    = URLEncoder.encode((String)map.get("P_TID"), "UTF-8");
	    String pType   = URLEncoder.encode((String)map.get("P_TYPE"), "UTF-8");
	    String pAuthNo = URLEncoder.encode((String)map.get("P_AUTH_NO"), "UTF-8");
	    
	    
	    String  pVactBankCode = URLEncoder.encode((String)map.get("P_VACT_BANK_CODE"), "UTF-8");
	    String  pVactNum      = URLEncoder.encode((String)map.get("P_VACT_NUM"), "UTF-8");
	    String  pVactName     = URLEncoder.encode((String)map.get("P_VACT_NAME"), "UTF-8");
	    String  pVactDate     = URLEncoder.encode((String)map.get("P_VACT_DATE"), "UTF-8");
	    String  pVactTime     = URLEncoder.encode((String)map.get("P_VACT_TIME"), "UTF-8");
	    
	    String payDivCd = "ACC001002";
	    
	    
	    // 데이터 입력은 noti에서 처리
	    
		Context initCtx = null; 
		DataSource ds   = null; 
		Connection conn = null;
		Statement stmt  = null;
		ResultSet rs    = null;


		try
		{
			initCtx = new InitialContext(); 
			ds = (DataSource)initCtx.lookup("java:/comp/env/jdbc/fundDB");
			
			conn = ds.getConnection();
			
			
			stmt = conn.createStatement();


			/**
			// noti 완료후 업데이트 해야 함
			sql = "";
			sql += "update tb_fndord001                    	";
			sql += "set										";
			sql += "      pay_yn		= 'Y'						";
			sql += "    , pay_dt		= CURRENT_TIMESTAMP() 	";
			sql += "where									";
			sql += "    ord_no = '"+pOid+"'						";
				
			// 주문현황 업데이트
			stmt.executeUpdate(sql);
			*/
			
			
			sql = "";
			sql += "insert into tb_accrcv001					";
			sql += "(											";
			sql += "   usr_id									";
			sql += " , ord_no									";
			sql += " , dpst_seq_no								";
			sql += " , dpst_amt									";
			sql += " , dpst_dt									";
			sql += " , dpst_cf_yn								";
			sql += " , tid										";
			sql += " , appl_num									";
			sql += " , pay_div_cd								";
			sql += " , pay_mth_cd								";
			sql += " , vact_bnk_cd								";
			sql += " , vact_no									";
			sql += " , vact_nm									";
			sql += " , vact_dt									";
			sql += " , vact_tm									";
			sql += ") values (									";
			sql += "	  (select usr_id from tb_fndord001 where ord_no = '"+pOid+"')		";
			sql += "	, '"+pOid+"'							";
			sql += "	, nextval('seq_ord_dpst_seq_no')		";
			sql += "	, '"+pAmt+"'							";
			sql += "	, CURRENT_TIMESTAMP()					";
			sql += "	, 'N'									";
			sql += "	, '"+pTid+"'							";
			sql += "	, '"+pAuthNo+"'						";
			sql += " 	, '"+payDivCd+"'								";
			sql += " 	, '"+pAuthNo+"'								";
			sql += " 	, '"+pVactBankCode+"'								";
			sql += " 	, '"+pVactNum+"'									";
			sql += " 	, '"+pVactName+"'									";
			sql += " 	, '"+pVactDate+"'									";
			sql += " 	, '"+pVactTime+"'									";
			sql += ") ON DUPLICATE KEY UPDATE dpst_cf_yn='N'	";
			
			
			// 입급내역 인서트
			stmt.executeUpdate(sql);
			
			
			
			
			
			out.print("OK"); // 절대로 지우지 마세요 - 이 메시지가 입금통보 OK메시지
			
			
			
			
			
		  
		} catch (Exception e){
			
			//System.out.println("SQL statement is not executed!");
			// SQL 입력시 에러가 발생하면...
			out.print(""+e.toString());
			//out.print("SQL statement is not executed!");
			
		  	e.printStackTrace();
		} finally { 
		    //if (rs!=null) 		try { rs.close(); } catch (Exception e) { } 
		    if (stmt !=null) try { stmt.close(); } catch (Exception e) { } 
	    	if (conn !=null) try { conn.close(); } catch (Exception e) { } 
 		} 

		
	    
	}
%>

	<script type="text/javascript">
		alert('<%= P_RMESG1 %>');
		
	    window.opener.fn_GoComplete(); 
	    var win = window.open('', '_self'); 
		win.close();
	</script>



