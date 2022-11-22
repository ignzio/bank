
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


/*
 * this class is a Panel that allow to create an account. is shown by pressing the create account button in the main frame window
 */
public class CreateAccountPanel extends JPanel{
    final JPanel mainView = new JPanel();
    final JPanel registerInfoPanel = new JPanel();
    final JTextArea accountHolderTextArea = new JTextArea();
    final JTextArea accountHolderAddressTextArea = new JTextArea();
    final JButton submitButton = new JButton("Submit");

    final JLabel holderTextLabel = new JLabel();
    final JLabel addressTextLabel = new JLabel();
    

    public CreateAccountPanel(){
        this.setBackground(new Color(0,20,0));
        this.setVisible(false);
        this.setLayout(null);
        registerInfoPanelSetting();
        mainViewSettings();
        this.add(mainView);

        //this.add(registerInfoPanel); 
    }
    //settings for the mainView
    private void mainViewSettings(){
        mainView.setBounds(100, 50, 890, 600);
        mainView.setLayout(new GridLayout(1,0));
        mainView.add(new JPanel());
        mainView.add(registerInfoPanel);
        mainView.add(new JPanel());
    }
    //settings for the registerInfo panel
    private void registerInfoPanelSetting(){
        registerInfoPanel.setBounds(100, 50, 890, 600);
        registerInfoPanel.setLayout(new GridLayout(0,1));

        accountHolderTextArea.setPreferredSize(new Dimension(200,200));
        accountHolderAddressTextArea.setBounds(270,250,400,50);

        holderTextLabel.setText("AccountHolder");
        registerInfoPanel.add(holderTextLabel);
        registerInfoPanel.add(accountHolderTextArea);

        addressTextLabel.setText("Address");
        registerInfoPanel.add(addressTextLabel);
        registerInfoPanel.add(accountHolderAddressTextArea);
      


        submitButton.addActionListener(e -> submitInformations(
            accountHolderTextArea.getText(),
            accountHolderAddressTextArea.getText()));

        submitButton.setBounds(100,300,200,50);
        registerInfoPanel.add(submitButton);
   
    }
    //this method will submite the information to create an Account
    private void submitInformations(String holder,String address){
        boolean holderTextFieldBlank = !(accountHolderTextArea.getText().isBlank());
        boolean addressTextFieldBlank = !(accountHolderAddressTextArea.getText().isBlank());


        if(holderTextFieldBlank && addressTextFieldBlank){
            Bank.manager.createAccount(holder,address,true);
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
