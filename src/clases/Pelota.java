
package clases;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Pelota {
    
    public int posX,posY;
    private final int ANCHO=15,ALTO=15;
    private int dx=1,dy=1;
    private ReproductorSonidos sounds;
    
            
    
    public Pelota(int x,int y) throws IOException,
            FileNotFoundException, LineUnavailableException,
            UnsupportedAudioFileException{
        
    this.sounds = new ReproductorSonidos();
    this.posX=x;
    this.posY=y;
    
    
    }
    
    public Rectangle2D getPelota(){
    return new Rectangle2D.Double(posX,posY,ANCHO,ALTO);
    }
    
    public void mover (Rectangle limites,int yPala1,int yPala2) throws LineUnavailableException, IOException{
    posX+=dx;
    posY+=dy;

    
    
    if(posX>limites.getMaxX()){
    dx=-dx;
    sistemaPuntos.puntosJugador ++;
    TableroJuego.labelPuntosJugador.setText("Player: "+sistemaPuntos.puntosJugador);
    sounds.reproducirBeep();
    }
    
    if (posY>=yPala2-10&&posY<=yPala2+80) {
        if(posX>767){
            dx=-dx;
            sounds.reproducirPlop();
        }
       
    }
    
    if (posY>=yPala1-10&&posY<=yPala1+80) {
        if(posX<20){
            dx=-dx;
            sounds.reproducirPlop();
        }
       
    }
    
    
    
     if(posY>limites.getMaxY()){
    dy=-dy;
    sounds.reproducirPlop();
    }
    
     if(posX<0){
    dx=-dx;
    sistemaPuntos.puntosIA ++;
         TableroJuego.labelPuntosIA.setText("Cpu: "+sistemaPuntos.puntosIA);
          sounds.reproducirBeep();
    }
     
     if(posY<0){
    dy=-dy;
    sounds.reproducirPlop();
    }
     
    }
    
    
    
}
