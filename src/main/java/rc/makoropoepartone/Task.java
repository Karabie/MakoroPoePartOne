/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rc.makoropoepartone;

/**
 *
 * @author Makoro ST10461176
 */
public class Task {

    private String taskName;
    private int taskNumber;
    private String description;
    private String devDetail;
    private int duration;
    private String taskID;
    private String status;

    public Task() {
        this.taskName = "";
        this.taskNumber = 0;
        this.description = "";
        this.devDetail = "";
        this.duration = 0;
        this.taskID = "";
        this.status = "";
    }

    //setters for private variables
    void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    void setDescription(String description) {
        this.description = description;
    }

    void setDevDetail(String devDetail) {
        this.devDetail = devDetail;
    }

    void setDuration(int duration) {
        this.duration = duration;
    }

    void setStatus(String status) {
        this.status = status;
    }

    //check the characters if they meet the requirements
    public boolean checkTaskDecription() {
        if (this.description.length() <= 50) {
            return true;
        }
        return false;
    }
    
    //creation of task ID
    public String createTaskID() {
        String firsttwo = this.taskName.substring(0,2);      
        String lastThree = this.devDetail.substring(this.devDetail.length() - 3);
        this.taskID = firsttwo.toUpperCase()+ ":" + taskNumber + ":" + lastThree.toUpperCase();
        return taskID;
    }

    //Print out entire task details
    public String printTaskDetails() {
        return "Task Name: " + this.taskName + '\n'
                + "Task Number: " + this.taskNumber + '\n'
                + "Task Description: " + this.description + '\n'
                + "Developer Details: " + this.devDetail + '\n'
                + "Task Duration: " + this.duration + "hrs" + '\n'
                + "Task ID: " + this.taskID + '\n'
                + "Task Status: " + status;
    }

    //return duration of task
    int returnTotalHours() {
        return this.duration;
    }
}
