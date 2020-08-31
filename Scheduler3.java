
package summm;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.TimerTask;
import java.util.Timer;

import javax.swing.JOptionPane;
public class Scheduler3
{
	int flag=0;	
	Timer timer = new Timer();
	TimerTask task = new TimerTask()
	{
		public void run() 
		{ 
			
			    
			if (flag==0){
				
final JFrame frame=new JFrame();
frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

frame.setTitle("Break reminder");
final JFXPanel fxpanel=new JFXPanel();
Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
int height=screenSize.height;
int width=screenSize.width;
frame.setSize(width/2, width/2);
frame.setLocationRelativeTo(null);
frame.setUndecorated(false);
frame.setVisible(true);
frame.getContentPane().add(fxpanel);
Object[] options = {"OK"};
int n = JOptionPane.showOptionDialog(null,
               "Take a Neck Break ","Break Reminder",
               JOptionPane.PLAIN_MESSAGE,
               JOptionPane.INFORMATION_MESSAGE,
               null,
               options,
               options[0]);

Platform.runLater(new Runnable() {
@Override
public void run()
    {
    WebEngine engine;
    WebView wv=new WebView();
    engine=wv.getEngine();
    fxpanel.setScene(new Scene(wv));
    engine.load("file:///C:/Users/admin2/Desktop/Neck.html");
    }
    });
frame.setVisible(true);

			    flag++;	
			    }
			    else if(flag==1)
			    {
			    	
			    	

final JFrame frame=new JFrame();
frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

final JFXPanel fxpanel=new JFXPanel();
Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
int height=screenSize.height;
int width=screenSize.width;
frame.setSize(width/2, width/2);
frame.setLocationRelativeTo(null);
frame.setUndecorated(false);
frame.setVisible(true);
frame.getContentPane().add(fxpanel);
frame.setTitle("Break reminder");
Object[] options = {"OK"};
int n = JOptionPane.showOptionDialog(null,"Take a Shoulder Break"
		,"Break Reminder",
               JOptionPane.PLAIN_MESSAGE,
               JOptionPane.INFORMATION_MESSAGE,
               null,
               options,
               options[0]);

Platform.runLater(new Runnable() {
@Override
public void run()
    {
    WebEngine engine;
    WebView wv=new WebView();
    engine=wv.getEngine();
    fxpanel.setScene(new Scene(wv));
    engine.load("file:///C:/Users/admin2/Desktop/Shoulder.html");
    }
    });
frame.setVisible(true);

			    	flag++;
			    	
			    }
			    else if(flag==2)
			    {
			    	
final JFrame frame=new JFrame();
frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

final JFXPanel fxpanel=new JFXPanel();
Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
int height=screenSize.height;
int width=screenSize.width;
frame.setSize(width/2, width/2);
frame.setLocationRelativeTo(null);
frame.setUndecorated(false);
frame.setVisible(true);
frame.getContentPane().add(fxpanel);
frame.setTitle("Break reminder");
Object[] options = {"OK"};
int n = JOptionPane.showOptionDialog(null,
               "Take a Back Break ","Break Reminder",
               JOptionPane.PLAIN_MESSAGE,
               JOptionPane.INFORMATION_MESSAGE,
               null,
               options,
               options[0]);
Platform.runLater(new Runnable() {
@Override
public void run()
    {
    WebEngine engine;
    WebView wv=new WebView();
    engine=wv.getEngine();
    fxpanel.setScene(new Scene(wv));
    engine.load("file:///C:/Users/admin2/Desktop/Back.html");
    }
    });
frame.setVisible(true);	    
				flag++;
			    } 
			    else if(flag==3){
			    	System.exit(0);;
			    }
		
		};
	};
		/**
		 * @wbp.parser.entryPoint
		 */
		public void start() {
			timer.scheduleAtFixedRate(task, 10*60*1000, 10*60*1000);	// TODO Auto-generated method stub
			
		}
	
/**
 * @wbp.parser.entryPoint
 */
public static void main(String[] args)
{
	
	Scheduler3 you =new Scheduler3();
	you.start();	
    
}
}


