import java.util.Scanner;

public class Joueur {

    private static String nom;

    public Joueur(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez votre nom : ");
        nom = scanner.nextLine();
    }
    public static String getNom() {
        return nom;
    }
}