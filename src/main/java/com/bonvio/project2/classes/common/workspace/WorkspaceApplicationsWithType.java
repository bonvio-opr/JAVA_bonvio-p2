package com.bonvio.project2.classes.common.workspace;

/**
 * Created by Ivan on 11.11.2014.
 */
public class WorkspaceApplicationsWithType {
    private int wsId;
    private String wsName;
    private String wsType;

    public WorkspaceApplicationsWithType(int wsid, String wsname, String wstype) {
        wsId = wsid;
        wsName = wsname;
        wsType = wstype;
    }

    @Override
    public String toString() {
        return "WorkspaceApplicationsWithType{" +
                "wsId=" + wsId +
                ", wsName='" + wsName + '\'' +
                ", wsType='" + wsType + '\'' +
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

    public String getWsType() {
        return wsType;
    }

    public void setWsType(String wsType) {
        this.wsType = wsType;
    }
}
