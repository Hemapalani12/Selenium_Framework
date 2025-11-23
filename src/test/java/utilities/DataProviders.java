package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="Logindata")
	public String [][] getData() throws IOException 
	{
		String path=".\\testdata\\Opencart.xlsx";
		ExcelUtility Xfile= new ExcelUtility(path);
		int totalRow= Xfile.getRowCount("Sheet1");
		int totalCol= Xfile.getCellCount("Sheet1", 1);
		String loginData[][]= new String [totalRow][totalCol];
		for(int i=1;i<=totalRow;i++) //you are reading data from 1 first instead of 0 since that only have heading
		{
			for(int j=0;j<totalCol;j++) // it is read data from 0 column
			{
				loginData[i-1][j]= Xfile.getCellData("Sheet1", i, j);// 1,0
			}
		}
		
		return loginData; //returning two dimension array		
		
	}
}
