import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class AccountsPanel extends JPanel{
    JTextField searchBar = new JTextField();
    JPanel mainView = new JPanel();
    JPanel listBoxPanel = new JPanel();
    JButton showListAccountButton = new JButton("Show Accounts");
    JButton showTransactionsListButton = new JButton("Show Transactions");
    JScrollPane listBoxScrollPane = new JScrollPane(listBoxPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    String[] actions = { "search", "delete", "update"};
    JComboBox actionsComboBox = new JComboBox<>(actions);
    AbstractAction comboBoxActions = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            System.out.println(actionsComboBox.getSelectedItem());
        }
        
    };

    AccountsPanel(){
        this.setBackground(new Color(20,0,0));
        this.setVisible(false);
        this.setLayout(null);


        

        searchBar.setBounds(30,24,400,40);

        actionsComboBox.setBounds(450,20,200,50);
        actionsComboBox.addActionListener(comboBoxActions);
  

        mainView.setBounds(30,80,1000,580);
        mainView.setLayout(null);

        showListAccountButton.addActionListener(e -> showAccountsList());
        showListAccountButton.setBounds(900,20,150,50);
   
        this.add(searchBar);
        this.add(actionsComboBox);
        this.add(mainView);
        this.add(showListAccountButton);
        

        listBoxPanel.setLayout(new BoxLayout(listBoxPanel, BoxLayout.Y_AXIS));
        listBoxPanel.setBorder(LineBorder.createBlackLineBorder());
        listBoxPanel.setBackground(new Color(50,0,20));
        listBoxPanel.setBounds(5,10,400,560);


        listBoxScrollPane.setBackground(new Color(50,0,20));
        listBoxScrollPane.setBounds(5,10,400,560);
      
        mainView.add(listBoxScrollPane);
    }
    void showAccountsList(){
        listBoxPanel.removeAll();
        for(Accounts a : Bank.manager.accounts){  
            JLabel label = new JLabel("Account Number: " + a.accountNumber  + " Account Holder"  + a.holderName);
            label.setForeground(new Color(0,80,10));
            label.setFont(new Font("Serif", Font.PLAIN, 20));
            listBoxPanel.add(label);
            System.out.println();
        }
        listBoxScrollPane.validate();
        Bank.manager.showAllAccountDetails();
    }
    
   
}
