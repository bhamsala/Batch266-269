package propertiestestfiles;

import utilitiesProgram.PropertiesFileUtility;

public class PFProgram1 {

	public static void main(String[] args) throws Exception
	{
		//create a new properfiles file
		String[] pnames= {"name","age","address"};
		String[] pvals= {"John","25","USA"};
		String pfpath="C:\\2025\\Batch-269\\IDE-BDD\\org.bofa.cne\\src\\test\\resources\\PropertiesFiles\\myconfig.properties";
		PropertiesFileUtility.createPropertiesFiles(pfpath,pnames,pvals);
	}

}
