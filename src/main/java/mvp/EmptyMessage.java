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

public class EmptyMessage extends JFrame {

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
					EmptyMessage frame = new EmptyMessage();
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
	public EmptyMessage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 283, 193);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelError = new JPanel();
		panelError.setLayout(null);
		panelError.setForeground(Color.WHITE);
		panelError.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelError.setBackground(Color.WHITE);
		panelError.setBounds(-55, 24, 345, 108);
		contentPane.add(panelError);
		
		JTextPane txtpnDoIt = new JTextPane();
		txtpnDoIt.setText("Compilare entrambi i campi");
		txtpnDoIt.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		txtpnDoIt.setEditable(false);
		txtpnDoIt.setBounds(156, 11, 139, 55);
		panelError.add(txtpnDoIt);
		
		JButton buttonOk = new JButton("Ok");
		buttonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		buttonOk.setBackground(Color.LIGHT_GRAY);
		buttonOk.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		buttonOk.setBounds(158, 77, 55, 27);
		panelError.add(buttonOk);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\valer\\Desktop\\eclipse-workspace\\maven-demo\\icon\\triangle_error.png"));
		lblNewLabel_2.setBounds(88, 11, 64, 55);
		panelError.add(lblNewLabel_2);
		
		JTextPane txtpnError = new JTextPane();
		txtpnError.setText("Errore");
		txtpnError.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		txtpnError.setEditable(false);
		txtpnError.setBounds(10, 0, 52, 27);
		contentPane.add(txtpnError);
	}
}
