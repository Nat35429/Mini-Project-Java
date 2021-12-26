import javax.swing.*;
import java.awt.*;
import java.util.jar.*;
import javax.security.auth.x500.*;

public class Playerdog extends Character{
	int sx;
	Playerdog playerdog;
	
	
	public Playerdog() {
	playerdog = this;
	x=750;
	y=400;
	width=80;
	height=100;
	isdog=true;
	img=new ImageIcon("dog.png").getImage();
	
	}
	public Rectangle getbounds(){
		return new Rectangle(x,y,width,height);
		
	}

}