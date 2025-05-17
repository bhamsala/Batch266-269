package propertiestestfiles;

import utilitiesProgram.PropertiesFileUtility;

public class PFProgram2 {

	public static void main(String[] args) throws Exception
	{
		
		String pfpath="C:\\2025\\Batch-269\\IDE-BDD\\org.bofa.cne\\src\\test\\resources\\PropertiesFiles\\myconfig.properties";
		System.out.println(PropertiesFileUtility.getValueFromPropertiesFiles(pfpath, "name"));
		System.out.println("************************************************");
		System.out.println(PropertiesFileUtility.getAllValueFromPropertiesFiles(pfpath));
	}

}
