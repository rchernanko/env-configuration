package com.richard.test;

import java.io.*;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YAMLException;

public class EnvConfig {

    private static final String ENV = System.getProperty("env", "default");

    private Map environments;

    public EnvConfig() {
        init(getEnvironmentFile());
    }

    private void init(File file) {
        try {
            InputStream inputStream = new FileInputStream(file);
            Yaml yaml = new Yaml();
            Map<String, Map<String, String>> myYamlFile = ((Map<String, Map<String, String>>) yaml
                    .load(inputStream));
            environments = myYamlFile.get(ENV);
            if (environments == null) {
                throw new RuntimeException("The environments ["
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

    public Map getProfiles() {
        return environments;
    }

    private File getEnvironmentFile() {
        return new File("configuration/env.yml");
    }

}
