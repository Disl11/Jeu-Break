


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class jeu {

    // Object et variable
    private Scanner scanner;
    private List<String> figures;
    private int maxTentatives;
    private int nombreDeTours;
    private final String lettres = "BREAK";
    private StringBuilder lettrePrise;
    private int indexLettre;



    //Constructeur de la classe jeu
    public jeu() {

        //Régles
        System.out.println("Les règles du jeu 'BREAK' sont destinées aux danseurs de breakdance! Vous avez 5 tours pour réussir les figures imposées par l'ordinateur. Si vous échouez sur une figure, vous prenez la lettre 'B'. Si vous échouez encore une fois, vous prenez la lettre 'R'. Ainsi de suite jusqu'à accumuler toutes les lettres 'BREAK'. Vous perdez si vous avez toutes les lettres." );

        // Initialisation des objects et des Variable
        this.scanner = new Scanner(System.in);
        this.lettrePrise = new StringBuilder();
        this.maxTentatives = 2;
        this.nombreDeTours = 6;
        this.indexLettre = 0;
    }

    //Méthode, le danseur lance le dé des figure

    public void figures() {

        figures = new ArrayList<>();
        figures.add("Envolé");
        figures.add("Valse");
        figures.add("Coupole");
        figures.add("Freeze");
        figures.add("Back spin");
    }

    // Méthode qui démarrer le jeu

    public void demarrer() {

        System.out.println("Bienvenue " + Joueur.getNom() + " Prêt a jouer ?"); // Bievenue au joueur

        for (int tour = 1; tour <= nombreDeTours; tour++) {                 //Ajouter des tours de jeu
            System.out.println("\n--- Tour " + tour + " ---");

            int indexAleatoire = ThreadLocalRandom.current().nextInt(figures.size());
            System.out.println( " Figure a réaliser  : " + figures.get(indexAleatoire));   // figure choisi aleatoire dans la liste
            int tentativesRestantes = maxTentatives;                                      // tentative restante

            while (tentativesRestantes > 0) {
                System.out.print("Bboy " + Joueur.getNom() + " as-tu réussi la figure ?  (oui/non) ");
                String reponse = scanner.nextLine().toLowerCase();

                if (reponse.equals("oui")) {
                    System.out.println("Bravo ! t'es un monstre !");
                    break;
                } else if (reponse.equals("non")) {
                    tentativesRestantes--;
                    System.out.println("Dommage ! Essayez encore !");
                } else {
                    System.out.println("Reponse invalide, réessayez.");

                }
            }
            if (tentativesRestantes == 0) {
                perdre();
            }

            if (lettrePrise.length() == lettres.length()) {
                System.out.println("Game over !   BREAK !");
                break;

            }

            if (tour ==  nombreDeTours && lettrePrise.length() < lettres.length()) {
                System.out.println("\nFéliciation ! Tu es un champion");
                break;
            }

        }
    }

    private void perdre() {
        if (indexLettre < lettres.length()) {
            char lettre = lettres.charAt(indexLettre);
            lettrePrise.append(lettres.charAt(indexLettre));
            System.out.println("Tu as raté ! Tu prend la lettre " + lettre);
            System.out.println("Lettres prises : " + lettrePrise.toString());
            indexLettre++;

        }
    }
}