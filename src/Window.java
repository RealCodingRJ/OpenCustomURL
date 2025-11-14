import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static java.awt.Font.BOLD;

static class HomeScreen extends JFrame {

    public HomeScreen() {

        setSize(new Dimension(300, 600));
        setResizable(false);

        getContentPane().setLayout(new FlowLayout());
        JTextField user_choice = new JTextField(10);
        user_choice.setPreferredSize(new Dimension(190, 29));
        add(user_choice);

        JButton submit = new JButton("Submit");

        submit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel label = new JLabel();
                Window window = new Window();

                if (user_choice.getText().contains("Admin")) {

                    window.setVisible(true);
                    label.setLayout(new FlowLayout());
                    label.setFont(new Font("sans-serif", BOLD, 18));
                    label.setText("Login | Success");
                    label.setForeground(new Color(255, 255, 255));
                    add(label);
                    getContentPane().setBackground(new Color(21, 71, 52));

                }

                if (user_choice.getText().contains("User")) {

                    window.setVisible(true);
                    label.setLayout(new FlowLayout());
                    label.setFont(new Font("sans-serif", BOLD, 20));


                    getContentPane().setBackground(new Color(255, 0, 0));
                    label.setText("Login | Failed");
                    label.setForeground(new Color(255, 255, 255));
                    add(label);

                }
            }
        });

        add(user_choice, BorderLayout.SOUTH);
        add(submit, BorderLayout.SOUTH);
    }

}


static class Window extends JFrame {

    public Window() {

        JCheckBox darkmode = new JCheckBox();
        darkmode.setText("Dark Mode");
        JLabel label = new JLabel();

        JLabel label2 = new JLabel();
        add(label2);
        label2.setFont(new Font("sans-serif", BOLD, 18));

        darkmode.addActionListener(_ -> {
            if (darkmode.isSelected()) {
                label.setText("Dark Mode Enabled");
                label2.setText(String.valueOf(LocalDate.now()));

                add(label);
                add(label2);
                getContentPane().setBackground(new Color(10, 10, 10));
                label.setFont(new Font("sans-serif", BOLD, 18));

            }
            else {
                label.setText("Dark Mode Disabled");
                label.setFont(new Font("sans-serif", BOLD, 18));
                getContentPane().setBackground(new Color(10, 10, 10));

            }
         });

        add(darkmode);
        setSize(400, 700);
        setResizable(false);

        setLayout(new FlowLayout());
        JCheckBox option = new JCheckBox();
        option.setText("iCrazyTeddy");
        add(option);

        JCheckBox option2 = new JCheckBox();
        option2.setText("XpertThief");
        add(option2);
        add(label);

        option.addActionListener(_ -> {
            if (option.isSelected()) {

                try {
                    URL url = URI.create("https://www.youtube.com/iCrazyteddy").toURL();
                    Desktop.getDesktop().browse(URI.create(url.toString()));
                    getContentPane().setBackground(new Color(10, 10, 10));
                    label.setFont(new Font("sans-serif", BOLD, 18));
                    label.setText(url.toString());
                    label.setForeground(new Color(255, 255, 255));

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        });


        option2.addActionListener(_ -> {
            if (option2.isSelected()) {

                try {
                    URL url = URI.create("https://www.youtube.com/XpertThief").toURL();

                    Desktop.getDesktop().browse(URI.create(url.toString()));
                    getContentPane().setBackground(new Color(10, 10, 10));
                    label.setFont(new Font("sans-serif", BOLD, 18));
                    label.setText(url.toString());
                    label.setForeground(new Color(255, 255, 255));

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }

}

void main() {

    HomeScreen homePage = new HomeScreen();

    boolean isTrue = homePage.isEnabled();
    if (isTrue) {
        homePage.setVisible(true);
    }

    else {
        Window window = new Window();
        window.setVisible(true);
        homePage.setVisible(false);
    }

}