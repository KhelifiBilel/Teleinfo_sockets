package lrc;
import java.lang.Math;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
	static String codeEnvoye;
	static String codeRecu;

	static public char[][] createVec(String a){  // Création d'un Matrice M(8-3) à partir d'un Code binaire de 24 bits 
		char[] m = a.toCharArray();  
	     char[][] matrice=new char[8][3];
	     for(int j=0;j<3;j++){
	         for(int i=0;i<8;i++){
	      	   switch(j){
	      	 
	      	   case 0:	 matrice[i][j]=m[i];break;
	      	   case 1:	 matrice[i][j]=m[8+i];break;
	      	   case 2:	 matrice[i][j]=m[16+i];break;}}}
	     return matrice;
	}
	// Création d'Erreur sur un code de 24 bits en modifiant un seul bit (le bits de parité ne sont pas modifiés) 
	
	static public String createError(String a) throws Exception{ 
		char[] m = a.toCharArray();
		String s;int p=24;
		while((p==7)||(p>=15)){
			double e=Math.random();double pos=e*30;
			if(e<0.8)
			 p=(int)pos;
			else return a;                 }
		System.out.println("p= "+p);
		if(p!=-1)
			{if (m[p]=='0') m[p]='1';
			                    else m[p]='0';}
			 
		s= new String(m);

		return s;}
		                    
	static public int decoder(char[][] t){ //Extraire un numéro entre '00' et '99' d'une matrice M(8-3) 
		String s1="";String s2="";
		 
		for(int i=0;i<7;i++){
		    
		 s1+=t[i][0];
		 s2+=t[i][1];}System.out.println("s1= "+s1);System.out.println("s2= "+s2);
		
		int a=Integer.parseInt(s1,2);
		int b=Integer.parseInt(s2,2);
		a-=48;		b-=48;

		return (a*10+b);}
	

	public static char[][] fixError(char[][] m){    	//CORRECTION d'Erreur 
		int nb=0;int e1=-1;int e2=-1;
		
		for(int i=0;i<7;i++){
			if(m[i][0]=='1')nb++;}
			nb=nb%2;
			 int a = (int) m[7][0]-48;
			 if (a!=nb)e1=0;else e1=1;            
		nb=0;
			 for(int i=0;i<6;i++){
				for(int j=0;j<2;j++){
				 if(m[i][j]=='1')nb++;}
				 nb=nb%2;
				  a = (int) m[i][2]-48;
				 if (a!=nb){e2=i;
				      i=6;}}
				           
	if(	m[e2][e1]=='0')m[e2][e1]='1';
	else m[e2][e1]='0';
		
		return m;
	}
}
		
