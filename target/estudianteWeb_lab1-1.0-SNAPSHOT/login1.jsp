<%-- 
    Document   : login
    Created on : 26/02/2020, 01:25:41 AM
    Author     : arK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?php
   session_start();  

    include_once 'header.php';
    include_once 'includes/dbc.inc.php';

    /*Para no escribir tantos ECHO se crea la variable OUPUT*/
    $output = '';

    $username='';

    /*Cargo mi tabla con los valores de la tabla Clientes*/
    $sql = "SELECT * FROM clients";

    /*almaceno el resultado de mi query*/
    $result = mysqli_query($conn, $sql);

    $output .= '
        <br><br><br><br><br>
        <h2>Clientes</h2><br>

   /*Fly este formulario lo agregue porque pensaba que si la ancla 
   <a> donde presiono mi INFO no estaba dentro de un formulario no 
    recibiria la instruccion*/
      <form action="clientsm.php" method="GET">

       <div class="container table-responsive" >                    
          <table class="table table-hover">
              <thead>
                    <tr>  
                       <th >Id</th>  
                       <th >First Name</th>  
                       <th >Last Name</th>
                       <th >Username</th>  
                       <th >Password</th>  
                       <th >Phone Number</th>
                       <th >Email</th>   

                    </tr>
              </thead>';

             /*Si el resultado en numero de registros de mi query SQL  
             es mayor a 0 significa que hay datos a cargar en la 
              tabla*/  
            if(mysqli_num_rows($result) > 0)  
             {  
             /*Por cada registro de mi tabla Clientes que me los vaya 
             agregando a la tabla y los almaceno en la variable ROW*/
             while($row = mysqli_fetch_array($result))  
             {       

             $output .='
              <tbody>

                    <tr>
                        <td>'.$row["user_id"].'</td> 

                        <td class="user_first" data- 
                    id1="'.$row["user_id"].'" 
                   contenteditable>'.$row["user_first"].'</td>

                        <td class="user_last" data- 
                    id2="'.$row["user_id"].'" 
                    contenteditable>'.$row["user_last"].'</td>

                        <td class="user_uid" data- 
                    id3="'.$row["user_id"].'" 
                    contenteditable>'.$row["user_uid"].'</td>

                        <td class="user_pwd" data- 
                     id4="'.$row["user_id"].'" 
                     contenteditable>'.$row["user_pwd"].'</td>

                        <td class="user_phone" data- 
                       id5="'.$row["user_id"].'" 
                       contenteditable>'.$row["user_phone"].'</td>

                        <td class="user_email" data- 
                        id6="'.$row["user_id"].'" 
                         contenteditable>'.$row["user_email"].'</td>

                        <td>
                        <button type="button" name="btn_delete2" 
                        id="btn_delete2" data- 
                         id7="'.$row["user_id"].'" class="btn btn-xs 
                         btn-danger btn_delete2">DELETE
                        </button>
                        </td>

                        <td>
                        <a data-toggle="modal" data- 
                      id8="'.$row["user_id"].'" class="btn_info" data- 
                      target="#paymentshist" id="trigger-btn">INFO
                        </a>
                        </td>

                    </tr>
                    </tbody>';
                     }

                     $output .= '  
                    <tr>  
                        <td></td>

                        <td id="user_first" contenteditable></td>  
                        <td id="user_last" contenteditable></td>
                        <td id="user_uid" contenteditable></td>  
                        <td id="user_pwd" contenteditable></td>
                        <td id="user_phone" contenteditable></td>  
                        <td id="user_email" contenteditable></td>

                        <td>
                        <button type="button" name="btn_add2" 
                        id="btn_add2" class="btn btn-xs btn- 
                        success">ADD
                        </button>
                        </td>  
                    </tr>';
                    }
                    /*Si el numero de registros de mi query SQL es 
                     menor o igual a 0 entonces me muestra lo 
                     siguiente*/  
                     else  
                     {

                    $output .= '
                      <tr>  
                          <td colspan="4">NO hay registros para 
                         Mostrar
                          </td>  
                      </tr>';  
                      }  
                    $output .= '
                </table>  
                 </div>
                 </form>';

                echo $output;


                ?>

                <div class="container">
                 <div class="row">


                   <div class="modal fade modal-fullscreen" 
                   id="paymentshist" tabindex="-1" role="dialog" aria- 
                   labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                   <div class="modal-content">
                   <div class="modal-header">
                   <button type="button" class="close" data- 
                   dismiss="modal" aria-label="Close"><span aria- 
                   hidden="true">&times;</span></button>
                  <h4 class="modal-title" id="myModalLabel">Historial 
                  de Pagos</h4>
                 </div>
                 <div class="modal-body">

                  <?php

                   /*Para no escribir tantos ECHO se crea la variable 
                   OUPUT*/
                  $output = '';



                  $querypaymentshist="SELECT hist_id, pay_id, 
                  user_uid, pay_amount, pay_totalint, pay_totalpay, 
                   pay_amountrest, hist_date FROM payments_history 
                   WHERE hist_id='".$_POST['id']."' ORDER BY hist_date 
                    DESC";

                  /*almaceno el resultado de mi query*/
                  $resultpamentshist = mysqli_query($conn, 
                  $querypaymentshist);


                  $output .= '
                   <br>

                   <div class="container table-responsive">                    
                   <table class="table table-hover">
                   <thead>
                    <tr>  
                       <th >Id</th>  
                       <th >Pay_Id</th>  
                       <th >Usuario</th>
                       <th >Ingreso</th>  
                       <th >Intereses</th>  
                       <th >Abonado</th>
                       <th >Capital</th>
                       <th >Fecha</th>  

                    </tr>
                    </thead>';

       
              <tbody>

                    <tr>
                        <td>'.$rowph["hist_id"].'</td> 

                        <td class="pay_id" data- 
                        id1="'.$rowph["hist_id"].'" 
                        contenteditable>'.$rowph["pay_id"].'</td>

                        <td class="user_uid" data- 
                        id2="'.$rowph["hist_id"].'" 
                         contenteditable>'.$rowph["user_uid"].'</td>

                        <td class="pay_amount" data- 
                        id3="'.$rowph["hist_id"].'" 
                        contenteditable>'.$rowph["pay_amount"].'</td>

                        <td class="pay_totalint" data- 
                         id4="'.$rowph["hist_id"].'" 
                       contenteditable>'.$rowph["pay_totalint"].'</td>

                        <td class="pay_totalpay" data- 
                         id5="'.$rowph["hist_id"].'" 
                      contenteditable>'.$rowph["pay_totalpay"].'</td>

                        <td class="pay_amountrest" data- 
                       id6="'.$rowph["hist_id"].'" 
                     contenteditable>'.$rowph["pay_amountrest"].'</td>

                        <td class="hist_date" data- 
                      id7="'.$rowph["hist_id"].'" 
                     contenteditable>'.$rowph["hist_date"].'</td>

                    </tr>
                   </tbody>';
                  }
                    }
                   /*Si el numero de registros de mi query 
                   resultpamentshist es menor o igual a 0 entonces me 
                   muestra lo siguiente*/  
                    else  
                     {

                      $output .= '
                      <tr>  
                          <td colspan="4">NO hay registros para 
                          Mostrar
                          </td>  
                      </tr>';  
                        }  