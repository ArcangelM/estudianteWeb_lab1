/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.estudianteweb_lab1.controller;

import com.udea.estudianteweb_lab1.ejb.AccountestFacadeLocal;
import com.udea.estudianteweb_lab1.modelo.Accountest;
import static com.udea.estudianteweb_lab1.modelo.Accountest_.email;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author arK
 */

@javax.servlet.annotation.MultipartConfig
public class AccountestServlet extends HttpServlet {

    @EJB
    private AccountestFacadeLocal accountestFacade;
    private static final Logger LOG = Logger.getLogger(AccountestServlet.class.getName());

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
        PrintWriter out = response.getWriter();
        try {
            LOG.log(Level.INFO, "ENTRO EN TRY ***");
            String action = request.getParameter("action");
            String url = "index.html";
            if("list".equals(action)){
                List<Accountest> findAll= accountestFacade.findAll();
                request.getSession().setAttribute("accounts", findAll);
                url = "listAccounts.jsp";
            }
            else if ("login".equals(action)){
                String u = request.getParameter("email");
                String p = request.getParameter("password");
                
                boolean checklogin = accountestFacade.checkLogin(u,p);
                if(checklogin){
                    Accountest estudiante = accountestFacade.find(u);
                    request.getSession().setAttribute("login", u);
                    request.getSession().setAttribute("nombre", u);
                    request.getSession().setAttribute("estudiante",estudiante);
                    url = "manager.jsp";
                }
                else{
                    url = "login.jsp?error=1";
                }
            }
            else if ("insertar".equals(action)){
                LOG.log(Level.INFO, "ENTRO EN INSERT ***");
                System.out.print("ENTRNADO");
                Accountest a = new Accountest();
                // String idu = request.getParameter("iduser");
                // a.setId(Integer.parseInt)
                a.setEmail(request.getParameter("email"));
                a.setPassword(request.getParameter("password"));
                a.setNombre(request.getParameter("nombre"));
                a.setApellido(request.getParameter("apellido"));
                a.setDocumento(Integer.parseInt(request.getParameter("documento")));
                a.setCarrera(request.getParameter("carrera"));
               
                //para cargar la foto 
               
               Part fotoPart = request.getPart("foto");
                int fotoSize=(int)fotoPart.getSize(); //si no tiene tamaño, no hay foto

                byte[] foto=null; //el buffer
                if(fotoSize>0){
                    foto=new byte[fotoSize];
                    try(DataInputStream dis=new DataInputStream(fotoPart.getInputStream())){
                        dis.readFully(foto);
                        
                         System.out.print("****ENTRO EN EL TRY ****");
                    }
                }
                if (fotoSize>0){
                
                    a.setFoto(foto);
                    System.out.print("si hay foto");
                    
                }
               
               
               
                
                accountestFacade.create(a);
                url = "login.jsp";
                
            }
            else if ("delete".equals(action)){
                String id = request.getParameter("id");
                Accountest a = accountestFacade.find(Integer.valueOf(id));
                accountestFacade.remove(a);
                url = "AccountServlet?action=list";
                
            }
            else if("logout".equals(action)){
                request.getParameter("login");
                url = "login.jsp";
            }
            response.sendRedirect(url);
        }
        finally{
            out.close();
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
         String email=request.getParameter("email");
        //long id=Long.parseLong($id);
        Accountest estudiante = accountestFacade.find(email);
        byte[] foto = estudiante.getFoto();
        response.getOutputStream().write(foto);
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
        processRequest(request, response);
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
