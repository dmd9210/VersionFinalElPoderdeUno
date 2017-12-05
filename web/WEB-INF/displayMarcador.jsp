<!--  import packages and classes needed by scripts -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       

<!DOCTYPE HTML> 
<html>
    <head>
        <title>Marcador</title>
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

        <p>Lista Marcador</p>

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
                                                     
                    <tr>
                        <td>${marcador.idMarcadores}</td>
                        <td>${marcador.nombre}</td>    
                        <td>${marcador.longitud}</td>  
                        <td>${marcador.latitud}</td>
                        
                        <td>
                            <a href="/VersionFinalElPoderdeUno/updateMarcador?idMarcadores=${marcador.idMarcadores}"> Actualizar</a>
                            <a href="/VersionFinalElPoderdeUno/deleteMarcador?idMarcadores=${marcador.idMarcadores}"> Borrar</a>
                        </td>
        </tr>
    
</tbody>
</table>
<h4>
    <a href="index.jsp">Return to Main page</a>
</h4>

</body>    
</html>