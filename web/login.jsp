<%@ page import ="java.sql.*" %>
<%
    String userid = request.getParameter("uname");    
    String pass = request.getParameter("pass");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elpoderdeuno",
            "root", "Futbold1392#");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from admin where nombre='" + userid + "' and pass='" + pass + "'");
    if (rs.next()) {
        session.setAttribute("userid", userid);
        //out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");
        response.sendRedirect("index.jsp");
    } else {
        out.println("Invalid password <a href='index1.jsp'>try again</a>");
    }
%>