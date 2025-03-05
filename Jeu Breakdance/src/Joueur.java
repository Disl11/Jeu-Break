import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Joueur {

    private String nom;
    private StringBuilder lettrePrise;

    public Joueur(String nom) {
        this.nom = nom;
        this.lettrePrise = new StringBuilder(); // Initialise les lettres prises
    }

    public String getNom() {
        return nom;
    }

    public StringBuilder getLettresPrises() {
        return lettrePrise;
    }

    public void ajouterLettre(char lettre) {
        lettrePrise.append(lettre);
    }

    // Méthode pour demander les joueurs à l'utilisateur et retourner la liste des joueurs
    public static List<Joueur> demanderJoueurs() {
        Scanner scanner = new Scanner(System.in);
        List<Joueur> joueurs = new ArrayList<>();

        // Demander combien de joueurs participent
        int nombreDeJoueurs; // declartation variable
        while (true) {
            try {
                System.out.print("\n Combien de joueurs jouent ? (maximum 4) ");
                // Si l'utilisateur rentre un nombre entier
                nombreDeJoueurs = Integer.parseInt(scanner.nextLine());
                if (nombreDeJoueurs <= 0) {
                    System.out.println("Veuillez entrer un nombre positif.");
                } else if (nombreDeJoueurs > 4 ) {
                    System.out.println("Nombre de joueurs maximum 4");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide, veuillez entrer un nombre entier.");
            }
        }

        // Demander les noms des joueurs
        for (int i = 1; i <= nombreDeJoueurs; i++) {
            System.out.print("Entrez le nom du joueur " + i + ": ");
            String nomJoueur = scanner.nextLine();  // Récupère le nom du joueur
            joueurs.add(new Joueur(nomJoueur)); // Ajoute un joueur à la liste
        }

        return joueurs;
    }
}