
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;



/*
 * This Class is a alternative version of CreateAccountPanel. this panel will allow to create and add a transactions
 */

public class CreateTransactionsPanel extends CreateAccountPanel {
    //accountHolder >> transaction type
    //accountHolderAddress >> trnasaction ammount
    JTextArea accountNumberTextArea= new JTextArea();
    JButton alternativeSubmitButton = new JButton();
    String[] options = {"Withdraw", "Deposit"};
    JComboBox<String> selectType = new JComboBox<>(options);
    
    CreateTransactionsPanel(){
        this.setVisible(false);

        this.holderTextLabel.setText("transaction Type");
        this.registerInfoPanel.remove(this.accountHolderTextArea);
        this.registerInfoPanel.add(selectType,1);


        this.addressTextLabel.setText("transaction ammount");

        this.registerInfoPanel.remove(submitButton);
        this.registerInfoPanel.add(new JLabel("Account Number"));
        this.registerInfoPanel.add(accountNumberTextArea);
        this.registerInfoPanel.add(alternativeSubmitButton);

        alternativeSubmitButton.setText("Submit");
        alternativeSubmitButton.addActionListener(e -> submitInformations(selectType.getSelectedItem().toString(),
        accountHolderAddressTextArea.getText(),
        accountNumberTextArea.getText()));
    }
    
    void submitInformations(String type, String ammount,String accountNumber) {
        // TODO Auto-generated method stub
        boolean addressTextFieldBlank = !(accountHolderAddressTextArea.getText().isBlank());
        boolean accountNumberTexareaBlank = !(accountNumberTextArea.getText().isBlank());

        boolean accountNumberNumeric = Bank.manager.isNumeric(accountNumber);
        boolean ammountIsNumeric = Bank.manager.isNumeric(ammount);
        boolean ammountNegative = !(Bank.manager.isNegative(ammount));
      
        

        if(addressTextFieldBlank && accountNumberTexareaBlank && accountNumberNumeric && ammountIsNumeric && ammountNegative){
            int accountNumberAsInteger = Integer.parseInt(accountNumber);
            float ammountAsFloat = Float.parseFloat(ammount);

            //add transaction to account


            Bank.manager.updateAccountTransactions(type, ammountAsFloat, accountNumberAsInteger);
        }
        else 
        {
            HashSet<String> messages = new HashSet<>();
            
    
            if (!(addressTextFieldBlank)){
                messages.add("The transaction ammount text field is empty");
            }
            if (!(accountNumberTexareaBlank)){
                messages.add("The account Number text field is empty");
            }
            if(!(accountNumberNumeric)){
                messages.add("accountNumber is not numeric!");
            }
            if(!(ammountIsNumeric)){
                messages.add("ammount field is not numeric!");
            }
            if(!(ammountNegative)){
                messages.add("Ammount field cant be a negative number!");
            }
            
           

            JFrame error= new JFrame();
                JOptionPane.showMessageDialog(error,
                  messages.toArray(),
                  "Account Created",
                  JOptionPane.INFORMATION_MESSAGE);
        }
        
    }

  

    }

