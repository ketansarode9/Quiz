/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package java;
//import dope;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prathitaswar
 */
public class login {
    private static final int H = 500, W = 500;
    JFrame frame;
    JPanel panel;
    
    JButton B1 = new JButton();
    JButton B2 = new JButton();
    JButton B3 = new JButton();
    
    JLabel Label1 = new JLabel();
    JLabel Label2 = new JLabel();
    JLabel Label3 = new JLabel();
    JLabel Label4 = new JLabel();
    
    JTextField text;
    JPasswordField pass;
    
    
    ButtonGroup bGrp = new ButtonGroup();
    JComboBox<String> CBox1=new JComboBox<>();
    
    Connection conn;
    PreparedStatement ps;
    
    login()
    {
        frame = new JFrame();
        frame.setTitle("Quiz");
        frame.setSize(W, H);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);
        
        Label1.setText("Login");
        Label2.setText("Access");
        
        CBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"select", "ADMIN", "USER"}));
        Label3.setText("LoginID");
        Label4.setText("Password");
        
        text = new JTextField();
        text.setText("ID");
        text.addFocusListener(new java.awt.event.FocusListener ()
		{
                        @Override
			public void focusGained(java.awt.event.FocusEvent e) 
			{
                            if(text.getText().equals("ID"))
                            {
                                text.setText("");
                            }
			}
                        @Override
			public void focusLost(java.awt.event.FocusEvent f)
			{
                            if(text.getText().equals(""))
                            {
                            	JOptionPane.showMessageDialog(frame,"PLEASE ENTER A VALID LOGIN ID");
				text.requestFocus();
                            }
			}
		});
        
        
        pass = new JPasswordField();
        pass.setText("password");
        pass.addFocusListener(new java.awt.event.FocusListener ()
		{
                        @Override
			public void focusGained(java.awt.event.FocusEvent e) 
			{
                            if(pass.getText().equals("password"))
                            {
                                pass.setText("");
                            }
			}
                        @Override
			public void focusLost(java.awt.event.FocusEvent f)
			{
                            if(pass.getText().equals(""))
                            {
                            	JOptionPane.showMessageDialog(frame,"PLEASE enter a valid Password");
				pass.requestFocus();
                            }
			}
		});
        
        B1.setText("Submit");
        B1.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent event){
                if (CBox1.getSelectedItem().toString().equals("ADMIN"))
                {
                    Boolean Loginstatus = false;
                    String msg = "";
                    String id;
                    String passwo;
                    
                    try
                    {   
                        //Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb","root","1234");
                        PreparedStatement ps=conn.prepareStatement("SELECT * FROM admin;");
                        ResultSet result=ps.executeQuery();
                            while (result.next()) 
                            {
                                id=result.getString(1);
                                passwo=result.getString(2);
                                
                                if(id.equals(text.getText()) && passwo.equals(pass.getText()))
                                {
                                    Loginstatus=true;
                                }
                            } 
                    }
                    catch(SQLException err)
                    {
                       JOptionPane.showMessageDialog(frame,"INVALID ENTRY"+err.getMessage());
                       Loginstatus=false;
                    }
                    
                    if(Loginstatus){
                        frame.setVisible(false);
                        new Admin();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(frame,"INVALID ENTRY ENTER AGAIN");
                    }
                }
                else if (CBox1.getSelectedItem().toString().equals("USER"))
                {
                    Boolean Loginstatus = false;
                    String msg = "";
                    String id = null;
                    String passwo;
                    
                    try
                    {   
                        //Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","1234");
                        PreparedStatement ps=conn.prepareStatement("SELECT * FROM student;");
                        ResultSet result=ps.executeQuery();
                            while (result.next()) 
                            {
                                id=result.getString(2);
                                passwo=result.getString(4);
                                
                                if(id.equals(text.getText()) && passwo.equals(pass.getText()))
                                {
                                    Loginstatus=true;
                                    break;
                                }
                            } 
                    }
                    catch(SQLException err)
                    {
                       JOptionPane.showMessageDialog(frame,"INVALID ENTRY"+err.getMessage());
                       Loginstatus=false;
                    }
                    
                    if(Loginstatus){
                        frame.setVisible(false);
                        new Quiz(id);
                        text.setText("ID");
                        pass.setText("password");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(frame,"INVALID ENTRY ENTER AGAIN");
                        text.setText("ID");
                        pass.setText("password");
                    }
                }
            }
        });
        
        B2.setText("Clear");
        B2.addActionListener((java.awt.event.ActionEvent evt) -> 
        {
            // jButton2ActionPerformed(evt);
            CBox1.setSelectedIndex(0);
            text.setText("ID");
            pass.setText("password");
        });
        
        B3.setText("SignUp");
        B3.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) 
            {
		frame.setVisible(false);
                new Registration();
            }
        });
        
        Label1.setBounds(250,30,200,30);
        Label2.setBounds(100,100,200,30);
        Label3.setBounds(100,180,200,30);
        Label4.setBounds(100,210,200,30);
        
        B1.setBounds(100,340,100,50);
	B2.setBounds(200,340,100,50);
	B3.setBounds(300,340,100,50);
        
        text.setBounds(180,180,150,30);
        pass.setBounds(180,210,150,30);
	CBox1.setBounds(180,100,150,30);

        
        panel.add(B1);
        panel.add(B2);
        panel.add(B3);
        
        panel.add(CBox1);
        panel.add(Label1);
        panel.add(Label2);
        panel.add(Label3);
        panel.add(Label4);
        
        
        panel.add(text);
        panel.add(pass);
        
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
