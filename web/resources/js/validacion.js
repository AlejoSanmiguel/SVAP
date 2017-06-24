$().ready(function(){
  $('input[type="submit"]').click(function(e){
    e.preventDefault();    
    usuario = $('#numeroDoc').val();
    clave = $('#password').val();
    if (usuario==='' && clave===''){
      sweetAlert("Oops...", "No has ingresado tus datos, Intentalo de nuevo");
    }else if (usuario==='' && clave==='12345678'){
      sweetAlert("Oops...", "No has ingresado tu numero de documento, Intentalo de nuevo");
    }else if (usuario!==0 && clave===''){
      sweetAlert("Oops...", "No has ingresado tu contraseÃ±a, Intentalo de nuevo");
    }
    else{
      sweetAlert("Oops...", "Los sentimos los datos ingresados son incorrectos, Intentalo de nuevo");
    };
  });
  
});