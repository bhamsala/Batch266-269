package FALCON;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import utilitiesProgram.ExcelFileUtility;


public class ExcelFileProgram6
{
	
	
		public static void main(String[] args) throws Exception
		{
		//open an existing file
			ExcelFileUtility ef=new ExcelFileUtility();
			Workbook book=ef.openExcelFile("C:\\2025\\Batch-269\\IDE-BDD\\org.bofa.cne\\src\\test\\resources\\Excelfile\\Resultbook1.xlsx");
			Sheet sh1=ef.openSheet(book,"Sheet0");
			int nour=ef.getRowsCount(sh1);
			//create a new sheet for result
			Sheet sh2=ef.addSheet(book,"Sheet2");
			ef.createResultColumn(sh2, 0);//1st column in sheet2 is result column
		//Data driven from 2nd rows (index=1) in sheet1
			for (int i=1;i<nour;i++)//1st row(index=0) has names of columns in sheet1
			{
				String temp1=ef.getCellValue(sh1,i, 0);
				String temp2=ef.getCellValue(sh1,i,1);
				int x=Integer.parseInt(temp1);
				int y=Integer.parseInt(temp2);
				int z=x+y;
				String temp3=String.valueOf(z);
				ef.setCellValue(sh2, i, 0, temp3);//result into 1st column(index=0) in sheet2
			}
			//Save excel file into HDD
			ef.saveAndCloseExcel(book, "C:\\2025\\Batch-269\\IDE-BDD\\org.bofa.cne\\src\\test\\resources\\Excelfile\\Resultbook1.xlsx");
		}
	}
