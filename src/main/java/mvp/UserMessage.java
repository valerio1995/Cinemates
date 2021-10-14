package mvp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserMessage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMessage frame = new UserMessage();
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
	public UserMessage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 283, 248);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(-60, 37, 512, 147);
		contentPane.add(panel);
		
		JTextPane txtpnAuthenticateLikeUser = new JTextPane();
		txtpnAuthenticateLikeUser.setText("Autenticarsi come utente dalla piattaforma mobile ");
		txtpnAuthenticateLikeUser.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtpnAuthenticateLikeUser.setEditable(false);
		txtpnAuthenticateLikeUser.setBounds(80, 11, 245, 71);
		panel.add(txtpnAuthenticateLikeUser);
		
		JButton buttonOk = new JButton("Ok");
		buttonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		buttonOk.setBackground(Color.LIGHT_GRAY);
		buttonOk.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		buttonOk.setBounds(155, 93, 55, 27);
		panel.add(buttonOk);
		
		JTextPane txtpnAttention = new JTextPane();
		txtpnAttention.setText("Avviso");
		txtpnAttention.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		txtpnAttention.setEditable(false);
		txtpnAttention.setBounds(10, 11, 52, 27);
		contentPane.add(txtpnAttention);
	}

}
