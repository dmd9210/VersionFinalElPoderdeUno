<%@ page import ="java.sql.*" %>
<%
    String usuario = request.getParameter("usuario");
    String pwd = request.getParameter("pass");
    String nombre = request.getParameter("nombre");
    String apellidos = request.getParameter("apellidos");
    String correo = request.getParameter("correo");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elpoderdeuno",
            "root", "Futbold1392#");
    Statement st = con.createStatement();
    //ResultSet rs;
    int i = st.executeUpdate("insert into admin(nombre, apellidos, correo, usuario, pass, regdate) values ('" + nombre + "','" + apellidos + "','" + correo + "','" + usuario + "','" + pwd + "', CURDATE())");
    if (i > 0) {
        //session.setAttribute("userid", user);
        response.sendRedirect("welcome.jsp");
        // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
    } else {
        response.sendRedirect("index.jsp");
    }
%>