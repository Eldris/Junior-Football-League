/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junior.football.league;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static junior.football.league.Teams.teamArray;

/**
 * This class is responsible for populating the  LeagueTable.
 * @author Eldram
 */
public class LeagueTable {
    
    /**
     * getTeams() is a method that uses the created file to pull the information from and add it to the teamArray using a Scanner.
     * @param teamArray the empty array is populated here.
     * @exception FileNotFoundException If the file isn't present or does not exist then a Jpanel with an error will appear. 
     */
    public void getTeams(){
        try {
            Scanner s = new Scanner(new File("teams.txt"));
               //A scanner is used to get the stored text from the file.
        while((s.hasNextLine()))
            teamArray.add(s.nextLine());
            //A while loop uses the scanner to carry on aslong as there is a next line in the text doc.
            //each line is added to the teamArray, as long as there is another line in the doc.
            
        } catch (FileNotFoundException ex) {
           JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Error");
           //if the file can't be found the catch exception will be caught and produces a Jpanel with a Error message.
            }
}

    /**
     * textTeams() uses the teamArray to populate teamAr.
     * @return teamAr is returned containing all of the objects from teamArray in String Array form.
     */
    public static String[] textTeams(){
    String[] teamAr = new String[teamArray.size()];
        //creates a new instance of teamAr where the String size is that of the teamArray.
    for(int i = 0; i < teamArray.size(); i++){
        teamAr[i] = teamArray.get(i);
    }   //uses a for loop to continue to loop for the size of the teamArray.
        //each loop gets an object from the teamArray and adds it to the teamAr array in String form.
    return teamAr;
}   //returns a filled teamAr array.

}


