
package clases;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;


public class Ventana extends JFrame {
    
    private final int SIZE_X = 800,SIZE_Y=500;
    private  MenuPrincipal menuPrincipal;
    private  TableroJuego tableroJuego;
    private NuevoHilo nuevoHilo;
    
    public Ventana () throws FontFormatException, IOException, FileNotFoundException,
            LineUnavailableException, UnsupportedAudioFileException {
       
        
    this.menuPrincipal = new MenuPrincipal(this);
    this.add(menuPrincipal);
    this.setTitle("Pong");
    this.setSize(SIZE_X,SIZE_Y);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
   
    this.addKeyListener(new ProcesadorDeEventos());
    
    
    
    
    }
    
    public void startGame() throws FontFormatException, IOException, 
            FileNotFoundException, LineUnavailableException, UnsupportedAudioFileException {
        
        menuPrincipal.setVisible(false);
     this.tableroJuego = new TableroJuego(); 
     this.add(tableroJuego);
     nuevoHilo = new NuevoHilo(tableroJuego);
     nuevoHilo.start();
    
    }

}
