package com.recipe.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Jonathan Fernandez <jonathan.fvargas@gmail.com>
 */
public class ConfigProperties {

    private static Properties prop = new Properties();

    static {
        
        InputStream input = null;

        try {
            
            String filename = "dev.properties";
            input = ConfigProperties.class.getClassLoader().getResourceAsStream(filename);

            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
            }

            //load a properties file from class path, inside static method
            prop.load(input);

        } catch (IOException ex) {
            //TODO: Framework de loggin, log4j, slf4j, logback
            //TODO: Specific exceptions
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 
     * @param property
     * @return 
     */
    public static String getProperty(PropertyId property) {
        return prop.getProperty(property.name());
    }

    public static void main (String arsg []){
        System.out.println( "PROPIEDAD" + getProperty(PropertyId.RECIPE_SPARK_PORT)) ;
    }
    
}
