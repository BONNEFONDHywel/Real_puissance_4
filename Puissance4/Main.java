package Puissance4;

import java.util.InputMismatchException;
import java.util.Scanner;

import Puissance4.Class.Plateau;

// Classe principale pour activer le puissance 4
public class Main {
    
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
            int option = 0;
            while (true){
                printMenu(options);
                try {
                    option = scanner.nextInt();
                    if (option < 1 || option > 4) {
                        System.out.println("\nS'il vous plaît, entrez un chiffre compris entre 1 et 4.");
                        continue;
                    } else if(option == 1){
                        System.out.println("\nVous avez choisi l'option 1.");
                        continue;
                    } else if(option == 2){
                        break;
                    } else if(option == 3){
                        System.out.println("\nVous avez choisi l'option 3.");
                        continue;
                    } else if(option == 4){
                        System.out.println("\nMerci d'avoir utilisé notre programme ! Nous vous souhaitons une excellente journée !\n");
                        System.exit(0);
                    }
                }
                catch (InputMismatchException ex){
                    System.out.println("\nS'il vous plaît, entrez un chiffre compris entre 1 et 4.");
                    scanner.next();
                }
            }
            while(true){
                Scanner sh = new Scanner(System.in);
                Plateau.main(args);
                System.out.println("Voulez-vous rejouer ? O (oui)/N (non)");
                String answer = sh.nextLine();
                sh.close();
                if (answer.equals("O") || answer.equals("o")) {
                    System.out.println("Ok, jouons encore une fois !");
                    continue;
                } else if(answer.equals("N") || answer.equals("n")) {
                    System.out.println("\nMerci d'avoir utilisé notre programme ! Nous vous souhaitons une excellente journée !\n");
                    System.exit(0);
                } else {
                    break;
                }
            }
        }
    }
}