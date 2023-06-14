import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

class Menu extends JFrame implements ActionListener{
	private JLabel label1,label2;
	private JPanel panel;
	private JMenuItem menuitem1,menuitem2,menuitem3,menuitem4,menuitem5,menuitem6;
	private Image img,temp;
	private ImageIcon image;
	private Login l;
	private Customer_Registeration c;
	private Add_Room a;
	private Checkin checkin;
	private Checkout checkout;
	private Employee employee;
	
	void Show() {
		setTitle("Menu");
		
		panel= new JPanel();
		panel.setBackground(new Color(0x1E2D39));
		panel.setBounds(0,0,300,850);
	
		menuitem1= new JMenuItem("Customer Registeration");
		menuitem1.setBounds(30, 350, 220, 30);
		menuitem1.setFont(new Font("Arial",Font.BOLD,16));
		menuitem1.setForeground(Color.orange);
		menuitem1.setBackground(new Color(0x1E2D39));
		panel.add(menuitem1);
		
		menuitem2= new JMenuItem("Manage Room");
		menuitem2.setBounds(30, 400, 150, 30);
		menuitem2.setFont(new Font("Arial",Font.BOLD,16));
		menuitem2.setForeground(Color.orange);
		menuitem2.setBackground(new Color(0x1E2D39));
		panel.add(menuitem2);
		
		menuitem3= new JMenuItem("Room Checkin");
		menuitem3.setBounds(30, 450, 200, 30);
		menuitem3.setForeground(Color.orange);
		menuitem3.setFont(new Font("Arial",Font.BOLD,16));
		menuitem3.setBackground(new Color(0x1E2D39));
		panel.add(menuitem3);
		
		menuitem4= new JMenuItem("Room Checkout");
		menuitem4.setBounds(30, 500, 150, 30);
		menuitem4.setForeground(Color.orange);
		menuitem4.setFont(new Font("Arial",Font.BOLD,16));
		menuitem4.setBackground(new Color(0x1E2D39));
		panel.add(menuitem4);
		
		menuitem5= new JMenuItem("Employee Data");
		menuitem5.setBounds(30, 550, 150, 30);
		menuitem5.setForeground(Color.orange);
		menuitem5.setFont(new Font("Arial",Font.BOLD,16));
		menuitem5.setBackground(new Color(0x1E2D39));
		panel.add(menuitem5);
		
		menuitem6= new JMenuItem("Log Out");
		menuitem6.setBounds(30, 600, 150, 30);
		menuitem6.setFont(new Font("Arial",Font.BOLD,16));
		menuitem6.setForeground(Color.orange);
		menuitem6.setBackground(new Color(0x1E2D39));
		panel.add(menuitem6);
		
		image = new ImageIcon("Hotel.png");
		img=image.getImage();
		temp=img.getScaledInstance(220, 220, Image.SCALE_SMOOTH);
		image=new ImageIcon(temp);
		
		label1 = new JLabel(image);
		label1.setText("HOTEL MANAGEMENT SYSTEM");
		label1.setIcon(image);
		label1.setHorizontalTextPosition(JLabel.CENTER);
		label1.setVerticalTextPosition(JLabel.BOTTOM);
		label1.setForeground(Color.ORANGE);
		label1.setFont(new Font("Bell MT",Font.BOLD,17));
		label1.setIconTextGap(10);
		label1.setBounds(13, 20,280, 280);
		panel.add(label1);
		
		image = new ImageIcon("building.JFIF");
		img=image.getImage();
		temp=img.getScaledInstance(1240, 850, Image.SCALE_SMOOTH);
		image=new ImageIcon(temp);
		
		label2 = new JLabel(image);
		label2.setBounds(300, 0,1240, 856);
		
		c = new Customer_Registeration();
		a = new Add_Room();
		l = new Login();
		checkin = new Checkin();
		checkout = new Checkout();
		employee  = new Employee();
		
		menuitem1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				menuitem1.setBackground(new Color(0x1E2D39));
				menuitem1.setForeground(Color.orange);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				menuitem1.setBackground(new Color(0x00FFEF));
				menuitem1.setForeground(new Color(0x1E2D39));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});	
		
	menuitem2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				menuitem2.setBackground(new Color(0x1E2D39));
				menuitem2.setForeground(Color.orange);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				menuitem2.setBackground(new Color(0x00FFEF));
				menuitem2.setForeground(new Color(0x1E2D39));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});	
	
	menuitem3.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			menuitem3.setBackground(new Color(0x1E2D39));
			menuitem3.setForeground(Color.orange);
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			menuitem3.setBackground(new Color(0x00FFEF));
			menuitem3.setForeground(new Color(0x1E2D39));
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});	
	
	menuitem4.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			menuitem4.setBackground(new Color(0x1E2D39));
			menuitem4.setForeground(Color.orange);
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			menuitem4.setBackground(new Color(0x00FFEF));
			menuitem4.setForeground(new Color(0x1E2D39));
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});	
	
	
	menuitem5.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			menuitem5.setBackground(new Color(0x1E2D39));
			menuitem5.setForeground(Color.orange);
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			menuitem5.setBackground(new Color(0x00FFEF));
			menuitem5.setForeground(new Color(0x1E2D39));
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});	
	
	menuitem6.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			menuitem6.setBackground(new Color(0x1E2D39));
			menuitem6.setForeground(Color.orange);
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			menuitem6.setBackground(new Color(0x00FFEF));
			menuitem6.setForeground(new Color(0x1E2D39));
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});	
	
		menuitem1.addActionListener(this); 
		menuitem2.addActionListener(this); 
		menuitem3.addActionListener(this); 
		menuitem4.addActionListener(this);
		menuitem5.addActionListener(this);
		menuitem6.addActionListener(this); 
		
		panel.setLayout(new BorderLayout());
		
		add(label2);
		add(panel);
		setBounds(-10, 0, 1550, 900);
		setLayout(null);
		setVisible(true);
		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==menuitem1) {
			c.add();
			a.dispose();
			checkin.dispose();
			checkout.dispose();
			employee.dispose();
			l.dispose();
			dispose();
		}
		else if(e.getSource()==menuitem2) {
			a.Room();	
			c.dispose();
			checkin.dispose();
			checkout.dispose();
			employee.dispose();
			l.dispose();
			dispose();
		}
		else if(e.getSource()==menuitem3) {
			checkin.entry();
			a.dispose();
			c.dispose();
			employee.dispose();
			checkout.dispose();
			l.dispose();
			dispose();
			}
		else if(e.getSource()==menuitem4) {
			checkout.exit();
			a.dispose();
			checkin.dispose();
			employee.dispose();
			c.dispose();
			l.dispose();
			dispose();
			}
		else if(e.getSource()==menuitem5) {
			employee.details();
			a.dispose();
			checkin.dispose();
			checkout.dispose();
			l.dispose();
			dispose();
			}
		else if(e.getSource()==menuitem6) {
			l.login();
			a.dispose();
			checkin.dispose();
			employee.dispose();
			checkout.dispose();
			dispose();
		}
	}
}