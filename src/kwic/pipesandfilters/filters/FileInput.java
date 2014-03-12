/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.pipesandfilters.filters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author Petr Kalivoda
 */
public class FileInput extends Input {
    
    public FileInput(File file) throws FileNotFoundException{
        super(new FileReader(file));
    }
    
    
}
