package org.example;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Logger;

public class Tictactoe {
    public static void main(String[] args)
    {
        PrintStream p= new PrintStream(new FileOutputStream(FileDescriptor.out));
        Logger l = Logger.getLogger("kawin");
        Scanner inp = new Scanner(System.in);
        System.out.println("enter size");
        int size = inp.nextInt();
        char[][] arr =new char[size][size];
        Oper obj = new Oper(arr,size);
        obj.main();
    }
}
class Oper
{
    int size;
    char[][] arr;
     public  Oper(char[][] arr, int size)
    {
        this.arr=arr;
        this.size=size;
    }

    PrintStream p= new PrintStream(new FileOutputStream(FileDescriptor.out));

    public  void main()
    {
        Methods m = new Methods(arr,size);
        for(int i=0;i<size;i++)
        {
           for(int j=0;j<size;j++)
                arr[i][j] = ' ';
        }
        p.println("player 1 --> X");
       p.println("player 2 --> O");

        int i=0,ch;
        Scanner inp = new Scanner(System.in);
       while(i<size*size)
       {
           int a=0;
           if(i%2==0)
           {
               p.println("enter the position to insert 1 to 9 \nPlayer 1-> X");
               char x='X';
               ch = inp.nextInt();
               //m.insert(ch,x);
               int inval=m.insert(ch,x);
               if(inval==1)
               {
                   i--;
               }
               m.display();
               m.daigonalchks(i);
               m.rightdaigonal();
               m.check1();
               m.cheak(a);
           }
           else
           {
               p.println("enter the position to insert 1 to 9 \nPlayer 2-> O");
               char O='O';
               ch = inp.nextInt();
               int inval=m.insert(ch,O);

               if(inval==1)
               {
                   i--;
               }
               if(inval==-1)
               {
                   break;
               }
               m.display();
               m.daigonalchks(i);
               m.rightdaigonal();
               m.check1();
               m.cheak(a);
           }
            i++;
        if(i==9)
        {
            p.println("Match Draw!!");
        }
       }


    }
}
class Methods extends Oper
{

    public Methods(char[][] arr, int size) {
        super(arr, size);
    }
    void display()
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                p.print("|"+arr[i][j]+"|");
            }
            p.println();
        }
    }
    int insert(int ch,char x)
    {
        System.out.println(ch);
        int row = (ch-1)/size;
        int col = (ch-1)%size;
        if(arr[row][col] != ' ')
        {
            return(invalid());
        }
        arr[row][col]=x;


        return 0;
    }
    int invalid()
    {
        p.println("Invalid position enter re again");
        return 1;
    }
    void daigonalchks(int player)
    {
        int inc=0;
        for(int i=1;i<size;i++)
        {
            if(arr[0][0]==arr[i][i] && arr[i][i]!=' ')
            {
                 inc++;
            }
        }
        if(inc==size-1)
        {
            if(player%2==0)
            {
                p.println("wow!! player 1 won");
                System.exit(0);
            }
            else
            {
                p.println("wow!! player 2 won");
                System.exit(0);
            }
        }
    }
    void rightdaigonal()
    {
        int play1=0;
        int play2=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if((i+j)==size-1 && arr[i][j]!=' ')
                {
                        if(arr[i][j]=='X')
                        {
                           play1++;
                        }
                        else if(arr[i][j]=='O')
                        {
                        play2++;
                        }
                        cheakof(play1,play2);
                }
            }
        }
    }
    void check1()//row cheak
    {
        for(int i=0;i<size;i++)
        {
            int f1=0;
            int f2=0;
            for(int j=0;j<size;j++)
            {
                if(arr[i][j]=='X')
                {
                    f1++;
                }
                else if(arr[i][j]=='O')
                {
                    f2++;
                }
            }
            if(f1 == size)
            {
                p.println("wow!! player 1 won");
                System.exit(0);
            }
            else if(f2 == size)
            {
                p.println("wow!! player 2 won");
                System.exit(0);
            }
            cheakof(f1,f2);
        }
    }
    void cheakof(int p1,int p2)
    {
        if(p1 == size)
        {
            p.println("wow!! player 1 won");
            System.exit(0);
        }
        else if(p2 == size)
        {
            p.println("wow!! player 2 won");
            System.exit(0);
        }
    }
    void cheak(int f)//col check
    {
        for(int j =0;j<size;j++)
        {
            f++;
            int f1=0;
            int f2=0;
            for(int i=0;i<size;i++)
            {
                if(arr[i][j]=='X')
                {
                    f1++;
                }
                else if(arr[i][j]=='O')
                {
                    f2++;
                }
            }
            cheakof(f1,f2);

        }
    }
}