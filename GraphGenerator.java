
import java.util.*

public class GraphGenarator {
	private const String URL = "#H4104 url";
	private const String URI = "#H4104 uri";
	protected String result;

	public void main(String[] args){
		Scanner scan = new Scanner(System.in);
	}
	
	public void readIn()  {
		String tmp = "";
		String token = "";
		tmp = scan.nextLine();
		while(!tmp.isEmpty()){
			if(tmp.equals(URL)){
				token = "url";
			}else if(tmp.equals(URI)){
				token = "uri";
			}
			
			if(token.equals(URL) && !tmp.equals(URL)){
				result += tmp+"\n";
			}else if(token.equals(URI) && !tmp.equals(URI)){
				//traitement d'une Uri
				//création d'un triplet
			}
			tmp = scan.nextLine();
		}
	}
	
	


}