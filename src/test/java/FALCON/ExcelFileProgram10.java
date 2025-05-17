package FALCON;





import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utilitiesProgram.ExcelFileUtility;


public class ExcelFileProgram10
{
	
	public static void main(String[] args) throws Exception
	{
		    File ef= new File ("C:\\2025\\Batch-269\\IDE-BDD\\org.bofa.cne\\src\\test\\resources\\Excelfile\\bbook55.xlsx");
			FileOutputStream fo= new FileOutputStream(ef);
			XSSFWorkbook wwb=new XSSFWorkbook();
			Sheet sh=wwb.createSheet("MYsheet");
			sh.createRow(0).createCell(0).setCellValue("Name");
			sh.getRow(0).createCell(1).setCellValue("File/Folder");
			sh.getRow(0).createCell(2).setCellValue("Size");
			sh.getRow(0).createCell(3).setCellValue("Last modified");
			sh.getRow(0).createCell(4).setCellValue("Hidden");
			//copy all files names and other details into excell sheet from 2nd row(index=1)
			File target=new File("C:\\2025\\Batch-269");
			File[] l=target.listFiles();
			int rowindex=1; // 1st row index=0 has names for columns
			for (File f:l)//take each file or folder from list/collection
			{
				//1 get name of file folder and then store in 1st column
				sh.createRow(rowindex).createCell(0).setCellValue(f.getName());
				sh.autoSizeColumn(0);
				//2 get type and size and then store them into 2 column and 3 column
				if(f.isFile())
				{
					sh.getRow(rowindex).createCell(1).setCellValue("file");
					sh.autoSizeColumn(1);
					double b=f.length();
					double k=(b/1024);
					sh.getRow(rowindex).createCell(2).setCellValue(k+"KB");
					sh.autoSizeColumn(2);
				}
				else
				{
					sh.getRow(rowindex).createCell(1).setCellValue("folder");
					long b=FileUtils.sizeOfDirectory(f);
					double k=(b/1024);
					sh.getRow(rowindex).createCell(2).setCellValue(k+"KB");
					sh.autoSizeColumn(2);
				}
					//3.get last modified date and time of file folder
					SimpleDateFormat sdf=new SimpleDateFormat("MMM/dd/yyyy HH:mm:ss");
					sh.getRow(rowindex).createCell(3).setCellValue(sdf.format(f.lastModified()));
					sh.autoSizeColumn(3);
					//4: get the file folder is hidden or not and store in 5th column
					if(f.isHidden())
					{
						sh.getRow(rowindex).createCell(4).setCellValue("Yes");
					}
					else
					{
						sh.getRow(rowindex).createCell(4).setCellValue("No");
					}
					
					rowindex++;// Mandatory to go to next row in excel sheet
				}
				//Take write permission on that file
				wwb.write(fo); //save file
				wwb.close();
				fo.close();
			}
	}
								
					
	