import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.awt.*;

public class student extends JFrame implements ActionListener
{
JTextField txt_id,txt_name,txt_age,txt_course,txt_semester,txt_tutor;
JLabel lbl_title,lbl_id,lbl_name,lbl_age,lbl_course,lbl_semester,lbl_tutor;
JButton btn_insert,btn_delete,btn_update,btn_clear,btn_search;

public student()
{
lbl_title=new JLabel("Student Information");
lbl_id=new JLabel("Id");
lbl_name=new JLabel("Name");
lbl_age=new JLabel("Age");
lbl_course=new JLabel("Course");
lbl_semester=new JLabel("Semester");
lbl_tutor=new JLabel("Tutor"); 

txt_id=new JTextField(20);
txt_name=new JTextField(20);

txt_age=new JTextField(20);
txt_course=new JTextField(20);
txt_semester=new JTextField(20);
txt_tutor=new JTextField(20);

btn_insert=new JButton("Insert");
btn_delete=new JButton("Delete");
btn_update=new JButton("Update");
btn_clear=new JButton("Clear");
btn_search=new JButton("Search");

btn_insert.addActionListener(this);
btn_delete.addActionListener(this);
btn_update.addActionListener(this);
btn_clear.addActionListener(this);
btn_search.addActionListener(this);

JPanel p1,p2,p3;

p1=new JPanel();
p1.setLayout(new FlowLayout());
p1.add(lbl_title);

p2=new JPanel();
p2.setLayout(new GridLayout(6,2));
p2.add(lbl_id);
p2.add(txt_id);
p2.add(lbl_name);
p2.add(txt_name);
p2.add(lbl_age);
p2.add(txt_age);
p2.add(lbl_course);
p2.add(txt_course);
p2.add(lbl_semester);
p2.add(txt_semester);
p2.add(lbl_tutor);
p2.add(txt_tutor);


p3=new JPanel();
p3.setLayout(new FlowLayout());
p3.add(btn_insert);
p3.add(btn_delete);
p3.add(btn_update);
p3.add(btn_clear);
p3.add(btn_search);


Container c=getContentPane();
c.setLayout(null);
p1.setBounds(20,20,300,40);
p2.setBounds(10,80,200,320);
p3.setBounds(10,400,300,80);

c.add(p1);
c.add(p2);
c.add(p3);
}

public void actionPerformed(ActionEvent ae)
{
String btn=ae.getActionCommand();
if(btn.equals("Clear"))
{

txt_id.setText("");
txt_name.setText("");
txt_age.setText("");
txt_course.setText("");
txt_semester.setText("");
txt_tutor.setText("");
}
if(btn.equals("Search"))
{
	
String id=txt_id.getText();
 try {

            BufferedReader br = null;
			String strLine = "";
br = new BufferedReader( new FileReader("st.txt"));
            while( (strLine = br.readLine()) != null){
				String[] splited = strLine.split("\\s+");
				//System.out.println(splited[0]+" "+s1);
				if(splited[0].equals(id)){
txt_name.setText(splited[1]);
txt_age.setText(splited[2]);
txt_course.setText(splited[3]);
txt_semester.setText(splited[4]);
txt_tutor.setText(splited[5]);
					}			
				}
 }
	 catch(Exception e){
		 
	 }

}
if(btn.equals("Update"))
{
String s1=txt_id.getText();
String s2=txt_name.getText();
String s3=txt_age.getText();
String s4=txt_course.getText();
String s5=txt_semester.getText();
String s6=txt_tutor.getText();
}
if(btn.equals("Delete"))
{
	try{
String s1=txt_id.getText();
            File inFile = new File("st.txt");

			File tempFile = new File("st2.txt");


            //BufferedReader br = new BufferedReader(new FileReader(inFile));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            BufferedReader br = null;
			String strLine = "";
br = new BufferedReader( new FileReader(inFile));
            while( (strLine = br.readLine()) != null){
				String[] splited = strLine.split("\\s+");
				if(!splited[0].equals(s1)){
				pw.println(strLine);
                    pw.flush();	
				}
            }
            pw.close();
            br.close();
			boolean successful = tempFile.renameTo(inFile);
			/*
			String fileName = "MyFile.txt";

try {
    Files.move(new File(fileName).toPath(), new File(fileName).toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
} catch (IOException ex) {
    Logger.getLogger(SomeClass.class.getName()).log(Level.SEVERE, null, ex);
}
			*/
        System.out.println(successful); 
			
	
	}catch(Exception e){
		
	}
}
if(btn.equals("Insert"))
{
String s1=txt_id.getText();
String s2=txt_name.getText();
String s3=txt_age.getText();
String s4=txt_course.getText();
String s5=txt_semester.getText();
String s6=txt_tutor.getText();
try{
	
	String filename= "st.txt";
    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
    //fw.seek(0);
	fw.write(s1+" "+s2+" "+s3+" "+s4+" "+s5+" "+s6);//appends the string to the file
	fw.write("\r\n");
    fw.close();
JOptionPane.showMessageDialog(null,"Successfully Inserted");
txt_id.setText("");
txt_name.setText("");
txt_age.setText("");
txt_course.setText("");
txt_semester.setText("");
txt_tutor.setText("");
}
catch(Exception ex)
{
}

}



}

public static void main(String args[])
{
student stud=new student();
stud.setVisible(true);
stud.addWindowListener(new WindowAdapter()
{ 
public void windowClosing(WindowEvent e)
{ 
System.exit(0); 
} 
});
stud.setSize(new Dimension(400,520));
}
}