/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import  Modelos.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Duber
 */
public class SEUsuarios extends HttpServlet {

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
        String action =request.getParameter("action");
        
        //actions of page 
        HibernateUtil.sesion= HibernateUtil.getSessionFactory().openSession();
        if(action.equals("iniciar_sesion")){
            iniciar_sesion(request, response,out);
        }else if(action.equals("crear")){
            crear(request, response, out);
        }else if(action.equals("editar")){
            
        }
        
        
       
    }
     private void iniciar_sesion(HttpServletRequest request, HttpServletResponse response,PrintWriter out)
           {
        response.setContentType("text/html;charset=UTF-8");
          
         try {
           
             Usuarios us = (Usuarios) HibernateUtil.QueryUnicod("SELECT C FROM Usuarios C WHERE username='"+request.getParameter("usuario")+"' and password='"+request.getParameter("password")+"' and tipo='"+request.getParameter("tipo")+"' ");
            
             if(us!=null){
                 out.print("valido");
                 HttpSession sesion = request.getSession();
                 sesion.setAttribute("usuario", us);
             }else{
                 out.print("invalido");
             }
         } catch (Exception e) {
             System.out.println(e.getMessage());
             out.print("error");
         }
       
    }
     private void crear(HttpServletRequest request, HttpServletResponse response,PrintWriter out)
             {
        response.setContentType("text/html;charset=UTF-8");
        
 
    }
     private void editar(HttpServletRequest request, HttpServletResponse response,PrintWriter out)
         {
        response.setContentType("text/html;charset=UTF-8");
        
        
        
        
       
    }
     
  public static String menuAdministrador(){
      String menu ="    <ul class='nav navbar-top-links navbar-right'>\n" +
"                \n" +
"            \n" +
"                \n" +
"                <!-- /.dropdown -->\n" +
"                <li class='dropdown'>\n" +
"                    <a class='dropdown-toggle' data-toggle='dropdown' href='#'>\n" +
"                        <i class=\"fa fa-user fa-fw\"></i>  <i class=\"fa fa-caret-down\"></i>\n" +
"                    </a>\n" +
"                    <ul class='dropdown-menu dropdown-user'>\n" +
"                        <li><a href=\"#\"><i class=\"fa fa-user fa-fw\"></i> Perfil</a>\n" +
"                        </li>\n" +
"                        <li><a href=\"#\"><i class=\"fa fa-gear fa-fw\"></i> Configuraciones</a>\n" +
"                        </li>\n" +
"                        <li class=\"divider\"></li>\n" +
"                        <li><a href='login.html'><i class=\"fa fa-sign-out fa-fw\"></i>Salir</a>\n" +
"                        </li>\n" +
"                    </ul>\n" +
"                    <!-- /.dropdown-user -->\n" +
"                </li>\n" +
"                <!-- /.dropdown -->\n" +
"            </ul>\n" +
"            <!-- /.navbar-top-links -->\n" +
"\n" +
"            <div class='navbar-default sidebar' role='navigation'>\n" +
"                <div class='sidebar-nav navbar-collapse'>\n" +
"                    <ul class=\"nav\" id=\"side-menu\">\n" +
"                       \n" +
"                        <li>\n" +
"                            <a href='index.html'><i class='fa fa-dashboard fa-fw'></i>Biblioteca</a>\n" +
"                        </li>\n" +
"                        <li>\n" +
"                            <a href='#'><i class='fa fa-bar-chart-o fa-fw'></i>Clientes<span class='fa arrow'></span></a>\n" +
"                            <ul class='nav nav-second-level'>\n" +
"                                <li>\n" +
"                                    <a href='flot.html'>Agregar</a>\n" +
"                                </li>\n" +
"                                <li>\n" +
"                                    <a href='morris.html'>Listar</a>\n" +
"                                </li>\n" +
"                            </ul>\n" +
"                            <!-- /.nav-second-level -->\n" +
"                        </li>\n" +
"                      \n" +
"                        <li>\n" +
"                            <a href='#'><i class='fa fa-sitemap fa-fw'></i>Libros<span class='fa arrow'></span></a>\n" +
"                            <ul class='nav nav-second-level'>\n" +
"                                <li>\n" +
"                                    <a href='#'>Agregar</a>\n" +
"                                </li>\n" +
"                                <li>\n" +
"                                    <a href='#'>Listar</a>\n" +
"                                </li>\n" +
"                               \n" +
"                            </ul>\n" +
"                            <!-- /.nav-second-level -->\n" +
"                        </li>\n" +
"                        <li class='active'>\n" +
"                            <a href='#'><i class='fa fa-files-o fa-fw'></i>Prestamos<span class='fa arrow'></span></a>\n" +
"                            <ul class='nav nav-second-level'>\n" +
"                              <li><a class='active' href='blank.html'>Agregar</a>\n" +
"                                </li>\n" +
"                                <li>\n" +
"                                    <a href='login.html'>Listar</a>\n" +
"                                </li>\n" +
"                            </ul>\n" +
"                            <!-- /.nav-second-level -->\n" +
"                        </li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <!-- /.sidebar-collapse -->\n" +
"            </div>\n" +
"            <!-- /.navbar-static-side -->             <li>\n" +
"                         ";
      return menu;
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
