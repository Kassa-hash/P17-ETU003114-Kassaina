package src.java.servlet; 

import java.io.IOException;
import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import src.java.model.Prevision;
import jakarta.servlet.RequestDispatcher;


public class PrevisionServlet extends HttpServlet {

    @Override
    public void init() {}
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        String libelle = request.getParameter("libelle");
        Double montant = Double.parseDouble(request.getParameter("montant"));

        Prevision p = new Prevision(libelle,montant);
        p.insert(p);

        response.sendRedirect("success.jsp");

    }

    @Override
    public void destroy() {}

}
