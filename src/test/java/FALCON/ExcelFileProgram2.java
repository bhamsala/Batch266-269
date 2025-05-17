package FALCON;



import java.util.Scanner;

import org.testng.annotations.Test;

import utilitiesProgram.ExcelFileUtility;


public class ExcelFileProgram2
{
	
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("How many .xlsx files you want to create?");
		int n=sc.nextInt();
		sc.close();
		for(int i=1;i<=n; i++)
		{
			//Create ".xlsx" file with a sheet
			ExcelFileUtility ef=new ExcelFileUtility();
			ef.createXLSXFile("C:\\2025\\Batch-269\\IDE-BDD\\org.bofa.cne\\src\\test\\resources\\Excelfile\\Resultbook"+i+".xlsx");
		}
	}
}
