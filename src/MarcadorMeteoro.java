/*

* ::::::::::Video Juego::::::::::::::
* Nombre del juego: Meteoro Crash
* Autor:
* Kevin Esteban Garibo Bracamontes
* copy@Left @ITLAC
 */
import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class MarcadorMeteoro extends JLabel{
    int contadorImagen=0;
    public MarcadorMeteoro(int X, int Y)
    {
        
       
        setIcon( new ImageIcon( "imagenes//marcador//"+contadorImagen+".png" ));
        setVisible(true);
        reshape(600,80,150,650);
       
    }
    
    
    public void Cambiar()
    {
        this.contadorImagen++;
        setIcon( new ImageIcon( "imagenes//marcador//"+contadorImagen+".png" ));
    }
    
    public int getPuntaje()
    {
        return this.contadorImagen;
    }
    
}
