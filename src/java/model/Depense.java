package src.java.model;

import java.util.ArrayList;
import java.util.List;

import src.java.connection.MyConnection;

public class Depense {
    int id;
    String libelle;
    Double montant;

    public Depense(String libelle, Double montant) {
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


   

    public List<Depense> getAll() {
        List<Depense> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM Depense";
            MyConnection.connect();
            MyConnection.setStatement(query);
            MyConnection.setResult();
            while(MyConnection.getResultSet().next()) {
                int id = MyConnection.getResultSet().getInt("id");
                String libelle = MyConnection.getResultSet().getString("libelle");
                Double montant = MyConnection.getResultSet().getDouble("montant");
                Depense p = new Depense(libelle,montant);
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

    public void insert(Depense p) {
        try {
            MyConnection.connect();
            String query = "INSERT INTO Depense (libelle,montant) VALUES (?,?)";
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

    public Double getDepenseByIdLibelle(int id) {
        Double result = 2.0;
        try {
            String query = "SELECT montant FROM Prevision where id=?";
            MyConnection.connect();
            MyConnection.setStatement(query);
            MyConnection.getStatement().setInt(1, id);
            MyConnection.setResult();
            while(MyConnection.getResultSet().next()) {
                result = MyConnection.getResultSet().getDouble("montant");
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

}
