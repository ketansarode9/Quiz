// Java program to implement 
// a Simple Registration Form 
// using Java Swing 

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class MyFrame 
	extends JFrame 
	implements ActionListener { 

	// Components of the Form 
	private Container c; 
	private JLabel title; 
	private JLabel name; 
	private JTextField tname; 
        private JLabel vname ;
        private JLabel uid; 
	private JTextField tuid; 
        private JLabel vuid ;
	private JLabel mno; 
	private JTextField tmno; 
        private JLabel vmno ;
        private JLabel pass; 
	private JTextField tpass; 
        private JLabel vpass ;
	private JLabel gender; 
	private JRadioButton male; 
	private JRadioButton female; 
	private ButtonGroup gengp;
        private JLabel conpass; 
	private JTextField tconpass; 
        private JLabel vconpass ;
        
	private JLabel dob; 
	private JComboBox date; 
	private JComboBox month; 
	private JComboBox year; 
	private JLabel add; 
	private JTextArea tadd; 
        private JLabel vadd ;
	private JCheckBox term; 
	private JButton sub; 
	private JButton reset;
        private JButton login;
	private JLabel res; 
	private JTextArea resadd; 

	private String dates[] 
		= { "1", "2", "3", "4", "5", 
			"6", "7", "8", "9", "10", 
			"11", "12", "13", "14", "15", 
			"16", "17", "18", "19", "20", 
			"21", "22", "23", "24", "25", 
			"26", "27", "28", "29", "30", 
			"31" }; 
	private String months[] 
		= { "Jan", "feb", "Mar", "Apr", 
			"May", "Jun", "July", "Aug", 
			"Sup", "Oct", "Nov", "Dec" }; 
	private String years[] 
		= { "1995", "1996", "1997", "1998", 
			"1999", "2000", "2001", "2002", 
			"2003", "2004", "2005", "2006", 
			"2007", "2008", "2009", "2010", 
			"2011", "2012", "2013", "2014", 
			"2015", "2016", "2017", "2018", 
			"2019" }; 

	// constructor, to initialize the components 
	// with default values. 
	public MyFrame() 
	{ 
		setTitle("Registration Form"); 
		setBounds(300, 90, 900, 600); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setResizable(false); 

		c = getContentPane(); 
		c.setLayout(null); 

		title = new JLabel("Registration Form"); 
		title.setFont(new Font("Arial", Font.PLAIN, 30)); 
		title.setSize(300, 30); 
		title.setLocation(300, 30); 
		c.add(title); 

		name = new JLabel("Name"); 
		name.setFont(new Font("Arial", Font.PLAIN, 20)); 
		name.setSize(100, 20); 
		name.setLocation(100, 100); 
		c.add(name); 
                
		tname = new JTextField(); 
		tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tname.setSize(160, 20); 
		tname.setLocation(200, 100); 
		c.add(tname);
                
                vname = new JLabel(""); 
		vname.setFont(new Font("Arial", Font.PLAIN, 20)); 
		vname.setSize(190, 20); 
		vname.setLocation(200, 125); 
		c.add(vname);
                
                uid = new JLabel("User ID"); 
		uid.setFont(new Font("Arial", Font.PLAIN, 20)); 
		uid.setSize(100, 20); 
		uid.setLocation(400, 100); 
		c.add(uid); 
                
		tuid = new JTextField(); 
		tuid.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tuid.setSize(110, 20); 
		tuid.setLocation(600, 100); 
		c.add(tuid);
                
                vuid = new JLabel(""); 
		vuid.setFont(new Font("Arial", Font.PLAIN, 20)); 
		vuid.setSize(190, 20); 
		vuid.setLocation(600,125); 
		c.add(vuid);

		mno = new JLabel("Mobile"); 
		mno.setFont(new Font("Arial", Font.PLAIN, 20)); 
		mno.setSize(100, 20); 
		mno.setLocation(100, 150); 
		c.add(mno); 

		tmno = new JTextField(); 
		tmno.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tmno.setSize(150, 20); 
		tmno.setLocation(200, 150); 
		c.add(tmno); 
                
                vmno = new JLabel(""); 
		vmno.setFont(new Font("Arial", Font.PLAIN, 20)); 
		vmno.setSize(190, 20); 
		vmno.setLocation(200, 175); 
		c.add(vmno); 
                
                pass = new JLabel("Password"); 
		pass.setFont(new Font("Arial", Font.PLAIN, 20)); 
		pass.setSize(100, 20); 
		pass.setLocation(400, 150); 
		c.add(pass); 
                
		tpass = new JTextField(); 
		tpass.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tpass.setSize(110, 20); 
		tpass.setLocation(600, 150); 
		c.add(tpass); 
                
                vpass = new JLabel(""); 
		vpass.setFont(new Font("Arial", Font.PLAIN, 20)); 
		vpass.setSize(190, 20); 
		vpass.setLocation(600, 175); 
		c.add(vpass); 
                
                
		gender = new JLabel("Gender"); 
		gender.setFont(new Font("Arial", Font.PLAIN, 20)); 
		gender.setSize(100, 20); 
		gender.setLocation(100, 200); 
		c.add(gender); 

		male = new JRadioButton("Male"); 
		male.setFont(new Font("Arial", Font.PLAIN, 15)); 
		male.setSelected(true); 
		male.setSize(75, 20); 
		male.setLocation(200, 200); 
		c.add(male); 
                
                conpass = new JLabel("Confirm Password"); 
		conpass.setFont(new Font("Arial", Font.PLAIN, 20)); 
		conpass.setSize(200,20); 
		conpass.setLocation(400, 200); 
		c.add(conpass); 
                
		tconpass = new JTextField(); 
		tconpass.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tconpass.setSize(110, 20); 
		tconpass.setLocation(600, 200); 
		c.add(tconpass); 
                
                vconpass = new JLabel(""); 
		vconpass.setFont(new Font("Arial", Font.PLAIN, 20)); 
		vconpass.setSize(300, 20); 
		vconpass.setLocation(600, 225); 
		c.add(vconpass); 

		female = new JRadioButton("Female"); 
		female.setFont(new Font("Arial", Font.PLAIN, 15)); 
		female.setSelected(false); 
		female.setSize(80, 20); 
		female.setLocation(275, 200); 
		c.add(female); 

		gengp = new ButtonGroup(); 
		gengp.add(male); 
		gengp.add(female); 

		dob = new JLabel("DOB"); 
		dob.setFont(new Font("Arial", Font.PLAIN, 20)); 
		dob.setSize(100, 20); 
		dob.setLocation(100, 250); 
		c.add(dob); 

		date = new JComboBox(dates); 
		date.setFont(new Font("Arial", Font.PLAIN, 15)); 
		date.setSize(50, 20); 
		date.setLocation(200, 250); 
		c.add(date); 

		month = new JComboBox(months); 
		month.setFont(new Font("Arial", Font.PLAIN, 15)); 
		month.setSize(60, 20); 
		month.setLocation(250, 250); 
		c.add(month); 

		year = new JComboBox(years); 
		year.setFont(new Font("Arial", Font.PLAIN, 15)); 
		year.setSize(60, 20); 
		year.setLocation(320, 250); 
		c.add(year); 

		add = new JLabel("Address"); 
		add.setFont(new Font("Arial", Font.PLAIN, 20)); 
		add.setSize(100, 20); 
		add.setLocation(100, 300); 
		c.add(add); 

		tadd = new JTextArea(); 
		tadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tadd.setSize(200, 75); 
		tadd.setLocation(200, 300); 
		tadd.setLineWrap(true); 
		c.add(tadd); 
                
                vadd = new JLabel(""); 
		vadd.setFont(new Font("Arial", Font.PLAIN, 20)); 
		vadd.setSize(190, 20); 
		vadd.setLocation(200, 380); 
		c.add(vadd); 

		term = new JCheckBox("Accept Terms And Conditions."); 
		term.setFont(new Font("Arial", Font.PLAIN, 15)); 
		term.setSize(250, 20); 
		term.setLocation(150, 400); 
		c.add(term); 

		sub = new JButton("Submit"); 
		sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
		sub.setSize(100, 20); 
		sub.setLocation(150, 450); 
		sub.addActionListener(this); 
		c.add(sub); 

		reset = new JButton("Reset"); 
		reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
		reset.setSize(100, 20); 
		reset.setLocation(270, 450); 
		reset.addActionListener(this); 
		c.add(reset); 
                
                login = new JButton("Existing User"); 
		login.setFont(new Font("Arial", Font.PLAIN, 15)); 
		login.setSize(200, 20); 
		login.setLocation(390, 450); 
		login.addActionListener(this); 
		c.add(login);

		res = new JLabel(""); 
		res.setFont(new Font("Arial", Font.PLAIN, 20)); 
		res.setSize(500, 25); 
		res.setLocation(100, 500); 
		c.add(res); 


		setVisible(true); 
	} 


	public void actionPerformed(ActionEvent ae) 
	{ 
		if (ae.getSource() == sub) { 
			if (term.isSelected()) { 
                            int qflag,wflag,eflag,rflag,tflag,yflag;
                                String score= "-1";
				String data1; 
                                String name= tname.getText() ;
				String userid= tuid.getText() ;
                                String mobile= tmno.getText() ;
                                String password= tpass.getText() ;
                                if (male.isSelected()) 
					data1 = "male"; 
				else
					data1 = "female"; 
                                
                                String gender = data1 ;
                                String confirmpassword = tconpass.getText();
                                String dob = (String)date.getSelectedItem() + "/" + (String)month.getSelectedItem() + "/" + (String)year.getSelectedItem(); 
                                String address= tadd.getText() ;
                                if(name.equals(""))
                                {
                                    qflag=1;
                                    vname.setText("Fill Name");
                                }
                                else
                                {   
                                    qflag=0;
                                   vname.setText("");
                                }
                                if(userid.equals(""))
                                {
                                    wflag=1;
                                    vuid.setText("Fill UID");
                                }
                                 else
                                {   
                                    wflag=0;
                                   vuid.setText("");
                                }
                                if(mobile.equals("") ||  mobile.length()!=10)
                                {
                                    eflag=1 ;
                                    vmno.setText("Invalid no.");
                                }
                                 else
                                {   
                                    eflag=0;
                                   vmno.setText("");
                                }
                                if(password.equals(""))
                                {
                                    rflag=1;
                                    vpass.setText("Fill Password");
                                }
                                 else
                                {   
                                    rflag=0;
                                   vpass.setText("");
                                }
                                if(!password.equals(confirmpassword))
                                {
                                    tflag=1 ;
                                    vconpass.setText("Incorrect Password");
                                }
                                 else
                                {   
                                    tflag=0;
                                   vconpass.setText("");
                                }
                                if(address.equals(""))
                                {
                                    yflag=1;
                                    vadd.setText("Fill Address");
                                }
                                 else
                                {   
                                    yflag=0;
                                   vadd.setText("");
                                }
                           
                               if(qflag==0 && wflag==0 && eflag==0 && rflag==0 && tflag==0 && yflag==0 )
                               {
				res.setText("Registration Successfully..");
                                
                                
                                try{  
                                    Class.forName("com.mysql.jdbc.Driver");  
                                    Connection con=DriverManager.getConnection(  
                                    "jdbc:mysql://localhost:3306/studentdb","root","1234");  
                                    PreparedStatement stmt=con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?)");  
                                    //here studentdb is database name, root is username and password 
                                    stmt.setString(1,name);//1 specifies the first parameter in the query  
                                    stmt.setString(2,userid);
                                    stmt.setString(3,mobile);
                                    stmt.setString(4,password);
                                    stmt.setString(5,gender);
                                    stmt.setString(6,dob);
                                    stmt.setString(7,address);
                                    stmt.setString(8,score);
                                    int i=stmt.executeUpdate();  
                                    System.out.println(i+" records inserted");

                                    con.close();  
                                    }catch(Exception e){ System.out.println(e);} 
                                  new login();
                                  setVisible(false);
                               }
                               else
                               {
                                 res.setText("Please Fill all details");
                               }
			} 
			else { 
				//tout.setText(""); 
				//resadd.setText(""); 
				res.setText("Please accept the"
							+ " terms & conditions.."); 
			} 
		} 

		else if (ae.getSource() == reset) { 
			String def = ""; 
			tname.setText(def); 
			tadd.setText(def); 
			tmno.setText(def); 
			res.setText(def); 
			term.setSelected(false); 
			date.setSelectedIndex(0); 
			month.setSelectedIndex(0); 
			year.setSelectedIndex(0); 
			resadd.setText(def); 
		} 
                else if(ae.getSource()==login)
                {
                    new login();
                    setVisible(false);
                }
	} 
} 

// Driver Code 
class Registration { 

	Registration() 
	{ 
		MyFrame f = new MyFrame(); 
	} 
} 
