<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dao.impl.BizDaoImpl" %>
<%@ page import="entity.UserInfo" %>
<%@ page import="service.BizServicerImpl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<title>添加主题--管理后台</title>
<link href="CSS/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String ursename=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		UserInfo user=new UserInfo();
		user.setUserid(1234);
		user.setPassword(pwd);
		BizDaoImpl bdi=new BizDaoImpl();
		bdi.denglu(user);
		BizServicerImpl bsi=new BizServicerImpl();
		bsi.setBizdao(bdi);
		boolean flag=bsi.denglu(user);
		if(flag){
		    session.setAttribute("login", ursename);
		  request.getRequestDispatcher("admin/admin.jsp").forward(request, response);  
		
		}else{
		    response.sendRedirect("index.jsp");
		}
	%>
</body>
</html>