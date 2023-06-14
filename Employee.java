import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class Employee extends JFrame implements ActionListener {
	private String day[]= {"1","2","3","4","5","6","7","8","9","10"
			,"11","12","13","14","15","16","17","18","19","20","21","22","23","24","25"
			,"26","27","28","29","30","31"};
	private String month[]= {"1","2","3","4","5","6","7","8","9","10","11","12"};
	private String year[]= {"1993","1994","1995","1996","1997","1998","1999",
			"2000","2001","2002","2003","2004","2005","2006","2007",
			"2008","2009","2010","2011","2012","2013","2014","2015"
			,"2016","2017","2018","2019","2020","2021","2022","2023"};
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private String name,date,cnic,mobno,address,gender;
	private JComboBox daybox,monthbox,yearbox;
	private ButtonGroup  group;
	private JButton button1,button2,button3,button4,button5;
	private JRadioButton male , female;
	private JPanel panel1,panel2,panel3,panel4,panel5,panel6;
	private JTextField text1,text2,text3,text4;
	private Image img,temp;
	private ImageIcon image;
	private Menu m; 
	private JLabel label,label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11;
	
	    void details() {
		setTitle("Employee Data");
		
		panel1 = new JPanel();
		panel1.setBackground(new Color(0x1E2D39));
		panel1.setBounds(0, 150, 480, 570);
		panel1.setVisible(true);
		
		panel2 = new JPanel();
		panel2.setBounds(500,250,1010,370);
		panel2.setVisible(true);
		
		panel3 = new JPanel();
		panel3.setBackground(new Color(0x00FFEF));
		panel3.setBounds(480,150,1050,100);
		panel3.setVisible(true);
		
		panel4 = new JPanel();
		panel4.setBackground(new Color(0x00FFEF));
		panel4.setBounds(480,620,1050,100);
		panel4.setVisible(true);
		
		panel5 = new JPanel();
		panel5.setBackground(new Color(0x00FFEF));
		panel5.setBounds(480,250,20,370);
		panel5.setVisible(true);
		
		panel6 = new JPanel();
		panel6.setBackground(new Color(0x00FFEF));
		panel6.setBounds(1510,250,20,370);
		panel6.setVisible(true);
		
		label = new JLabel("EMPLOYEE FORM");
		label.setForeground(Color.ORANGE);
		label.setFont(new Font("Calibri",Font.BOLD,34));
		label.setBounds(100,30,330,50);
		panel1.add(label);
		
		label1 = new JLabel("Employee Name ");
		label1.setForeground(Color.ORANGE);
		label1.setFont(new Font("Arial",Font.PLAIN,16));
		label1.setBounds(50,120,180,30);
		panel1.add(label1);
		
		text1 = new JTextField();
		text1.setFont(new Font("Arial",Font.PLAIN,16));
		text1.setBounds(250,120,200,30);
		panel1.add(text1);
		
		label2 = new JLabel("Employee CNIC Number ");
		label2.setForeground(Color.ORANGE);
		label2.setFont(new Font("Arial",Font.PLAIN,16));
		label2.setBounds(50,170,200,30);
		panel1.add(label2);
		
		text2 = new JTextField();
		text2.setFont(new Font("Arial",Font.PLAIN,16));
		text2.setBounds(250,170,200,30);
		panel1.add(text2);
		
		label3 = new JLabel("Employee Mobile Number ");
		label3.setForeground(Color.ORANGE);
		label3.setFont(new Font("Arial",Font.PLAIN,16));
		label3.setBounds(50,220,200,30);
		panel1.add(label3);
		
		text3 = new JTextField();
		text3.setFont(new Font("Arial",Font.PLAIN,16));
		text3.setBounds(250,220,200,30);
		panel1.add(text3);
		
		label4 = new JLabel("Employee Date of Birth ");
		label4.setForeground(Color.ORANGE);
		label4.setFont(new Font("Arial",Font.PLAIN,16));
		label4.setBounds(50,300,180,30);
		panel1.add(label4);
		
		
		daybox = new JComboBox(day);
		daybox.setFont(new Font("Arial",Font.PLAIN,16));
		daybox.setBounds(250,300,50,30);
		panel1.add(daybox);
		
		monthbox = new JComboBox(month);
		monthbox.setFont(new Font("Arial",Font.PLAIN,16));
		monthbox.setBounds(320,300,50,30);
		panel1.add(monthbox);
		
		yearbox = new JComboBox(year);
		yearbox.setFont(new Font("Arial",Font.PLAIN,16));
		yearbox.setBounds(380,300,70,30);
		panel1.add(yearbox);
		
		label9 = new JLabel("Day");
		label9.setForeground(Color.ORANGE);
		label9.setFont(new Font("Arial",Font.BOLD,14));
		label9.setBounds(260,270,60,30);
		panel1.add(label9);
		
		label10 = new JLabel("Month");
		label10.setForeground(Color.ORANGE);
		label10.setFont(new Font("Arial",Font.BOLD,14));
		label10.setBounds(325,270,60,30);
		panel1.add(label10);
		
		label11 = new JLabel("Year");
		label11.setForeground(Color.ORANGE);
		label11.setFont(new Font("Arial",Font.BOLD,14));
		label11.setBounds(390,270,60,30);
		panel1.add(label11);
		
		label5 = new JLabel("Employee Address ");
		label5.setForeground(Color.ORANGE);
		label5.setFont(new Font("Arial",Font.PLAIN,16));
		label5.setBounds(50,350,150,30);
		panel1.add(label5);
	
		text4 = new JTextField();
		text4.setFont(new Font("Arial",Font.PLAIN,16));
		text4.setBounds(250,350,200,30);
		panel1.add(text4);
		
		label6 = new JLabel("Choose Gender ");
		label6.setForeground(Color.ORANGE);
		label6.setFont(new Font("Arial",Font.PLAIN,16));
		label6.setBounds(50,410,200,30);
		panel1.add(label6);
		
		male = new JRadioButton("Male");
		male.setForeground(Color.ORANGE);
		male.setBackground(new Color(0x1E2D39));
		male.setFont(new Font("Arial",Font.PLAIN,16));
		male.setBounds(250, 400, 80, 50);
		male.setBorderPainted(false);
		male.setFocusable(false);
		panel1.add(male);
		
		female = new JRadioButton("Female");
		female.setForeground(Color.ORANGE);
		female.setBackground(new Color(0x1E2D39));
		female.setFont(new Font("Arial",Font.PLAIN,16));
		female.setBorderPainted(false);
		female.setBounds(350, 400, 100, 50);
		female.setFocusable(false);
		panel1.add(female);
		
		group = new ButtonGroup();

		group.add(male);
		group.add(female);
		
		button1 = new JButton("Submit");
		button1.setForeground(Color.ORANGE);
		button1.setFont(new Font("Arial",Font.PLAIN,16));
		button1.setBackground(new Color(0x00FFEF));
		button1.setForeground(new Color(0,0,0));
		button1.setFocusable(false);
		button1.setBorderPainted(false);
		button1.setBounds(80,470,100,30);
		panel1.add(button1);
		button1.addActionListener(this);
		

		button1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				checkbutton();
			}
			 });
		
		button2 = new JButton("Delete");
		button2.setForeground(Color.ORANGE);
		button2.setFont(new Font("Arial",Font.PLAIN,16));
		button2.setBackground(new Color(0x00FFEF));
		button2.setForeground(new Color(0,0,0));
		button2.setFocusable(false);
		button2.setBorderPainted(false);
		button2.setBounds(200,470,100,30);
		panel1.add(button2);		
		button2.addActionListener(this);
		
		button3 = new JButton("Modify");
		button3.setForeground(Color.ORANGE);
		button3.setFont(new Font("Arial",Font.PLAIN,16));
		button3.setBackground(new Color(0x00FFEF));
		button3.setForeground(new Color(0,0,0));
		button3.setFocusable(false);
		button3.setBorderPainted(false);
		button3.setBounds(320,470,100,30);
		panel1.add(button3);		
		button3.addActionListener(this);
		
		button4 = new JButton("Refresh");
		button4.setForeground(Color.ORANGE);
		button4.setFont(new Font("Arial",Font.PLAIN,16));
		button4.setBackground(new Color(0x1E2D39));
		button4.setForeground(new Color(250,250,250));
		button4.setBorderPainted(false);
		button4.setFocusable(false);
		button4.setBounds(430,30,100,30);
		panel4.add(button4);
		button4.addActionListener(this);
		
		m = new Menu();
		
		button5 = new JButton("Back");
		button5.setForeground(Color.ORANGE);
		button5.setFont(new Font("Arial",Font.PLAIN,16));
		button5.setBackground(new Color(0x00FFEF));
		button5.setForeground(new Color(0,0,0));
		button5.setFocusable(false);
		button5.setBorderPainted(false);
		button5.setBounds(200,520,100,30);
		panel1.add(button5);
		button5.addActionListener(this);
		
		label7 = new JLabel("EMPLOYEE DETAILS");
		label7.setForeground(new Color(0x1E2D39));
		label7.setFont(new Font("Calibri",Font.BOLD,34)); 
		label7.setBounds(430,30,350,35);
		panel3.add(label7);
		
		image = new ImageIcon("Hotel.png");
		img=image.getImage();
		temp=img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		image=new ImageIcon(temp);
		
		label8 = new JLabel(image);
		label8.setText("HOTEL MANAGEMENT SYSTEM");
		label8.setIcon(image);
		label8.setHorizontalTextPosition(JLabel.CENTER);
		label8.setVerticalTextPosition(JLabel.BOTTOM);
		label8.setForeground(new Color(250,250,250));
		label8.setFont(new Font("Bell MT",Font.BOLD,24));
		label8.setIconTextGap(0);
		label8.setBackground(new Color(0x012A4A));
		label8.setOpaque(true);
		label8.setBounds(0, 0,1550, 150);
		
		panel1.setLayout(new BorderLayout());
		panel2.setLayout(new BorderLayout());
		panel3.setLayout(new BorderLayout());
		panel4.setLayout(new BorderLayout());
		panel5.setLayout(new BorderLayout());
		panel6.setLayout(new BorderLayout());
		
		table = new JTable();
		table.setFont(new Font("Calibri",Font.PLAIN,14));
		table.setBackground(Color.white);
		table.getTableHeader().setFont(new Font("Arial",Font.PLAIN,14));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(32,136,203));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.setSelectionBackground(Color.red);
		table.setSelectionForeground(Color.white);
		table.setRowHeight(20);
		
        model = new DefaultTableModel();
        table.setModel(model);
        scrollPane = new JScrollPane(table);
        scrollPane.addMouseListener(new MouseListener() {
			
            public void mousePressed(MouseEvent e) {
            	
    			}
    	          public void mouseClicked(MouseEvent e) {
    	        	  JtabelDataShow(e);
    	        	
                   
                }
    			@Override
    			public void mouseReleased(MouseEvent e) {
    				// TODO Auto-generated method stub
    				
    			}
    			@Override
    			public void mouseEntered(MouseEvent e) {
    				// TODO Auto-generated method stub
    				
    			}
    			@Override
    			public void mouseExited(MouseEvent e) {
    				// TODO Auto-generated method stub
    				
    			}
            });
        panel2.add(scrollPane,BorderLayout.CENTER);
         
	    getContentPane().add(label8);
	    getContentPane().add(panel1);
	    getContentPane().add(panel2);
	    getContentPane().add(panel3);
	    getContentPane().add(panel4);
	    getContentPane().add(panel5);
	    getContentPane().add(panel6);    
	    
	    setBounds(5,80,1550,750);
	    setLayout(null);
	    setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}

	    private void checkbutton() {
	    	if(text1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter Your Name","Error",JOptionPane.ERROR_MESSAGE);
			}
			if(text2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter Your CNIC","Error",JOptionPane.ERROR_MESSAGE);
			}
			if(text3.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter Your Mobile Number","Error",JOptionPane.ERROR_MESSAGE);
			}
			if(text4.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter Your Address","Error",JOptionPane.ERROR_MESSAGE);
			}
	    	String cnic=text2.getText();
			String mobile=text3.getText();

	        boolean isCNICValid = validateCNIC(cnic);
	        boolean isMobileNumberValid = validateMobileNumber(mobile);

	        if (!isCNICValid && !isMobileNumberValid) {
	            JOptionPane.showMessageDialog(null, "Invalid CNIC and Mobile number!", "Error", JOptionPane.ERROR_MESSAGE);
	            text2.setText("");
	            text3.setText("");
	        }
	        else if (!isCNICValid) {
	            JOptionPane.showMessageDialog(null, "Invalid CNIC number!", "Error", JOptionPane.ERROR_MESSAGE);
	            text2.setText("");
	        }
	        else if(!isMobileNumberValid){
	            JOptionPane.showMessageDialog(null, "Invalid Mobile number!", "Error", JOptionPane.ERROR_MESSAGE);
	            text3.setText("");
	        }
	        else {
	    		name=text1.getText();
	        	cnic = text2.getText();
	        	mobno = text3.getText();
	    		date = daybox.getSelectedItem()+"/"+monthbox.getSelectedItem()+"/"+yearbox.getSelectedItem();
	    		address=text4.getText();
	        	if(male.isSelected()) {
	        		gender = "Male";
	        	}
	        	else if (female.isSelected()){
	        		gender = "Female";
	        	}
	    		try
	    		{
	    			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","Moving@123");
	    			PreparedStatement st= con.prepareStatement("INSERT INTO employee(Name,CNIC,MobileNo,DOB,Address,Gender) VALUES(?,?,?,?,?,?)");
	    			st.setString(1, name);
	    			st.setString(2, cnic);
	    			st.setString(3, mobno);
	    			st.setString(4, date);
	    			st.setString(5, address);
	    			st.setString(6, gender);
	    			int row =st.executeUpdate();
	    			if(row>0) {
	    				 JOptionPane.showMessageDialog(null, "Inserted data into the employee table.");
	    			}
	    			else {
	    				 JOptionPane.showMessageDialog(null, "No Data Inserted into the employee table.");
	    			}
		                   
		            st.close();
		            con.close();
	    	        
	    		} 
	    		catch (SQLException e1) {
	    			// TODO Auto-generated catch block
	    			JOptionPane.showMessageDialog(null, "Error is: " + e1);
	    			e1.printStackTrace();
	    		} 
	    		text1.setText("");
    			text2.setText("");
    			text3.setText("");
    			text4.setText("");
	        } 
		}

		private boolean validateCNIC(String cnic) {
			// TODO Auto-generated method stub
			   String pattern = "\\d{5}-\\d{7}-\\d";
		        return Pattern.matches(pattern, cnic);
		}
		protected boolean validateMobileNumber(String mobile) {
			// TODO Auto-generated method stub
			   String pattern = "\\+92\\d{10}";
		        return Pattern.matches(pattern, mobile);

		}
	    
		private void checkbutton2() {
			cnic = text2.getText();
			try
    		{
    			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","Moving@123");
    			 String query = "DELETE FROM employee WHERE CNIC = ?";
    			PreparedStatement st= con.prepareStatement(query);
    			st.setString(1, cnic);
    			int row =st.executeUpdate();
    			 if(row>0){
    				 JOptionPane.showMessageDialog(null, "Deleted data from the employee table."); 
    			 }
    			 else {
    				 JOptionPane.showMessageDialog(null, "No Data Deleted from the employee table.");
    			 }
	               
	            st.close();
	            con.close();
    		} 
    		catch (SQLException e1) {
    			// TODO Auto-generated catch block
    			JOptionPane.showMessageDialog(null, "Error is: " + e1);
    			e1.printStackTrace();
    		} 
    		text1.setText("");
			text2.setText("");
			text3.setText("");
			text4.setText("");
		}
		
		private void checkbutton3() {
			name=text1.getText();
        	cnic = text2.getText();
        	mobno = text3.getText();
    		date = daybox.getSelectedItem()+"/"+monthbox.getSelectedItem()+"/"+yearbox.getSelectedItem();
    		address=text4.getText();
        	if(male.isSelected()) {
        		gender = "Male";
        	}
        	else if (female.isSelected()){
        		gender = "Female";
        	}
    		try
    		{
    			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","Moving@123");
    			String query = "UPDATE employee SET Name = ?, MobileNo = ?, DOB = ?, Address = ?, Gender = ? WHERE CNIC = ?";
                PreparedStatement st = con.prepareStatement(query);
                st.setString(1, name);
                st.setString(2, mobno);
                st.setString(3, date);
                st.setString(4, address);
                st.setString(5, gender);
                st.setString(6, cnic);
                
                int rowsUpdated = st.executeUpdate();
                
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Updated data in the employee table.");
                } 
                else {
                    JOptionPane.showMessageDialog(null, "No rows were updated in the employee table.");
                }
                st.close();
	            con.close();
    		} 
    		catch (SQLException e1) {
    			// TODO Auto-generated catch block
    			JOptionPane.showMessageDialog(null, "Error is: " + e1);
    			e1.printStackTrace();
    		} 
    		text1.setText("");
    		text2.setText("");
    		text3.setText("");
    		text4.setText("");
		}
		
		private void checkbutton4() {
			try {
	        	 model.setRowCount(0);
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "Moving@123");
	            String query = "SELECT * FROM employee";
	            PreparedStatement st = con.prepareStatement(query);
	            ResultSet rs = st.executeQuery();
	            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
	            int columnCount = rsmd.getColumnCount();

	            // Set column names in the table model
	            Vector<String> columnNames = new Vector<>();
	            for (int i = 1; i <= columnCount; i++) {
	                columnNames.add(rsmd.getColumnName(i));
	            }
	            model.setColumnIdentifiers(columnNames);
	            int count =0;
	            // Populate data in the table model
	            while (rs.next()) {
	            	
	            	count++;
	                Vector<Object> rowData = new Vector<>();
	               
	                for (int i = 1; i <= columnCount; i++) {
	                	if(i==1) {
	                		 rowData.add(count);
	                	}
	                	else {
	                		 rowData.add(rs.getObject(i));
	                	}
	                   
	                }
	                model.addRow(rowData);
	            }
	            st.close();
	            con.close();
	        } 
	        catch (SQLException e1) {
	            JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
	            e1.printStackTrace();
	        }

	        table.getColumnModel().getColumn(0).setPreferredWidth(80);
	        table.getColumnModel().getColumn(1).setPreferredWidth(150);
	        table.getColumnModel().getColumn(2).setPreferredWidth(120);
	        table.getColumnModel().getColumn(3).setPreferredWidth(120);
	        table.getColumnModel().getColumn(4).setPreferredWidth(80);
	        table.getColumnModel().getColumn(5).setPreferredWidth(300);
	        table.getColumnModel().getColumn(6).setPreferredWidth(80);

		}
		
	    private void JtabelDataShow(java.awt.event.MouseEvent e) {
	    	int i = table.getSelectedRow();
	    	model =(DefaultTableModel) table.getModel();
	    	text1.setText(model.getValueAt(i, 1).toString());
	    	text2.setText(model.getValueAt(i, 2).toString());
	    	text3.setText(model.getValueAt(i, 3).toString());
	    	String Date =model.getValueAt(i, 4).toString();
	    	
	    	String s,s1,s2;
    		String date =  Date;
    		String[] a = date.split("/");
            s=a[0];
            s1=a[1];
            s2=a[2];
            daybox.setSelectedItem(s);
            monthbox.setSelectedItem(s1);
            yearbox.setSelectedItem(s2);
            
            text4.setText(model.getValueAt(i, 5).toString());
            
	    	String Gender=model.getValueAt(i, 6).toString();
	    	if(Gender.equals("Male")) {
	    		male.setSelected(true);
	    	}
	    	else if(Gender.equals("Female")) {
	    		female.setSelected(true);
	    	}
	    	else {
	    		male.setSelected(false);
	    		female.setSelected(false);
	    	}
	    }
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==button2) {
				checkbutton2();
			}
			
			else if(e.getSource()==button3) {
				checkbutton3();
			}
			
			else if(e.getSource()==button4) {
				checkbutton4();
			}
			
			else if(e.getSource()==button5) {
				m.Show();
				dispose();	
			}
		}
}