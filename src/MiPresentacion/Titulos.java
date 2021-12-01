package MiPresentacion;

import javax.swing.*;
import java.awt.*;

public class Titulos extends JLabel {

    public Titulos(String titulos, Color colorFondo){
        setText(titulos);
        setBackground(colorFondo);
        setForeground(Color.white);
        setFont(new Font(Font.DIALOG,Font.BOLD+Font.ITALIC,20));
        setHorizontalAlignment(JLabel.CENTER);
        setOpaque(true);
    }
}
