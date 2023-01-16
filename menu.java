import java.util.InputMismatchException;
import java.util.Scanner;

public class menu {
    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Bienvenue au jeu du puissance 4 !");
        System.out.print("Veullez choisir une option parmi les quatre proposés, s'il vous plaît : ");
    }
    public static void main(String[] args) {
        String[] options = {"1- Affronter l'ordinateur",
                            "2- Affronter un joueur",
                            "3- Regarder les meilleures scores",
                            "4- Quitter",
        };
        try (Scanner scanner = new Scanner(System.in)) {
            int option = 1;
            while (option!=4){
                printMenu(options);
                try {
                    option = scanner.nextInt();
                    //if (option <= 1 ) {
                        
                    //}
                }
                catch (InputMismatchException ex){
                    System.out.println("Please enter an integer value between 1 and " + options.length);
                    scanner.next();
                }
                catch (Exception ex){
                    System.out.println("An unexpected error happened. Please try again");
                    scanner.next();
                }
            }
        }
    }
}