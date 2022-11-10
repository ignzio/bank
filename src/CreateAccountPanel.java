
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;




import java.util.HashSet;
import java.awt.GridLayout;


import java.awt.Color;
import java.awt.Dimension;

public class CreateAccountPanel extends JPanel{
    JPanel mainView = new JPanel();
    JPanel registerInfoPanel = new JPanel();
    JTextArea accountHolderTextArea = new JTextArea();
    JTextArea accountHolderAddressTextArea = new JTextArea();
    JButton submitButton = new JButton("Submit");

    

    public CreateAccountPanel(){
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
        accountHolderAddressTextArea.setBounds(270,250,400,50);

        registerInfoPanel.add(new JLabel("Holder Name"));
        registerInfoPanel.add(accountHolderTextArea);
        registerInfoPanel.add(new JLabel("Address"));
        registerInfoPanel.add(accountHolderAddressTextArea);
        registerInfoPanel.add(new JLabel());


        submitButton.addActionListener(e -> submitInformations(
            accountHolderTextArea.getText(),
            accountHolderAddressTextArea.getText()));

        submitButton.setBounds(100,300,200,50);
        registerInfoPanel.add(submitButton);
        registerInfoPanel.add(new JLabel());
    }

    void submitInformations(String holder,String address){
        boolean holderTextFieldBlank = !(accountHolderTextArea.getText().isBlank());
        boolean addressTextFieldBlank = !(accountHolderAddressTextArea.getText().isBlank());


        if(holderTextFieldBlank && addressTextFieldBlank){
            Bank.manager.createAccount(holder,address);
        }
        else {
            HashSet<String> messages = new HashSet<String>();
            if(!(holderTextFieldBlank)){
                messages.add("The Holder Text Field Is empty");
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
