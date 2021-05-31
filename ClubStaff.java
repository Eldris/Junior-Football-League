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

/**
 * This class is responsible for creating ClubStaff instances using the given attributes and deleting.
 * @author Eldram
 */
public class ClubStaff {

    /**
     * Creates a public string named csName;
     */
    public String csName; 

    /**
     *Creates a public string named job;
     */
    public String job;

    /**
     * Creates a public string named age.
     */
    public String age;

    /**
     *Creates a string named teamName.
     */
    public String teamName;
    
    /**
     *creates a public ArrayList named csArray.
     */
    public static ArrayList<String> csArray = new ArrayList();

    /**
     *creates a public String array named csAr.
     */
    public static String [] csAr;    
    
    /**
     *ClubStaff() is a method that when called upon runs the methods listed within.
     */
    public ClubStaff(){ 
    getCS();
    textCS();
}

    /**
     *createCS() is responsible for creating ClubStaff instances using the given attributes.
     * @param csName the name of a staff member.
     * @param job the job of the staff member.
     * @param age the age of the staff member.
     * @param teamName the team that they work for.
     * @exception e an exception used to catch any error with the filewriter.
     */
    public void createCS(String csName, String job, String age, String teamName){
    
    this.csName = csName;
    this.job = job;
    this.age = age;
    this.teamName = teamName;    
    
        try {
            FileWriter writer = new FileWriter("clubStaff.txt", true);
            writer.write(csName +" ");
            writer.write(job +" ");
            writer.write(age +" ");
            writer.write(teamName);
            writer.write(System.getProperty( "line.separator" ));
            //A FileWriter is used to create a file named 'clubStaff' and the specifc input for each attribute is written to the file.
            //the writer seperates each instance by putting one on a new line.
            writer.close();
            
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Staff Member Submitted");
            //When the writer is finished it will then produce a JPanel confirming the submittion.           
        } 
        catch(Exception e){
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Text box is Empty");
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
     * this Method was supposed to use a for loop to get the number of the selected object from the GUI and then use an if statement to remove the number from the Array
     * @param removeLine the integer of which object is to be removed from the Array.
     * @return csArray the new csArray with an instance removed.
     */
    public ArrayList<String> deleteCS(int removeLine){
            //states that when the method is called an int must be provided.
        for (int i = 0; i < csArray.size(); i++) {
        //a for loop is created that happens for the size of the csArray and gets the index of each object in the csArray.            
            csArray.get(i);
        if (i == removeLine) {
            csArray.remove(i);
            // an if statement state if i is equal to the inputted removeLine Index then it removes it from the csArray.
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Staff Member Deleted");
            //message is created and a message is placed in a JPanel.
        }
        //System.out.print(teamArray);
}
        return csArray;
        //returns the new csArray without the removed index.    
}
}
