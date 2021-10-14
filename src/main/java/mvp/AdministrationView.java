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
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.mail.MessagingException;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class AdministrationView extends JFrame implements AdministrationInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextPane txtAdminEmail = new JTextPane();
	public JLabel labelTitle_1 = new JLabel("Titolo");
	public JLabel labelDate_1 = new JLabel("Data");
	public JLabel labelDirector_1 = new JLabel("Regista");
	public JLabel labelTitle_2 = new JLabel("Titolo");
	public JLabel labelDate_2 = new JLabel("Data");
	public JLabel labelDirector_2 = new JLabel("Regista");
	public JLabel labelTitle_3 = new JLabel("Titolo");
	public JLabel labelDate_3 = new JLabel("Data");
	public JLabel labelDirector_3 = new JLabel("Regista");
	public JLabel labelTitle_4 = new JLabel("Titolo");
	public JLabel labelDate_4 = new JLabel("Data");
	public JLabel labelDirector_4 = new JLabel("Regista");
	private JPanel contentPane;
	private JTextField fieldObject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministrationView frame = new AdministrationView("null");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param adminEmail 
	 */
	public AdministrationView(String adminEmail) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 458);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel RecommendMovieView = new JPanel();
		final JPanel SendMailView = new JPanel();
		final JPanel panel_menu = new JPanel();
		
				
		SendMailView.setLayout(null);
		SendMailView.setForeground(Color.WHITE);
		SendMailView.setBorder(new LineBorder(new Color(0, 0, 0)));
		SendMailView.setBackground(Color.WHITE);
		SendMailView.setBounds(-41, 49, 1047, 346);
		contentPane.add(SendMailView);
		
				
				panel_menu.setBackground(Color.WHITE);
				panel_menu.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel_menu.setBounds(52, 22, 166, 130);
				SendMailView.add(panel_menu);
				panel_menu.setLayout(null);
				
				
								JPanel buttonSendMail = new JPanel();
								buttonSendMail.setBackground(Color.WHITE);
								buttonSendMail.setBorder(new LineBorder(new Color(0, 0, 0)));
								buttonSendMail.setBounds(0, 0, 165, 46);
								panel_menu.add(buttonSendMail);
								buttonSendMail.setLayout(null);
								
								JLabel labelSendMail = new JLabel("Invia Mail");
								labelSendMail.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										panel_menu.setVisible(true);
										SendMailView.setVisible(true);
										RecommendMovieView.setVisible(false);
									}
								});
								labelSendMail.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
								labelSendMail.setBounds(55, 11, 100, 24);
								buttonSendMail.add(labelSendMail);
								
								JLabel lblNewLabel_1 = new JLabel("");
								lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\valer\\Desktop\\eclipse-workspace\\maven-demo\\icon\\posta.jpg"));
								lblNewLabel_1.setBounds(11, 11, 34, 24);
								buttonSendMail.add(lblNewLabel_1);
								
								JPanel buttonRecommendMovie = new JPanel();
								buttonRecommendMovie.setBackground(Color.WHITE);
								buttonRecommendMovie.setBorder(new LineBorder(new Color(0, 0, 0)));
								buttonRecommendMovie.setBounds(0, 44, 165, 46);
								panel_menu.add(buttonRecommendMovie);
								buttonRecommendMovie.setLayout(null);
								
								
								JLabel labelRecommendMovie = new JLabel("Raccomanda film");
								labelRecommendMovie.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										panel_menu.setVisible(true);
										SendMailView.setVisible(false);
										RecommendMovieView.setVisible(true);
									}
								});
								labelRecommendMovie.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
								labelRecommendMovie.setBounds(53, 11, 112, 24);
								buttonRecommendMovie.add(labelRecommendMovie);
								
								JLabel lblNewLabel_2 = new JLabel("");
								lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\valer\\Desktop\\eclipse-workspace\\maven-demo\\icon\\pellicola.jpg"));
								lblNewLabel_2.setBounds(10, 11, 50, 24);
								buttonRecommendMovie.add(lblNewLabel_2);
								
								JPanel buttonExit = new JPanel();
								buttonExit.setBackground(Color.WHITE);
								buttonExit.setBorder(new LineBorder(new Color(0, 0, 0)));
								buttonExit.setBounds(0, 84, 165, 46);
								panel_menu.add(buttonExit);
								buttonExit.setLayout(null);
								
								JLabel labelExit = new JLabel("Esci");
								labelExit.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										setVisible(false);
										AuthenticationView authenticationView = new AuthenticationView();
										authenticationView.setVisible(true);
										
									}
								});
								labelExit.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
								labelExit.setBounds(57, 11, 98, 24);
								buttonExit.add(labelExit);
								
								JLabel lblNewLabel_3 = new JLabel("");
								lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\valer\\Desktop\\eclipse-workspace\\maven-demo\\icon\\exit.jpg"));
								lblNewLabel_3.setBounds(10, 11, 40, 29);
								buttonExit.add(lblNewLabel_3);
								
								JTextPane txtpnSendAMail = new JTextPane();
								txtpnSendAMail.setText("Invia una mail a tutti gli utenti della piattaforma");
								txtpnSendAMail.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
								txtpnSendAMail.setEditable(false);
								txtpnSendAMail.setBounds(241, 22, 458, 60);
								SendMailView.add(txtpnSendAMail);
								
								JTextPane txtpnReceiver = new JTextPane();
								txtpnReceiver.setText("Mittente");
								txtpnReceiver.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
								txtpnReceiver.setEditable(false);
								txtpnReceiver.setBounds(241, 76, 66, 27);
								SendMailView.add(txtpnReceiver);
								
								JTextPane txtpnObject = new JTextPane();
								txtpnObject.setText("Oggetto");
								txtpnObject.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
								txtpnObject.setEditable(false);
								txtpnObject.setBounds(241, 114, 66, 27);
								SendMailView.add(txtpnObject);
								
								JTextPane txtpnMessage = new JTextPane();
								txtpnMessage.setText("Messaggio");
								txtpnMessage.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
								txtpnMessage.setEditable(false);
								txtpnMessage.setBounds(241, 152, 66, 27);
								SendMailView.add(txtpnMessage);
								
								
								txtAdminEmail.setText(adminEmail);
								txtAdminEmail.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
								txtAdminEmail.setEditable(false);
								txtAdminEmail.setBounds(311, 76, 124, 27);
								SendMailView.add(txtAdminEmail);
								
								fieldObject = new JTextField();
								fieldObject.setBounds(311, 114, 243, 20);
								SendMailView.add(fieldObject);
								fieldObject.setColumns(10);
								
								JPanel fieldBorder = new JPanel();
								fieldBorder.setBackground(Color.WHITE);
								fieldBorder.setBorder(new LineBorder(Color.LIGHT_GRAY));
								fieldBorder.setBounds(311, 147, 327, 141);
								SendMailView.add(fieldBorder);
								fieldBorder.setLayout(null);
								
								final JTextPane fieldMessage = new JTextPane();
								fieldMessage.setBounds(6, 11, 315, 119);
								fieldBorder.add(fieldMessage);
								
								JButton buttonSend = new JButton("Invia");
								buttonSend.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {

										SendMailPresenter sendMailPresenter = new SendMailPresenter();
										UserDAOMySQL userDAOMySQL = new UserDAOMySQL();
										
										if(sendMailPresenter.isNotEmptyField(fieldObject.getText(), fieldMessage.getText()) == true){
											try {
												sendMailPresenter.sendMail(userDAOMySQL.getAllUsers(), fieldObject.getText(), fieldMessage.getText(), txtAdminEmail.getText());
											} catch (MessagingException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										}else {
											showEmptyBodyMessage();
										}
									}
								});
								buttonSend.setBackground(Color.LIGHT_GRAY);
								buttonSend.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
								buttonSend.setBounds(321, 312, 89, 23);
								SendMailView.add(buttonSend);
								
								buttonSendMail.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										panel_menu.setVisible(true);
										SendMailView.setVisible(true);
										RecommendMovieView.setVisible(false);
									}
								});
								
								buttonRecommendMovie.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										panel_menu.setVisible(true);
										SendMailView.setVisible(false);
										RecommendMovieView.setVisible(true);
									}
								});
								
								buttonExit.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										AuthenticationView authenticationView = new AuthenticationView();
										setVisible(false);
										authenticationView.setVisible(true);
									}
								});
		
		RecommendMovieView.setBounds(-14, 49, 864, 346);
		contentPane.add(RecommendMovieView);
		RecommendMovieView.setBorder(new LineBorder(Color.LIGHT_GRAY));
		RecommendMovieView.setBackground(Color.WHITE);
		RecommendMovieView.setLayout(new CardLayout(0, 0));
		
		JPanel panel_menu_1 = new JPanel();
		panel_menu_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_menu_1.setBackground(Color.WHITE);
		RecommendMovieView.add(panel_menu_1, "name_521566681193300");
		panel_menu_1.setLayout(null);
		
		JScrollPane scrollPanelMovie = new JScrollPane();
		scrollPanelMovie.setBounds(200, 21, 596, 245);
		panel_menu_1.add(scrollPanelMovie);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setForeground(Color.WHITE);
		scrollPanelMovie.setViewportView(panel);
		panel.setLayout(null);
		
		JPanel dateMovie_1 = new JPanel();
		dateMovie_1.setBackground(Color.WHITE);
		dateMovie_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		dateMovie_1.setBounds(10, 11, 278, 99);
		panel.add(dateMovie_1);
		dateMovie_1.setLayout(null);
		
		JButton buttonRecommend_1 = new JButton("Raccomanda");
		buttonRecommend_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecommendMoviePresenter recommendMoviePresenter = new RecommendMoviePresenter();
				recommendMoviePresenter.sendNotification(labelTitle_1.getText(),labelDate_1.getText(),labelDirector_1.getText());
			}
		});
		buttonRecommend_1.setBackground(Color.LIGHT_GRAY);
		buttonRecommend_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		buttonRecommend_1.setBounds(166, 46, 102, 44);
		dateMovie_1.add(buttonRecommend_1);
		
		
		labelTitle_1.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		labelTitle_1.setBounds(83, 6, 185, 36);
		dateMovie_1.add(labelTitle_1);
		
		labelDate_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		labelDate_1.setBounds(83, 46, 185, 14);
		dateMovie_1.add(labelDate_1);
		
		labelDirector_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		labelDirector_1.setBounds(83, 71, 79, 19);
		dateMovie_1.add(labelDirector_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\valer\\Desktop\\eclipse-workspace\\maven-demo\\icon\\film.png"));
		lblNewLabel_6.setBounds(10, 6, 63, 84);
		dateMovie_1.add(lblNewLabel_6);
		
		JPanel dateMovie_2 = new JPanel();
		dateMovie_2.setLayout(null);
		dateMovie_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		dateMovie_2.setBackground(Color.WHITE);
		dateMovie_2.setBounds(306, 11, 278, 99);
		panel.add(dateMovie_2);
		
		JButton buttonRecommend_2 = new JButton("Raccomanda");
		buttonRecommend_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecommendMoviePresenter recommendMoviePresenter = new RecommendMoviePresenter();
				recommendMoviePresenter.sendNotification(labelTitle_2.getText(),labelDate_2.getText(),labelDirector_2.getText());
			}
		});
		buttonRecommend_2.setBackground(Color.LIGHT_GRAY);
		buttonRecommend_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		buttonRecommend_2.setBounds(172, 46, 96, 44);
		dateMovie_2.add(buttonRecommend_2);
		
		labelTitle_2.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		labelTitle_2.setBounds(83, 6, 185, 29);
		dateMovie_2.add(labelTitle_2);
		
		labelDate_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		labelDate_2.setBounds(83, 46, 79, 14);
		dateMovie_2.add(labelDate_2);
		
		labelDirector_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		labelDirector_2.setBounds(83, 71, 79, 19);
		dateMovie_2.add(labelDirector_2);
		
		JLabel lblNewLabel_6_1 = new JLabel("");
		lblNewLabel_6_1.setIcon(new ImageIcon("C:\\Users\\valer\\Desktop\\eclipse-workspace\\maven-demo\\icon\\film.png"));
		lblNewLabel_6_1.setBounds(10, 6, 63, 84);
		dateMovie_2.add(lblNewLabel_6_1);
		
		JPanel dateMovie_3 = new JPanel();
		dateMovie_3.setLayout(null);
		dateMovie_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		dateMovie_3.setBackground(Color.WHITE);
		dateMovie_3.setBounds(10, 132, 278, 99);
		panel.add(dateMovie_3);
		
		JButton buttonRecommend_3 = new JButton("Raccomanda");
		buttonRecommend_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecommendMoviePresenter recommendMoviePresenter = new RecommendMoviePresenter();
				recommendMoviePresenter.sendNotification(labelTitle_3.getText(),labelDate_3.getText(),labelDirector_3.getText());
			}
		});
		buttonRecommend_3.setBackground(Color.LIGHT_GRAY);
		buttonRecommend_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		buttonRecommend_3.setBounds(170, 46, 98, 44);
		dateMovie_3.add(buttonRecommend_3);
		
		labelTitle_3.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		labelTitle_3.setBounds(83, 6, 185, 29);
		dateMovie_3.add(labelTitle_3);
		
		labelDate_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		labelDate_3.setBounds(83, 46, 79, 14);
		dateMovie_3.add(labelDate_3);
		
		labelDirector_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		labelDirector_3.setBounds(83, 71, 79, 19);
		dateMovie_3.add(labelDirector_3);
		
		JLabel lblNewLabel_6_2 = new JLabel("");
		lblNewLabel_6_2.setIcon(new ImageIcon("C:\\Users\\valer\\Desktop\\eclipse-workspace\\maven-demo\\icon\\film.png"));
		lblNewLabel_6_2.setBounds(10, 6, 63, 84);
		dateMovie_3.add(lblNewLabel_6_2);
		
		JPanel dataFilm_4 = new JPanel();
		dataFilm_4.setLayout(null);
		dataFilm_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		dataFilm_4.setBackground(Color.WHITE);
		dataFilm_4.setBounds(306, 132, 278, 99);
		panel.add(dataFilm_4);
		
		JButton buttonRecommend_4 = new JButton("Raccomanda");
		buttonRecommend_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecommendMoviePresenter recommendMoviePresenter = new RecommendMoviePresenter();
				recommendMoviePresenter.sendNotification(labelTitle_4.getText(),labelDate_4.getText(),labelDirector_4.getText());
			}
		});
		buttonRecommend_4.setBackground(Color.LIGHT_GRAY);
		buttonRecommend_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		buttonRecommend_4.setBounds(172, 46, 96, 44);
		dataFilm_4.add(buttonRecommend_4);
		
		labelTitle_4.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		labelTitle_4.setBounds(83, 6, 185, 29);
		dataFilm_4.add(labelTitle_4);
		
		labelDate_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		labelDate_4.setBounds(83, 46, 79, 14);
		dataFilm_4.add(labelDate_4);
		
		labelDirector_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		labelDirector_4.setBounds(83, 71, 79, 19);
		dataFilm_4.add(labelDirector_4);
		
		JLabel lblNewLabel_6_3 = new JLabel("");
		lblNewLabel_6_3.setIcon(new ImageIcon("C:\\Users\\valer\\Desktop\\eclipse-workspace\\maven-demo\\icon\\film.png"));
		lblNewLabel_6_3.setBounds(10, 6, 63, 84);
		dataFilm_4.add(lblNewLabel_6_3);
		
		JPanel panel_menu_2 = new JPanel();
		panel_menu_2.setLayout(null);
		panel_menu_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_menu_2.setBackground(Color.WHITE);
		panel_menu_2.setBounds(24, 21, 166, 130);
		panel_menu_1.add(panel_menu_2);
		
		JPanel buttonSendMail_1 = new JPanel();
		buttonSendMail_1.setLayout(null);
		buttonSendMail_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonSendMail_1.setBackground(Color.WHITE);
		buttonSendMail_1.setBounds(0, 0, 165, 46);
		panel_menu_2.add(buttonSendMail_1);
		
		JLabel labelInviaMailView_2 = new JLabel("Invia Mail");
		labelInviaMailView_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_menu.setVisible(true);
				SendMailView.setVisible(true);
				RecommendMovieView.setVisible(false);
			}
		});
		labelInviaMailView_2.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		labelInviaMailView_2.setBounds(55, 11, 100, 24);
		buttonSendMail_1.add(labelInviaMailView_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\valer\\Desktop\\eclipse-workspace\\maven-demo\\icon\\posta.jpg"));
		lblNewLabel_1_1.setBounds(11, 11, 34, 24);
		buttonSendMail_1.add(lblNewLabel_1_1);
		
		JPanel buttonRecommendMovie_1 = new JPanel();
		buttonRecommendMovie_1.setLayout(null);
		buttonRecommendMovie_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonRecommendMovie_1.setBackground(Color.WHITE);
		buttonRecommendMovie_1.setBounds(0, 44, 165, 46);
		panel_menu_2.add(buttonRecommendMovie_1);
		
		JLabel lblRecommendMovie_1 = new JLabel("Raccomanda film");
		lblRecommendMovie_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_menu.setVisible(true);
				SendMailView.setVisible(false);
				RecommendMovieView.setVisible(true);
			}
		});
		lblRecommendMovie_1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblRecommendMovie_1.setBounds(53, 11, 112, 24);
		buttonRecommendMovie_1.add(lblRecommendMovie_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\valer\\Desktop\\eclipse-workspace\\maven-demo\\icon\\pellicola.jpg"));
		lblNewLabel_2_1.setBounds(10, 11, 50, 24);
		buttonRecommendMovie_1.add(lblNewLabel_2_1);
		
		JPanel buttonExit_1 = new JPanel();
		buttonExit_1.setLayout(null);
		buttonExit_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonExit_1.setBackground(Color.WHITE);
		buttonExit_1.setBounds(0, 84, 165, 46);
		panel_menu_2.add(buttonExit_1);
		
		JLabel lblExit_1 = new JLabel("Esci");
		lblExit_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				AuthenticationView autenticazioneView = new AuthenticationView();
				autenticazioneView.setVisible(true);
			}
		});
		lblExit_1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblExit_1.setBounds(57, 11, 98, 24);
		buttonExit_1.add(lblExit_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon("C:\\Users\\valer\\Desktop\\eclipse-workspace\\maven-demo\\icon\\exit.jpg"));
		lblNewLabel_3_1.setBounds(10, 11, 40, 29);
		buttonExit_1.add(lblNewLabel_3_1);
		
		
		
		JTextPane txtpnAdministration = new JTextPane();
		txtpnAdministration.setText("Amministrazione");
		txtpnAdministration.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		txtpnAdministration.setEditable(false);
		txtpnAdministration.setBounds(10, 11, 136, 27);
		contentPane.add(txtpnAdministration);
	}

	
	public void showEmptyBodyMessage() {
		// TODO Auto-generated method stub
		EmptyBody emptyBody = new EmptyBody();
		emptyBody.setVisible(true);
	}

	
	public void showSuccessSendMessage() {
		// TODO Auto-generated method stub
		SuccessSend successSend = new SuccessSend();
		successSend.setVisible(true);
	}

	public void loadMovie() {
		// TODO Auto-generated method stub
		List<Movie> listMovie = new ArrayList<Movie>();
		RecommendMoviePresenter recommendMoviePresenter = new RecommendMoviePresenter();
		listMovie = recommendMoviePresenter.getListMovie();
		
		/*Multples panels and labels*/
		for(int index=0; index<listMovie.size(); index++) {
			/*ADD panel with label and button*/
			
		}
		
		labelTitle_1.setText(listMovie.get(0).getTitle());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
		labelDate_1.setText(dateFormat.format(listMovie.get(0).getReleaseDate()));
		labelDirector_1.setText(listMovie.get(0).getDirector());
		
		labelTitle_2.setText(listMovie.get(1).getTitle());
		labelDate_2.setText(dateFormat.format(listMovie.get(1).getReleaseDate()));
		labelDirector_2.setText(listMovie.get(1).getDirector());
		
		labelTitle_3.setText(listMovie.get(2).getTitle());
		labelDate_3.setText(dateFormat.format(listMovie.get(2).getReleaseDate()));
		labelDirector_3.setText(listMovie.get(2).getDirector());
		
		labelTitle_4.setText(listMovie.get(3).getTitle());
		labelDate_4.setText(dateFormat.format(listMovie.get(3).getReleaseDate()));
		labelDirector_4.setText(listMovie.get(3).getDirector());

	}
}
