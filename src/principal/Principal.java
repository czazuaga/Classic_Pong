
package principal;

import clases.Ventana;
import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;


public class Principal {
   
    public static void main(String[] args) throws FontFormatException, IOException, FileNotFoundException, LineUnavailableException, UnsupportedAudioFileException {
        
       Ventana ventana = new Ventana();
       ventana.setVisible(true);
       ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
}
