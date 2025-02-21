
import java.util.List;
import java.util.Scanner;

public class jeu {

    private Scanner scanner;
    private int maxTentatives;
    private int nombreDeTours;
    private final String lettres = "BREAK";
    private List<Joueur> joueurs;
    private NiveauDeDifficulte niveauDeDifficulte;

    // Initialisation des variables
    public jeu(List<Joueur> joueurs, NiveauDeDifficulte niveauDeDifficulte) {

        this.scanner = new Scanner(System.in);
        this.maxTentatives = 2;
        this.nombreDeTours = 6;
        this.joueurs = joueurs;
        this.niveauDeDifficulte = niveauDeDifficulte;
    }

    public void demarrer() {

        // Démarre le jeu pour chaque tour
        for (int tour = 1; tour <= nombreDeTours; tour++) {
            System.out.println("\n--- Tour " + tour + " ---");

            String figure = niveauDeDifficulte.getFigureAleatoire();

            // Chaque joueur joue à son tour sur le même tour
            for (Joueur joueur : joueurs) {
                System.out.println("\n" + joueur.getNom() + ", c'est à toi de jouer !");

                int tentativesRestantes = maxTentatives;

                while (tentativesRestantes > 0) {
                    System.out.print("Bboy " + joueur.getNom() + ", as-tu réussi la figure ? (oui/non) ");
                    String reponse = scanner.nextLine().toLowerCase();

                    if (reponse.equals("oui")) {
                        System.out.println("\nBravo " + joueur.getNom() + " ! Tu es un monstre !");
                        break; // Si le joueur réussit, on passe à l'étape suivante
                    } else if (reponse.equals("non")) {
                        tentativesRestantes--;
                        System.out.println("\nDommage " + joueur.getNom() + " ! Essayez encore !");
                    } else {
                        System.out.println("Réponse invalide, réessayez.");
                    }
                }

                // Si le joueur a échoué, il prend une lettre
                if (tentativesRestantes == 0) {
                    perdre(joueur);
                }

                // Si un joueur a pris toutes les lettres BREAK, il perd
                if (joueur.getLettresPrises().length() == lettres.length()) {
                    System.out.println(joueur.getNom() + " a perdu ! GAME OVER ! BREAK !");
                    return; // Arrêter immédiatement si un joueur a perdu
                }
            }

            // À la fin de chaque tour, vérifier si tous les joueurs ont fait la figure
            for (Joueur joueur : joueurs) {
                if (joueur.getLettresPrises().length() < lettres.length()) {

                }
            }
        }

        // Si le jeu a fini et qu'un joueur n'a pas pris toutes les lettres BREAK
        for (Joueur joueur : joueurs) {
            if (joueur.getLettresPrises().length() < lettres.length()) {
                System.out.println(joueur.getNom() + " est un champion !");
            }
        }
    }

    private void perdre(Joueur joueur) {
        if (joueur.getLettresPrises().length() < lettres.length()) {
            char lettre = lettres.charAt(joueur.getLettresPrises().length());
            joueur.ajouterLettre(lettre);
            System.out.println(joueur.getNom() + " a raté ! " );
            System.out.println("\nLettres prises par " + joueur.getNom() + " : " + joueur.getLettresPrises().toString());
        }
    }
}

