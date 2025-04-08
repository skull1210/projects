package Salesmanager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author skull
 */
public class Home extends JFrame {
    
    public JPanel panel, sections, copy;
    public int ancho, altura;
    public JButton boton;
    
    public Home(){
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension tamanio = tk.getScreenSize();
    double anchos, alturas;
    anchos= tamanio.getWidth(); alturas= tamanio.getHeight();
    ancho = (int) anchos; altura = (int) alturas - 30;  
    setTitle("Salesmanager");
    this.setBounds(0, 0, ancho, altura);
   //this.getContentPane().setBackground(Color.red)
   
    StartComponents();
    StartButons();
    StartSections();
    addtextbox();
    addlabels();

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }
    
    private void StartComponents(){
        
        panel = new JPanel();
        panel.setBackground(Color.blue);
        panel.setLayout(null);
        this.getContentPane().add(panel);
        panel.setBounds(400, 0, ancho-400, altura);
        
        sections= new JPanel();
        sections.setBounds(0, 0, 400, altura);
        sections.setLayout(null); 
        sections.setBackground(Color.white);
        this.getContentPane().add(sections);
    }
    
    private void StartSections(){
       
    JButton Ventas = new JButton("Ventas");
    Ventas.setBounds(0, 0, 400, altura/4);
    
    JButton Usuarios = new JButton("Usuarios");
    Usuarios.setBounds(0, altura/4, 400, altura/4);
    
    JButton Inventario = new JButton("Inventario");
    Inventario.setBounds(0, (altura/4) * 2, 400, altura/4);
    
    JButton Tendencias = new JButton("Tendencias");
    Tendencias.setBounds(0, (altura/4) * 3, 400, altura/4);
    
        MouseListener seccion = new MouseAdapter (){
        @Override
        public void mousePressed(MouseEvent e){
            JButton boton = (JButton) e.getSource(); // Identifica el botón presionado
            
            panel.removeAll();
            
            if(boton == Ventas)
            {
                resetHome();
                
            }
            else if(boton == Usuarios)
            {
                Users us = new Users ();
                us.setBounds(0, 0, ancho-400, altura);
                us.setVisible(true);
                panel.add(us);
            }
            else if(boton == Inventario)
            {
                Storage st = new Storage ();
                st.setBounds(0, 0, ancho-400, altura);
                st.setVisible(true);
                panel.add(st);
            }
            else if(boton == Tendencias)
            {
                Tendency td = new Tendency();
                td.setBounds(0, 0, ancho-400, altura);
                td.setVisible(true);
                panel.add(td);
                
            }
            panel.revalidate();
            panel.repaint();
    }
        
        
        
        
    };
    
    sections.add(Ventas); sections.add(Inventario); 
    sections.add(Usuarios); sections.add(Tendencias); 
    
    Ventas.addMouseListener(seccion); Inventario.addMouseListener(seccion);
    Usuarios.addMouseListener(seccion); Tendencias.addMouseListener(seccion);
    
    }
    
    private void StartButons(){
    
    ImageIcon calen = new ImageIcon("calendar.png"); 
    JButton calendar = new JButton();
    calendar.setIcon(new ImageIcon (calen.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
    calendar.setBounds(10, 100, 50, 50);
    calendar.setBackground(Color.blue);
    
    JButton agregar = new JButton("Agregar");
    agregar.setBounds(500, 520, 100, 30);
    
    JButton abrir = new JButton("Abrir");
    abrir.setBounds(70, 570, 200, 60);
    
    JButton cerrar = new JButton("Cerrar");
    cerrar.setBounds(280, 570, 200, 60);
    
    JButton salida = new JButton("Salida");
    salida.setBounds(490, 570, 200, 60);

    
    panel.add(calendar); panel.add(agregar);
    panel.add(abrir); panel.add(cerrar);
    panel.add(salida);
    }
    
    private void addlabels(){
        JLabel units = new JLabel("Unit");
        units.setBounds(450, 520, 30, 30);
        units.setForeground(Color.white);
        
        JLabel dia = new JLabel ("Ventas del dia: " );
        dia.setBounds(70, 10, 700, 50);
        dia.setForeground(Color.white);
        dia.setFont(new Font ("ALGERIAN",3,30));
        
        panel.add(units); panel.add(dia);
    }
    
    private void addtextbox(){
    
        JTextArea historial = new JTextArea();
        
        historial.setBounds(70, 100, 700, 400);
        historial.setEditable(false);
        
        JTextField search = new JTextField();
        search.setBounds(70, 520, 300, 30);
        
        JTextField units = new JTextField();
        units.setBounds(380, 520, 50, 30);
        panel.add(historial); panel.add(search); 
        panel.add(units); 
    }
    
    public void resetHome() {
    getContentPane().removeAll(); // Elimina todos los componentes
    repaint();
    
    StartComponents();
    StartButons();
    StartSections();
    addtextbox();
    addlabels();

    revalidate();
    repaint();
    }
            
}
    


