/*

* ::::::::::Video Juego::::::::::::::
* Nombre del juego: Meteoro Crash
* Autor:
* Kevin Esteban Garibo Bracamontes
* copy@Left @ITLAC
 */

import java.io.*;
import javax.sound.sampled.*;
import java.awt.event.*;
import javax.swing.*;


public class Escenario extends JFrame implements ActionListener, KeyListener{
    
    JLabel fondo = new JLabel( new ImageIcon( "imagenes//meteoro-crash.png" ) );
    JLabel gane = new JLabel( new ImageIcon( "imagenes//final//ganar.png" ) );
    JLabel perdi = new JLabel( new ImageIcon( "imagenes//final//perder.png" ) );
    JLabel universo = new JLabel( new ImageIcon( "imagenes//wallspace.png" ) );    
    JLabel explosion = new JLabel( new ImageIcon( "imagenes//explosion.gif" ) );
    JButton jugar,salir,ok;
     
    protected Meteoros meteoros[];
    protected MarcadorMeteoro marcadorMeteoro;
    protected Nave nave;
    protected Balas balas;
    
    public boolean turno=true;
    
    int posicionX=250;
    int posicionY=580;
    int posicionExplosionX=0;
    int posicionExplosionY=0;
    int x=0;
    int exploit=0;
    Timer tiempoBala;
    Timer tiempoMeteoro;
    Timer tiempoExplosion;
    
    SonidoMeteoro play = new SonidoMeteoro();
    SonidoExplosion playExplosion = new SonidoExplosion();
    
    public Escenario()
    {
          initComponents();  
       
      for(int i=1;i<26;i++)
      {meteoros[i].setVisible(false);}    
      tiempoMeteoro = new Timer (1, new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
      meteoros[x].avanzar();
          if(balas.getPosy()==meteoros[x].getPosy())
           {
               
               
               if((balas.getPosx()<=meteoros[x].getSubPosx())&&(balas.getSubPosx()>=meteoros[x].getPosx())&&(balas.isVisible()==true))
               {
               meteoros[x].setVisible(false);
               balas.setVisible(false);
               
               posicionY=500;
               posicionExplosionY=meteoros[x].getPosy();
               posicionExplosionX=(meteoros[x].getPosx());
               
               TiempoExplosion();
               tiempoExplosion.start();
               marcadorMeteoro.Cambiar();
                
               }
           }
          

          
      if(meteoros[x].getPosy()>720)
      {
      x++;
      if(x<26)
      {
       meteoros[x].setVisible(true);
      }
      }
      
      if(marcadorMeteoro.getPuntaje()==25)
      {
          tiempoMeteoro.stop();
          tiempoBala.stop();
          x=0;
          turno=false;
          marcadorMeteoro.setVisible(false);
          nave.setVisible(false);
          balas.setVisible(false);
          universo.setVisible(false);
          gane.setVisible(true);
          ok.setVisible(true);
          setSize(710,460);
          setLocationRelativeTo(null);
          
      }
      
       if((meteoros[x].isVisible()==true)&&(meteoros[x].getPosy()==500))
      {
          
          turno=false;
          marcadorMeteoro.setVisible(false);
          nave.setVisible(false);
          balas.setVisible(false);
          universo.setVisible(false);
          perdi.setVisible(true);
          ok.setVisible(true);
          setSize(710,460);
          setLocationRelativeTo(null);
          tiempoMeteoro.stop();
          tiempoBala.stop();
          x=0;
          
      }
      
      
      
 
      
      }       
      }); 
      
         
        
    }
    
    public void initComponents()
    {
                
                this.setLayout(null);
                this.setTitle("Meteoro Crash");
	   	this.setVisible(true);
                this.addKeyListener(this);
		this.setSize(870,547);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
                this.jugar= new JButton("");
		this.jugar.setIcon(new ImageIcon( "imagenes//jugar.png" ) );
		this.jugar.setVisible(true);
		this.jugar.reshape(580,150,250,40);
                this.jugar.addKeyListener(this);
                this.jugar.addActionListener(this);
		this.add(jugar);
		
	        this.salir= new JButton("");
		this.salir.setIcon(new ImageIcon( "imagenes//salir.png" ) );
		this.salir.setVisible(true);
		this.salir.reshape(580,300,250,40);
                this.salir.addKeyListener(this);
                this.salir.addActionListener(this);
		this.add(salir);
                
                this.ok= new JButton("");
		this.ok.setIcon(new ImageIcon( "imagenes//final//ok.png" ) );
		this.ok.setVisible(false);
		this.ok.reshape(620,330,50,40);
                this.ok.addKeyListener(this);
                this.ok.addActionListener(this);
		this.add(ok);
                
                this.fondo.reshape(0,0,860,510);
                this.fondo.setVisible(true);
                this.fondo.addKeyListener(this);
		this.add(this.fondo);
                
                this.gane.reshape(0,0,700,425);
                this.gane.setVisible(false);
                this.gane.addKeyListener(this);
		this.add(this.gane);
                
                this.perdi.reshape(0,0,700,425);
                this.perdi.setVisible(false);
                this.perdi.addKeyListener(this);
		this.add(this.perdi);
                
                
                this.nave= new Nave(250,580);
                this.setVisible(true);
                add(this.nave);
                
                this.marcadorMeteoro= new MarcadorMeteoro(1300,800);
                this.marcadorMeteoro.setVisible(true);
                add(this.marcadorMeteoro);
                
                this.balas=new Balas(0, -100);
                this.add(this.balas);
                balas.addKeyListener(this);
                
                this.meteoros= new Meteoros[26];
                for(int a=0;a<26;a++){
                this.meteoros[a]=new Meteoros();
                this.add(this.meteoros[a]);
                meteoros[a].addKeyListener(this);
                }
                
                this.explosion.reshape(0,0,860,510);
                this.explosion.setVisible(false);
                this.explosion.addKeyListener(this);
		this.add(this.explosion);
                
                this.universo.reshape(0,0,750,800);
                this.universo.setVisible(true);
                this.universo.addKeyListener(this);
		this.add(this.universo);
                
		
                   }
  
    
      	public void keyTyped (KeyEvent e)
	{
	}
	public void keyReleased(KeyEvent e)
	{
	}
        public void keyPressed (KeyEvent e)
        {
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
        if(nave.getPosx()>10)
        {
        this.nave.avanzarInquierda();
        }
             
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
        if(nave.getPosx()<450)
        {
        this.nave.avanzarDerecha(); 
        }     
        }
        
         if(e.getKeyCode() == KeyEvent.VK_A){
         
         
         if(turno==true)
         {
         playExplosion.ReproducirExplosion();    
                 
         this.posicionX=( nave.getPosx()+45);
         this.posicionY=500;
         this.balas=new Balas(posicionX, posicionY);
         this.add(this.balas);
         this.balas.addKeyListener(this);
         this.balas.setVisible(true);
         balas.reshape(posicionX,posicionY , 32, 70 );
         
           this.universo.reshape(0,0,750,800);
           this.universo.setVisible(true);
           this.add(this.universo);
         
           
           tiempoBala = new Timer (1, new ActionListener(){
           public void actionPerformed(ActionEvent e){
                      
     
          balas.avanzar();     
          
           if(balas.getPosy()==meteoros[x].getPosy())
           {
               
               
               if((balas.getPosx()<=meteoros[x].getSubPosx())&&(balas.getSubPosx()>=meteoros[x].getPosx())&&(balas.isVisible()==true))
               {
               meteoros[x].setVisible(false);
               balas.setVisible(false);
               
               posicionY=500;
               posicionExplosionY=meteoros[x].getPosy();
               posicionExplosionX=(meteoros[x].getPosx());
               
               TiempoExplosion();
               tiempoExplosion.start();
               marcadorMeteoro.Cambiar();
                
               }
           }
          
          if(balas.getPosy()<-115)
           {              
            turno=true;  
            tiempoBala.stop();
           }        

           
           else
           {
            turno=false;
           }
                      
                      
                  }});    
                  
           tiempoBala.start();
           }
                
           
           
    
        }    
        }
        public void actionPerformed(ActionEvent e)
	{
            if(e.getSource()==jugar)
            {
                          
            this.jugar.reshape(1000,150,250,40);
            this.salir.setVisible(false);
            this.fondo.setVisible(false);
            this.setSize(750,750);
            this.nave.addKeyListener(this);
            this.setLocationRelativeTo(null);
            tiempoMeteoro.start();
            play.ReproducirSonido();
            }
            if(e.getSource()==salir)
            {
                System.exit(0);
            }
            
            if(e.getSource()==ok)
            {
                System.exit(0);
            }
        }
        
        
        
    public void TiempoExplosion()
    {
       tiempoExplosion = new Timer (10, new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
         
          
        if(exploit<50)
        {
        explosion.reshape(posicionExplosionX,posicionExplosionY,150,230);
        explosion.setVisible(true);
        }
        else
        {explosion.setVisible(false);
        tiempoExplosion.stop();
        
            exploit=0;
        }
        exploit++;
        
      
	   
          
      }       
      }); 
    }
    
}
