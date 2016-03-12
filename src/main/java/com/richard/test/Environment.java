package com.richard.test;

import java.io.*;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YAMLException;

public class Environment {

    private static final String ENV = System.getProperty("env", "default");

    private Map<String, Object> environment;

    public Environment() {
        init(getEnvironmentFile());
    }

    private void init(File file) {
        try {
            InputStream inputStream = new FileInputStream(file);
            Yaml yaml = new Yaml();
            Map<String, Map<String, Object>> myYamlFile = ((Map<String, Map<String, Object>>) yaml
                    .load(inputStream));
            environment = (Map<String, Object>) myYamlFile.get(ENV);
            if (environment == null) {
                throw new RuntimeException("The environment ["
                        + ENV
                        + "] does not exist in the file ["
                        + file.getAbsolutePath() + "].");
            }
        } catch (YAMLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private File getEnvironmentFile() {
        return new File("configuration/env.yml");
    }

}
