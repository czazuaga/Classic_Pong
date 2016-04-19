
package clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TableroJuego extends JPanel {
    
    
    Pala pala1,pala2;
    Pelota pelota;
      
    public static JLabel labelPuntosJugador,labelPuntosIA;
    
    public TableroJuego () throws FontFormatException, IOException, FileNotFoundException, LineUnavailableException, UnsupportedAudioFileException {
        this.setLayout(null);
        
        crearEtiquetas();
        
    this.setBackground(Color.BLACK);
    
    pelota = new Pelota(0, 0);
    pala1 = new Pala(10, 200,pelota);
    pala2 = new Pala(794-10-10, 200,pelota);
    
    }
    
    @Override
    public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D)g;
    g.fillRect((794/2)-5, 0, 10, 500);
    g2d.setColor(Color.WHITE);
        dibujar(g2d);
        try {
            actualizar();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(TableroJuego.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TableroJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void dibujar(Graphics2D g) {
    
    g.fill(pelota.getPelota());
    g.fill(pala1.getPala());
    g.fill(pala2.getPala());
    
       
    }
    
    public void actualizar() throws LineUnavailableException, IOException {
   
     pelota.mover(getBounds(),pala1.posY,pala2.posY);
     pala1.moverPala1(getBounds());
     pala2.moverPala2(getBounds());
     
        
         
     
    }
    
   private void crearEtiquetas() throws FontFormatException, IOException{
       
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/pixeldub.ttf")));   


       
   labelPuntosJugador = new JLabel();
   labelPuntosJugador.setBounds(160, 5, 300, 60);
   labelPuntosJugador.setText("Player "+sistemaPuntos.puntosJugador);
   labelPuntosJugador.setForeground(Color.WHITE);
   labelPuntosJugador.setFont(new java.awt.Font("pixeldust", 0, 32)); 
   this.add(labelPuntosJugador);
   
   labelPuntosIA = new JLabel();
   labelPuntosIA.setBounds(470, 5, 200, 60);
   labelPuntosIA.setText("Cpu: "+sistemaPuntos.puntosIA);
   labelPuntosIA.setForeground(Color.WHITE);
   labelPuntosIA.setFont(new java.awt.Font("pixeldust", 0, 32)); 
   this.add(labelPuntosIA);
   
   }
    
}
