/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavaapplication2;

/**
 *
 * @author davidoster
 */

// original code from https://github.com/alekarios/JAVA_homeworks/blob/master/lesson5/simple_java_app_2/Person.java - MODIFIED
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Person {
    private String lastName;
    private String firstName;
    private String fathersName;
    private Date birthday;
    
    public void setName(String fullName){
        String[] names = fullName.split("/-");
        setFirstName(names[0]);
        setLastName(names[1]);
        setFatherName(names[2]);
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public void setFatherName(String fathersName) {
        this.fathersName = fathersName;
    }
    public String getFathersName() {
        return this.fathersName;
    }
    
    public void setBirthDate() {
        // code from https://stackoverflow.com/a/27583797 - MODIFIED
        System.out.println("Enter your date of birth using the format (DD/MM/YYYY):");
        Date date = validateDate();
        setBirthday(date);
    }
    
    public Date validateDate(){
        Scanner scanner = new Scanner(System.in);
        Date parsedDate = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        while(true){
            try{
                String date = scanner.nextLine();
                parsedDate = dateFormat.parse(date);
                return parsedDate;
            }
            catch (Exception e){
                System.out.println("Invalid format! nter your date of birth using the format (DD/MM/YYYY):");
                String newlineC = scanner.nextLine();
            }
        }
    }
    
    public void setBirthday(Date date) {
        this.birthday = date;
    }
    
    public Date getBirthday() {
        return this.birthday;
    }

    public int getBirthYearInt() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(birthday);
        return calendar.get(Calendar.YEAR);
    }
}