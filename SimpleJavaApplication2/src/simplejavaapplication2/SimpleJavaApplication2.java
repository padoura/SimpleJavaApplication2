/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavaapplication2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author davidoster
 */
public class SimpleJavaApplication2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String folder = "C:\\temp\\";
        String subfolder = "temp1\\";
        String fileName = "file.txt";
        
        File tempDir = new File(folder);
        FileHandler.createPath(tempDir);
        
        File tempDir1 = new File(folder + subfolder);
        FileHandler.createPath(tempDir1);
        
        try {
            PrintWriter writer = new PrintWriter(folder + subfolder + fileName);
            // code from https://github.com/alekarios/JAVA_homeworks/blob/master/lesson5/simple_java_app_2/Simple_java_app_2.java - MODIFIED
            // TODO code application logic here
            Scanner input = new Scanner(System.in);
            Person person = new Person();
            FileHandler fileHandler = new FileHandler(writer);

            System.out.println("Give your first name");
            String fullName = input.next() + "/-";

            System.out.println("Give your last name");
            fullName += input.next() + "/-";

            System.out.println("Give your father's name");
            fullName += (input.next());

            person.setName(fullName);

            person.setBirthDate();

            for(int i = 1; i <= 3; i++){
                switch(i){
                    case 1: 
                        //writer.println("Line " + i + ": " + this.lastName + ", " + this.firstName + ", " + this.fathersName);
                        fileHandler.writeString(i,"Last Name: " + person.getLastName() + ", First Name: " + person.getFirstName() + ", Father's Name: " + person.getFathersName());
                        break;
                    case 2: 
                        fileHandler.writeString(i,"Your birthday is on: " + person.getBirthday());
                        break;
                    default:
                        fileHandler.writeString(i, "Your age is: " + (Calendar.getInstance().get(Calendar.YEAR) - person.getBirthYearInt()));
                    break;
                }
            }
            
            // Read the fullname
            File file = new File(folder + subfolder + fileName);
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            String line = buffer.readLine();
            String[] names = line.split(",");
            String[] fNameField = names[0].split(": ");
            String[] lNameField = names[1].split(": ");
            String[] fathNameField = names[2].split(": ");
            
            Person anotherPerson = new Person();
            anotherPerson.setFirstName(fNameField[fNameField.length-1]);
            anotherPerson.setLastName(lNameField[lNameField.length-1]);
            anotherPerson.setFatherName(fathNameField[fathNameField.length-1]);
            
            System.out.println(fNameField[fNameField.length-1] + " " + lNameField[lNameField.length-1] + " " + fathNameField[fathNameField.length-1]);
            
            // Read the birthday
            line = buffer.readLine();
            String[] fields = line.split(" ");
            String month = fields[7];
            String day = fields[8];
            String year = fields[fields.length-1];
            
            
            Date date = new SimpleDateFormat("MMM").parse(month);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int monthNum = cal.get(Calendar.MONTH) + 1;
            
            String birthday = day + "/" + monthNum + "/" + year;
            System.out.println(birthday);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date parsedDate = dateFormat.parse(birthday);
            
            anotherPerson.setBirthday(parsedDate);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SimpleJavaApplication2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SimpleJavaApplication2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(SimpleJavaApplication2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}