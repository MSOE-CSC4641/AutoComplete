# AutoComplete Exercise
In this exercise you are going to identify several improvements to make to this implementation to make it faster and more useful.

The code will run from IntelliJ (or your IDE of choice) and requires at least Java 17 and JavaFX 17

## Configuring IntelliJ
- Download [Java 21 from Oracle](https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.msi) and run the installer
- Download [JavaFX 21 from Gluon](https://download2.gluonhq.com/openjfx/21.0.2/openjfx-21.0.2_windows-x64_bin-sdk.zip) and unzip the archive into your **ProgramFiles/Java/** folder.
- In IntelliJ, go to File->Project Structure->Global Libraries and click the '+' above the middle column
- Select Java from the dropdown menu, then navigate to Program Files/Java/YOUR JAVAFX FOLDER/lib and select it
- Name the new library javafx (optional)
- Still in Project Structure, select Modules from the left side, then Dependencies from the right side
- Click the '+' in the right column, select Java, and select javafx from the list that appears
  - if a list does not appear, select New Library and navigate to your JavaFX lib folder as described above and select it
- Click OK
- In the Run Configurations dropdown menu at the top of your IntelliJ window, select Edit Configurations
- Click on Edit Configuration Templates near the bottom, then select Application
- Click on Modify Options and ensure Add VM Options is selected
- In the VM Options field, add the following <pre>--module-path PATH/TO/javafx-sdk-21.0.1/lib --add-modules=javafx.controls,javafx.fxml</pre> replacing PATH/TO with the path to your javafx folder
- Click OK twice.

If you are using an IDE other than IntelliJ...good luck!

## The Exercise
The goal of the exercise is to identify techniques to improve this implementation of autocorrect with the following criteria in mind:
- Can it be made to run faster?
  - Discuss using time complexity and describe what changes you would make to improve the overall performance
- Can it be smarter in what it recommends?
  - Rather than dump all possibilities to the user, can the system be made to suggest more appropriate completions?
  - What would be needed to make this happen? Briefly describe the workflow required to do this. Do not worry about actual implementation, just explain what would need to happen.
- What additional functionality would need to be added to turn this into an Auto-Correct system rather than Auto-Complete? (i.e. correcting mis-spelled or mis-typed words)

## Submission
Write up your solution into a (very) brief summary, answering each question separately. Submit that file as a PDF in Canvas
