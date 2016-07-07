#Introduction

This is me messing around with YAML. *This is a WIP.*

###What I want to do

- Understand how to pass in environment arguments on the command line with Maven e.g. mvn clean install -Denv=richard = DONE
- Understand how to then use those arguments to run the tests in different browsers 
        e.g. -Denv=richard-chrome would run the tests in chrome = DONE, USING YAML

###Progress

(Initial comments)

- Using the maven surefire plugin, I can now pass in arguments via the command line. these will pick up relevant profiles in an env.yml file i have created.

(Updated comments)

- NOTE that I don't actually need to do this...with Maven, I can simply do a -Dhello=richard or a -Dcity-london and it can then be picked up when doing a System.getProperty("city") etc

###Todo

- Once above is done, understand how to intertwine this and also args4j (to then do something different e.g. load a database) = TODO
