import javax.swing.*;
import java.awt.*;

public class Windows extends JFrame  {
	static Windows windows;
	Games game;
	Play play;
	Playerdog playerdog;
	Playercat playercat;
	End end;
	public Windows(){
		windows=this;
		setTitle("cat vs dog");
		setSize(1000,625);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		play=new Play();
		add(play);
		setVisible(true);

		
		
		
	}
	public static void main(String[] args){
		new Windows();
		}
}
