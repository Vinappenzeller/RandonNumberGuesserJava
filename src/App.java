import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

    static Integer myNumber = ThreadLocalRandom.current().nextInt(0, 100 + 1);
    static Integer tries = 0;
    static JLabel text = new JLabel("Gebe eine Zahl zwischen 0 und 100 ein.");
    static JTextField textField = new JTextField();

    public static void main(String[] args) throws Exception {
        openUI();
    }

    public static void openUI() {
        JFrame frame = new JFrame("Rate die Zahl!");
        frame.setSize(400, 300);
        frame.setLocation(100, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);

        text.setBounds(50, 50, 350, 30);

        textField.setBounds(50, 100, 200, 30);

        JButton button = new JButton("Raten");
        button.setBounds(50, 150, 200, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String textFromTexFied = textField.getText();
                    Integer number = Integer.parseInt(textFromTexFied);
                    guess(number);
                } catch (Exception error) {
                    text.setText("Bitte gebe eine Zahl ein!");
                }
            }
        });

        frame.add(text);
        frame.add(textField);
        frame.add(button);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void guess(Integer number) {
        if (number == myNumber) {
            text.setText("Richtig geraten mit " + tries + " Versuchen.");
            System.out.println("Richtig geraten!!!");
            System.out.println("Du hast " + tries + " Versuche gebraucht!");
        } else {
            tries++;
            if (number < myNumber) {
                text.setText("Deine Zahl ist zu klein!");
            } else if (number > myNumber) {
                text.setText("Deine Zahl ist zu gross!");
            }
            textField.setText("");
        }
    }
}
