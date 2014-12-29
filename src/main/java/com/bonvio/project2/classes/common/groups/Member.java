package com.bonvio.project2.classes.common.groups;

import java.util.Date;

/**
 * Created by Ivan on 19.12.2014.
 */
public class Member {

    private int id;
    private int userId;
    private int groupId;
    private int userRightsId;
    private int senderId;
    private Date sendDate;
    private Date acceptDate;
    private int accepted;

    private String groupName;
    private String userFirstName;
    private String userSurname;
    private String userPatronymic;


    public Member() {
    }

    public Member(int id, int userId, int groupId, int userRightsId, int senderId, Date sendDate, Date acceptDate, int accepted, String groupName, String profileName, String profileSurname, String profilePatronymic) {
        this.id = id;
        this.userId = userId;
        this.groupId = groupId;
        this.userRightsId = userRightsId;
        this.senderId = senderId;
        this.sendDate = sendDate;
        this.acceptDate = acceptDate;
        this.accepted = accepted;
        this.groupName = groupName;
        this.userFirstName = profileName;
        this.userSurname = profileSurname;
        this.userPatronymic = profilePatronymic;
    }

    public Member(int id, int userId, int groupId, int userRightsId, int senderId, Date sendDate, Date acceptDate, int accepted) {
        this.id = id;
        this.userId = userId;
        this.groupId = groupId;
        this.userRightsId = userRightsId;
        this.senderId = senderId;
        this.sendDate = sendDate;
        this.acceptDate = acceptDate;
        this.accepted = accepted;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getUserRightsId() {
        return userRightsId;
    }

    public void setUserRightsId(int userRightsId) {
        this.userRightsId = userRightsId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public int getAccepted() {
        return accepted;
    }

    public void setAccepted(int accepted) {
        this.accepted = accepted;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserPatronymic() {
        return userPatronymic;
    }

    public void setUserPatronymic(String userPatronymic) {
        this.userPatronymic = userPatronymic;
    }
}
