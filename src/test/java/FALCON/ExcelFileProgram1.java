package FALCON;

import utilitiesProgram.ExcelFileUtility;

public class ExcelFileProgram1
{
	public static void main(String[] args) throws Exception
	{
		//Create ".xls" file with a sheet
		ExcelFileUtility ef=new ExcelFileUtility();
		//use single "/" or"\\" in file paths in Java code
		ef.createXLSFile("src/test/resources/Excelfile/Resultbook1.xls");
	}
}
