import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.*;


public class Play extends JLabel {
		JLabel pl=new JLabel(new ImageIcon("Play.png"));
	
		Image image;
		
		public Play(){
			image=new ImageIcon("bg.png").getImage();
			setLayout(null);
			setSize(Windows.windows.getWidth(),Windows.windows.getHeight());
			pl.setBounds(250, 350, 500, 200);
			Windows.windows.repaint();
			add(pl);
			pl.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
				        Windows.windows.remove(Windows.windows.play);
				        	if(Windows.windows.game==null){
				        		Windows.windows.game=new Games();
				       		}
				        		Windows.windows.add(Windows.windows.game);
								Windows.windows.game.requestFocusInWindow();		
								Windows.windows.repaint();
				        	}
						});
				
			}	
		protected  void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(image, 0, 0, 1000,625,this);
		}					
	}
