package teleinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.util.*;
import java.io.PrintStream;
public class monserveur {
	static String  codeEnvoye ;static String codeRecu;static String msg="";
	private static Connection con;
	public static void main(String[] args)throws IOException,Exception {
 
		//Connection avec La base de Donnée 
		
	try {

            Class.forName("org.sqlite.JDBC");} catch(Exception e){}
		if( con == null) {
			 try {         
			     con=DriverManager.getConnection("jdbc:sqlite:database//mydb.db");  


					System.out.println("connexion effective");
				} catch (SQLException e) {
					 JOptionPane.showMessageDialog(null, "Erreur lors de l Etablissement de la connexion a la base de donnees\n Code erreur: "+e.getErrorCode(), "Erreur", JOptionPane.ERROR_MESSAGE);
		             System.exit(1);                
		                   }    }
		 if (con!=null){					

			 Statement st=con.createStatement();

		     Statement st1=con.createStatement();
		     Statement st2=con.createStatement(); 
	          //Repérer le 3 Tables de La Base de Donnée 
		     
		   ResultSet rs=st.executeQuery(" select * from Etudiant " );
		   ResultSet rs1=st1.executeQuery(" select * from Adresse " );
		   ResultSet rs2=st2.executeQuery(" select * from fiche_scolaire " );
			 
			 
			 
		  ServerSocket s1=new ServerSocket(177);
		     Socket ss=s1.accept();  
		     
		     Scanner sc=new Scanner(ss.getInputStream());
		      
		      int number=sc.nextInt(); //Réception du numéro de la Carte
		      
		       String nat="";
			      int age=0;
			      int numero=0;
			      String name="";
			      String email="";
			      String str="";
			      int nu=0;
			      String t1="",strr="",ville="",rue="",niveau="",grpe="",m="",m1="";
			     
	           boolean test=false;
	           
			   PrintStream p=new PrintStream(ss.getOutputStream());
               //Recherche  de l'Etudiant Correspondant 
		     while(rs.next()){
				   if(rs.getInt(1)==number){
	                        nu=rs.getInt(2);
	                        numero=rs.getInt(3);
	                        name=rs.getString(4);
	                        age=rs.getInt(5);
					        nat=rs.getString(6);
	                        email=rs.getString(7);
	                        str ="Ce numero de carte :"+ number+" est pour :"+ name; 
			                test=true;
			       }}
			int num_unique=0;
		       if(!test){
		    	   str="Numero de Carte Errone";
	      	     }
		       System.out.print(str);
		        p.println(str); //Envoi soit d'Un message d'Erreur : Numéro Erroné (non trouvé) ou du Nom de L'Etudiant 
		      
		      if (test)
		         { 
		               	       // Traitement sur le Numéro_unique avec La méthode de Correction LRC
		    	   Scanner sc1=new Scanner(ss.getInputStream());
		    	   codeEnvoye = sc1.nextLine();
		 	      char[][] matrice1=new char[8][3];
		           matrice1=lrc.server.createVec(codeEnvoye);
		         
		          codeRecu=lrc.server.createError(codeEnvoye);
		          if(codeEnvoye.equals(codeRecu)){ msg+="Pas d'Erreur lors de la Transmission "; num_unique=lrc.server.decoder(matrice1);}
		          else{ char[][] matrice2=new char[8][3];
		          matrice2=lrc.server.createVec(codeRecu);
		                                         msg="Erreur :Reçu ="+lrc.server.decoder(matrice2); 
		           matrice2=lrc.server.fixError(matrice2);
		           num_unique=lrc.server.decoder(matrice2);

		             }            
                    p.println(msg);
				     
 				  
				     System.out.println(num_unique);
				     if(nu!=num_unique){
				    	 t1="Votre Code n'est pas valide ";
				    	 ville=" Vous Devez Reessayer !";
					      p.println(t1);
					      p.println(ville);
					      
		                        }
				     
				     else{   t1= name+", "+ age+ " ans "+" de Nationalité "+nat+"." ;
	                      p.println(t1);
					      

	                      while (rs1.next()){
					    	  if(rs1.getInt(1)==numero) { 
					    		  ville= "Ville :"+rs1.getString(2);
								     p.println(ville);
						          rue= "Rue  :"+rs1.getString(3);
						     	     p.println(rue);
 	                     
					    		
					    	                            }}			
	                      while(rs2.next()){
					    	  if(rs2.getInt(2)==number) { 
					    		 niveau= "Niveau  :"+rs2.getString(3);
						          p.println(niveau);
					    		  grpe= "Groupe :"+rs2.getString(4);
						     	     p.println(grpe);
					    		 m= "Moyenne de l'annee précédente :"+rs2.getInt(5);
						     	     p.println(m);
					    		  m1= "Moyenne Bac :"+rs2.getInt(6);
						     	     p.println(m1);
						     	     p.println("Email :"+email);  }}
		      
		      
	
	  rs.close();
	  st.close();
	  rs1.close();
	  st1.close();
	  rs2.close();
	  st2.close();
	  con.close();
		     }
	  
	
	
	
	
	
	
	
	
		         	}}}}
