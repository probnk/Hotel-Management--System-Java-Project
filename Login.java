import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class Login extends JFrame implements ActionListener {
	private JPanel panel1;
	private JLabel label,label1,label2,label3,label4;
	private JTextField text1;
	private JPasswordField text2;
	private JButton button;
	private ImageIcon image,image2;
	private Image img,img2,temp,temp2;
	private Menu m ;
	
	void login() {
	panel1 = new JPanel();
	panel1.setBackground(new Color(0x1E2D39));
	panel1.setBounds(450, 0, 450, 450);
	
	label = new JLabel("LOGIN");
	label.setForeground(Color.ORANGE);
	label.setFont(new Font("Calibri",Font.PLAIN,48));
	label.setBounds(200, 0,250, 150);
	panel1.add(label);
	
	label1= new JLabel("Admin Name ");
	label1.setForeground(Color.ORANGE);
	label1.setFont(new Font("Calibri",Font.BOLD,20));
	label1.setBounds(50, 150, 120, 30);
	panel1.add(label1);
	
	text1=new JTextField();
	text1.setFont(new Font("Arial",Font.PLAIN,16));
	text1.setBounds(180, 150, 200, 30);
	panel1.add(text1);
	
	label2= new JLabel("Password ");
	label2.setForeground(Color.ORANGE);
	label2.setFont(new Font("Calibri",Font.BOLD,20));
	label2.setBounds(50, 220, 160, 30);
	
	text2=new JPasswordField(15);
	text2.setFont(new Font("Arial",Font.PLAIN,16));
	text2.setBounds(180, 220, 200, 30);
	
	panel1.add(label2);
	panel1.add(text2);
	
	button = new JButton("Login");
	button.setBackground(new Color(0x00FFEF));
	button.setFocusable(false);
	button.setBorderPainted(false);
	button.setBounds(215, 300,100, 30);
	panel1.add(button);
	
	panel1.setLayout(new BorderLayout());
	
	setTitle("Admin Login Page");
	m = new Menu();
	button.addActionListener(this);
	
	image2 = new ImageIcon("bed.png");
	img2=image2.getImage();
	temp2=img2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	image2=new ImageIcon(temp2);
	
	label4 = new JLabel(image2);
	label4.setBounds(290,250,100,100);
	add(label4);
	

	image = new ImageIcon("Hotel.png");
	img=image.getImage();
	temp=img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	image=new ImageIcon(temp);
	
	label3 = new JLabel(image);
	label3.setText("HOTEL MANAGEMENT SYSTEM");
	label3.setIcon(image);
	label3.setHorizontalTextPosition(JLabel.CENTER);
	label3.setVerticalTextPosition(JLabel.BOTTOM);
	label3.setForeground(new Color(0x123456));
	label3.setFont(new Font("Bell MT",Font.BOLD,20));
	label3.setIconTextGap(10);
	label3.setBackground(new Color(0x00FFEF));
	label3.setOpaque(true);
	label3.setBounds(0, 0,450, 450);
	add(label3);
   
    setBounds(250,100,900,486);
    setLayout(null);
    setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	add(panel1);
	setResizable(false);
}
	private void check() {
		  String username = text1.getText();
	        String password = new String(text2.getPassword());

	        try {
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "Moving@123");

	            PreparedStatement st = con.prepareStatement("SELECT * FROM login WHERE AdminName = ? AND Password = ?");
	            st.setString(1, username);
	            st.setString(2, password);
	            
	            ResultSet rs = st.executeQuery();

	            if (rs.next()) {
	            	String storedName = rs.getString("AdminName");
	                String storedPassword = rs.getString("Password");

	                if (password.equals(storedPassword) && username.equals(storedName)) {
	                    m.Show();
	                    dispose();
	                    text1.setText("");
	                    text2.setText("");
	                    
	                } 
	                else {
	                    JOptionPane.showMessageDialog(null, "Incorrect password!", "Error", JOptionPane.ERROR_MESSAGE);
	                    text2.setText("");
	                }
	            }
	            else {
	                JOptionPane.showMessageDialog(null, "Username not found!", "Error", JOptionPane.ERROR_MESSAGE);
	                text1.setText("");
	                text2.setText("");
	            }

	            con.close();
	        } 
	        catch (Exception e1) {
	            JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
      check();
    }
}