import javax.swing.*;
import java.awt.*;

static class Window extends JFrame {

    public Window() {


        JCheckBox lightmode = new JCheckBox();
        lightmode.setText("Light Mode");

        lightmode.addActionListener(_ -> {
            if (lightmode.isSelected()) {
                getContentPane().setForeground(new Color(255, 255, 255));
            }
            else {
                lightmode.setEnabled(false);
                lightmode.setVisible(false);
            }
        });

        JCheckBox darkmode = new JCheckBox();
        darkmode.setText("Dark Mode");

        darkmode.addActionListener(_ -> {
            if (darkmode.isSelected()) {
                getContentPane().setBackground(new Color(10, 10, 10));
            }
            else {
                darkmode.setEnabled(false);
                darkmode.setVisible(false);
            }
         });

        add(darkmode);
        setSize(400, 700);
        setResizable(false);

        setLayout(new FlowLayout());
        JCheckBox option = new JCheckBox();
        option.setText("iCrazyTeddy");
        add(option);
        add(lightmode);

        JCheckBox option2 = new JCheckBox();
        option2.setText("XpertThief");
        add(option2);
        JLabel label = new JLabel();
        add(label);

        option.addActionListener(_ -> {
            if (option.isSelected()) {

                try {
                    URL url = URI.create("https://www.youtube.com/iCrazyteddy").toURL();
                    Desktop.getDesktop().browse(URI.create(url.toString()));
                    getContentPane().setBackground(new Color(10, 10, 10));
                    label.setFont(new Font("sans-serif", Font.BOLD, 18));
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
                    label.setFont(new Font("sans-serif", Font.BOLD, 18));
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