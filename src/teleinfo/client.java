package teleinfo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.JLabel;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.AbstractAction;
import javax.swing.Action;

import java.awt.Checkbox;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.LineBorder;

import java.awt.ComponentOrientation;
import java.awt.Cursor;

import javax.swing.DebugGraphics;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Component;

import javax.swing.JTextArea;

public class client {
   static Socket so;
   
   static JLabel reecriture1;

   static JLabel reecriture;
   JTextArea text2;
	private JFrame frame;
	static  JTextField numcarte;
	private JPasswordField password;
	private JLabel lblNumrounique;
	private JButton button;
	private static JLabel error;
	private JLabel lblEntrezVotreNumero;
	private JLabel text1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private JRadioButton rdbtnContinuer;JLabel erreur;
private JLabel infos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws  UnknownHostException,IOException  {
		try {
			so=new Socket("127.0.0.1",177);
			}
			
	catch (ConnectException e){
			JOptionPane.showMessageDialog(null, "Serveur Non Connecté "); // Si on lance le Client avant le Serveur
         System.exit(1);          }
		
			  EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					client window = new client();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
			  
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public client() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws UnknownHostException,IOException{
		
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("Vous etes connecte au serveur  \r\n\r\nEntrez votre Numero de Carte :");
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		error = new JLabel("");
		error.setBounds(32, 11, 173, 14);
		error.setBackground(new Color(0, 0, 139));
		error.setForeground(new Color(255, 0, 0));
		error.setHorizontalAlignment(SwingConstants.LEFT);
		error.setVerticalAlignment(SwingConstants.TOP);
		numcarte = new JTextField();
		numcarte.setBounds(32, 92, 107, 20);
		numcarte.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
		numcarte.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmer"); //Aprés saisir le Numéro de Carte
		btnNewButton.setBounds(340, 90, 114, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {int numero=0;
				String num=numcarte.getText();
			try{	numero=Integer.parseInt(num);
				
			reecriture.setText(""); // Si on saisit un chaine au lieu d'un numéro :demander la reecriture 
			Scanner sc1=new Scanner(so.getInputStream());	
				PrintStream p=new PrintStream(so.getOutputStream());
		           p.println(numero);
		            
		     String t=sc1.nextLine(); //Réception soit d'un message d'Erreur ou Du nom de l'Etudiant
			    text1.setText(t);
		        if(t.equals("Numero de Carte Errone")){infos.setText("");}
		        else{infos.setText("Pour plus d'Informations,Veuillez Saisir votre Num_Unique");
		        }}
			
			
			catch(NumberFormatException a){reecriture.setText("Réentrez votre Numéro ");}
			catch(Exception e){ }
			}
		});
		btnNewButton.setBackground(new Color(245, 222, 179));
		btnNewButton.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		
		password = new JPasswordField();
		password.setBounds(32, 288, 107, 20);
		password.setEnabled(false);
		
		JLabel lblVotreNumoDe = new JLabel(" Num\u00E9ro de Carte");
		lblVotreNumoDe.setBounds(32, 67, 144, 14);
		
		lblNumrounique = new JLabel("Num\u00E9ro_Unique");
		lblNumrounique.setBounds(32, 263, 144, 14);
		
		button = new  JButton("Confirmer"); // Aprés saisir le Numéro_unique (partie LRC ) 
		button.setBounds(340, 286, 114, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pwd=password.getText();
				 
				  pwd=   lrc.client.creationCode(pwd);
				  try{Scanner sc1=new Scanner(so.getInputStream());	 
					PrintStream p=new PrintStream(so.getOutputStream());
				   p.println(pwd);
				   String msg=sc1.nextLine();
			            erreur.setText(msg); //Indiquer si le numéro_unique a été bien envoyé ou pas 
			            
			     String t=sc1.nextLine();
			   String  t1=sc1.nextLine();
				  //  text1.setText(t);
			        if(t.equals("Votre Code n'est pas valide ")){
			        	text2.setText(t+"\n"+t1);
			        	}
			        else{ // Réception des Infomations sur l'Etudiant 
		        		  String rue=sc1.nextLine();
		        		 String  niveau=sc1.nextLine();
		        		 String  grpe=sc1.nextLine();
		        		  String m=sc1.nextLine();
		        		  String m1=sc1.nextLine();

		        		 String  email=sc1.nextLine();
		        		 String all= t+"\n"+t1+"\n"+rue +"\n"+ niveau+"\n"+grpe+"\n"+m+"\n"+m1+"\n"+email;
		        		 text2.setText(all);}
			        
			        
		        	 
				}catch(Exception e1){  }
			}
		});
		button.setEnabled(false);
		button.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		button.setBackground(new Color(245, 222, 179));
		
		JLabel lblVousEtesConnecte = new JLabel("Vous etes connecte au serveur ");
		lblVousEtesConnecte.setBounds(32, 11, 233, 20);
		lblVousEtesConnecte.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblVousEtesConnecte.setForeground(new Color(70, 130, 180));
		
		lblEntrezVotreNumero = new JLabel("Entrez votre Numero de Carte : ");
		lblEntrezVotreNumero.setBounds(32, 36, 233, 20);
		lblEntrezVotreNumero.setForeground(new Color(70, 130, 180));
		lblEntrezVotreNumero.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		
		text1 = new JLabel("");
		text1.setBounds(32, 150, 422, 29);
		text1.setBackground(new Color(176, 224, 230));
		text1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		text1.setForeground(new Color(0, 128, 128));
		text1.setHorizontalAlignment(SwingConstants.LEFT);
		text1.setVerticalAlignment(SwingConstants.BOTTOM);
		
		rdbtnContinuer = new JRadioButton("Continuer");
		rdbtnContinuer.setBounds(32, 220, 109, 23);
		rdbtnContinuer.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.setLayout(null);
		panel.add(error);
		panel.add(numcarte);
		panel.add(btnNewButton);
		panel.add(password);
		panel.add(lblVotreNumoDe);
		panel.add(lblNumrounique);
		panel.add(button);
		panel.add(lblVousEtesConnecte);
		panel.add(lblEntrezVotreNumero);
		panel.add(text1);
		panel.add(rdbtnContinuer);
		
		 text2 = new JTextArea();
		 text2.setWrapStyleWord(true);
		 text2.setEnabled(false);
		 text2.setLineWrap(true);
		 text2.setFont(new Font("Courier New", Font.BOLD, 12));
		 text2.setForeground(new Color(112, 128, 144));
		 text2.setEditable(false);
		text2.setBounds(32, 332, 422, 165);
		panel.add(text2);
		
		 erreur = new JLabel("");
		 erreur.setForeground(Color.RED);
		 erreur.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		erreur.setBounds(147, 243, 307, 20);
		panel.add(erreur);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {System.exit(1);
			}
		});
		btnQuitter.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		btnQuitter.setBackground(new Color(245, 222, 179));
		btnQuitter.setBounds(340, 508, 114, 23);
		panel.add(btnQuitter);
		
		infos = new JLabel("");
		infos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		infos.setBounds(32, 178, 422, 35);
		panel.add(infos);
		
		infos = new JLabel("");
		infos.setBounds(40, 178, 371, 29);
		panel.add(infos);
		
		 reecriture = new JLabel("");
		reecriture.setForeground(new Color(255, 0, 0));
		reecriture.setBounds(32, 117, 173, 14);
		panel.add(reecriture);
		
		JLabel reecriture1 = new JLabel("");
		reecriture1.setForeground(Color.RED);
		reecriture1.setBounds(32, 307, 173, 14);
		panel.add(reecriture1);
		rdbtnContinuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				password.setEnabled(true);
				button.setEnabled(true);
				text2.setEnabled(true);

			}});
		
	}
	

}
