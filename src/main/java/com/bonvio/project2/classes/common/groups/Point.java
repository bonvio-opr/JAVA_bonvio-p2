package com.bonvio.project2.classes.common.groups;

/**
 * Created by Ivan on 19.12.2014.
 */
public class Point {

    private int id;
    private String name;
    private int groupId;
    private String description;

    public Point() {
    }

    public Point(int id, String name, int groupId, String description) {
        this.id = id;
        this.name = name;
        this.groupId = groupId;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
