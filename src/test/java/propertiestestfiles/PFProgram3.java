package propertiestestfiles;

import utilitiesProgram.PropertiesFileUtility;

public class PFProgram3 {

	public static void main(String[] args) throws Exception
	{
		
		String pfpath="C:\\2025\\Batch-269\\IDE-BDD\\org.bofa.cne\\src\\test\\resources\\PropertiesFiles\\myconfig.properties";
		String[] pnames= {"maxwaittimeinsecs","intervaltimeinmsecs","Super","Target"};
		String[] pvals= {"100","50","SMan","India"};
		PropertiesFileUtility.updatePropertiesFiles(pfpath,pnames,pvals);
	
	}

}
