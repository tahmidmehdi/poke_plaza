//PokeMatch
//By: Tahmid Mehdi, Ryan Del Genio, Cole Stichhaller
//The user has to click 2 buttons, if the images on the buttons match, then the buttons get removed, they have to remove every button
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Matching extends Applet implements ActionListener
{
    //button & image arrays
    JButton[] btn=new JButton[12];
    ImageIcon[] img=new ImageIcon[6];
    
    JButton button=new JButton("");
    //images
    ImageIcon img0=new ImageIcon("pikachu.GIF");
    ImageIcon img1=new ImageIcon("charizard.GIF");
    ImageIcon img2=new ImageIcon("squirtle.GIF");
    ImageIcon img3=new ImageIcon("blastoise.GIF");
    ImageIcon img4=new ImageIcon("arbok.GIF");
    ImageIcon img5=new ImageIcon("mewtwo.GIF");
    //grid layout
    GridLayout grid=new GridLayout(3, 4);
    //random numbers
    int r1, r2, r3, r4, r5, r6, p0, p1, p2 ,p3 , p4, p5, p6, p7, p8, p9, p10, p11;
    //number of clicks
    int clicks=0;
    //background image
    Image bg;
    ImageIcon bgIcon=new ImageIcon("pokemonbg.jpg");

    public void init()
    {
	setLayout(grid);
	//background gets image
	bg=bgIcon.getImage();
	//randomize numbers & set images to image array
	r1=(int)(Math.random()* 6 + 0);
	do{
	    r2=(int)(Math.random()* 6 + 0);
	}while(r2==r1);
	do{
	    r3=(int)(Math.random()* 6 + 0);
	}while(r3==r1||r3==r2);
	do{
	    r4=(int)(Math.random()* 6 + 0);
	}while(r4==r1||r4==r2||r4==r3);
	do{
	    r5=(int)(Math.random()* 6 + 0);
	}while(r5==r1||r5==r2||r5==r3||r5==r4);
	do{
	    r6=(int)(Math.random()* 6 + 0);
	}while(r6==r1||r6==r2||r6==r3||r6==r4||r6==r5);
	
	img[r1]=img0;
	img[r2]=img1;
	img[r3]=img2;
	img[r4]=img3;
	img[r5]=img4;
	img[r6]=img5;
	//instantiate buttons in array & add listeners
	for(int i=0; i<btn.length; i++)
	{
	    JButton button=new JButton("");
	    btn[i]=button;

	    btn[i].addActionListener(this);
	}
	//randomize the position of the buttons
	p0=(int)(Math.random()* 12 + 0);
	do{
	    p1=(int)(Math.random()* 12 + 0);
	}while(p1==p0);
	do{
	    p2=(int)(Math.random()* 12 + 0);
	}while(p2==p0||p2==p1);
	do{
	    p3=(int)(Math.random()* 12 + 0);
	}while(p3==p0||p3==p1||p3==p2);
	do{
	    p4=(int)(Math.random()* 12 + 0);
	}while(p4==p0||p4==p1||p4==p2||p4==p3);
	do{
	    p5=(int)(Math.random()* 12 + 0);
	}while(p5==p0||p5==p1||p5==p2||p5==p3||p5==p4);
	do{
	    p6=(int)(Math.random()* 12 + 0);
	}while(p6==p0||p6==p1||p6==p2||p6==p3||p6==p4||p6==p5);
	do{
	    p7=(int)(Math.random()* 12 + 0);
	}while(p7==p0||p7==p1||p7==p2||p7==p3||p7==p4||p7==p5||p7==p6);
	do{
	    p8=(int)(Math.random()* 12 + 0);
	}while(p8==p0||p8==p1||p8==p2||p8==p3||p8==p4||p8==p5||p8==p6||p8==p7);
	do{
	    p9=(int)(Math.random()* 12 + 0);
	}while(p9==p0||p9==p1||p9==p2||p9==p3||p9==p4||p9==p5||p9==p6||p9==p7||p9==p8);
	do{
	    p10=(int)(Math.random()* 12 + 0);
	}while(p10==p0||p10==p1||p10==p2||p10==p3||p10==p4||p10==p5||p10==p6||p10==p7||p10==p8||p10==p9);
	do{
	    p11=(int)(Math.random()* 12 + 0);
	}while(p11==p0||p11==p1||p11==p2||p11==p3||p11==p4||p11==p5||p11==p6||p11==p7||p11==p8||p11==p9||p11==p10);
	
	add(btn[p0]);
	add(btn[p1]);
	add(btn[p2]);
	add(btn[p3]);
	add(btn[p4]);
	add(btn[p5]);
	add(btn[p6]);
	add(btn[p7]);
	add(btn[p8]);
	add(btn[p9]);
	add(btn[p10]);
	add(btn[p11]);

    }
//buttons----------------------------------------------------------
    public void actionPerformed(ActionEvent ae)
    {
	/*if they click twice it takes them here
	the buttons lose their image*/
	if(clicks==0)
	{
	    for(int b=0; b<btn.length; b++)
	    {
		btn[b].setIcon(null);
	    }
	}
	/*if a button is clicked, an icon appears on it
	the program searches for a button that has the same icon
	if it finds one, than it removes the buttons*/
	if(ae.getSource()==btn[0])
	{
	    btn[0].setIcon(img[0]);

		for(int b2=1; b2<btn.length; b2++)
		{
		    if(btn[0].getIcon()==btn[b2].getIcon())
		    {
			//delay 1sec
			try { Thread.currentThread().sleep(1000); }
			catch ( Exception e ) { }
			remove(btn[0]);
			remove(btn[b2]);
		    }
		}
	    
	}
	if(ae.getSource()==btn[1])
	{
	    btn[1].setIcon(img[1]);

		for(int b2=0; b2<btn.length; b2++)
		{
		    if(b2==1)
		    {
			b2++;
		    }
		    
		    if(btn[1].getIcon()==btn[b2].getIcon())
		    {
			try { Thread.currentThread().sleep(1000); }
			catch ( Exception e ) { }
			remove(btn[1]);
			remove(btn[b2]);
		    }
		}
	}
	if(ae.getSource()==btn[2])
	{
	    btn[2].setIcon(img[2]);

		for(int b2=0; b2<btn.length; b2++)
		{
		    if(b2==2)
		    {
			b2++;
		    }
		
		    if(btn[2].getIcon()==btn[b2].getIcon())
		    {
			try { Thread.currentThread().sleep(1000); }
			catch ( Exception e ) { }
			remove(btn[2]);
			remove(btn[b2]);
		    }
		}
	}
	if(ae.getSource()==btn[3])
	{
	    btn[3].setIcon(img[3]);

		for(int b2=0; b2<btn.length; b2++)
		{
		    if(b2==3)
		    {
			b2++;
		    }
		
		    if(btn[3].getIcon()==btn[b2].getIcon())
		    {
			try { Thread.currentThread().sleep(1000); }
			catch ( Exception e ) { }
			remove(btn[3]);
			remove(btn[b2]);
		    }
		}
	}
	if(ae.getSource()==btn[4])
	{
	    btn[4].setIcon(img[4]);
 
		for(int b2=0; b2<btn.length; b2++)
		{
		    if(b2==4)
		    {
			b2++;
		    }
		
		    if(btn[4].getIcon()==btn[b2].getIcon())
		    {
			try { Thread.currentThread().sleep(1000); }
			catch ( Exception e ) { }
			remove(btn[4]);
			remove(btn[b2]);
		    }
		}
	}
	if(ae.getSource()==btn[5])
	{
	    btn[5].setIcon(img[5]);

		for(int b2=0; b2<btn.length; b2++)
		{
		    if(b2==5)
		    {
			b2++;
		    }
		
		    if(btn[5].getIcon()==btn[b2].getIcon())
		    {
			try { Thread.currentThread().sleep(1000); }
			catch ( Exception e ) { }
			remove(btn[5]);
			remove(btn[b2]);
		    }
		}
	}
	if(ae.getSource()==btn[6])
	{
	    btn[6].setIcon(img[0]);

		for(int b2=0; b2<btn.length; b2++)
		{
		    if(b2==6)
		    {
			b2++;
		    }
		
		    if(btn[6].getIcon()==btn[b2].getIcon())
		    {
			try { Thread.currentThread().sleep(1000); }
			catch ( Exception e ) { }
			remove(btn[6]);
			remove(btn[b2]);
		    }
		}
	}
	if(ae.getSource()==btn[7])
	{
	    btn[7].setIcon(img[1]);

		for(int b2=0; b2<btn.length; b2++)
		{
		    if(b2==7)
		    {
			b2++;
		    }
		
		    if(btn[7].getIcon()==btn[b2].getIcon())
		    {
			try { Thread.currentThread().sleep(1000); }
			catch ( Exception e ) { }
			remove(btn[7]);
			remove(btn[b2]);
		    }
		}
	}
	if(ae.getSource()==btn[8])
	{
	    btn[8].setIcon(img[2]);

		for(int b2=0; b2<btn.length; b2++)
		{
		    if(b2==8)
		    {
			b2++;
		    }
		
		    if(btn[8].getIcon()==btn[b2].getIcon())
		    {
			try { Thread.currentThread().sleep(1000); }
			catch ( Exception e ) { }
			remove(btn[8]);
			remove(btn[b2]);
		    }
		}
	}
	if(ae.getSource()==btn[9])
	{
	    btn[9].setIcon(img[3]);

		for(int b2=0; b2<btn.length; b2++)
		{
		    if(b2==9)
		    {
			b2++;
		    }
		
		    if(btn[9].getIcon()==btn[b2].getIcon())
		    {
			try { Thread.currentThread().sleep(1000); }
			catch ( Exception e ) { }
			remove(btn[9]);
			remove(btn[b2]);
		    }
		}
	}
	if(ae.getSource()==btn[10])
	{
	    btn[10].setIcon(img[4]);

		for(int b2=0; b2<btn.length; b2++)
		{
		    if(b2==10)
		    {
			b2++;
		    }
		
		    if(btn[10].getIcon()==btn[b2].getIcon())
		    {
			try { Thread.currentThread().sleep(1000); }
			catch ( Exception e ) { }
			remove(btn[10]);
			remove(btn[b2]);
		    }
		}
	}
	if(ae.getSource()==btn[11])
	{
	    btn[11].setIcon(img[5]);
 
		for(int b2=0; b2<(btn.length-1); b2++)
		{
		    if(btn[11].getIcon()==btn[b2].getIcon())
		    {
			try { Thread.currentThread().sleep(1000); }
			catch ( Exception e ) { }
			remove(btn[11]);
			remove(btn[b2]);
		    }
		}
	}
	    //if they click 2 buttons, clicks gets assigned 0 so that the ifstatement above the button commands can be used
	    clicks++;
	    if(clicks==2)
	    {
		clicks=0;
	    }
	
	repaint();
    }
    
    public void paint(Graphics g)
    {
	//background image
	g.drawImage(bg, 0, 0, this);
	super.paint(g);
    }
    
}
