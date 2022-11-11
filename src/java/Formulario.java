/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Clases.Alumno;
import Clases.AlumnoController;
import Clases.ConexionBaseDeDatos;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Christian
 */
@WebServlet(urlPatterns = {"/Formulario"})
public class Formulario extends HttpServlet {
    Alumno alumno;
    AlumnoController registroAlumno;
     Alumno[] alumnosRegistrados;
     StringBuffer objetoRespuesta = new StringBuffer();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        try ( PrintWriter respuesta = response.getWriter()) {            
           
           registroAlumno=new AlumnoController();
           String control = request.getParameter("control");
           
           if(control.toUpperCase().equals("GUARDAR")){
               alumno=new Alumno(
                Integer.parseInt(request.getParameter("codigo")),
                request.getParameter("nombre"),     
                request.getParameter("correo"),
                request.getParameter("telefono"),   
                request.getParameter("direccion"),
                Integer.parseInt(request.getParameter("opcion")));                
                registroAlumno.guardarAlumno2(alumno);//almacenarlo en BD                 
           }else if(control.toUpperCase().equals("ELIMINAR")){
               int codigoEliminar= Integer.parseInt(request.getParameter("codigo_alumno"));
               registroAlumno.eliminarALumno(codigoEliminar);
           }
                        
            
            //registroAlumno.guardarAlumno(alumno);//almacenarlo en el array
            //alumnosRegistrados= registroAlumno.getAlumnos();// consultar alumnos en el array                       
                    
           registroAlumno.getAlumnos2(objetoRespuesta);//consultar alumnos en la BD
           respuesta.write(objetoRespuesta.toString());             
            
           
            /*for (int i = 0; i < alumnosRegistrados.length; i++){
                   //if(!alumnosRegistrados[i].getCodigo().isEmpty()){
                    if(alumnosRegistrados[i].getCodigo()>0){
                       respuesta.println("<tr><td>" + alumnosRegistrados[i].getCodigo()+ "</td>");
                       respuesta.println("<td>" + alumnosRegistrados[i].getNombre() + "</td>");
                       respuesta.println("<td>" + alumnosRegistrados[i].getDireccion()+ "</td>");
                       respuesta.println("<td>" + alumnosRegistrados[i].getCorreo()+ "</td>");
                       respuesta.println("<td>" + alumnosRegistrados[i].getTipo()+ "</td>");
                       respuesta.println("<td>"
                               + "<button type=\"button\" class=\"btn btn-warning\"></i>Editar</button> "
                               + "<button type=\"button\" class=\"btn btn-danger\">Eliminar</button>"
                               + "</td></tr>");
                    }
                }*/
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
