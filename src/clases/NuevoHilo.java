
package clases;

import java.util.logging.Level;
import java.util.logging.Logger;


public class NuevoHilo extends Thread{
    
    TableroJuego tableroJuego;
    boolean juegoActivo = true;
    
    
    public NuevoHilo (TableroJuego tableroJuego) {
    this.tableroJuego = tableroJuego;
    }
    
    @Override
    public void run () {
    while (juegoActivo){
        
        try {
            Thread.sleep(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(NuevoHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    tableroJuego.repaint();
    }
    }
    
    
}
