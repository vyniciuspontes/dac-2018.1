<%-- 
    Document   : lembretes
    Created on : Apr 2, 2018, 2:26:50 AM
    Author     : vyniciuspontes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lembretes de ${param.usuario}</h1>

        <c:forEach var="lembrete" items="${sessionScope.lembretes.lembretesMap.get(param.usuario)}">

            <td>

                <tr>
                    ${lembrete}

                </tr>
            </td>

    </c:forEach>

</body>
</html>
