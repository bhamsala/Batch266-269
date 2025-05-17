package FALCON;





import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


import utilitiesProgram.ExcelFileUtility;


public class ExcelFileProgram9
{
	
	public static void main(String[] args) throws Exception
	{
		    String fp="C:\\2025\\Batch-269\\IDE-BDD\\org.bofa.cne\\src\\test\\resources\\Excelfile\\stylebook.xlsx";
			ExcelFileUtility ef=new ExcelFileUtility();
			ef.createXLSXFile(fp);
			Workbook wb=ef.openExcelFile(fp);
			Sheet sh=ef.addSheet(wb,"Sheet1");
			//set a value in a cell with all decorations
			ef.setCellValue(sh, 0, 0, "Hi Student Welcome Bhargava",14,"Courier New", true, true, IndexedColors.BLUE.getIndex(),IndexedColors.YELLOW.getIndex(), "JUSTIFY");
			//Save excel file
			ef.saveAndCloseExcel(wb, fp); 
		
	}
}
