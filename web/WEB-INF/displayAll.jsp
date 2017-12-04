<!--  import packages and classes needed by scripts -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       

<!DOCTYPE HTML> 
<html>
    <head>
        <title>Lista Participantes</title>
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

        <p>Lista Participantes</p>

        <table>
            <thead>
                <tr>
                    <th style="width:100px;">Id Matricula</th>
                    <th style = "width: 100px;">Nombre</th>
                    <th style = "width: 200px;">Apellido Paterno</th>
                    <th style = "width: 200px;">Apellido Materno</th>
                    <th style = "width: 100px;">Correo</th>
                    <th style = "width:100px;">Edad</th>
                    <th style = "width:100px;">Genero</th>
                    <th style = "width: 300px;">Teléfono</th>
                    <th style = "width:100px;">Nivel de Estudio</th>
                    <th style = "width:100px;">Proyecto</th>
                </tr>
            </thead>

            <tbody>                                                                          
                <c:forEach var="participantesElement" items="${ParticipantesList}" >                                      
                    <tr>
                        <td>${participantesElement.idMatricula}</td>
                        <td>${participantesElement.nombre}</td>    
                        <td>${participantesElement.apellidoP}</td>  
                        <td>${participantesElement.apellidoM}</td>
                        <td>${participantesElement.correo}</td>
                        <td>${participantesElement.edad}</td>
                        <td>${participantesElement.genero}</td>
                        <td>${participantesElement.telefono}</td>
                        <td>${participantesElement.nivelEstudio}</td>
                        <td>${participantesElement.proyecto}</td>
                        <td>
                            <a href="/Proyecto_Final_ElPoderdeUno/updateParticipante?idMatricula=${participantesElement.idMatricula}"> Actualizar</a>
                            <a href="/Proyecto_Final_ElPoderdeUno/deleteParticipante?idMatricula=${participantesElement.idMatricula}"> Borrar</a>
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