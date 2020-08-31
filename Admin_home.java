package summm;



import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;

import summm.Log;

import javax.swing.SwingConstants;

import java.awt.SystemColor;
import java.awt.event.MouseMotionAdapter;

public class Admin_home extends JFrame {

	
	private JPanel contentPane;
	
	public static JTextField namee;
	public static JTextField idd;
	int xmouse,ymouse;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_home frame = new Admin_home();
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
	public Admin_home() {
		setTitle("Break");
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 564, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 564, 345);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setIcon(new ImageIcon("C:\\Users\\admin2\\Desktop\\Apps-session-logout-icon.png"));
		btnLogout.setBackground(Color.WHITE);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				Admin ob =new Admin();
				ob.setVisible(true);
				
			}
		});
		btnLogout.setBounds(105, 301, 143, 33);
		panel.add(btnLogout);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				setLocation(x-xmouse,y-ymouse);
			}
		});
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				xmouse=arg0.getXOnScreen();
				ymouse=arg0.getYOnScreen();
			}
		});
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.setBounds(0, 0, 564, 52);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel labelmin = new JLabel("-");
		labelmin.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelmin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setState(JFrame.ICONIFIED);
			}
		});
		labelmin.setBounds(508, 11, 46, 30);
		panel_1.add(labelmin);
		
		JLabel lblNewLabel = new JLabel("BREAK REMINDER \r\n\r\n");
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setBounds(-25, -16, 259, 95);
		panel_1.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		namee = new JTextField();
		namee.setSelectionColor(SystemColor.controlShadow);
		namee.setBackground(SystemColor.control);
		namee.setBounds(73, 176, 192, 33);
		namee.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(namee);
		namee.setColumns(10);
		namee.setEditable(false);
		idd = new JTextField();
		idd.setSelectionColor(SystemColor.controlShadow);
		idd.setBackground(SystemColor.control);
		idd.setBounds(73, 243, 192, 33);
		idd.setFont(new Font("Tahomal",Font.BOLD,14));
		panel.add(idd);
		idd.setColumns(10);
		idd.setEditable(false);
		
		JLabel lblUserProfile = 
				new JLabel("Profile");
		lblUserProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserProfile.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserProfile.setBounds(85, 128, 138, 52);
		panel.add(lblUserProfile);
		
		JTextArea txtrWelcome = new JTextArea();
		txtrWelcome.setEditable(false);
		txtrWelcome.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtrWelcome.setBackground(Color.WHITE);
		txtrWelcome.setWrapStyleWord(true);
		txtrWelcome.setText("      Welcome \r\n           To\r\n  Break Reminder\r\n");
		txtrWelcome.setBounds(283, 78, 216, 83);
		panel.add(txtrWelcome);

		
		JLabel lblClickStartSession = new JLabel("Click here  to view FeedBack\r\n");
		lblClickStartSession.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				setState(Frame.ICONIFIED);
				Jtable jf=new Jtable();
				jf.setVisible(true);
				jf.setLocationRelativeTo(null);
			}
		});
		lblClickStartSession.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClickStartSession.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClickStartSession.setBounds(293, 171, 297, 42);
		panel.add(lblClickStartSession);
		
		JLabel lblClickHereTo = new JLabel("Click here to view User Login Activity");
		lblClickHereTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Jtable2 jt=new Jtable2();
				jt.setVisible(true);
				jt.setLocationRelativeTo(null);
			}
		});
		lblClickHereTo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClickHereTo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClickHereTo.setBounds(289, 224, 275, 33);
		panel.add(lblClickHereTo);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\admin2\\Desktop\\user-settings-icon.png"));
		lblNewLabel_1.setBounds(106, 54, 97, 92);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 175, 82, 34);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email-id");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 243, 82, 33);
		panel.add(lblNewLabel_3);
	}
}

