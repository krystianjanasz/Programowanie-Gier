import javax.swing.*;

public class Main {

    public static void main(String[] args)
    {
        JFrame ticTacToe=new TicTacToe();
        ticTacToe.setTitle("Tic Tac Toe");
        ticTacToe.setSize(600,600);
        ticTacToe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ticTacToe.setLocationRelativeTo(null);
        ticTacToe.setVisible(true);

    }

}

