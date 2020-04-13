import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Game {
	public static void run(String field) throws IOException{
		File folder = new File("level/");
		File file = new File(folder, field);
	    FileReader fr = new FileReader(file.getPath());   //Creation of File Reader object
	    BufferedReader br = new BufferedReader(fr);  //Creation of BufferedReader object
	    int lines = 0;
	    String l;
	    int max_line_length = 0;
	    while((l = br.readLine()) != null){
	    	if(l.length() > max_line_length){
	    		max_line_length = l.length();
	    	}
	    	lines++;
	    }
		char[][] map = new char[lines][max_line_length];
		for(int i = 0; i < lines; i++){
			for(int j = 0; j < max_line_length; j++){
				map[i][j] = '#';
			}
		}
	    System.out.println(Arrays.toString(map[0]));
	    System.out.println(max_line_length);
	    br.close();
	}
	
	public static void main(String[] args) throws IOException{
        run("sokoban.txt");	
	}
}
