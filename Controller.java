/*
CO225 - Software Construction
Lab06 - Event Handling and MVC Approch

This is Controller class of Tic Tac Toe game

Author : Jeewantha Udeshika Ariyawansha (E/18/028)
*/


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Controller implements ActionListener{
    
    private JButton[] btnset;
    private GameView gView;
    private Model gModel;
    private JTextField txtField;
    private boolean player1Chance = true;   // ! st chance is to 1st player

    // Contructor of controller
    public Controller(Model gModel, GameView gView){
        this.gView = gView;
        this.gModel = gModel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        btnset = gView.getbtnset();
        txtField = gView.getTextField();
        

        for (int i=0; i<9; i++){
            // Checking which button is clicked
            if (e.getSource() == btnset[i]){
                // Check 1 st player is clicked the button
                if (player1Chance){
                    btnset[i].setEnabled(false);  // Lock the button
                    btnset[i].setForeground(new Color(255, 0, 0));
                    btnset[i].setText("1");       // Setting the button text to 1
                    txtField.setText("2nd Player's Chance");    // Change text to next player

                    player1Chance = false; // Set chance to 2nd Player
                    gModel.updateCounter();              // Count the click

                    // Checking the game status
                    gModel.winPredictor();
                }

                else{   // if second player clicked the button
                    btnset[i].setEnabled(false);      // Lock the button
                    btnset[i].setForeground(new Color(255, 0, 0));
                    btnset[i].setText("2");           // Setting the button text to 1
                    txtField.setText("1st player's Chance");   // Change text to next player
                    
                    player1Chance = true;   // Set chance to 1st player
                    gModel.updateCounter();              // Count the click
                    
                     // Checking the game status
                     gModel.winPredictor();
                }
            }
        }
    }
}
