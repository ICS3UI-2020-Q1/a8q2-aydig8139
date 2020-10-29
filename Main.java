import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;
  
  JLabel firstNum;
  JLabel secondNum;
  JLabel resultNum;

  JTextField firstInput;
  JTextField secondInput;
  JTextField resultOutput;

  JButton addButton;
  JButton subButton;
  JButton mulButton;
  JButton divButton;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    //initialize the main JPanel
    mainPanel = new JPanel();

    //disable any layout helpers
    mainPanel.setLayout(null);

    //create the side labels
    firstNum = new JLabel("First number");
    secondNum = new JLabel("Second number");
    resultNum = new JLabel("Result");

    //layout the labels by setting the coordinate and size 
    firstNum.setBounds(30,20,130,20);
    secondNum.setBounds(30,50,130,20);
    resultNum.setBounds(30,80,130,20);

    //initialize the input text fields
    firstInput = new JTextField();
    secondInput = new JTextField();
    resultOutput = new JTextField();

    //set the location and size 
    firstInput.setBounds(170, 20, 100, 20);
    secondInput.setBounds(170, 50, 100, 20);
    resultOutput.setBounds(170, 80, 100, 20);

    //initialize the buttons
    addButton = new JButton("Add");
    subButton = new JButton("Sub");
    mulButton = new JButton("Mul");
    divButton = new JButton("Div");

    //set the size and location of the buttons
    addButton.setBounds(60, 120, 90, 20);
    subButton.setBounds(160, 120, 90, 20);
    mulButton.setBounds(60, 150, 90, 20);
    divButton.setBounds(160, 150, 90, 20);

    //add an action listener to the buttons
    addButton.addActionListener(this);
    subButton.addActionListener(this);
    mulButton.addActionListener(this);
    divButton.addActionListener(this);

    //set the action command on the buttons
    addButton.setActionCommand("Add");
    subButton.setActionCommand("Sub");
    mulButton.setActionCommand("Mul");
    divButton.setActionCommand("Div");

    //add the buttons to the panel
    mainPanel.add(addButton);
    mainPanel.add(subButton);
    mainPanel.add(mulButton);
    mainPanel.add(divButton);

    //add the text fields to the panel
    mainPanel.add(firstInput);
    mainPanel.add(secondInput);
    mainPanel.add(resultOutput);

    //add the labels to the main panel 
    mainPanel.add(firstNum);
    mainPanel.add(secondNum);
    mainPanel.add(resultNum);

    //add the panel to the window
    frame.add(mainPanel);

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    //get the text from each text box
    String firstText = firstInput.getText();
    String secondText = secondInput.getText();

    //change the string into an integer
    int numA = Integer.parseInt(firstText);
    int numB = Integer.parseInt(secondText);

    if(command.equals("Add")){
      int sum = numA + numB;
      resultOutput.setText("" + sum);
    }else if(command.equals("Sub")){
      int dif = numA - numB;
      resultOutput.setText("" + dif);
    }else if(command.equals("Mul")){
      int product = numA * numB;
      resultOutput.setText("" + product);
    }else if(command.equals("Div")){
      int quotient = numA / numB;
      resultOutput.setText("" + quotient);
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
