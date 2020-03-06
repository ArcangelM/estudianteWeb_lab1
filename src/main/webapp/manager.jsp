<%-- 
    Document   : manager2
    Created on : 3/03/2020, 01:49:06 AM
    Author     : arK
--%>

<%@page import="com.udea.estudianteweb_lab1.modelo.Materia"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>User manage</title>

  <!-- Custom fonts for this theme -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

  <!-- Theme CSS -->
  <link href="css/freelancer.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="css/main.css">

 
  
  
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
            <a class="btn btn-outline-danger" href="login.jsp">Logout</a>
          </li>
          
        </ul>
      </div>
    </div>
  </nav>

  <!-- Masthead -->
  <header class="masthead bg-primary text-white text-center">
     
      <div class="container d-flex align-items-center flex-column">
      
          <c:if test="${estudiante.foto ne null}">
                        <img src="<%=request.getContextPath()%>/AccountestServlet?email=${estudiante.email}" class="masthead-avatar mb-5" alt=""/>
                    </c:if>
          
      <!-- Masthead Heading -->
      <h1 class="masthead-heading text-white mb-0">${estudiante.nombre} ${estudiante.apellido} </h1>

      <!-- Icon Divider -->
      <div class="divider-custom divider-light">
        <div class="divider-custom-line"></div>
        <div class="divider-custom-icon">
          <i class="fas fa-star"></i>
        </div>
        <div class="divider-custom-line"></div>
      </div>

      <!-- Masthead Subheading -->
      <p class="masthead-subheading font-weight-light mb-0">DOCUMENTO: ${estudiante.documento}</p>
      <p class="masthead-subheading font-weight-light mb-0">CARRERA: ${estudiante.carrera}</p>
      
    </div>
  </header>
      <section>
          <!--<div btn-group btn-group-justified>-->
          <div>
              <br>
          </div>
          
      <!--</div>-->
      </section>
     
      <!---prueba modal--->
      <!-- Button trigger modal -->
      <!--<form action="MostrarMateriaServlet?action=mostrar" method="post">-->
      <!--data-toggle="modal" data-target="#exampleModalCenter"-->
      <button type="button" class="btn btn-success" id="btn_modal" data-toggle="modal" data-target="#exampleModalCenter" >
  MATRICULAR CURSO
</button>
      
<button type="button" class="btn btn-warning" id="btn_modal" data-toggle="modal" data-target="#exampleModalCenter" >
    ESTADO CURSOS
</button>
      
<div>
    <br>
</div>
      <!--     name="action" value="mostrar"  </form>
<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-xl" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">MATRICULAR CURSOS</h5>
        <br>
        
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
        <h6>Asegurese de verificar los cursos a inscrribir antes de enviar la matricula!</h6>
      <div class="modal-body" id="modal_body">
          
        <!--cuerpo de la tabla en el modal-->
        
        
        
        <!--fin tabla -->
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>



   
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
  <script src="js/contact_me.js"></script>

  <!-- Custom scripts for this template -->
  <script src="js/freelancer.min.js"></script>
  
 <script src="vendor/jquery/eventos.js"></script>
 <script>
     id= ${estudiante.documento}
    </script>
 
</body>

</html>
