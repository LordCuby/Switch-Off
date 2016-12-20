package game;
import java.awt.*; 
import java.applet.*;  
import java.awt.event.*;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.MouseInfo;

public class SwitchOff extends Applet{
	int xpos, ypos, size = 100;

	int [] xcord = {0, size, size*2};
	int [] ycord = {0, size, size*2};
	int [][] lights = {{0,0,1}, {0,1,1}, {1,1,1}};
	boolean win;
	
	public void init() {

		

		xpos = 0;
		ypos = 0;
		size = 100;
		setBackground(Color.black);
		
		addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent event) {
				int xpos=event.getX();
			    int ypos=event.getY();
			    boolean fort = true;
			    int n = -1;
			    
			    while (fort){	    	
			    	if (n < 4){
			    	n++;
			    	}
			    	else{
			    		fort = false;
			    	}

			    	if (xpos > xcord[n] && xpos < xcord[n]+size){
			    				System.out.println("x: "+n);
			    				fort = false;
			    							
			    	}
			    	
			    }
			    boolean fort2 = true;
			    int m = -1;
			    
			    while (fort2){		
					if (m < 4){
				    	m++;
				    	}
				    	else{
				    		fort2 = false;
				    	}
					if (ypos > ycord[m] && ypos < ycord[m]+size){
							System.out.println("y: "+m);
							if (lights[m][n] == 0){
								lights[m][n] = 1;
							}else{lights[m][n] = 0;}

							if (m < 2){
								if (lights[m+1][n] ==1) {lights[m+1][n] = 0;}
								else {lights[m+1][n] = 1;}
							}
							if (m > 0){
								if (lights[m-1][n] ==1) {lights[m-1][n] = 0;}
								else {lights[m-1][n] = 1;}
							}
							if (n < 2){
								if (lights[m][n+1] ==1) {lights[m][n+1] = 0;}
								else {lights[m][n+1] = 1;}
							}
							if (n > 0){
								if (lights[m][n-1] ==1) {lights[m][n-1] = 0;}
								else {lights[m][n-1] = 1;}
							}
								
								
								fort2 = false;
								repaint();
							
							
					}
					
				}
			   
		}
		});	
	}

	
	public void paint(Graphics g) {
		this.setSize(size*3, size*3);
		int xLight = -1;
		for (int i = 0; i <= (size*2); i+=size){
			xpos = i;
			xLight ++;
			int yLight = -1;
			for (int j = 0; j <= (size*2); j+=size){
				ypos = j;
				yLight ++;
				
				if (lights[yLight][xLight] == 1){
					paintLightON(g);
				}
				else{
					paintLightOFF(g);
				}

			}
			win = true;
			
			for (int w = 0; w < 3; w++){
				if (lights[0][w] == 0){
					win = false;
					
				}else if (lights[1][w] == 0){
					win = false;
					
				}else if (lights[2][w] == 0){
					win = false;
				}
				
			}
			if (win = true){
				System.out.println("Du vann!");
			}
		}

	}

	private void paintLightON(Graphics g){
		g.setColor(Color.yellow);
		g.fillRect(xpos, ypos,size, size);
		g.setColor(Color.black);
		g.drawRect(xpos, ypos, size, size);
		
	}
	
	private void paintLightOFF(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(xpos, ypos,size, size);
		g.setColor(Color.black);
		g.drawRect(xpos, ypos, size, size);
		
	}
}
