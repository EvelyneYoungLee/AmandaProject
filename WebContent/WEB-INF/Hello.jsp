<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style>
.pointcard-body{
background-color: #bbe3e3;

}

</style>
</head>
<body>
<div class="card my-card border-danger">
						<div class="pointcard-body">
						<c:choose>
						<c:when test="${user.point ne 0}">
									<h5 class="card-title"><img src="https://img.icons8.com/color/48/000000/human-head.png">
									${user.name}�Թݰ����ϴ�</h5>
									</c:when>
								<c:otherwise>
								<h5 class="card-title"><img src="https://img.icons8.com/color/48/000000/human-head.png">
									${user.name}�������� �ʿ��մϴ�</h5>
								</c:otherwise>	
							</c:choose>	
							
							<p class="card-text"></p>
									<h5><img src="https://img.icons8.com/color/30/000000/sales-performance.png">
									${user.name }���� ���� �ܿ�����Ʈ�� <span id="point">${user.point}	</span> �Դϴ�.
									</h5>
									<h5><img src="https://img.icons8.com/color/30/000000/alarm-clock.png">
									
									${user.name }����
										���� ���� �ð��� <span id="timeout"></span> �Դϴ�.
									</h5><br>
									<script>  $("#timeout").html( "<font color='red'>" + (Math.floor(${user.point}/60))+ "�� " +"</font>")  </script>
									</div>
					</div>
</body>
</html>