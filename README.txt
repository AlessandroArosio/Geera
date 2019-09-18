Using "Geera" is straight forward. After running the main method in the IDE (or java -jar path/file.jar),
a help menu will appear with instructions from 1 to 8. To view the help menu again press 9.

The design of this (toy) application is fairly common in the business world (for example:
- Data Access Object layer
- Data Transfer Object layer
- Service Layer

Also with an important addition (in my opinion) about Aspect logging (which uses the Proxy Design pattern).
Lastly, support for internationalisation - i18n.

One extra note about the design: the package structure are divided according to the "role" of each class.
Some of the SOLID programming principles were applied, such as Single resonsibility principle,
Interface segregation principle and Dependency inversion principle.


All the 3rd party software are listed in the gradle.settings