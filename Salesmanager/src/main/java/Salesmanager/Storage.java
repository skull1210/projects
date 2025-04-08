/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Salesmanager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author skull
 */
public class Storage extends JPanel{
    public int ancho, altura;
    
    public Storage(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension tamanio = tk.getScreenSize();
        double anchos, alturas;
        anchos = tamanio.getWidth(); alturas = tamanio.getHeight();
        ancho=(int) anchos; altura=(int) alturas -30;
        StartComponents();
    }
    
    private void StartComponents(){
        
        this.setBackground(Color.green);
        this.setLayout(null);
        this.setBounds(400, 0, ancho-400, altura);
        StartTextBox();
        StartButons();
    }
    
    private void StartTextBox(){
        JTextArea inven = new JTextArea();
        inven.setBounds(50,50,750,500);
        inven.setEditable(false);
        add(inven);
        
        JTextField search = new JTextField();
        search.setBounds(300, 570, 200, 30);
        add(search);
    }
    
    private void StartButons(){
        JButton agregar = new JButton("Agregar producto");
        agregar.setBounds(70, 570,200, 30);
        add(agregar);
        agregar.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(Storage.this);
        ModificarProducto dialog = new ModificarProducto(parentFrame);
        dialog.setVisible(true);
        
            }
        });
        
        JButton search = new JButton("Buscar");
        search.setBounds(530, 570, 100, 30);
        add(search);
    }
}

class Product extends JLabel{
    private int y;
    
    Product(int yes){
        y=yes;
        this.setSize(750, 30);
        
        initComponents();
    }
    
    void initComponents(){
        JLabel nombre = new JLabel();
        nombre.setBounds(0, y, 200, 50);
        add(nombre);
        
        JLabel units = new JLabel();
        units.setBounds(220, y, 70, 50);
        add(units);
        
        JLabel unit = new JLabel();
        unit.setBounds(310, y, 50, 50);
        add(unit);
        
        JLabel date = new JLabel();
        date.setBounds(380, y, 150, 50);
        add(date);
        
        JButton editar = new JButton();
        editar.setBounds(550, y, 50, 50);
        ImageIcon edit = new ImageIcon("modify.png");
        editar.setIcon(new ImageIcon (edit.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        add(editar);
        editar.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
        Window parentWindow = SwingUtilities.getWindowAncestor(Product.this);
        if (parentWindow instanceof JFrame) {
        ModificarProducto dialog = new ModificarProducto((JFrame) parentWindow);
        dialog.setVisible(true);
        }
    
        
        }
        });
        
        
        JButton eliminar = new JButton();
        eliminar.setBounds(620, y, 50, 50);
        ImageIcon borrar = new ImageIcon("delete.png");
        eliminar.setIcon(new ImageIcon (borrar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        add(eliminar);
        eliminar.addMouseListener(new MouseAdapter() {
    @Override
    public void mousePressed(MouseEvent e) {
        int opcion = JOptionPane.showConfirmDialog(
            null,
            "Esta acción no se puede deshacer.\n¿Desea continuar?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (opcion == JOptionPane.YES_OPTION) {
            // Aquí va la lógica para eliminar el producto
            System.out.println("Producto eliminado");
            
            } else {
            System.out.println("Eliminación cancelada");
            }
            }
        });
        
        
        
        JButton details = new JButton(); 
        details.setBounds(690, y, 50, 50);
        ImageIcon detalles = new ImageIcon("details.png");
        details.setIcon(new ImageIcon (detalles.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        add(details);
        
        details.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
        Window parentWindow = SwingUtilities.getWindowAncestor(Product.this);
        if (parentWindow instanceof JFrame) {
        ModificarProducto dialog = new ModificarProducto((JFrame) parentWindow);
        dialog.setVisible(true);
        }
    
        
        }
        });
        
        
    }
    
    public int gety(){
        return y;
    }
    
    
    
}

class ModificarProducto extends JDialog {

    private JTextField productoField;
    private JTextField unidadesField;
    private JTextField tipoUnidadField;
    private JTextField propietarioField;
    private JTextField costoCompraField;
    private JTextField costoVentaField;
    private JTextField utilidadField;
    private JTextField fechaAdquisicionField;

    private JButton guardarButton;
    private JButton cancelarButton;

    public ModificarProducto(JFrame parent) {
        super(parent, "Agregar Producto", true);
        setSize(450, 500);
        setLocationRelativeTo(parent);
        setResizable(false);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(33, 33, 33));
        add(panel);

        initComponents(panel);
    }

    private void initComponents(JPanel panel) {
        int y = 20;
        int labelWidth = 130;
        int fieldWidth = 220;
        int height = 30;

        productoField = createInput(panel, "Producto:", 40, y, labelWidth, fieldWidth, height);
        y += 50;
        unidadesField = createInput(panel, "Unidades:", 40, y, labelWidth, fieldWidth, height);
        y += 50;
        tipoUnidadField = createInput(panel, "Tipo de unidad:", 40, y, labelWidth, fieldWidth, height);
        y += 50;
        propietarioField = createInput(panel, "Propietario:", 40, y, labelWidth, fieldWidth, height);
        y += 50;
        costoCompraField = createInput(panel, "Costo compra:", 40, y, labelWidth, fieldWidth, height);
        y += 50;
        costoVentaField = createInput(panel, "Costo venta:", 40, y, labelWidth, fieldWidth, height);
        y += 50;
        utilidadField = createInput(panel, "Utilidad:", 40, y, labelWidth, fieldWidth, height);
        y += 50;
        fechaAdquisicionField = createInput(panel, "Fecha de adquisición:", 40, y, labelWidth, fieldWidth, height);
        y += 60;

        guardarButton = new JButton("Guardar");
        guardarButton.setBounds(90, y, 120, 35);
        guardarButton.setBackground(new Color(66, 165, 245));
        guardarButton.setForeground(Color.WHITE);
        guardarButton.setFont(new Font("Arial", Font.BOLD, 14));
        guardarButton.setFocusPainted(false);
        panel.add(guardarButton);

        cancelarButton = new JButton("Cancelar");
        cancelarButton.setBounds(230, y, 120, 35);
        cancelarButton.setBackground(new Color(244, 67, 54)); // Rojo moderno
        cancelarButton.setForeground(Color.WHITE);
        cancelarButton.setFont(new Font("Arial", Font.BOLD, 14));
        cancelarButton.setFocusPainted(false);
        panel.add(cancelarButton);

        guardarButton.addActionListener(e -> {
            System.out.println("Producto guardado: " + productoField.getText());
            dispose();
        });

        cancelarButton.addActionListener(e -> dispose());
    }

    private JTextField createInput(JPanel panel, String labelText, int x, int y, int labelWidth, int fieldWidth, int height) {
        JLabel label = new JLabel(labelText);
        label.setBounds(x, y, labelWidth, height);
        label.setForeground(Color.WHITE);
        panel.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(x + labelWidth + 10, y, fieldWidth, height);
        panel.add(textField);

        return textField;
    }

    // Getters por si los necesitas
    public String getProducto() { return productoField.getText(); }
    public String getUnidades() { return unidadesField.getText(); }
    public String getTipoUnidad() { return tipoUnidadField.getText(); }
    public String getPropietario() { return propietarioField.getText(); }
    public String getCostoCompra() { return costoCompraField.getText(); }
    public String getCostoVenta() { return costoVentaField.getText(); }
    public String getUtilidad() { return utilidadField.getText(); }
    public String getFechaAdquisicion() { return fechaAdquisicionField.getText(); }
}
