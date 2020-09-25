package org.acme;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.microprofile.config.spi.ConfigSource;

/*
    source : XML file,database, REST app , spring-cloud-config server ,....
*/

public class InMemoryConfigSource implements ConfigSource {

    private static Map<String, String> properties = new HashMap<>();

    static {
        properties.put("greeting.message", "Ola world");
    }

    @Override
    public Map<String, String> getProperties() {
        return properties;
    }

    @Override
    public String getValue(String propertyName) {
        return properties.get(propertyName);
    }

    @Override
    public String getName() {
        return "InMemoryConfigSource";
    }

    @Override
    public int getOrdinal() {
        return 500;
    }

}