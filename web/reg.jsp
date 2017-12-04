<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <form method="post" action="registration.jsp">
            <center>
                <img src="img/logo.png">
                <table border="1" width="30%" cellpadding="5">
                    <thead>
                        <tr>
                            <th colspan="2">Ingrese información aquí</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Nombre</td>
                            <td><input type="text" name="nombre" value="" /></td>
                        </tr>
                        <tr>
                            <td>Apellidos</td>
                            <td><input type="text" name="apellidos" value="" /></td>
                        </tr>
                        <tr>
                            <td>Correo</td>
                            <td><input type="text" name="correo" value="" /></td>
                        </tr>
                        <tr>
                            <td>Usuario</td>
                            <td><input type="text" name="usuario" value="" /></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="password" name="pass" value="" /></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Submit" /></td>
                            <td><input type="reset" value="Reset" /></td>
                        </tr>
                        <tr>
                            <td colspan="2">Ya registrado <a href="index.jsp">Entre aquí</a></td>
                        </tr>
                    </tbody>
                </table>
            </center>
        </form>
    </body>
</html>