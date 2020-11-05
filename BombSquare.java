import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BombSquare extends GameSquare
{
    private GameBoard board; // Object reference to the GameBoard this square is part of.
    private boolean hasBomb; // True if this squre contains a bomb. False otherwise.

    public static final int MINE_PROBABILITY = 10;

    public BombSquare(int x, int y, GameBoard board)
    
    {   super(x, y, "images/blank.png");

        this.board = board;
        hasBomb = ((int) (Math.random() * MINE_PROBABILITY)) == 0;



    }    

    @Override
    public void leftClicked(){

        System.out.println(" left click ");
        System.out.println(getXLocation() + "  left clicked   " + getYLocation());

        if ( hasBomb == true)
        {
            System.out.println(" bomb found ");
            setImage("images/bomb.png");
            JOptionPane.showMessageDialog(null,
            "YOU LOST ",
            JOptionPane.PLAIN_MESSAGE);
            board.dispose();
        }

        if ( hasBomb == false)
        {
            System.out.println(" bomb not found ");
            setImage("images/0.png");
        }


    }

    public void rightClicked(){

        System.out.println(" right click ");
        System.out.println(getXLocation() + "   right clicked   " + getYLocation());

        setImage("images/flag.png");

        if ( hasBomb == true)
        {
            System.out.println(" bomb found ");
        }

        if ( hasBomb == false)
        {
            System.out.println(" bomb not found ");
        }



    }


    // System.out.println(getXLocation() + " before" + getYLocation());
    // System.out.println(getXLocation() + " after " + getYLocation());
    // if (GameBoard.rightClicked()){
    //     System.out.println(getXLocation() + " right clicked" + getYLocation());
    // }

    // @Override

    // public void mouseClicked(MouseEvent e){
    //     system.out.println(e.getXLocation() + "," + e.getYLocation());

    // }

    // System.out.println(leftClicked() + "," + leftClicked());

    // if (leftClicked()){

    // }

//     @Override
//     public int getXLocation() {
//         System.out.println(super.getXLocation() + "," );
//         return super.getXLocation();
//     }
}
