/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.adt.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import kwic.adt.characters.CharacterStorage;
import kwic.adt.characters.Characters;

/**
 *
 * @author Petr Kalivoda
 */
public class FileInput implements Input{
    
    
    protected File file;
    
    public FileInput(File file) {
        this.file = file;
    }
    
    
    @Override
    public Characters parse() {
        Characters c = new CharacterStorage();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            
            while((line = br.readLine()) != null) {
                c.addLine(line);
            }            
        }catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        
        return c;
    }
}
