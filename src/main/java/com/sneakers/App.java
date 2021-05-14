package com.sneakers;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


public class App 
{
    public static void main( String[] args ) throws InterruptedException, AWTException
    {
     String url = "https://www.nike.com/my/launch/t/air-jordan-1-hyper-royal?size=7&productId=ce29a7d4-377c-5adf-9f9f-6cb9bab279aa";
     StringSelection stringSelection = new StringSelection(url);
     Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
     clipboard.setContents(stringSelection, stringSelection);
     int x = 1185;
     int y = 82;
     Robot robot = new Robot();
     robot.mouseMove(x, y);
     robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
     robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
     Thread.sleep(100);
     robot.keyPress(KeyEvent.VK_CONTROL);
     robot.keyPress(KeyEvent.VK_V);
     Thread.sleep(300);
     robot.keyRelease(KeyEvent.VK_CONTROL);
     robot.keyRelease(KeyEvent.VK_V); 
     robot.keyPress(KeyEvent.VK_ENTER);
     Thread.sleep(500);
     robot.keyRelease(KeyEvent.VK_ENTER);
     while(true) {
    	 Color c = new Color(17,17,17);
    	if(robot.getPixelColor(908, 651).equals(c)) {
    		System.out.println("Checkoutpage");
    		Thread.sleep(600);
    		 String cvv = "999";
    	     StringSelection check = new StringSelection(cvv);
    	     Clipboard clipboard2 = Toolkit.getDefaultToolkit().getSystemClipboard();
    	     clipboard2.setContents(check, check);
    	     robot.mouseMove(1138, 495);
    	     robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    	     robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    	     robot.keyPress(KeyEvent.VK_CONTROL);
    	     robot.keyPress(KeyEvent.VK_V);
    	     robot.keyRelease(KeyEvent.VK_CONTROL);
    	     robot.keyRelease(KeyEvent.VK_V); 
    	     robot.mouseMove(971,641);
    	     robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    	     robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    	     robot.mouseMove(1116, 781);
    	     robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    	     robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    		
    	}
     }
    
}
}
