package src.java.model;

import java.util.ArrayList;
import java.util.List;

//import oracle.net.aso.p;
import src.java.connection.MyConnection;

public class Prevision {
    int id;
    String libelle;
    Double montant;

    public Prevision(String libelle, Double montant) {
        this.libelle = libelle;
        this.montant = montant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }


   

    public List<Prevision> getAll() {
        List<Prevision> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM Prevision";
            MyConnection.connect();
            MyConnection.setStatement(query);
            MyConnection.setResult();
            while(MyConnection.getResultSet().next()) {
                int id = MyConnection.getResultSet().getInt("id");
                String libelle = MyConnection.getResultSet().getString("libelle");
                Double montant = MyConnection.getResultSet().getDouble("montant");

                Prevision p = new Prevision(libelle,montant);
                p.setId(id);
                result.add(p);
            }
            MyConnection.closeStatement();
            MyConnection.closeResultSet();
            MyConnection.closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            MyConnection.closeAll();
        }
        return result;
    }

    public Prevision getById(int id) {
        Prevision result = new Prevision(libelle, montant);
        try {
            String query = "SELECT * FROM Prevision Where id=?";
            MyConnection.connect();
            MyConnection.setStatement(query);
            MyConnection.getStatement().setInt(1,id);

            MyConnection.setResult();
            while(MyConnection.getResultSet().next()) {
                String libelle = MyConnection.getResultSet().getString("libelle");
                Double montant = MyConnection.getResultSet().getDouble("montant");

                Prevision p = new Prevision(libelle,montant);
                p.setId(id);
            }
            MyConnection.closeStatement();
            MyConnection.closeResultSet();
            MyConnection.closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            MyConnection.closeAll();
        }
        return result;
    }
    public void insert(Prevision p) {
        try {
            MyConnection.connect();
            String query = "INSERT INTO Prevision (libelle,montant) VALUES (?,?)";
            MyConnection.setStatement(query);
            MyConnection.getStatement().setString(1, p.getLibelle());
            MyConnection.getStatement().setDouble(2, p.getMontant());


            int rowsAffected = MyConnection.getStatement().executeUpdate();
            System.out.println("Row affected: " + rowsAffected + "ADDED");

            MyConnection.closeStatement();
            MyConnection.closeConnection();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            MyConnection.closeStatement();
            MyConnection.closeConnection();
        }
    }

    public Double getSumDepenseByIdPrevision(int idP) {
        Double result = 2.0;
        try {
            String query = "SELECT COALESCE(SUM(montant), 0) AS total FROM depense where libelle=?";
            MyConnection.connect();
            MyConnection.setStatement(query);
            MyConnection.getStatement().setInt(1, idP);
            MyConnection.setResult();
            while(MyConnection.getResultSet().next()) {
                result = MyConnection.getResultSet().getDouble("total");
            }
            MyConnection.closeStatement();
            MyConnection.closeResultSet();
            MyConnection.closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            MyConnection.closeAll();
        }
        return result;
    }

//mdp=
}
