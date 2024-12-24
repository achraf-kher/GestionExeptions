public class CompteCourant extends CompteBancaire {

    private double decouvertAutorise;

    public CompteCourant(String numeroCompte, double soldeInitial, String nomTitulaire, double decouvertAutorise) {
        super(numeroCompte, soldeInitial, nomTitulaire);
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public void retirer(double montant) throws FondsInsuffisantsException {
        if (montant > (getSolde() + decouvertAutorise)) {
            throw new FondsInsuffisantsException("Fonds insuffisants même avec découvert", montant);
        } else {
            super.retirer(montant);
        }
    }
}
