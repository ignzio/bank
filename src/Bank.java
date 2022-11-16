



/*
 * this Class is will run the main method and will hold an information manager variable to allow the interraction between all the GUI elements.
 */
public class Bank {
    public static InformationManager manager = new InformationManager();

    public static void main(String[] args) throws Exception {
        WindowFrame frame = new WindowFrame();
        frame.setVisible(true);
    }

}
