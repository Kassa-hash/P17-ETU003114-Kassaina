package src.java.model;

public class Etat {

    int id;
    String libelle;
    Double depense;
    Double reste;
    
    public Etat(int id, String libelle, Double depense, Double reste) {
        this.id = id;
        this.libelle = libelle;
        this.depense = depense;
        this.reste = reste;
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
    public Double getDepense() {
        return depense;
    }
    public void setDepense(Double depense) {
        this.depense = depense;
    }
    public Double getReste() {
        return reste;
    }
    public void setReste(Double reste) {
        this.reste = reste;
    }
}
