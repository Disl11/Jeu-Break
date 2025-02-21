import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class NiveauDeDifficulte {

    private String niveau;
    private List<String> figures;

// Constructeur
    public NiveauDeDifficulte(String niveau){
        this.niveau = niveau;
        this.figures = new ArrayList<>();
        intialiserFigures();
    }

// Initialisé les figure en fonction du niveau
    private void intialiserFigures(){

        if (niveau.equals("Débutant")){
            figures.add("Valse");
            figures.add("Freeze");
            figures.add("back-spin");
        } else if (niveau.equals("Intermédiaire")) {
            figures.add("Swipe");
            figures.add("Windmill");
            figures.add("Turlte");
        } else if (niveau.equals("Expert")) {
            figures.add("Airflar");
            figures.add("Thomas");
            figures.add("2000");
        }
    }

    public String getFigureAleatoire() {

        int indexAleatoire = ThreadLocalRandom.current().nextInt(figures.size());
        String figureAleatoire = figures.get(indexAleatoire);

        // Afficher la figure à réaliser
        System.out.println("\nFigure à réaliser : " + figureAleatoire);
        return figureAleatoire;
    }



    public static   NiveauDeDifficulte choisirNiveau(){
        Scanner scanner = new Scanner(System.in);
        String niveauChoisi = "";

        while (!niveauChoisi.equals("Débutant") &&  !niveauChoisi.equals("Intermédiaire") && !niveauChoisi.equals("Expert")){
            System.out.print("Choisissez le niveau de diffuclté (Débutant, Intermédiaire, Expert )");
            niveauChoisi = scanner.nextLine();
        }
        return new NiveauDeDifficulte(niveauChoisi);
    }
}

