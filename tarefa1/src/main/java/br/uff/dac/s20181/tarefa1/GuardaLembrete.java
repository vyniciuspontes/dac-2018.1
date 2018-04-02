/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.dac.s20181.tarefa1;

import br.uff.dac.s20181.tarefa1.beans.Lembretes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vyniciuspontes
 */
@WebServlet(name = "guardaLembrete", urlPatterns = {"/guardaLembrete"})
public class GuardaLembrete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.sendRedirect("/tarefa1/criaLembrete.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Lembretes lembretes = null;

        if (session.getAttribute("lembretes") == null) {

            lembretes = new Lembretes();

            lembretes.addLembrete(request.getParameter("usuario"), request.getParameter("lembrete"));
            session.setAttribute("lembretes", lembretes);
        } else {

            lembretes = (Lembretes) session.getAttribute("lembretes");

            lembretes.addLembrete(request.getParameter("usuario"), request.getParameter("lembrete"));
        }

        //RequestDispatcher requestDispatcher = request.getRequestDispatcher("lembretes.jsp?usuario=" + request.getParameter("usuario"));

        //requestDispatcher.forward(request, response);
        
        response.sendRedirect("/tarefa1/lembretes.jsp?usuario=" + request.getParameter("usuario"));
    }

}
