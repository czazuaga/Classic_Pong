
package clases;

import static clases.TableroJuego.labelPuntosJugador;
import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class MenuPrincipal extends JPanel{
    
    ProcesadorDeEventos procesadorDeEventos;
    HiloMenuPrincipal hiloMenuPrincipal;
    ReproductorSonidos reproductorSonidos;
    
    JLabel labelBin,labelBin1,labelBin2,labelBin3,labelTitulo,labelTitulo1;
    
    private Ventana ventana;
  
    
    int binPosX=1,binPosXWrong=1,binPosY=1;
    int dx=0,dy=0;
    
    public MenuPrincipal(Ventana ventana) throws LineUnavailableException, IOException, FileNotFoundException, UnsupportedAudioFileException{
        reproductorSonidos = new ReproductorSonidos();
        hiloMenuPrincipal = new HiloMenuPrincipal(this);
        hiloMenuPrincipal.start();
    this.setLayout(null);
    this.setBackground(Color.BLACK);
    this.setBounds(0, 0, getWidth(), getHeight());
    this.ventana= ventana;
    reproductorSonidos.reproducirSong();
    
    crearLabels();
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
        } catch (FontFormatException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void actualizar() throws FontFormatException, IOException, FileNotFoundException, LineUnavailableException, UnsupportedAudioFileException {
        
        if (!reproductorSonidos.song.isRunning()){ 
        reproductorSonidos.reproducirSong();
        }
        
        if(ProcesadorDeEventos.space){
            reproductorSonidos.pararSong();
        ventana.startGame();
        }
        
        if(labelBin.getBounds().x>800){
            
        dx=0;
        }else if(labelBin.getBounds().x<-3000){
        dx=1;
        }
        
        if(dx==1){
       binPosX++;
       binPosXWrong--;
        }else{
       binPosX--;
       binPosXWrong++;
        }
       
       
        labelBin .setBounds(binPosX, binPosY, 4000, 100);
        labelBin1 .setBounds(binPosXWrong-10, 38, 4000, 100);
        labelBin2 .setBounds(binPosX+1, 60, 3000, 100);
        labelBin3 .setBounds(binPosXWrong+30, 90, 3000, 100);
       
        
    }

    private void dibujar(Graphics2D g2d) {
        
    
    }
    
    void crearLabels(){
    labelBin = new JLabel();
    labelBin .setBounds(-1000, binPosY, 1000, 505);
   labelBin .setText("//  111111111111111111111111111111111111111111111111111111111 \n"
           + "111111 \\ desarrollado por carlos zamora azuaga \\ 11111111111111111111105054045i85487523729982398t57y64395835745929026543956345");                                                                          
   labelBin .setForeground(Color.WHITE);
   labelBin .setFont(new java.awt.Font("pixeldust", 3, 50)); 
   this.add(labelBin );
   
    labelBin1 = new JLabel();
    labelBin1 .setBounds(-1000, binPosY+20, 1000, 505);
   labelBin1 .setText("//  Desarrollado por carlos zamora azuaga 111111111111111111111111111111111111111111111111111111111 \n"
           + "11111111111111111111111111105054045i85487523729982398t57y64395835745929026543956345");                                                                          
   labelBin1 .setForeground(Color.WHITE);
   labelBin1 .setFont(new java.awt.Font("pixeldust", 3, 50)); 
   this.add(labelBin1 );
   
   labelBin2 = new JLabel();
    labelBin .setBounds(-1000, binPosY+20, 1000, 505);
   labelBin2 .setText("//  111001101011100011101110101110001110011100101000110001010001001"
           + "101010000\\developed by carlos zamora azuaga\\111100101010101000001111101000111011001101010001011001100101000101010011110");                                                                          
   labelBin2 .setForeground(Color.WHITE);
   labelBin2 .setFont(new java.awt.Font("pixeldust", 3, 30)); 
   this.add(labelBin2 );
   
   labelBin3 = new JLabel();
    labelBin3 .setBounds(-1000, binPosY+20, 1000, 505);
   labelBin3 .setText("//  111kkgufrhdsbysb36326532gryew6rgrffd7ds7fgsus77syyfh2523hgrfyd76sweu7f7s88gjhsug7sgg"
           + "skjgkjg847647848hjtru7ew7ewfjuefh7wefwe8fg7wf3623f5ffg376f84874ft6ftw8f94fry298t2fgg286f4fgyf4fb");                                                                          
   labelBin3 .setForeground(Color.WHITE);
   labelBin3 .setFont(new java.awt.Font("pixeldust", 3, 55)); 
   this.add(labelBin3 );
   
   labelTitulo = new JLabel();
    labelTitulo .setBounds(80, 200, 400,200);
   labelTitulo .setText("PONG");                                                                          
   labelTitulo .setForeground(Color.WHITE);
   labelTitulo .setFont(new java.awt.Font("pixeldust", 3, 100)); 
   this.add(labelTitulo );
   
   labelTitulo1 = new JLabel();
    labelTitulo1 .setBounds(100, 300, 800,200);
   labelTitulo1 .setText("presiona espacio para comenzar");                                                                          
   labelTitulo1 .setForeground(Color.WHITE);
   labelTitulo1 .setFont(new java.awt.Font("pixeldust", 3, 30)); 
   this.add(labelTitulo1 );
   
    }
    
}
