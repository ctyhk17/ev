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
 * �̴Ͻý� ������� �Աݳ��� ó��demon���� �Ѿ���� �Ķ���͸� control �ϴ� �κ� �Դϴ�.
 * [��������] �ڼ��� ������ �޴��� ����
 * ������           �ѱ۸�                           
 * no_tid           �ŷ���ȣ                         
 * no_oid           �ֹ���ȣ                         
 * cd_bank          �ŷ��߻� ����ڵ�                
 * cd_deal          ��ޱ���ڵ�                     
 * dt_trans         �ŷ�����                         
 * tm_trans         �ŷ��ð�                         
 * no_vacct         ���¹�ȣ                         
 * amt_input        �Աݱݾ�                         
 * amt_check        �̰���Ÿ���Ǳݾ�                 
 * flg_close        ��������                         
 * type_msg         �ŷ�����                         
 * nm_inputbank     �Ա������                       
 * nm_input         �Ա��ڸ�                         
 * dt_inputstd      �Աݱ�������                     
 * dt_calculstd     �����������                     
 * dt_transbase     �ŷ���������                     
 * cl_trans         �ŷ������ڵ� "1100"              
 * cl_close         �������� ����,  0:������, 1������
 * cl_kor           �ѱ۱����ڵ�, 2:KSC5601          
 *
 * (�������ä���� ���ݿ����� �ڵ��߱޽�û�ÿ��� ����)
 * dt_cshr          ���ݿ����� �߱�����              
 * tm_cshr          ���ݿ����� �߱޽ð�              
 * no_cshr_appl     ���ݿ����� �߱޹�ȣ              
 * no_cshr_tid      ���ݿ����� �߱�TID               
 *******************************************************************************/

/***********************************************************************************
 * �̴Ͻý��� �����ϴ� ���������ü�� ����� �����Ͽ� DB ó�� �ϴ� �κ� �Դϴ�.	
 * �ʿ��� �Ķ���Ϳ� ���� DB �۾��� �����Ͻʽÿ�.
 ***********************************************************************************/	




 	String file_path = "/home/mcfund/logs";  //�α׸� ����� ���͸�

    id_merchant = request.getParameter("id_merchant");
    no_tid 		= request.getParameter("no_tid");
    no_oid 		= request.getParameter("no_oid");
    no_vacct 	= request.getParameter("no_vacct");
    amt_input 	= request.getParameter("amt_input");
    nm_inputbank = request.getParameter("nm_inputbank");
    nm_input 	= request.getParameter("nm_input");
    
    type_msg 	= request.getParameter("type_msg");

    // �Ŵ����� ���ð� �߰��Ͻ� �Ķ���Ͱ� �����ø� �Ʒ��� ���� ������� �߰��Ͽ� ����Ͻñ� �ٶ��ϴ�.

    // String value = reqeust.getParameter("������ �ʵ��");

	try
	{
        //writeLog(file_path);

//***********************************************************************************
//
//	������ ���� �����ͺ��̽��� ��� ���������� ���� �����ÿ��� "OK"�� �̴Ͻý���
//	�����ϼž��մϴ�. �Ʒ� ���ǿ� �����ͺ��̽� ������ �޴� FLAG ������ ��������
//	(����) OK�� �������� �����ø� �̴Ͻý� ���� ������ "OK"�� �����Ҷ����� ��� �������� �õ��մϴ�
//	��Ÿ �ٸ� ������ out.println(response.write)�� ���� �����ñ� �ٶ��ϴ�
	

		

        Context initCtx = null; 
		DataSource ds   = null; 
		Connection conn = null;
		Statement stmt  = null;
		ResultSet rs    = null;




		try
		{
			// �����Ա� : 0200
			// ��� : 0400
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
					
				// �ֹ���Ȳ ������Ʈ
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
				
				
				// �Ա޳��� �μ�Ʈ
				stmt.executeUpdate(sql);
			
			}
			
			
			out.print("OK"); // ����� ������ ������ - �� �޽����� �Ա��뺸 OK�޽���
			
			
			
			
			
		  
		} catch (Exception e){
			
			//System.out.println("SQL statement is not executed!");
			// SQL �Է½� ������ �߻��ϸ�...
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
