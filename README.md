# GymPro Vision
It's an interactive Java Based GUI application which offers various features for members, admin e.t.c that are necassary for properly managing a gym.
## Built With
- Java Swing Library.
- SQL for managing Database.
- MySql-Connector (external library for Java).
- Xampp (MariaDB) for managing SQL server.
## To use the System
1. **Download and Import the Project in Eclipse (or other Java IDE):**
   - Download the project folder.
   - Import the folder into Eclipse using the IDE's import feature.

2. **Add `mysql-connector-x.x.x.jar` File to Java Build Path:**
   - Navigate to `Project` -> `Properties` -> `Java Build Path`.
   - Under `Libraries` or `ClassPath`, add the `mysql-connector-x.x.x.jar` file.

3. **Resolve Swing or Similar Errors:**
   - If there are errors related to Swing or similar libraries, add the required Java SE version in the Module Path in Java Build Path. If this deosn't fix it, Google the problem and you will most certainly find the fix.

4. **Set Up XAMPP Control Panel:**
   - Install and set up XAMPP on your system.
   - Start the XAMPP control panel.

5. **Import the Database:**
   - Open the XAMPP control panel.
   - Go to the "Import" tab.
   - Choose the `gym.sql` file located in the `/database` directory of the project.

6. **Run the Application:**
   - In Eclipse, navigate to `/src/login/Login.java`.
   - Run the application.

7. **Login Credentials:**
   - Use the login credentials found in the `UserLogin` database table when prompted.

8. **Enjoy Using the GymPro Vision System:**
   - Explore the features and functionalities of the system.
