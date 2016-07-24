<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.bjsxt.registeration.service.*" %>
<%@ page import="com.bjsxt.registeration.model.*" %>
<%

    String username = request.getParameter("username");
    String password = request.getParameter("password");

    User user = new User();
    user.setUsername(username);
    user.setPassword(password);

    UserManager userManager = new UserManager();

    boolean exists = false;
    try {
        exists = userManager.exists(user);
    } catch (SQLException e) {
        e.printStackTrace();
    }

    if (exists) {
        response.sendRedirect("registerFail.jsp");

    }

    try {
        userManager.add(user);
    } catch (SQLException e) {
        e.printStackTrace();
    }

    response.sendRedirect("registerSuccess.jsp");
%>
