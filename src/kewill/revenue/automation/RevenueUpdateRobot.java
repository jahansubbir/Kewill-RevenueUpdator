package kewill.revenue.automation;

import java.util.LinkedList;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;

import kewill.revenue.models.Revenue;
import main.App;

public class RevenueUpdateRobot extends PatternParent {

	public void revenueUpdate(LinkedList<Revenue> revenues, String fileName) throws FindFailed, InterruptedException {
		for (Revenue revenue : revenues) {
try{
			click("1");
			click("2");
			click("3");
			while (!exists("4")) {
				System.out.println("Waiting...");
				
			}
			click("4");
			click("5");
			wait(2f);
			if (exists("6",3)) {
				doubleClick("6",230,10);
			}else if(exists("6-1")){
			doubleClick("6-1",230,10);
			}
			
			else if (exists("8")) {
				doubleClick("8",230,10);
			}
			//System.out.println(revenue.getBlNo());
			wait(1f);
		//	screen.type(Key.BACKSPACE);
		//	wait(2);
		//	System.out.println(revenue.getBlNo());
			screen.type(revenue.getBlNo());
			wait(1f);
			click("7");
			wait(1);
			click("9");
			wait(1);
			if (exists("10")) {
				screen.type(Key.ENTER);
			}
			else {
				while (!exists("11")) {
					System.out.println("waiting for modification window...");
				}
				click("12");
				while (!exists("13")) {
					System.out.println("waiting for Revenue window");
				}
				click("14");
				if (exists("15")) {
					doubleClick("15",0,35);
					type(Key.BACKSPACE);
					type(String.valueOf(revenue.getContainerStuffingCharge()));
					type(Key.TAB);
					
										
				}
				doubleClick("16");
				if (exists("17")) {
					doubleClick("17", 0, 45);
					type(Key.BACKSPACE);
					type(String.valueOf(revenue.getVgmWeighingCharge()));
					type(Key.TAB);
				}
				doubleClick("18");
				if (exists("19")) {
					doubleClick("19", 0, 45);
					type(Key.BACKSPACE);
					type(String.valueOf(revenue.getLandingCharge()));
					type(Key.TAB);
				}
				click("20");
				wait(3f);
			}
		}catch (Exception e) {
			System.out.println(e.getStackTrace()[0].getLineNumber());
			System.out.println(e.getMessage());
		
		}
			// TODO: handle exception
		}
	}
}