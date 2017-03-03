/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbacat;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import CorbaCatApp.*;
import java.util.ArrayList;
import java.util.List;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;

/**
 *
 * @author daniel
 */
public class VentanaGato extends JFrame{
    private String nombre;
    private String ip;
    static ICorbaCat corbaCat;
    private String args[];
    private int idJuego;
    VentanaGato (String nombre, String ip, String args[]){
        super();
        this.args=args;
        this.nombre=nombre;
        this.ip=ip;
        invocarComponente();
        int idJugador = registrarJugador(nombre);
        idJuego = registrarJuego (idJugador, 1);
        initComponents();
    }
    public void initComponents(){
        setTitle("Juego Gato");
        setSize(400,500);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel panelGeneral = new JPanel();
        panelGeneral.setBackground(Color.BLACK);
        add(panelGeneral);
        
        JPanel panelBienvenida = new JPanel(/*layoutCentro*/);
        panelBienvenida.setBackground(Color.BLACK);
        JLabel bienvenida = new JLabel ("-------------Bienvenido "+ nombre + "-------------");
        bienvenida.setForeground(Color.GREEN);
        bienvenida.setFont(new Font("Sans", Font.PLAIN, 18));
        panelBienvenida.add(bienvenida);
        /*JLabel espacio = new JLabel ("-------------Bienvenido al juego-------------");
        espacio.setForeground(Color.BLACK);
        espacio.setFont(new Font("Sans", Font.PLAIN, 18));
        panelBienvenida.add(espacio);*/
        
        panelGeneral.add(panelBienvenida);
        
        JPanel panelBotones = new JPanel ();
        panelBotones.setBackground(Color.RED);
        Boton botonUno = new Boton (corbaCat, 0, 0, idJuego);
        panelBotones.add(botonUno);
        
        Boton botonDos = new Boton (corbaCat, 0, 1, idJuego);
        panelBotones.add(botonDos);
        
        Boton botonTres = new Boton (corbaCat, 0, 2, idJuego);
        panelBotones.add(botonTres);
        
        panelGeneral.add(panelBotones);
        
        JPanel panelBotonesDos = new JPanel ();
        panelBotonesDos.setBackground(Color.BLUE);
        Boton botonCuatro = new Boton (corbaCat, 1, 0, idJuego);
        panelBotonesDos.add(botonCuatro);
        
        Boton botonCinco = new Boton (corbaCat, 1, 1, idJuego);
        panelBotonesDos.add(botonCinco);
        
        Boton botonSeis = new Boton (corbaCat, 1, 2, idJuego);
        panelBotonesDos.add(botonSeis);
        
        panelGeneral.add(panelBotonesDos);
        
        JPanel panelBotonesTres = new JPanel ();
        panelBotonesTres.setBackground(Color.YELLOW);
        Boton botonSiete = new Boton (corbaCat, 2, 0, idJuego);
        panelBotonesTres.add(botonSiete);
        
        Boton botonOcho = new Boton (corbaCat, 2, 1, idJuego);
        panelBotonesTres.add(botonOcho);
        
        Boton botonNueve = new Boton (corbaCat, 2, 2, idJuego);
        panelBotonesTres.add(botonNueve);
        
        List<Boton> botones =new ArrayList <Boton> ();
        botones.add(botonUno);
        botones.add(botonDos);
        botones.add(botonTres);
        botones.add(botonCuatro);
        botones.add(botonCinco);
        botones.add(botonSeis);
        botones.add(botonSiete);
        botones.add(botonOcho);
        botones.add(botonNueve);
        
        botones.forEach(b -> b.setBotones(botones));
        panelGeneral.add(panelBotonesTres);
    }
    
    public void invocarComponente(){
      try{
        // crear e inicializar el ORB
	args[3] = ip;
	ORB orb = ORB.init(args, null);

        // obtener la raiz del nombre del contexto
        org.omg.CORBA.Object objRef = 
	orb.resolve_initial_references("NameService");
        // Usar NamingContextExt para instanciar NamingContext. Esto es parte de la interoperabilidad del servicio de nombres.
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
		
        // resolver la referencia del objeto con el nombre
        String name = "CorbaCat";
        corbaCat = ICorbaCatHelper.narrow(ncRef.resolve_str(name));
	//System.out.println(calcImpl.saludar());
      }catch (Exception e) {
         System.out.println("ERROR : " + e) ;
	 e.printStackTrace(System.out);
      }
  }

    private int registrarJugador(String nombre) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return corbaCat.registrarJugador(nombre);
    }

    private int registrarJuego(int idJugador, int i) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return corbaCat.registraJuego(idJugador, i);
    }
    
}
