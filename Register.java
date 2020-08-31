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
import java.util.regex.Pattern;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;

import java.awt.event.MouseMotionAdapter;

public class Register  extends JFrame {

/**
* 
*/
private static final long serialVersionUID = 1L;
private JPanel contentPane;
public  static JTextField Name;
public static  JTextField Id;
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
public Register() {
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
	
	
	JLabel lblmin = new JLabel("  -");
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
	lblmin.setBounds(444, 11, 46, 44);
	panel.add(lblmin);
	
	JLabel lblBreakReminder = new JLabel("Break Reminder");
	lblBreakReminder.setBackground(SystemColor.activeCaptionBorder);
	lblBreakReminder.setForeground(SystemColor.inactiveCaptionBorder);
	lblBreakReminder.setFont(new Font("Tahoma", Font.BOLD, 21));
	lblBreakReminder.setBounds(25, 11, 183, 44);
	panel.add(lblBreakReminder);
	
	JLabel lblNewLabel_1 = new JLabel("X");
	lblNewLabel_1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			dispose();
			Log lo=new Log();
			lo.setVisible(true);
			lo.setLocationRelativeTo(null);
		}
	});
	lblNewLabel_1.setForeground(new Color(240, 248, 255));
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewLabel_1.setBounds(507, 11, 46, 44);
	panel.add(lblNewLabel_1);
	
	JPanel panel_1 = 
			new JPanel();
	panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	panel_1.setBackground(new Color(0, 102, 153));
	panel_1.setBounds(0, 60, 553, 325);
	contentPane.add(panel_1);
	panel_1.setLayout(null);
	
	Name = new JTextField();
	Name.setBounds(292, 97, 180, 32);
	Name.setFont(new Font("Tahoma",Font.PLAIN,14));
	panel_1.add(Name);
	Name.setColumns(10);
	
	
	JLabel lblUsername = new JLabel("     Name      :");
	lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblUsername.setForeground(Color.WHITE);
	lblUsername.setBounds(156, 91, 154, 40);
	panel_1.add(lblUsername);
	
	Id = new JTextField();
	Id.setBounds(292, 160, 180, 32);
	Id.setFont(new Font("Tahoma",Font.PLAIN,14));
	panel_1.add(Id);
	Id.setColumns(10);
	
	JLabel lblEmplloyeeid = new JLabel("Email- id  :");
	lblEmplloyeeid.setForeground(Color.WHITE);
	lblEmplloyeeid.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblEmplloyeeid.setBounds(177, 154, 142, 40);
	panel_1.add(lblEmplloyeeid);
	
	JButton btnSubmit = new JButton("Register");
	btnSubmit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String EmployeeName = Name.getText();
       String Employeeid = Id.getText();
       try {
    	   Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/login?serverTimezone=UTC", "root", "");
			  String sql="insert into register values (?, ?, ?, ?)";
             PreparedStatement pst=connection.prepareStatement(sql);
             java.util.Date date=new java.util.Date();
             java.sql.Date sqlDate=new java.sql.Date(date.getTime());
             java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
             
             pst.setString(1,Name.getText());
             
             pst.setString(2, Id.getText());
             pst.setDate(3,sqlDate);
             pst.setTimestamp(4,sqlTime);
             
             if(Name.getText().trim().isEmpty()||Id.getText().trim().isEmpty())
             {
					  JOptionPane.showMessageDialog(null, "All fields are required");
				  }
             else if(!Pattern.matches("^[a-zA-Z]+$", Name.getText())){
             	JOptionPane.showMessageDialog(null, "invalid name");	
             }
             else  if(!Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", Id.getText())){
             	JOptionPane.showMessageDialog(null, "invalid email-id");	
             }
				  else
				  {
					  pst.execute();
            JOptionPane.showMessageDialog(null, " Registered Successfully");
           dispose();
            Log ah=new Log();
            ah.setVisible(true);
            ah.setLocationRelativeTo(null);
             }
             
	
             		
       } catch (SQLException sqlException) {
           sqlException.printStackTrace();
       }
			
		}
	});
	btnSubmit.setForeground(Color.WHITE);
	btnSubmit.setBackground(SystemColor.textHighlight);
	btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnSubmit.setBounds(292, 225, 109, 23);
	panel_1.add(btnSubmit);
	
	JButton btnReset = new JButton("Reset");
	btnReset.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			Name.setText("");
			Id.setText("");
		   }
	});
	btnReset.setBackground(Color.RED);
	btnReset.setForeground(Color.WHITE);
	btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnReset.setBounds(429, 224, 98, 25);
	panel_1.add(btnReset);
	
	JLabel lblNewLabel = new JLabel(" User Registration");
	lblNewLabel.setBounds(278, 31, 297, 44);
	panel_1.add(lblNewLabel);
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
	
	
}


}

