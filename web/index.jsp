<%-- 
    Document   : index
    Created on : 10 nov 2022, 18:22:32
    Author     : Cristhian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script
      src="https://kit.fontawesome.com/64d58efce2.js"
      crossorigin="anonymous"
    ></script>
    </head>
    <body>        
     <div class="container">
               <c:if test="${success ==0}">
                    <div class="alert alert-danger" id="error">${mensaje}</div>
                </c:if>

        <section class="body">
    <div class="container">
        <div class="login-box">
            <div class="row">
                <div class="col-sm-6">
                    <div class="logo">
                        <span class="logo-font">Libreria</span>UMG
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6">
                    <br>
                    <h3 class="header-title">LOGIN</h3>
                    <form action="NewServlet" method="POST">
                    <form class="login-form">
                        <div class="form-group">
                            <input type="text" class="form-control" name="user" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Email or UserName">
                        </div>
                        <div class="form-group">
                            <input type="Password" class="form-control" class="form-control" name="pass" id="exampleInputPassword1"  placeholder="Password">
                        </div>
                        <div class="form-check">
              <input type="checkbox" class="form-check-input" id="exampleCheck1">
              <label class="form-check-label" for="exampleCheck1">Mantener mi sesion iniciada</label>
            </div>

                        <div class="form-group">
                            <input type="submit" class="btn btn-primary btn-block"></button>
                        </div>
                        <div class="form-group">
                            <div class="text-center">Nuevo Usuario? <a href="#!">Registrate Ya!</a></div>
                        </div>
                    </form>
                </div>
                <div class="col-sm-6 hide-on-mobile">
                    <div id="demo" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ul class="carousel-indicators">
                            <li data-target="#demo" data-slide-to="0" class="active"></li>
                            <li data-target="#demo" data-slide-to="1"></li>
                        </ul>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <div class="slider-feature-card">
                                    <img src="biblioteca.jpg" alt="">
                                    <h3 class="slider-title">Libreria UMG</h3>
                                    <p class="slider-description">Bienvenido al inicio de sesion a la pagina oficial de la biblioteca de la universidad.</p>
                                </div>
                            </div>
                            </div>
                        </div>                      
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
    </body>
</html>