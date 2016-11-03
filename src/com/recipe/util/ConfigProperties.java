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
     * Get parameter value from properties
     * @param propertyId 
     * @return String value based on the PropertyID otherwise null
     */
    public static String getProperty(PropertyId propertyId) {
        return prop.getProperty(propertyId.name());
    }
}