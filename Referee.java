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
 * This class is used to create instance of Referees and also deleting them.
 * @author Eldram
 */

public class Referee {

    /**
     *Creates public string variable refName.
     */
    public String refName;
    
    /**
     *Creates public ArrayList refArray.
     */
    public static ArrayList<String> refArray = new ArrayList();

    /**
     *Creates public String Array refsAr.
     */
    public static String [] refsAr;
    
    /**
     * Creates a Referee() method that when called runs methods within.
     */
    public Referee(){
    getRefs();
    textRefs();
}

    /**
     *createRef() uses a FileWriter to create a flie that will store all instances of referees.
     * @param refName stores the inputted name.
     */
    public void createRef(String refName){
        this.refName = refName;

        try {
            FileWriter writer = new FileWriter("referee.txt", true);
            writer.write(refName);
            writer.write(System.getProperty( "line.separator" ));
            writer.close();
            // A file writer is used to create a file call 'referee' that will then be then write the refName to the file.
            //After the refName is written it will drop to a new line.

            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Referee Submitted");
            } 
            //When the writer is finished a window will appear stating that the submittion has worked.

        catch(Exception e){
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Error");
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
     * this Method was supposed to use a for loop to get the number of the selected object from the GUI and then use an if statement to remove the number from the Array
     * @param removeLine the integer of which object is to be removed from the Array.
     * @return refArray the new refArray with an instance removed.
     */
    public ArrayList<String> deleteRef(int removeLine){
        //states that when the method is called an int must be provided.
        for (int i = 0; i < refArray.size(); i++) {
        refArray.get(i);
        //a for loop is created that happens for the size of the refArray and gets the index of each object in the refArray.
        if (i == removeLine) {
            refArray.remove(i);
            // an if statement state if i is equal to the inputted removeLine Index then it removes it from the refArray.
            JOptionPane.showMessageDialog(new javax.swing.JPanel(), "Referee Deleted");
            //message is created and a message is placed in a JPanel.
        }
        //System.out.print(teamArray);
}
        return refArray;
         //returns the new refArray without the removed index.   
}
}
