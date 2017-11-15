/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavaapplication2;

import java.io.File;
import java.io.PrintWriter;
import java.util.Calendar;

/**
 *
 * @author padou
 */
public class FileHandler {
    
    private PrintWriter writer;
    
    public FileHandler(PrintWriter writer){
        this.writer = writer;
    }
    
    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }
    
    public void writeString(int i, String s) {
        writer.println("Line " + i + ": " + s);
        if(i == 3) writer.close();
    }
    
    public static void createPath(File path){
        if (!path.exists()){
            path.mkdir();
            System.out.println(path.getPath() + " created!");
        }
        else
            System.out.println(path.getPath() + " exists!");
    }
    
}
