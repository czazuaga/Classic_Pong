
package clases;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;


public class Pala {
    
    public int posX,posY;
    public static final int SIZE_X=10,SIZE_Y=60;
    private Pelota pelota;
    
    public Pala(int x, int y,Pelota pelota){
    posX=x;
    posY=y;
    this.pelota=pelota;
    }
    
    public Rectangle2D getPala () {
    return new Rectangle2D.Double(posX, posY, SIZE_X, SIZE_Y);
    } 
    
    public void moverPala1(Rectangle limites){     
    if(ProcesadorDeEventos.w&&posY>limites.getMinY()){
    posY--;
    }
    
    if(ProcesadorDeEventos.s&&posY<limites.getMaxY()-SIZE_Y){
    posY++;
    }   
    }
    
    public void moverPala2(Rectangle limites){
    if(pelota.posY<=posY+(SIZE_Y/2)&&posY>limites.getMinY()){
    posY--;
    }
    
    if(pelota.posY>=posY&&posY<limites.getMaxY()-SIZE_Y){
    posY++;
    }
    }
    
}
