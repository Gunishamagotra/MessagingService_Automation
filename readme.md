## BDD-Cucumber Framework
The repo consists of Messaging service API automated tests using Rest Assured


## Instructions to run the tests
1. Java and maven should be installed on your machine
2. Clone the repo
2. Navigate to the repository in a terminal and run the following commands, in order: mvn clean install
3. Create 2 users and Pass the UserID 1,User ID2 and Message in the smokeTest.feature file (line no: 11) as shown in the screenshot below:
![img.png](img.png)
4. Run the command to execute test: mvn -Dtest=runner test
5. Open the html report (target/cucumber.html) in browser to verify the results

![img_1.png](img_1.png)

## Observations/Issues identified
1. Post Message service - request Body accepts User ID and message value as blank. It should be mandatory field
![Pasted Graphic.png](..%2F..%2FLibrary%2FGroup%20Containers%2Fgroup.com.apple.notes%2FAccounts%2F759FC06E-B57E-4A95-B35C-6AD7485A105B%2FMedia%2FAA2D8C19-501F-4186-AC05-D2B00C543BF4%2F1_67162904-31E8-459C-BBDB-305F137296DF%2FPasted%20Graphic.png)
![Pasted Graphic 1.png](..%2F..%2FLibrary%2FGroup%20Containers%2Fgroup.com.apple.notes%2FAccounts%2F759FC06E-B57E-4A95-B35C-6AD7485A105B%2FMedia%2F44B7EA4B-8D15-4F91-92F4-352E71197765%2F1_2BD9A15D-7265-4EF4-91B0-58BDB1B262B6%2FPasted%20Graphic%201.png)
2. Response code 500 is returned when wrong request body is passed. Expected value is 400 Bad request
![Pasted Graphic 2.png](..%2F..%2FLibrary%2FGroup%20Containers%2Fgroup.com.apple.notes%2FAccounts%2F759FC06E-B57E-4A95-B35C-6AD7485A105B%2FMedia%2F4DA35CF5-9488-48B1-BDA1-205D1CCA491A%2F1_683EDAE4-4263-4DAD-AD35-2ECA58C6826C%2FPasted%20Graphic%202.png)
3. 