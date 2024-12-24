public class Main {
    public static void main(String[] args) {
        try {

            EntierNaturel entier = new EntierNaturel(5);
            System.out.println("Valeur initiale : " + entier.getVal());

            entier.decrementer();
            System.out.println("Après décrémentation : " + entier.getVal());

            entier.decrementer();
            entier.decrementer();
            entier.decrementer();
            entier.decrementer();

        } catch (NombreNegatifException e) {
            System.out.println("Exception attrapée : " + e.getMessage());
            System.out.println("Valeur erronée : " + e.getValeurErronee());
        }

        try {
            EntierNaturel entierNegatif = new EntierNaturel(-1);
        } catch (NombreNegatifException e) {
            System.out.println("Exception attrapée : " + e.getMessage());
            System.out.println("Valeur erronée : " + e.getValeurErronee());
        }
    }
}
