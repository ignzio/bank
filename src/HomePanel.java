

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;


/*
 * This Class will represent the Home panel, extra features will be added in this panel.
 */
public class HomePanel extends JPanel{

    JButton accountGenButton = new JButton("Generate 1000 accounts");
    HomePanel(){
        settings();
        accountGenButtonSettings();
        this.add(accountGenButton);
    }
    private void accountGenButtonSettings() {
        accountGenButton.addActionListener(e -> generateAccounts());
    }
    
    void settings(){
        this.setBackground(new Color(0,50,0));
        this.setVisible(true);
        this.setLayout(new GridLayout(3,5));
        
    }
    void generateAccounts(){
        Bank.manager.genRandomAccount(1000);
    }
}
