package com.bonvio.project2.classes.common.groups;

import java.util.Date;

/**
 * Created by Arti on 07.08.2014.
 */
public class Invite {
    private int inviteId;
    private int inviteGroupId;
    private int inviteSenderId;
    private int inviteReceiverId;
    private Date inviteSendDate;
    private Date inviteAcceptDate;
    private Date inviteRejectDate;

    @Override
    public String toString() {
        return "Invite{" +
                "inviteId=" + inviteId +
                ", inviteGroupId=" + inviteGroupId +
                ", inviteSenderId=" + inviteSenderId +
                ", inviteReceiverId=" + inviteReceiverId +
                ", inviteSendDate=" + inviteSendDate +
                ", inviteAcceptDate=" + inviteAcceptDate +
                ", inviteRejectDate=" + inviteRejectDate +
                '}';
    }

    public int getInviteId() {
        return inviteId;
    }

    public void setInviteId(int inviteId) {
        this.inviteId = inviteId;
    }

    public int getInviteGroupId() {
        return inviteGroupId;
    }

    public void setInviteGroupId(int inviteGroupId) {
        this.inviteGroupId = inviteGroupId;
    }

    public int getInviteSenderId() {
        return inviteSenderId;
    }

    public void setInviteSenderId(int inviteSenderId) {
        this.inviteSenderId = inviteSenderId;
    }

    public int getInviteReceiverId() {
        return inviteReceiverId;
    }

    public void setInviteReceiverId(int inviteReceiverId) {
        this.inviteReceiverId = inviteReceiverId;
    }

    public Date getInviteSendDate() {
        return inviteSendDate;
    }

    public void setInviteSendDate(Date inviteSendDate) {
        this.inviteSendDate = inviteSendDate;
    }

    public Date getInviteAcceptDate() {
        return inviteAcceptDate;
    }

    public void setInviteAcceptDate(Date inviteAcceptDate) {
        this.inviteAcceptDate = inviteAcceptDate;
    }

    public Date getInviteRejectDate() {
        return inviteRejectDate;
    }

    public void setInviteRejectDate(Date inviteRejectDate) {
        this.inviteRejectDate = inviteRejectDate;
    }

    public Invite() {
    }

    public Invite(int inviteId, int inviteGroupId, int inviteSenderId, int inviteReceiverId, Date inviteSendDate, Date inviteAcceptDate, Date inviteRejectDate) {

        this.inviteId = inviteId;
        this.inviteGroupId = inviteGroupId;
        this.inviteSenderId = inviteSenderId;
        this.inviteReceiverId = inviteReceiverId;
        this.inviteSendDate = inviteSendDate;
        this.inviteAcceptDate = inviteAcceptDate;
        this.inviteRejectDate = inviteRejectDate;
    }
}
