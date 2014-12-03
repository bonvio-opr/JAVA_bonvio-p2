package com.bonvio.project2.classes.common.workspace;

/**
 * Created by Arti on 23.07.2014.
 */
public class UserCredentials {
    private int userId;
    private String firstName;
    private String secondName;
    private String userNumber;

    @Override
    public String toString() {
        return "UserCredentials{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", userNumber='" + userNumber + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public UserCredentials() {

    }

    public UserCredentials(int userId, String firstName, String secondName, String userNumber) {

        this.userId = userId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.userNumber = userNumber;
    }
}
