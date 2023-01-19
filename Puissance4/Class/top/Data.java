package Puissance4.Class.top;

import java.util.ArrayList;
import java.util.List;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

public class Data{

    private static Player player;


    private static final String SEPARATEUR = ";";

    public static List<Data> readTop10() throws FileNotFoundException, IOException, ParseException {
        List<Data> list = new ArrayList<>();
        try (BufferedReader buf = new BufferedReader(new FileReader("Data.csv"))) {
            String ligne = buf.readLine();
            while (ligne != null) {
                String[] tab = ligne.split(SEPARATEUR);
                Data c = new Data();
                //Player.setNom(tab[0]);
                //Player.setNbr(Integer.parseInt( tab[1]));
            }
        }
        return list;
    }

    private Player nbcoups;

    public void writeTop10(){
        
      
        try {
        
            FileWriter writer = new FileWriter("Data.csv", true);
            BufferedWriter bw1 = new BufferedWriter(writer); 
            PrintWriter pw2 = new PrintWriter(bw1);
            
            
            
            pw2.println(player + " : " + nbcoups);


        }catch(IOException e){
            System.out.println("erreur");
        }
                

        
        

        //ecrire dans le fichier les données de la list
    
}
}
