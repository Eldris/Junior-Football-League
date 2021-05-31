/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junior.football.league;

import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * This class is used to create instances of Teams and also deleting them.
 * @author Eldram
 */

public class Teams{

    /**
     *Declares a public variable.
     * @param teamName contains the instances of inputted Team names.
     */
    public String teamName;

    /**
     * Creates a new String Array List.
     * @param teamArray the Array that is going to store each Team Name.
     */
    public static ArrayList<String> teamArray = new ArrayList();

    /**
     *Declares the name for a String Array.
     * @param teamAr used to create a String array for the Team names.
     */
    public static String [] teamAr;
    

    /**
     * The createTeam method uses a FileWriter to create a file that will house all the teamName's.
     * @param teamName it is implemented to get the inputted name. 
     * @exception if there is an issue when running the filewriter then an error window will appear. 
     */
    public void createTeam(String teamName){
    this.teamName = teamName;
    try {
            FileWriter writer = new FileWriter("teams.txt", true);
            writer.write(teamName);
            writer.write(System.getProperty( "line.separator" ));
            writer.close();
           // A file writer is used to create a file call 'teams' that will then be then write the teamNames to the file.
           //After the teamName is written it will drop to a new line.

            //System.out.println(teamArray);
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Team Submitted");
            //When the writer is finished a window will appear stating that the submittion has worked.
        } 
    catch(Exception e){
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Error");
}

}

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

    /**
     * this Method was supposed to use a for loop to get the number of the selected object from the GUI and then use an if statement to remove the number from the Array
     * @param removeLine the integer of which object is to be removed from the Array.
     * @return teamArray the new teamArray with an instance removed.
     */
    public ArrayList<String> deleteTeam(int removeLine) {
    //states that when the method is called an int must be provided.
       for (int i = 0; i < teamArray.size(); i++) {
        teamArray.get(i);
        //a for loop is created that happens for the size of the teamArray and gets the index of each object in the teamArray.
        if (i == removeLine) {
            teamArray.remove(i);
            // an if statement state if i is equal to the inputted removeLine Index then it removes it from the teamArray.
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Team Deleted");
            //message is created and a message is placed in a JPanel.
        }
        //System.out.print(teamArray);
}
        return teamArray;
        //System.out.print(teamArray);
        //returns the new teamArray without the removed index.
}
}

    
    

  
    

