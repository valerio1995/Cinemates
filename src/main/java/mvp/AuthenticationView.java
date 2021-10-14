package mvp;
import javax.swing.ImageIcon;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AuthenticationView extends JFrame implements AuthenticationInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldEmail;
	private JPasswordField fieldPassword;
	private JButton buttonAuthenticate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthenticationView frame = new AuthenticationView();
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
	public AuthenticationView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 394);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtAreaAuthentication = new JTextPane();
		txtAreaAuthentication.setText("Autenticazione");
		txtAreaAuthentication.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		txtAreaAuthentication.setEditable(false);
		txtAreaAuthentication.setBounds(10, 11, 106, 27);
		contentPane.add(txtAreaAuthentication);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBounds(-40, 43, 533, 285);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnAdministrationOfCinemates = new JTextPane();
		txtpnAdministrationOfCinemates.setBounds(100, 11, 358, 113);
		panel.add(txtpnAdministrationOfCinemates);
		txtpnAdministrationOfCinemates.setText("Amministrazione di CineMates20");
		txtpnAdministrationOfCinemates.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		txtpnAdministrationOfCinemates.setEditable(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(213, 67, 10, 10);
		panel.add(panel_1);
		
		fieldEmail = new JTextField();
		fieldEmail.setBounds(155, 162, 228, 20);
		panel.add(fieldEmail);
		fieldEmail.setColumns(10);
		
		fieldPassword = new JPasswordField();
		fieldPassword.setBounds(155, 213, 228, 20);
		panel.add(fieldPassword);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setText("E-mail");
		txtpnEmail.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtpnEmail.setEditable(false);
		txtpnEmail.setBounds(155, 135, 44, 27);
		panel.add(txtpnEmail);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setText("Password");
		txtpnPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtpnPassword.setEditable(false);
		txtpnPassword.setBounds(155, 186, 70, 27);
		panel.add(txtpnPassword);
		
		buttonAuthenticate = new JButton("Autenticati");
		buttonAuthenticate.setBackground(Color.LIGHT_GRAY);
		buttonAuthenticate.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		buttonAuthenticate.setBounds(208, 247, 127, 27);
		buttonAuthenticate.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				checkFields(fieldEmail.getText(), fieldPassword.getText());
				
			}
		});
		panel.add(buttonAuthenticate);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\valer\\Desktop\\eclipse-workspace\\maven-demo\\icon\\posta.jpg"));
		lblNewLabel.setBounds(111, 165, 34, 17);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\valer\\Desktop\\eclipse-workspace\\maven-demo\\icon\\lock.jpg"));
		lblNewLabel_1.setBounds(111, 199, 34, 34);
		panel.add(lblNewLabel_1);
	
	}

	
	public void showEmptyMessage() {
		// TODO Auto-generated method stub
		EmptyMessage emptyMessage = new EmptyMessage();
		emptyMessage.setVisible(true);
	}

	
	public void showErrorData() {
		// TODO Auto-generated method stub
		ErrorData errorData = new ErrorData();
		errorData.setVisible(true);
	}


	public void showUserMessage() {
		// TODO Auto-generated method stub
		UserMessage userMessage = new UserMessage();
		userMessage.setVisible(true);
	}
	
	public boolean checkFields(String emailText, String passwordText) {
		
		if(!emailText.equals("") && !passwordText.equals("")) { //if the fields aren't empty...
			//GET on user and amministratore
			Administrator administrator = new Administrator();
			AdministratorDAOMySQL administratorDAOMySQL = new AdministratorDAOMySQL();
			administrator = administratorDAOMySQL.getAdministratorByEmail(fieldEmail.getText());
			UserDAOMySQL userDAOMySQL = new UserDAOMySQL();
			User user = new User();
								
			if(administrator.getEmail() != null && administrator.getEmail().equals(fieldEmail.getText()) && administrator.getPassword() != null && administrator.getPassword().equals(fieldPassword.getText())){
					AdministrationView administrationView = new AdministrationView(fieldEmail.getText());
					administrationView.loadMovie();
					administrationView.setVisible(true);
					setVisible(false);
					return true;
			}else{
				user = userDAOMySQL.getUserByEmail(fieldEmail.getText());
				System.out.println("Mail user: "+user.getEmail());
				if(user.getEmail() != null && user.getEmail().equals(fieldEmail.getText())){
					System.out.println("Entro perché mail user: "+user.getEmail());
					showUserMessage();
					return false;
				}else{
					showErrorData();
					return false;
				}	
			}
		}else {
			showEmptyMessage();
			return false;
		}
	}

}
