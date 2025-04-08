<%@ page import = "java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Prevision</title>
</head>
<body>
    
    <h2>Inserer une prevision</h2>
    <form action="PrevisionServlet" method="post">
        <p>
            Libelle: <input type="text" name = "libelle">
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