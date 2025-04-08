package src.java.servlet; 

import java.io.IOException;
import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import src.java.model.Depense;
import src.java.model.Prevision;

//import src.java.model.Employe;

public class FormEmpServlet extends HttpServlet {

    @Override
    public void init() {}
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        String libelle = request.getParameter("libelle");
        Double montant = Double.parseDouble(request.getParameter("montant"));

        Depense d = new Depense(libelle,montant);
        d.insert(d);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double init=20.5;
        Prevision p=new Prevision("",init );
        List<Prevision> listePrevision = p.getAll();
        request.setAttribute("listPrevision", listePrevision);
         RequestDispatcher dispatcher = request.getRequestDispatcher("form-emp.jsp");
         dispatcher.forward(request, response);
    }

    @Override
    public void destroy() {}

}
