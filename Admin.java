
package summm;



import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class Admin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public  static JTextField name;
	public static  JTextField id;
int xmouse,ymouse;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		this.setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				setLocation(x-xmouse,y-ymouse);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				xmouse=evt.getXOnScreen();
				ymouse=evt.getYOnScreen();
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
				System.exit(0);
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
		panel_1.setBounds(0, 60, 553, 306);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		name = new JTextField();
		name.setBounds(288, 97, 176, 32);
		name.setFont(new Font("Tahoma",Font.PLAIN,14));
		panel_1.add(name);
		name.setColumns(10);
		
		
		JLabel lblUsername = new JLabel("     Name    :\r\n\r\n");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(156, 91, 154, 40);
		panel_1.add(lblUsername);
		
		id = new JTextField();
		id.setBounds(288, 160, 176, 32);
		id.setFont(new Font("Tahoma",Font.PLAIN,14));
		panel_1.add(id);
		id.setColumns(10);
		
		JLabel lblEmplloyeeid = new JLabel("Email     :");
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
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307"
                		+ "/Login?serverTimezone=UTC", "root", "");

                PreparedStatement st = (PreparedStatement) connection
                    .prepareStatement("Select Name, Email from admin_login where Name=? and Email=?");
                st.setString(1, Name);
                st.setString(2, Email);
               
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    dispose();
    				Admin_home obj=new Admin_home();
    				obj.setVisible(true);
    				obj.setLocationRelativeTo(null);
    			Admin_home.namee.setText(Admin.name.getText());
    				Admin_home.idd.setText(Admin.id.getText());
    			
                    JOptionPane.showMessageDialog(btnSubmit, "You have successfully logged in");
                } 
else if(name.getText().trim().isEmpty()||id.getText().trim().isEmpty()){
	
    JOptionPane.showMessageDialog(btnSubmit, "Fields are empty");
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
		btnSubmit.setBounds(288, 226, 89, 23);
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
		btnReset.setBounds(410, 226, 89, 23);
		panel_1.add(btnReset);
		
		JLabel lblNewLabel = new JLabel("Admin Login \r\n");
		lblNewLabel.setBounds(288, 42, 297, 44);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
	}
}
