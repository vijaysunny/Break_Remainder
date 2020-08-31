package summm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;
import java.awt.event.MouseMotionAdapter;

public class Feed extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField mail;
int xmouse,ymouse;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feed frame = new Feed();
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
	public Feed() {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				setLocation(x-xmouse,y-ymouse);
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				xmouse=arg0.getXOnScreen();
				ymouse=arg0.getYOnScreen();
				
			}
		});
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 594, 634);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEmployeeName.setBounds(208, 56, 106, 28);
		panel_1.add(lblEmployeeName);
		
		Name = new JTextField();
		Name.setBounds(208, 93, 225, 28);
		panel_1.add(Name);
		Name.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblGender.setBounds(208, 190, 68, 28);
		panel_1.add(lblGender);
		
		JComboBox<String> Gender = new JComboBox<String>();
		Gender.setBackground(Color.WHITE);
		Gender.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		Gender.setBounds(208, 225, 227, 28);
		Gender.addItem(" ");
		Gender.addItem("Male");
		Gender.addItem("Female");
		Gender.addItem("Transgender");
		panel_1.add(Gender);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAge.setBounds(206, 264, 68, 26);
		panel_1.add(lblAge);
		
		@SuppressWarnings("rawtypes")
		JComboBox<Comparable> Age = new JComboBox<Comparable>();
		Age.setBackground(Color.WHITE);
		Age.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		Age.setBounds(206, 293, 227, 28);int i=18;
		Age.addItem(" ");
		for(i=18;i<=100;i++)
		{
			Age.addItem(i);
		}
		panel_1.add(Age);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEmail.setBounds(208, 132, 68, 26);
		panel_1.add(lblEmail);
		
		mail = new JTextField();
		mail.setBounds(208, 162, 227, 28);
		panel_1.add(mail);
		mail.setColumns(10);
		
		JLabel lblComment = new JLabel("Comment");
		lblComment.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblComment.setBounds(208, 340, 68, 28);
		panel_1.add(lblComment);
		
		JTextArea cmnt = new JTextArea();
		cmnt.setBorder(UIManager.getBorder("TextField.border"));
		cmnt.setLineWrap(true);
		cmnt.setBounds(206, 379, 227, 114);
		panel_1.add(cmnt);
		
			
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(344, 545, 89, 35);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Submit\r\n");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
					  
		                Connection connection;
						try {
							connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/feedback?serverTimezone=UTC", "root", "");
						
		                String sql="insert into feedback_form values (?, ?, ?, ?, ?, ?, ?)";
		                PreparedStatement pst=connection.prepareStatement(sql);
		                java.util.Date date=new java.util.Date();
		                java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		                java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
		                
		                pst.setString(1,Name.getText());
		                pst.setString(2,mail.getText());
		               
		                String combo;
						  combo=Gender.getSelectedItem().toString();
						  
		 pst.setString(3, combo);
		 String comb;
		 comb=Age.getSelectedItem().toString();
		 pst.setString(4, comb);
		               
		               pst.setString(5,cmnt.getText());
		                pst.setDate(6,sqlDate);
		                pst.setTimestamp(7,sqlTime);
		               
		               if(Name.getText().trim().isEmpty()||combo.startsWith(" ")||comb.startsWith(" ")||mail.getText().trim().isEmpty()||cmnt.getText().trim().isEmpty())
						  {
							  JOptionPane.showMessageDialog(null, " All fields are required ");
						  }
		               else if(!Pattern.matches("^[a-zA-Z]+$", Name.getText())){
		                	JOptionPane.showMessageDialog(null, " invalid name");	
		                	Name.setText("");
		                }
		              
		                
		              
		               else  if(!Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-z]+$", mail.getText())){
		                	JOptionPane.showMessageDialog(null, " invalid email-id");	
		                	mail.setText("");
		                }
						  else
						  {
							  pst.executeUpdate();
		               JOptionPane.showMessageDialog(null, "Feedback submitted");
		               dispose();
						  }
			
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(51, 153, 255));
		btnNewButton_1.setBorder(UIManager.getBorder("Button.border"));
		btnNewButton_1.setBounds(208, 545, 89, 35);
		panel_1.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panel.setBackground(new Color(0, 255, 204));
		panel.setBounds(0, -13, 625, 58);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblFeedbackForm = new JLabel("Feedback Form");
		lblFeedbackForm.setForeground(Color.DARK_GRAY);
		lblFeedbackForm.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblFeedbackForm.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFeedbackForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedbackForm.setBounds(207, 11, 193, 45);
		panel.add(lblFeedbackForm);
	}
}
