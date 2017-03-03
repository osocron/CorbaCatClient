/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbacat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

/**
 *
 * @author daniel
 */
public class VentanaPrincipal extends JFrame{
    private JTextField campoNombre;
    private JTextField campoIP;
    private JButton botonJugar;
    private String args[];
 
    VentanaPrincipal (String args[]){
        super();
        this.args=args;
        initComponents();
        botonJugar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			//invocarComponente();
                       VentanaGato ventanaGato = new VentanaGato (campoNombre.getText(), campoIP.getText(), args);
                       ventanaGato.setVisible(true); 
                       //dispose();
		}
	});
        
    }
    public void initComponents(){
        setTitle("Gato");
        setSize(400,300);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panelGeneral = new JPanel();
        panelGeneral.setBackground(Color.BLACK);
        
        //Boton botonUno = new Boton ();
        //panelGeneral.add(botonUno);
        JPanel panelBienvenida = new JPanel(/*layoutCentro*/);
        panelBienvenida.setBackground(Color.BLACK);
        JLabel bienvenida = new JLabel ("-------------Bienvenido al juego Gato-------------");
        bienvenida.setForeground(Color.GREEN);
        bienvenida.setFont(new Font("Sans", Font.PLAIN, 18));
        panelBienvenida.add(bienvenida);
        
        panelGeneral.add(panelBienvenida);
        
        JPanel panelNombre = new JPanel(/*layoutIzquierda*/);
        panelNombre.setBackground(Color.BLACK);
        JLabel nombre = new JLabel ("Nombre");
        nombre.setForeground(Color.GREEN);
        panelNombre.add(nombre);
        campoNombre =  new JTextField ();
        campoNombre.setPreferredSize(new Dimension(150,20));
        panelNombre.add(campoNombre);
        panelGeneral.add(panelNombre);
        
        JPanel panelIP = new JPanel();
        panelIP.setBackground(Color.BLACK);
        JLabel ip = new JLabel ("Dir IP     ");
        ip.setForeground(Color.GREEN);
        panelIP.add(ip);
        campoIP =  new JTextField ();
        campoIP.setPreferredSize(new Dimension(150,20));
        panelIP.add(campoIP);
        panelGeneral.add(panelIP);
        
        JPanel panelBotonJugar = new JPanel();
        panelBotonJugar.setBackground(Color.BLACK);
        JLabel espacio = new JLabel ("-------------Bienvenido al juego-------------");
        espacio.setForeground(Color.BLACK);
        espacio.setFont(new Font("Sans", Font.PLAIN, 18));
        botonJugar = new JButton("Jugar");
        botonJugar.setPreferredSize(new Dimension (200,75));
        botonJugar.setBackground(Color.GREEN);
        botonJugar.setFont(new Font("Sans", Font.BOLD, 36));
        
        panelBotonJugar.add(botonJugar);
        panelGeneral.add(espacio);
        panelGeneral.add(panelBotonJugar);
        
        add(panelGeneral);
        
        setLocationRelativeTo(null);
        
    }
    
    
}
