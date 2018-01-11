
/**
 * Write a description of class Minesweeper here.
 * 
 * @author (Audricus Phagnasay) 
 * @version (a version number or a date)
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MinesweeperBoard2{
    Cell[][] board;
    int rows;
    int columns;
    public MinesweeperBoard2(int rows, int columns,int bombs){
        //Put the constructor here.
        this.rows = rows;
        this.columns = columns;
        board = new Cell [rows][columns];
        //These pieces are for the GUI.
        JFrame frame = new JFrame();
        frame.add(addCells());

        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //addBombs(bombs);
        //addNums();
    }

    public MinesweeperBoard2(){
        this(10,10,10);
    }

    //adds bombs randomly arcoss the siz of the board
    public void addBombs(int bombs){ //throws Exception{
        for(int i = bombs; i > 0; i--){
            for(int j = bombs; j > 0; j--){
                int index = (int)(Math.random() * (rows*columns));
                if(board[index].isBomb()){
                    i++;
                }
                else{
                    board[index].setBomb();
                }
            }
        }
    }

    /*
    //checks for bombs in adjacent cells add val to cells in contact
    public void addNums(){
    for (int i = 0; i< rows*columns; i++){
    int index = 0;
    if (board[i].isBomb() == true){
    //Top
    index = i - columns;
    if (index > 0 && board [index].getValue() != -1 && index % rows == i % rows){
    board[index].addValue();
    }
    //Bottom
    index = i + columns;
    if (index <=(rows * columns - 1) && board [index].getValue() != -1 && index % rows == i % rows){
    board[index].addValue();
    }
    //Right
    index = i + 1;
    if (index <=(rows * columns -1) && board [index].getValue() != -1 && i % rows !=0){
    board[index].addValue();
    }
    //Left
    index = i -1;
    if (index > 0 && board [index].getValue() != -1 && i % rows !=0){
    board[index].addValue();
    //Top Left
    index = i - columns - 1;
    if (index > 0 && board [index].getValue() != -1 && i % rows !=0){
    board[index].addValue();
    }
    //Top Right
    index = i - columns + 1;
    if (index > 0 && board [index].getValue() != -1 && index % rows != rows -1){
    board[index].addValue();
    }
    //Bottom Left
    index = i + columns - 1;
    if (index <= (rows * columns -1) && board [index].getValue() != -1 && i % rows != rows -1){
    board[index].addValue();
    }
    //Bottom Right
    index = i + columns + 1;
    if (index <= (rows * columns -1) && board [index].getValue() != -1 && i % rows != 0){
    board[index].addValue();
    }

    }
    }
    }
    }

    public void printBoard(){
    int i = 0;
    for(int y = 0; y < rows; y++){
    for(int x = 0; x < columns; x++){
    if(board[i].isBomb()){
    System.out.print("X"+" ");
    i++;
    }
    else{
    System.out.print(board[i].getValue()+ " ");
    i++;
    }
    }
    System.out.println();
    }

    }
     */
    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int r = 0; r<rows; r++){
            for(int c = 0; c<columns; c++){
                board[c][r]= new Cell();
                panel.add(board[c][r].getButton());
            }
        }
        return panel;
    }
}

