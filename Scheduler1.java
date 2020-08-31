package summm;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.TimerTask;
import java.util.Timer;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class Scheduler1

{
	int flag=0;	
	Timer timer = new Timer();
	
	TimerTask task = new TimerTask()
	{
		public void run() 
		{ 
			
			    
			if (flag==0){
				First obj=new First();
				obj.start();
			    flag++;
			     
			    }
			    else if(flag==1)
			    {
			    	Second obj=new Second();
				    obj.start();
				    
   	flag++;
			    	
			    }
			    else if(flag==2)
			    {Third obj=new Third();
			    obj.start();
			    flag++;
			    } 
			    
		}
	};
		/**
		 * @wbp.parser.entryPoint
		 */
		public void start() {
				// TODO Auto-generated method stub
			timer.scheduleAtFixedRate(task, 2*60*1000, 2*60*1000);
			
		}
	
/**
 * @wbp.parser.entryPoint
 */
public static void main(String[] args)
{
	System.setProperty("webdriver.ie.driver", "C:\\Users\\admin2\\Desktop\\IEDriverServer.exe");
	
	Scheduler1 you =new Scheduler1();
	you.start();	
    
}
public void stopp()
{
	timer.cancel();
}
}

