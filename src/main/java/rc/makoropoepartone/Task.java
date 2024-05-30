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
    
    //setters for private variables
    void setTaskName(String taskName){
        this.taskName = taskName;
    }
    void setTaskNumber(int taskNumber){
        this.taskNumber = taskNumber;
    }
    void setDescription(String description){
        this.description = description;
    }
    void setDevDetail(String devDetail){
        this.devDetail = devDetail;
    }
    void setDuration(int duration){
        this.duration = duration;
    }
    void setStatus(String status){
        this.status = status;
    }
    
    
    public boolean checkTaskDecription(){
        if(this.description.length()<=50){
            return true;
        }return false;
    }
    public String createTaskID(){
        char one, two;
        String lastThree = taskName.substring(taskName.length()-3);
        one = this.taskName.charAt(0);
        two = this.taskName.charAt(1);
        this.taskID = one+two+":"+taskID+":"+lastThree;
        return taskID;
    }
    public String printTaskDetails(){
        return "Task Name: " + this.taskName +
                "Task Number: " + this.taskNumber + 
                "Task Description: " + this.description + 
                "Developer Details: " + this.devDetail + 
                "Task Duration: " + this.duration + "hrs" + 
                "Task ID: " + this.taskID + 
                "Task Status: " + status;
    }
    int returnTotalHours(){
        return this.duration;
    }
}
