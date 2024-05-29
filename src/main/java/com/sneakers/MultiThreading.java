package com.sneakers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MultiThreading implements Runnable{
	private int size;
	private int port;
	private int profile;
	private String customDomain;
	private String region;
	private String token;
	private String phoneCountry;
	private String customPassword;
	ArrayList<proxy> arr = new ArrayList<proxy>();
	public void settingvar(int size, int port, int profile,String customDomain, String region, String token, String phoneCountry, String customPassword, ArrayList<proxy> aram) {
		this.size = size;
		this.port = port;
		this.profile= profile;
		this.customDomain = customDomain;
		this.region = region;
		this.token = token;
		this.phoneCountry = phoneCountry;
		this.customPassword= customPassword;
		this.arr = aram;
	}
	@Override
	public void run() {
		for(int i = 0; i<size;i++) {
		    ProcessBuilder ye1s = new ProcessBuilder("cmd.exe","/c","rmdir /s /q \"C:\\selenum\\ChromeProfile\\Profile "+profile);
		    
		     }
		
	     
		
		
	   
      

	

}
}

