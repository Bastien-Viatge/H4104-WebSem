import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.regex.MatchResult;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import nu.validator.htmlparser.dom.HtmlDocumentBuilder;

import org.w3c.dom.*;
import org.xml.sax.InputSource;


public class Spotlight {
	public static void main (String[] Args) throws MalformedURLException, IOException{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			System.out.println("#4104 url");
			String url = sc.nextLine();
			System.out.println(url);
			System.out.println("#4104 uri");
			String texte = sc.nextLine();
			doPost(texte);
		}
		sc.close();

	}

/*	public static void lireSite(String url) throws MalformedURLException, IOException
	{
	    String regex = "href=\"([^\\\"]*)\"";
	    
	    Scanner sc = new Scanner(new URL(url).openStream());
	    
	    while (sc.hasNextLine())
	    {
	        String line = sc.nextLine();
	        System.out.println(line);
	        if (line.matches(regex))
	        {
	            Scanner sc2 = new Scanner(line);
	            sc2.findInLine(regex);
	            
	            MatchResult result = sc2.match();
	            System.out.printf("%s\n",result.group(1));
	            sc2.close();
	        }
	    }
	    sc.close();
	}*/
	

public static void doPost(String texte){
   OutputStreamWriter writer = null;
   BufferedReader reader = null;
   try {
     //encodage des paramètres de la requête
      String donnees = URLEncoder.encode("text", "UTF-8")+
                        "="+(texte);
 
      //création de la connection
      URL url = new URL("http://spotlight.dbpedia.org/rest/annotate?confidence=0.2&support=20");
      URLConnection conn = url.openConnection();
      conn.setDoOutput(true);
 
      //envoi de la requête
      writer = new OutputStreamWriter(conn.getOutputStream());
      writer.write(donnees);
      writer.flush();
 
      //lecture de la réponse
      HtmlDocumentBuilder db = new HtmlDocumentBuilder();
      //Document doc = db.parse(new URL(url).openStream());
      Document doc = db.parse(new InputSource(conn.getInputStream()));
      
      XMLparser.parseAndStream(doc,System.out);
      /*reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String ligne;
      while ((ligne = reader.readLine()) != null) {
         System.out.println(ligne);
      }*/
   }catch (Exception e) {
      e.printStackTrace();
   }finally{
      try{writer.close();}catch(Exception e){}
   }
}


}