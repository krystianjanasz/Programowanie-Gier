import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame{
    private char whoseTurn='x';
    private boolean gameOver;

    public Board[][] board=new Board[3][3];
    private char[][] board2={
            {'_','_','_'},
            {'_','_','_'},
            {'_','_','_'}
    };

    JLabel jlblStatus= new JLabel("tura X");

    public TicTacToe()
    {
        JPanel panel=new JPanel(new GridLayout(3,3));
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                panel.add(board[i][j] = new Board());
            }
        }
        panel.setBorder(new LineBorder(Color.black,1));
        jlblStatus.setBorder(new LineBorder(Color.white,1));

        add(panel,BorderLayout.CENTER);
        add(jlblStatus,BorderLayout.SOUTH);
    }

    public boolean isFull()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j].getToken() ==' ')
                    return false;
            }
        }
        return true;
    }

    public boolean isWon(char token)
    {
        for(int i=0;i<3;i++)
        {
            if(board[i][0].getToken()==token &&
                    board[i][1].getToken()==token &&
                    board[i][2].getToken()==token)
            {
                return true;
            }
            if(board[0][i].getToken()==token &&
                    board[1][i].getToken()==token &&
                    board[2][i].getToken()==token)
            {
                return true;
            }
        }
        if(board[0][0].getToken()==token &&
            board[1][1].getToken()==token &&
            board[2][2].getToken()==token)
        {
            return true;
        }
        if(board[0][2].getToken()==token &&
            board[1][1].getToken()==token &&
            board[2][0].getToken()==token)
        {
            return true;
        }
        return false;
    }

    public class Board extends JPanel {
        private char token=' ';

        public Board()
        {
            setBorder(new LineBorder(Color.BLACK,1));
            addMouseListener(new MyMouseListener());
        }

        public char getToken()
        {
            return token;
        }

        public void setToken(char c)
        {
            token=c;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            if(token=='x')
            {
                g.drawLine(10,10,getWidth()-10,getHeight()-10);
                g.drawLine(getWidth()-10,10,10,getHeight()-10);
            }
            else if(token=='o')
            {
                g.drawOval(10,10,getWidth()-20,getHeight()-20);
            }
        }

        private  class MyMouseListener extends  MouseAdapter
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(gameOver)
                    return;
                if(token==' '&& whoseTurn ==' ')
                    setToken(whoseTurn);


                if(isWon(whoseTurn))
                {
                    gameOver=true;
                    jlblStatus.setText(whoseTurn+ " won! Game over!");
                }
                else if(isFull())
                {
                    gameOver=true;
                    jlblStatus.setText("Remis!");
                }
                else
                {
                    whoseTurn=(whoseTurn=='x')?'o':'x';
                    jlblStatus.setText(whoseTurn+"turn");
                }
            }
        }
    }
}

