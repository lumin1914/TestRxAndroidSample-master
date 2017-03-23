package spikeking.github.com.testrxandroid.network.module;

import java.io.Serializable;

/**
 * Created by lumin on 16-8-22.
 */
public class UserCareerInfo implements Serializable {
    private String careerId;
    private String userId;
    private String startTime;
    private String endTime;
    private String org;
    private UserCareerRoleEnum role;
    private String title;
    private String description;

    public String getCareerId() {
        return careerId;
    }

    public void setCareerId(String careerId) {
        this.careerId = careerId;
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

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public UserCareerRoleEnum getRole() {
        return role;
    }

    public void setRole(UserCareerRoleEnum role) {
        this.role = role;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
