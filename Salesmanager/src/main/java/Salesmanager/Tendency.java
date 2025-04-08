/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Salesmanager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author skull
 */
public class Tendency extends JPanel{
    
    public int ancho, altura;
    
    public Tendency(){
    
   
        
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension tamanio = tk.getScreenSize();
    double anchos, alturas;
    anchos= tamanio.getWidth(); alturas= tamanio.getHeight();
    ancho = (int) anchos; altura = (int) alturas - 30;  
    StartComponents();
   
   
    
}
     private void StartComponents(){
        
          this.setBackground(Color.yellow);
          this.setLayout(null);
          this.setBounds(400, 0, ancho-400, altura);
          StartLabels();
          StartTextBox();
          StartButons();
          
    }
    
     void StartLabels(){
    
     JLabel vendido = new JLabel("El producto mas vendido del mes de: " + "es: " + "");
     vendido.setBounds(50, 50, 800, 30);
     add(vendido);
     
     JLabel rentable = new JLabel("El producto mas rentable " + "es: ");
     rentable.setBounds(50, 90, 800, 30);
     add(rentable);
     
     JLabel utilidad = new JLabel ("La utilidad es: " + "");
     utilidad.setBounds(50, 130, 800, 30);
     add(utilidad);
     
     JLabel Notas = new JLabel ("Notas del mes: ");
     Notas.setBounds(50, 170, 800, 30);
     add(Notas);
    }
    
    void StartTextBox(){
        
        JTextArea Notas = new JTextArea();
        Notas.setEditable(false);
        Notas.setBounds(50, 200, 800, 400);
        add(Notas);
    }
    
    void StartButons(){
        
        JButton Notas = new JButton("Agregar nueva nota");
        Notas.setBounds(50, 610, 800, 30);
        add(Notas);
        
    }
    
}
