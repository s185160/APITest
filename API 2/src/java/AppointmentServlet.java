/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ClassesPackage.Appointment;
import ModelsPackage.AppointmentModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/appointment/*")
public class AppointmentServlet extends HttpServlet {

    Appointment appointmentDAO = new Appointment();

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
            out.println("<title>Servlet AppointmentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AppointmentServlet at " + request.getContextPath() + "</h1>");
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
        try {
            //processRequest(request, response);
            //HttpSession session = request.getSession(true);
            //int userID =  Integer.parseInt((String) session.getAttribute("currentUserId"));

            int userID = Integer.parseInt((String) request.getParameter("cpr"));
            List<AppointmentModel> curentAppointments = appointmentDAO.getAllAppointmentsForId(userID);

            //Disptching request
            /**
             * request.setAttribute("allAppointments", curentAppointments);
             * RequestDispatcher dispatcher =
             * request.getRequestDispatcher("appointment-page.jsp");
             *
             * if (dispatcher != null){
             *
             * dispatcher.forward(request, response);
             *
             * }
             *
             */
            response.setContentType("text/xml;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            
            for (AppointmentModel model : curentAppointments) {
                writer.append("<Appointments>");
                writer.append("<Booking>");
                writer.append("<Id>").append(String.valueOf(model.getId())).append("</Id>");
                writer.append("<Type>").append(String.valueOf(model.gettype())).append("</Type>");
                writer.append("<Date>").append(String.valueOf(model.getDate())).append("</Date>");
                writer.append("<Patient>");
                writer.append("<Cpr>").append(String.valueOf(model.getCpr())).append("</Cpr>");
                writer.append("<FirstName>").append(String.valueOf(model.getFirstName())).append("</FirstName>");
                writer.append("<LastName>").append(String.valueOf(model.getLastName())).append("</LastName>");
                writer.append("</Patient>");
                writer.append("</Booking>");
                writer.append("</Appointments>");
            }

        } catch (SQLException ex) {
            Logger.getLogger(AppointmentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

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
