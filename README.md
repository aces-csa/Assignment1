Programming with Java and JDBC Primary Assessment
Evaluation Criteria
• Does the Java code provide an accurate and complete solution for the stated requirements?
• Are sound object-oriented principles used in the Java code?
• Are exceptions used to manage errors that can occur in the code?
• Use of JDBC, Collections and Streams API?
• Java Code best practices followed?
Assessment Scenario
MyDocs is an online document sharing application. The user’s needs to login with their username and
password to use the services of the application. MyDocs team has approached you to create the login
module for the application.
The users must login through a login form (create main app which will take login details through
standard I/O). If login is success then print a greeting message “Hello <user>” where <user> is the
username entered by the user. The user name/password should exist in the database for
successfully login into the application. Use PostgreSQL database for storing user credentials. Data
layer should use JDBC specs.
If the username/password is incorrect the user should display to error message with the error
message “username (or) password is incorrect”.
Once user is logged in and have role of admin then user should access the list of users and able to
display sorted list on console.
Tasks:
Define the Java classes that are required to implement the functionality that is described
above. Be sure to use sound object-oriented principles in your Java code. Follow the layered
architecture concepts in your code.
Use Maven build tool and Intellij IDE. Print the exceptions in standard console.
