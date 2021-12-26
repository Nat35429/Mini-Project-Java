import java.awt.*;
import javax.swing.*;
public class End extends JPanel{
	Games games = new Games();
	Image bgOver;
	static Image dogOver = new ImageIcon("windog.png").getImage();
	static Image catOver=new ImageIcon("wincat.png").getImage();
	
	
	public End(int over){
		setLayout(null);
		setSize(Windows.windows.getWidth(), Windows.windows.getHeight());
		if(over==1){
			bgOver=dogOver;
		}
		else if(over==2){
			bgOver=catOver;
		}
	}
	public void paintComponent(Graphics g){
		
		g.drawImage(bgOver,0,0,1000,625,this);
	}
}