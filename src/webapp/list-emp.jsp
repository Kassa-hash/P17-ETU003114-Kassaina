<%@ page import = "java.util.List" %>
<%@ page import = "src.java.model.Prevision" %>
<%@ page import = "src.java.model.Depense" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
   <table border="1">
    <tr>
        <th>Prevision</th>
        <th>Depense</th>
        <th>Reste</th>
    </tr>

    <%
     List<Prevision> prevision = (List<Prevision>) request.getAttribute("listPrevision");
            for(Prevision p : prevision) {
                Double reste= p.getMontant()-p.getSumDepenseByIdPrevision(p.getId());
            %>
                <tr>
                    <td><%= p.getLibelle() %></td>
                    <td><%= p.getSumDepenseByIdPrevision(p.getId()) %></td>
                    <td><%= reste%></td>
                </tr>
                <% } %> 
</table>
</body>
</html>

