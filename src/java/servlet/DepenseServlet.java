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

public class DepenseServlet extends HttpServlet {

    @Override
    public void init() {}
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        Integer libelle = Integer.parseInt(request.getParameter("libelle"));
        Double montant = Double.parseDouble(request.getParameter("montant"));

        String lib=libelle.toString();
        Depense d = new Depense(lib,montant);

        Prevision p=new Prevision(lib, montant);
        Prevision p2=p.getById(libelle);

        Double depenseProvisoire=d.getDepenseByIdLibelle(p2.getId());
        Double getSumDepense=p.getSumDepenseByIdPrevision(p2.getId());

        Double reste=depenseProvisoire-getSumDepense;
            d.insert(d);
            response.sendRedirect("success.jsp");

            // // if (montant<reste) {
            // //     response.sendRedirect("success.jsp");
            // // }
            
            // // if (reste==0) {
            // //     response.sendRedirect("echec.jsp");
            // // }
            
            // if (montant>reste) {
            //     d.insert(d);
            //     response.sendRedirect("echec.jsp");
            // }
     //MDP= 3M3o3SX5  
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
