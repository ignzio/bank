import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

public class Window extends JFrame {
    Dimension dimension;
    JPanel lateralPanel = new JPanel();
    JPanel centerPanel =new JPanel();
    JPanel homePanel = new JPanel();
    JPanel createAccountPanel= new CreateAccountPanel();
    JPanel accountsPanel = new AccountsPanel();

    JButton homeButton = new JButton("Home");
    JButton createAccountButton = new JButton("Create Account");
    JButton accountsButton = new JButton("Accounts");



    Window(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(1270,720));


        homePanelSettings();
        createAccountPanelSettings();
        lateralPanelSettings();
        centerPanelSettings();
        accountsPanelSettings();
        homeButton.addActionListener(e -> switchCenterPanel(homePanel));
        createAccountButton.addActionListener(e -> switchCenterPanel(createAccountPanel));
        accountsButton.addActionListener(e -> switchCenterPanel(accountsPanel));


        this.add(lateralPanel,BorderLayout.WEST);
        this.add(centerPanel,BorderLayout.CENTER);
    }

    void lateralPanelSettings(){
        lateralPanel.setPreferredSize(new Dimension(200,100));
        lateralPanel.setBackground(new Color(0,0,0));
        lateralPanel.setLayout(new GridLayout(0,1));
        lateralPanel.add(homeButton);
        lateralPanel.add(createAccountButton);
        lateralPanel.add(accountsButton);
    }
    void centerPanelSettings(){
        centerPanel.setPreferredSize(new Dimension(500,500));
        centerPanel.setBackground(new Color(50,50,50));
        centerPanel.setLayout(new CardLayout());
        centerPanel.add(homePanel);
        centerPanel.add(createAccountPanel);
        centerPanel.add(accountsPanel);
    }

    void homePanelSettings(){
        homePanel.setBackground(new Color(0,50,0));
        homePanel.setVisible(true);
    }
    void createAccountPanelSettings(){
        createAccountPanel.setBackground(new Color(0,20,0));
        createAccountPanel.setVisible(false);
    }
    void accountsPanelSettings(){
        accountsPanel.setBackground(new Color(20,0,0));
        createAccountPanel.setVisible(false);
    }

    void switchCenterPanel(JPanel panel){
        homePanel.setVisible(false);
        createAccountPanel.setVisible(false);
        accountsPanel.setVisible(false);
        panel.setVisible(true);
    }
    
}
