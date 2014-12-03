package com.bonvio.project2.classes.common.workspace.extractors;

/**
 * Created by Arti on 07.07.2014.
 */
public class WorkspaceWithApplicationsDBExtractor {
    private int workspaceId;
    private String workspaceName;
    private String unitName;
    private String unitCode;
    private String unitImgPath;

    @Override
    public String toString() {
        return "WorkspaceWithApplicationsDBExtractor{" +
                "workspaceId=" + workspaceId +
                ", workspaceName='" + workspaceName + '\'' +
                ", unitName='" + unitName + '\'' +
                ", unitCode='" + unitCode + '\'' +
                ", unitImgPath='" + unitImgPath + '\'' +
                '}';
    }

    public int getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(int workspaceId) {
        this.workspaceId = workspaceId;
    }

    public String getWorkspaceName() {
        return workspaceName;
    }

    public void setWorkspaceName(String workspaceName) {
        this.workspaceName = workspaceName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitImgPath() {
        return unitImgPath;
    }

    public void setUnitImgPath(String unitImgPath) {
        this.unitImgPath = unitImgPath;
    }

    public WorkspaceWithApplicationsDBExtractor() {

    }

    public WorkspaceWithApplicationsDBExtractor(int workspaceId, String workspaceName, String unitName, String unitCode, String unitImgPath) {

        this.workspaceId = workspaceId;
        this.workspaceName = workspaceName;
        this.unitName = unitName;
        this.unitCode = unitCode;
        this.unitImgPath = unitImgPath;
    }
}
