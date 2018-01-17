
/**
 * Write a description of class Cell here.
 * 
 * @author Wiebe 
 * @version 10.11.16
 * build 10x10 board
 * make print board method
 * make the add bombs method
 * add Nums meth
 * make look prety
 * AUDRIC PHAGNASAY
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cell implements ActionListener{
    //Variables you need to work with
    private int value;

    //Variables you don't need to worry about or care about.
    private JButton button;
    /**
     * This constructor is complete and does not need modification
     */
    public Cell(){
        button = new JButton();
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(20,20));
        button.setMargin(new Insets(0,0,0,0));
        value = 0;
    }

    /** This Method tells me if the cell is a bomb.
     * 
     * @return True if it is a bomb, otherwse false.
     */
    boolean isBomb(){
        if(value == -1){
            return true;
        }
        return false;
    }

    public void setBomb(){
        value = -1;
    }

    public int getValue() {
        return value;
    }

    public void addValue() {
        value++;
    }

    //Additional Methods may be required. Please make them yourself.
    //The following methods are used for the User Inferface. These methods are fully functional and do not need to be modified.
    public void checkCell(){
        button.setEnabled(false);
        displayValue();
    }

    public void displayValue(){
        if(this.isBomb()){
            button.setText("\u2600");
            button.setBackground(Color.RED);
        }else if(value!=0){
            button.setText(String.valueOf(value));
        }
    }

    public JButton getButton() {
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkCell();
    }
}

