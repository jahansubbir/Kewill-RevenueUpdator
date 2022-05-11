package kewill.revenue.app;

import java.awt.Dimension;
import java.awt.DisplayMode;

import java.awt.Toolkit;

import com.sun.jna.platform.win32.GDI32;
import com.sun.jna.platform.win32.WinDef;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;

import kewill.revenue.ui.MainWindow;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display display=new Display();
	Point point=	display.getCurrent().getDPI();
	int x=point.x;
		
	System.out.println(x);
		kewill.revenue.ui.MainWindow mainWindow=new MainWindow();
		mainWindow.setTitle("Kewill Revenue Update 1.0");

	}
	public static int getScaleFactor() {
	    WinDef.HDC hdc = GDI32.INSTANCE.CreateCompatibleDC(null);
	    if (hdc != null) {
	        int actual = GDI32.INSTANCE.GetDeviceCaps(hdc, 10 /* VERTRES */);
	        int logical = GDI32.INSTANCE.GetDeviceCaps(hdc, 117 /* DESKTOPVERTRES */);
	        GDI32.INSTANCE.DeleteDC(hdc);
	        // JDK11 seems to always return 1, use fallback below
	        if (logical != 0 && logical/actual > 1) {
	            return logical/actual;
	        }
	    }
	    return (int)(Toolkit.getDefaultToolkit().getScreenResolution() / 96.0);
	}
}
