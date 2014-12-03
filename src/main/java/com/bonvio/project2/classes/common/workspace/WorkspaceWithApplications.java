package com.bonvio.project2.classes.common.workspace;

import java.util.ArrayList;

/**
 * Created by Arti on 23.05.2014.
 */
public class WorkspaceWithApplications {
    private int wsId;
    private String wsName;
    private ArrayList<Application> wsUnits;

    @Override
    public String toString() {
        return "WorkspaceWithApplications{" +
                "wsId=" + wsId +
                ", wsName='" + wsName + '\'' +
                ", wsUnits=" + wsUnits +
                '}';
    }

    public int getWsId() {
        return wsId;
    }

    public void setWsId(int wsId) {
        this.wsId = wsId;
    }

    public String getWsName() {
        return wsName;
    }

    public void setWsName(String wsName) {
        this.wsName = wsName;
    }

    public ArrayList<Application> getWsUnits() {
        return wsUnits;
    }

    public void setWsUnits(ArrayList<Application> wsUnits) {
        this.wsUnits = wsUnits;
    }

    public WorkspaceWithApplications() {

    }

    public WorkspaceWithApplications(int wsId, String wsName, ArrayList<Application> wsUnits) {

        this.wsId = wsId;
        this.wsName = wsName;
        this.wsUnits = wsUnits;
    }
}
