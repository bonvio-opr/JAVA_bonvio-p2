package com.bonvio.project2.classes.common.groups;

/**
 * Created by Ivan on 19.12.2014.
 */
public class Member {

    private int id;
    private int userId;
    private int groupId;
    private int userRightsId;


    public Member(int id, int userId, int groupId, int userRightsId) {
        this.id = id;
        this.userId = userId;
        this.groupId = groupId;
        this.userRightsId = userRightsId;
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
}
