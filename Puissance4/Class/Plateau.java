package Puissance4.Class;

import java.util.Scanner;

import Puissance4.Class.top.Data;

// Cette classe est créée pour effectuer une partie de puissance 4 dans le mode 2 joueurs
public class Plateau {

    public static String nbcoups1;
	public static String nbcoups2;
	public static int nbcoups;


	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
				// Les 2 joueurs choisissent leurs pseudonyme et leurs pions (représentés par des symboles)
				System.out.println("\nJoueur 1, choisissez votre pseudo\n");
				String player1Name = in.nextLine();
				System.out.println("\nJoueur 1, choisissez votre symbole\n");
				char player1Symbol = in.nextLine().charAt(0);
				System.out.println("\nJoueur 2, choisissez votre pseudo\n");
				String player2Name = in.nextLine();
				System.out.println("\nJoueur 2, choisissez votre symbole\n");
				char player2Symbol = in.nextLine().charAt(0);
				System.out.println(' ');
			// Création de la grille
            char[][] grid = new char[6][7];
            
            // Création des cases pour placer les pions
            for (int row = 0; row < grid.length; row++){
            	for (int col = 0; col < grid[0].length; col++){
            		grid[row][col] = ' ';
            	}
            }
            
			// Initialisation de certains paramètres avant une partie

			// Le nombre de tours, initialisé à 1
            int turn = 1;

			int nbcoups1 = 0;
			int nbcoups2 = 0;

			// Le joueur actuel à jouer
			String currentPlayer = player1Name;

			// Le symbole du premier joueur
            char player = player1Symbol;

			// La condition de victoire, initialisé à "false"
            boolean winner = false;
            
            // Pendant un tour
            while (winner == false && turn <= 42){
            	boolean validPlay;
            	int play;
            	do {
					// Afficher l'état de la grille actuelle, le joueur choisit une colonne où mettre son pion
            		display(grid);
                    System.out.print("Joueur " + currentPlayer + ", choisissez une colonne, s'il vous plaît : ");
                    play = in.nextInt()-1;
					System.out.println(' ');
            		
					// Appelle la fonction validate en-dessous pour vérifier ses conditions
            		validPlay = validate(play,grid);
            		
            	}while (validPlay == false);
            	
            	// Si les conditions de la fonction validate ne sont pas remplies, placer le pion du joueur dans la colonne respective
            	for (int row = grid.length-1; row >= 0; row--){
            		if(grid[row][play] == ' '){
            			grid[row][play] = player;
            			break;
            		}
            	}
            	
            	// Détermine s'il y a un vainqueur
            	winner = Victoire.isWinner(player,grid);
            	
            	// Permet d'échanger les joueurs et leurs symbole après un tour
            	if (currentPlayer == player1Name){
					nbcoups1++;
					currentPlayer = player2Name;
            		player = player2Symbol;
            	}else{
					nbcoups2++;
					currentPlayer = player1Name;
            		player = player1Symbol;
            	}
            	
				// Augmente le nombre de tours de 1
            	turn++;
            }

			// Affiche l'état de la grille après l'alignement de 4 pions semblables
            display(grid);
            
			// Si un vainqueur a été déclaré, effectuer cette condition
            if (winner){
            	if (player==player1Symbol){
            		System.out.println(player2Name + " a gagné ! Félicitations !\n");
					nbcoups = nbcoups1;
					Data top = new Data();
					top.writeTop10();
            	}else{
            		System.out.println(player1Name + " a gagné ! Félicitations !\n");
            	}
            }else{
            	System.out.println("Il y a égalité. Bien joué au deux joueurs !\n");
            }
        }
		
	}
	
	// Permet d'afficher la grille sur le terminal
	public static void display(char[][] grid){
		System.out.println(" 1 2 3 4 5 6 7");
		System.out.println("---------------");
		for (int row = 0; row < grid.length; row++){
			System.out.print("|");
			for (int col = 0; col < grid[0].length; col++){
				System.out.print(grid[row][col]);
				System.out.print("|");
			}
			System.out.println();
			System.out.println("---------------");
		}
		System.out.println(" 1 2 3 4 5 6 7");
		System.out.println();
	}
	

	public static boolean validate(int column, char[][] grid){
        // Si un chiffre n'étant pas entre 1 et 7 est écrit pour le choix d'une colonne, renvoie cette erreur
        if (column < 0 || column > grid[0].length){
            System.out.println("\nVeuillez choisir une colonne non remplie entre 1 et 7.\n");
            return false;
        }
    
        // Si une colonne pleine est sélectionnée, renvoie cette erreur
        if (grid[0][column] != ' '){
            System.out.println("\nCette colonne est remplie, veuillez en choisir une autre.\n");
            return false;
        }
		
		// Sinon, passe cette fonction
		return true;
	}
	
}