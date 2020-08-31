

package summm;

import java.util.Timer;
import java.util.TimerTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Third {

	WebDriver driver=new InternetExplorerDriver();
Third()
{
	driver.get("http://localhost/Back.html");
}
	Timer timer = new Timer();
	TimerTask task = new TimerTask()
	{
		public void run() 
		{
			driver.close();
			timer.cancel();
		}};
		public void start() {
			// TODO Auto-generated method stub
		timer.schedule(task,60*900);	
	}
	public static void main(String args[])
	{
		System.setProperty("webdriver.ie.driver", "C:\\Users\\admin2\\Desktop\\IEDriverServer.exe");
		Third obj=new Third();
		obj.start();
	}
}