 //à voir !! import de la lib
import java.util.*

public class GraphGenarator {
	private const String URL = "#H4104 url";
	private const String URI = "#H4104 uri";
	protected String result; // String à renvoyer sur la console
	private const String BEGGIN = "SELECT * WHERE{?s , ?s, ?o. FILTER(?s in ("; //début de la requête SPARQL

	public void main(String[] args){
		Scanner scan = new Scanner(System.in);
	}
	
	public void readIn()  {
		String request ="";
		String tmp = "";
		String token = "";
		tmp = scan.nextLine();
		while(!tmp.isEmpty()){
			if(tmp.equals(URL)){
				token = "url";
				if(request.isEmpty()){
					request = BEGGIN;
				}else{
					if ( request.charAt(request.length()-1)==',') {
					  request = request.substring(0, request.length()-1);
					}
					request += ")) }"; // requête finie !
					sendRequest(request);
				}
				
				//some shit here
			}else if(tmp.equals(URI)){
				token = "uri";
			}
			
			if(token.equals(URL) && !tmp.equals(URL)){
				result += tmp+"\n";
			}else if(token.equals(URI) && !tmp.equals(URI)){
				dbppediaRequest += "<"+tmp+">,";
			}
			tmp = scan.nextLine();
		}
	}
	
	public void sendRequest(String request){
		static String ur = "http://dbpedia.org/sparql";
		static String urlEnd = "&format=json&timeout=30000";
		request = "?default-graph-uri=http%3A%2F%2Fdbpedia.org&query=" + URLEncoder.encode(request,"UTF-8") + urlEnd;
		URL url = new URL(ur);
		URLConnection  conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
		writer.write(request);
		writer.flush();
		//recuperation du code html
		String ligne = null,jsonResult=null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		while ((ligne = reader.readLine()) != null) {
				jsonResult+= ligne.trim()+"\n";
		}
		formatJsonResult(jsonResult);
	}
	
	public void formatJsonResult(String json){
		
	}
}