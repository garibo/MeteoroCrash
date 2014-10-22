/*

* ::::::::::Video Juego::::::::::::::
* Nombre del juego: Meteoro Crash
* Autor:
* Kevin Esteban Garibo Bracamontes
* copy@Left @ITLAC
 */

import java.util.Random;
import javax.swing.*;

public class Meteoros extends  javax.swing.JLabel{
    
   
    protected int posx;
    protected int posy;
   
    
    public Meteoros() {
        int lugar;
        Random Posicionar = new Random();
         lugar=Posicionar.nextInt(5);
        this.posx=300;
        this.posy=-100;
        
        if(lugar==0) {
            this.posx=0;
        }
        if(lugar==1)
        {
            this.posx=100;
        }
         if(lugar==2)
        {
            this.posx=200;
        }
        
          if(lugar==3)
        {
            this.posx=300;
        }
        
           if(lugar==4)
        {
            this.posx=400;
        }
        
            if(lugar==5)
        {
            this.posx=500;
        }
        setIcon( new ImageIcon( "imagenes//roka.png" ));
        
        this.reshape(this.posx,this.posy,120,120);
        
}

    
    public int getPosx(){
        return this.posx;
    }

   public int getPosy(){
       return this.posy;
   }
   
   public int getSubPosx()
   {
       return posx+120;
   }
   public int getSubPosy()
   {
       return posy+120;
   }
   

    public void avanzar(){
        this.posy++;
        this.reshape(posx,posy,120,120); 
    }
    


  

}