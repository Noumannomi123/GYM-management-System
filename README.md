# GymPro Vision
It's an interactive Java Based GUI application which offers various features for members, admin e.t.c that are necassary for properly managing a gym.
Will be made by four members.

## Built With

- Java Swing Library
- SQL
- MySql-Connector (external library for Java)
- Xampp (MariaDB) for managing SQL server.

## To Use the System

1. **Download and Import the Project in Eclipse (or other Java IDE):**
   - Download the project folder.
   - Import the folder into Eclipse using the IDE's import feature.

2. **Add `mysql-connector-x.x.x.jar` File to Java Build Path:**
   - Navigate to `Project` -> `Properties` -> `Java Build Path`.
   - Under `Libraries` or `ClassPath`, add the `mysql-connector-x.x.x.jar` file.

3. **Resolve Swing or Similar Errors:**
   - If there are errors related to Swing or similar libraries, add the required Java SE version in the Module Path in Java Build Path. If this doesn't solve the issue, Google the problem and you will most certainly find the fix.

4. **Set Up XAMPP Control Panel:**
   - Install and set up XAMPP on your system.
   - Start the XAMPP control panel. Turn on Apache Service first, then MySql. Note that while turning the Control panel, turn off the features in reverse order (No idea why but this doesn't mess up the Xampp Control panel). Also, let it run in the background.
   - Create and account with all priveleges and remember the username and password of the account (You will need this in the future).
   
5. **Import the Database:**
   - Open the XAMPP control panel.
   - Go to the "Import" tab.
   - Choose the `gym.sql` file located in the `/database` directory of the project.

6. **Run the Application:**
   - In Eclipse, navigate to `/src/database/Database.java`. Go to line 25, 26. Change the username and password that you used to set-up the Xampp admin account.
   - Run the application through `/src/login/Login.java` file.

7. **Login Credentials:**
   - Use the login credentials found in the `UserLogin` database table when prompted.

8. **Enjoy Using the GymPro Vision System:**
   - Explore the features and functionalities of the system.

## Known Bugs
- Fitness Goals, Plans are set for all members instead of selected member. (Member)
- Adding Fitness Class causes duplicate entry of Primary Key. (Staff)
- Training Sessions is not working 100%. (Staff)
- On removing staff, foreign key constraint key fails. (Admin)
- Registration Manager has no working module. (Registraion Manager)

## Note for Bugs
Some of the bugs are related to the database entries. Others are due to time contraints.

## Screenshots
- **User Login:**

  ![User Login](Screenshots/Screenshot%202024-04-14%20232437.png)
  
- **Member:**
  ![Member](Screenshots/2024-04-14%20(2).png)

- **Staff:**
  ![Staff](Screenshots/2024-04-14%20(12).png)

- **Admin:**
  ![Admin](Screenshots/2024-04-14%20(15).png)
