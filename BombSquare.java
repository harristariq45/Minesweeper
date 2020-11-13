import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BombSquare extends GameSquare
{
    private GameBoard board; // Object reference to the GameBoard this square is part of.
    private boolean hasBomb; // True if this square contains a bomb. False otherwise.
    private boolean clicked; // true if square has been clicked, false otherwise.
    private boolean flagged; // true if square has been flagged, false otherwise. 
    private int nBombs=0; //number of bombs adjacent to the choosen square will be stored in this int and starting value is 0 

    public static final int MINE_PROBABILITY = 10;

/**
 * This class codes the squares of the game
 * has the method for right and left click 
 * also contains recursion bit of the game.
 * @author Harris Bin Tariq
 */

    /**
     * 
     * @param x
     * @param y
     * @param board
     */

    public BombSquare(int x, int y, GameBoard board)
    {   
        super(x, y, "images/blank.png");
        this.clicked = false; //all the squares set to false because noone have been clicked
        this.flagged = false; //all the squares set to false because noone have been flagged
        this.board = board;
        hasBomb = ((int) (Math.random() * MINE_PROBABILITY)) == 0;
    }    

    @Override
    /**
     * LeftClick method is invoked when the user left clicks
     */
    public void leftClicked()
    {
        if ( hasBomb == true)
        {   
            this.clicked = true;
            setImage("images/bomb.png");
        }

        else
        if  ( hasBomb == false && this.clicked == false )
        {   
            this.clicked = true;
            numOfBombs();
        }
    }

    /**
     *RightClick method is invoked when the user right clicks
     */

    public void rightClicked()
    {   
        if ( this.clicked== false)
        {
            if ( this.flagged == false)
            {
                setImage("images/flag.png");
                this.flagged = true;
            }

            else
            {
                setImage("images/blank.png");
                this.flagged = false;
            }
        }
    }

    /**
     * this method is used to first calculate the number of bombs in the adjacent 8 squares
     * then this method also performs recursion to which expands into empty space
     * so if an empty square is clicked, the surrounding 8 squares are also revealed and 
     * if those are empty their surround squares are revealed until
     * a square is revealed with bombs in its surrounding square.
     * 
     */
    public void numOfBombs()
    {
        int xCoordinate = getXLocation();
        int yCorrdinate = getYLocation();

        nBombs = 0;
        //for loop to search the 8 adjacent squares
        for(int x = xCoordinate-1 ; x<xCoordinate+2 ; x++)
        {
            for(int y = yCorrdinate-1 ; y<yCorrdinate+2 ; y++)
            {
                BombSquare nSquare = (BombSquare) board.getSquareAt(x, y);
                if (nSquare != null && nSquare.hasBomb)
                {
                    nBombs++;
                }
            }
        } 

        // set  image according to the number of bombs found in neighbouring cells
        setImage("images/" + nBombs +".png"); 

        if(nBombs == 0)
        {

            //for loop for recursion
            for(int x = xCoordinate-1 ; x<xCoordinate+2 ; x++)
            {
                for(int y = yCorrdinate-1 ; y<yCorrdinate+2 ; y++)
                {
                    BombSquare nSquare = (BombSquare) board.getSquareAt(x, y);

                    if( nSquare != this && nSquare != null){

                        nSquare.leftClicked();

                    }
                }
            } 

        }

    }
}

// board.dispose();

// setImage("images/0.png");



// if (nSquare.hasBomb)
// {
//     nBombs++;
//     System.out.println(" nBombs= "+ nBombs);
// }


// setImage("images/0.png");

// if (nBombs == 1){
//     setImage("images/1.png");
// }
// if (nBombs == 2){
//     setImage("images/2.png");
// }
// if (nBombs == 3){
//     setImage("images/3.png");
// }
// if (nBombs == 4){
//     setImage("images/4.png");
// }
// if (nBombs == 5){
//     setImage("images/5.png");
// }
// if (nBombs == 6){
//     setImage("images/6.png");
// }
// if (nBombs == 7){
//     setImage("images/7.png");
// }
// if (nBombs == 8){
//     setImage("images/8.png");
// }
// if (nBombs == 9){
//     setImage("images/9.png");
// }


// System.out.println(" right click ");
// System.out.println(getXLocation() + "   right clicked   " + getYLocation());



// if ( this.clicked== false && hasBomb == true)
// {
//     System.out.println(" bomb found ");
//     setImage("images/flag.png");
//     // this.clicked = true;
//     System.out.println(" right click 1 ");
// }

// if ( hasBomb == false && this.clicked == false)
// {
//     System.out.println(" bomb not found ");
//     setImage("images/flag.png");
//     // this.clicked = true;
//     System.out.println(" right click 2");
// }


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
// for(int x = xCoordinate-1 ; x<xCoordinate+2 ; x++)
// { 
//     //   System.out.println(" 1 ");

//     for(int y = yCorrdinate-1 ; y<yCorrdinate+2 ; y++)
//     {
//         System.out.println(" 2 ");

//         BombSquare nSquare = (BombSquare) board.getSquareAt(x, y);

//         if (nSquare.hasBomb)
//         {
//             nBombs++;
//             System.out.println(" nBombs= "+ nBombs);
//         }

//     }
// } 
// if (nBombs == 2){
//     setImage("images/2.png");
// }
// else{
//     setImage("images/0.png");
// }

// this.flagged = true;
// setImage("images/flag.png");

// if (this.flagged== true)
// {           
//     setImage("images/blank.png");
//     this.clicked = false; 
//     System.out.println(" right click 2");
// }


// JOptionPane.showMessageDialog(null,
// "YOU LOST ",
// JOptionPane.PLAIN_MESSAGE);
// board.dispose();