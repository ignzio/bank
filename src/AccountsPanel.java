

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.GridLayout;


/*
 * this class is a panel that allow to perform actions To:
 * Search and display account informations
 * Delete accounts
 * Search and Display all the transactions of an Account
 * Show all the existing account in a listbox
 * 
 */
public class AccountsPanel extends JPanel{
    JTextField searchBar = new JTextField(); 
    JPanel mainView = new JPanel(); // main view of the panel
    JPanel listBoxPanel = new JPanel(); // listbox where the accounts are shown
    JPanel informationPanel = new JPanel();
    JButton showListAccountButton = new JButton("Show Accounts");
    JButton showTransactionsListButton = new JButton("Show Transactions");
    JButton actionButton = new JButton("Perform Action");
    JScrollPane listBoxScrollPane = new JScrollPane(listBoxPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    String[] actions = { "search Account", "delete Account","display Transactions"};
    JComboBox<String> actionComboBox = new JComboBox<>(actions);
    Border border = BorderFactory.createLineBorder(Color.orange,3);


    /*
     * this abstract action is the actionListener for the jcombobox and actionbutton. it will 
     * Search and display account informations
 * Delete accounts
 * Search and Display all the transactions of an Account
     */
    AbstractAction comboBoxActions = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {

          
            boolean searchBarIsDigit = Bank.manager.isNumeric(searchBar.getText()); // t
           if(!searchBarIsDigit){
            Bank.manager.popUpGuiMessage("ERROR_NODIGIT");
           }

            if(actionComboBox.getSelectedItem() == actionComboBox.getItemAt(0) && searchBarIsDigit){
                 //search account
                System.out.println(actionComboBox.getSelectedItem());

                Accounts a = Bank.manager.getAccountFromArray(Integer.parseInt(searchBar.getText()));
                if(a != null){
                    Bank.manager.showAccountDetails(a);
                    showAccountDetails(a);
                }else{
                    Bank.manager.popUpGuiMessage("ERROR_NOFOUND");
        
                }

            }
            if(actionComboBox.getSelectedItem() == actionComboBox.getItemAt(1) && searchBarIsDigit){
                System.out.println(actionComboBox.getSelectedItem());


                Bank.manager.deleteAccount(Integer.parseInt(searchBar.getText()));
            
                //delete Account
            }
            if(actionComboBox.getSelectedItem() == actionComboBox.getItemAt(2) && searchBarIsDigit){
                System.out.println(actionComboBox.getSelectedItem());
                //display Transactions
                Accounts a = Bank.manager.getAccountFromArray(Integer.parseInt(searchBar.getText()));
                if(a != null){
                    a.displayTransactions();
                    showTransactions(a);
                }
                else{
                    Bank.manager.popUpGuiMessage("ERROR_NOFOUND");
                }
            }
        }
    };

    public AccountsPanel(){
        settings();
        searchBarSettings();
        actionsComboBoxSettings();
        actionButtonSettings();
        mainViewSettings();
        showListAccountButtonSettings();
        listBoxPanelSettings();
        listboxScrollPaneSettings();
        informationPanelSettings();
       
   
        this.add(searchBar);
        this.add(actionComboBox);
        this.add(actionButton,2);
        this.add(mainView);
        this.add(showListAccountButton);
        mainView.add(informationPanel);
      
        mainView.add(listBoxScrollPane);
    }

    // Settings for the informationPanel is located on the right of the mainview
    private void informationPanelSettings() {
        informationPanel.setBounds(420,10,560,560);
       
        informationPanel.setLayout(new GridLayout(4,2));
        informationPanel.setVisible(false);
        informationPanel.setForeground(new Color(50,20,10));
        
    }
    /*
     * this method will show the account details in the information panel
     */
    private void showAccountDetails(Accounts a){
        informationPanel.setVisible(true);
        informationPanel.removeAll();
        informationPanel.revalidate();
        informationPanel.repaint();

        informationPanel.add(new JLabel("Account Number"));
        informationPanel.add(new JLabel(Integer.toString(a.getAccountNumber())));
        informationPanel.add(new JLabel("Account Holder Name"));
        informationPanel.add(new JLabel(a.getHolderName()));
        informationPanel.add(new JLabel("Opening Date And Time"));
        informationPanel.add(new JLabel(a.getOpeningDate()));
        informationPanel.add(new JLabel("Deposit"));
        informationPanel.add(new JLabel(Float.toString(a.getHolderBalance())));

    }

    //this method will show a trasaction of an account in the information panel
    private void showTransactions(Accounts a){
        informationPanel.setVisible(true);
        informationPanel.removeAll();
        informationPanel.revalidate();
        informationPanel.repaint();
        ArrayList<Transaction> tempTransactions = a.getTransaction();

        for(Transaction t : tempTransactions){
            JPanel transaction = new TransactionPanel(t.getType(), t.getAmmount(), t.getDate());
            informationPanel.add(transaction);
        }
    }

    //this method will show all the accounts of the accounts arraylist in the listbox
    private void showAccountsList(){
        listBoxPanel.removeAll();
        listBoxPanel.revalidate();
        listBoxPanel.repaint();
        for(Accounts a : Bank.manager.accounts){  
            JLabel label = new JLabel("<html>Account Number: " + a.getAccountNumber()  + "<br/>Account Holder: "  + a.getHolderName());
            label.setForeground(new Color(255, 191, 0));
            label.setFont(new Font("Serif", Font.PLAIN, 20));
            label.setBorder(border);
            
            listBoxPanel.add(label);
            System.out.println();
        }
    
        Bank.manager.showAllAccountDetails();
    }


    //settings for the listboxScrollPanel
    private void listboxScrollPaneSettings() {
        listBoxScrollPane.setBackground(new Color(50,0,20));
        listBoxScrollPane.setBounds(5,10,400,560);
    }


    //settings for the listboxPanel
    private void listBoxPanelSettings() {
        listBoxPanel.setLayout(new BoxLayout(listBoxPanel, BoxLayout.Y_AXIS));
        listBoxPanel.setBorder(LineBorder.createBlackLineBorder());
        listBoxPanel.setBackground(new Color(50,0,20));
        listBoxPanel.setBounds(5,10,400,560);
    }

    //settings for the showListAccountButton
    private void showListAccountButtonSettings() {
        showListAccountButton.addActionListener(e -> showAccountsList());
        showListAccountButton.setBounds(750,20,150,50);
    }

    //settings of the class
    private void settings(){
        this.setBackground(new Color(20,0,0));
        this.setVisible(false);
        this.setLayout(null);
    }
    
    //settings for the searchbar
    private void searchBarSettings(){
        searchBar.setBounds(30,24,290,40);
    }

    //settings for the actionscombobox
    private void actionsComboBoxSettings(){
        actionComboBox.setBounds(520,20,200,50); 
    }

    //settings for the mainView
    private void mainViewSettings() {
        mainView.setBounds(30,80,1000,580);
        mainView.setLayout(null);
    }

    //settings for the actionbutton
    private void actionButtonSettings() {
        actionButton.setBounds(350,20,130,50);
        actionButton.addActionListener(comboBoxActions);
    }
       
}
