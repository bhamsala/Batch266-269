package FALCON;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import utilitiesProgram.ExcelFileUtility;


public class ExcelFileProgram4
{
	
	public static void main(String[] args) throws Exception
	{
	 //open an existing excel file
		ExcelFileUtility ef=new ExcelFileUtility();
		Workbook book=ef.openExcelFile("C:\\2025\\Batch-269\\IDE-BDD\\org.bofa.cne\\src\\test\\resources\\Excelfile\\Resultbook1.xlsx");
		Sheet sh=ef.openSheet(book,"Sheet0");
		int nour=ef.getRowsCount(sh);
		//Get used columns count
		int nouc=ef.getCellscount(sh, 0); //0 means 1 rows
		//create a result column in sheet
		ef.createResultColumn(sh, nouc);
		//1st row(index=0) has names of columns
		for (int i=1;i<nour;i++)//data driven from 2nd rows (index=1)
		{
			String temp1=ef.getCellValue(sh, i, 0);// 1st column
			String temp2=ef.getCellValue(sh, i, 1);// 2nd column
			int x=Integer.parseInt(temp1);//string to integer
			int y=Integer.parseInt(temp2);
			int z=x+y;//perform addition
			String temp3=String.valueOf(z);//integer to string
			ef.setCellValue(sh, i, nouc, temp3);//3rd column
		}
		//Save excel file into HDD
		ef.saveAndCloseExcel(book, "C:\\2025\\Batch-269\\IDE-BDD\\org.bofa.cne\\src\\test\\resources\\Excelfile\\Resultbook1.xlsx");
	}
}
