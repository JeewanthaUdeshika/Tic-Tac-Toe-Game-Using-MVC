/*
Event Handling and MVC Approch

This is GameView class of Tic Tac Toe game. This controlls all the gui parts of the game

Author  : Jeewantha Udeshika Ariyawansha
Date    : 19-02-2022
*/

import java.awt.*;
import javax.swing.*;

public class GameView extends JFrame {

    private JFrame frame = new JFrame();        // The main container frame
    private JPanel txtPannel = new JPanel();    // Pannel to include instructions
    private JPanel btnPannel = new JPanel();    // Pannel to include buttons
    private JTextField txtField;                // Text field to display instructions
    private JButton[] btnset = new JButton[9];  // Buttons array
    private Font fieldFont1 = new Font("SansSerif", Font.BOLD, 25);     // Font for text field
    private Font buttonFont1 = new Font("SansSerif", Font.BOLD, 70);    // Font for buttons
    private Object[] option = {"Play Again", "Exit"};                   // Options for pop up window
    private Model gModel = new Model(this);                             // Initializing the Model class in this class
    private Controller gController = new Controller(gModel, this);      // Initializing the Model class in this class 
    
    public GameView(){
        // Make the container object by retrive the content pane

        // Set the layout in outer frame
        frame.setLayout(new BorderLayout());
        frame.setTitle("Tic Tac Toe");
        frame.setSize(500, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Making the text field for instructions
        txtField = new JTextField("1st Player's Chance", 10);
        txtField.setEditable(false);
        txtField.setText("1st Player's Chance");
        txtField.setHorizontalAlignment(JTextField.CENTER);
        txtField.setFont(fieldFont1);

        txtPannel.setLayout(new BorderLayout());
        txtPannel.add(txtField);

        // Make Panel for store buttons
        btnPannel.setLayout(new GridLayout(3,3));

        // Initialize button set
        for(int i=0; i<9; i++){
            btnset[i] = new JButton();
            btnset[i].setFont(buttonFont1);             // Set button text font
            btnPannel.add(btnset[i]);             // Add button to the pannel
            btnset[i].addActionListener(gController);    // Add the listner
        }

        frame.add(btnPannel);
        frame.add(txtPannel, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    // Method for get button sets from view class
    public JButton[] getbtnset(){
        return this.btnset;
    }

    // Method for get text field from view class
    public JTextField getTextField(){
        return this.txtField;
    }

    // Method for close the window
    public void closeFrame(){
        this.frame.dispose();
    }

    // Method for show pop up window with result
    public int showMassage(String massage){
        int selection = JOptionPane.showOptionDialog(   frame,         // Parent frame
                                                            massage, // Massage
                                                            "Game Finished",    // Title
                                                            JOptionPane.OK_CANCEL_OPTION,   // Option Type
                                                            JOptionPane.INFORMATION_MESSAGE, null,  // Massage Type
                                                            option,
                                                            option[0]);
        
        return selection;
    }

}