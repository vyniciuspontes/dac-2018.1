package br.uff.dac.s20181.tarefa1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabri
 */
public class AloMundo extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AloMundo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>Informe seu nome:</p>");
            out.println("<form action=\" AloMundo \" method=\"post\">");
            out.println("<input type=\"text\" name=\"nome\"/>");
            out.println("<input type=\"submit\" value=\"Enviar\"/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String nome = request.getParameter("nome");
        
        PrintWriter out = response.getWriter();
        
        out.println("<html><head>");
        out.println("<title>Servlet AloMundo</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Alo " + nome + "!</p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
        
    }

}
