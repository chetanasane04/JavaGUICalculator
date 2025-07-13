
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

    public class CalculatorGUI extends JFrame implements ActionListener {

        JTextField display;
        double num1 = 0, num2 = 0, result = 0;
        char operator;

        CalculatorGUI() {
            setTitle("Java GUI Calculator");
            setSize(350, 450);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(null);

            display = new JTextField();
            display.setBounds(20, 30, 290, 40);
            display.setFont(new Font("Arial", Font.BOLD, 24));
            display.setEditable(false);
            add(display);

            String[] buttons = {
                    "7", "8", "9", "/",
                    "4", "5", "6", "*",
                    "1", "2", "3", "-",
                    "0", "C", "=", "+"
            };

            int x = 20, y = 90;
            for (int i = 0; i < buttons.length; i++) {
                JButton btn = new JButton(buttons[i]);
                btn.setBounds(x, y, 60, 40);
                btn.setFont(new Font("Arial", Font.PLAIN, 18));
                btn.addActionListener(this);
                add(btn);

                x += 70;
                if ((i + 1) % 4 == 0) {
                    x = 20;
                    y += 50;
                }
            }

            setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ((command.charAt(0) >= '0' && command.charAt(0) <= '9')) {
                display.setText(display.getText() + command);
            } else if (command.charAt(0) == 'C') {
                display.setText("");
                num1 = num2 = result = 0;
            } else if (command.charAt(0) == '=') {
                num2 = Double.parseDouble(display.getText());

                switch (operator) {
                    case '+': result = num1 + num2; break;
                    case '-': result = num1 - num2; break;
                    case '*': result = num1 * num2; break;
                    case '/':
                        if (num2 == 0) {
                            display.setText("Error");
                            return;
                        }
                        result = num1 / num2;
                        break;
                }

                display.setText(String.valueOf(result));
                num1 = result;
            } else {
                num1 = Double.parseDouble(display.getText());
                operator = command.charAt(0);
                display.setText("");
            }
        }

        public static void main(String[] args) {
            new CalculatorGUI();
        }
    }


