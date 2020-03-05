<%-- 
    Document   : newestudiante
    Created on : 26/02/2020, 02:01:03 PM
    Author     : arK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html >

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Freelancer - Start Bootstrap Theme</title>

  <!-- Custom fonts for this theme -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

  <!-- Theme CSS -->
  <link href="css/freelancer.min.css" rel="stylesheet">

</head>

<body id="page-top">

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand logo_h" href="index.html"
              ><img src="img/logo.png" alt=""
            /></a>
      <button class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          
          <li class="nav-item mx-0 mx-lg-1">
            <a class="btn btn-outline-primary" href="login.jsp">Entrar</a>
          </li>
          <li class="nav-item mx-0 mx-lg-1">
            <a class="btn btn-outline-info" href="#contact">Admin</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Masthead -->
  <section class="masthead bg-primary text-white text-center">
    <div class="container">

      <!-- Contact Section Heading -->
      <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Resgistrate Aqui !</h2>

      <!-- Icon Divider -->
      <div class="divider-custom">
        <div class="divider-custom-line"></div>
        <div class="divider-custom-icon">
          <i class="fas fa-star"></i>
        </div>
        <div class="divider-custom-line"></div>
      </div>

      <!-- Contact Section Form -->
      <div class="row">
        <div class="col-lg-8 mx-auto">
          <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
          <form id="contactForm" action="AccountestServlet?action=insert" method="post" enctype="multipart/form-data">
            <div class="control-group">
              <div class="form-group floating-label-form-group controls mb-0 pb-2">
                <label>Nombre</label>
                <input class="form-control" id="name" name ="nombre" type="text" placeholder="Nombre" required="required" data-validation-required-message="Por favor ingrese su Nombre.">
                <p class="help-block text-danger"></p>
              </div>
            </div>
              <div class="control-group">
              <div class="form-group floating-label-form-group controls mb-0 pb-2">
                <label>Apellido</label>
                <input class="form-control" id="apellido" name ="apellido" type="text" placeholder="Apellido" required="required" data-validation-required-message="Por favor ingrese su Apellido.">
                <p class="help-block text-danger"></p>
              </div>
            </div>
              <div class="control-group">
              <div class="form-group floating-label-form-group controls mb-0 pb-2">
                <label>N° Documento</label>
                <input class="form-control" id="documento" name ="documento" type="text" placeholder="Dodcumento de Identidad" required="required" data-validation-required-message="Por favor ingrese su Documento.">
                <p class="help-block text-danger"></p>
              </div>
            </div>
              <div class="control-group">
              <div class="form-group floating-label-form-group controls mb-0 pb-2">
                <label>Carrera</label>
                <input class="form-control" id="carrera" name ="carrera" type="text" placeholder="Programa Academico" required="required" data-validation-required-message="Por favor ingrese su Carrera.">
                <p class="help-block text-danger"></p>
              </div>
            </div>
            <div class="control-group">
              <div class="form-group floating-label-form-group controls mb-0 pb-2">
                <label>Email</label>
                <input class="form-control" id="email" type="email" name='email' placeholder="Email" required="required" data-validation-required-message="Por favor ingrese su Email.">
                <p class="help-block text-danger"></p>
              </div>
            </div>
            <div class="control-group">
              <div class="form-group floating-label-form-group controls mb-0 pb-2">
                <label>Password</label>
                <input class="form-control" id="password" name="password" type="password" placeholder="Password" required="required" data-validation-required-message="Por favor ingrese un password.">
                <p class="help-block text-danger"></p>
              </div>
            </div>
            <div class="control-group">
              <div class="form-group floating-label-form-group controls mb-0 pb-2">
                <input type="file" name="foto" value="foto" class="form-control" id="foto"/>
                <label for="foto"> Selecccione su foto de perfil</label>
                <p class="help-block text-danger"></p>
              </div>
            </div>
            <br>
            <div id="success"></div>
            <div class="form-group">
              <input class="btn icon-btn btn-success" type="submit" name="action" value="insertar">
              <span class="glyphicon glyphicon-ok-sign"></span>
                            
              <input class="btn btn-info btn-lg" type="reset" name="action" value="Reset">
              <span class="glyphicon glyphicon-remove"></span>
            </div>
          </form>
        </div>
      </div>

    </div>
  </section>

  <!-- Footer -->
  <footer class="footer text-center">
    <div class="container">
      <div class="row">

        <!-- Footer Location -->
        <div class="col-lg-4 mb-5 mb-lg-0">
          <h4 class="text-uppercase mb-4">Developers</h4>
          <p class="lead mb-0">Diego Chavarria
            <br>Arcangel Marin
            <br>Julian Angel
          <br>Alejandro Gallego
          <br>Angres Cortes</p>
        </div>

        <!-- Footer Social Icons -->
        <div class="col-lg-4 mb-5 mb-lg-0">
          
          
               <img src="img/logo-udea.png">
          
          
        </div>

        <!-- Footer About Text -->
        <div class="col-lg-4">
          <h4 class="text-uppercase mb-4">Arquitectura de Software</h4>
          <p class="lead mb-0">Laborarorio 1. 
            <a href="https://sites.google.com/site/cursosdiegobotia/">CursosDiegoBotia</a>.</p>
        </div>

      </div>
    </div>
  </footer>

  <!-- Copyright Section -->
  <section class="copyright py-4 text-center text-white">
    <div class="container">
      <small>Copyright &copy; Estudiantes S.I 2020</small>
    </div>
  </section>

 

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Contact Form JavaScript -->
  <script src="js/jqBootstrapValidation.js"></script>
  

  <!-- Custom scripts for this template -->
  <script src="js/freelancer.min.js"></script>

</body>

</html>