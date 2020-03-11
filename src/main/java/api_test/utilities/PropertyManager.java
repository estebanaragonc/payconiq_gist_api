package api_test.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {

	private static Properties properties;
    private static final String PROPERTIES_FILE_PATH = "/gist.properties";
    
    static {
    	properties = new Properties();
        System.out.println ("PROPERTIES_FILE_PATH : " + PROPERTIES_FILE_PATH);
        System.out.println(PropertyManager.class.getResource("/").getPath());
        InputStream is = PropertyManager.class.getResourceAsStream(PROPERTIES_FILE_PATH);
        System.out.println( "status" + is);
        
        try {
            properties.load(is);
        } catch (IOException e) { 
            throw new RuntimeException("File path does not exit" + PROPERTIES_FILE_PATH, e);
        }
        
    }
   
    //to obtain property absed in name
    public static String get (String propertyName) {
        return properties.getProperty(propertyName);
    }
    
}
