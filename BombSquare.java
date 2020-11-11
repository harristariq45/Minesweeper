import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BombSquare extends GameSquare
{
    private GameBoard board; // Object reference to the GameBoard this square is part of.
    private boolean hasBomb; // True if this squre contains a bomb. False otherwise.
    private boolean clicked;
    private boolean flagged;
    private int nBombs=0;

    public static final int MINE_PROBABILITY = 10;

    public BombSquare(int x, int y, GameBoard board)
    
    {   super(x, y, "images/blank.png");
        this.clicked = false; 
        this.flagged = false;
        this.board = board;
        hasBomb = ((int) (Math.random() * MINE_PROBABILITY)) == 0;
    }    

    @Override
    public void leftClicked(){

        if ( hasBomb == true)
        {   
            this.clicked = true;
            setImage("images/bomb.png");
            // board.dispose();

        }

        else
        if  ( hasBomb == false && this.clicked == false )
        {   
            this.clicked = true;
            numOfBombs();
        }
        
    }

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

    public void numOfBombs()
    {
        int xCoordinate = getXLocation();
        int yCorrdinate = getYLocation();

        nBombs = 0;

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
        
        setImage("images/" + nBombs +".png");

        if(nBombs == 0)
        {
            // setImage("images/0.png");
            
            for(int x = xCoordinate-1 ; x<xCoordinate+2 ; x++)
            {
                for(int y = yCorrdinate-1 ; y<yCorrdinate+2 ; y++)
                {
                    BombSquare nSquare = (BombSquare) board.getSquareAt(x, y);
                    // if (nSquare.hasBomb)
                    // {
                    //     nBombs++;
                    //     System.out.println(" nBombs= "+ nBombs);
                    // }
                    
                    if( nSquare != this && nSquare != null){
                    // setImage("images/0.png");
                        nSquare.leftClicked();
 
                    }
                }
            } 

        }
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

    }
}



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