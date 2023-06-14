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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


class Checkout extends JFrame implements ActionListener{
	
	private String name,cnic,roomno,roomtype,roomprice,mealprice,checkindate,checkoutdate,totalbill,nights,address;
	String CNIC;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private DateFormat dateFormat ;
	private Date date;
	private String difference;
	private JButton button,button2,button3,button4,generate;
	private JPanel panel1,panel2,panel3,panel4,panel5,panel6;
	private JTextField text1,text2,text4,text5,text6,text7,text8,text9;
	private JTextArea area1,area2;
	private Image img,temp;
	private ImageIcon image;
	private JLabel label,label1,label2,label4,label5,label6,label7,label8,label9,label11,label12;
	private Menu m; 
	private Bill b;
	
	void exit(){
	
		setTitle("Hotel Room Checkout ");
		
		panel1 = new JPanel();
		panel1.setBackground(new Color(0x1E2D39));
		panel1.setBounds(0, 120, 480, 620);
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
	 
		
		label = new JLabel("CUSTOMER CHECKOUT FORM");
		label.setForeground(Color.ORANGE);
		label.setFont(new Font("Calibri",Font.BOLD,34));
		label.setBounds(45,30,450,50);
		panel1.add(label);
		
		label1 = new JLabel("Customer Name ");
		label1.setForeground(Color.ORANGE);
		label1.setFont(new Font("Arial",Font.PLAIN,16));
		label1.setBounds(50,90,180,30);
		panel1.add(label1);
		
		text1 = new JTextField();
		text1.setFont(new Font("Arial",Font.PLAIN,16));
		text1.setBounds(250,90,200,30);
		text1.setEditable(false);
		panel1.add(text1);
		
		label2 = new JLabel("Customer CNIC ");
		label2.setForeground(Color.ORANGE);
		label2.setFont(new Font("Arial",Font.PLAIN,16));
		label2.setBounds(50,130,200,30);
		panel1.add(label2);
		
		text2 = new JTextField();
		text2.setFont(new Font("Arial",Font.PLAIN,16));
		text2.setEditable(false);
		text2.setBounds(250,125,200,30);
		panel1.add(text2);
		
		label12 = new JLabel("Room Number ");
		label12.setForeground(Color.ORANGE);
		label12.setFont(new Font("Arial",Font.PLAIN,16));
		label12.setBounds(50,163,200,30);
		panel1.add(label12);
		
		text9 = new JTextField();
		text9.setFont(new Font("Arial",Font.PLAIN,16));
		text9.setEditable(false);
		text9.setBounds(250,163,200,30);
		panel1.add(text9);
		
		label4 = new JLabel("Room Type ");
		label4.setForeground(Color.ORANGE);
		label4.setFont(new Font("Arial",Font.PLAIN,16));
		label4.setBounds(50,205,180,30);
		panel1.add(label4);
		
		text4 = new JTextField();
		text4.setFont(new Font("Arial",Font.PLAIN,16));
		text4.setBounds(250,205,200,30);
		text4.setEditable(false);
		panel1.add(text4);
		
		label5 = new JLabel("Room Price ");
		label5.setForeground(Color.ORANGE);
		label5.setFont(new Font("Arial",Font.PLAIN,16));
		label5.setBounds(50,245,150,30);
		panel1.add(label5);
		
		text5 = new JTextField();
		text5.setFont(new Font("Arial",Font.PLAIN,16));
		text5.setBounds(250,245,200,30);
		text5.setEditable(false);
		panel1.add(text5);
		
		label2 = new JLabel("Meal Price ");
		label2.setForeground(Color.ORANGE);
		label2.setFont(new Font("Arial",Font.PLAIN,16));
		label2.setBounds(50,290,200,30);
		panel1.add(label2);
		
		text7 = new JTextField();
		text7.setFont(new Font("Arial",Font.PLAIN,16));
		text7.setBounds(250,290,200,30);
		text7.setEditable(false);
		panel1.add(text7);
		
		label4 = new JLabel("Number of Nights ");
		label4.setForeground(Color.ORANGE);
		label4.setFont(new Font("Arial",Font.PLAIN,16));
		label4.setBounds(50,335,180,30);
		panel1.add(label4);
		
		text6 = new JTextField();
		text6.setFont(new Font("Arial",Font.PLAIN,16));
		text6.setBounds(250,335,200,30);
		text6.setEditable(false);
		panel1.add(text6);
		
		label6 = new JLabel("Checkout date");
		label6.setForeground(Color.ORANGE);
		label6.setFont(new Font("Arial",Font.PLAIN,16));
		label6.setBounds(50,425,200,30);
		panel1.add(label6);

		area1 = new JTextArea("");
		area1.setFont(new Font("Arial",Font.PLAIN,16));
		area1.setBounds(250,380,200,30);
		area1.setEditable(false);
		panel1.add(area1);
		
		label9 = new JLabel("Checkin Date");
		label9.setForeground(Color.ORANGE);
		label9.setFont(new Font("Arial",Font.PLAIN,16));
		label9.setBounds(50,380,170,35);
		panel1.add(label9);
		
		area2 = new JTextArea();
		
		dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
		date = new Date();
		String date1= dateFormat.format(date);
		 
		area2.setText(date1);
		
		label11 = new JLabel("Total Bill ");
		label11.setForeground(Color.ORANGE);
		label11.setFont(new Font("Arial",Font.PLAIN,16));
		label11.setBounds(50,470,200,30);
		panel1.add(label11);
		
		text8 = new JTextField();
		text8.setFont(new Font("Arial",Font.PLAIN,16));
		text8.setBounds(250,470,200,30);
		text8.setEditable(false);
		panel1.add(text8);
		
		m = new Menu();
		
		area2.setFont(new Font("Arial",Font.PLAIN,16));
		area2.setBounds(250,425,200,30);
		area2.setEditable(false);
		panel1.add(area2);
		
		button = new JButton("Checkout");
		button.setForeground(Color.ORANGE);
		button.setFont(new Font("Arial",Font.PLAIN,16));
		button.setBackground(new Color(0x00FFEF));
		button.setForeground(new Color(0,0,0));
		button.setFocusable(false);
		button.setBorderPainted(false);
		button.setBounds(140,520,100,30);
		panel1.add(button);		
		button.addActionListener(this);
		
		generate = new JButton("Bill");
		generate.setForeground(Color.ORANGE);
		generate.setFont(new Font("Arial",Font.PLAIN,16));
		generate.setBackground(new Color(0x00FFEF));
		generate.setForeground(new Color(0,0,0));
		generate.setFocusable(false);
		generate.setBorderPainted(false);
		generate.setBounds(365,520,100,30);
		panel1.add(generate);		
		generate.addActionListener(this);
		
		b= new Bill();
		
		label7 = new JLabel("Checkout Successfully");	
		label7.setForeground(Color.ORANGE);
		label7.setFont(new Font("Arial",Font.PLAIN,16));
		label7.setBounds(160,550,170,35);
		label7.setVisible(false);
		panel1.add(label7);
		
		label7 = new JLabel("CHECKOUT DETAILS");
		label7.setForeground(new Color(0x1E2D39));
		label7.setFont(new Font("Calibri",Font.BOLD,34));
		label7.setBounds(430,30,350,35);
		panel3.add(label7);
		

		button3 = new JButton("Delete");
		button3.setForeground(Color.ORANGE);
		button3.setFont(new Font("Arial",Font.PLAIN,16));
		button3.setBackground(new Color(0x00FFEF));
		button3.setForeground(new Color(0,0,0));
		button3.setFocusable(false);
		button3.setBorderPainted(false);
		button3.setBounds(20,520,100,30);
		panel1.add(button3);		
		button3.addActionListener(this);
		
		button2 = new JButton("Refresh");
		button2.setForeground(Color.ORANGE);
		button2.setFont(new Font("Arial",Font.PLAIN,16));
		button2.setBackground(new Color(0x1E2D39));
		button2.setForeground(new Color(250,250,250));
		button2.setFocusable(false);
		button2.setBorderPainted(false);
		button2.setBounds(430,30,100,30);
		panel4.add(button2);
		button2.addActionListener(this);
		
		button4 = new JButton("Back");
		button4.setForeground(Color.ORANGE);
		button4.setFont(new Font("Arial",Font.PLAIN,16));
		button4.setBackground(new Color(0x00FFEF));
		button4.setForeground(new Color(0,0,0));
		button4.setFocusable(false);
		button4.setBorderPainted(false);
		button4.setBounds(255,520,100,30);
		panel1.add(button4);
		button4.addActionListener(this);
		
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

	 private void JtabelDataShow(java.awt.event.MouseEvent e) {
	    	int i = table.getSelectedRow();
	    	model =(DefaultTableModel) table.getModel();
	    	text1.setText(model.getValueAt(i, 1).toString());
	    	text2.setText(model.getValueAt(i, 2).toString());
	    	text9.setText(model.getValueAt(i, 3).toString());
	    	text4.setText(model.getValueAt(i, 4).toString());
	    	text5.setText(model.getValueAt(i, 5).toString());
	    	text7.setText(model.getValueAt(i, 6).toString());
	    	text6.setText(model.getValueAt(i, 7).toString());
	    	area1.setText(model.getValueAt(i, 8).toString());
	    	text8.setText(model.getValueAt(i, 10).toString());
	        String checkInStr = area1.getText();
	        String checkOutStr = area2.getText();

	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    
	            
				try {
					Date checkInDate = dateFormat.parse(checkInStr);
					Date checkOutDate = dateFormat.parse(checkOutStr);

			        long differenceInMillis = checkOutDate.getTime() - checkInDate.getTime();
			        long differenceInDays = differenceInMillis / (24 * 60 * 60 * 1000);
			        difference = String.valueOf(differenceInDays) ;
			        int diff = Integer.parseInt(difference);
			        if(differenceInDays==0) {
			        	text6.setText("1");
			        }
			        else {
			        	text6.setText(""+differenceInDays);
			        }
			        
			        if(differenceInDays==0) {
			        	 int rprice=Integer.parseInt(text5.getText());
					        int mprice=Integer.parseInt(text7.getText());
					        int Total =rprice+mprice*1;
					        text8.setText(""+Total);
			        }
			        else {
			        	int rprice=Integer.parseInt(text5.getText());
				        int mprice=Integer.parseInt(text7.getText());
				      
				        int Total =(rprice+mprice)*diff;
				        text8.setText(""+Total);	
			        }
			        
				} 
				catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	           
	 }
	
	 private void data() {
		 
		 name = text1.getText();
		cnic = text2.getText();
		roomno = text9.getText();
		roomtype = text4.getText();
		roomprice = text5.getText();
		mealprice = text7.getText();
		nights = text6.getText();
		checkindate = area1.getText();
		checkoutdate = area2.getText();
		totalbill = text8.getText();

		    try {
		        Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "Moving@123");
		        PreparedStatement st1 = con1.prepareStatement("UPDATE checkout SET CustomerName = ? , RoomNo = ? , RoomType = ? , RoomPrice = ? , MealPrice = ? , CheckinDate = ? , NightsNo = ? , CheckoutDate = ? , TotalBill = ?  WHERE CustomerCNIC = ?");
			    st1.setString(1, name);
			    st1.setString(2, roomno);
			    st1.setString(3, roomtype);
			    st1.setString(4, roomprice);
			    st1.setString(5, mealprice);
			    st1.setString(6, checkindate);
		        st1.setString(7, nights);
		        st1.setString(8, checkoutdate);
		        st1.setString(9, totalbill);
			    st1.setString(10, cnic);

		        int row =st1.executeUpdate();
		        if(row>0) {
		        	 JOptionPane.showMessageDialog(null, "Inserted data in the checkout table.");
		        }
		        else {
		        	 JOptionPane.showMessageDialog(null, "No Data Inserted in the checkout table.");
		        }
		       
		        
		        st1.close();
		        con1.close();
		    }
		        catch(SQLException e3) {
					JOptionPane.showMessageDialog(null, "Error: " + e3.getMessage());
		            e3.printStackTrace();
				}
		    try {
		    	 String status="Free";
		    	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "Moving@123");
		 			PreparedStatement st2= con.prepareStatement("UPDATE add_room SET RoomStatus = ?  WHERE RoomNo = ?");
		 			st2.setString(1, status);
		 			st2.setString(2, roomno);
		 			st2.executeUpdate();
		 			     
				        st2.close();
				        con.close();
	        }
		       
		    catch (SQLException e1) {
		        // TODO Auto-generated catch block
		        JOptionPane.showMessageDialog(null, "Error is: " + e1);
		        e1.printStackTrace();
		    }
			JTextArea area3 = new JTextArea();
				
			dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
			date = new Date();
			String date1= dateFormat.format(date);
				 
			area3.setText(date1);
			String ReceiptDate=area3.getText();
			
	        try {
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "Moving@123");
	            // CNIC to match
	            String query = "SELECT Name,Address FROM customer WHERE CNIC = ? ";
	            PreparedStatement st = con.prepareStatement(query);
	            st.setString(1, cnic);
	            
	            ResultSet rs = st.executeQuery();
	            while (rs.next()) {
	                name = rs.getString("Name");
	                address = rs.getString("Address");
	                
	            }  
	            CNIC=cnic;
	        }
	            
	        catch(SQLException e2) {
				JOptionPane.showMessageDialog(null, "Error: " + e2.getMessage());
	            e2.printStackTrace();
			} 
	         
	        try {
	        	 Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "Moving@123");
	            	 String query1 = "SELECT RoomNo,RoomType,RoomPrice FROM add_room WHERE RoomNo = ? ";
	 	            PreparedStatement st1 = con1.prepareStatement(query1);
	 	            st1.setString(1, roomno);
	 	            ResultSet rs1 = st1.executeQuery();
	 	            
	 	            while (rs1.next()) {
	 	                roomno = rs1.getString("RoomNo");
	 	                roomtype = rs1.getString("RoomType");
	 	                roomprice = rs1.getString("RoomPrice");
	 	            }
	 	            st1.close();
	 	            con1.close();
				}
				catch(SQLException e2) {
					JOptionPane.showMessageDialog(null, "Error: " + e2.getMessage());
		            e2.printStackTrace();
				}
	            
	            try {
	            	 Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "Moving@123");
	            	 String query2 = "INSERT INTO bill (Name , CNIC , Address , RoomNo , RoomType , RoomPrice , TotalNights , MealPrice ,CheckinDate , CheckoutDate , TotalBill , ReceiptDate) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
	 	            PreparedStatement st2 = con2.prepareStatement(query2);
	 	            st2.setString(1, name);
	 	            st2.setString(2, cnic);
	 	            st2.setString(3, address);
	 	            st2.setString(4, roomno);
	 	            st2.setString(5, roomtype);
	 	            st2.setString(6, roomprice);
	 	            st2.setString(7, nights);
	 	            st2.setString(8, mealprice);
	 	            st2.setString(9, checkindate);
	 	            st2.setString(10, checkoutdate);
	 	            st2.setString(11, totalbill);
	 	            st2.setString(12, ReceiptDate);
	 	            
	 	           int row3 = st2.executeUpdate();
	 	            if(row3>0) {
	 	            	JOptionPane.showMessageDialog(null, "Data Store in Bill Table","Error",JOptionPane.INFORMATION_MESSAGE);
	 	            }
	 	            else {
	 	            	JOptionPane.showMessageDialog(null, "No Data Store in Bill Table","Error",JOptionPane.INFORMATION_MESSAGE);
	 	            }
	 	            st2.close();
	 	            
	 	            con2.close();
				}
				catch(SQLException e3) {
					JOptionPane.showMessageDialog(null, "Error: " + e3.getMessage());
		            e3.printStackTrace();
				}
	 		
		}

	 private void checkoutTable() {
		 try {
		        model.setRowCount(0);
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "Moving@123");
		        String query = "SELECT * FROM checkout";
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
		        int count = 0;
		        // Populate data in the table model
		        while (rs.next()) {

		            count++;
		            Vector<Object> rowData = new Vector<>();

		            for (int i = 1; i <= columnCount; i++) {
		                if (i == 1) {
		                    rowData.add(count);
		                } else {
		                    rowData.add(rs.getObject(i));
		                }
		            }
		            model.addRow(rowData);
		        }

		        st.close();
		        con.close();
		    } catch (SQLException e1) {
		        JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
		        e1.printStackTrace();
		    }
		    // Set preferred width of columns
		    table.getColumnModel().getColumn(0).setPreferredWidth(70);
		    table.getColumnModel().getColumn(1).setPreferredWidth(120);
		    table.getColumnModel().getColumn(2).setPreferredWidth(120);
		    table.getColumnModel().getColumn(3).setPreferredWidth(80);
		    table.getColumnModel().getColumn(4).setPreferredWidth(80);
		    table.getColumnModel().getColumn(5).setPreferredWidth(80);
		    table.getColumnModel().getColumn(6).setPreferredWidth(80);
		    table.getColumnModel().getColumn(7).setPreferredWidth(80);
		    table.getColumnModel().getColumn(8).setPreferredWidth(80);
		}
		
	 private void deletecheckout() {
		 cnic = text2.getText();
			try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","Moving@123");
			String query = "DELETE FROM checkout WHERE CustomerCNIC = ?";
			PreparedStatement st= con.prepareStatement(query);
			st.setString(1, cnic);
			
			int row = st.executeUpdate();
			if(row>0) {
				 JOptionPane.showMessageDialog(null, "Deleted data from the checkout table"); 
			}
			else {
				 JOptionPane.showMessageDialog(null, "No Deleted from the checkout table"); 
			}
	          
	            st.close();
	            con.close();
		} 
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error is: " + e1);
			e1.printStackTrace();
		} 
	 }
	 
	 public void deletecheckin() {
		 cnic = text2.getText();
			try
 		{
 			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","Moving@123");
 			String query = "DELETE FROM checkin WHERE CNIC = ?";
 			PreparedStatement st= con.prepareStatement(query);
 			st.setString(1, cnic);
 			st.executeUpdate(); 
	            
	            st.close();
	            con.close();
 		} 
 		catch (SQLException e1) {
 			// TODO Auto-generated catch block
 			JOptionPane.showMessageDialog(null, "Error is: " + e1);
 			e1.printStackTrace();
 		} 
 	
	 }
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		label7.setVisible(true);
		if(e.getSource()==generate) {
			b.roomBill();
			b.billtable(CNIC);
	        }
		
		else if (e.getSource() == button) {
		    // TODO Auto-generated method stuB
			data();
			deletecheckin();
			
		}
		else if (e.getSource() == button2) {
		   
			checkoutTable();
		}
		else if(e.getSource()==button3) {
			deletecheckout();
		}
		else if(e.getSource()==button4) {
			
			m.Show();
			dispose();
		}
	}
}