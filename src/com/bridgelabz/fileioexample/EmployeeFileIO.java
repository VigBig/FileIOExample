package com.bridgelabz.fileioexample;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class EmployeeFileIO {

    public static final String EMP_DIR_PATH = "C:/Users/bilgi/IdeaProjects/Java Remap/FileIOExample/EmployeeDirectory";
    public static final String EMP_FILE_PATH = EMP_DIR_PATH + "/EmployeeData.txt";

    public boolean writeEmployeeData(List<Employee> employeeList) {

        Path directoryPath = Paths.get(EMP_DIR_PATH);
        Path filePath = Paths.get(EMP_FILE_PATH);
        boolean isWriteSuccessful = true;

        System.out.println("Does "+EMP_DIR_PATH+" exist ? " + Files.exists(directoryPath));
        System.out.println("Does "+EMP_FILE_PATH+" exist ? " + Files.exists(filePath));

        if(Files.notExists(directoryPath)){

            try{
                Files.createDirectories(directoryPath);

            }catch(IOException e){
                e.printStackTrace();
                isWriteSuccessful = false;
            }

        }else{

            if(Files.notExists(filePath)) {

                try {
                    Files.createFile(filePath);

                    StringBuffer empBuffer = new StringBuffer();

                    for (Employee emp : employeeList) {
                        empBuffer.append(emp.getId() + "\t" + emp.getName() + "\t"
                                + emp.getSalary() + "\n");
                    }

                    Files.write(filePath, empBuffer.toString().getBytes());
                    isWriteSuccessful = true;

                } catch (IOException e) {
                    e.printStackTrace();
                    isWriteSuccessful = false;
                }

            }
        }

        System.out.println("Does "+EMP_DIR_PATH+" exist ? " + Files.exists(directoryPath));
        System.out.println("Does "+EMP_FILE_PATH+" exist ? " + Files.exists(filePath));
        return isWriteSuccessful;


    }

    public void readEmployeeData() {

        try {
            Files.lines(new File(EMP_FILE_PATH).toPath()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
