package org.example;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;


class Operation {
    int size;
    char[][] arr;
    public  Operation(char[][] arr, int size)
    {
        this.arr=arr;
        this.size=size;
    }

    PrintStream p= new PrintStream(new FileOutputStream(FileDescriptor.out));

    public  void main()
    {
        Methods m = new Methods(arr,size);
        m.assign();
        p.println("player 1 --> X");
        p.println("player 2 --> O");

        int inc=0;
        Scanner inpobject = new Scanner(System.in);
        while(inc<size*size)
        {

            if(inc%2==0)
            {
                p.println("enter the position to insert 1 to 9 \nPlayer 1-> X");
                char x='X';
                int pos = inpobject.nextInt();
                int inval=m.insert(pos,x);
                if(inval==1)
                {
                    inc--;
                }
                m.display();
                m.daigonalchks(inc);
                m.rightdaigonal();
                m.check();
                m.cheaks();
            }
            else
            {
                p.println("enter the position to insert 1 to 9 \nPlayer 2-> O");
                char o='O';
                int pos = inpobject.nextInt();
                int inval=m.insert(pos,o);
                if(inval==1)
                {
                    inc--;
                }
                m.display();
                m.daigonalchks(inc);
                m.rightdaigonal();
                m.check();
                m.cheaks();
            }
            inc++;
            if(inc==size*size)
            {
                p.println("Match Draw!!");
            }
        }


    }
}