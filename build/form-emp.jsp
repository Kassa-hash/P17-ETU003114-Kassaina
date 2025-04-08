<%@ page import = "java.util.List" %>
<%@ page import = "src.java.model.Prevision" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="DepenseServlet" method="post">
        Libelle:
            <select name="libelle" id="">
                <%
                    List<Prevision> prevision = (List<Prevision>) request.getAttribute("listPrevision");
                    for(Prevision p : prevision) { %>
                        <option value="<%= p.getId() %>"><%= p.getLibelle() %></option>
                    <% } %>
            </select>
        </p>

          <p>
            Inserer le montant: <input type="number" name="montant" id="">
        </p>
        
        <p>
            <input type="submit" name = "submit" rows = "5" value = "Soumettre">
        </p>
    </form>
</body>
</html>