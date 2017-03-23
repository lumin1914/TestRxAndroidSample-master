package spikeking.github.com.testrxandroid.network.module;

import java.io.Serializable;

/**
 * Created by lumin on 16-8-22.
 */
public class UserEduInfo implements Serializable {
    private String eduId;
    private String userId;
    private String startTime;
    private String endTime;
    private String school;
    private String academy;
    private String major;
    private String degree;
    private String description;

    public String getEduId() {
        return eduId;
    }
    public void setEduId(String eduId) {
        this.eduId = eduId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFinishEdit(){
        if(startTime != null && endTime!= null && school!= null && academy!= null && degree!= null ){
            return true;
        }else {
            return false;
        }
    }


}
