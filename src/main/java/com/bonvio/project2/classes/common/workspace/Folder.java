package com.bonvio.project2.classes.common.workspace;

/**
 * Created by Ivan on 01.12.2014.
 */
public class Folder {

    public Folder (){

    }

    public Folder(long id, long ownerId, long parentId, String name, String type) {
        this.id = id;
        this.ownerId = ownerId;
        this.parentId = parentId;
        this.name = name;
        this.type = type;
    }

    private long id;
    private long ownerId;
    private long parentId;
    private String name;
    private String type;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
