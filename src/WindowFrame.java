import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

public class WindowFrame extends JFrame {
    final JPanel lateralPanel = new JPanel();
    final JPanel centerPanel =new JPanel();
    final JPanel homePanel = new HomePanel();
    final JPanel createAccountPanel= new CreateAccountPanel();
    final JPanel accountsPanel = new AccountsPanel();
    final JPanel transactionsPanel = new TransactionsPanel();
    

    final JButton homeButton = new JButton("Home");
    final JButton createAccountButton = new JButton("Create Account");
    final JButton accountsButton = new JButton("Accounts");
    final JButton transactionsButton = new JButton("Transactions");



    WindowFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(1270,720));
        this.setResizable(false);
        lateralPanelSettings();
        centerPanelSettings();
        homeButton.addActionListener(e -> switchCenterPanel(homePanel));
        createAccountButton.addActionListener(e -> switchCenterPanel(createAccountPanel));
        accountsButton.addActionListener(e -> switchCenterPanel(accountsPanel));
        transactionsButton.addActionListener(e -> switchCenterPanel(transactionsPanel));
        this.add(lateralPanel,BorderLayout.WEST);
        this.add(centerPanel,BorderLayout.CENTER);
    }
    //settings for the lateral pannel positioned on the left of the frame
    private void lateralPanelSettings(){
        lateralPanel.setPreferredSize(new Dimension(200,100));
        lateralPanel.setBackground(new Color(0,0,0));
        lateralPanel.setLayout(new GridLayout(0,1));
        lateralPanel.add(homeButton);
        lateralPanel.add(createAccountButton);
        lateralPanel.add(accountsButton);
        lateralPanel.add(transactionsButton);
    }
    //settings for the center pannel positioned on the center of the frame
    private void centerPanelSettings(){
        centerPanel.setPreferredSize(new Dimension(500,500));
        centerPanel.setBackground(new Color(50,50,50));
        centerPanel.setLayout(new CardLayout());
        centerPanel.add(homePanel);
        centerPanel.add(createAccountPanel);
        centerPanel.add(accountsPanel);
        centerPanel.add(transactionsPanel);
    }

    // This function switches the visibility of the pannels when pressing the buttons on the lateral panel
    private void switchCenterPanel(JPanel panel){
        homePanel.setVisible(false);
        createAccountPanel.setVisible(false);
        accountsPanel.setVisible(false);
        panel.setVisible(true);
    }
    
}
