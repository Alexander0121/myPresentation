package MiPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUI_Presentacion extends JFrame {
    //Atributos
    private JButton miFoto, miHobby,miEsxpectativa;
    private JPanel panelBotones,panelDatos;
    private JLabel labelImagen;
    private Titulos titulo;
    private Escucha escucha;
    private JTextArea texto;

    //Metodos
    public GUI_Presentacion(){
        initGUI();
        //Config de la ventana
        setTitle("Presentacion");
        setSize(600,540);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initGUI() {
        //crear container y layout de Jframe
        //Crear objetos Escucha y Control

        escucha =new Escucha();

        titulo = new Titulos("Hola soy Alexander, oprime los botones",Color.BLACK);
        add(titulo,BorderLayout.NORTH);

        miFoto=new JButton("Este soy yo");
        miFoto.addActionListener(escucha);
        miHobby =new JButton("Este es mi hobby");
        miHobby.addMouseListener(escucha);
        //miEsxpectativa = new JButton("Yo creo que...");
        //miEsxpectativa.addKeyListener(escucha);
        //miEsxpectativa.setFocusable(true);

        panelDatos = new JPanel();
        panelDatos.addKeyListener(escucha);
        panelDatos.setFocusable(true);
        panelDatos.setBorder(BorderFactory.createTitledBorder(null,"Un poco mas de mi...",
                TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION, new Font("Calibri",Font.BOLD,18),Color.BLACK));

        add(panelDatos,BorderLayout.CENTER);

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        //panelBotones.add(miEsxpectativa);

        this.add(panelBotones,BorderLayout.SOUTH);

        labelImagen=new JLabel();
        texto= new JTextArea(10,12);
        texto.addKeyListener(escucha);
    }

    public static void main(String[] arg) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI_Presentacion miPresentacion =new GUI_Presentacion();
            }
        });
    }

    private class Escucha implements ActionListener, MouseListener, KeyListener {
        private ImageIcon imagen;
        @Override
        public void actionPerformed(ActionEvent e) {
            panelDatos.removeAll();
            if (e.getSource()==miFoto){
                imagen=new ImageIcon(getClass().getResource("/recursos/Foto.jpeg"));
                labelImagen.setIcon(imagen);
                panelDatos.add(labelImagen);
            }
            revalidate();
            repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            panelDatos.removeAll();
            if(e.getClickCount() == 2 && !e.isConsumed()&&e.getSource()==miHobby) {
                e.consume();
                imagen=new ImageIcon(getClass().getResource("/recursos/Hobby.jpeg"));
                labelImagen.setIcon(imagen);
                panelDatos.add(labelImagen);
            }

            revalidate();
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            panelDatos.removeAll();
            labelImagen.setIcon(null);
            if(e.VK_M==e.getKeyCode()){
                //JOptionPane.showMessageDialog(null,"Se presiono la tecla "+e.getKeyChar());

                texto.setText("Se de Java y POO pero me gustaria aprender aun mas \n" +
                        "Quiero aprender a crear muchos tipos de GUI's");
                texto.setFont(new Font(Font.MONOSPACED,Font.BOLD+Font.ITALIC,16));
                texto.setBackground(null);
                panelDatos.add(texto);
            }
            revalidate();
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}