package kewill.revenue.ui;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import kewill.revenue.automation.RevenueUpdateRobot;
import kewill.revenue.dataAccess.ModelDataGateway;
import kewill.revenue.models.Revenue;

public class MainWindow extends userInterface.MainWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ModelDataGateway modelDataGateway = new ModelDataGateway();
	RevenueUpdateRobot robot=new RevenueUpdateRobot();

	public MainWindow() {
		super();
	}

	@Override
	public void onAutomateButtonClick() {
		// TODO Auto-generated method stub

		
		setState(ICONIFIED);
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					String fileName = fileTextBox.getText();
					LinkedList<Revenue> revenues=modelDataGateway.GetRevenues(fileName);
					robot.revenueUpdate(revenues, fileName);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(getPanel(), e.getStackTrace()+e.getMessage());
				}
				//JOptionPane.showMessageDialog(getPanel(), "Child");

			}
		});
		thread.start();

	}
}
