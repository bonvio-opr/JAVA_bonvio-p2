package com.bonvio.project2.dao.common.groups;

import com.bonvio.project2.classes.common.groups.Group;

import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Arti on 06.08.2014.
 */
public interface GroupsManagementDao {
    public int createGroup(Group groupName, int ownerId);
    public java.util.List<Group> searchGroupByName(String namePart);
    public Group groupManagementWatchGroup(int groupId);
    public int groupManagementInviteUser(int inviterUserId, int invitedUserId, int groupId);
    public int groupManagementSpotAddExisting(int spotId, int groupId);
    public int groupManagementSpotCreateThenAdd(Point2D.Double spotLatLon, String spotAddress, int groupId, String spotName, String country, String city);
    public int groupManagementLeaveGroup(int userId, int groupId);
    public int groupManagementKickFromGroup(int userId, int groupId, String reason);
    public int groupManagementUpdateGroupInfo(Group groupWithNewProperties);
}
