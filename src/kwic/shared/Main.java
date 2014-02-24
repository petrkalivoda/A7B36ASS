package kwic.shared;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Petr Kalivoda
 */
public class Main {

    protected static String filename /**/ = "src/kwic/shared/input.txt" /**/;
    protected static ArrayList<char[]> characters;
    protected static ArrayList<int[]> index;
    protected static ArrayList<int[]> alphabetized_index;
    
    public static final int LINE = 0;
    public static final int CHAR = 1;

    /**
     * @param args 0 => filename
     */
    public static void main(String[] args) {
        //filename = args[0];
        input();
        circular_shift();
        alphabetize();
        output();
    }

    /**
     * Inputs the file, creates lines list.
     */
    public static void input() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            characters = new ArrayList<char[]>();
            String line;

            while ((line = br.readLine()) != null) {
                characters.add(line.trim().toCharArray());
            }

        } catch (IOException e) {
            System.err.println("I/O error");
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Creates an index of all possible shifts.
     */
    public static void circular_shift() {
        index = new ArrayList<int[]>();
        char[] line;
        int lineNo = 0;

        for (Iterator<char[]> it = characters.iterator(); it.hasNext(); lineNo++) {

            line = it.next();
            index.add(new int[]{lineNo, 0}); //original start

            for (int charNo = 0; charNo < line.length; charNo++) {
                if (line[charNo] == ' ') {
                    index.add(new int[]{lineNo, charNo + 1}); //add one to the index
                }
            }
        }
    }

    /**
     * Clones index and bubble sorts it in alphabetical order.
     */
    public static void alphabetize() {
        alphabetized_index = (ArrayList<int[]>) index.clone();
        boolean done = false;

        while (!done) { //such efficiency
            done = true; 
            for (int j = 0; j < alphabetized_index.size() - 1; j++) { //much speeed
                int[] pos_A = alphabetized_index.get(j); 
                int[] pos_B = alphabetized_index.get(j + 1);
                
                String A = new String(characters.get(pos_A[LINE])).substring(pos_A[CHAR]);
                String B = new String(characters.get(pos_B[LINE])).substring(pos_B[CHAR]);

                if (A.compareTo(B) > 0) { //so complexity
                    Collections.swap(alphabetized_index, j, j+1); //wow
                    done = false;
                }
            }
        }
    }

    /**
     * Outputs the corresponding lines and performs the actual shifting.
     */
    public static void output() {
        for (int[] position : alphabetized_index) {
            char[] line = characters.get(position[LINE]);
            
            //first, print the unpermuted part of string.
            System.out.print(new String(line).substring(position[CHAR]));
            
            //then print the rest in reversed order.
            List<String> words = new ArrayList<String>();
            String buf = "";
            
            for(int i = 0; i < position[CHAR]; i++) {
                if(line[i] == ' ') {
                    words.add(buf);
                    buf = "";
                }else {
                    buf += line[i];
                }
            }
            
            for(String s : words) {
                System.out.printf(" %s", s); 
            }
            
            System.out.printf("\n");   
        }
    }
}