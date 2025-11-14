import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import static java.awt.Font.BOLD;

static class CreationPage extends  JFrame {

    public CreationPage() {

        setSize(new Dimension(700, 1000));

        setVisible(true);
    }
}

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
                    window.setVisible(true);
                    setVisible(false);

                    JCheckBox ExtraBox = new JCheckBox();
                    ExtraBox.setText("Extra Options");
                    getContentPane().setBackground(new Color(21, 71, 52));
                    window.add(ExtraBox);
                    JPanel panel = new JPanel();
                    window.setLayout(new GridBagLayout());
                    panel.setLayout(new GridBagLayout());

                    ExtraBox.addActionListener(_ -> {
                        if (ExtraBox.isSelected()) {

                            CreationPage page = new CreationPage();
                            boolean isPageVisible = !user_choice.getText().contains("Extra");

                            if (isPageVisible) {

                                try {
                                    label.setText("Closing...");
                                    Thread.sleep(1000);
                                    page.setVisible(true);
                                    window.setVisible(false);
                                    setVisible(false);

                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }

                        }

                    });

                }

                if (user_choice.getText().contains("User")) {

                    window.setVisible(true);
                    label.setLayout(new FlowLayout());
                    label.setFont(new Font("sans-serif", BOLD, 18));

                    getContentPane().setBackground(new Color(255, 0, 0));
                    boolean isValid = !user_choice.getText().startsWith("User");
                    label.setText("Login | Failed");

                    if (isValid) {
                        label.setForeground(new Color(255, 255, 255));
                        add(label);
                        setVisible(true);
                    }

                    else {
                        add(label);
                        setVisible(false);
                    }
                }
            }
        });

        add(user_choice, BorderLayout.SOUTH);
        add(submit, BorderLayout.SOUTH);
    }

}


static class Window extends JFrame {

    public Window() {

        JLabel label = new JLabel();
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
    Window window = new Window();

    if (homePage.isEnabled()) {
        homePage.setVisible(true);

    } else if (window.isEnabled()){
        window.setVisible(false);
    }
}