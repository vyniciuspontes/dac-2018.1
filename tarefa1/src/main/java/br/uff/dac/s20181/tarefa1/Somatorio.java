package br.uff.dac.s20181.tarefa1;

import javax.servlet.ServletContext;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Somatorio extends HttpServlet {

    private final String contadorKey = "contador";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sessao = request.getSession();
        Cookie[] cookies = request.getCookies();
        ServletContext contexto = request.getServletContext();

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


            Integer contadorSessao = getContadorSessao(sessao);
            out.println("<p>Você usou o serviço " + contadorSessao + " vezes nessa sessão.</p>");


            Integer contadorCookie = getContadorCookie(cookies);
            Cookie novoCookie = new Cookie(contadorKey, String.valueOf(contadorCookie));
            response.addCookie(novoCookie);
            out.println("<p>Você usou o serviço " + contadorCookie + " vezes nesse navegador.</p>");


            Integer contadorContexto = getContadorContext(contexto);
            out.println("<p>Esse serviço foi usado " + contadorContexto + " vezes desde que o servidor foi iniciado.</p>");


            out.println("</body>");
            out.println("</html>");
            out.close();
        }

    }

    private Integer getContadorContext(ServletContext contexto) {
        Integer contadorContexto = (Integer) contexto.getAttribute(contadorKey);
        contadorContexto = contadorContexto != null ? contadorContexto + 1 : 1;
        contexto.setAttribute(contadorKey, contadorContexto);

        return contadorContexto;
    }

    private Integer getContadorCookie(Cookie[] cookies) {
        if(cookies == null) {
            return 1;
        }

        for(Cookie cookie : cookies) {
            if(cookie.getName().equals(contadorKey)) {
                Integer contadorCookie = Integer.valueOf(cookie.getValue());
                return contadorCookie+1;
            }
        }

        return 1;
    }

    private Integer getContadorSessao(HttpSession sessao) {
        Integer contadorSessao = (Integer) sessao.getAttribute(contadorKey);
        contadorSessao = contadorSessao != null ? contadorSessao + 1 : 1;
        sessao.setAttribute(contadorKey, contadorSessao);

        return contadorSessao;
    }

    private Integer getSomatorio(Integer inicio, Integer fim) {
        Integer resultado = 0;
        for (int i = inicio; i <= fim; i++) {
            resultado += i;
        }
        return resultado;
    }

}
