package FALCON;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import utilitiesProgram.ExcelFileUtility;


public class ExcelFileProgram8
{
	
	
		public static void main(String[] args) throws Exception
		{
		  // open existing file and get existing sheet 	//Access as an excel file, when it is .xls or .xlsx
			ExcelFileUtility ef=new ExcelFileUtility();
			Workbook wb=ef.openExcelFile("C:\\2025\\Batch-269\\IDE-BDD\\org.bofa.cne\\src\\test\\resources\\Excelfile\\vikram.xlsx");
			Sheet sh=ef.openSheet(wb,"Sheet1");
			int nour=ef.getRowsCount(sh);
			int nouc=ef.getCellscount(sh,0);
			//Row sum
			for (int i=0;i<nour;i++) // rowwise
			{
				
				int rowsum=0;
				for(int j=0;j<nouc;j++) //column wise is every row
				{
				String temp=ef.getCellValue(sh, i,j);
				int x=Integer.parseInt(temp);
			    rowsum=rowsum+x;
				}
			//Save excel file into HDD
				ef.setCellValue(sh, i, nouc, String.valueOf(rowsum));
			}
			// column Sum
			for (int i=0;i<nouc;i++) // columnwise
			{
				
				int colsum=0;
				for(int j=0;j<nour;j++) //row wise is every column
				{
				String temp=ef.getCellValue(sh,j, i);
				int x=Integer.parseInt(temp);
			    colsum=colsum+x;
				}
			//Save excel file into HDD
				ef.setCellValue(sh, nour,i, String.valueOf(colsum));
			}	
				
				ef.saveAndCloseExcel(wb, "C:\\2025\\Batch-269\\IDE-BDD\\org.bofa.cne\\src\\test\\resources\\Excelfile\\vikram.xlsx");
		}
	}
