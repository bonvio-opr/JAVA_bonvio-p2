package com.bonvio.project2.classes.common.groups;

/**
 * Created by Arti on 07.08.2014.
 */
public class Group {
    private int groupId;
    private String groupName;
    private String groupShortName;
    private String groupInfo;
    private String groupPicturePath;

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", groupShortName='" + groupShortName + '\'' +
                ", groupInfo='" + groupInfo + '\'' +
                ", groupPicturePath='" + groupPicturePath + '\'' +
                '}';
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupShortName() {
        return groupShortName;
    }

    public void setGroupShortName(String groupShortName) {
        this.groupShortName = groupShortName;
    }

    public String getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(String groupInfo) {
        this.groupInfo = groupInfo;
    }

    public String getGroupPicturePath() {
        return groupPicturePath;
    }

    public void setGroupPicturePath(String groupPicturePath) {
        this.groupPicturePath = groupPicturePath;
    }

    public Group() {

    }

    public Group(int groupId, String groupName, String groupShortName, String groupInfo, String groupPicturePath) {

        this.groupId = groupId;
        this.groupName = groupName;
        this.groupShortName = groupShortName;
        this.groupInfo = groupInfo;
        this.groupPicturePath = groupPicturePath;
    }
}
