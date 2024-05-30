/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package rc.makoropoepartone;

import javax.swing.JOptionPane;

/**
 *
 * @author Makoro ST10461176
 */
public class MakoroPoePartOne {

    //Create new object from the login class
    static Login user = new Login();
    static Task[] task;
    static int numtask;
    //Declare variables for the main class
    static String full_name, last_name, username, password;

    public static void main(String[] args) {
        //Call methods to create user and login user
        registerUser();
        loginUser();
        createTask();
        displayTasks();
    }

    static void createUser() {
        //Create a new Login Object and use the overloaded constructor 
        full_name = JOptionPane.showInputDialog("Please enter your full name");
        last_name = JOptionPane.showInputDialog("Please enter your last name");
        username = JOptionPane.showInputDialog("Please set username, Must contain underscore and less than 5 characters.");
        password = JOptionPane.showInputDialog("Please set password, Must be more than 8 characters, digits and special character");
        user = new Login(full_name, last_name, username, password, false);
    }

    static void registerUser() {
        boolean registrationTriger = true;
        do {
            boolean usernameCheck = false;
            boolean passwordCheck = false;
            //Call the create user method for registration
            createUser();
            /*check if password complexity meets requirement 
            update the local variable
             */
            if (user.checkUserName()) {
                usernameCheck = true;
            } else {
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted," + '\n'
                        + "please ensure that your username contains an underscore" + '\n'
                        + "and is no more than 5 characters in length");
            }
            /*check if password complexity meets requirement 
            update the local variable
             */
            if (user.checkPasswordComplexity()) {
                passwordCheck = true;
            } else {
                JOptionPane.showMessageDialog(null, "Password is not correctly formatted," + '\n'
                        + "please ensure that the password contains atleast 8 characters," + '\n'
                        + "a capital letter, a number and a special character.");
            }
            if (usernameCheck && passwordCheck) {
                /*username and password are both valid then 
                the user may be registered and communication 
                can be sent to the user
                 */
                JOptionPane.showMessageDialog(null, "Username Succesfully Captured");
                JOptionPane.showMessageDialog(null, "Password Succesfully Captured");
                JOptionPane.showMessageDialog(null, user.registerUser());
                registrationTriger = false;
            } else {
                JOptionPane.showMessageDialog(null, user.registerUser());
            }
        } while (registrationTriger);

    }

    //method to Login the user
    static void loginUser() {
        //Declare local variables for temporary storage for operations
        boolean loginTriger = true;
        String fullname = user.getFullName();
        String lastname = user.getLastName();
        do {
            //Temporary Storae for username and password for logging in
            String username = JOptionPane.showInputDialog("Enter your login username");
            String password = JOptionPane.showInputDialog("Enter your login password");
            if (user.loginUser(username, password)) {//if the username and password entered are correct then the condition is met for user to be logged in.
                JOptionPane.showMessageDialog(null, user.returnLoginStatus());
                JOptionPane.showMessageDialog(null, "Welcome to EasyKhanban " + fullname + " , " + lastname + " it is great to see you again.");
                loginTriger = false;
            } else {
                JOptionPane.showMessageDialog(null, user.returnLoginStatus());
                JOptionPane.showMessageDialog(null, "Username or password incorrect please try again");
            }
        } while (loginTriger);
    }

    static void createTask() {

        int option = Integer.parseInt(JOptionPane.showInputDialog("Welcome to the Main Menu" + '\n'
                + "Press 1 to add tasks" + '\n'
                + "Press 2 to show report " + '\n'
                + "Press 3 to Quit"));

        while (option != 3) {

            numtask = Integer.parseInt(JOptionPane.showInputDialog("Please enter number of tasks"));
            task = new Task[numtask];
            for (int c = 0; c < numtask; c++) {

                boolean descriptionTrigger = false;
                do {
                    String taskName = JOptionPane.showInputDialog("Enter name of task");
                    int taskNumber = c;
                    String description = JOptionPane.showInputDialog("Enter Description of no more than 50 characters");
                    String devDetails = JOptionPane.showInputDialog("Developer Name and Surname");
                    int duration = Integer.parseInt(JOptionPane.showInputDialog("Input Duration"));
                    int status = Integer.parseInt(JOptionPane.showInputDialog("Select from : 1 = To Do , 2 = Done , 3 = Doing"));

                    task[c] = new Task();
                    task[c].setTaskName(taskName);
                    task[c].setTaskNumber(taskNumber);
                    task[c].setDescription(description);
                    task[c].setDevDetail(devDetails);
                    task[c].setDuration(duration);
                    if (status == 1) {
                        task[c].setStatus("To Do");
                    } else if (status == 2) {
                        task[c].setStatus("Done");
                    } else {
                        task[c].setStatus("Doing");
                    }
                    if (task[c].checkTaskDecription()) {
                        descriptionTrigger = true;
                        JOptionPane.showMessageDialog(null, "Task succefully captured");
                        task[c].createTaskID();
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                    }
                } while (descriptionTrigger == false);

            }
            option = Integer.parseInt(JOptionPane.showInputDialog("Welcome to the Main Menu" + '\n'
                + "Press 1 to add tasks" + '\n'
                + "Press 2 to show report " + '\n'
                + "Press 3 to Quit"));

        }

    }

    static void displayTasks() {
        for (int i = 0; i < numtask; i++) {
            JOptionPane.showMessageDialog(null, task[i].printTaskDetails());
        }

    }

}
