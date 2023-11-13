/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author yongx
 */
public class test4 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String path1 = "src/resource/cust.csv";
        String path2 = "src/resource/employee.csv";
        String path3 = "src/resource/sales.csv";
        String path4 = "src/resource/vehicle.csv";
        int status;
        
        System.out.print("Enter [0]Sales Employee or [1]Management Employee: ");
        status = sc.nextInt();
        switch (status) {
            case 0: {
                readCSV(path1);
                readCSV(path3);
                readCSV(path4);
            } break;
            
            case 1: {
                readCSV(path1);
                readCSV(path2);
                readCSV(path3);
                readCSV(path4);
                System.out.print("Enter [0]To add employee or [1]To exit: ");
                int add = sc.nextInt();
                switch (add) {
                    case 0: {
                        System.out.print("Enter the number of employees to be added: ");
                        int number=sc.nextInt();
                        String[] data=new String[number];
                        for (int i=0; i<number; i++) {
                            System.out.print("Enter the information in the form of ID,Name,Status,Password: ");
                            data[i] = sc.next();
                            System.out.println("The employee has been added successfully.");
                        }
                        appendToCSV(path2, number, data); 
                    } break;
                } 
            } break;
         
        default: 
            System.out.println("Please enter a valid status.");
            break;
        } 
    }
    
    private static List<String[]> readCSV(String filePath) {
        List<String[]> csv = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] column = line.split(",");
                csv.add(column);
            }
        } 
        catch (IOException e) {
        }
        return csv;
    }
    
    private static void appendToCSV(String filePath, int number, String[] data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            // Append the new data to the file
            for (int i = 0; i < data.length; i++) {
                bw.write(data[i]);
                if (i < data.length - 1) {
                    bw.write(","); // Add the CSV delimiter (comma in this case)
                }
                bw.newLine();
            }
        } 
        catch (IOException e) {
        }
    }
        
}