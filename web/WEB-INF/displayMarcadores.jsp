<!--  import packages and classes needed by scripts -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       

<!DOCTYPE HTML> 
<html>
    <head>
        <title>Lista Marcadores</title>
        <style type = "text/css">
            body {     
                font-family: tahoma, helvetica, arial, sans-serif; 
            }
            table, tr, td, th { 
                text-align: center;
                font-size: .9em;
                border: 3px groove;
                padding: 5px;
                background-color: #dddddd;
            }
            p {
                font-size: 2em;
            }

        </style>
    </head>

    <%-- UserDao in dataAccess to obtain list --%>
    <body> 

        <p>Lista Marcadores</p>

        <table>
            <thead>
                <tr>
                    <th style="width:100px;">Id Marcador</th>
                    <th style = "width: 100px;">Nombre</th>
                    <th style = "width: 200px;">Latitud</th>
                    <th style = "width: 200px;">Longitud</th>
                    
                </tr>
            </thead>

            <tbody>                                                                          
                <c:forEach var="marcadoresElement" items="${MarcadoresList}" >                                      
                    <tr>
                        <td>${marcadoresElement.idMarcadores}</td>
                        <td>${marcadoresElement.nombre}</td>    
                        <td>${marcadoresElement.latitud}</td>  
                        <td>${marcadoresElement.longitud}</td>
                        
                        <td>
                            <a href="/VersionFinalElPoderdeUno/updateMarcador?idMarcadores=${marcadoresElement.idMarcadores}"> Actualizar</a>
                            <a href="/VersionFinalElPoderdeUno/deleteMarcador?idMarcadores=${marcadoresElement.idMarcadores}"> Borrar</a>
                        </td>
        </tr>
    </c:forEach>  
</tbody>
</table>
<h4>
    <a href="index.jsp">Return to Main page</a>
</h4>

</body>    
</html>