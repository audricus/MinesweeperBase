
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

        addBombs(bombs);
        //addNums();
    }

    public MinesweeperBoard2(){
        this(10,10,10);
    }

    //adds bombs randomly arcoss the size of the board
    public void addBombs(int bombs){ //throws Exception{

        for(int i = bombs; i > 0; i--){
            int index = (int)(Math.random() * columns);
            int index2 = (int)(Math.random() * rows);
            if(board[index][index2].isBomb()){
                i++;
            }
            else{
                board[index][index2].setBomb();
            }

        }

    }

    //checks for bombs in adjacent cells add val to cells in contact
    public void addNums(){
        for (int i = 0; i< rows; i++){
            for (int j = 0; j<columns; j++){
                int index = 0;
                if (board[i][j].isBomb() == true){
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
    }

        public void printBoard(){
            for(int i = 0; i < (rows); i++){
                for(int j = 0; j < (columns); j++){
                    if(board[i][j].getValue()==-1){
                        System.out.print("X");
                    }
                    else{
                        System.out.print(board[i][j].getValue() + "");
                    }
                }
                System.out.println();
            }

        }

        public JPanel addCells(){
            JPanel panel = new JPanel(new GridLayout(rows,columns));
            for(int r = 0; r<rows; r++){
                for(int c = 0; c<columns; c++){
                    board[r][c]= new Cell();
                    panel.add(board[r][c].getButton());
                }
            }
            return panel;
        }
    }

