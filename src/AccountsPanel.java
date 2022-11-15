
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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;



public class AccountsPanel extends JPanel{
    JTextField searchBar = new JTextField();
    JPanel mainView = new JPanel();
    JPanel listBoxPanel = new JPanel();
    JPanel informationPanel = new JPanel();
    JButton showListAccountButton = new JButton("Show Accounts");
    JButton showTransactionsListButton = new JButton("Show Transactions");
    JButton actionButton = new JButton("Perform Action");
    JScrollPane listBoxScrollPane = new JScrollPane(listBoxPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    String[] actions = { "search Account", "delete Account","display Transactions"};
    JComboBox actionComboBox = new JComboBox<>(actions);

    Border border = BorderFactory.createLineBorder(Color.orange,3);



    AbstractAction comboBoxActions = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            boolean searchBarIsDigit = Bank.manager.isNumeric(searchBar.getText());
           

            if(actionComboBox.getSelectedItem() == actionComboBox.getItemAt(0) && searchBarIsDigit){
                 //search account
                System.out.println(actionComboBox.getSelectedItem());

                Accounts a = Bank.manager.getAccountFromArray(Integer.parseInt(searchBar.getText()));
                
               
                if(a != null){
                    Bank.manager.showAccountDetails(a);
                    showAccountDetails(a);
                }else{
                    System.out.println("No Account Found");
                }

            }
            if(actionComboBox.getSelectedItem() == actionComboBox.getItemAt(1) && searchBarIsDigit){
                System.out.println(actionComboBox.getSelectedItem());


                Bank.manager.deleteAccount(Integer.parseInt(searchBar.getText()));
                //delete Account
            }
            if(actionComboBox.getSelectedItem() == actionComboBox.getItemAt(2)){
                System.out.println(actionComboBox.getSelectedItem());
                //display Transactions
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


    private void informationPanelSettings() {
        informationPanel.setBounds(420,10,560,560);
       
        informationPanel.setLayout(new GridLayout(4,2));
        informationPanel.setVisible(false);
        informationPanel.setForeground(new Color(50,20,10));
        
    }
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


    void showAccountsList(){
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


    //all settings below
    private void listboxScrollPaneSettings() {
        listBoxScrollPane.setBackground(new Color(50,0,20));
        listBoxScrollPane.setBounds(5,10,400,560);
    }


    private void listBoxPanelSettings() {
        listBoxPanel.setLayout(new BoxLayout(listBoxPanel, BoxLayout.Y_AXIS));
        listBoxPanel.setBorder(LineBorder.createBlackLineBorder());
        listBoxPanel.setBackground(new Color(50,0,20));
        listBoxPanel.setBounds(5,10,400,560);
    }


    private void showListAccountButtonSettings() {
        showListAccountButton.addActionListener(e -> showAccountsList());
        showListAccountButton.setBounds(750,20,150,50);
    }


    private void settings(){
        this.setBackground(new Color(20,0,0));
        this.setVisible(false);
        this.setLayout(null);
    }
        
    private void searchBarSettings(){
        searchBar.setBounds(30,24,290,40);
    }

    private void actionsComboBoxSettings(){
        actionComboBox.setBounds(520,20,200,50); 
    }

    private void mainViewSettings() {
        mainView.setBounds(30,80,1000,580);
        mainView.setLayout(null);
    }

    private void actionButtonSettings() {
        actionButton.setBounds(350,20,130,50);
        actionButton.addActionListener(comboBoxActions);
    }
       
}
