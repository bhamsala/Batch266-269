package FALCON;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import utilitiesProgram.ExcelFileUtility;


public class ExcelFileProgram5
{
	
	public static void main(String[] args) throws Exception
	{
	    //open an existing file
		ExcelFileUtility ef=new ExcelFileUtility();
		Workbook book=ef.openExcelFile("C:\\2025\\Batch-269\\IDE-BDD\\org.bofa.cne\\src\\test\\resources\\Excelfile\\Resultbook1.xlsx");
		Sheet sh=ef.openSheet(book,"Sheet0");
		int nour=ef.getRowsCount(sh);
	  //create a result column in sheet
		ef.createResultColumn(sh, 2);// index 2 third column
		//1st row(index=0) has names of columns
		for (int i=1;i<nour;i++)//data driven from 2nd rows (index=1)
		{
			String temp1=ef.getCellValue(sh, i, 0);
			String temp2=ef.getCellValue(sh,i,1);
			int x=Integer.parseInt(temp1);
			int y=Integer.parseInt(temp2);
			int z=x+y;
			String temp3=String.valueOf(z);
			ef.setCellValue(sh, i, 2, temp3);
		}
		//Save excel file into HDD
		ef.saveAndCloseExcel(book, "C:\\2025\\Batch-269\\IDE-BDD\\org.bofa.cne\\src\\test\\resources\\Excelfile\\Resultbook1.xlsx");
	}
}
