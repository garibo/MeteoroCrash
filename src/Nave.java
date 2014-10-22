/*

* ::::::::::Video Juego::::::::::::::
* Nombre del juego: Meteoro Crash
* Autor:
* Kevin Esteban Garibo Bracamontes
* copy@Left @ITLAC
 */
import javax.swing.*;
public class Nave extends JLabel{
    
    int posx;
    int posy;
    
    public Nave(int posicionNaveX, int posicionNaveY)
    {
        
        
        this.posx=posicionNaveX;
        this.posy=posicionNaveY;
        this.setVisible(true);
        
        setIcon(new ImageIcon( "imagenes//NaveEspacial.png" ));
        reshape(this.posx,this.posy,118,123);
    }
    
    public int getPosx()
    {
        return this.posx;
    }
    public int getPosy()
    {
        return this.posy;
    }
    
    public void avanzarInquierda()
    {
       this.posx=this.posx-40;
       reshape(this.posx,this.posy,118,123);
    }
    public void avanzarDerecha()
    {
       this.posx=this.posx+40; 
       reshape(this.posx,this.posy,118,123);
    }
}
