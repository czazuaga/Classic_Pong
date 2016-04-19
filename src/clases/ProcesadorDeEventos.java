
package clases;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class ProcesadorDeEventos extends KeyAdapter {
    
    public static boolean w,s,up,down,space;
    
    @Override
    public void keyPressed (KeyEvent keyEvent) {
    int keyID = keyEvent.getKeyCode();
    
    switch (keyID){
    
        case  KeyEvent.VK_W :
        {
        w=true;
        break;
        }
        
        case  KeyEvent.VK_S :
        {
        s=true;
        break;
        }
        
        case  KeyEvent.VK_UP :
        {
        up=true;
        break;
        }
        
        case  KeyEvent.VK_DOWN :
        {
        down=true;
        break;
        }
        
        case  KeyEvent.VK_SPACE :
        {
        space=true;
        break;
        }
    
    
    }
    }
    
    @Override
    public void keyReleased (KeyEvent keyEvent) {
    int keyID = keyEvent.getKeyCode();
    
    switch (keyID){
    
        case  KeyEvent.VK_W :
        {
        w=false;
        break;
        }
        
        case  KeyEvent.VK_S :
        {
        s=false;
        break;
        }
        
        case  KeyEvent.VK_UP :
        {
        up=false;
        break;
        }
        
        case  KeyEvent.VK_DOWN :
        {
        down=false;
        break;
        }
    
        case  KeyEvent.VK_SPACE :
        {
        space=false;
        break;
        }
    
    }
    }
    
}
