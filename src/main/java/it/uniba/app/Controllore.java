package it.uniba.app;

import java.util.regex.Pattern;

public class Controllore {
    public static final String REGEX = "[a-z][a-z][a-z][a-z][a-z]";
    
    public static boolean controlloParola(String parolaRic) throws IllegalArgumentException {
        if(Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE).matcher(parolaRic).matches() == false)
        {
            throw new IllegalArgumentException();
        }
        
        else
        {
            return true;
        }
    }
}
