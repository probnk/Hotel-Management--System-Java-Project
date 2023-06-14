import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;


class Bill extends Checkout{
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private JPanel panel,panel1,panel2,panel3,panel4,panel5;
	private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,label14,label15;
	private JTextArea area1,area2,area3,area4,area5,area6,area7,area8;
	private Image img1,img2,img3,img4,temp1,temp2,temp3,temp4;
	private ImageIcon image1,image2,image3,image4;

	void roomBill() {
	
		setTitle("Customer Room Bill");
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0,120,566,270);
		
		panel1 = new JPanel();
		panel1.setBackground(new Color(0x1E2D39));
		panel1.setBounds(0,0,636,100);
		
		panel2 = new JPanel();
		panel2.setBackground(Color.ORANGE);
		panel2.setBounds(566,120,70,410);
		
		panel3 = new JPanel();
		panel3.setBackground(new Color(0x00FFEF));
		panel3.setBounds(0,100,636,20);
		
		panel4 = new JPanel();
		panel4.setBackground(Color.WHITE);
		panel4.setBounds(0,390,571,44);
		
		panel5 = new JPanel();
		panel5.setBackground(Color.WHITE);
		panel5.setBounds(0,434,570,95);
		
		image1 = new ImageIcon("Hotel.png");
		img1=image1.getImage();
		temp1=img1.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		image1=new ImageIcon(temp1);
		
		label1 = new JLabel(image1);
		label1.setBounds(20,0,100,100);
		panel1.add(label1);
		
		label2 = new JLabel();
		label2.setText("  www.UmarandMohsinHotel.com");
		label2.setForeground(new Color(250,250,250));
		label2.setFont(new Font("Arial",Font.BOLD,14));
		label2.setBackground(new Color(0x1E2D39));
		label2.setOpaque(true);
		label2.setBounds(250,35,240, 30);
		panel1.add(label2);
		
		label3 = new JLabel();
		label3.setText("  Mobile NO : +923170731446");
		label3.setForeground(new Color(250,250,250));
		label3.setFont(new Font("Calibri",Font.BOLD,14));
		label3.setBackground(new Color(0x1E2D39));
		label3.setOpaque(true);
		label3.setBounds(250,60,220,30);
		panel1.add(label3);
		
		label13 = new JLabel("BILL TO");
		label13.setFont(new Font("Calibri",Font.BOLD,24));
		label13.setBounds(80,10,100,50);
		panel.add(label13);
		
		label4 = new JLabel("Name");
		label4.setFont(new Font("Arial",Font.BOLD,16));
		label4.setBounds(80,60,100,40);
		panel.add(label4);
		
		area1 = new JTextArea();
		area1.setFont(new Font("Calibri Light (Headings)",Font.PLAIN,14));
		area1.setBounds(80,90,100,30);
		area1.setEditable(false);
		panel.add(area1);
		
		label5 = new JLabel("CNIC Number");
		label5.setFont(new Font("Arial",Font.BOLD,16));
		label5.setBounds(80,120,150,40);
		panel.add(label5);
		
		area2 = new JTextArea();
		area2.setFont(new Font("Calibri Light (Headings)",Font.PLAIN,14));
		area2.setBounds(80,150,130,30);
		area2.setEditable(false);
		panel.add(area2);
		
		label6 = new JLabel("Address");
		label6.setFont(new Font("Arial",Font.BOLD,16));
		label6.setBounds(80,180,100,40);
		panel.add(label6);
		
		area3 = new JTextArea();
		area3.setFont(new Font("Calibri Light ",Font.PLAIN,14));
		area3.setBounds(80,210,180,50);
		area3.setEditable(false);
		panel.add(area3);
		
		label7 = new JLabel("Receipt No");
		label7.setFont(new Font("Arial",Font.BOLD,16));
		label7.setBounds(310,60,100,40);
		panel.add(label7);
		
		area4 = new JTextArea();
		area4.setFont(new Font("Calibri Light (Headings)",Font.PLAIN,14));
		area4.setBounds(310,90,100,30);
		area4.setEditable(false);
		panel.add(area4);
		
		label8 = new JLabel();
		label8.setText("                      HOTEL RECEIPT");
		label8.setForeground(new Color(250,250,250));
		label8.setFont(new Font("Bell MT",Font.BOLD,24));
		label8.setBackground(new Color(0x1E2D39));
		label8.setOpaque(true);
		label8.setBounds(120,0,510, 40);
		panel1.add(label8);
		
		label9 = new JLabel("Receipt Date");
		label9.setFont(new Font("Arial",Font.BOLD,16));
		label9.setBounds(310,110,100,40);
		panel.add(label9);
		
		area5 = new JTextArea();
		area5.setFont(new Font("Calibri Light (Headings)",Font.PLAIN,14));
		area5.setBounds(310,140,100,30);
		area5.setEditable(false);
		panel.add(area5);
		
		label10 = new JLabel("Checkin Date");
		label10.setFont(new Font("Arial",Font.BOLD,16));
		label10.setBounds(310,155,100,40);
		panel.add(label10);
		
		area6 = new JTextArea();
		area6.setFont(new Font("Calibri Light (Headings)",Font.PLAIN,14));
		area6.setBounds(310,185,100,25);
		area6.setEditable(false);
		panel.add(area6);
		
		label11 = new JLabel("Checkout Date");
		label11.setFont(new Font("Arial",Font.BOLD,16));
		label11.setBounds(310,205,130,30);
		panel.add(label11);
		
		area7 = new JTextArea();
		area7.setFont(new Font("Calibri Light (Headings)",Font.PLAIN,14));
		area7.setBounds(310,230,100,30);
		area7.setEditable(false);
		panel.add(area7);
		
		label12 = new JLabel("Total Bill");
		label12.setFont(new Font("Arial",Font.BOLD,16));
		label12.setBounds(320,10,100,40);
		panel5.add(label12);
		
		area8 = new JTextArea();
		area8.setFont(new Font("Arial",Font.PLAIN,16));
		area8.setForeground(new Color(250,250,250));
		area8.setBackground(new Color(0x1E2D39));
		area8.setBounds(400,20,100,25);
		area8.setEditable(false);
		panel5.add(area8);
		
		image2 = new ImageIcon("bed.png");
		img2=image2.getImage();
		temp2=img2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		image2=new ImageIcon(temp2);
		
		label13 = new JLabel(image2);
		label13.setBounds(430,40,100,100);
		panel.add(label13);
		
		image3 = new ImageIcon("plate.png");
		img3=image3.getImage();
		temp3=img3.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		image3=new ImageIcon(temp3);
		
		label14 = new JLabel(image3);
		label14.setBounds(430,100,100,100);
		panel.add(label14);
		
		image4 = new ImageIcon("cup.png");
		img4=image4.getImage();
		temp4=img4.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		image4=new ImageIcon(temp4);
		
		label15 = new JLabel(image4);
		label15.setBounds(430,170,100,100);
		panel.add(label15);
        
		panel.setLayout(new BorderLayout());
		panel1.setLayout(new BorderLayout());
		panel2.setLayout(new BorderLayout());
		panel3.setLayout(new BorderLayout());
		panel4.setLayout(new BorderLayout());
		panel5.setLayout(new BorderLayout());
		
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
        
        panel4.add(scrollPane,BorderLayout.CENTER);
         
	    getContentPane().add(label8);
	    getContentPane().add(panel);
	    getContentPane().add(panel1);
	    getContentPane().add(panel2);
	    getContentPane().add(panel3);
	    getContentPane().add(panel4);
	    getContentPane().add(panel5);
	    
	    setBounds(250,100,650,530);
	    setLayout(null);
	    setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setResizable(false);

	}
	
	
	public void billtable(String m) {
			
		try {
	    	 model.setRowCount(0);
	    	 String num = m;
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "Moving@123");
	        String query = "SELECT * FROM bill WHERE CNIC = ?";
	        PreparedStatement st = con.prepareStatement(query);
	        st.setString(1, num);
	        ResultSet rs = st.executeQuery();
	        ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
	        int columnCount = rsmd.getColumnCount();

	        // Set column names in the table model
	        Vector<String> columnNames = new Vector<>();
	        for (int i = 5; i <= 9; i++) {
	            columnNames.add(rsmd.getColumnName(i));
	        }
	        model.setColumnIdentifiers(columnNames);
	        // Populate data in the table model
	        while (rs.next()) {
	        
	            Vector<Object> rowData = new Vector<>();
	           
	            for (int i = 1; i <= columnCount; i++) {
	            	if(i==1) {
	            		area4.setText(rs.getString(i));
	            	}
	            	else if(i==2) {
	            		area1.setText(rs.getString(i));
	            	}
	            	if(i==3) {
	            		area2.setText(rs.getString(i));
	            	}
	            	if(i==4) {
	            		area3.setText(rs.getString(i));
	            	}
	            	if(i==10) {
	            		area6.setText(rs.getString(i));
	            	}
	            	if(i==11) {
	            		area7.setText(rs.getString(i));
	            	}
	            	if(i==12) {
	            		area8.setText("RS "+rs.getString(i));
	            	}
	            	if(i==13) {
	            		area5.setText(rs.getString(i));
	            	}
	            	else if((i==5)  || (i==6) || (i==7) || (i==8) || (i==9)){
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
		try
 		{
 			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","Moving@123");
 			String query = "DELETE FROM checkout WHERE CustomerCNIC = ?";
 			PreparedStatement st= con.prepareStatement(query);
 			st.setString(1, m);
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
	
}