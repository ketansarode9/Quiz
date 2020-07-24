//package dope;
import java.awt.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
//import static javax.xml.ws.Service.Mode.MESSAGE;
import javax.swing.table.*;

public class Admin
{ 

	private static final int WIDTH = 1000;
	private static final int HEIGHT = 500;
	JFrame frame;
    JPanel panel;
    
    JTextArea text=new JTextArea();
    JLabel Label1;
    JScrollPane scroll;
    JTable j;
    DefaultTableModel dtm;
                
    Connection conn;
    PreparedStatement ps;
    JButton B1 = new JButton();
    JButton B2 = new JButton();
    public Object GetData(JTable table, int row_index, int col_index)
    {
        return table.getModel().getValueAt(row_index, col_index);
    } 

	Admin()
	{
        JFrame frame = new JFrame(); 
        Label1=new JLabel(); 
		frame.setTitle("Score Card");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
        panel =new JPanel();
		panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        Label1.setText("WELCOME ADMIN");
        text.setText("");
        B1.setText("CLOSE/LOGIN AGAIN");
		B1.addMouseListener(new java.awt.event.MouseAdapter() 
		{
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt) 
                    {
                        frame.setVisible(false);
                        login loginn = new login();
                    }
                 });
                B2.setText("DELETE");
		B2.addMouseListener(new java.awt.event.MouseAdapter() 
		{
                    Boolean flag=false;
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt) 
                    {
                        int rowIndex=j.getSelectedRow();
                        if(rowIndex !=-1)
                        {
                            String obj1;
                            obj1 = (String) GetData(j,rowIndex, 0);
                            JOptionPane.showMessageDialog(frame,obj1);
                            flag=true;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(frame,"PLEASE CHOOSE A ROW TO PERFORM DELETION");
                        }
                        int option=0;
                        if(flag)
                        {
                            
                            option = JOptionPane.showConfirmDialog(frame,"Want to delete this?\n"
                                ,"Are You Sure?",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE );
                            
                        }

                        if(option==JOptionPane.YES_OPTION){
                            try
                            {
                                String myUrl = "jdbc:mysql://localhost/studentdb";
                                
                                Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
//                                String query = "delete from users where id = ?";
//                                PreparedStatement preparedStmt = conn.prepareStatement(query);
//                                preparedStmt.setInt(1, 3);
//
//                                // execute the preparedstatement
//                                preparedStmt.execute();
                                int rowIndexj=j.getSelectedRow();
                                PreparedStatement stmt=conn.prepareStatement("delete from student where userid=?");  
                                stmt.setString(1,(String)GetData(j,rowIndexj,0));  
                                 
                                int i=stmt.executeUpdate();  
                                System.out.println((String)GetData(j,rowIndexj,0)+" records deleted");
                                conn.close();
                            }

                            catch (Exception e)
                            {
                                System.err.println("Got an exception! ");
                                System.err.println(e.getMessage());
                            }
                        }
                        
                        
                        
                    }

                    
                    
                    
                    
                 });
                
        String[] columnNames = {"ID","Name", "Mobile_No", "Score"}; 
        dtm = new DefaultTableModel(columnNames,0);
        j=new JTable(dtm);
        scroll = new JScrollPane(j);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
	

        	
                
                
        try
        {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","1234");
            PreparedStatement ps;
            ps = conn.prepareStatement("SELECT * FROM student;");
            ResultSet result=ps.executeQuery();
            while (result.next() ) 
            {
                String[] item={result.getString(2),result.getString(1),result.getString(3),result.getString(8)};
                dtm.addRow(item);
            }
                    
        }catch(SQLException err)
        {
            JOptionPane.showMessageDialog(frame,"INVALID ENTRY"+err.getMessage());
        }
                
               
	
            Label1.setBounds(300,10,240,30);
            scroll.setBounds(100,50,800,350);
            B1.setBounds(750,410,150,50);
            B2.setBounds(100,410,150,50);

                
		panel.add(Label1);
		panel.add(scroll);
		panel.add(B1);
		panel.add(B2);
		
        frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	}
        
       
}
