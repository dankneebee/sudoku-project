package sudokugame;
/*
FileName: SudokuMain.java
Author: Daniela Georgieva
Date: 23/04/2022
*/
import java.awt.*;
import javax.swing.*;

/*
in this main program i start by working on the GUI of
the game; adding a button that currently does nothing
as i only have one puzzle ive added to be displayed, and
a constructor inside the class 
*/
public class SudokuMain extends JFrame {

   GameBoardPanel board = new GameBoardPanel();
   JButton btnNewGame = new JButton("New Game");

   public SudokuMain() {
      Container cp = getContentPane();
      cp.setLayout(new BorderLayout());
      cp.add(board, BorderLayout.CENTER);
      cp.add(btnNewGame, BorderLayout.SOUTH);
     
      board.init();

      pack();    
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      setTitle("Sudoku");
      setVisible(true);
   }
   
   /*
   main method which runs all the code and starts
   the program
   */

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         @Override
         public void run() {
            new SudokuMain().setVisible(true);
         }    
        });
    }
}