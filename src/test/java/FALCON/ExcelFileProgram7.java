package FALCON;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import utilitiesProgram.ExcelFileUtility;


public class ExcelFileProgram7
{
	
	
		public static void main(String[] args) throws Exception
		{
		// open existing file and get existing sheet
			ExcelFileUtility ef=new ExcelFileUtility();
			Workbook book1=ef.openExcelFile("C:\\2025\\Batch-269\\IDE-BDD\\org.bofa.cne\\src\\test\\resources\\Excelfile\\Resultbook1.xlsx");
			Sheet sh1=ef.openSheet(book1,"Sheet0");
			int nour=ef.getRowsCount(sh1);
			//create a new excel file with a sheet
			ef.createXLSXFile("C:\\2025\\Batch-269\\IDE-BDD\\org.bofa.cne\\src\\test\\resources\\Excelfile\\Resultbook2.xlsx");
			Workbook book2=ef.openExcelFile("C:\\2025\\Batch-269\\IDE-BDD\\org.bofa.cne\\src\\test\\resources\\Excelfile\\Resultbook2.xlsx");
			Sheet sh2=ef.addSheet(book2,"Sheet1");
			//create a result column in sheets
			ef.createResultColumn(sh2, 0);//1st column in sheet2 is result column
			//data driven from 2nd rows (index=1)
			for (int i=1;i<nour;i++) //1st row(index=0) has names of columns
			{
				String temp1=ef.getCellValue(sh1,i, 0);
				String temp2=ef.getCellValue(sh1,i,1);
				int x=Integer.parseInt(temp1);
				int y=Integer.parseInt(temp2);
				int z=x+y;
				String temp3=String.valueOf(z);
				ef.setCellValue(sh2, i, 0, temp3);
			}
			//Save excel file into HDD
			ef.saveAndCloseExcel(book2, "C:\\2025\\Batch-269\\IDE-BDD\\org.bofa.cne\\src\\test\\resources\\Excelfile\\Resultbook2.xlsx");
		}
	}
