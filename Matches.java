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
import static junior.football.league.ClubStaff.csArray;
import static junior.football.league.Players.playerArray;
import static junior.football.league.Referee.refArray;
import static junior.football.league.Teams.teamArray;

/**
 * This class is responsible for creating match instance using all of the attributes, deleting a match and printing out match reports.
 * @author Eldram
 */

public class Matches {

    /**
     * creates a public String named match.
     */
    public String match;

    /**
     * creates a public String named ref.
     */
    public String ref;

    /**
     * creates a public String named homeTeam.
     */
    public String homeTeam;

    /**
     * creates a public String named homeStaff.
     */
    public String homeStaff;

    /**
     * creates a public String named homeCap.
     */
    public String homeCap;

    /**
     * creates a public String named homeSubs.
     */
    public String homeSubs;

    /**
     * creates a public String named awayTeam.
     */
    public String awayTeam;

    /**
     *creates a public String named awayStaff.
     */
    public String awayStaff;

    /**
     * creates a public String named awayCap.
     */
    public String awayCap;

    /**
     * creates a public String named awaySubs.
     */
    public String awaySubs;
    
    /**
     * creates a public ArrayList named matchReportArray.
     */
    public static ArrayList<String> matchReportArray = new ArrayList();

    /**
     * creates a String array named mRAr.
     */
    public static String [] mRAr;
    
    /**
     * creates a public ArrayList named matchArray.
     */
    public static ArrayList<String> matchArray = new ArrayList();

    /**
     * creates a public String array named matchAr.
     */
    public static String [] matchAr;
    
    /**
     *Matches() method that when called runs all contained methods.
     */
    public Matches(){
    getMatchReport(); textMatchReport();
    getMatch(); textMatch();
    //getTeams(); textTeams();
    getRefs(); textRefs();
    getPlayers(); textPlayers();
    getCS(); textCS();
    //all above methods are called so when the Matches class is run so are these.
}

    /**
     * createMatchReport() is responsible for creating match instances using all of the inputted attributes.
     * @param match the home team name and the away team name.
     * @param ref the officiating referee.
     * @param homeStaff the home club staff.
     * @param homeCap the captain of the home team.
     * @param homeTeam all of the home players.
     * @param homeSubs all of the home subs.
     * @param awayStaff the away club staff.
     * @param awayCap the captain of the away team.
     * @param awayTeam all of the away Players.
     * @param awaySubs all of the away subs.
     * @exception e an exception used to catch any error with the filewriter.
     */
    public void createMatchReport
        (String match, String ref, String homeStaff, String homeCap, String homeTeam, String homeSubs,
         String awayStaff, String awayCap, String awayTeam, String awaySubs){
    this.match = match;
    this.ref = ref;
    this.homeStaff = homeStaff;
    this.homeCap = homeCap;
    this.homeTeam = homeTeam;
    this.homeSubs = homeSubs;
    this.awayStaff = awayStaff;
    this.awayCap = awayCap;
    this.awayTeam = awayTeam;
    this.awaySubs = awaySubs;
    
        try {
            FileWriter writer = new FileWriter("matchReport.txt", true);
            writer.write(match +" ");
            writer.write(ref +" ");
            writer.write(homeStaff +" ");
            writer.write(homeCap +" ");
            writer.write(homeTeam +" ");
            writer.write(homeSubs +" ");
            writer.write(awayStaff +" ");
            writer.write(awayCap +" ");
            writer.write(awayTeam +" ");
            writer.write(awaySubs +" ");
            writer.write(System.getProperty( "line.separator" ));
            writer.close();
            //A FileWriter is used to create a file named 'matchReport' and the specifc input for each attribute is written to the file.
            //the writer seperates each instance by putting one on a new line.            
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Match Report Submitted");
            //When the writer is finished it will then produce a JPanel confirming the submittion.            
            } 
        catch(Exception e){
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Error");
            //the catch part of this code runs if the writer does not function, this will cause an error message to appear.            
            }        
    
}

    /**
     *getMatchReport() reads the matchReport text document.
     */
    public void getMatchReport(){

        try {
            Scanner s = new Scanner(new File("matchReport.txt"));
            //A scanner is used to get the stored text from the file.                       
        while((s.hasNextLine()))
            matchReportArray.add(s.nextLine());
            //A while loop uses the scanner to carry on aslong as there is a next line in the text doc.
            //each line is added to the matchReportArray, as long as there is another line in the doc.                        
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Error, Can't find file!");
           //if the file can't be found the catch exception will be caught and produces a Jpanel with a Error message.
        }
    
}

    /**
     * textMatchReport() uses the matchReportArray to add objects to the mRAr by turning them into a String format. 
     * @return mRAr is returned containing all of the objects from teamArray in String Array form.
     */
    public static String[] textMatchReport(){
    String[] mRAr = new String[matchReportArray.size()];
    //creates a new instance of mRAr where the String size is that of the matchReportArray.    
    for(int i = 0; i < matchReportArray.size(); i++){
        mRAr[i] = matchReportArray.get(i);
    }   //uses a for loop to continue to loop for the size of the matchReportArray.
        //each loop gets an object from the matchReportArray and adds it to the mRAr array in String form.

    return mRAr;
    //returns a filled mRAr array.
}   
    /**
     * This methods is responsible for creating player instances using their specific attributes defined below and a FileWriter.
     * @param match the home team name and the away team name.
     * @exception e an exception used to catch any error with the filewriter.
     */
    public void createMatch(String match){
    
        try {
            FileWriter writer = new FileWriter("match.txt", true);
            writer.write(match);
            writer.write(System.getProperty( "line.separator" ));
            writer.close();
            //A FileWriter is used to create a file named 'match' and the specifc input for each attribute is written to the file.
            //the writer seperates each instance by putting one on a new line.            
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Match Submitted");
            } 
            //When the writer is finished it will then produce a JPanel confirming the submittion.        
        catch(Exception e){
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Error");
            //the catch part of this code runs if the writer does not function, this will cause an error message to appear.            
            }
    
}

    /**
     * getMatch() reads the match text document.
     */
    public void getMatch(){
    
        try {
            Scanner s = new Scanner(new File("match.txt"));
            //A scanner is used to get the stored text from the file.                       
        while((s.hasNextLine()))
            matchArray.add(s.nextLine());
            //A while loop uses the scanner to carry on aslong as there is a next line in the text doc.
            //each line is added to the matchArray, as long as there is another line in the doc.                        
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Error, Can't find file!");
           //if the file can't be found the catch exception will be caught and produces a Jpanel with a Error message.
        }
    
}

    /**
     * textMatch() uses the matchArray to add objects to the matchAr by turning them into a String format. 
     * @return teamAr is returned containing all of the objects from matchArray in String Array form.
     */
    public static String[] textMatch(){
    String[] matchAr = new String[matchArray.size()];
    //creates a new instance of matchAr where the String size is that of the matchArray.    
    for(int i = 0; i < matchArray.size(); i++){
        matchAr[i] = matchArray.get(i);
    }   //uses a for loop to continue to loop for the size of the matchArray.
        //each loop gets an object from the matchArray and adds it to the matchAr array in String form.
    
    return matchAr;   
}   //returns a filled matchAr array.

    /**
     * this Method was supposed to use a for loop to get the number of the selected object from the GUI and then use an if statement to remove the number from the Array
     * @param removeLine the integer of which object is to be removed from the Array.
     * @return matchArray the new matchArray with an instance removed.
     */
    public ArrayList<String> deleteMatch(int removeLine){
    //states that when the method is called an int must be provided.    
        for (int i = 0; i < matchArray.size(); i++) {
        //a for loop is created that happens for the size of the matchArray and gets the index of each object in the matchArray.            
        matchArray.get(i);
        if (i == removeLine) {
            matchArray.remove(i);
            // an if statement state if i is equal to the inputted removeLine Index then it removes it from the matchArray.            
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Match Deleted");
            //message is created and a message is placed in a JPanel.
        }
        //System.out.print(teamArray);
}
        return matchArray;
        //returns the new matchArray without the removed index.    
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
     *getRefs() is a method that uses the created file to pull the information and add it to the refArray using a Scanner.
     * @param refArray the empty array is populated here.
     * @exception FileNotFoundException If the file isn't present or does not exist then a Jpanel with an error will appear. 
     */
    public void getRefs(){
    
        try {
            Scanner s = new Scanner(new File("referee.txt"));
            //A scanner is used to get the stored text from the file.
        while((s.hasNextLine()))
            refArray.add(s.nextLine());
            //A while loop uses the scanner to carry on aslong as there is a next line in the text doc.
            //each line is added to the refArray, as long as there is another line in the doc.
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Error, Can't find file!");
           //if the file can't be found the catch exception will be caught and produces a Jpanel with a Error message.
        }    
    
}

    /**
     * textTeams() uses the refArray to populate refAr.
     * @return refAr returned containing all of the objects from refArray in String form.
     */
    public static String[] textRefs(){
    String[] refAr = new String[refArray.size()];
    //creates a new instance of refAr where the String size is that of the refArray.
    for(int i = 0; i < refArray.size(); i++){
        refAr[i] = refArray.get(i);
    }  //uses a for loop to continue to loop for the size of the refArray.
       //each loop gets an object from the refArray and adds it to the trefAr array in String form.

    return refAr;
}   //returns a filled refAr array.

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
     *getCS() is used to read from the clubStaff text document and add the objects to the csArray.
     * @param csArray the ArrayList that will contain all produced clubStaff instances.
     * @exception FileNotFoundException If the file isn't present or does not exist then a Jpanel with an error will appear.     *
     */
    public void getCS() {

        try {
            Scanner s = new Scanner(new File("clubStaff.txt"));
            //A scanner is used to get the stored text from the file.                         
        while((s.hasNextLine()))
            csArray.add(s.nextLine());
            //A while loop uses the scanner to carry on aslong as there is a next line in the text doc.
            //each line is added to the csArray, as long as there is another line in the doc.            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Error, Can't find file!");
           //if the file can't be found the catch exception will be caught and produces a Jpanel with a Error message.
        }    
}

    /**
     *textCS() uses the csArray to add objects to the teamAr by adding them in a string format.
     * @return csAr is returned containing all of the objects from csArray in String Array form.
     */
    public static String[] textCS(){
    String[] csAr = new String[csArray.size()];
    //creates a new instance of csAr where the String size is that of the csArray.    
    for(int i = 0; i < csArray.size(); i++){
        csAr[i] = csArray.get(i);
    }   //uses a for loop to continue to loop for the size of the csArray.
        //each loop gets an object from the csArray and adds it to the csAr array in String form.
    return csAr;    
}   //returns a filled csAr array.
}
