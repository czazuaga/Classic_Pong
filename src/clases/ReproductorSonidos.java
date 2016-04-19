
package clases;

import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class ReproductorSonidos {
    
    Clip clip1,clip2,song;
    BufferedInputStream bisPlop = new BufferedInputStream(getClass().getResourceAsStream("/sounds/plop.wav"));
        AudioInputStream ais = AudioSystem.getAudioInputStream(bisPlop);
        
        BufferedInputStream bisBeep = new BufferedInputStream(getClass().getResourceAsStream("/sounds/beep.wav"));
        AudioInputStream aisBeep = AudioSystem.getAudioInputStream(bisBeep);
    
        BufferedInputStream bis8bit = new BufferedInputStream(getClass().getResourceAsStream("/sounds/8bit.wav"));
        AudioInputStream ais8bit = AudioSystem.getAudioInputStream(bis8bit);

    public ReproductorSonidos() throws FileNotFoundException, IOException, 
            LineUnavailableException, UnsupportedAudioFileException {
        
         this.clip1 = AudioSystem.getClip();
         this.clip2 = AudioSystem.getClip();
         this.song = AudioSystem.getClip();
        
       clip1.open(ais);
       clip2.open(aisBeep);
       song.open(ais8bit);
        
        
       
    }
    
    public void reproducirPlop () throws LineUnavailableException, IOException {
     
        clip1.setFramePosition(0);
        clip1.start();
   
    }
    
    public void reproducirBeep () throws LineUnavailableException, IOException {
       
        clip2.setFramePosition(0);
        clip2.start();
   
    }
    
    public void reproducirSong () throws LineUnavailableException, IOException {
       
        song.setFramePosition(0);
        song.start();
   
    }
    
    public void pararSong () throws LineUnavailableException, IOException {
       
       
        song.stop();
   
    }
    
}
