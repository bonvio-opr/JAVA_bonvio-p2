package com.bonvio.project2.web.rest.common.groups;

import com.bonvio.project2.classes.common.groups.Group;
import com.bonvio.project2.classes.common.groups.GroupApplicationsTemplate;
import com.bonvio.project2.classes.common.groups.TemplateApp;
import com.bonvio.project2.dao.common.groups.implementation.GroupsManagementDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.geom.Point2D;
import java.util.List;

/**
 * Created by Arti on 06.08.2014.
 */

@RestController
@RequestMapping("/gm")
public class GroupsManagementService {

    @Autowired
    public GroupsManagementDaoImpl dao;

    @RequestMapping(value = "/createGroup", method = RequestMethod.POST)
    public int createGroup(@RequestParam("group") Group g, @RequestParam("ownerId") int ownerId){
        return dao.groupManagementCreateGroup(g, ownerId);
    }

    @RequestMapping(value = "/searchByName", method = RequestMethod.POST)
    public List<Group> groupManagementSearchByName(@RequestParam("namePart") String namePart){
        return dao.groupManagementSearchByName(namePart);
    }

    @RequestMapping(value = "/watchGroup", method = RequestMethod.POST)
    public Group getGroupById(@RequestParam("groupId") int groupId){
        return dao.groupManagementWatchGroup(groupId);
    }

    @RequestMapping(value = "/inviteUser", method = RequestMethod.POST)
    public int inviteUser(@RequestParam("inviter") int inviter, @RequestParam("invited") int invited, @RequestParam("groupId") int groupId){
        return dao.groupManagementInviteUser(inviter, invited, groupId);
    }

    @RequestMapping(value = "/acceptInvitation", method = RequestMethod.POST)
    public int acceptInvitation(@RequestParam("userId") int userId, @RequestParam("groupId") int groupId){
        return dao.groupManagementAcceptInvitation(userId, groupId);
    }

    @RequestMapping(value = "/rejectInvitation", method = RequestMethod.POST)
    public int rejectInvitation(@RequestParam("userId") int userId, @RequestParam("groupId") int groupId){
        return dao.groupManagementRejectInvitation(userId, groupId);
    }

    @RequestMapping(value = "/addExistingSpot", method = RequestMethod.POST)
    public int addExistingSpot(@RequestParam("spotId") int spotId, @RequestParam("groupId") int groupId){
        return dao.groupManagementSpotAddExisting(spotId, groupId);
    }

    @RequestMapping(value = "/createAndAddSpot", method = RequestMethod.POST)
    public int createThenAddSpot(
            @RequestParam("latLon") Point2D.Double spotLatLon,
            @RequestParam("spotAddress") String spotAddress,
            @RequestParam("groupId") int groupId,
            @RequestParam("spotName") String spotName,
            @RequestParam("country") String country,
            @RequestParam("city") String city
    ){
        return dao.groupManagementSpotCreateThenAdd(spotLatLon, spotAddress, groupId, spotName, country, city);
    }

    @RequestMapping(value = "/leaveGroup", method = RequestMethod.POST)
    public int leaveGroup(@RequestParam("userId") int userId, @RequestParam("groupId") int groupId){
        return dao.groupManagementLeaveGroup(userId, groupId);
    }

    @RequestMapping(value = "/kickFromGroup", method = RequestMethod.POST)
    public int kickFromGroup(@RequestParam("userId") int userId, @RequestParam("groupId") int groupId, @RequestParam("reason") String reason){
        return dao.groupManagementKickFromGroup(userId, groupId, reason);
    }

    @RequestMapping(value = "/getTemplateById", method = RequestMethod.POST)
    public GroupApplicationsTemplate getTemplateById(@RequestParam("templateId") int templateId, @RequestParam("groupId") int groupId){
        return dao.getTemplateById(templateId, groupId);
    }

    @RequestMapping(value = "/getTemplates", method = RequestMethod.POST)
    public List<GroupApplicationsTemplate> getTemplates(@RequestParam("groupId") int groupId){
        return dao.getTemplates(groupId);
    }

    @RequestMapping(value = "/createTemplate", method = RequestMethod.POST)
    public int updateGroupInfo(@RequestParam("groupId") int groupId, @RequestParam("templateName") String templateName, @RequestParam("tmplApps") List<TemplateApp> templateApps){
        return dao.createTemplate(groupId, templateName, templateApps);
    }

    @RequestMapping(value = "/editTemplate", method = RequestMethod.POST)
    public int editTemplate(@RequestParam("templateId") int templateId, @RequestParam("templateName") String templateName, @RequestParam("newTmplApps") List<TemplateApp> templateApps){
        return dao.editTemplate(templateId, templateName, templateApps);
    }

    @RequestMapping(value = "/getAppsByWsId", method = RequestMethod.POST)
    public List<TemplateApp> getAppsByWsId(@RequestParam("wsId") int wsId, @RequestParam("groupId") int groupId){
        return dao.getAppsByWsId(groupId, wsId);
    }

    @RequestMapping(value = "/removeAppsFromWs", method = RequestMethod.POST)
    public int removeAppsFromWs(@RequestParam("wsId") int wsId, @RequestParam("removedApps") List<Integer> list){
        return dao.removeAppsFromWs(wsId, list);
    }

    @RequestMapping(value = "/addAppsToWs", method = RequestMethod.POST)
    public int addAppsToWs(@RequestParam("wsId") int wsId, @RequestParam("addedApps") List<Integer> list){
        return dao.addAppsToWs(wsId, list);
    }

}
