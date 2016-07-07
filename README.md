#Introduction

This is me messing around with YAML. *This is a WIP.*

###What I want to do

- Understand how to pass in environment arguments on the command line with Maven e.g. mvn clean install -Denv=richard
- Understand how to then use those arguments to run the tests in different browsers 
        e.g. -Denv=richard-chrome would run the tests in chrome
- Once above is done, understand how to intertwine this and also args4j (to then do something different e.g. load a database)

###Progress

- Using the maven surefire plugin, i can now pass in arguments via the command line. these will pick up relevant profiles in an env.yml file i have created