package Puissance4.Class;

// Cette classe est créée pour les conditions de victoire du puissance 4
public class Victoire {

    public static boolean isWinner(char player, char[][] grid){
		// Si 4 mêmes pions sont alignés horizontalement, alors mettre la condition de victoire à "True".
		for(int row = 0; row<grid.length; row++){
			for (int col = 0;col < grid[0].length - 3;col++){
				if (grid[row][col] == player   && 
					grid[row][col+1] == player &&
					grid[row][col+2] == player &&
					grid[row][col+3] == player){
					return true;
				}
			}			
		}
		// Si 4 mêmes pions sont alignés verticalement, alors mettre la condition de victoire à "True".
		for(int row = 0; row < grid.length - 3; row++){
			for(int col = 0; col < grid[0].length; col++){
				if (grid[row][col] == player   && 
					grid[row+1][col] == player &&
					grid[row+2][col] == player &&
					grid[row+3][col] == player){
					return true;
				}
			}
		}
		// Si 4 mêmes pions sont alignés en diagonales (de haut-gauche à bas-droite), alors mettre la condition de victoire à "True".
		for(int row = 3; row < grid.length; row++){
			for(int col = 0; col < grid[0].length - 3; col++){
				if (grid[row][col] == player   && 
					grid[row-1][col+1] == player &&
					grid[row-2][col+2] == player &&
					grid[row-3][col+3] == player){
					return true;
				}
			}
		}
		// Si 4 mêmes pions sont alignés en diagonales (de haut-droite à bas-gauche), alors mettre la condition de victoire à "True".
		for(int row = 0; row < grid.length - 3; row++){
			for(int col = 0; col < grid[0].length - 3; col++){
				if (grid[row][col] == player   && 
					grid[row+1][col+1] == player &&
					grid[row+2][col+2] == player &&
					grid[row+3][col+3] == player){
					return true;
				}
			}
		}
		// Sinon mettre la condition de victoire à "false".
		return false;
	}
    
}
