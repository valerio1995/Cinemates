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


public class WelcomeView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton buttonAuthenticate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeView frame = new WelcomeView();
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
	public WelcomeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 394);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane Introduction = new JTextPane();
		Introduction.setText("Introduzione");
		Introduction.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		Introduction.setEditable(false);
		Introduction.setBounds(10, 11, 106, 27);
		contentPane.add(Introduction);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBounds(-40, 43, 533, 285);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnAdministrationOfCinemates = new JTextPane();
		txtpnAdministrationOfCinemates.setBounds(153, 55, 235, 66);
		panel.add(txtpnAdministrationOfCinemates);
		txtpnAdministrationOfCinemates.setText("CineMates20");
		txtpnAdministrationOfCinemates.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		txtpnAdministrationOfCinemates.setEditable(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(213, 67, 10, 10);
		panel.add(panel_1);
		
		buttonAuthenticate = new JButton("Autenticazione");
		buttonAuthenticate.setBackground(Color.LIGHT_GRAY);
		buttonAuthenticate.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		buttonAuthenticate.setBounds(185, 194, 127, 27);
		buttonAuthenticate.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {	
				AuthenticationView authenticationView = new AuthenticationView();
				setVisible(false);
				authenticationView.setVisible(true);
				
			}
		});
		panel.add(buttonAuthenticate);
	
	}
}
