/*
CO225 - Software Construction
Lab06 - Event Handling and MVC Approch

This is Model class of Tic Tac Toe game.

Author : Ariyawansha P.H.J.U. (E/18/028)
*/


import javax.swing.*;

public class Model {
    private GameView gView;
    private JButton[] btnset;
    private JTextField txtField;
    private boolean p1Win = true,
                    p2Win = true;
    private int count=0;
    private String massage;

    // constructor for Model class
    public Model(GameView gView){
        this.gView = gView;
    }

    // Method to update the counter by one
    public void updateCounter(){
        ++this.count;
    }

    // Method to check the current state and any player is won or game is draw
    public void winPredictor(){
        /* 
        Winning Posibilities
        ** Vertical =   {0,3,6}
                        {1,4,7}
                        {2,5,8}

        ** Horizontal = {0,1,2}
                        {3,4,5}
                        {6,7,8}

        ** Dioganlly =  {0,4,8}
                        {2,4,6}
        */

        btnset = gView.getbtnset();
        txtField = gView.getTextField();

        // Check player 1 is won
            // Check vertical winning possibilties
        if (((btnset[0].getText() == "1") && (btnset[3].getText() == "1") && (btnset[6].getText() == "1")) ||
            ((btnset[1].getText() == "1") && (btnset[4].getText() == "1") && (btnset[7].getText() == "1")) ||
            ((btnset[2].getText() == "1") && (btnset[5].getText() == "1") && (btnset[8].getText() == "1")) ||
            // Check Horizontal winning possibilties
            ((btnset[0].getText() == "1") && (btnset[1].getText() == "1") && (btnset[2].getText() == "1")) ||
            ((btnset[3].getText() == "1") && (btnset[4].getText() == "1") && (btnset[5].getText() == "1")) ||
            ((btnset[6].getText() == "1") && (btnset[7].getText() == "1") && (btnset[8].getText() == "1")) ||
            // Check Diagonaal winning possibilties
            ((btnset[0].getText() == "1") && (btnset[4].getText() == "1") && (btnset[8].getText() == "1")) ||
            ((btnset[2].getText() == "1") && (btnset[4].getText() == "1") && (btnset[6].getText() == "1"))){
                p1Win = true;
                p2Win = false;
            }
        
        // Check player 1 is won
                // Check vertical winning possibilties
        else if(((btnset[0].getText() == "2") && (btnset[3].getText() == "2") && (btnset[6].getText() == "2")) ||
                ((btnset[1].getText() == "2") && (btnset[4].getText() == "2") && (btnset[7].getText() == "2")) ||
                ((btnset[2].getText() == "2") && (btnset[5].getText() == "2") && (btnset[8].getText() == "2")) ||
                // Check Horizontal winning possibilties
                ((btnset[0].getText() == "2") && (btnset[1].getText() == "2") && (btnset[2].getText() == "2")) ||
                ((btnset[3].getText() == "2") && (btnset[4].getText() == "2") && (btnset[5].getText() == "2")) ||
                ((btnset[6].getText() == "2") && (btnset[7].getText() == "2") && (btnset[8].getText() == "2")) ||
                // Check Diagonaal winning possibilties
                ((btnset[0].getText() == "2") && (btnset[4].getText() == "2") && (btnset[8].getText() == "2")) ||
                ((btnset[2].getText() == "2") && (btnset[4].getText() == "2") && (btnset[6].getText() == "2"))){
                    p1Win = false;
                    p2Win = true;
            }
        
        // Check the game is draw
        else{
            if(count == 9){
                p1Win = false;
                p2Win = false;
            }
        }

        // Make game finished
        // Check player 1 is won
        if (p1Win && !p2Win){
            count = 0;          // If any player won, set count to zero
            massage = "Player 1 won";
            txtField.setText(massage);
            int selection = gView.showMassage(massage);
            
            if(selection==0){   // If user choosed to Restart open a new instance
                gView.closeFrame();
                new GameView();
            }
            else{
                gView.closeFrame();
            }

        }
        
        // check player 2 is won
        else if (!p1Win && p2Win){
            count = 0;
            massage = "Player 2 won";
            txtField.setText(massage);
            int selection = gView.showMassage(massage);
            
            if(selection==0){   // If user choosed to Restart open a new instance
                gView.closeFrame();
                new GameView();
            }
            else{
                gView.closeFrame();
            }
        }

        // check the game is draw
        else if (!p1Win && !p2Win){
            count = 0;
            massage = "Game Draw";
            txtField.setText(massage);
            int selection = gView.showMassage(massage);
            
            if(selection==0){   // If user choosed to Restart open a new instance
                gView.closeFrame(); // Close the window and exit
                new GameView();
            }
            else{
                gView.closeFrame(); // Close the window and exit
            }
        }
    }
  
}
