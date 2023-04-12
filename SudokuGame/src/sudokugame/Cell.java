
package sudokugame;
/*
FileName: CellStatus.java
Author: Daniela Georgieva
Date: 23/04/2022
 */

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

/**
this is the Cell class, which i use to remodel the javax.swing.JTextField component and have it 
also include rows and columns, as well as the puzzle number and status of the current puzzle
* 
the purpose of this is to model the grid, aka the cells of the sudoku, so not only customize the 
JTextField component, but also change the appearance 
* 
I have imported the java.awt.Color and java.awt.Font subclasses in order to change color and font of cells
*/
public class Cell extends JTextField {
   
 
/*
defining the variables for row column and number, as well as the
enum CellStatus
*/
    int row, column;
    int number;
    CellStatus status;
    
/*
constructor of the class
*/
    public Cell(int row, int column){
        super();
        this.row = row;
        this.column = column;
        super.setHorizontalAlignment(JTextField.CENTER);
        super.setFont(FONT_NUMBERS);
    }
    
/*
in the following i change the color and font of the text in the
cells according to what their status is
*/   
     public static final Color BG_GIVEN = Color.WHITE;
     public static final Color FG_GIVEN = Color.BLACK;
     public static final Color FG_NOT_GIVEN = Color.GRAY;
     public static final Color BG_TO_GUESS = Color.ORANGE;
     public static final Color BG_CORRECT = Color.GREEN;
     public static final Color BG_WRONG = Color.RED;
     public static final Font FONT_NUMBERS = new Font("Calibri", Font.BOLD, 26);
    
/*
this is the initialization of the cell for a new game, 
including the number of the puzzle and the status of whether
a number is given or not     
*/
    public void init(int number, boolean isGiven){
        this.number = number;
        status = isGiven ? CellStatus.GIVEN : CellStatus.TO_GUESS;
        paint();
    }
    
/*
based on the following the cell will paint itself 
according to its status
*/
    public void paint(){
        if(null != status)switch (status) {
            case GIVEN -> {
                super.setText(number + "");
                super.setEditable(false);
                super.setBackground(BG_GIVEN);
                super.setForeground(FG_GIVEN);
            }
            case TO_GUESS -> {
                super.setText("");
                super.setEditable(true);
                super.setBackground(BG_TO_GUESS);
                super.setForeground(FG_NOT_GIVEN);
            }
            case CORRECT -> super.setBackground(BG_CORRECT);
            case WRONG -> super.setBackground(BG_WRONG);
            default -> {
            }
        }
    }
}