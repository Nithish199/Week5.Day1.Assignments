package Week5.Day2.dataProvider;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ServiceNowReadExcel {

	public String[][] readdata2(String fileName) throws IOException {
	
		XSSFWorkbook b= new XSSFWorkbook("./Data/servicenow2.xlsx");
		XSSFSheet sheet=b.getSheet("Sheet1");
		int rowcount =sheet.getLastRowNum();
		short columncount = sheet.getRow(0).getLastCellNum();
		String[][] data=new String[rowcount][columncount];
		for(int i=1;i<=rowcount;i++) {
			for(int j=0;j<columncount;j++) {
				String values = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j]=values;
				
			}
		}
		return data;
		
	}
}
