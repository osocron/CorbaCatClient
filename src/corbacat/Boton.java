/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbacat;
import CorbaCatApp.ICorbaCat;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author daniel
 */
public class Boton extends JButton{
    private int seleccionado;
    private List <Boton> botones;
    private boolean ganador;
    
    
    Boton (ICorbaCat corbaCat, int x, int y, int idJuego){
        super();
        seleccionado = 0;
        ganador=false;
        setBackground(Color.GREEN);
        setPreferredSize(new Dimension (100,100));
        setFont(new Font("Sans", Font.BOLD, 42));
        this.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			//invocarComponente();
                       if(seleccionado==0){
                           seleccionado=1;
                           setText("x");
                           if(ganador==false) {
                               identificarLineas(corbaCat, idJuego);
                           }
                           corbaCat.registrarCoordenadas(x, y, idJuego, 1);
                           int xMalo = corbaCat.obtenerJugadaX();
                           int yMalo = corbaCat.obtenerJugadaY();
                           mostrarXYMalo(xMalo, yMalo);
                           if(ganador==false) {
                               identificarLineas(corbaCat, idJuego);
                           }

                       }
		}
	});
    }
    public void mostrarXYMalo(int x, int y) {
        switch(x){
            case 0:
                switch(y){
                    case 0:
                        botones.get(0).setText("o");
                        botones.get(0).cambiarEstado();
                        break;
                    case 1:
                        botones.get(1).setText("o");
                        botones.get(1).cambiarEstado();
                        break;
                    case 2:
                        botones.get(2).setText("o");
                        botones.get(2).cambiarEstado();
                        break;
                }
                break;
                
            case 1:
                switch(y){
                    case 0:
                        botones.get(3).setText("o");
                        botones.get(3).cambiarEstado();
                        break;
                    case 1:
                        botones.get(4).setText("o");
                        botones.get(4).cambiarEstado();
                        break;
                    case 2:
                        botones.get(5).setText("o");
                        botones.get(5).cambiarEstado();
                        break;
                   
                }
                break;
            case 2:
                switch(y){
                   case 0:
                        botones.get(6).setText("o");
                        botones.get(6).cambiarEstado();
                        break;
                    case 1:
                        botones.get(7).setText("o");
                        botones.get(7).cambiarEstado();
                        break;
                    case 2:
                        botones.get(8).setText("o");
                        botones.get(8).cambiarEstado();
                        break;
                }
                break;
        }
        
    }
    public void cambiarEstado(){
        seleccionado=1;
    }
    public int getSeleccionado(){
        return seleccionado;
    }
    public void setBotones(List<Boton> botones){
        this.botones=botones;
    }
    public void identificarLineas(ICorbaCat corbaCat, int idJuego){
        if(botones.get(0).getSeleccionado()== 1 && botones.get(1).getSeleccionado()==1 && botones.get(2).getSeleccionado()==1){
            if(botones.get(0).getText().equals("x") && botones.get(1).getText().equals("x") && botones.get(2).getText().equals("x")){
                showMessageDialog(null,"Felicidades Ganaste!");
                ganador=true;
                corbaCat.terminarJuego(idJuego);
            }
            else if(botones.get(0).getText().equals("o") && botones.get(1).getText().equals("o") && botones.get(2).getText().equals("o")){
                showMessageDialog(null,":( Perdiste");
                ganador=true;
                corbaCat.terminarJuego(idJuego);
            }
        }
        else if (botones.get(3).getSeleccionado()== 1 && botones.get(4).getSeleccionado()==1 && botones.get(5).getSeleccionado()==1){
            if(botones.get(3).getText().equals("x") && botones.get(4).getText().equals("x") && botones.get(5).getText().equals("x")){
                showMessageDialog(null,"Felicidades Ganaste!");
                ganador=true;
                corbaCat.terminarJuego(idJuego);
            }
            else if(botones.get(3).getText().equals("o") && botones.get(4).getText().equals("o") && botones.get(5).getText().equals("o")){
                showMessageDialog(null,":( Perdiste");
                ganador=true;
                corbaCat.terminarJuego(idJuego);
            }
        }
        else if (botones.get(6).getSeleccionado()== 1 && botones.get(7).getSeleccionado()==1 && botones.get(8).getSeleccionado()==1){
            if(botones.get(6).getText().equals("x") && botones.get(7).getText().equals("x") && botones.get(8).getText().equals("x")){
                showMessageDialog(null,"Felicidades Ganaste!");
                ganador=true;
                corbaCat.terminarJuego(idJuego);
            }
            else if(botones.get(6).getText().equals("o") && botones.get(7).getText().equals("o") && botones.get(8).getText().equals("o")){
                showMessageDialog(null,":( Perdiste");
                ganador=true;
                corbaCat.terminarJuego(idJuego);
            }
        }
        else if (botones.get(0).getSeleccionado()== 1 && botones.get(3).getSeleccionado()==1 && botones.get(6).getSeleccionado()==1){
            if(botones.get(0).getText().equals("x") && botones.get(3).getText().equals("x") && botones.get(6).getText().equals("x")){
                showMessageDialog(null,"Felicidades Ganaste!");
                ganador=true;
                corbaCat.terminarJuego(idJuego);
            }
            else if(botones.get(0).getText().equals("o") && botones.get(3).getText().equals("o") && botones.get(6).getText().equals("o")){
                showMessageDialog(null,":( Perdiste");
                ganador=true;
                corbaCat.terminarJuego(idJuego);
            }
        }
        else if (botones.get(1).getSeleccionado()== 1 && botones.get(4).getSeleccionado()==1 && botones.get(7).getSeleccionado()==1){
            if(botones.get(1).getText().equals("x") && botones.get(4).getText().equals("x") && botones.get(7).getText().equals("x")){
                showMessageDialog(null,"Felicidades Ganaste!");
                ganador=true;
                corbaCat.terminarJuego(idJuego);
            }
            else if(botones.get(1).getText().equals("o") && botones.get(4).getText().equals("o") && botones.get(7).getText().equals("o")){
                showMessageDialog(null,":( Perdiste");
                ganador=true;
                corbaCat.terminarJuego(idJuego);
            }
        }
        else if (botones.get(2).getSeleccionado()== 1 && botones.get(5).getSeleccionado()==1 && botones.get(8).getSeleccionado()==1){
            if(botones.get(2).getText().equals("x") && botones.get(5).getText().equals("x") && botones.get(8).getText().equals("x")){
                showMessageDialog(null,"Felicidades Ganaste!");
                ganador=true;
                corbaCat.terminarJuego(idJuego);
            }
            else if(botones.get(2).getText().equals("o") && botones.get(5).getText().equals("o") && botones.get(8).getText().equals("o")){
                showMessageDialog(null,":( Perdiste");
                ganador=true;
                corbaCat.terminarJuego(idJuego);
            }
        }
        else if (botones.get(0).getSeleccionado()== 1 && botones.get(4).getSeleccionado()==1 && botones.get(8).getSeleccionado()==1){
            if(botones.get(0).getText().equals("x") && botones.get(4).getText().equals("x") && botones.get(8).getText().equals("x")){
                showMessageDialog(null,"Felicidades Ganaste!");
                ganador=true;
                corbaCat.terminarJuego(idJuego);
            }
            else if(botones.get(0).getText().equals("o") && botones.get(4).getText().equals("o") && botones.get(8).getText().equals("o")){
                showMessageDialog(null,":( Perdiste");
                ganador=true;
                corbaCat.terminarJuego(idJuego);
            }
        }
        else if (botones.get(2).getSeleccionado()== 1 && botones.get(4).getSeleccionado()==1 && botones.get(6).getSeleccionado()==1){
            if(botones.get(2).getText().equals("x") && botones.get(4).getText().equals("x") && botones.get(6).getText().equals("x")){
                showMessageDialog(null,"Felicidades Ganaste!");
                ganador=true;
                corbaCat.terminarJuego(idJuego);
            }
            else if(botones.get(2).getText().equals("o") && botones.get(4).getText().equals("o") && botones.get(6).getText().equals("o")){
                showMessageDialog(null,":( Perdiste");
                ganador=true;
                corbaCat.terminarJuego(idJuego);
            }
        }
    }

}
