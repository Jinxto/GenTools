package com.sneakers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.Set;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;

public class cookie {
 public void addCookie(Set<Cookie> set) {
	  File file = new File("Cookies.data");							
      try		
      {	  
          // Delete old file if exists
    	  file.delete();
          file.createNewFile();			
          FileWriter fileWrite = new FileWriter(file);							
          BufferedWriter Bwrite = new BufferedWriter(fileWrite);							
          // loop for getting the cookie information 		
          	
          // loop for getting the cookie information 		
          for(Cookie ck : set)							
          {			
              Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));																									
              Bwrite.newLine();             
          }			
          Bwrite.close();			
          fileWrite.close();	
          
      }
      catch(Exception ex)					
      {		
          ex.printStackTrace();			
      }		
 }
 public Cookie loadCookie() {
	  try{			
		     
	        File file = new File("Cookies.data");							
	        FileReader fileReader = new FileReader(file);							
	        BufferedReader Buffreader = new BufferedReader(fileReader);							
	        String strline;			
	        while((strline=Buffreader.readLine())!=null){									
	        StringTokenizer token = new StringTokenizer(strline,";");									
	        while(token.hasMoreTokens()){					
	        String name = token.nextToken();					
	        String value = token.nextToken();					
	        String domain = token.nextToken();					
	        String path = token.nextToken();					
	        Date expiry = null;					
	        		
	        String val;			
	        if(!(val=token.nextToken()).equals("null"))
			{		
	        	expiry = new Date(val);					
	        }		
	        Boolean isSecure = new Boolean(token.nextToken()).								
	        booleanValue();		
	        Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);			
	        System.out.println(ck);
	        return ck;
	        }		
	        }		
	        }catch(Exception ex){					
	        return null;
	        }	
	  return null;
	}	
 }

