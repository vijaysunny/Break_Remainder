     
package summm;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;

import java.awt.event.MouseMotionAdapter;

public class Log extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public  static JTextField name;
	public static  JTextField id;
int xmouse;
int ymouse;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log frame = new Log();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Log() {
		this.setLocationRelativeTo(null);
		setUndecorated(true);
		
		
		setBounds(100, 100, 553, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				xmouse=arg0.getXOnScreen();
				ymouse=arg0.getYOnScreen();
				
			}
		});
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent evt) {

				int x=evt.getXOnScreen();
				int y=evt.getYOnScreen();
				setLocation(x-xmouse,y-ymouse);
			}
		});
		panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		panel.setForeground(UIManager.getColor("Button.disabledShadow"));
		panel.setBackground(SystemColor.controlShadow);
		panel.setBounds(0, 0, 553, 61);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblclose = new JLabel("X");
		lblclose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblclose.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int a=JOptionPane.showConfirmDialog(null, "Are you sure to quit?");
				if(a==JOptionPane.YES_OPTION){
					dispose();
				}
				
			}
		});
		
		lblclose.setForeground(Color.WHITE);
		lblclose.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblclose.setBounds(485, 19, 46, 19);
		panel.add(lblclose);
		
		
		JLabel lblmin = new JLabel("-");
		lblmin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setState(JFrame.ICONIFIED);
			}

			
				// TODO Auto-generated method stub
				
		
			
		});
		lblmin.setForeground(Color.WHITE);
		lblmin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblmin.setBounds(451, 6, 24, 44);
		panel.add(lblmin);
		
		JLabel lblBreakReminder = new JLabel("Break Reminder");
		lblBreakReminder.setBackground(SystemColor.activeCaptionBorder);
		lblBreakReminder.setForeground(SystemColor.inactiveCaptionBorder);
		lblBreakReminder.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblBreakReminder.setBounds(25, 11, 183, 44);
		panel.add(lblBreakReminder);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(0, 102, 153));
		panel_1.setBounds(0, 60, 553, 325);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		name = new JTextField();
		name.setBounds(279, 97, 165, 32);
		name.setFont(new Font("Tahoma",Font.PLAIN,14));
		panel_1.add(name);
		name.setColumns(10);
		
		
		JLabel lblUsername = new JLabel("     Name      :\r\n\r\n");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(156, 91, 154, 40);
		panel_1.add(lblUsername);
		
		id = new JTextField();
		id.setBounds(279, 160, 165, 32);
		id.setFont(new Font("Tahoma",Font.PLAIN,14));
		panel_1.add(id);
		id.setColumns(10);
		
		JLabel lblEmplloyeeid = new JLabel("Email-id   :");
		lblEmplloyeeid.setForeground(Color.WHITE);
		lblEmplloyeeid.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmplloyeeid.setBounds(177, 154, 142, 40);
		panel_1.add(lblEmplloyeeid);
		
		JButton btnSubmit = new JButton("Login");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Name = name.getText();
            String Email = id.getText();
            try {
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/login?serverTimezone=UTC", "root", "");

                PreparedStatement st = (PreparedStatement) connection
                    .prepareStatement("Select Name, Email from register where Name=? and Email=?");
                st.setString(1, Name);
                st.setString(2, Email);
               
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    dispose();
                    UserHom obj=new UserHom();
    				obj.setVisible(true);
    				obj.setLocationRelativeTo(null);
    			UserHom.namee.setText(Log.name.getText());
    				UserHom.idd.setText(Log.id.getText());
    				
                    JOptionPane.showMessageDialog(btnSubmit, "You have successfully logged in");
                    String sql="insert into userlogin values (?, ?,?,?)";
	                PreparedStatement pst=connection.prepareStatement(sql);
	                java.util.Date date=new java.util.Date();
	                java.sql.Date sqlDate=new java.sql.Date(date.getTime());
	                java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
	                pst.setString(1,name.getText());
	                
	                pst.setString(2, id.getText());
	                pst.setDate(3,sqlDate);
	                pst.setTimestamp(4,sqlTime);
	                
	                pst.executeUpdate();
    				
                } 
                else if(name.getText().trim().isEmpty()||

 id.getText().trim().isEmpty()){
	
    JOptionPane.showMessageDialog(btnSubmit, "All fields are required");
}
else
{
	JOptionPane.showMessageDialog(btnSubmit, "invalid Name or Email-id");	
}
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
				
			}
		});
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBackground(SystemColor.textHighlight);
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSubmit.setBounds(283, 226, 89, 23);
		panel_1.add(btnSubmit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				name.setText("");
				id.setText("");
			   }
		});
		btnReset.setBackground(Color.RED);
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBounds(401, 226, 89, 23);
		panel_1.add(btnReset);
		
		JLabel lblNewLabel = new JLabel(" User Login \r\n");
		lblNewLabel.setBounds(279, 30, 297, 44);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		JLabel lblNewLabel_2 = new JLabel("New User?\r\n Register");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				Register reg=new Register();
				reg.setVisible(true);
				reg.setLocationRelativeTo(null);
			}
		});
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setForeground(new Color(240, 248, 255));
		lblNewLabel_2.setBounds(353, 265, 165, 37);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Click here to Admin login");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				Admin am=new Admin();
				am.setVisible(true);
				am.setLocationRelativeTo(null);
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setBounds(10, 272, 267, 23);
		panel_1.add(lblNewLabel_1);
		
		
	}

	
	}

