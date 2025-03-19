import javax.swing.*;
public class ejemplo{
    private final JFrame frame;
    public ejemplo(){
        //Configurar la ventana
        frame = new JFrame("Ventana 1");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Crear panel
        JPanel panel = new JPanel();
        frame.add(panel);

        colocarComponentens(panel);
    }

    private void colocarComponentens(JPanel panel){
        panel.setLayout(null);

        //Etiqueta
        JLabel etiqueta = new JLabel("Usuario");
        etiqueta.setBounds(10,20,80,25);
        panel.add(etiqueta);

        //Texto
        JTextField texto = new JTextField(20);
        texto.setBounds(100, 20, 165, 25);
        panel.add(texto);

        //Boton
        JButton boton = new JButton("Enviar");
        boton.setBounds(10, 80, 80, 25);
        panel.add(boton);
    }

    public void mostrar(){
        this.frame.setVisible(true);
    }
}