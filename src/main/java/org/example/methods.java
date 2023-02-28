package org.example;

class Methods extends Operation
{

    public Methods(char[][] arr, int size)
    {
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
    void assign()
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
                arr[i][j] = ' ';
        }
    }
    int insert(int pos,char xo)
    {
        p.println(pos);
        int row = (pos-1)/size;
        int col = (pos-1)%size;
        try
        {

            if(arr[row][col] != ' ')
            {
                return(invalid());
            }
            arr[row][col]=xo;
        }
        catch(Exception e)
        {
            p.println("\nException caught----" + e);
            System.exit(0);
        }
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
                p.println("wow!! player  1 won");
                System.exit(0);
            }
            else
            {
                p.println("wow!! player  2 won");
                System.exit(0);
            }
        }
    }
    void rightdaigonal()
    {
        int player1=0;
        int player2=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if((i+j)==size-1 && arr[i][j]!=' ')
                {
                    if(arr[i][j]=='X')
                    {
                        player1++;
                    }
                    else if(arr[i][j]=='O')
                    {
                        player2++;
                    }
                    cheakof(player1,player2);
                }
            }
        }
    }
    void check()//row cheak
    {
        for(int i=0;i<size;i++)
        {
            int player1=0;
            int player2=0;
            for(int j=0;j<size;j++)
            {
                if(arr[i][j]=='X' && arr[i][j]!=' ')
                {
                    player1++;
                }
                else if(arr[i][j]=='O' && arr[i][j]!=' ')
                {
                    player2++;
                }
            }
            cheakof(player1,player2);
        }
    }
    void cheakof(int player1,int player2)
    {
        if(player1 == size)
        {
            p.println("wow!! player 1 won");
            System.exit(0);
        }
        else if(player2 == size)
        {
            p.println("wow!! player 2 won");
            System.exit(0);
        }
    }
    void cheaks()//col check
    {

        for(int j =0;j<size;j++)
        {
            int play1=0;
            int play2=0;
            for(int i=0;i<size;i++)
            {
                if(arr[i][j]=='X'&& arr[i][j]!=' ')
                {
                    play1++;
                }
                else if(arr[i][j]=='O'&& arr[i][j]!=' ')
                {
                    play2++;
                }
            }
            cheakof(play1,play2);
        }
    }
}