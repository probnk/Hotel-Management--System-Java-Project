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
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import java.sql.ResultSetMetaData;

class Add_Room extends JFrame implements ActionListener{
		private String Type,ac_nonac,number,price,status;
		private String room[]= {"Suite","Duplex","Family"};
		private String ac[]= {"AC","Not AC"};
		private JTable table;
		private DefaultTableModel model;
		private JScrollPane scrollPane;
		private JPanel panel1,panel2,panel3,panel4,panel5,panel6;
		private JLabel label,label1,label2,label3,label4,label5,label6,label7,label8,label9,label10;
		private JTextField text1,text5;
		private JTextArea area;
		private Image img,temp;
		private ImageIcon image;
		private Menu m; 
		private JComboBox type,type1;
		private JButton button3,button4,button5;
		
	void Room() {
		
		setTitle("Manage Room");
		
		panel1 = new JPanel();
		panel1.setBackground(new Color(0x1E2D39));
		panel1.setBounds(0, 150, 480, 620);
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
		
		label = new JLabel("MANAGING ROOM");
		label.setForeground(Color.ORANGE);
		label.setFont(new Font("Calibri",Font.BOLD,34));
		label.setBounds(100,30,300,50);
		panel1.add(label);
		
		label1 = new JLabel("Room Number ");
		label1.setForeground(Color.ORANGE);
		label1.setFont(new Font("Arial",Font.PLAIN,16));
		label1.setBounds(80,120,180,30);
		panel1.add(label1);
		
		text1 = new JTextField();
		text1.setFont(new Font("Arial",Font.PLAIN,16));
		text1.setBounds(250,120,200,30);
		panel1.add(text1);
		
		label2 = new JLabel("Room AC/Non AC ");
		label2.setForeground(Color.ORANGE);
		label2.setFont(new Font("Arial",Font.PLAIN,16));
		label2.setBounds(80,180,200,30);
		panel1.add(label2);
		
		type1 = new JComboBox(ac);
		type1.setFont(new Font("Arial",Font.PLAIN,16));
		type1.setBounds(250,180,100,30);
		panel1.add(type1);
		
		label7 = new JLabel("Select ");
		label7.setForeground(Color.ORANGE);
		label7.setFont(new Font("Arial",Font.BOLD,14));
		label7.setBounds(360,180,60,30);
		panel1.add(label7);
		
		label3 = new JLabel("Room Status ");
		label3.setForeground(Color.ORANGE);
		label3.setFont(new Font("Arial",Font.PLAIN,16));
		label3.setBounds(80,240,200,30);
		panel1.add(label3);
		
		area = new JTextArea("Free");
		area.setFont(new Font("Arial",Font.PLAIN,16));
		area.setBounds(250,240,100,30);
		area.setEditable(false);
		panel1.add(area);
		
		label8 = new JLabel("Initial Status");
		label8.setForeground(Color.ORANGE);
		label8.setFont(new Font("Arial",Font.BOLD,14));
		label8.setBounds(360,240,120,30);
		panel1.add(label8);
		
		label4 = new JLabel("Room Type ");
		label4.setForeground(Color.ORANGE);
		label4.setFont(new Font("Arial",Font.PLAIN,16));
		label4.setBounds(80,300,180,30);
		panel1.add(label4);
		
		label6 = new JLabel("Select ");
		label6.setForeground(Color.ORANGE);
		label6.setFont(new Font("Arial",Font.BOLD,14));
		label6.setBounds(360,300,60,30);
		panel1.add(label6);
		
		type = new JComboBox(room);
		type.setFont(new Font("Arial",Font.PLAIN,16));
		type.setBounds(250,300,100,30);
		panel1.add(type);
		
		label9 = new JLabel("Room Price ");
		label9.setForeground(Color.ORANGE);
		label9.setFont(new Font("Arial",Font.PLAIN,16));
		label9.setBounds(80,350,180,30);
		panel1.add(label9);
		
		text5 = new JTextField("8000");
		text5.setFont(new Font("Arial",Font.PLAIN,16));
		text5.setBounds(250,350,100,30);
		panel1.add(text5);
		
		m = new Menu();
		
		type.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(type.getSelectedItem().equals("Suite"))
		    	{
		    		text5.setText("8000");
		    	}
				else if(type.getSelectedItem().equals("Duplex"))
		    	{
		    		text5.setText("10000");
		    	}
				else if(type.getSelectedItem().equals("Family"))
		    	{
		    		text5.setText("12000");
		    	}
			}
		});

		label10 = new JLabel("Rupees");
		label10.setForeground(Color.ORANGE);
		label10.setFont(new Font("Arial",Font.BOLD,14));
		label10.setBounds(360,350,120,30);
		panel1.add(label10);
		
		button3 = new JButton("Modify");
		button3.setForeground(Color.ORANGE);
		button3.setFont(new Font("Arial",Font.PLAIN,16));
		button3.setBackground(new Color(0x00FFEF));
		button3.setForeground(new Color(0,0,0));
		button3.setFocusable(false);
		button3.setBorderPainted(false);
		button3.setBounds(310,420,100,30);
		panel1.add(button3);		
		button3.addActionListener(this);
		
		label5 = new JLabel("Submitted Successfully");	
		label5.setForeground(Color.ORANGE);
		label5.setFont(new Font("Arial",Font.PLAIN,16));
		label5.setBounds(160,460,170,35);
		label5.setVisible(false);
		panel1.add(label5);
		
		button4 = new JButton("Refresh");
		button4.setForeground(Color.ORANGE);
		button4.setFont(new Font("Arial",Font.PLAIN,16));
		button4.setBackground(new Color(0x1E2D39));
		button4.setForeground(new Color(250,250,250));
		button4.setFocusable(false);
		button4.setBorderPainted(false);
		button4.setBounds(430,30,100,30);
		panel4.add(button4);
		button4.addActionListener(this);
		
		button5 = new JButton("Back");
		button5.setForeground(Color.ORANGE);
		button5.setFont(new Font("Arial",Font.PLAIN,16));
		button5.setBackground(new Color(0x00FFEF));
		button5.setForeground(new Color(0,0,0));
		button5.setFocusable(false);
		button5.setBorderPainted(false);
		button5.setBounds(190,420,100,30);
		panel1.add(button5);
		button5.addActionListener(this);
		
		label7 = new JLabel("ROOM DETAILS");
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
	
	  private void JtabelDataShow(java.awt.event.MouseEvent e) {
	    	int i = table.getSelectedRow();
	    	model =(DefaultTableModel) table.getModel();
	    	text1.setText(model.getValueAt(i, 1).toString());
	    	String ac=model.getValueAt(i, 2).toString();
	    	type1.setSelectedItem(ac);
	    	String room=model.getValueAt(i, 3).toString();
	    	type.setSelectedItem(room);
	    	area.setText(model.getValueAt(i, 4).toString());
	    	text5.setText(model.getValueAt(i, 5).toString());
	    }
	  
	  private void updateroom(){
			number=text1.getText();
        	ac_nonac= (String) type1.getSelectedItem();
        	status="Free";
        	Type=""+type.getSelectedItem();
        	price = text5.getText();
    		try{
    			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","Moving@123");
    			String query = "UPDATE add_room SET AC_NonAC = ?, RoomType = ? , RoomStatus= ?, RoomPrice = ? WHERE RoomNo = ?";
                PreparedStatement st = con.prepareStatement(query);
                st.setString(1, ac_nonac);
                st.setString(2, Type);
                st.setString(3, status);
                st.setString(4, price);
                st.setString(5, number);
                
                int rowsUpdated = st.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Updated data in the add room table.");
                } 
                else {
                    JOptionPane.showMessageDialog(null, "No rows were updated in the add room table.");
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
    		text5.setText("");
	  }
	  
	 private void roomtable(){
		  try {
	        	 model.setRowCount(0);
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "Moving@123");
	            String query = "SELECT * FROM add_room";
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
	           // JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
	            e1.printStackTrace();
	        }

	        // Set preferred width of columns
	        table.getColumnModel().getColumn(0).setPreferredWidth(100);
	        table.getColumnModel().getColumn(1).setPreferredWidth(200);
	        table.getColumnModel().getColumn(2).setPreferredWidth(150);
	        table.getColumnModel().getColumn(3).setPreferredWidth(120);
	        table.getColumnModel().getColumn(4).setPreferredWidth(80);
	        table.getColumnModel().getColumn(5).setPreferredWidth(300);
	  }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==button3) {
			updateroom();
    	
		}
		if(e.getSource()==button4) {
			roomtable();
		}
		if(e.getSource()==button5) {
			m.Show();
			dispose();
		}
	}
}