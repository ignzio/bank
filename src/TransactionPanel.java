
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.GridLayout;



/*
 * this class represent the micropannel that will be attached into the information panel of the account panel
 * will display the information of a transaction
 * 
 */


public class TransactionPanel extends JPanel {
    final JLabel transactionType = new JLabel();
    final JLabel transactionAmmount = new JLabel();
    final JLabel transactionDate = new JLabel();
    final Border border = BorderFactory.createLineBorder(Color.orange,3);


    TransactionPanel(String type, float ammount, String date){
        this.setLayout(new GridLayout(0,1));
        this.transactionType.setText(type);
        this.transactionAmmount.setText(Float.toString(ammount));
        this.transactionDate.setText(date);

        this.add(transactionType);
        this.add(transactionAmmount);
        this.add(transactionDate);
    }
}
