package org.example;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Tictactoe {
    public static void main(String[] args)
    {
        PrintStream p= new PrintStream(new FileOutputStream(FileDescriptor.out));
        Scanner inp = new Scanner(System.in);
        p.println("enter size");
        int size = inp.nextInt();
        char[][] arr =new char[size][size];
        Operation obj = new Operation(arr,size);
        obj.main();
    }
}

