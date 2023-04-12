package sudokugame;
/*
FileName: Puzzle.java
Author: Daniela Georgieva
Date: 23/04/2022
 */

/*
in this class i make the already solved grid,
declare the grid and its size
and make a boolean that checks if a number is
given
*/
public class Puzzle {
    int[][] numbers = new int[GameBoardPanel.GRID_SIZE][GameBoardPanel.GRID_SIZE];
    boolean[][] isGiven = new boolean[GameBoardPanel.GRID_SIZE][GameBoardPanel.GRID_SIZE];
    
    public Puzzle(){
        super();
    }

/*
in this method i have generated an already solved
sudoku puzzle and further down i have randomly chosen some
cells that will be empty and for the user to solve
*
currently only a few cells are empty for the demo,
in a future further work on this project i have put the base
for difficulty change - the harder the difficulty
the more cells are empty and to be solved
*/
public void newPuzzle(int cellsToGuess){
int[][] hardcodedNumbers = 
{{1, 2, 5, 3, 7, 8, 6, 4, 9},
{9, 4, 7, 2, 5, 6, 1, 3, 8},
{3, 6, 8, 1, 9, 4, 5, 7, 2},
{5, 1, 6, 7, 3, 2, 8, 9, 4},
{4, 9 ,2, 6, 8, 1, 7, 5, 3},
{7, 8, 3, 9, 4, 5, 2, 1, 6},
{8, 3, 9, 5, 6, 7, 4, 2, 1},
{6, 5, 1, 4, 2, 3, 9, 8, 7},
{2, 7, 4, 8, 1, 9, 3, 6 ,5}};

for(int row = 0; row < GameBoardPanel.GRID_SIZE; ++row){
    for(int col = 0; col < GameBoardPanel.GRID_SIZE; ++col){
    numbers[row][col] = hardcodedNumbers[row][col];
}
}

boolean[][] hardcodedIsGiven = 
{{true, false, true, false, true, true, true, true, false},
{true, true, true, false, true, true, true, true, true},
{true, false, true, true, true, true, true, true, true},
{false, true, true, true, true, true, true, false, true},
{true, true, true, true, true, true, true, true, true},
{true, true, true, true, true, true, true, true, true},
{true, true, false, true, true, true, true, true, true},
{true, true, true, true, false, true, true, true, true},
{true, false, true, true, true, true, true, true, true}};
        
for(int row = 0; row < GameBoardPanel.GRID_SIZE; ++row){
    for(int col = 0; col < GameBoardPanel.GRID_SIZE; ++col){
    isGiven[row][col] = hardcodedIsGiven[row][col];
}
}
}
}
