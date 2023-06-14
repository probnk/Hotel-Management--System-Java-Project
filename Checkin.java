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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class Checkin extends JFrame implements ActionListener {
	private boolean check1 = false,check2=false,check3=true;
	private String room[]= {"Suite","Duplex","Family"};
	private String number[]= {"100","101","102","103","104","105","106","107","108","109","110","111","112","113","114","115"};
	private String ac[]= {"AC","NonAC"};
	private String mealtype[]= {"Vegetarian","Non-Vegetarian","Sea Food"};
	private String mealtime[]= {"Breakfast","Launch","Dinner"};
	private String ccnic,cname,name,cnic,ac_nonac,roomno,roomprice,roomtype,roomstatus,mealadd,mealprice,time,Type,checkindate;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private DateFormat dateFormat ;
	private Date date;
	private JComboBox mtime,mtype,rno;
	private JButton button,button2,button3,button4,button5;
	private JCheckBox box;
	private JPanel panel1,panel2,panel3,panel4,panel5,panel6;
	private JTextField text1,text2,text5,text6;
	private  JTextArea area;
	private Image img,temp;
	private ImageIcon image;
	private JComboBox type,type1;
	private Menu m; 
	private JLabel label,label1,label2,label4,label5,label6,label7,label8,label9,label10,label11,label13,label14,label15;
	
	void entry() {

			setTitle("Hotel Room Checkin");
			
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
		 
			
			label = new JLabel("CUSTOMER CHECKIN FORM");
			label.setForeground(Color.ORANGE);
			label.setFont(new Font("Calibri",Font.BOLD,34));
			label.setBounds(45,30,400,50);
			panel1.add(label);
			
			label1 = new JLabel("Customer Name ");
			label1.setForeground(Color.ORANGE);
			label1.setFont(new Font("Arial",Font.PLAIN,16));
			label1.setBounds(50,90,180,30);
			panel1.add(label1);
			
			text1 = new JTextField();
			text1.setFont(new Font("Arial",Font.PLAIN,16));
			text1.setBounds(250,90,200,30);
			panel1.add(text1);
			
			label2 = new JLabel("Customer CNIC Number ");
			label2.setForeground(Color.ORANGE);
			label2.setFont(new Font("Arial",Font.PLAIN,16));
			label2.setBounds(50,135,200,30);
			panel1.add(label2);
			
			text2 = new JTextField();
			text2.setFont(new Font("Arial",Font.PLAIN,16));
			text2.setBounds(250,135,200,30);
			panel1.add(text2);
			
			label4 = new JLabel("Room Number ");
			label4.setForeground(Color.ORANGE);
			label4.setFont(new Font("Arial",Font.PLAIN,16));
			label4.setBounds(50,185,180,30);
			panel1.add(label4);
			
			rno= new JComboBox(number);
			rno.setBounds(250,185,100,30);
			panel1.add(rno);
			rno.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					setroomdata();
				}
			});

			
			label5 = new JLabel("Room Price ");
			label5.setForeground(Color.ORANGE);
			label5.setFont(new Font("Arial",Font.PLAIN,16));
			label5.setBounds(50,285,150,30);
			panel1.add(label5);
			
			text5 = new JTextField("8000");
			text5.setFont(new Font("Arial",Font.PLAIN,16));
			text5.setBounds(250,285,200,30);
			text5.setEditable(false);
			panel1.add(text5);
			
			label2 = new JLabel("Room AC or Non AC ");
			label2.setForeground(Color.ORANGE);
			label2.setFont(new Font("Arial",Font.PLAIN,16));
			label2.setBounds(50,235,200,30);
			panel1.add(label2);
			
			type1 = new JComboBox(ac);
			type1.setFont(new Font("Arial",Font.PLAIN,16));
			type1.setBounds(250,235,100,30);
			type1.setEditable(false);
			panel1.add(type1);
			
			label11 = new JLabel("Select ");
			label11.setForeground(Color.ORANGE);
			label11.setFont(new Font("Arial",Font.BOLD,14));
			label11.setBounds(360,235,60,30);
			panel1.add(label11);
			
			label4 = new JLabel("Room Type ");
			label4.setForeground(Color.ORANGE);
			label4.setFont(new Font("Arial",Font.PLAIN,16));
			label4.setBounds(50,335,180,30);
			panel1.add(label4);
			
			label10 = new JLabel("Select ");
			label10.setForeground(Color.ORANGE);
			label10.setFont(new Font("Arial",Font.BOLD,14));
			label10.setBounds(360,335,60,30);
			panel1.add(label10);
			
			type = new JComboBox(room);
			type.setFont(new Font("Arial",Font.PLAIN,16));
			type.setBounds(250,335,100,30);
			type.setEditable(false);
			panel1.add(type);
			
			label6 = new JLabel("Add Meal ");
			label6.setForeground(Color.ORANGE);
			label6.setFont(new Font("Arial",Font.PLAIN,16));
			label6.setBounds(50,420,200,30);
			panel1.add(label6);
			
			box = new JCheckBox();
			box.setForeground(Color.ORANGE);
			box.setBackground(new Color(0x1E2D39));
			box.setFont(new Font("Arial",Font.PLAIN,16));
			box.setBounds(150, 420, 50, 30);
			box.setFocusable(false);
			panel1.add(box);
			box.addActionListener(this);
			
			mtype = new JComboBox(mealtype);
			mtype.setFont(new Font("Arial",Font.PLAIN,16));
			mtype.setEnabled(false);
			mtype.setBounds(230,450,110,30);
			panel1.add(mtype);
			
			mtime = new JComboBox(mealtime);
			mtime.setFont(new Font("Arial",Font.PLAIN,16));
			mtime.setEnabled(false);
			mtime.setBounds(350,450,100,30);
			panel1.add(mtime);
			
			label13 = new JLabel("Time ");
			label13.setForeground(Color.ORANGE);
			label13.setFont(new Font("Arial",Font.PLAIN,16));
			label13.setBounds(360,420,180,30);
			panel1.add(label13);
			
			label14 = new JLabel("Type ");
			label14.setForeground(Color.ORANGE);
			label14.setFont(new Font("Arial",Font.PLAIN,16));
			label14.setBounds(230,420,180,30);
			panel1.add(label14);
			
			label15 = new JLabel("Price ");
			label15.setForeground(Color.ORANGE);
			label15.setFont(new Font("Arial",Font.PLAIN,16));
			label15.setBounds(50,450,200,30);
			panel1.add(label15);
			 
			text6 = new JTextField();
			text6.setFont(new Font("Arial",Font.PLAIN,16));
			text6.setBounds(100,450,110,30);
			text6.setEditable(false);
			panel1.add(text6);
			
			area = new JTextArea();
			
			dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
			date = new Date();
			String date1= dateFormat.format(date);
			 
			area.setText(""+date1);
			area.setFont(new Font("Arial",Font.PLAIN,16));
			area.setBounds(250,380,200,30);
			area.setEditable(false);
			panel1.add(area);
			
			m = new Menu();
			
			label9 = new JLabel("Checkin Date");
			label9.setForeground(Color.ORANGE);
			label9.setFont(new Font("Arial",Font.PLAIN,16));
			label9.setBounds(50,380,170,35);
			panel1.add(label9);
			
			button = new JButton("Checkin");
			button.setForeground(Color.ORANGE);
			button.setFont(new Font("Arial",Font.PLAIN,16));
			button.setBackground(new Color(0x00FFEF));
			button.setForeground(new Color(0,0,0));
			button.setFocusable(false);
			button.setBorderPainted(false);
			button.setBounds(200,500,100,30);
			panel1.add(button);		
			button.addActionListener(this);
			
			label7 = new JLabel("Checkin Successfully");	
			label7.setForeground(Color.ORANGE);
			label7.setFont(new Font("Arial",Font.PLAIN,16));
			label7.setBounds(180,540,150,30);
			label7.setVisible(false);
			panel1.add(label7);
			
			label7 = new JLabel("CHECKIN DETAILS");
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
			button3.setBounds(80,500,100,30);
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
			button4.setBounds(320,500,100,30);
			panel1.add(button4);
			button4.addActionListener(this);
			
			button5 = new JButton("Select");
			button5.setForeground(Color.ORANGE);
			button5.setFont(new Font("Arial",Font.BOLD,14));
			button5.setBackground(new Color(0x1E2D39));
			button5.setFocusable(false);
			button5.setBorderPainted(false);
			button5.setBounds(350,185,80,30);
			panel1.add(button5);		
			button5.addActionListener(this);
			
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
			table.setFont(new Font("Arial",Font.PLAIN,13));
			table.setBackground(Color.white);
			table.getTableHeader().setFont(new Font("Arial",Font.PLAIN,12));
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

	private void setroomdata() {
		roomno=(String) rno.getSelectedItem();
		try {
       	 Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "Moving@123");
           	 String query1 = "SELECT * FROM add_room WHERE RoomNo = ? ";
	            PreparedStatement st1 = con1.prepareStatement(query1);
	            st1.setString(1, roomno);
	            ResultSet rs1 = st1.executeQuery();
	            
	            while (rs1.next()) {
	                ac_nonac= rs1.getString("AC_NonAC");
	                roomtype = rs1.getString("RoomType");
	                roomprice = rs1.getString("RoomPrice");
	             
	            }
	            
	            type1.setSelectedItem(ac_nonac);
                text5.setText(roomprice);
                type.setSelectedItem(roomtype);
		}
			catch(SQLException e2) {
				JOptionPane.showMessageDialog(null, "Error: " + e2.getMessage());
	            e2.printStackTrace();
			}
	}
	
	 private void JtabelDataShow(java.awt.event.MouseEvent e) {
	    	int i = table.getSelectedRow();
	    	model =(DefaultTableModel) table.getModel();
	    	model.getValueAt(i, 0).toString();
	    	text1.setText(model.getValueAt(i, 1).toString());
	    	text2.setText(model.getValueAt(i, 2).toString());
	    	String num=model.getValueAt(i, 3).toString();
	    	rno.setSelectedItem(num);
	    	String ac =model.getValueAt(i, 4).toString();
	    	type1.setSelectedItem(ac);
	    	
	    	String room =model.getValueAt(i, 5).toString();
	    	type.setSelectedItem(room);
	    	
	    	
	    	text5.setText(model.getValueAt(i, 6).toString());
	    	
	    	String check =model.getValueAt(i, 7).toString();
	    	
	    	if(check.equals("Yes")) {
	    		box.setSelected(true);
	    		mtime.setEnabled(true);
	    		mtype.setEnabled(true);
	    		String mt =model.getValueAt(i, 8).toString();
		    	mtime.setSelectedItem(mt);

		    	String mty =model.getValueAt(i, 9).toString();
		    	mtype.setSelectedItem(mty);
		    	
		    	text6.setText(model.getValueAt(i, 10).toString());
		    	
	    	}
	    	
	    }
	 
	 private void checkindata() {
		 name=text1.getText();
	    	cnic=text2.getText();
	    	roomno=(String) rno.getSelectedItem();
	    	try {
	        	 Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "Moving@123");
	            	 String query3 = "SELECT * FROM  customer WHERE CNIC = ? ";
	 	            PreparedStatement st3 = con3.prepareStatement(query3);
	 	            st3.setString(1, cnic);
	 	            
	 	            ResultSet rs1 = st3.executeQuery();
	 	            
	 	            while (rs1.next()) {
	 	                cname = rs1.getString("Name");
	 	                ccnic = rs1.getString("CNIC");
	 	            }
	 	            if((name.equals(cname)) && (cnic.equals(ccnic))) {
	 	            	check1=true;
	 	            }
	 	            st3.close();
	 	            con3.close();
				}
				catch(SQLException e2) {
					JOptionPane.showMessageDialog(null, "Error: " + e2.getMessage());
		            e2.printStackTrace();
				}
	    		if(check1) {
	    			
	    		}
	    		else {
	    			JOptionPane.showMessageDialog(null, "CNIC or NAME not Matched with Customer Registered");
	    		}
	    	try {
	          	 Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "Moving@123");
	              	 String query1 = "SELECT RoomStatus FROM add_room WHERE RoomNo = ? ";
	   	            PreparedStatement st1 = con1.prepareStatement(query1);
	   	            st1.setString(1, roomno);
	   	            ResultSet rs1 = st1.executeQuery();
	   	            
	   	            while (rs1.next()) {
	   	                roomstatus = rs1.getString("RoomStatus");
	   	               
	   	            }
	   	            rs1.close();
	   	            st1.close();
	   	            con1.close();
	   			}
	   			catch(SQLException e2) {
	   				JOptionPane.showMessageDialog(null, "Error: " + e2.getMessage());
	   	            e2.printStackTrace();
	   			}
	    	if(roomstatus.equals("Booked")) {
	    		check3=false;
	    		JOptionPane.showMessageDialog(null, "Room is already booked");
	    	}
	    	else if(check3 && check1) {
	    		type1.setSelectedItem(roomtype);
		    	text5.setText(roomprice);
		    	ac_nonac=""+type1.getSelectedItem();
		    	roomtype=""+type.getSelectedItem();
		    	roomprice=text5.getText();
		    	if(box.isSelected()) {
		    		mealadd="Yes";
		    		time=""+mtime.getSelectedItem();
		    		Type=""+mtype.getSelectedItem();
			    	mealprice=text6.getText();
		    	}
		    	else {
		    		mealadd="No";
		    		time=" ";
			    	Type=" ";
			    	mealprice="0";
		    	}
		    	checkindate=area.getText();

		    		try
		    		{
		    			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","Moving@123");
		    			PreparedStatement st= con.prepareStatement("INSERT INTO checkin(CustomerName,CNIC,RoomNo,AC_NonAC,RoomType,RoomPrice,AddMeal,MealTime,MealType,MealPrice,CheckinDate) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
		    			st.setString(1, name);
		    			st.setString(2, cnic);
		    			st.setString(3, roomno);
		    			st.setString(4, ac_nonac);
		    			st.setString(5, roomtype);
		    			st.setString(6, roomprice);
		    			st.setString(7, mealadd);
		    			st.setString(8, time);
		    			st.setString(9, Type);
		    			st.setString(10, mealprice);
		    			st.setString(11, checkindate);
		    			check2=true;
		    			int row=st.executeUpdate();
		    			if(row>0) {
		    				JOptionPane.showMessageDialog(null, "Inserted data in the checkin table.");
		    			}
		    			else {
		    				JOptionPane.showMessageDialog(null, "Data is not Inserted in the checkin table.");
		    			}
		    			st.close();
		    			
		    			PreparedStatement st1 = con.prepareStatement("INSERT INTO checkout(CustomerName,CustomerCNIC,RoomNo,RoomType,RoomPrice,MealPrice,CheckinDate) VALUES(?,?,?,?,?,?,?)");
					    st1.setString(1, name);
					    st1.setString(2, cnic);
					    st1.setString(3, roomno);
					    st1.setString(4, roomtype);
					    st1.setString(5, roomprice);
					    st1.setString(6, mealprice);
					    st1.setString(7, checkindate);
					    st1.executeUpdate();
		    			st1.close();
		    			
		    			String status;
		    			if(check2) {
		    				status="Booked";
		    			}
		    			else {
		    				status="Free";
		    			}
		       			PreparedStatement st2= con.prepareStatement("UPDATE add_room SET RoomStatus = ?  WHERE RoomNo = ?");
		       			st2.setString(1, status);
		       			st2.setString(2, roomno);
		       			st2.executeUpdate();
		   		           
		   		        st2.close();
		   	            st1.close();
		   	            con.close();
		   			}
		    		
		    		catch (SQLException e1) {
		    			// TODO Auto-generated catch block
		    			JOptionPane.showMessageDialog(null, "Error is: " + e1);
		    			e1.printStackTrace();
		    		} 
		    		
		    		text1.setText("");
	    			text2.setText("");
	    			
	    	}
	 }
	 
	 private void selectcheckin() {
		 try {
        	 model.setRowCount(0);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "Moving@123");
            String query = "SELECT * FROM checkin";
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
            rs.close();
            st.close();
            con.close();
        } 
        catch (SQLException e1) {
           JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
            e1.printStackTrace();
        }

        // Set preferred width of columns
        table.getColumnModel().getColumn(0).setPreferredWidth(70);
        table.getColumnModel().getColumn(1).setPreferredWidth(180);
        table.getColumnModel().getColumn(2).setPreferredWidth(180);
        table.getColumnModel().getColumn(3).setPreferredWidth(120);
        table.getColumnModel().getColumn(4).setPreferredWidth(130);
        table.getColumnModel().getColumn(5).setPreferredWidth(130);
        table.getColumnModel().getColumn(6).setPreferredWidth(120);
        table.getColumnModel().getColumn(7).setPreferredWidth(120);
        table.getColumnModel().getColumn(8).setPreferredWidth(150);
        table.getColumnModel().getColumn(9).setPreferredWidth(150);
        table.getColumnModel().getColumn(10).setPreferredWidth(80);
        table.getColumnModel().getColumn(11).setPreferredWidth(120);
	 }
	 
	 public void deletecheckin() {
		 cnic = text2.getText();
			try
 		{
 			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","Moving@123");
 			String query = "DELETE FROM checkin WHERE CNIC = ?";
 			PreparedStatement st= con.prepareStatement(query);
 			st.setString(1, cnic);
 			int row =st.executeUpdate();
 			if(row>0) {
 				 JOptionPane.showMessageDialog(null, "Deleted data from the checkin table"); 
 			}
 			else {
 				JOptionPane.showMessageDialog(null, "No Data Deleted from the checkin table"); 
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
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(box.isSelected()) {
			mtype.setEnabled(true);
			mtime.setEnabled(true);
			text6.setText("2000");
		}
		else {
			mtype.setEnabled(false);
			mtime.setEnabled(false);
		}
		if(e.getSource()==button) {
					// TODO Auto-generated method stub
			checkindata();
			    	
			        } 
		if(e.getSource()==button2) {
			  selectcheckin();
			}
		if(e.getSource()==button3) {
			deletecheckin();
		}
		if(e.getSource()==button4) {
			m.Show();
			dispose();
		}
	}				
}