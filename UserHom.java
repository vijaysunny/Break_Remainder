package summm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class UserHom extends JFrame {

	Scheduler1 ah=new Scheduler1();
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
					UserHom frame = new UserHom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param <showMessageDialog>
	 */
	public <showMessageDialog> UserHom() {
		setTitle("Break");
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 582, 390);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, Color.BLACK));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		ButtonGroup G=new ButtonGroup();
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setIcon(new ImageIcon("C:\\Users\\admin2\\Desktop\\Apps-session-logout-icon.png"));
		btnLogout.setBackground(SystemColor.inactiveCaptionBorder);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				ah.timer.cancel();
				Log ob =new Log();
				
				ob.setVisible(true);
				
			}
		});
		btnLogout.setBounds(100, 277, 128, 33);
		panel.add(btnLogout);
		JLabel lblClickStartSession = new JLabel("Click Start session to take break reminders\r\n");
		lblClickStartSession.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClickStartSession.setBounds(255, 149, 297, 42);
		panel.add(lblClickStartSession);
		
		JButton btnNewButton = new JButton("Start Session");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings({ "unlikely-arg-type", "deprecation" })
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
					setState(JFrame.ICONIFIED);
				ah.start();
				 JOptionPane.showMessageDialog(null, "Session Started");
				 
				btnNewButton.setEnabled(false);
				
				btnNewButton.hide();
				lblClickStartSession .hide();
				JLabel lblClickStartSession1 = new JLabel("                  Session started\r\n");
				lblClickStartSession1.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblClickStartSession1.setBounds(242, 149, 297, 42);
				panel.add(lblClickStartSession1);
				
				
			/*	String com;
				com=comboBox.getSelectedItem().toString();
				if(com.startsWith("2 Minute"))
				{
					dispose();
					System.setProperty("webdriver.ie.driver", "C:\\Users\\admin2\\Desktop\\IEDriverServer.exe");
				Scheduler1 av=new Scheduler1();
				av.start();
				Userhome2 ab=new Userhome2();
				ab.setVisible(true);
				Userhome2.namee.setText(Log.Name.getText());
				Userhome2.idd.setText(Log.id.getText());
				
			}
				else if(com.startsWith("5 Minute"))
				{
					dispose();
					Scheduler2 ab=new Scheduler2();
					ab.start();
					Userhome2 abc=new Userhome2();
					abc.setVisible(true);
				}
				else  if(com.startsWith("10 Minute"))
				{
					dispose();
					Scheduler2 ab=new Scheduler2();
					ab.start();
					Userhome2 abd=new Userhome2();
					abd.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "please select time interval");
				}*/
			}});
		btnNewButton.setBackground(new Color(51, 153, 51));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(301, 202, 181, 33);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				xmouse=evt.getXOnScreen();
				ymouse=evt.getYOnScreen();
				
			}
		});
		panel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				setLocation(x-xmouse,y-ymouse);
			}
		});
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.setBounds(-11, -17, 583, 69);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel labelmin = new JLabel("-");
		labelmin.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				JLabel lblNewLabel_2 = new JLabel("Minimize");
				lblNewLabel_2.setBounds(421, 54, 70, 22);
				panel.add(lblNewLabel_2);
				
			}
		});
		labelmin.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelmin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setState(JFrame.ICONIFIED);
			}
		});
		labelmin.setBounds(503, 27, 46, 30);
		panel_1.add(labelmin);
		
		JLabel lblNewLabel = new JLabel("BREAK REMINDER \r\n\r\n");
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setBounds(-15, 0, 259, 95);
		panel_1.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btnFeedback = 
				new JButton("Feedback");
		btnFeedback.setBackground(new Color(0, 204, 204));
		btnFeedback.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFeedback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Feed fe=new Feed();
				fe.setVisible(true);
				fe.setLocationRelativeTo(null);
			}
		});
		btnFeedback.setBounds(437, 276, 115, 33);
		panel.add(btnFeedback);
		
		namee = new JTextField();
		namee.setSelectionColor(SystemColor.controlShadow);
		namee.setBackground(SystemColor.control);
		namee.setBounds(70, 165, 175, 33);
		namee.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(namee);
		namee.setColumns(10);
		namee.setEditable(false);
		idd = new JTextField();
		idd.setSelectionColor(SystemColor.controlShadow);
		idd.setBackground(SystemColor.control);
		idd.setBounds(70, 214, 175, 33);
		idd.setFont(new Font("Tahomal",Font.BOLD,14));
		panel.add(idd);
		idd.setColumns(10);
		idd.setEditable(false);
		
		JLabel lblUserProfile = new JLabel("User Profile");
		lblUserProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserProfile.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserProfile.setBounds(78, 118, 138, 52);
		panel.add(lblUserProfile);
		
		JTextArea txtrWelcome = new JTextArea();
		txtrWelcome.setEditable(false);
		txtrWelcome.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtrWelcome.setBackground(Color.WHITE);
		txtrWelcome.setWrapStyleWord(true);
		txtrWelcome.setText("      Welcome \r\n           To\r\n  Break Reminder\r\n");
		txtrWelcome.setBounds(282, 63, 189, 83);
		panel.add(txtrWelcome);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("\r\n");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\admin2\\Desktop\\Folders-OS-User-No-Frame-Metro-icon.png"));
		lblNewLabel_1.setBounds(115, 63, 68, 57);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Email-id");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(11, 214, 69, 33);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Name");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(11, 165, 59, 33);
		panel.add(lblNewLabel_4);
		
		
		
		
		
	}
}
