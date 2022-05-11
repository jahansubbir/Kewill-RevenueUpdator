package kewill.revenue.dataAccess;

import java.util.LinkedList;

import com.codoid.products.fillo.Recordset;

import dataAccess.IModelDataGateway;
import kewill.revenue.models.Revenue;

public class ModelDataGateway extends dataAccess.ModelDataGateway {

	public LinkedList<Revenue> GetRevenues(String fileName) throws Exception 
	{
		LinkedList<Revenue> revenues = new LinkedList<Revenue>();
	
		try{
			Recordset recordset = super.getData(fileName);
			while (recordset.next()) {
				if(!recordset.getField("HBL NUM").trim().equals("")){
				Revenue revenue=new Revenue();
				revenue.setBlNo(recordset.getField("HBL NUM").trim());
				revenue.setContainerStuffingCharge(Double.parseDouble(recordset.getField("Container Stuffing").trim()));
				revenue.setVgmWeighingCharge(Double.parseDouble(recordset.getField("VGM Weighing Fee").trim()));
				revenue.setLandingCharge(Double.parseDouble(recordset.getField("Landing Charge").trim()));
				
				revenues.add(revenue);
				}
				
			}
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		return revenues;
	}

}
