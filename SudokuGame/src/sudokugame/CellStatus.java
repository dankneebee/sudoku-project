package sudokugame;
/**
 I decided to create an enumeration to maintain a set 
 of constants, and in this case it used to 
 show the status of each cell in the grid, 
 making each cell status a constant
 */
public enum CellStatus {
    GIVEN,
    TO_GUESS,
    CORRECT,
    WRONG
}
/*
in order each constant represents the following:
the already generated number, the not yet guessed number, 
the correctly and the incorrectly guessed number
*
additionally, if none of the cells' status is TO_GUESS or WRONG 
that is when the puzzle will be considered solved
*/