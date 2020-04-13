import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Game {
	public static void run(String field) throws IOException{
		
		File folder = new File("level/");
		File file = new File(folder, field);
	    FileReader fr = new FileReader(file.getPath()); 
	    BufferedReader br = new BufferedReader(fr);  
	    
	    int lines = 0;
	    String l;
	    int ch;
	    int max_line_length = 0;
	    while((l = br.readLine()) != null){
	    	if(l.length() > max_line_length){
	    		max_line_length = l.length();
	    	}
	    	lines++;
	    }
	    
	    char[][] map = new char[lines][max_line_length];

	    FileReader reader = new FileReader(file.getPath());
	    BufferedReader f = new BufferedReader(reader);
	    String d;
	    int k = 0;
	    while((d = f.readLine()) != null){
	    	
	    	for(int i = 0; i< d.length(); i++){
	    		//System.out.println(d.charAt(i));
	    		map[k][i] = d.charAt(i);
	    		//add game logic here
	    	}
	    	k++;
	    }
	    /*
	    for(int i = 0; i< lines; i++){
	    	for(int j = 0; j< max_line_length; j++){
	    		System.out.println(map[i][j]);
	    	}
	    }*/
	}
	
	public static void main(String[] args) throws IOException{
        run("sokoban.txt");	
	}
}
