/**
 *
 */
package com.fulln.entity.pro;

import com.fulln.entity.BaseModel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


/**
 * @author xiaqi 2017-6-12 下午03:07:15
 * @version 1.0 PlayTaskBasic.java
 */
public class PlayTaskBasicVO extends BaseModel implements Serializable {

    private static final long serialVersionUID = 5765501919089728235L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;
    private String devCode;
    private String devType;
    private Integer groupId;
    private Integer taskType;
    private Integer taskStatus;
    private Integer taskTimes;
    private String taskContent;
    private Long taskExpireDate;
    private String taskPercent;
    private String custNo;
    private String taskRemarks;
    private String deviceTypeName;
    private String programName;
    private String registrationId;


    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getTaskRemarks() {
        return taskRemarks;
    }

    public void setTaskRemarks(String taskRemarks) {
        this.taskRemarks = taskRemarks;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getDevCode() {
        return devCode;
    }

    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }

    public String getDevType() {
        return devType;
    }

    public void setDevType(String devType) {
        this.devType = devType;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Integer getTaskTimes() {
        return taskTimes;
    }

    public void setTaskTimes(Integer taskTimes) {
        this.taskTimes = taskTimes;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public Long getTaskExpireDate() {
        return taskExpireDate;
    }

    public void setTaskExpireDate(Long taskExpireDate) {
        this.taskExpireDate = taskExpireDate;
    }

    public String getTaskPercent() {
        return taskPercent;
    }

    public void setTaskPercent(String taskPercent) {
        this.taskPercent = taskPercent;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

}
