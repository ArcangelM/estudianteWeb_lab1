/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.estudianteweb_lab1.controller;

import com.udea.estudianteweb_lab1.ejb.AccountestFacadeLocal;
import com.udea.estudianteweb_lab1.ejb.MateriaFacadeLocal;
import com.udea.estudianteweb_lab1.ejb.MatriculaFacadeLocal;
import com.udea.estudianteweb_lab1.modelo.Materia;
import com.udea.estudianteweb_lab1.modelo.Matricula;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arK
 */
public class MatriculasServlet extends HttpServlet {

    @EJB
    private AccountestFacadeLocal accountestFacade;

    @EJB
    private MateriaFacadeLocal materiaFacade;

    @EJB
    private MatriculaFacadeLocal matriculaFacade;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MatriculasServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MatriculasServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            String action = request.getParameter("action");
            
            String id=request.getParameter("idEstu");
            String url = "manager.jsp";
            
            if("quitar-matricula".equals(action)){
                String codMatri = request.getParameter("codMatri");
                matriculaFacade.remove(matriculaFacade.find(Integer.parseInt(codMatri)));
               
            }else if("add-matricula".equals(action)){
               String codMater = request.getParameter("codMater");
                Matricula matricula = new Matricula();
                matricula.setIdEstudiante(accountestFacade.find(id));
                matricula.setEstadoMa("matriculada");
                matricula.setPerAcademico("2019-02");
                matricula.setIdMateria(materiaFacade.find(Integer.parseInt(codMater)));
                matriculaFacade.create(matricula);
            }
                
               
                //MATRICULAS DE UN ESTUDIANTE CON DOCUMENTO ID
                
                List<Matricula>matriculas= matriculaFacade.matriculasEstu(Integer.parseInt(id));
                       
                //MATERIAS EXTRAIDA DESDE LA TABLA MATERIAS
                List<Materia> materias= materiaFacade.findAll();
               
                List<Materia> matDispoMatricular = new ArrayList<Materia>();
                Map<String, String> estadosMa = new HashMap<String, String>();
                Map<String, String> materiaMatricu = new HashMap<String, String>();
                
                    for (int j=0; j<materias.size();j++ ){
                        
                        Materia ma = materias.get(j);
                        int codigoMa = ma.getCodigo();
                        int prerrequi = ma.getCodPrerrequisito();
                        
                        int maEncontrada=0;
                        
                        for (int k=0;k<matriculas.size();k++){
                           Matricula matri = matriculas.get(k);
                           //Si la materia 
                           int pru = codigoMa;
                           int pru1=matri.getIdMateria().getCodigo();
                           String pru2 = matri.getEstadoMa();
                           if ((codigoMa == matri.getIdMateria().getCodigo())&& (matri.getEstadoMa().equals("matriculada"))){
                                   
                                   
                                         matDispoMatricular.add(ma);
                                         estadosMa.put(""+codigoMa,"matriculada");
                                         materiaMatricu.put(""+codigoMa,""+matri.getId());
                                         maEncontrada=1;
                                         break;
                            }else if((prerrequi == matri.getIdMateria().getCodigo())&& (matri.getEstadoMa().equals("aprobada"))){
                                matDispoMatricular.add(ma);
                                estadosMa.put(""+codigoMa,"no vista");
                                materiaMatricu.put(""+codigoMa,""+matri.getId());
                                maEncontrada=1;
                                break;
                             
                            }else if((codigoMa == matri.getIdMateria().getCodigo())&& (matri.getEstadoMa().equals("aprobada"))){
                                maEncontrada=1;
                                break;
                            }  
                           
                           if (maEncontrada==0 && prerrequi==0 && k==matriculas.size()-1){
                                    matDispoMatricular.add(ma);
                                    estadosMa.put(""+codigoMa,"no vista");
                                    materiaMatricu.put(""+codigoMa,""+matri.getId());
                              }
                               }
                              
                           }
                        
             
                
                          // request.getSession().setAttribute("materias", findAll);
               // url = "manager.jsp";
               
               out.println(" <table class=\"table table-bordered\"  id=\"tablaDatos\">\n" +
"                    <thead>\n" +
"                        <tr>\n" +
"                            <th class=\"text-center\">CODIGO</th>\n" +
"                            <th>NOMBRES</th>\n" +
"                            <th class=\"text-center\">CREDITOS</th>\n" +
"                            <th class=\"text-center\">PRERREQUISITO</th>\n" +
"                            <th class=\"text-center\">ESTADO MATERIA</th>\n" +
"                        </tr>\n" +
"                    </thead>\n" +
"                    <tbody id=\"tbodys\">\n" +
"                       \n" +
"                            \n" );

                        for (int i=0; i<matDispoMatricular.size(); i++){
                            Materia  materia= matDispoMatricular.get(i);
out.println("                        <tr>\n" +
"                            <td class=\"text-center\">"+materia.getCodigo()+"</td>\n" +
"                            <td>"+materia.getNombreMa()+"</td>\n" +
"                            <td class=\"text-center\">"+materia.getCreditos()+"</td>\n" +
"                            <td class=\"text-center\">"+materia.getCodPrerrequisito()+"</td>\n" +
"                            <td class=\"text-center\">"+estadosMa.get(""+materia.getCodigo())+"</td>\n" +
"                            <td class=\"text-center\">\n" +
"                                \n" +
"                                <!-- <input type=\"hidden\" value=\"<//%= rs.getInt(\"Id_Usuario\")%>\" id=\"Editar\"/>\n" +
"                                <input type=\"submit\" class=\"btn btn-warning\" data-toggle=\"modal\" data-target=\"#myModal1\" value=\"Editar\"/>  -->\n" +
"                                <button type=\"button\" value=\""+materiaMatricu.get(""+materia.getCodigo())+"\" id=\"add-link\" class=\"btn btn-primary\">Añadir</a>\n" +
"                                <button value=\""+materiaMatricu.get(""+materia.getCodigo())+"\" id=\"quitar-link\" class=\"btn btn-danger\">Quitar</a>\n" +
"                            </td>\n" +
"                        </tr>\n");
                        }
                                out.println("\n" +
"                </table>");
            
                 
            
          // response.sendRedirect(url); 
        }
        finally{
            out.close();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
