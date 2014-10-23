package com.bonvio.project2.classes.common.groups;

import java.util.List;

/**
 * Created by Arti on 08.08.2014.
 */
public class GroupApplicationsTemplate {
    private String templateName;
    private int templateId;
    private List<TemplateApp> templateApps;

    @Override
    public String toString() {
        return "GroupApplicationsTemplate{" +
                "templateName='" + templateName + '\'' +
                ", templateId=" + templateId +
                ", templateApps=" + templateApps +
                '}';
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    public List<TemplateApp> getTemplateApps() {
        return templateApps;
    }

    public void setTemplateApps(List<TemplateApp> templateApps) {
        this.templateApps = templateApps;
    }

    public GroupApplicationsTemplate() {

    }

    public GroupApplicationsTemplate(String templateName, int templateId, List<TemplateApp> templateApps) {

        this.templateName = templateName;
        this.templateId = templateId;
        this.templateApps = templateApps;
    }
}
