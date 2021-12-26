import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import java.awt.ActiveEvent;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.math.*;
public class Games extends JPanel {
	Image bg;
	Image wall;
	Playerdog playerdog;
	Playercat playercat;
	Bone bone;
	boolean isRight;
	boolean itemRight;
	Timer t1,t2;
	int bn,ck;
	int power;
	static int hpDog=100;
	static int hpCat=100;
	static int damage=0;
	static int num_x2=1;
	static int over=0;
	static int w=200;
	static int wind;
	int cw=0;
	
		
	public Games(){
		bg=new ImageIcon("bgg.png").getImage();
		wall=new ImageIcon("wall.png").getImage();
		JLabel ih=new JLabel(new ImageIcon("heal.png"));
		JLabel ib=new JLabel(new ImageIcon("bomb.png"));
		JLabel ix2=new JLabel(new ImageIcon("x2.png"));
		JLabel ip=new JLabel(new ImageIcon("power.png"));
		JLabel ihr=new JLabel(new ImageIcon("heal.png"));
		JLabel ibr=new JLabel(new ImageIcon("bomb.png"));
		JLabel ix2r=new JLabel(new ImageIcon("x2.png"));
		JLabel ipr=new JLabel(new ImageIcon("power.png"));
		ih.setBounds(60, 100, 50, 50);
		ib.setBounds(120, 100, 50, 50);
		ix2.setBounds(180, 100, 50, 50);
		ip.setBounds(240, 100, 50, 50);
		ihr.setBounds(700, 100, 50, 50);
		ibr.setBounds(760, 100, 50, 50);
		ix2r.setBounds(820, 100, 50, 50);
		ipr.setBounds(880, 100, 50, 50);
		add(ibr);
		add(ix2r);
		add(ipr);
		add(ihr);
		add(ib);
		add(ix2);
		add(ip);
		add(ih);
	
		
		playerdog = new Playerdog();
		playercat = new Playercat(); 
		
		power=0;
		bn=0;
		ck=1;
		isRight=true;
		itemRight=true;
		wind=(int)(Math.random()*(10)-5);
	
		Timer t3 = new Timer(33,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isRight){
					
					if(ck==1){
					ix2r.addMouseListener(new MouseAdapter(){
						public void mouseClicked(MouseEvent e){
							ck=0;
							num_x2=2;
							System.out.println("pass"+ck+itemRight);
							remove(ix2r);
					}
				});
					}
					if(ck==1){
					ihr.addMouseListener(new MouseAdapter(){
						public void mouseClicked(MouseEvent e){
		
							hpDog+=30;
							if (hpDog>=100)
								hpDog=100;
							ck=0;
							System.out.println("pass");
							remove(ihr);
					}
				});
					}
					if(ck==1){
					ipr.addMouseListener(new MouseAdapter(){
						public void mouseClicked(MouseEvent e){
			
							damage=50;
							ck=0;	
							System.out.println("passDa");
							remove(ipr);
					}
				});
					}
					if(ck==1){
					ibr.addMouseListener(new MouseAdapter(){
						public void mouseClicked(MouseEvent e){
				
							ck=0;
							cw=1;
							System.out.println("pass");
							remove(ibr);
							
							
					}
				});
						} 
					}
					if(isRight==false){
					ih.addMouseListener(new MouseAdapter(){
						public void mouseClicked(MouseEvent e){
						
						hpCat+=30;
						if (hpCat>=100)
							hpCat=100;
							ck=1;
							System.out.println("pass");
							remove(ih);		
						}
					});
						ib.addMouseListener(new MouseAdapter(){
						public void mouseClicked(MouseEvent e){
							ck=1;
							cw=1;
							System.out.println("pass");
							remove(ib);	
							}
						});
					
						ip.addMouseListener(new MouseAdapter(){
						public void mouseClicked(MouseEvent e){
							damage=50;
							ck=1;
							System.out.println("pass");
							remove(ip);
							}
						});
						ix2.addMouseListener(new MouseAdapter(){
						public void mouseClicked(MouseEvent e){
							System.out.println("pass");
							num_x2=2;
							remove(ix2);
				
							ck=1;
							}
						});
					}
			}
		});
		t3.start();
		
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				if (e.getX()>500&&e.getY()>350){
						if(isRight){
						playerdog.img=new ImageIcon("dog1.png").getImage();
						t2 = new Timer(33,new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								power+=1;
								

							}
						});	
						t2.start();
						}
					}
				else if (e.getX()<480&&e.getY()>350){
						if(isRight==false){
						playercat.img=new ImageIcon("cat1.png").getImage();
						t2 = new Timer(33,new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								power+=1;
							}
						});	
						t2.start();
						}			
				}
			}
			public void mouseReleased(MouseEvent e) {
				t2.stop();
				
				if(isRight){
			   		if (e.getX()>500&&e.getY()>350){
						System.out.println("clickDog"+power);
						if (cw==1){
							bone = new Bone(playerdog,power,200);
							System.out.println("cw="+cw);
							cw=0;
						}else if(cw==0){
							for(int i=1;i<=num_x2;i++){
							bone = new Bone(playerdog,power);
						}
						wind=(int)(Math.random()*10)-5;
						System.out.println("wind"+wind);
						
						
						}
						num_x2=1;
						
						
						power=0;
						
		  				System.out.println("clickedDog");
						bn=1;
						
						System.out.println("clickDog"+ck);
						playerdog.img=new ImageIcon("dog.png").getImage();
						isRight=false;
						//t4.start();
						
					}
					
				}
				else if (e.getX()<480&&e.getY()>350){
					System.out.println("clickcat"+power);
					if (cw==1){
						bone = new Bone(playercat,power,200);
						System.out.println("cw="+cw);
						cw=0;
					}else if(cw==0){
						for(int i =1;i<= num_x2;i++){
							bone = new Bone(playercat,power);
							}
						wind=(int)(Math.random()*10)-5;
						System.out.println("wind"+wind);

					}
					num_x2=1;
					power=0;
					System.out.println("clickedCat");
					
					bn=1;
					
					playercat.img=new ImageIcon("cat2.png").getImage();
					playercat.img=new ImageIcon("cat.png").getImage();
					isRight=true;
					
					System.out.println("cat"+ck+itemRight);
					
				}
			}
		});
		setLayout(null);
		setSize(Windows.windows.getWidth(), Windows.windows.getHeight());
		t1 = new Timer(33,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(hpDog<=0){
					over=1;
				}
				else if(hpCat<=0){
					over=2;
				}
				Windows.windows.repaint();
			}
		});	
		t1.start();
	}
	protected  void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, 1000,625,this);
		g.drawImage(wall, 480, 375, 40, 299, this);
		g.setColor(Color.GRAY);
		g.fillRect(50, 30, 400, 30);
		g.fillRect(550, 30,400, 30);
		g.fillRect(100, 515, 100, 15);
		g.fillRect(750, 515, 100, 15);
		
		g.setColor(Color.GREEN);
		g.fillRect(50, 30, hpCat*4, 30);
		g.fillRect(550, 30,hpDog*4, 30);
		//g.setColor(Color.BLUE);
		//g.fillRect(450, 80, 100, 20);

		
		if(isRight){
			if(wind<=0){
			g.setColor(Color.GRAY);
			g.fillRect(450, 80, 50, 20);
			g.fillRect(500, 80, 50, 20);
			g.setColor(Color.BLUE);
			g.fillRect(500, 80, Math.abs(wind*10), 20);
			
			}
			else{
			g.setColor(Color.GRAY);
			g.fillRect(500, 80, 50, 20);
			g.setColor(Color.BLUE);
			g.fillRect(450, 80, 50, 20);
			g.setColor(Color.GRAY);
			g.fillRect(450, 80, 50-wind*10, 20);
			}
			g.setColor(Color.RED);
			g.fillRect(750, 515,power*3, 15);
			
		}
		else {
			if(wind>=0){
			g.setColor(Color.GRAY);
			g.fillRect(450, 80, 50, 20);
			g.fillRect(500, 80, 50, 20);
			g.setColor(Color.BLUE);
			g.fillRect(500, 80,wind*10, 20);
			}
			else {
			g.setColor(Color.GRAY);
			g.fillRect(500, 80, 50, 20);
			g.setColor(Color.BLUE);
			g.fillRect(450, 80,50, 20);
			g.setColor(Color.GRAY);
			g.fillRect(450, 80, 50-Math.abs(wind)*10, 20);
			}
			g.setColor(Color.RED);
			g.fillRect(100, 515,power*3, 15);
		} 
			
		g.setColor(Color.WHITE);
		g.drawRect(50, 30, 400, 30);
		g.drawRect(550, 30, 400, 30);
		g.drawRect(450, 80, 50, 20);
		g.drawRect(500, 80, 50, 20);
		g.drawRect(100, 515, 100, 15);
		g.drawRect(750, 515, 100, 15);
		
		
		
		
		g.drawImage(playerdog.getImage(), playerdog.getX(), playerdog.getY(),playerdog.getWidth(),playerdog.getHeight(),this);
		g.drawImage(playercat.getImage(), playercat.getX(), playercat.getY(),playercat.getWidth(),playercat.getHeight(),this);
		if (bn==1){
			g.drawImage(bone.getImage(), bone.getX(), bone.getY(),bone.getWidth(),bone.getHeight(),this);
		}
		if(hpDog<=0){
			Windows.windows.remove(Windows.windows.game);
			if(Windows.windows.end==null){
				Windows.windows.end=new End(2);
			}
			t1.stop();
			Windows.windows.add(Windows.windows.end);
			Windows.windows.end.requestFocusInWindow();
			Windows.windows.repaint();
		}
		if(hpCat<=0){
			Windows.windows.remove(Windows.windows.game);
			if(Windows.windows.end==null){
				Windows.windows.end=new End(1);
			}
			t1.stop();
			Windows.windows.add(Windows.windows.end);
			Windows.windows.end.requestFocusInWindow();
			Windows.windows.repaint();		}
		
	}					


	
}






