package com.sneakers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class deleteProcess {
   public void deleteproc(String port, String profile) throws IOException {
	   String[] command = {"CMD", "/C", "netstat -aon |findstr :"+port+" |findstr ESTABLISHED"};
		 ProcessBuilder pb = new ProcessBuilder(command);
		 pb.directory(new File("C:/Windows/System32/"));
		 pb.redirectErrorStream(true);
		 Process p = pb.start();
		  try (BufferedReader reader = new BufferedReader(
	                 new InputStreamReader(p.getInputStream()))) {
	        	 String yes2 = "";
	             String line;
	             ArrayList<String> temporar = new ArrayList<String>();
	             while (( line = reader.readLine()) != null) {
	            	 System.out.println(line);
	            	   line = line.replace(" ", "");
	            	   yes2 ="";
	            	   for(int l =line.length()-1; l>=0;l--) {
	          	    	 String temp = Character.toString(line.charAt(l));
	                     if(temp.contains("D")) {
	                    	break;
	                     }
	                     yes2+=temp;
	             }
	            	   
	            	   temporar.add(yes2);
	             }
	             
	   for(int i1 = 0; i1<temporar.size();i1++) {
		  String temp23 = temporar.get(i1);
		  String neew = "";
		  for(int k1 = temp23.length()-1; k1>=0;k1--) {
		    	 String tem2p = Character.toString(temp23.charAt(k1));
			  neew+=tem2p;
		  }
		  temporar.set(i1, neew);
		  System.out.println(temporar.get(i1));
	   }
	   for(int i2 =0;i2<temporar.size();i2++) {
		   String cmd = "taskkill /F /PID " + temporar.get(i2);
		   Runtime.getRuntime().exec(cmd);

	   }
	   ProcessBuilder yes = new ProcessBuilder("cmd.exe","/c","rmdir /s /q \"C:\\selenum\\ChromeProfile\\Profile "+profile);
	     System.out.println("success");
	     yes.redirectErrorStream(true);
	     try {
			yes.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   } catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}
