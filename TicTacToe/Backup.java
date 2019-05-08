/*
import java.util.Scanner;

public class Main {
    public static char player='x';
    public static char opponent='o';

    public static int MAX=1000;
    public static int MIN=-1000;

    public static boolean isMovesLeft(char[][] board)
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]=='_')
                    return true;
            }
        }
        return false;
    }

    public static int evaluate(char[][] b)
    {
        for(int row=0;row<3;row++)
        {
            if(b[row][0]==b[row][1]&& b[row][1]==b[row][2])
            {
                if(b[row][0]=='o')
                    return 1;
                else if(b[row][0]=='x')
                    return -1;
            }
        }

        for(int col=0;col<3;col++)
        {
            if(b[0][col]==b[1][col]&& b[1][col]==b[2][col])
            {
                if(b[0][col]=='o')
                    return 1;
                else if(b[0][col]=='x')
                    return -1;
            }
        }

        if(b[0][0]==b[1][1] && b[1][1]==b[2][2])
        {
            if(b[0][0]=='o')
                return 1;
            else if(b[0][0]=='x')
                return -1;
        }

        if(b[0][2]==b[1][1] && b[1][1]==b[2][0])
        {
            if(b[0][2]=='o')
                return 1;
            else if(b[0][2]=='x')
                return -1;
        }

        return 0;
    }

    public static int minimaxAlphaBeta(char[][] board,int depth,boolean isMax,int alpha,int beta)
    {
        int score=evaluate(board);
        if(score==1)return  score;
        if(score==-1)return  score;
        if(isMovesLeft(board)==false) return 0;

        int best=isMax?MIN:MAX;

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]=='_')
                {
                    board[i][j]=isMax?opponent:player;
                    int val=minimaxAlphaBeta(board,depth+1,!isMax,alpha,beta);
                    if(isMax)
                    {
                        best=java.lang.Math.max(best,val);
                        alpha=java.lang.Math.max(alpha,best);
                    }
                    else
                    {
                        best=java.lang.Math.min(best,val);
                        beta=java.lang.Math.min(beta,best);
                    }
                    board[i][j]='_';
                    if(beta<=alpha)
                        break;
                }
            }
        }
        return best;
    }

    public static int minimax(char[][] board,int depth, boolean isMax)
    {
        int score=evaluate(board);
        if(score==1)return  score;
        if(score==-1)return  score;
        if(isMovesLeft(board)==false) return 0;

        int best=isMax ? -1000 :1000;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]=='_')
                {
                    board[i][j]=isMax ? opponent :player;
                    if(isMax)
                    {
                        best=java.lang.Math.max(best,minimax(board,depth+1,!isMax));
                    }
                    else{
                        best=java.lang.Math.min(best,minimax(board,depth+1,!isMax));
                    }
                    board[i][j]='_';
                }
            }
        }
        return best;
    }

    public static Move findBestMove(char[][] board)
    {
        int bestVal=-1000;
        Move bestMove=new Move(-1,-1);

        for (int i = 0; i<3; i++)
            for (int j = 0; j<3; j++)
                if (board[i][j]=='_') {
                    board[i][j] = opponent;
                    int moveVal = minimaxAlphaBeta(board, 0, false,MIN,MAX);

                    board[i][j] = '_';

                    if (moveVal > bestVal) {
                        bestMove.setRow(i);
                        bestMove.setCol(j);
                        bestVal = moveVal;
                    }
                }

        return bestMove;
    }

    public static void main(String[] args) {
        char[][] board={
                {'_','_','_'},
                {'_','_','_'},
                {'_','_','_'}
        };

        for(int i=0;i<board.length;i++) {
            for (int j = 0; j < board[i].length; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }

        Move bestMove;
        int moveRow;
        int moveCol;
        int value=0;
        Scanner scanner=new Scanner(System.in);

        while(isMovesLeft(board))
        {
            System.out.println("Wykonaj ruch.");
            System.out.print("Wybierz wiersz: ");
            moveRow=scanner.nextInt();
            System.out.print("Wybierz kolumne: ");
            moveCol=scanner.nextInt();
            board[moveRow][moveCol]='x';

            System.out.println("==========");
            for(int i=0;i<board.length;i++)
            {
                for(int j=0;j<board[i].length;j++)
                    System.out.print(board[i][j]+ " ");
                System.out.println();
            }
            System.out.println("==========");
            value=evaluate(board);
            if(value==1 || value==-1)
                break;

            bestMove=findBestMove(board);
            if(!isMovesLeft(board))
                break;
            board[bestMove.getRow()][bestMove.getCol()]='o';
            for(int i=0;i<board.length;i++)
            {
                for(int j=0;j<board[i].length;j++)
                    System.out.print(board[i][j]+ " ");
                System.out.println();
            }
            System.out.println("==========");
            value=evaluate(board);
            if(value==1 || value==-1)
                break;

        }
        if(value==1)
        {
            System.out.println("Przegrales");
        }
        else if(value==-1)
        {
            System.out.println("Wygrales");
        }
        else
        {
            System.out.println("Remis");
        }


    }
}
*/