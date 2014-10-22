/*

* ::::::::::Video Juego::::::::::::::
* Nombre del juego: Meteoro Crash
* Autor:
* Kevin Esteban Garibo Bracamontes
* copy@Left @ITLAC
 */

import javax.swing.*;

public class Balas extends JLabel{

    int posx;
    int posy;
    
    public Balas(int posicionBalaX, int posicionBalaY)
    {
    this.posx=posicionBalaX;
    this.posy=posicionBalaY;
    
    reshape(this.posx,this.posy , 32, 100 );
    setIcon( new ImageIcon( "imagenes//Rocket.png" ));
    }
    
    
        public int getPosx()
        {
            return this.posx;
        }
        
        public int getPosy()
        {
            return this.posy;
        }
        
        public int getSubPosx()
        {
            return this.posx+23;
        }
        public int getSubPosy()
        {
            return this.posy+100;
        }
        
        public void avanzar(){
        this.posy--;
        this.reshape(this.posx,this.posy , 32, 100 ); 
    }
    
}
