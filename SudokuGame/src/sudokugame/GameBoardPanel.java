package sudokugame;
/*
FileName: GameBoardPanel.java
Author: Daniela Georgieva
Date: 23/04/2022
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameBoardPanel extends JPanel {
   
/*
here i have defined the constants for 
the grid size and cell sizes in pixels    
*/
public static final int GRID_SIZE = 9;
public static final int BOX_SIZE = GRID_SIZE / 3;

public static final int CELL_SIZE = 60;
public static final int BOARD_WIDTH = CELL_SIZE * GRID_SIZE;
public static final int BOARD_HEIGHT = CELL_SIZE * GRID_SIZE;
  
/*
i have basically customized the JPanel 
to be a 9x9 grid containing a puzzle
*/
private final Cell[][] cells = new Cell[GRID_SIZE][GRID_SIZE];
private final Puzzle puzzle = new Puzzle();

/*
this is the constructor that puts the array of Cell
inside the grid made with JPanel, then i made a CellInputListener
that checks the status of the cells 
*/
public GameBoardPanel(){
    super.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
    
    for(int row = 0; row < GRID_SIZE; ++row){
        for(int col = 0; col < GRID_SIZE; ++col){
            cells[row][col] = new Cell(row, col);
            super.add(cells[row][col]);
        }
    }
    CellInputListener listener = new CellInputListener();
    for(int row = 0; row < GRID_SIZE; ++row){
        for (int col = 0; col < GRID_SIZE; ++col){
        if(cells[row][col].isEditable()){
            cells[row][col].addActionListener(listener);
        }
    }
    }

    super.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
}

/*
here this generates a new puzzle and initializes the 9x9 cells 
*/
    public void init(){
    puzzle.newPuzzle(2);
    for(int row = 0; row < GRID_SIZE; ++row){
        for(int col = 0; col < GRID_SIZE; ++col){
            cells[row][col].init(puzzle.numbers[row][col], puzzle.isGiven[row][col]);
            
        }
    }
}
/*
this method returns true upon the puzzle being solved 
(as established already, that happens when none of the 
cells' status is TO_GUESS or WRONG)    
*/
public boolean isSolved(){
    for(int row = 0; row < GRID_SIZE; ++row){
        for(int col = 0; col < GRID_SIZE; ++col){
            if(cells[row][col].status == CellStatus.TO_GUESS || cells[row][col].status == CellStatus.WRONG){
                return false;
            }
        }
    }
    return true;
}
/*
here i have made the class for the listener
and the actions it does - painting the cells
according to their status
*
i have also implemented event handling, thanks to which 
in case something other than a digit is input
a pane will pop up displaying that it should be a digit
*/
  private class CellInputListener implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e){
          int numberIn = -1;
          Cell sourceCell = (Cell)e.getSource();
          try{
             numberIn = Integer.parseInt(sourceCell.getText());
             System.out.println("You entered " + numberIn);}
          
          catch(Exception e1){
              JOptionPane.showMessageDialog(null, "Input cannot be empty or a letter. Try with a digit!");
          }
          if(numberIn == sourceCell.number){
              sourceCell.status = CellStatus.CORRECT;
             sourceCell.paint();
          }else {
              if(numberIn != sourceCell.number){
              sourceCell.status = CellStatus.WRONG;
             sourceCell.paint();
          } else{
              if(numberIn == sourceCell.number){
              sourceCell.status = CellStatus.GIVEN;
              }
            }
            }
        sourceCell.paint();
/*
calling isSolved, if it returns true,
a pane will pop up saying congrats 
on solving the puzzle
*/
       if(isSolved() == true){
       JOptionPane.showMessageDialog(null, "Congratulations! Puzzle has been solved successfully!");
      
     }
  
  }
}
}

