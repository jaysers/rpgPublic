import javax.imageio.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.*;

public class Sprite {
	
	ImageIcon icon;
	
	public Sprite(String path){
		
		File img = new File(path);
		try{
			BufferedImage buffImg = ImageIO.read(img);
			this.icon = new ImageIcon(buffImg);
	    }
		catch(IOException e){
		  e.printStackTrace();
		}		
	  
	}
	
}

class Text_Img{
	
  private ImageIcon icon;
  
  public Text_Img(String text, Font font){
	  
	int length = text.length();
	
	BufferedImage bi0 = new BufferedImage(1, 1, BufferedImage.TYPE_USHORT_GRAY);
	
	FontMetrics metrics = bi0.getGraphics().getFontMetrics(font);
	int width = metrics.stringWidth(text);
	int height = metrics.getHeight();
    
    BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    
    forceFill(bi, new Color(0, 0, 0, 0));
    
    bi.getGraphics().setFont(font);
    bi.getGraphics().setColor(Color.WHITE);    
    bi.getGraphics().drawString(text, height, width);
    bi.getGraphics().dispose();
    
    icon = new ImageIcon(bi);
    
  }
  
  private void forceFill(BufferedImage img, Color color) {
	  
	int rgb = color.getRGB() + color.getAlpha() << 24;
	  
    for(int x = 0; x < img.getWidth(); x++) {
     for(int y = 0; y < img.getHeight(); y++) { 
		 
      img.setRGB(x, y, rgb); 
      
     } 
    }
    
  }
  
  public ImageIcon getIcon(){
    
    return(icon);
    
  }
  
}

