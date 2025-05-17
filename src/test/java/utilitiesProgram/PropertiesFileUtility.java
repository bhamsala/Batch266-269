package utilitiesProgram;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.configuration.PropertiesConfiguration;

public class PropertiesFileUtility {

	public static void createPropertiesFiles(String pfPath,String[] names,String[] values) throws Exception
	{
		// TODO Auto-generated method stub
      Properties p=new Properties();
	  for(int i=0;i<names.length;i++)
	  {
		  p.setProperty(names[i], values[i]);
	  }
	  File f=new File(pfPath);
	  FileWriter fw=new FileWriter(f);
	  p.store(fw,"Welcome");
	}

	public static String getValueFromPropertiesFiles(String pfPath,String propertyname) throws Exception
	{
		//open an existing Properties file in READ mode
		FileInputStream fi=new FileInputStream(pfPath);
		Properties p=new Properties();
		p.load(fi);
		String value=p.getProperty(propertyname);
		fi.close();
		return (value);
	}
	
	public static Map<String,String> getAllValueFromPropertiesFiles(String pfPath) throws Exception
	{
		// TODO Auto-generated method stub
		FileInputStream fi=new FileInputStream(pfPath);
		Properties p=new Properties();
		p.load(fi);
		Set<Object> prs=p.keySet();//get properties names
		Map<String,String> m=new HashMap<String,String>();
		for(Object pr:prs)
		{
			m.put(pr.toString(), p.getProperty(pr.toString()));
		}
		
		fi.close();
		return (m);
	}
	
	public static void updatePropertiesFiles(String pfPath,String[] names,String[] values) throws Exception
	{
		// TODO Auto-generated method stub
		File  fi=new File(pfPath);
		PropertiesConfiguration p=new PropertiesConfiguration(fi);
		for(int i=0;i<names.length;i++)
		{
			p.setProperty(names[i], values[i]);
		}
		p.save();
	}
	
}
