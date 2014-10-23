package com.bonvio.project2.classes.common.groups;

/**
 * Created by Arti on 08.08.2014.
 */
public class TemplateApp {
    private int templateAppId;
    private String templateAppName;

    @Override
    public String toString() {
        return "TemplateApp{" +
                "templateAppId=" + templateAppId +
                ", templateAppName='" + templateAppName + '\'' +
                '}';
    }

    public int getTemplateAppId() {
        return templateAppId;
    }

    public void setTemplateAppId(int templateAppId) {
        this.templateAppId = templateAppId;
    }

    public String getTemplateAppName() {
        return templateAppName;
    }

    public void setTemplateAppName(String templateAppName) {
        this.templateAppName = templateAppName;
    }

    public TemplateApp() {

    }

    public TemplateApp(int templateAppId, String templateAppName) {

        this.templateAppId = templateAppId;
        this.templateAppName = templateAppName;
    }
}
