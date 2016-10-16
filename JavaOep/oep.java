import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.*;

public class oep extends JFrame implements ActionListener
{
JTextField txt_name,txt_event,txt_year;
JLabel lbl_title,lbl_name,lbl_event,lbl_year;

JButton btn_create;

public oep()
{
lbl_title=new JLabel("Certi Creation!");

lbl_name=new JLabel("Name");
lbl_event=new JLabel("Event Name");
lbl_year=new JLabel("Year");

txt_name=new JTextField(30);
txt_event=new JTextField(20);
txt_year=new JTextField(20);


btn_create=new JButton("Create");

btn_create.addActionListener(this);


JPanel p1,p2,p3;

p1=new JPanel();
p1.setLayout(new FlowLayout());
p1.add(lbl_title);

p2=new JPanel();
p2.setLayout(new GridLayout(3,2));

p2.add(lbl_name);
p2.add(txt_name);

p2.add(lbl_event);
p2.add(txt_event);

p2.add(lbl_year);
p2.add(txt_year);


p3=new JPanel();
p3.setLayout(new FlowLayout());
p3.add(btn_create);


Container c=getContentPane();
c.setLayout(null);
p1.setBounds(20,20,250,40);
p2.setBounds(10,80,200,120);
p3.setBounds(10,200,300,40);

c.add(p1);
c.add(p2);
c.add(p3);
}

public void actionPerformed(ActionEvent ae)
{
String btn=ae.getActionCommand();

if(btn.equals("Create"))
{
String s1=txt_name.getText();
String s2=txt_event.getText();
String s3=txt_year.getText();
if(s1 != null && !s1.isEmpty() && s2 != null && !s2.isEmpty() && s3 != null && !s3.isEmpty() ){
	try{
Certi c = new Certi(s1,s2,s3);
}
catch(IOException e)
{
JOptionPane.showMessageDialog(null,"Error");
	System.out.println("Error"+e);
}
txt_name.setText("");
txt_event.setText("");
txt_year.setText("");

	}

else{
	JOptionPane.showMessageDialog(null,"Plz Fill all info!");
}
}

}

public static void main(String args[])
{
oep stud=new oep();
stud.setVisible(true);
stud.addWindowListener(new WindowAdapter()
{ 
public void windowClosing(WindowEvent e)
{ 
System.exit(0); 
} 
});
stud.setSize(new Dimension(300,300));
}
}
