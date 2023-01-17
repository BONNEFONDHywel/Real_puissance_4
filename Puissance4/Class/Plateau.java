package Puissance4.Class;

public class Plateau {
    
    public static void gridScreen(int gridSize, int cellSize) {
        int total = gridSize*cellSize;
        char c;
        for(int i=0; i <= total; i++){
            for(int k=0; k <= total; k++){
                if(i % cellSize == 0 || k % cellSize == 0){
                    c = '*';
                } else {
                    c = ' ';
                }
                System.out.print(c);
            }
            System.out.println();
        }
    }

}