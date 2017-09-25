<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<%
  /**
  * @Class Name : McmMalGds001P001C.jsp
  * @Description : 이미지 팝업
  * @Modification Information
  *
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2017.06.20            최초 생성
  *
  * author 개발팀
  * since 2017.06.20
  *
  */
%>
<!doctype html> 
<html lang="ko">
<head>
<title>이미지 업로드</title>
	    <%@ include file="/WEB-INF/jsp/kr/co/mcmall/mcm/include/McmAdminHeadInclude.jsp" %>
	    <script>
		    $(document).ready(function(){
		    	$('#btnCancle').click(function(){
		    		window.close();
		    	})
		    	
		    	$('#btnOk').click(function(){
		    		fnUpload();
		    	});
		    	
		          var fileTarget = $('.filebox #fileNm');
	
		            fileTarget.on('change', function(){
		                if(window.FileReader){
		                    var filename = $(this)[0].files[0].name;
		                } else {
		                    var filename = $(this).val().split('/').pop().split('\\').pop();
		                }
	
		                $(this).siblings('.upload-name').val(filename);
		            });
		            
		        });
		    
		    function fnUpload(){
		    	var fileNm = document.getElementById("fileNm");
		    	var FileUploadPath = fileNm.value;
		    	
		    	var indexOfValue = FileUploadPath.lastIndexOf("\\");
		    	var indexOfVlaueTwo = FileUploadPath.lastIndexOf(".");
		    	var indexOfLength = FileUploadPath.length;
		    	
		    	var indexOfStr = FileUploadPath.substring(indexOfValue+1,indexOfVlaueTwo);
		    	var indexOfStrTwo = FileUploadPath.substring(indexOfVlaueTwo+1,indexOfLength);
		    	var finalIndex = indexOfStr + "." + indexOfStrTwo;
		    	
				var Extension = FileUploadPath.substring(FileUploadPath.lastIndexOf('.') + 1).toLowerCase();
		    	
				
				if(Extension == "gif" || Extension == "png" || Extension == "bmp"|| Extension == "jpeg" || Extension == "jpg") {
					//호출
					$("#McmMalGds001VO").ajaxSubmit({
			        	url : '/McmMalGds001P13CP.do',
			        	type : 'POST',
			        	dataType:'json',
			        	complete : function(result) {
			        		
			        		var fileName = result.responseJSON.tempNm;
			        		var oriFileName = result.responseJSON.fileName;
			        		var filePath =  result.responseJSON.filePath;
			        		 $("#gdsImgNm2",opener.document).val(finalIndex);
			        		 $("#gdsAttMnImg",opener.document).val(oriFileName);
			        		 $("#gdsAttImgPath",opener.document).val(filePath+fileName);
			        		 $("#parentImgBox2",opener.document).attr("src",$("#img_box_img").attr("src"));
			        		 window.close();
			        	},
			        	error : function() {
			        		alert('이미지를 선택해주세요');
			        	}
			        });
				}else{
					alert("이미지를 선택해주세요.");
				}
		    	
		    }
		    
		    
			function fnFileInfo(f){
				var file = f.files; // files 를 사용하면 파일의 정보를 알 수 있음

				var reader = new FileReader(); // FileReader 객체 사용
				reader.onload = function(rst){ // 이미지를 선택후 로딩이 완료되면 실행될 부분
					$('#img_box').html('<img id="img_box_img" src="' + rst.target.result + '">'); // append 메소드를 사용해서 이미지 추가
					// 이미지는 base64 문자열로 추가
					// 이 방법을 응용하면 선택한 이미지를 미리보기 할 수 있음
				}
				reader.readAsDataURL(file[0]); // 파일을 읽는다, 배열이기 때문에 0 으로 접근
			}
		    
	    </script>
	    <style>
		    .popup_photo b {color: red;}
		    .popup_photo {width: 100%;margin: 0% auto;max-width: 700px;}
		    .popup_photo > div > h1{font-size: 18px;background: #f2f2f2;padding: 5px 0 10px 0;text-align: center;}
		    .check{border-bottom: 1px solid #8b8b8b;padding: 10px 0;}
		    .check > input{vertical-align: -2px;margin-right: 5px;}
		    .check_box_1 {padding: 0 0;padding: 15px 0;}
		    .photo_box {border: 1px solid #c3c3c3; text-align: center;margin: 5px 0 15px 0; padding: 100px; 0;background: #f2f2f2;}
		    .save_btn {display: inline-block;width: 100%;text-align: center;border-top: 1px solid #8b8b8b;}
		    .save_btn a{display: inline-block;padding: 4px 10px;border: 1px solid #d0d0d0;margin: 2% 1%; cursor: pointer;color: black; background: #f0f0f0;font-size: 14px;}
		    .check_box_1 p{font-size: 13px;line-height: 150%;}
		    #img_box_img{margin: 3% 0 0 25%; width:40%;}   
		    .check_box_2 {text-align: center;margin: 15px 0;line-height: 290px;}
		        
		    .display_block {display: block;}
		    .display_none {display: none;}
		    
		    .check:after{content: '';display: block;clear: both;}
		    .check{font-size: 14px;}
		    .active_1 {float: left;padding: 5px 10px;border: 1px solid #8d8d8d;}
		    .active_2 {float: left;padding: 5px 10px;border: 1px solid #8d8d8d;}
		    .active_1 {cursor: pointer;}
		    .active_2 {cursor: pointer;margin: 0 5px;}
		    .active_text {color: red;border: 1px solid red;font-weight: bold;}
		    .filebox{margin-left: 14%;}
		    .where {
		      display: block;
		      margin: 25px 15px;
		      font-size: 11px;
		      color: #000;
		      text-decoration: none;
		      font-family: verdana;
		      font-style: italic;
		    } 
		
		    .filebox input[type="file"] {
		        position: absolute;
		        width: 1px;
		        height: 1px;
		        padding: 0;
		        margin: -1px;
		        overflow: hidden;
		        clip:rect(0,0,0,0);
		        border: 0;
		    }
		
		    .filebox label {
		        display: inline-block;
		        padding: .5em .75em;
		        color: #999;
		        font-size: inherit;
		        line-height: normal;
		        vertical-align: middle;
		        background-color: #fdfdfd;
		        cursor: pointer;
		        border: 1px solid #ebebeb;
		        border-bottom-color: #e2e2e2;
		        border-radius: .25em;
		    }
		
		    /* named upload */
		    .upload-name {width: 250px;}
		    .filebox .upload-name {
		        display: inline-block;
		        padding: .5em .75em;
		        font-size: inherit;
		        font-family: inherit;
		        line-height: normal;
		        vertical-align: middle;
		        background-color: #f5f5f5;
		      border: 1px solid #ebebeb;
		      border-bottom-color: #e2e2e2;
		      border-radius: .25em;
		      -webkit-appearance: none;
		      -moz-appearance: none;
		      appearance: none;
		    }
		
		    .filebox.bs3-primary label {
		      color: #fff;
		        background-color: #989898;
		    }
		    @media all and (max-width: 500px){
		        .upload-name {width: 170px;}
		    }

    </style>
	    
	    
</head>
<body style="height: 300px;">
	<form:form commandName="McmMalGds001VO" name="McmMalGds001VO" method="post" enctype="multipart/form-data">
	    <div class="popup_photo">
	        <div><h1 style="margin-bottom: 5%;">사진첨부하기</h1></div>
	        <div class="check_box_1">
	            <div class="filebox bs3-primary">
	                <input class="upload-name" value="파일선택" disabled="disabled">
					<label for="fileNm">찾아보기</label> 
	                <input type="file" id="fileNm" name="fileNm" class="upload-hidden" onchange="fnFileInfo(this)">
	                <p><b style="margin-left: -7%;">이미지 파일을 등록할 수 있습니다. (JPG, GIF, PNG BMP)</b></p>
	                <div id="img_box" class="img_box"></div> 
	            </div>
	        </div>
	        <div class="save_btn">
	            <a href="#" id="btnOk">확인</a><a href="#" id="btnCancle">취소</a>
	        </div>
	    </div>
    </form:form>
</body>
</html>