import javax.swing.*;
import java.awt.*;


import static java.awt.Font.BOLD;

static class Window extends JFrame {

    public Window() {

        JCheckBox darkmode = new JCheckBox();
        darkmode.setText("Dark Mode");
        JLabel label = new JLabel();

        darkmode.addActionListener(_ -> {
            if (darkmode.isSelected()) {
                label.setText("Dark Mode Enabled");
                add(label);
                getContentPane().setBackground(new Color(10, 10, 10));
                label.setFont(new Font("sans-serif", BOLD, 18));

            }
            else {
                label.setText("Dark Mode Disabled");
                add(label);

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

void main()  {

    Window window = new Window();
    window.setVisible(true);
}