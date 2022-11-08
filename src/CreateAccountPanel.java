import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.util.HashSet;
import java.awt.GridLayout;
import java.awt.GridBagLayout;

import java.awt.Color;
import java.awt.Dimension;

public class CreateAccountPanel extends JPanel{
    JPanel mainView = new JPanel();
    JPanel registerInfoPanel = new JPanel();
    JTextArea accountHolderTextArea = new JTextArea();
    JTextArea accountHolderAddressTextArea = new JTextArea();
    JTextArea accountPasswordTextArea = new JTextArea();
    JButton submitButton = new JButton("Submit");

    

    CreateAccountPanel(){
        this.setBackground(new Color(0,20,0));
        this.setVisible(false);
        this.setLayout(null);
        registerInfoPanelSetting();
        mainViewSettings();
        this.add(mainView);

        //this.add(registerInfoPanel); 
    }
    void mainViewSettings(){
        mainView.setBounds(100, 50, 890, 600);
        mainView.setLayout(new GridLayout(1,0));
        mainView.add(new JPanel());
        mainView.add(registerInfoPanel);
        mainView.add(new JPanel());
    }

    void registerInfoPanelSetting(){
        registerInfoPanel.setBounds(100, 50, 890, 600);
        registerInfoPanel.setLayout(new GridLayout(0,1));



        accountHolderTextArea.setPreferredSize(new Dimension(200,200));
        accountPasswordTextArea.setBounds(270,150,400,50);
        accountHolderAddressTextArea.setBounds(270,250,400,50);

        registerInfoPanel.add(new JLabel("Holder Name"));
        registerInfoPanel.add(accountHolderTextArea);
        registerInfoPanel.add(new JLabel("Password"));
        registerInfoPanel.add(accountPasswordTextArea);
        registerInfoPanel.add(new JLabel("Address"));
        registerInfoPanel.add(accountHolderAddressTextArea);
        registerInfoPanel.add(new JLabel());


        submitButton.addActionListener(e -> submitInformations(
            accountHolderTextArea.getText(),
            accountHolderAddressTextArea.getText(),
            accountPasswordTextArea.getText()));

        submitButton.setBounds(100,300,200,50);
        registerInfoPanel.add(submitButton);
        registerInfoPanel.add(new JLabel());
    }

    void submitInformations(String holder,String password,String address){
        boolean holderTextFieldBlank = !(accountHolderTextArea.getText().isBlank());
        boolean passwordTextFieldBlank = !(accountPasswordTextArea.getText().isBlank());
        boolean addressTextFieldBlank = !(accountHolderAddressTextArea.getText().isBlank());


        if(holderTextFieldBlank && passwordTextFieldBlank && addressTextFieldBlank){
            Bank.manager.createAccount(holder,password,address);
        }
        else {
            HashSet<String> messages = new HashSet<String>();
            if(!(holderTextFieldBlank)){
                messages.add("The Holder Text Field Is empty");
            }
            if (!(passwordTextFieldBlank)){
                messages.add("The password text field Is empty");
            }
            if (!(addressTextFieldBlank)){
                messages.add("The Address text field is empty");
            }
           

            JFrame error= new JFrame();
                JOptionPane.showMessageDialog(error,
                  messages.toArray(),
                  "Account Created",
                  JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
}
