
package Arkanoid.soundUtils;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class HiloSonidoBucle extends Thread{
       
          
          private Clip sonido;
          private boolean seguir;
           
       
 
       public HiloSonidoBucle(String rutaArchivo){
          
          seguir=true;
          try {
              sonido = AudioSystem.getClip();
              sonido.open(AudioSystem.getAudioInputStream(PlaySound.class.getClassLoader().getResource(rutaArchivo)));
               
          } catch (UnsupportedAudioFileException ex) {
             
              Logger.getLogger(PlaySound.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              
              Logger.getLogger(PlaySound.class.getName()).log(Level.SEVERE, null, ex);
          } catch (LineUnavailableException ex) {
              
              Logger.getLogger(PlaySound.class.getName()).log(Level.SEVERE, null, ex);
          }
       }
        
      @Override
       public void run(){
             
          sonido.loop(Clip.LOOP_CONTINUOUSLY);
             
          // Espera mientras se est� reproduciendo.
          do{
              try {
              Thread.sleep(500);
              } catch (InterruptedException ex) {
              Logger.getLogger(PlaySound.class.getName()).log(Level.SEVERE, null, ex);
              }
               
          }while (seguir && sonido.isActive());
           
          if(sonido.isActive()){
              sonido.stop();
          }
           
          // Se cierra el clip.
          sonido.close();
         
        
       }
       
      public void parar(){
          seguir=false;
      }
        
   }  