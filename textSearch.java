import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class textSearch{
	
	public static void searchText(String searchTerm, String path) throws IOException{
		printResult(searchTerm, fileToText(path));
	}
	
	private static List<String> fileToText(String path) throws IOException{
		java.util.List<String> lines = Files.readAllLines(Paths.get(path));
		return lines;
	}
	
	private static void printResult(String searchTerm, List<String> lines){
		for(String s: lines){
			if(s.contains(searchTerm)){
				System.out.println(s);
			}
		}
	}
	
	public static void main(String[] args){	    
		if (args.length != 2) {
		    System.out.println("Please use correct format as input: 'SearchTearm' 'Path'");
		    System.exit (-1);
		}
		
		String searchTerm = args[0];
		String path = args[1];
		
		try {
			textSearch(searchTerm, path);
		} catch (IOException e) {
			System.out.println("The file doesn't exist");
			System.exit (-1);
		}
	}
}