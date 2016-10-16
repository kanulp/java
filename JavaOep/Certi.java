
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Certi  extends JFrame{

  private JLabel l1,l2,l3;
  public String s1="";
  public String s2="";
  public String s3="";
	
	Certi(String s1,String s2,String s3) throws IOException
	{
		this.s1=s1;
		this.s2=s2;
		this.s3=s3;

	JFrame frame = new JFrame();
    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("ss.jpg")))));
    JLabel label1 = new JLabel(s1);
	JLabel label2 = new JLabel(s2);
	JLabel label3 = new JLabel(s3);
	label1.setFont(new Font("Serif", Font.BOLD, 17));
		label2.setFont(new Font("Serif", Font.BOLD, 17));
	label3.setFont(new Font("Serif", Font.BOLD, 17));

    frame.add(label1);
	frame.add(label2);
	frame.add(label3);
	


    Dimension size = label1.getPreferredSize();
	    Dimension size2 = label2.getPreferredSize();
    Dimension size3 = label3.getPreferredSize();

    label1.setBounds(230, 265, size.width, size.height);
	label2.setBounds(450, 295, size2.width, size2.height);
	label3.setBounds(150, 295, size3.width, size3.height);
    frame.setSize(650, 520);
    frame.setVisible(true);

      Dimension size11 = frame.getSize();
      BufferedImage image = (BufferedImage)frame.createImage(size11.width, size11.height);
      Graphics g = image.getGraphics();
      frame.paint(g);
      g.dispose();
      try
      {
        ImageIO.write(image, "jpg", new File(s1+".jpg"));
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  
public static void main(String args[]) throws IOException{
	
		Certi c = new Certi("Karan Gajjar","3rd year","Relay-Coding");
c.addWindowListener(new WindowAdapter()
{ 
public void windowClosing(WindowEvent e)
{ 
System.exit(0); 
} 
});

    }
}
