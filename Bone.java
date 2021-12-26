import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Bone extends Character{
		int sx;
		double time =0;
		int power;
		double temp,dy,dx,vx,vy;
		static Image imgR = new ImageIcon("bone.png").getImage();
		static Image imgL=new ImageIcon("can.png").getImage();
		
		Bone bone;

		public Bone(Playerdog player,int power) {

			// TODO Auto-generated constructor stub
			bone=this;
			this.power=power;
			x=750;
			y=400;
			
			System.out.println(x+" "+y);
			width=100;
			height=27;
			img = imgR;
	
			t = new Timer(25, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					time=time+0.1;
					vx=power*Math.cos(-45)*-1;
					vy=power*Math.sin(-45);
					temp=-1*(0.5*9.8*time*time);         
					dy=(vy*time)-temp;
					dx=vx*time;
					x=(int)(750+(420*(dx*time/100)));
					y=(int)(400+(320*(dy*time/100)));	
					
					
					if(Windows.windows.game.playercat.getBounds().intersects(getBounds())){

						System.out.println("hit");
						Windows.windows.game.hpCat-=10+Windows.windows.game.damage;
						System.out.println("damage "+Windows.windows.game.damage);
						Windows.windows.game.damage=0;
						t.stop();
					}
					if(x>480&&x<500&&y>=325){
						y++;
						t.stop();
					}
					
					
				}
			});
			t.start();  
		}
		public Bone(Playerdog player,int power,int w) {

			// TODO Auto-generated constructor stub
			bone=this;
			this.power=power;
			x=750;
			y=400;
			
			System.out.println(x+" "+y);
			width=w;
			height=27;
			img = imgR;
	
			t = new Timer(25, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					time=time+0.1;
					vx=power*Math.cos(-45)*-1;
					vy=power*Math.sin(-45);
					temp=-1*(0.5*9.8*time*time);         
					dy=(vy*time)-temp;
					dx=vx*time;
					x=(int)(750+(420*(dx*time/100)));
					y=(int)(400+(320*(dy*time/100)));	
					
					
					if(Windows.windows.game.playercat.getBounds().intersects(getBounds())){

						System.out.println("hit");
						Windows.windows.game.hpCat-=10+Windows.windows.game.damage;
						System.out.println("damage "+Windows.windows.game.damage);
						Windows.windows.game.damage=0;
						t.stop();
					}
					if(x>480&&x<500&&y>=325){
						y++;
						t.stop();
					}
					
					
				}
			});
			t.start();  
		}

		public Bone(Playercat player,int power) {
			// TODO Auto-generated constructor stub

			bone=this;
			this.power=power;
			x=100;
			y=400;
			
			System.out.println(x+" "+y);
			width=100;
			height=27;
			img = imgL;
	
			t = new Timer(25, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					time=time+0.1;
					vx=power*Math.cos(-45);
					vy=power*Math.sin(-45);
					temp=-1*(0.5*9.8*time*time);         
					dy=(vy*time)-temp;
					dx=vx*time;
					x=(int)(100+(420*(dx*time/100)));
					y=(int)(400+(320*(dy*time/100)));

					
					
					if(Windows.windows.game.playerdog.getBounds().intersects(getBounds())){
						System.out.println("hit");
						Windows.windows.game.hpDog-=10+Windows.windows.game.damage;
						System.out.println("damage"+Windows.windows.game.damage);
						Windows.windows.game.damage=0;
						t.stop();
					}
					if(x<460&&x>450&&y>=325){
						y++;
						t.stop();
					}
					
				}
			});
			t.start(); 
		}
			public Bone(Playercat player,int power,int w) {
				// TODO Auto-generated constructor stub

				bone=this;
				this.power=power;
				x=100;
				y=400;
				
				System.out.println(x+" "+y);
				width=w;
				height=27;
				img = imgL;
		
				t = new Timer(25, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						time=time+0.1;
						vx=power*Math.cos(-45);
						vy=power*Math.sin(-45);
						temp=-1*(0.5*9.8*time*time);         
						dy=(vy*time)-temp;
						dx=vx*time;
						x=(int)(100+(420*(dx*time/100)));
						y=(int)(400+(320*(dy*time/100)));

						
						
						if(Windows.windows.game.playerdog.getBounds().intersects(getBounds())){
							System.out.println("hit");
							Windows.windows.game.hpDog-=10+Windows.windows.game.damage;
							System.out.println("damage"+Windows.windows.game.damage);
							Windows.windows.game.damage=0;
							t.stop();
						}
						if(x<460&&x>450&&y>=325){
							y++;
							t.stop();
						}
						
					}
				});
				t.start();  
 
		}
}