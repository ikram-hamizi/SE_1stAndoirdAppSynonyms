Software Engineering - CMSC 355 - Spring2018 - Virginia Commonwealth University

AndoirdApp-Synonyms
*******************


App: consists of three screens: 1) a Welcome screen and 2) an EnterValues screen, and 3) a Results screen.

When starting the app, the user is presented with the Welcome screen, containing a TextView widget that displays the message ”Find synonym/antonym”, a Plain Text field where the user can enter a word and two buttons labeled ”Enter Values” and “Find Synonym/Antonym”. When the ”Enter Values” button is clicked, the EnterValues screen is displayed.

The EnterValues screen has two Plain Text fields with appropriate TextView fields as labels, and a ”Submit” Button. The text fields will allow you to enter a synonym/antonym pair, and the ”Submit” Button enters the pair into the SQLite Database, and returns you to the Welcome screen.

On the Welcome screen, if the user enters a word into the Plain Text field and clicks the button “Find Synonym/Antonym”, the Results screen will appear. If the word matches a synonym/antonym pair, the synonym/antonym is returned. If not, the message “Word not found” is displayed.

(As specified in: https://github.com/CMSC-355-Spring-18/MyApplication)
