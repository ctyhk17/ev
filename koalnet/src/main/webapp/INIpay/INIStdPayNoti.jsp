<%@ page  contentType="text/html; charset=euc-kr" %>
<%@ page import = "java.io.*" %>
<%@ page import = "java.util.Calendar" %>

<%@ page import = "java.sql.*" %>
<%@ page import = "javax.sql.*" %>
<%@ page import = "javax.naming.*" %>
<%@ page import = "java.sql.SQLException" %>


<%

System.out.println("INIStdPayNoti.jsp ----------- start");

/*******************************************************************************
 * FILE NAME : vacctinput.jsp
 * DATE : 2009.07
 * 이니시스 가상계좌 입금내역 처리demon으로 넘어오는 파라메터를 control 하는 부분 입니다.
 * [수신정보] 자세한 내용은 메뉴얼 참조
 * 변수명           한글명                           
 * no_tid           거래번호                         
 * no_oid           주문번호                         
 * cd_bank          거래발생 기관코드                
 * cd_deal          취급기관코드                     
 * dt_trans         거래일자                         
 * tm_trans         거래시각                         
 * no_vacct         계좌번호                         
 * amt_input        입금금액                         
 * amt_check        미결제타점권금액                 
 * flg_close        마감구분                         
 * type_msg         거래구분                         
 * nm_inputbank     입금은행명                       
 * nm_input         입금자명                         
 * dt_inputstd      입금기준일자                     
 * dt_calculstd     정산기준일자                     
 * dt_transbase     거래기준일자                     
 * cl_trans         거래구분코드 "1100"              
 * cl_close         마감전후 구분,  0:마감점, 1마감후
 * cl_kor           한글구분코드, 2:KSC5601          
 *
 * (가상계좌채번시 현금영수증 자동발급신청시에만 전달)
 * dt_cshr          현금영수증 발급일자              
 * tm_cshr          현금영수증 발급시간              
 * no_cshr_appl     현금영수증 발급번호              
 * no_cshr_tid      현금영수증 발급TID               
 *******************************************************************************/

/***********************************************************************************
 * 이니시스가 전달하는 가상계좌이체의 결과를 수신하여 DB 처리 하는 부분 입니다.	
 * 필요한 파라메터에 대한 DB 작업을 수행하십시오.
 ***********************************************************************************/	




 	String file_path = "/home/mcfund/logs";  //로그를 기록할 디렉터리

    id_merchant = request.getParameter("id_merchant");
    no_tid 		= request.getParameter("no_tid");
    no_oid 		= request.getParameter("no_oid");
    no_vacct 	= request.getParameter("no_vacct");
    amt_input 	= request.getParameter("amt_input");
    nm_inputbank = request.getParameter("nm_inputbank");
    nm_input 	= request.getParameter("nm_input");
    
    type_msg 	= request.getParameter("type_msg");

    // 매뉴얼을 보시고 추가하실 파라메터가 있으시면 아래와 같은 방법으로 추가하여 사용하시기 바랍니다.

    // String value = reqeust.getParameter("전문의 필드명");

	try
	{
        //writeLog(file_path);

//***********************************************************************************
//
//	위에서 상점 데이터베이스에 등록 성공유무에 따라서 성공시에는 "OK"를 이니시스로
//	리턴하셔야합니다. 아래 조건에 데이터베이스 성공시 받는 FLAG 변수를 넣으세요
//	(주의) OK를 리턴하지 않으시면 이니시스 지불 서버는 "OK"를 수신할때까지 계속 재전송을 시도합니다
//	기타 다른 형태의 out.println(response.write)는 하지 않으시기 바랍니다
	

		

        Context initCtx = null; 
		DataSource ds   = null; 
		Connection conn = null;
		Statement stmt  = null;
		ResultSet rs    = null;




		try
		{
			// 정상입금 : 0200
			// 취소 : 0400
			if("0200".equals(type_msg))
			{
				
				initCtx = new InitialContext(); 
				ds = (DataSource)initCtx.lookup("java:/comp/env/jdbc/fundDB");
				
				conn = ds.getConnection();
				
				
				stmt = conn.createStatement();
				
				
				//P_STATUS
				//P_TYPE
				
				
				String sql = "";
				sql += "update tb_fndord001                    	";
				sql += "set										";
				sql += "      pay_yn		= 'Y'						";
				sql += "    , pay_dt		= CURRENT_TIMESTAMP() 	";
				sql += "    , pay_mth_cd  = 'VBANK'				";
				sql += "    , pay_div_cd  = 'ACC001002'				";
				sql += "where									";
				sql += "    ord_no = '"+no_oid+"'						";
				//sql += "    and usr_id = #usrId#					";
					
				// 주문현황 업데이트
				stmt.executeUpdate(sql);
				
				
				
				sql = "";
				sql += "insert into tb_accrcv001					";
				sql += "(											";
				sql += "	  usr_id								";
				sql += "	, ord_no								";
				sql += "	, dpst_seq_no							";
				sql += "	, dpst_amt								";
				sql += "	, dpst_dt								";
				sql += "	, dpst_cf_yn							";
				sql += "	, tid									";
				sql += ") values (									";
				sql += "	  (select usr_id from tb_fndord001 where ord_no = '"+no_oid+"')		";
				sql += "	, '"+no_oid+"'							";
				sql += "	, nextval('seq_ord_dpst_seq_no')		";
				sql += "	, '"+amt_input+"'							";
				sql += "	, CURRENT_TIMESTAMP()					";
				sql += "	, 'Y'									";
				sql += "	, '"+no_tid+"'							";
				sql += ") ON DUPLICATE KEY UPDATE dpst_cf_yn='Y'	";
				
				
				// 입급내역 인서트
				stmt.executeUpdate(sql);
			
			}
			
			
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
	catch(Exception e)
	{
		out.print(e.getMessage());
	}

%>
<%!

    private String id_merchant;
    private String no_tid;
    private String no_oid;
    private String no_vacct;
    private String amt_input;
    private String nm_inputbank;
    private String nm_input;
    private StringBuffer times;
    
    private String type_msg;

    private String getDate()
    {
    	Calendar calendar = Calendar.getInstance();
    	
    	times = new StringBuffer();
        times.append(Integer.toString(calendar.get(Calendar.YEAR)));
		if((calendar.get(Calendar.MONTH)+1)<10)
        { 
            times.append("0"); 
        }
		times.append(Integer.toString(calendar.get(Calendar.MONTH)+1));
		if((calendar.get(Calendar.DATE))<10) 
        { 
            times.append("0");	
        } 
		times.append(Integer.toString(calendar.get(Calendar.DATE)));
    	
    	return times.toString();
    }
    
    private String getTime()
    {
    	Calendar calendar = Calendar.getInstance();
    	
    	times = new StringBuffer();

    	times.append("[");
    	if((calendar.get(Calendar.HOUR_OF_DAY))<10) 
        { 
            times.append("0"); 
        } 
 		times.append(Integer.toString(calendar.get(Calendar.HOUR_OF_DAY)));
 		times.append(":");
 		if((calendar.get(Calendar.MINUTE))<10) 
        { 
            times.append("0"); 
        }
 		times.append(Integer.toString(calendar.get(Calendar.MINUTE)));
 		times.append(":");
 		if((calendar.get(Calendar.SECOND))<10) 
        { 
            times.append("0"); 
        }
 		times.append(Integer.toString(calendar.get(Calendar.SECOND)));
 		times.append("]");
 		
 		return times.toString();
    }

    private void writeLog(String file_path) throws Exception
    {

        File file = new File(file_path);
        file.createNewFile();

        FileWriter file2 = new FileWriter(file_path+"/vacctinput_"+getDate()+".log", true);


        file2.write("\n************************************************\n");
        file2.write("PageCall time : " + getTime());
        file2.write("\nID_MERCHANT : " + id_merchant);
        file2.write("\nNO_TID : " + no_tid);
        file2.write("\nNO_OID : " + no_oid);
        file2.write("\nNO_VACCT : " + no_vacct);
        file2.write("\nAMT_INPUT : " + amt_input);
        file2.write("\nNM_INPUTBANK : " + nm_inputbank);
        file2.write("\nNM_INPUT : " + nm_input);
        file2.write("\n************************************************\n");

        file2.close();

    }
%>
