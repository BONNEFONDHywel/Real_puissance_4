package Puissance4.Class;

import java.util.Scanner;

public class Plateau {

    public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			System.out.println("\nJoueur 1, choisissez votre pseudo\n");
            String player1Name = in.nextLine();
            System.out.println("\nJoueur 1, choisissez votre symbole\n");
            char player1Symbol = in.nextLine().charAt(0);
            System.out.println("\nJoueur 2, choisissez votre pseudo\n");
            String player2Name = in.nextLine();
            System.out.println("\nJoueur 2, choisissez votre symbole\n");
            char player2Symbol = in.nextLine().charAt(0);
			System.out.println(' ');
            char[][] grid = new char[6][7];
            
            //initialize array
            for (int row = 0; row < grid.length; row++){
            	for (int col = 0; col < grid[0].length; col++){
            		grid[row][col] = ' ';
            	}
            }
            
            int turn = 1;
			String currentPlayer = player1Name;
            char player = player1Symbol;
            boolean winner = false;
            
            //play a turn
            while (winner == false && turn <= 42){
            	boolean validPlay;
            	int play;
            	do {
            		display(grid);
                    System.out.print("Joueur " + currentPlayer + ", choisissez une colonne, s'il vous plaît : ");
                    play = in.nextInt()-1;
            		
            		//validate play
            		validPlay = validate(play,grid);
            		
            	}while (validPlay == false);
            	
            	//drop the checker
            	for (int row = grid.length-1; row >= 0; row--){
            		if(grid[row][play] == ' '){
            			grid[row][play] = player;
            			break;
            		}
            	}
            	
            	//determine if there is a winner
            	winner = Victoire.isWinner(player,grid);
            	
            	//switch players
            	if (currentPlayer == player1Name){
					currentPlayer = player2Name;
            		player = player2Symbol;
            	}else{
					currentPlayer = player1Name;
            		player = player1Symbol;
            	}
            	
            	turn++;
            }
            display(grid);
            
            if (winner){
            	if (player==player1Symbol){
            		System.out.println(player2Name + " a gagné ! Félicitations !\n");
            	}else{
            		System.out.println(player1Name + " a gagné ! Félicitations !\n");
            	}
            }else{
            	System.out.println("Il y a égalité. Bien joué au deux joueurs !\n");
            }
        }
		
	}
	
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
	
	/**
	* @param column
	* @param grid
	* @return
	*/
	public static boolean validate(int column, char[][] grid){
        //valid column?
        if (column < 0 || column > grid[0].length){
            System.out.println("\nVeuillez choisir une colonne non remplie entre 1 et 7.\n");
            return false;
        }
    
        //full column?
        if (grid[0][column] != ' '){
            System.out.println("\nCette colonne est remplie, veuillez en choisir une autre.\n");
            return false;
        }
		
		return true;
	}
	
}