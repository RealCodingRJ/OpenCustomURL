import javax.swing.*;
import java.awt.*;

static class Window extends JFrame {

    public Window() {

        setSize(500, 500);
        setResizable(false);

        setLayout(new FlowLayout());
        JCheckBox option = new JCheckBox();
        option.setText("iCrazyTeddy");
        add(option);

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
                    label.setFont(new Font("sans-serif", Font.BOLD, 20));
                    label.setText(url.toString());
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
                    label.setFont(new Font("sans-serif", Font.BOLD, 20));
                    label.setText(url.toString());

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