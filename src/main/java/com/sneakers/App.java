package com.sneakers;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;



public class App implements Runnable
{
	static ArrayList<Thread> arr = new ArrayList<Thread>();
	static int NoOfAccounts;
	static int port;
    static int Multithreadno;
    static String customdomania;
    static String region;
    static String token;
    static String license;
    static String customopassword;
    static String phoneCountry;
    static ArrayList<proxy> proxies = new ArrayList<proxy>();
    public static String getId(String filepath) {
  	  try {
  	         File file = new File(filepath);
  	         FileReader fr = new FileReader(file);
  	         BufferedReader br = new BufferedReader(fr);
  	         String line = "";
  	         String temp = "";
  	         while((line = br.readLine()) != null) {
  	            temp = line;
  	         }
  	         br.close();
  	         return temp;
  	         } catch(IOException ioe) {
  	            ioe.printStackTrace();
  	         }
  	return null;
    }
    public static ArrayList<proxy> csvListAll(String path) {
		ArrayList<proxy> record = new ArrayList<proxy>();
		String data = ""; String port1 = ""; String username = ""; String password = "";
		try {
			Scanner x;
			x = new Scanner(new File(path));
			x.useDelimiter("[:\n]");
			while(x.hasNext()) {
				data = x.next();
				port1 = x.next();
				username = x.next();
				password = x.next();
				proxy pro = new proxy();
				pro.setProvider(data);
				pro.setPort(port1);
				pro.setUsername(username);
				pro.setPassword(password);
				record.add(pro);
			
			}
		}catch(Exception e) {
			System.out.println("No Proxies");
			try {
				Thread.sleep(10*1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
			}
			
		}
		return record;
		
	}
    public static void main( String[] args ) throws InterruptedException, AWTException, IOException
    {
     System.out.println("Initializing...");
     System.out.println("Checking License");
     File file = new File("license.txt");
     if(!file.exists()) {
   	    System.out.println("No license file found");
   	    return;
     }
     license = getId("license.txt");
     Map<String, String> headers = new HashMap<>(); 
	     headers.put("Authorization", "Bearer pk_3QQyt93oDlgylh8eK9ajBHdMIBFoTZfd");
	     headers.put("Content-Type", "application/json");
	 
			
	     try {
			HttpResponse<JsonNode>	jsonResponse = Unirest.get("https://api.hyper.co/v4/licenses/"+license)
					  .headers(headers)
					  .asJson();
			if(jsonResponse.getStatus()==200) {
				System.out.println("License validated!");
				File file2 = new File("token.txt");
				if(!file2.exists()) {
			   	    System.out.println("No token file found");
			   	    return;
			     }
				  token = getId("token.txt");
				  URL url = new URL("https://5sim.net/v1/user/profile");
				  HttpURLConnection http = (HttpURLConnection)url.openConnection();
				  http.setRequestProperty("Authorization", "Bearer "+token);
				  http.setRequestProperty("Content-Type", "application/json");
		 	    if(http.getResponseCode()==200) {
		 	    	System.out.println("5sim token validated");
		 	    	System.out.println("Checking proxies");
		 	    	File file3 = new File("proxies.txt");
		 	    	if(!file3.exists()) {
				   	    System.out.println("No proxies file found");
				   	    return;
				     }
		 	    	proxies = csvListAll("proxies.txt");
		 	    	if(proxies.size()<1) {
		 	    		System.out.println("Proxies file is empty!");
		 	    		Thread.sleep(10*1000);
		 	    		return;
		 	    	}
		 	    	//System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
		 	    	 new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  
		 	    	System.out.println("\n"
		 	    			+ "\n"
		 	    			+ "░██████╗░███████╗███╗░░██╗████████╗░█████╗░░█████╗░██╗░░░░░░██████╗░░░███████╗██╗░░██╗███████╗\n"
		 	    			+ "██╔════╝░██╔════╝████╗░██║╚══██╔══╝██╔══██╗██╔══██╗██║░░░░░██╔════╝░░░██╔════╝╚██╗██╔╝██╔════╝\n"
		 	    			+ "██║░░██╗░█████╗░░██╔██╗██║░░░██║░░░██║░░██║██║░░██║██║░░░░░╚█████╗░░░░█████╗░░░╚███╔╝░█████╗░░\n"
		 	    			+ "██║░░╚██╗██╔══╝░░██║╚████║░░░██║░░░██║░░██║██║░░██║██║░░░░░░╚═══██╗░░░██╔══╝░░░██╔██╗░██╔══╝░░\n"
		 	    			+ "╚██████╔╝███████╗██║░╚███║░░░██║░░░╚█████╔╝╚█████╔╝███████╗██████╔╝██╗███████╗██╔╝╚██╗███████╗\n"
		 	    			+ "░╚═════╝░╚══════╝╚═╝░░╚══╝░░░╚═╝░░░░╚════╝░░╚════╝░╚══════╝╚═════╝░╚═╝╚══════╝╚═╝░░╚═╝╚══════╝");
		 	    	Scanner myObj = new Scanner(System.in);
		 	    	System.out.println("Press 1 to start!");
		 	    	String tempo = myObj.nextLine();
		 	    	if(tempo.equals("1")) {
		 	    		System.out.println("State the number of nike accounts you want to generate");
		 	    		tempo = myObj.nextLine();
		 	    		if(Integer.parseInt(tempo)>0) {
		 	    			NoOfAccounts = Integer.parseInt(tempo);
		 	    			System.out.println("Do you wish to use custom domain?, if so type 1 else press enter");
		 	    			tempo = myObj.nextLine();
		 	    			customdomania = "no";
		 	    			if(tempo.equals("1")) {
		 	    				System.out.println("Type in your custom domain Example: @YouCustomDomain.com");
		 	    				customdomania = myObj.nextLine();
		 	    			}
		 	    			System.out.println("Select your 5sim provider region by stating the numbers!\n"
		 	    					+ "1. russia\n"
		 	    					+ "2. malaysia\n"
		 	    					+ "3. singapore\n"
		 	    					+ "4. thailand\n"
		 	    					+ "5. uk\n"
		 	    					+ "6. philippines\n");
		 	    			tempo = myObj.nextLine();
		 	    			if(tempo.matches("[1-6]+")) {
		 	    			   if(tempo.equals("1")) {
		 	    				   region = "ru";
		 	    				   phoneCountry = "russia";
		 	    			   }
		 	    			  if(tempo.equals("2")) {
		 	    				   region = "my";
		 	    				   phoneCountry = "malaysia";
		 	    			   }
		 	    			 if(tempo.equals("3")) {
		 	    				   region = "sg";
		 	    				   phoneCountry = "singapore";
		 	    			   }
		 	    			 if(tempo.equals("4")) {
		 	    				   region = "th";
		 	    				   phoneCountry = "thailand";
		 	    			   }
		 	    			 if(tempo.equals("5")) {
		 	    				   region = "uk";
		 	    				   phoneCountry = "uk";
		 	    			   }
		 	    			 if(tempo.equals("6")) {
		 	    				   region = "ph";
		 	    				   phoneCountry = "philippines";
		 	    				 
		 	    			   }
		 	    			System.out.println("Do you wish to use custom password?, if so type 1 else press enter");
		 	    			tempo = myObj.nextLine();
		 	    			customopassword = "no";
		 	    			if(tempo.equals("1")) {
		 	    				System.out.println("Please type in your custom password, reminder you must have at least 1 uppercase letter 1 numbers and total word length of not less than 8");
		 	    				customopassword = myObj.nextLine();
		 	    			}
		 	    			System.out.println("Select the number of thread you want to use, please note your thread cannot be more than your number of accounts and your thread shouldnt have a remainder when being divided by number of accounts!");
		 	    			tempo = myObj.nextLine();
		 	    			int temper =Integer.parseInt(tempo);
		 	    			temper = NoOfAccounts%temper;
		 	    			if(Integer.parseInt(tempo)>NoOfAccounts) {
		 	    				System.out.println("Your thread is more than your account exiting");
		 	    				Thread.sleep(10*1000);
		 	    				return;
		 	    			}
		 	    			if(temper!=0) {
		 	    				System.out.println(Integer.parseInt(tempo)%NoOfAccounts);
		 	    				System.out.println("Invalid number this is due to the existence of remainder please specify another number next time, exiting");
		 	    				Thread.sleep(10*1000);
		 	    				return;
		 	    			}
		 	    			System.out.println("test");
		 	    			Multithreadno= Integer.parseInt(tempo);
		 	    			  if(NoOfAccounts%Multithreadno==0) {
		 	    				 port = 9222;
		 	    		         int halfAcc = NoOfAccounts/Multithreadno;
		 	    		    	 for(int i = 0; i<Multithreadno; i++) {
		 	    		    		 int temp = halfAcc*i;
		 	    		    		 int updatedport = port+temp;
		 	    		    		 
		 	    		    		 MultiThreading worker = new MultiThreading();
		 	    					  worker.settingvar(halfAcc, updatedport, temp, customdomania, region, token,phoneCountry,customopassword,proxies);
		 	    		    		  Thread thread = new Thread(worker);
		 	    		    		  thread.start(); 
		 	    		    			
		 	    		    	 }
		 	    		     }
		 	    			 
		 	    			}
		 	    			System.out.println("Incorrect Number Exiting");
		 	    			Thread.sleep(10*1000);
		 	    			return;
		 	    		}
		 	    		System.out.println("You cant create 0 Accounts!");
		 	    		Thread.sleep(10*1000);
		 	    		return;
		 	    	}
		 	    	System.out.println("The button 1 is located at your top left of your keyboard!");
		 	    	Thread.sleep(10*1000);
		 	    	return;
		 	    }
			
			
		} 
			System.out.println("License expired, app will quit in 10 seconds");
	        Thread.sleep(10*1000);
	        return;
	
	     } catch (UnirestException e) {
			// TODO Auto-generated catch block
			System.out.println("License expired, app will quit in 10 seconds");
	        Thread.sleep(10*1000);
	        return;
		}
 
   
     
    	
   
    	 
    	



    }
    

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


}
