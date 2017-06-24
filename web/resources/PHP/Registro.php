<?php
//Conexion con la base de datos y el servidor
$link=mysqli_connect("localhost","root","","Registro") or die("<h2>No se encuentra el servidor</h2>");


//Obtener los datos del formulario
$PrimerNombre=$_POST['PrimerNombre'];
$SegundoNombre=$_POST['SegundoNombre'];
$PrimerApellido=$_POST['PrimerApellido'];
$SegundoApellido=$_POST['SegundoApellido'];
$TipoDocumento=$_POST['TipoDocumento'];
$Documento=$_POST['Documento'];
$CorreoElectronico=$_POST['Email'];
$CCorreoElectronico=$_POST['CEmail'];
$TCelular=$_POST['TCelular'];
$TFijo=$_POST['TFijo'];
$Contraseña=$_POST['Contraseña'];
$CContraseña=$_POST['CContraseña'];

//Obtener la longitud de un string
$req =(strlen($PrimerNombre)*strlen($PrimerApellido)*strlen($TipoDocumento)*strlen($Documento)*strlen($CorreoElectronico)*strlen($Contraseña)) or die ("No se han llenado los campos requeridos");

//Se confirma la contraseña
if ($Contraseña != $CContraseña) {
	die("Las contraseñas no coinciden")
}

//Se encripta la contraseña
$ContraseñaUs = md5($Contraseña)

//Se ingresa la informacion a la tabla
mysql_query("INSERT INTO signupcomprador VALUES ('$PrimerNombre','$SegundoNombre','$PrimerApellido','$SegundoApellido','$TipoDocumeto','$Documento','$CorreoElectronico','$TCelular','$TFijo','$ContraseñaUs')")
?>