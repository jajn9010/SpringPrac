<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<title></title>
<script type="text/javascript">
$(function () {
	$('#uploadForm').ajaxForm({
		cache: false,
	       dataType:"apllication/json",
	       //보내기전 validation check가 필요할경우
	       beforeSubmit: function (data, frm, opt) {
		       //console.log(data);
	           alert("전송전!!");
	           return true;
	       },
	       //submit이후의 처리
	       success: function(data, statusText){
	    	   alert("전송성공!!");
	           console.log(data); //응답받은 데이터 콘솔로 출력         
	       },
	       //ajax error
	       error: function(e){
	           alert("에러발생!!");
	           console.log(e);
	       }                   
	})
});

</script>
</head>
<body>
	<form action="fileUpload.do" name="uploadForm" id="uploadForm" enctype="multipart/form-data" method="post">
		<input type="text" name="title" id="title" placeholder="제목"> <br />
		<input type="text" name="writer" id="writer" placeholder="작성자"> <br />
		<input type="file" name="file" id="file"> <br />
		<input type="submit" name="submitBtn" id="submitBtn" value="전송하기" >
	</form>
</body>
</html>