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
    static final String ERRORTASK = "No Task";
    //Declare variables for the main class
    static String full_name, last_name, username, password;

    public static void main(String[] args) {
        //Call methods to run program
        registerUser();
        loginUser();
        runTask();
        displayTotalTasks();
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

    //method to create Tasks 
    static void runTask() {

        //ask user Input
        int option = menu();

        while (option != 7) { //do while the quit option is not invoked
            switch (option) {
                case 2 -> //Coming soon feature
                    showReport(); // Display The Complete Report
                case 1 -> {
                    //carry out to create tasks
                    numtask = Integer.parseInt(JOptionPane.showInputDialog("Please enter number of tasks"));
                    task = new Task[numtask];//resize the array
                    for (int c = 0; c < numtask; c++) {

                        boolean descriptionTrigger = true;
                        do {
                            String taskName = JOptionPane.showInputDialog("Enter name of task" + (c+1));
                            int taskNumber = (c+1);
                            String description = JOptionPane.showInputDialog("Enter Task " + (c+1)+" Description of no more than 50 characters");
                            String devDetails = JOptionPane.showInputDialog("Enter Developer "+ (c+1)+" Name and Surname");
                            int duration = Integer.parseInt(JOptionPane.showInputDialog("Input Duration for Task " + (c+1)));
                            int status = Integer.parseInt(JOptionPane.showInputDialog("Select from : 1 = To Do , 2 = Done , 3 = Doing"));

                            task[c] = new Task();//create a task at the specified array index
                            task[c].setTaskName(taskName);
                            task[c].setTaskNumber(taskNumber);
                            task[c].setDescription(description);
                            task[c].setDevDetail(devDetails);
                            task[c].setDuration(duration);
                            switch (status) {
                                case 1 ->
                                    task[c].setStatus("To Do");
                                case 2 ->
                                    task[c].setStatus("Done");
                                default ->
                                    task[c].setStatus("Doing");
                            }
                            if (task[c].checkTaskDecription()) {
                                descriptionTrigger = false;
                                JOptionPane.showMessageDialog(null, "Task succefully captured");
                                task[c].createTaskID();
                            } else {
                                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                            }
                        } while (descriptionTrigger);

                    }
                }
                case 3 -> //Dislay Status Done
                    returnStatus();
                case 4 -> //Display Longest Duration
                    JOptionPane.showMessageDialog(null, returnLongDuration());
                case 5 -> {
                    //Search for task
                    String search = JOptionPane.showInputDialog("Please enetr task name to search");
                    JOptionPane.showMessageDialog(null, searchTask(search));
                }
                case 6 -> {
                    //Delete Task
                    String taskDelete = JOptionPane.showInputDialog("Enter Task Name to delete");
                    deleteTask(task, taskDelete);
                }
                default -> {
                }
            }
            option = menu();

        }

    }
    
    static int menu(){
        return Integer.parseInt(JOptionPane.showInputDialog("Welcome to the Main Menu" + '\n'
                    + "Press 1 to add tasks" + '\n'
                    + "Press 2 to show report " + '\n'
                    + "Press 3 to show status of Done " + '\n'
                    + "Press 4 to longest duration " + '\n'
                    + "Press 5 to search task " + '\n'
                    + "Press 6 to delete task " + '\n'
                    + "Press 7 to Quit"));
    }

    static void displayTotalTasks() {
        int totalHours = 0;
        if (task!=null) {
            for (Task task1 : task) {
                if (task1 != null) {
                    
                    totalHours += task1.returnTotalHours();
                }
            }
            JOptionPane.showMessageDialog(null, "Total Task hours: " + totalHours + "hrs");

        }else JOptionPane.showMessageDialog(null, ERRORTASK);
    }

    /*Functions to Manipulate the Task Array and Rreturn Values */
    static void returnStatus() {
        if (task!=null) {
            for (Task task1 : task) {
                if (task1 != null) {
                    if (task1.getStatus().equalsIgnoreCase("Done")) {
                        JOptionPane.showMessageDialog(null, "Task Name: " + task1.getTaskName() + '\n' 
                                + "Duration: " + task1.getDuration()+ "hrs");
                    }
                }

            }
        }else JOptionPane.showMessageDialog(null, ERRORTASK);

    }

    static String returnLongDuration() {
        int tempHigh = 0;
        int index = 0;
        if (task!=null) {
            for (int i = 0; i < task.length; i++) {
                if (task[i] != null) {
                    if (task[i].getDuration() > tempHigh) {
                        tempHigh = task[i].getDuration();
                        index = i;
                    }
                }

            }
            return "Developer Name: " + task[index].getDevDetail() + '\n'
                    + "Duration: " + task[index].getDuration() + "hrs";

        } else {
            return ERRORTASK;
        }
    }
    //
    static String searchTask(String taskName) {
        String details = "";
        if (task!=null) {
            for (Task task1 : task) {
                if (task1 != null) {
                    if (task1.getTaskName().equalsIgnoreCase(taskName)) {
                        details += "Task Name: " + task1.getTaskName() + '\n' + "Developer: " + task1.getDevDetail() + '\n' + "Status: " + task1.getStatus();
                    }
                }

            }
        }

        if (details.length()>1) {
            return "Found Task" + '\n' + details;
        }
        return ERRORTASK;
    }
    //delete task method
    static void deleteTask(Task[] array, String taskName) {
        int index = 0;
        int countValid = 0;
        Task[] tmparray = array;
        if (tmparray!=null) {
            for (int i = 0; i < tmparray.length; i++) {
                if (tmparray[i] != null) {
                    if (tmparray[i].getTaskName().equalsIgnoreCase(taskName)) {
                        index += tmparray[i].getTaskNumber();
                        tmparray[i] = null;
                    }else{
                        countValid ++;
                    }
                }

            }
           
            task = tmparray;
        JOptionPane.showMessageDialog(null, "Delete Operation Complete" + '\n'
                + "Task number Deleted: " + index);
        }else {
            JOptionPane.showMessageDialog(null, ERRORTASK);
        }

        
    }
    //Show report method
    static void showReport() {
        if (task!=null) {
            for (int i = 0; i < numtask; i++) {
                if (task[i] != null) {
                    JOptionPane.showMessageDialog(null, task[i].printTaskDetails());
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, ERRORTASK);
        }

    }
}
