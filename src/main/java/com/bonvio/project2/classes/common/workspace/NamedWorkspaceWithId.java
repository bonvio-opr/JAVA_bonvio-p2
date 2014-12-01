package com.bonvio.project2.classes.common.workspace;

/**
 * Created by Arti on 23.04.2014.
 */
public class NamedWorkspaceWithId {
    private int workspaceId;
    private String workspaceName;

    @Override
    public String toString() {
        return "NamedWorkspaceWithId{" +
                "workspaceId=" + workspaceId +
                ", workspaceName='" + workspaceName + '\'' +
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

    public NamedWorkspaceWithId() {

    }

    public NamedWorkspaceWithId(int workspaceId, String workspaceName) {

        this.workspaceId = workspaceId;
        this.workspaceName = workspaceName;
    }
}
