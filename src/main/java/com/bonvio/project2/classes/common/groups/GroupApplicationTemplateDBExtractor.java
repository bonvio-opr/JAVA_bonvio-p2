package com.bonvio.project2.classes.common.groups;

/**
 * Created by Arti on 08.08.2014.
 */
public class GroupApplicationTemplateDBExtractor {
    private int tId;
    private String tName;
    private int aId;
    private String aName;

    @Override
    public String toString() {
        return "GroupApplicationTemplateDBExtractor{" +
                "tId=" + tId +
                ", tName='" + tName + '\'' +
                ", aId=" + aId +
                ", aName='" + aName + '\'' +
                '}';
    }



    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public GroupApplicationTemplateDBExtractor() {

    }

    public GroupApplicationTemplateDBExtractor(int tId, String tName, int aId, String aName) {

        this.tId = tId;
        this.tName = tName;
        this.aId = aId;
        this.aName = aName;
    }
}
