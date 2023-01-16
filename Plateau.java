import java.util.*;

public class Plateau {
    
    private int nbLig;
    private int nbCol;
    private char [][] grille;

    public Grille(int n, int p){
        nbLig = n;
        nbCol = p;
        grille = new char[nbLig][nbCol];

        for(int i=0; i<nbLig; i++){
            for(int j=0; j<nbCol; j++){
                grille[i][j] = ' ';
            }
        }
    }

    public void afficher(){
        System.out.println();
        for(int i=0; i<nbLig; i++){
            for(int j=0; j<nbCol; j++){
                System.out.println(" | " + grille[i][j]);
            }
            System.out.println(" | ");
        }
        System.out.println();
    }

}