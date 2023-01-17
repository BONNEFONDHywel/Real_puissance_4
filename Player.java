import java.util.Scanner;

public class Player {

    public static void main(String[] args) {
    
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("\nJoueur 1, choisissez votre pseudo\n");
            String player1Name = scan.nextLine();
            System.out.println("\nJoueur 1, choisissez votre symbole\n");
            char player1Symbol = scan.nextLine().charAt(0);
            System.out.println("\nJoueur 2, choisissez votre pseudo\n");
            String player2Name = scan.nextLine();
            System.out.println("\nJoueur 2, choisissez votre symbole\n");
            char player2Symbol = scan.nextLine().charAt(0);
            System.out.println("\nPseudo du joueur 1 : " + player1Name);
            System.out.println("\nSymbole du joueur 1 : " + player1Symbol);
            System.out.println("\nPseudo du joueur 2 : " + player2Name);
            System.out.println("\nSymbole du joueur 2 : " + player2Symbol + "\n");
        }
    }
}