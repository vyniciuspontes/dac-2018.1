package br.uff.dac.s20181.tarefa1;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class MostraHeader extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Mostra Header</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>Os Headers utlizados nesta requisição foram: s</p>");
            out.println("<ul>");

            Enumeration<String> headers = request.getHeaderNames();
            while (headers.hasMoreElements()) {
                String headerName = headers.nextElement();
                String headerValue = request.getHeader(headerName);
                String listItem = "<li><b>" + headerName + ": </b> " + headerValue + "</li>";
                out.println(listItem);
            }

            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }

    }
}
