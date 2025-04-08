package src.java.servlet; 

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import src.java.model.Depense;
import src.java.model.Prevision;

//import src.java.model.Employe;

public class EtatServlet extends HttpServlet {

    @Override
    public void init() {}
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double init=20.5;
        Prevision p=new Prevision("",init );

        Depense d=new Depense("", init);

        List<Prevision> listePrevision = p.getAll();
        request.setAttribute("listPrevision", listePrevision);

        // List<Double> listSum=new ArrayList<>();
        
        // for (int i = 1; i <listePrevision.size(); i++) {
        //     Double a=p.getSumDepenseByIdPrevision(i);
        //     listSum.add(a);
        // }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-emp.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void destroy() {}

}
