package com.bonvio.project2.classes.settings.profile;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Arti on 07.10.2014.
 */
public class FullUserProfile {
    private int profileId;
    private String profileEmail;
    private String profileName;
    private String profileSurname;
    private String profilePatronymic;
    private String profilePassword;
    private String profilePhoneNumber;
    private int profileDocType;
    private String profileDocCode;
    private String profileCity;
    private String profileCountry;

    @Override
    public String toString() {
        return "FullUserProfile{" +
                "profileId=" + profileId +
                ", profileEmail='" + profileEmail + '\'' +
                ", profileName='" + profileName + '\'' +
                ", profileSurname='" + profileSurname + '\'' +
                ", profilePatronymic='" + profilePatronymic + '\'' +
                ", profilePassword='" + profilePassword + '\'' +
                ", profilePhoneNumber='" + profilePhoneNumber + '\'' +
                ", profileDocType=" + profileDocType +
                ", profileDocCode='" + profileDocCode + '\'' +
                ", profileCity='" + profileCity + '\'' +
                ", profileCountry='" + profileCountry + '\'' +
                '}';
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getProfileEmail() {
        return profileEmail;
    }

    public void setProfileEmail(String profileEmail) {
        this.profileEmail = profileEmail;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileSurname() {
        return profileSurname;
    }

    public void setProfileSurname(String profileSurname) {
        this.profileSurname = profileSurname;
    }

    public String getProfilePatronymic() {
        return profilePatronymic;
    }

    public void setProfilePatronymic(String profilePatronymic) {
        this.profilePatronymic = profilePatronymic;
    }

    public String getProfilePassword() {
        return profilePassword;
    }

    public void setProfilePassword(String profilePassword) {
        this.profilePassword = profilePassword;
    }

    public String getProfilePhoneNumber() {
        return profilePhoneNumber;
    }

    public void setProfilePhoneNumber(String profilePhoneNumber) {
        this.profilePhoneNumber = profilePhoneNumber;
    }

    public int getProfileDocType() {
        return profileDocType;
    }

    public void setProfileDocType(int profileDocType) {
        this.profileDocType = profileDocType;
    }

    public String getProfileDocCode() {
        return profileDocCode;
    }

    public void setProfileDocCode(String profileDocCode) {
        this.profileDocCode = profileDocCode;
    }

    public String getProfileCity() {
        return profileCity;
    }

    public void setProfileCity(String profileCity) {
        this.profileCity = profileCity;
    }

    public String getProfileCountry() {
        return profileCountry;
    }

    public void setProfileCountry(String profileCountry) {
        this.profileCountry = profileCountry;
    }

    public FullUserProfile() {

    }

    public FullUserProfile(int profileId, String profileEmail, String profileName, String profileSurname, String profilePatronymic, String profilePassword, String profilePhoneNumber, int profileDocType, String profileDocCode, String profileCity, String profileCountry) {

        this.profileId = profileId;
        this.profileEmail = profileEmail;
        this.profileName = profileName;
        this.profileSurname = profileSurname;
        this.profilePatronymic = profilePatronymic;
        this.profilePassword = profilePassword;
        this.profilePhoneNumber = profilePhoneNumber;
        this.profileDocType = profileDocType;
        this.profileDocCode = profileDocCode;
        this.profileCity = profileCity;
        this.profileCountry = profileCountry;
    }
}
