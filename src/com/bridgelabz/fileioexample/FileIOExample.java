package com.bridgelabz.fileioexample;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileIOExample {

    public static final String DIR_PATH = "C:/Users/bilgi/IdeaProjects/Java Remap/FileIOExample/TestDirectory";

    public static void main(String[] args) {
        System.out.println("File IO Example:");
        //2. Set the path to the reference of I/F "Path" with Paths.get()
        Path directoryPath = Paths.get(DIR_PATH);

        //3.a. Check if directoryPath exists , if not then create path with Files.exists().

        System.out.println("Does "+DIR_PATH+" exist ? " + Files.exists(directoryPath));

        if(Files.notExists(directoryPath)){
            //3.b. NOTE: Compiler will not allow you to create a directory/file/path for directory or file until
            //you handle the IOException. Either place the "Files.createDirectories(directoryPath);" code in
            // a try block and catch the IOException through printStackTrace() OR
            // write "throws IOException" next to the class name.

            try{
                Files.createDirectories(directoryPath);
            }catch(IOException e){
                e.printStackTrace();
            }

        }

        System.out.println("Does "+DIR_PATH+" exist ? " + Files.exists(directoryPath));
    }
}
