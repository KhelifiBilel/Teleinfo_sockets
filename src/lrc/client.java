package lrc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class client {
	static String l="";
	public static String creationCode(String str){ //Transformer le numéro insérer en un Code binaire de 24 bits 
		String s="";
		byte[][] t=new byte[8][3];
	
		 for ( int i = 0; i < str.length(); ++i){
             char c = str.charAt(i);
             int j = (int) c;
           
          byte[] tab=getBinary(j);
         for(int a=0;a<8;a++){t[a][i]=tab[a];}
         }
         for (int z=0;z<8;z++){
        	 int p=0;
        	 if(t[z][0]==1)p++;
        	 if(t[z][1]==1)p++;
        	 p=p%2;
        	 t[z][2]=(byte) p;
         }
         for(int j=0;j<3;j++){
       for(int i=0;i<8;i++){
    	   
    		  s+=t[i][j]+"";
    	    }
         }return s;}
	public static byte[] getBinary(int decimal) { // TRANSFORMER le Code ASCII en un flux binaire de 7 bits et ajouter le 8éme bit de Parité 
        
        byte[] result = new byte[8];
         int p=0;
        for(int i = 0; i < 7; i++) {
        	
             
            if(decimal - Math.pow(2,6-i) > 0) {    
                result[i] = 1;p++;
                decimal -= Math.pow(2,6-i);}
           
            else if(decimal - Math.pow(2,6-i) == 0) {
                result[i] = 1;p++;
                break;
            }else{
                result[i] = 0;}}
          
         if(p%2==0) result[7]=0;
         else result[7]=1;
        return result;
         
    }}

	