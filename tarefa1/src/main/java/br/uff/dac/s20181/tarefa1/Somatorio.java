package br.uff.dac.s20181.tarefa1;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Somatorio extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Somatório</title>");
            out.println("</head>");
            out.println("<body>");

            Integer inicio = Integer.valueOf(request.getParameter("inicio"));
            Integer fim = Integer.valueOf(request.getParameter("fim"));
            Integer somatorio = getSomatorio(inicio, fim);

            out.println("<p>O somatório de " + inicio + " a " + fim + " é " + somatorio + ".</p>");

            out.println("</body>");
            out.println("</html>");
            out.close();
        }

    }

    private Integer getSomatorio(Integer inicio, Integer fim) {
        Integer resultado = 0;
        for (int i = inicio; i <= fim; i++) {
            resultado += i;
        }
        return resultado;
    }

}
