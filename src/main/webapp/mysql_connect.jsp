<%--
  @author sh1ro
  @date 2022/12/25
  @description
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>">
</head>
<body style="text-align:center;" >
<form action="${pageContext.request.contextPath}/mysql_connect.do" method="post" >
    dbUrl:<input name="db_url" value="jdbc:mysql://127.0.0.1:3306/test?autoDeserialize=true" style="width: 350px;height: 20px" > <br/>
    db_user:<input name="db_user" value="" style="width: 350px;height: 20px" ><br/>
    db:pass<input name="db_pass" value="" style="width: 350px;height: 20px" ><br/>
    <input type="submit" name="connect" value="add">
</form>

</body>
</html>
