/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junior.football.league;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static junior.football.league.Teams.teamArray;

/**
  * This class is responsible for creating Player instances using the given attributes and also deleting them.
 * @author Eldram
 */
public class Players {
    /**
     * creates a String named playerName.
     */
    public String playerName; 

    /**
     * creates a String named position.
     */
    public String position;

    /**
     * creates a String named age.
     */
    public String age;

    /**
     * creates a String named teamName.
     */
    public String teamName;
    
    /**
     * creates a new ArrayList called playerArray.
     */
    public static ArrayList<String> playerArray = new ArrayList();

    /**
     * creates a new String Array named playerAr.
     */
    public static String [] playerAr;
    
    /**
     *Players method that when called runs all contained methods.
     */
    public Players(){
    getPlayers();
}

    /**
     * This methods is responsible for creating player instances using their specific attributes defined below and a FileWriter. 
     * @param playerName the name of a player.
     * @param position the position where a player plays.
     * @param age the age of a player.
     * @param teamName the name of the team they play for pulled from the Teams class.
     * @exception e an exception used to catch any error with the filewriter.
     */
    public void createPlayer(String playerName, String position, String age, String teamName){
    
    this.playerName = playerName;
    this.position = position;
    this.age = age;
    this.teamName = teamName;
    
        try {
            FileWriter writer = new FileWriter("players.txt", true);
            writer.write(playerName +" ");
            writer.write(position +" ");
            writer.write(age +" ");
            writer.write(teamName);
            writer.write(System.getProperty( "line.separator" ));
            writer.close();
            //A FileWriter is used to create a file named 'players' and the specifc input for each attribute is written to the file.
            //the writer seperates each instance by putting one on a new line.
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Player Submitted");
            //When the writer is finished it will then produce a JPanel confirming the submittion.
            } 
        catch(Exception e){
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Error");
            //the catch part of this code runs if the writer does not function, this will cause an error message to appear.
            }
}

    /**
     *getTeams() reads the teams text document.
     */
    public void getTeams(){

    
        try {
            Scanner s = new Scanner(new File("teams.txt"));
            //A scanner is used to get the stored text from the file.        
        while((s.hasNextLine()))
            Teams.teamArray.add(s.nextLine());
            //A while loop uses the scanner to carry on aslong as there is a next line in the text doc.
            //each line is added to the teamArray, as long as there is another line in the doc.            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Error, Can't find file!");
           //if the file can't be found the catch exception will be caught and produces a Jpanel with a Error message.
        }
}

     /**
     * textTeams() uses the teamArray to add objects to the teamAr by turning them into a String format. 
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
     *getPlayers() is used to read from the players text document and add the objects to the playerArray.
     * @param playerArray the ArrayList that will contain all produced player instances.
     * @exception FileNotFoundException If the file isn't present or does not exist then a Jpanel with an error will appear.
     */
    public void getPlayers(){
    
        try {
            Scanner s = new Scanner(new File("players.txt"));
            //A scanner is used to get the stored text from the file.               
        while((s.hasNextLine()))
            playerArray.add(s.nextLine());
            //A while loop uses the scanner to carry on aslong as there is a next line in the text doc.
            //each line is added to the playerArray, as long as there is another line in the doc.
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Error, Can't find file!");
           //if the file can't be found the catch exception will be caught and produces a Jpanel with a Error message.
        }
    
}

    /**
     *textPlayers() uses playerArray to populate playerAr.
     * @return playerAr is returned containing all of the objects contained in the playerArray.
     */
    public static String[] textPlayers(){
    String [] playerAr = new String[playerArray.size()];
        //creates a new instance of playerAr where the String size is that of the playerArray.    
    for(int i = 0; i < playerArray.size(); i++){
        playerAr[i] = playerArray.get(i);
    }   //uses a for loop to continue to loop for the size of the playerArray.
        //each loop gets an object from the playerArray and adds it to the playerAr array in String form.
    return playerAr;
}   //returns a filled playerAr array.

    /**
     * this Method was supposed to use a for loop to get the number of the selected object from the GUI and then use an if statement to remove the number from the Array
     * @param removeLine the integer of which object is to be removed from the Array.
     * @return playerArray the new playerArray with an instance removed.
     */
    public ArrayList<String> deletePlayer(int removeLine){
    //states that when the method is called an int must be provided.
        for (int i = 0; i < playerArray.size(); i++) {
        //a for loop is created that happens for the size of the playerArray and gets the index of each object in the playerArray.
        playerArray.get(i);
        if (i == removeLine) {
            playerArray.remove(i);
            // an if statement state if i is equal to the inputted removeLine Index then it removes it from the playerArray.
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Player Deleted");
            //message is created and a message is placed in a JPanel.
        }
        //System.out.print(teamArray);
}
        return playerArray;
        //returns the new playerArray without the removed index.
}
}
