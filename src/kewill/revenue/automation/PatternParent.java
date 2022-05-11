package kewill.revenue.automation;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;



public class PatternParent {
	Screen screen;
	String imageDiretory;

	public PatternParent() {
		screen = new Screen();
		Settings.ActionLogs = true;
		//Settings.SlowMotionDelay = 2;
		Settings.setShowActions(true);
		
	//	imageDiretory ="..\\images\\"; //new Directory("images").getAbsolutePath();
	}
public boolean exists(String target) {
	Pattern pattern=GetPattern(target);
	if(screen.exists(pattern)!=null){
		System.out.println(target + " exists");
		return true;
	}else
		System.out.println(target+ " not exists ");
		return false;
}
public boolean exists(String target,double timeout) {
	Pattern pattern=GetPattern(target);

	if(screen.exists(pattern, timeout)!=null){
		System.out.println(target + " exists");
		return true;
	}else
		System.out.println(target+" not exists");
		return false;
}
public void click(String image) throws FindFailed {
	Pattern pattern=GetPattern(image);
	screen.click(pattern);
	System.out.println("Clicked "+ image);
}

public void click(String image,int x,int y) throws FindFailed {
	Pattern pattern=GetPattern(image);//new Pattern(image+".png");
	screen.click(pattern.targetOffset(x, y));
	System.out.println("Clicked "+ image);
}
public void doubleClick(String image) throws FindFailed {
	Pattern pattern=GetPattern(image);
	screen.doubleClick(pattern);
	System.out.println("Clicked "+ image);
}
public void doubleClick(String image,int x,int y) throws FindFailed {
	Pattern pattern=GetPattern(image);//new Pattern(imageDiretory+image+".png");
	screen.doubleClick(pattern.targetOffset(x,y));
	System.out.println("Clicked "+ image);
}

public void type(String txt) throws FindFailed {
	screen.type(txt);
}
public void wait(double second) throws InterruptedException  {
	TimeUnit.SECONDS.sleep((int)(second));
}
public void wait(int second) throws InterruptedException  {
	TimeUnit.SECONDS.sleep((int)(second));
}
private Pattern GetPattern(String fileName) {
	
	Pattern pattern=null;
	try{
		pattern= new Pattern(this.getClass().getResource(fileName.concat(".png")));}
	catch (Exception e)
	{
		// TODO: handle exception
//		soCreation.app.Logger.Log(e);
	     
	}
	// pattern.similar(.7);
	return pattern;
}
}
