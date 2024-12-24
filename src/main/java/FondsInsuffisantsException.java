public class FondsInsuffisantsException extends Exception {
    private double montant;

    public FondsInsuffisantsException(String message, double montant) {
        super(message);
        this.montant = montant;
    }

    public double getMontant() {
        return montant;
    }
}
