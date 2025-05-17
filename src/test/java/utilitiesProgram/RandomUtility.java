package utilitiesProgram;

import java.util.Random;

public class RandomUtility
{
	    public static String generateRandomEmail() 
	    {
	        String[] domains={"gmail.com","yahoo.com","hotmail.com","example.com","batch265266.co.in"};
	        Random rand=new Random();
	        String username=generateRandomString(8); // You can specify the username length
	        String domain=domains[rand.nextInt(domains.length)];
	        return(username+"@"+domain);
	    }

	    public static String generateRandomString(int length) 
	    {
	        String characters="abcdefghijklmnopqrstuvwxyz0123456789"; //You can add other chars if needed
	        StringBuilder username=new StringBuilder();
	        Random rand=new Random();
	        for(int i = 0; i<length; i++) 
	        {
	            int index=rand.nextInt(characters.length());
	            username.append(characters.charAt(index));
	        }
	        return(username.toString());
	    }
}


