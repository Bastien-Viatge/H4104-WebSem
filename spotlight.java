import java.util.Scanner;

public class Spotlight{

	public static main (String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			String url = sc.nextLine();
			System.out.println("#H4104 ",url);
			lireSite(url);
		}

	}

	public static void lireSite(String url) throws MalformedURLException, IOException
	{
	    String regex = "title=\"([^\\\"]*)\"";
	    
	    Scanner sc = new Scanner(new URL(url).openStream());
	    
	    while (sc.hasNextLine())
	    {
	        String line = sc.nextLine();
	        if (line.matches(regex))
	        {
	            Scanner sc2 = new Scanner(line);
	            sc2.findInLine(regex);
	            
	            MatchResult result = sc2.match();
	            System.out.printf("%s\n",result);
	            sc2.close();
	        }
	    }
	    sc.close();
	}

}
