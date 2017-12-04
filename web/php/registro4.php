<?php
$db_host="10.32.109.174";
$db_user="ciudadano";
$db_password="elpoderdeuno";
$db_name="elpoderdeuno";
$db_table_name="solicitud";
   $db_connection = mysql_connect($db_host, $db_user, $db_password);
 
if (!$db_connection) {
	die('No se ha podido conectar a la base de datos');
}



$subs_asunto = ($_POST['asunto']);
$subs_texto = ($_POST['texto']);
$subs_email = ($_POST['email']);
$subs_nombre = ($_POST['nombre']);
$subs_claveTema = 4;

 

	
	//$insert_value = "INSERT INTO solicitud  (asunto, texto, email, nombre , claveTema)
	//VALUES('$asunto_texto','$subs_texto','$subs_email','$subs_nombre', $subs_claveTema)";
	
$insert_value =  "INSERT INTO elpoderdeuno.solicitud (asunto, texto, email,nombre, tema)
	VALUES('$subs_asunto','$subs_texto','$subs_email','$subs_nombre',$subs_claveTema)";
 
mysql_select_db($db_name, $db_connection);
$retry_value = mysql_query($insert_value, $db_connection);
 
if (!$retry_value) {
   die('Error: ' . mysql_error());
}
header('Location: ../seguridad.html');	
 
mysql_close($db_connection);
		
?>