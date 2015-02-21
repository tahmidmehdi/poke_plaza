/*You are charizard & you must dodge pokeballs that fly at you, don't hit the black parts!
the user gets a score at the end based on how much pokeballs they dodged
Dodgemon*/

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class DodgemonMedium extends Applet implements MouseListener, MouseMotionListener, KeyListener
{
    //x & y are charizard's coordinates
    int x=800, y=100;
    //X & Y are the pokeballs coordinates
    int X=0, Y;
    //displayed at beginning
    Image img, pokeball, bgTop, bgBottom, lose;
    //random  variable and score
    int random, score;
    //whether it should draw the image or not
    boolean draw=true;
    
    public void init()
    {
	//initialize images, including top & bottom of the background
	img=getImage(getDocumentBase(), "flyingCharizard.gif");
	pokeball=getImage(getDocumentBase(), "pokeball.GIF");
	bgTop=getImage(getDocumentBase(), "bgTop.GIF");
	bgBottom=getImage(getDocumentBase(), "bgBottom.GIF");  
	lose=getImage(getDocumentBase(), "youlose.jpg");
	
	this.requestFocus();
	addMouseListener(this);
	addMouseMotionListener(this);
	addKeyListener(this);
	//randomize y value of pokeball
	random=(int)(Math.random()* 260 + 100);
	Y=random;
    }

    public void keyPressed(KeyEvent ke) 
    {
	//the user controls charizard using the up arrow key
	int key = ke.getKeyCode();
	switch(key) 
	{ 
	    case KeyEvent.VK_UP:
		y-=10;
		break;
	}
	repaint();
    } 
    public void keyReleased(KeyEvent ke)
    {
    
    }
    public void keyTyped(KeyEvent ke)
    {
    
    }
    public void mousePressed(MouseEvent me)
    {
	y=me.getY();
	repaint();
    }
    public void mouseReleased(MouseEvent me)
    {   }
    public void mouseEntered(MouseEvent me)
    {
    }
    public void mouseExited(MouseEvent me)
    {
    }
    public void mouseClicked(MouseEvent me)
    {
	y=me.getY();
	repaint();
    }
    
    public void mouseDragged(MouseEvent me)
    {
	y=me.getY();
	repaint();
    }
    public void mouseMoved(MouseEvent me)
    {

    }

    public void paint(Graphics g) 
    {
	/*if draw is true, all of these pictures are drawn
	charizard moves based on the users click location or how much times they pressed the up arrow key*/
	if(draw)
	{
	    //if nothing is pressed, he constantly moves down
	    y+=3;
	    g.drawImage(img, x, y, this);
	    g.drawImage(pokeball, X, Y, this);
	    g.drawImage(bgTop, 0, 0, this);
	    g.drawImage(bgBottom, 0, 300, this);
	    update();
	}
	//if the user hits the black bars, they lose, score is displayed on the screen, draw becomes false so the images dissappear
	if(y<50||y>250)
	{
	    g.drawImage(lose, 0, 0, this); 
	    g.drawString("Your Score: "+score, 700, 100);
	    draw=false;
	}
	//if the pokeball hits charizard, the user loses, score is displayed, draw becomes false
	if(X>800)
	{
	    /*if the bottom of the pokeball picture touches any location on charizard(not the picture), this code will run
	    the entire charizard picture has a few blank spots so we have determined the y values of the image that has charizard on it*/ 
	    if(((Y+40)<(y+75))&&((Y+40)>(y+25)))
	    {
		g.drawImage(lose, 0, 0, this); 
		draw=false;
		g.drawString("Your Score: "+score, 700, 100);
	    }
	    //if the top of the pokeball picture touches any location on charizard(not the picture), this code will run
	    if((Y>(y+25))&&(Y<(y+75)))
	    {
		g.drawImage(lose, 0, 0, this); 
		draw=false;
		g.drawString("Your Score: "+score, 700, 100);
	    }
	}

    }
    public void update()
    {
	//the pokeballs speed, this depends on the difficulty
	X+=15;
	//if the pokeball leaves the screen it comes back at a random y value, score is increased every time a pokeball passes the screen
	if(X==900)
	{
	    X=0;
	    random=(int)(Math.random()* 260 + 100);
	    Y=random;
	    score++;
	}
	
    }

}


