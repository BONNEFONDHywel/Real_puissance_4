package Puissance4;

import Puissance4.Class.Plateau;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    
    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.println("Bienvenue au jeu du puissance 4 !\n");
        System.out.print("Veullez choisir une option parmi les quatre proposés en tapant le bon chiffre, s'il vous plaît : ");
    }
    public static void main(String[] args) {
        String[] options = {"\n1- Affronter l'ordinateur",
                            "2- Affronter un joueur",
                            "3- Regarder les meilleures scores",
                            "4- Quitter\n",
        };
        try (Scanner scanner = new Scanner(System.in)) {
            int option = 1;
            while (option!=4){
                printMenu(options);
                try {
                    option = scanner.nextInt();
                    if (option < 1 || option > 4) {
                        System.out.println("\nS'il vous plaît, entrez un chiffre compris entre 1 et 4.");
                    } else if(option == 1){
                        try (Scanner scan = new Scanner(System.in)) {
                            System.out.println("\nJoueur 1, choisissez votre pseudo\n");
                            String player1Name = scan.nextLine();
                            System.out.println("\nJoueur 1, choisissez votre symbole\n");
                            char player1Symbol = scan.nextLine().charAt(0);
                            System.out.println("\nJoueur 2, choisissez votre pseudo\n");
                            String player2Name = scan.nextLine();
                            System.out.println("\nJoueur 2, choisissez votre symbole\n");
                            char player2Symbol = scan.nextLine().charAt(0);
                        }
                        Plateau.gridScreen(7, 6);
                    } else if(option == 2){
                        System.out.println("\nVous avez choisi l'option 2.");
                    } else if(option == 3){
                        System.out.println("\nVous avez choisi l'option 3.");
                    }
                }
                catch (InputMismatchException ex){
                    System.out.println("\nS'il vous plaît, entrez un chiffre compris entre 1 et 4.");
                    scanner.next();
                }
                catch (Exception ex){
                    System.out.println("\nUne erreur inconnue est apparue. Réessayez encore, s'il vous plaît.");
                    scanner.next();
                }
            }
            System.out.println("\nMerci d'avoir utilisé notre programme ! Nous vous souhaitons une excellente journée. !\n");
        }
    }
}