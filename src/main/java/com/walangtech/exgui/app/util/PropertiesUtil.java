package com.walangtech.exgui.app.util;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class PropertiesUtil {
    private Properties properties;

    public PropertiesUtil(String aPath){

        try {
            properties = new Properties();
            InputStream stream = this.getClass().getResourceAsStream(aPath);
            loadProperties(stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void loadProperties(InputStream aInputStream) throws IOException {
        properties.load(aInputStream);
    }

    public Set<Object> getAllKeys(){
        Set<Object> keys = properties.keySet();
        return keys;
    }

    public String getPropertyValue(String aKey){
        return properties.getProperty(aKey);
    }

}