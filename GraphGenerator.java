
import java.util.*

public class GraphGenarator {
	private const String URL = "#H4104 url";
	private const String URI = "#H4104 uri";
	protected String result;
	private const String BEGGIN = "SELECT * WHERE{?s , ?s, ?o. FILTER(?s in (";

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
					sendResquest(request);
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
		static String urlBeggin = "http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&query=";
		static String urlEnd = "+&format=json&timeout=30000";
		request = urlBeggin + URLEncoder.encode(request,"UTF-8") + urlEnd;
	
	}


}