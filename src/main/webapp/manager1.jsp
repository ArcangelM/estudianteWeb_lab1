<%-- 
    Document   : manager
    Created on : 28/02/2020, 07:39:03 PM
    Author     : arK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Lato:100,300,400,700,900" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" TYPE="text/css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">

        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <h1>BIENVENIDO A LA PAGINA ${estudiante.email}</h1>
        <h1>BIENVENIDO A LA PAGINA ${estudiante.nombre}</h1>
        <h1>BIENVENIDO A LA PAGINA ${estudiante.documento}</h1>
        <h1>BIENVENIDO A LA PAGINA ${estudiante.carrera}</h1>
        <div class="form-group">
                    <label for="foto">Foto</label>
     
                    <c:if test="${estudiante.foto ne null}">
                        <img src="<%=request.getContextPath()%>/AccountestServlet?email=${estudiante.email}" style="width: 100px;"/>
                    </c:if>
                </div>
        <div class="container">
  <div class="row">
  <div class="col-md-12">
    <div class="profile-bar">
      <div class="contents">
        <img src="https://gravatar.com/avatar/cd62d88a83461e0b1daa8f2fa31c4dcb?s=512&d=https://codepen.io/assets/avatars/user-avatar-512x512-6e240cf350d2f1cc07c2bed234c3a3bb5f1b237023c204c782622e80d6b212ba.png" alt="UserAvatar">
      <p class="profile-name">Good Job, John!</p>
        <p class="profile-description">You haven't miss any task this week!</p>
        <div class="buttons">
          <ul>
            <li>
              <a href="#"><i class="ti-panel"></i><span> Settings</span></a>
            </li>
            <li>
              <a href="#"><i class="ti-user"></i><span> Profile</span></a>
            </li>
            <li>
              <a href="#"><i class="ti-power-off"></i><span> Logout</span></a>
            </li>
          </ul>
          
        </div>
      </div>
      
    </div>
        
    </body>
</html>




