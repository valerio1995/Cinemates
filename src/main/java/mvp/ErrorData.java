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
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErrorData extends JFrame {

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
					ErrorData frame = new ErrorData();
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
	public ErrorData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 313, 202);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(-22, 28, 345, 108);
		contentPane.add(panel_1);
		
		JTextPane txtpnEmailOrPassword = new JTextPane();
		txtpnEmailOrPassword.setText("E-mail e/o password non corretti");
		txtpnEmailOrPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		txtpnEmailOrPassword.setEditable(false);
		txtpnEmailOrPassword.setBounds(135, 11, 164, 55);
		panel_1.add(txtpnEmailOrPassword);
		
		JButton buttonOk = new JButton("Ok");
		buttonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		buttonOk.setBackground(Color.LIGHT_GRAY);
		buttonOk.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		buttonOk.setBounds(135, 70, 55, 27);
		panel_1.add(buttonOk);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\valer\\Desktop\\eclipse-workspace\\maven-demo\\icon\\triangle_error.png"));
		lblNewLabel_1.setBounds(61, 11, 64, 44);
		panel_1.add(lblNewLabel_1);
		
		JTextPane txtpnError = new JTextPane();
		txtpnError.setText("Errore");
		txtpnError.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		txtpnError.setEditable(false);
		txtpnError.setBounds(10, 0, 52, 27);
		contentPane.add(txtpnError);
	}

}
