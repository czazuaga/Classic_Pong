
package clases;

import java.util.logging.Level;
import java.util.logging.Logger;


public class HiloMenuPrincipal extends Thread {
    
    private MenuPrincipal menuPrincipal;
    
    public HiloMenuPrincipal (MenuPrincipal menuPrincipal) {
    this.menuPrincipal = menuPrincipal;
    }
    
    @Override
    public void run () {
    while (true){
        
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(NuevoHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    menuPrincipal.repaint();
    }
    }
    
}
