package com.io.printstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class demo {
    public static void main(String[] args) {
        PrintStream printStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/huangzhenmin/Desktop/123.txt"));
            printStream = new PrintStream(fileOutputStream,true);
            if (printStream!= null){
                System.setOut(printStream);
            }
            for (int i = 0; i < 255; i++) {
                System.out.print((char)i);
                if (i%50==0){
                    System.out.print("\n");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
