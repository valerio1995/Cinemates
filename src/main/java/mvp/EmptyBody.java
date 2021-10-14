package mvp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmptyBody extends JFrame {

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
					EmptyBody frame = new EmptyBody();
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
	public EmptyBody() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 239);
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
		panel.setBounds(-19, 34, 345, 126);
		contentPane.add(panel);
		
		JButton buttonOk = new JButton("Ok");
		buttonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		buttonOk.setBackground(Color.LIGHT_GRAY);
		buttonOk.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		buttonOk.setBounds(134, 91, 55, 27);
		panel.add(buttonOk);
		
		JTextPane txtpnTheBodyOf = new JTextPane();
		txtpnTheBodyOf.setText("Il corpo del messaggio non pu\u00F2 essere vuoto");
		txtpnTheBodyOf.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		txtpnTheBodyOf.setEditable(false);
		txtpnTheBodyOf.setBounds(131, 11, 139, 69);
		panel.add(txtpnTheBodyOf);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\valer\\Desktop\\eclipse-workspace\\maven-demo\\icon\\triangle_error.png"));
		lblNewLabel.setBounds(51, 21, 55, 51);
		panel.add(lblNewLabel);
		
		JTextPane txtpnError = new JTextPane();
		txtpnError.setText("Errore");
		txtpnError.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		txtpnError.setEditable(false);
		txtpnError.setBounds(10, 0, 52, 27);
		contentPane.add(txtpnError);
	}

}
