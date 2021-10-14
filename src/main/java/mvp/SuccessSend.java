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

public class SuccessSend extends JFrame {

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
					SuccessSend frame = new SuccessSend();
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
	public SuccessSend() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 298, 218);
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
		panel.setBounds(-28, 27, 345, 126);
		contentPane.add(panel);
		
		JButton buttonOk = new JButton("Ok");
		buttonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		buttonOk.setBackground(Color.LIGHT_GRAY);
		buttonOk.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		buttonOk.setBounds(125, 88, 55, 27);
		panel.add(buttonOk);
		
		JTextPane txtpnTheMail = new JTextPane();
		txtpnTheMail.setText("La mail \u00E8 stata inviata correttamente a tutti gli utenti");
		txtpnTheMail.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		txtpnTheMail.setEditable(false);
		txtpnTheMail.setBounds(115, 11, 183, 69);
		panel.add(txtpnTheMail);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hat\\Desktop\\eclipse-workspace\\Cinematers\\Images\\confirm.jpg"));
		lblNewLabel.setBounds(50, 24, 55, 37);
		panel.add(lblNewLabel);
		
		JTextPane txtpnError = new JTextPane();
		txtpnError.setText("Errore");
		txtpnError.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		txtpnError.setEditable(false);
		txtpnError.setBounds(10, 0, 52, 27);
		contentPane.add(txtpnError);
	}

}
