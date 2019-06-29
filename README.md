# kiwiland
Railroad company.

The ONEBOX's document 'Trains exercise' mentions three tasks: 
 1. Compute the distance along a certain route
 2. The number of different routes between two towns
 3. The shortest route between two towns

Some test had been created for each task. The name of the test class is RailroadManagerTest

For example for the first task (ONEBOX propose some inputs and outputs) the main test to execute are:
getDistanceRoute_example1_return9, getDistanceRoute_example2_return5, getDistanceRoute_example3_return13, getDistanceRoute_example4_return22,getDistanceRoute_example5_noSuchRoute

For the second task the main test are:
getTotalRoutesFromTwoTowns_fromAtoB_return4, getTotalRoutesFromTwoTowns_fromBtoA_return0, getTotalRoutesFromTwoTowns_random_returnValue

Finally, for the third task, the main test are:
getMinDistanceFromTwoTowns_fromAtoB_returnAB, getMinDistanceFromTwoTowns_fromBtoA_noSuchRoute, getMinDistanceFromTwoTowns_fromAtoC_returnABC

# Help
This project runs gradle instead of maven. Once you have configured gradle (you have to go to the project root and launch the gradle file '.\gradlew') 

```console
C:\Users\alexb\git\repository\trains-exercise>.\gradlew

> Task :help

Welcome to Gradle 5.4.

To run a build, run gradlew <task> ...

To see a list of available tasks, run gradlew tasks

To see a list of command-line options, run gradlew --help

To see more detail about a task, run gradlew help --task <task>

For troubleshooting, visit https://help.gradle.org

BUILD SUCCESSFUL in 4s
```


The commands are basically the same as maven, for example build (Assembles and tests this project)

```console
C:\Users\alexb\git\repository\trains-exercise>gradlew build
```

To execute an specific Test of one specific class: 

```console
C:\Users\alexb\git\repository\trains-exercise>gradlew test --tests "RailroadManagerTest.getTotalRoutesFromTwoTowns_random_returnValue"
```

To see javadoc, execute:

```console
gradlew javadoc
```
Now the documentation is created at /build/docs/javadoc and the main page is index.html

