package com.bridgelabz.fileioexample;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileIOExample {
    //1. Set Directory Path
    public static final String DIR_PATH = "C:/Users/bilgi/IdeaProjects/Java Remap/FileIOExample/TestDirectory";
    //4. Set File Path
    public static final String FILE_PATH = DIR_PATH + "/TestFile.txt";

    public static void main(String[] args) {
        System.out.println("File IO Example:");
        //2. Set the directory path to the reference of I/F "Path" with Paths.get()
        Path directoryPath = Paths.get(DIR_PATH);
        //5. Set the file path to the reference of I/F "Path" with Paths.get()
        Path filePath = Paths.get(FILE_PATH);

        //3.a. Check if directoryPath exists Files.exists(), if not then create path with Files.createDirectories().
        System.out.println("Does "+DIR_PATH+" exist ? " + Files.exists(directoryPath));
        //6.a. Check if filePath exists Files.exists(), if not then create path with Files.createFile().
        System.out.println("Does "+FILE_PATH+" exist ? " + Files.exists(filePath));

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

        }else{

            if(Files.notExists(filePath)) {
                //6.b. Much like in Step 3.b., You have to create the file , if the file doesn't exist.

                try {
                    Files.createFile(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        System.out.println("Does "+DIR_PATH+" exist ? " + Files.exists(directoryPath));
        System.out.println("Does "+FILE_PATH+" exist ? " + Files.exists(filePath));
    }
}
