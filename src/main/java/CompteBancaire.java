public class CompteBancaire {
    private String numeroCompte;
    private double solde;
    private String nomTitulaire;

    public CompteBancaire(String numeroCompte, double soldeInitial, String nomTitulaire) {
        this.numeroCompte = numeroCompte;
        this.solde = soldeInitial;
        this.nomTitulaire = nomTitulaire;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public String getNomTitulaire() {
        return nomTitulaire;
    }

    public void deposer(double montant) {
        if (montant > 0) {
            this.solde += montant;
        } else {
            System.out.println("Montant invalide !");
        }
    }

    public void retirer(double montant) throws FondsInsuffisantsException {
        if (montant > this.solde) {
            throw new FondsInsuffisantsException("Fonds insuffisants pour le retrait", montant);
        } else {
            this.solde -= montant;
        }
    }

    public void afficherSolde() {
        System.out.println("Solde actuel de " + nomTitulaire + " (" + numeroCompte + ") : " + solde + " €");
    }
}
