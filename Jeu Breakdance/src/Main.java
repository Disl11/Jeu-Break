
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Afficher les régles en  First
        System.out.println("\nLes règles du jeu 'BREAK' sont destinées aux danseurs de breakdance !");
        System.out.println("Vous avez 5 tours pour réussir les figures imposées par l'ordinateur.");
        System.out.println("Si vous échouez sur une figure, vous prenez la lettre 'B'. Si vous échouez encore une fois, vous prenez la lettre 'R'.");
        System.out.println("Ainsi de suite jusqu'à accumuler toutes les lettres 'BREAK'. Vous perdez si vous avez toutes les lettres.");
        System.out.println("\nBonne chance à tous !");

        //Demander à l'utilisateur de choisir le niveau de diffculté
        NiveauDeDifficulte niveauDeDifficulte = NiveauDeDifficulte.choisirNiveau();

        // Demander les joueurs à la classe Joueur
        List<Joueur> joueurs = Joueur.demanderJoueurs();

        // Créer un objet jeu avec la liste des joueurs
        jeu jeu = new jeu(joueurs, niveauDeDifficulte);

        // Démarrer le jeu
        jeu.demarrer();
    }
}