package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main1 {

    public static void main(String[] args) {
        try{
            byte[] data = Files.readAllBytes(Paths.get("text.txt"));
            String text = new String(data,  StandardCharsets.UTF_8);
            System.out.println(text);
        }catch (IOException e){
            e.printStackTrace();
        }



            File file = new File("text.txt");

        try {
            FileInputStream inputStream = new FileInputStream(file);
            InputStreamReader fileReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

            char[] buffer = new char[10];
           while(true){
             int readBytes = fileReader.read(buffer, 0, buffer.length);
                     if(readBytes == -1){
                         break;
                     }
               System.out.println(buffer);
           }
            }catch (IOException e) {
            e.printStackTrace();
           }



//        int readBytes = fileReader.read(buffer, 0, 1024);




//        System.out.println("Hi m8");

	// write your code here
    }
}
