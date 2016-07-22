<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.*" %>
<%

    String username = request.getParameter("username");
    String password = request.getParameter("password");
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/spring","root","");

    String sql_check = "select count(*) from user where username=? ";
    PreparedStatement ps_check = conn.prepareStatement(sql_check);
    ps_check.setString(1,username);
    ResultSet rs = ps_check.executeQuery();
    rs.next();
    int count = rs.getInt(1);
    if(count >0){
        response.sendRedirect("registerFail.jsp");
        ps_check.close();
        conn.close();
        return;
    }


    String sql = "insert into user values(null,?,?)";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1,username);
    ps.setString(2,password);
    ps.executeUpdate();
    ps.close();
    conn.close();
    response.sendRedirect("registerSuccess.jsp");
%>
