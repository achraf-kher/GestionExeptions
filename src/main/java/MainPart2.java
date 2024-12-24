import java.util.ArrayList;


public class MainPart2 {
    public static void main(String[] args) {
        ArrayList<CompteBancaire> comptes = new ArrayList<>();

        // Ajouter des comptes
        CompteCourant cc = new CompteCourant("001", 500, "Alice", 200);
        CompteEpargne ce = new CompteEpargne("002", 1000, "Bob", 2.5);
        comptes.add(cc);
        comptes.add(ce);

        // Dépôts et retraits
        try {
            cc.deposer(100);
            cc.retirer(700); // Avec découvert autorisé
            ce.appliquerInteret();
        } catch (FondsInsuffisantsException e) {
            System.out.println(e.getMessage() + ". Montant problématique : " + e.getMontant());
        }

        // Afficher le solde de chaque compte
        for (CompteBancaire compte : comptes) {
            compte.afficherSolde();
        }

        // Transfert entre comptes
        try {
            transfererArgent(comptes, "001", "002", 300);
        } catch (CompteInexistantException | FondsInsuffisantsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void transfererArgent(ArrayList<CompteBancaire> comptes, String from, String to, double montant)
            throws CompteInexistantException, FondsInsuffisantsException {
        CompteBancaire source = chercherCompte(comptes, from);
        CompteBancaire destination = chercherCompte(comptes, to);

        source.retirer(montant);
        destination.deposer(montant);
    }

    public static CompteBancaire chercherCompte(ArrayList<CompteBancaire> comptes, String numero)
            throws CompteInexistantException {
        for (CompteBancaire compte : comptes) {
            if (compte.getNumeroCompte().equals(numero)) {
                return compte;
            }
        }
        throw new CompteInexistantException("Compte avec le numéro " + numero + " introuvable.");
    }
}
