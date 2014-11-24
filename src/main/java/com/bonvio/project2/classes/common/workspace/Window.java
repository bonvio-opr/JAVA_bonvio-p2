package com.bonvio.project2.classes.common.workspace;

/**
 * Created by Ivan on 24.11.2014.
 */
public class Window {

    private int windowId;
    private int ownerUnitId;
    private int windowPositionX;
    private int windowPositionY;
    private int windowWidth;
    private int windowHeight;
    private String title;
    private String state;
    private int isMax;
    private int isMin;
    private int zIndex;

    public Window() {
    }

    public Window(
            int windowId,
            int ownerUnitId,
            int windowPositionX,
            int windowPositionY,
            int windowWidth,
            int windowHeight,
            String title,
            String state,
            int isMax,
            int isMin,
            int zIndex
    ) {
        this.windowId = windowId;
        this.ownerUnitId = ownerUnitId;
        this.windowPositionX = windowPositionX;
        this.windowPositionY = windowPositionY;
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.title = title;
        this.state = state;
        this.isMax = isMax;
        this.isMin = isMin;
        this.zIndex = zIndex;
    }


    public int getWindowId() {
        return windowId;
    }

    public void setWindowId(int windowId) {
        this.windowId = windowId;
    }

    public int getOwnerUnitId() {
        return ownerUnitId;
    }

    public void setOwnerUnitId(int ownerUnitId) {
        this.ownerUnitId = ownerUnitId;
    }

    public int getWindowPositionX() {
        return windowPositionX;
    }

    public void setWindowPositionX(int windowPositionX) {
        this.windowPositionX = windowPositionX;
    }

    public int getWindowPositionY() {
        return windowPositionY;
    }

    public void setWindowPositionY(int windowPositionY) {
        this.windowPositionY = windowPositionY;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public void setWindowWidth(int windowWidth) {
        this.windowWidth = windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public void setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getIsMax() {
        return isMax;
    }

    public void setIsMax(int isMax) {
        this.isMax = isMax;
    }

    public int getIsMin() {
        return isMin;
    }

    public void setIsMin(int isMin) {
        this.isMin = isMin;
    }

    public int getzIndex() {
        return zIndex;
    }

    public void setzIndex(int zIndex) {
        this.zIndex = zIndex;
    }
}
