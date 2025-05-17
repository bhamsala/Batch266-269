package FALCON;

import utilitiesProgram.ExcelFileUtility;


public class ExcelFileProgram3
{
	
	public static void main(String[] args) throws Exception
	{
	
		for(int i=1;i<=10; i++)
		{
			//Create ".xlsx" file with a sheet
			ExcelFileUtility ef=new ExcelFileUtility();
			ef.createXLSXFile("C:\\2025\\Batch-269\\IDE-BDD\\org.bofa.cne\\src\\test\\resources\\Excelfile\\Resultbook"+i+".xlsx");
		}
	}
}
