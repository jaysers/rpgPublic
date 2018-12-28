import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Button_MainMenu extends JLabel {
	
	public Button_MainMenu(String text){
		
		super();
		setIcon(new Text_Img(text, new Font("Arial", Font.BOLD, 40)).getIcon());
		setSize(500, 500);
		setLocation(50, 50);
		
	}
}
