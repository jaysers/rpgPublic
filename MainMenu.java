import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu {
	
	public static void main (String[] args) {
		
	    GraphicsDevice dev = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        dev.setFullScreenWindow(new Wind(Toolkit.getDefaultToolkit().getScreenSize()));
		
	}
	
}

class Wind extends JWindow{
  
  public Wind(Dimension screenSize){

    super();
	setSize(screenSize.width, screenSize.height);
	
	Background background = new Background();
    setContentPane(background);
    
    background.add(new Button_MainMenu("Hello World"));
    
    setVisible(true);

  }
  
}

class Background extends JLabel{
  
  public Background(){
    
    super();
    setIcon(new Sprite("background.jpg").icon);
    setSize(1600, 900);
    setLocation(0, 0);
    
  }
  
  public void changeBackground(String path){
    
    setIcon(new Sprite(path).icon);
    
  }
  
}
