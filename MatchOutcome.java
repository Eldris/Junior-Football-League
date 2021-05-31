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
 * This class is responsible for submitting MatchOutcomes and printing match results.
 * @author Eldram
 */

public class MatchOutcome {

    /**
     * creates a String named homeTeam.
     */
    public String homeTeam;

    /**
     * creates a String named awayTeam.
     */
    public String awayTeam;

    /**
     *creates a String named homeScore.
     */
    public String homeScore;

    /**
     *creates a String named awayScore.
     */
    public String awayScore;
    
    /**
     *creates a ArrayList named resultsArray.
     */
    public static ArrayList<String> resultArray = new ArrayList();

    /**
     *creates a new String array named resAr.
     */
    public static String [] resAr;

    /**
     * creates a new Integer array named teamResults.
     */
    public static int [] teamResults = new int[teamArray.size()];
    
    resultUI rUI;

    /**
     *MatchOutcome method that when called runs all contained methods.
     */
    public MatchOutcome() {
    //teamResults = pullTeams();
    textTeams();
    getResults();
    textResults();
}

    /**
     * This method is responsible for creating result instances using the input for the given attributes.
     * @param homeTeam name of the home team.
     * @param awayTeam name of the away team.
     * @param homeScore score for the home team.
     * @param awayScore score for the away team.
     */
    public void createResults(String homeTeam, String awayTeam, String homeScore, String awayScore){
    
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
    this.homeScore = homeScore;
    this.awayScore = awayScore;
    
        try {
            FileWriter writer = new FileWriter("results.txt", true);
            writer.write(homeTeam +": ");
            writer.write(homeScore +" vs ");
            writer.write(awayTeam +": ");
            writer.write(awayScore);
            writer.write(System.getProperty( "line.separator" ));
            writer.close();
            //A FileWriter is used to create a file named 'results' and the specifc input for each attribute is written to the file.
            //the writer seperates each instance by putting one on a new line.            
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Result Submitted");
            //When the writer is finished it will then produce a JPanel confirming the submittion.            
            } 
        catch(Exception e){
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Error");
             //the catch part of this code runs if the writer does not function, this will cause an error message to appear.           
            }
}

/*public int[] pullTeams(){
    System.out.println(teamArray.size());
    for (int i = 0; i< teamArray.size(); i++){
        //System.out.println("help");
        teamResults[i] = 0;
    }
        return teamResults;    
}*/

    /**
     *Draw() is called upon when the inputted result is a draw. it gives both teams 1 point.
     * @param team the home team.
     * @param team2 the away team.
     */


public void draw(int team, int team2){
    teamResults[team] +=1;
    teamResults[team2] +=1;
    //adds one point to both teams point total.
}

    /**
     *Win() is called upon when the home team wins. it give the home team 3 points.
     * @param team - home team.
     */
public void win(int team){
    teamResults[team] +=3;
    //adds three points to both teams point totals.
}

    /**
     *Lose() is called upon when the away team wins. it gives the away team 3 points.
     * @param team - away team.
     */
public void lose(int team){
    teamResults[team] +=3;
    //adds three points to the away teams point total.
}

    /**
     *getReuslts() reads the results text document.
     */
    public void getResults(){
        
        try {
            Scanner s = new Scanner(new File("results.txt"));
            //A scanner is used to get the stored text from the file.                       
        while((s.hasNextLine()))
            resultArray.add(s.nextLine());
            //A while loop uses the scanner to carry on aslong as there is a next line in the text doc.
            //each line is added to the reusltArray, as long as there is another line in the doc.                        
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Error, Can't find file!");
           //if the file can't be found the catch exception will be caught and produces a Jpanel with a Error message.
        }
    
    }
    
    /**
     *textResults() uses the resultsArray to add objects to the resAr by turning them into a String format.
     * @return resAr is returned containing all of the objects from resultArray in String Array form.
     */
    public static String[] textResults() {
    String[] resAr = new String[resultArray.size()];
    //creates a new instance of resAr where the String size is that of the resultArray.    
    for(int i = 0; i < resultArray.size(); i++){
        resAr[i] = resultArray.get(i);
    }   //uses a for loop to continue to loop for the size of the teamArray.
        //each loop gets an object from the resultArray and adds it to the resAr array in String form.
        return resAr;   
    }   //returns a filled resAr array.
    
    /**
     * getTeams() is a method that uses the created file to pull the information from and add it to the teamArray using a Scanner. 
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
