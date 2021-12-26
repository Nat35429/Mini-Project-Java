import javax.swing.*;
import java.awt.*;


public class Playercat extends Character{
	Playercat playercat;
	 
	public Playercat() {
	playercat = this;
	x=100;
	y=400;
	width=100;
	height=100;
	img=new ImageIcon("cat.png").getImage();
	}
	public Rectangle getbounds(){
		return new Rectangle(x,y,width,height);
			
		}
}
