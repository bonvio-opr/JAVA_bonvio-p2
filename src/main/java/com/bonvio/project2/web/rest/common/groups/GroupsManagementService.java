package com.bonvio.project2.web.rest.common.groups;

import com.bonvio.project2.classes.common.groups.Group;
import com.bonvio.project2.classes.common.groups.GroupApplicationsTemplate;
import com.bonvio.project2.classes.common.groups.Point;
import com.bonvio.project2.classes.common.groups.TemplateApp;
import com.bonvio.project2.dao.common.groups.implementation.GroupsManagementDaoImpl;
import com.bonvio.project2.dao.common.groups.implementation.PointManagmentDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.awt.geom.Point2D;
import java.util.List;

/**
 * Created by Arti on 06.08.2014.
 */

@RestController
@RequestMapping("/group")
public class GroupsManagementService {

    @Autowired
    public GroupsManagementDaoImpl groupsManagement;

    @Autowired
    public PointManagmentDaoImpl pointManagment;


    //work with point

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public ModelAndView redirect(HttpServletRequest request) {
        String userId = request.getSession().getAttribute("userId").toString();
        System.out.println("проверка");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("workspace/groups");
        return modelAndView;
    }


    @RequestMapping(value = "/createGroup", method = RequestMethod.POST)
    public int createGroup(@RequestBody Group group,  HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        int userIdInt = Integer.parseInt(userId);
        return groupsManagement.createGroup(group, userIdInt);
    }

    @RequestMapping(value = "/searchByName/{groupName}", method = RequestMethod.POST)
    public List<Group> groupManagementSearchByName(@PathVariable("groupName") String groupName){
        return groupsManagement.searchGroupByName(groupName);
    }

    @RequestMapping(value = "/mygroups", method = RequestMethod.POST)
    public List<Group> myGroups(HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        int userIdInt = Integer.parseInt(userId);
        return groupsManagement.getMyGroups(userIdInt);
    }

    @RequestMapping(value = "/deletegroup/{groupId}", method = RequestMethod.POST)
    public int deleteGroup (@PathVariable("groupId") String groupId, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        int userIdInt = Integer.parseInt(userId);
        return groupsManagement.deleteGroup(userIdInt, groupId);
    }

    @RequestMapping(value = "/getgroup/{groupId}", method = RequestMethod.POST)
    public Group getGroup (@PathVariable("groupId") String groupId){
        return groupsManagement.getGroup(groupId);
    }





    //work with point
    //pointManagment.

    @RequestMapping(value = "/createpoint", method = RequestMethod.POST)
    public int createPoint (@RequestBody Point point,  HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        int userIdInt = Integer.parseInt(userId);
        return pointManagment.createPoint(point, userIdInt);
    }

    @RequestMapping(value = "/deletepoint/{piontId}", method = RequestMethod.POST)
    public int deletePoint (@PathVariable("piontId") int piontId,  HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        int userIdInt = Integer.parseInt(userId);
        return pointManagment.deletePoint(piontId, userIdInt);
    }

    @RequestMapping(value = "/getpointsbygroupid/{groupId}", method = RequestMethod.POST)
    public  List<Point> getPoints (@PathVariable("groupId") int groupId,  HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        int userIdInt = Integer.parseInt(userId);
        return pointManagment.getPointsByGroupId(groupId, userIdInt);
    }

    @RequestMapping(value = "/getpoinbyid/{piontId}", method = RequestMethod.POST)
    public Point getPointById (@PathVariable("piontId") int piontId,  HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        int userIdInt = Integer.parseInt(userId);
        return pointManagment.getPointById(piontId, userIdInt);
    }











    @RequestMapping(value = "/watchGroup", method = RequestMethod.POST)
    public Group getGroupById(@RequestParam("groupId") int groupId){
        return groupsManagement.groupManagementWatchGroup(groupId);
    }

    @RequestMapping(value = "/inviteUser", method = RequestMethod.POST)
    public int inviteUser(@RequestParam("inviter") int inviter, @RequestParam("invited") int invited, @RequestParam("groupId") int groupId){
        return groupsManagement.groupManagementInviteUser(inviter, invited, groupId);
    }

    @RequestMapping(value = "/acceptInvitation", method = RequestMethod.POST)
    public int acceptInvitation(@RequestParam("userId") int userId, @RequestParam("groupId") int groupId){
        return groupsManagement.groupManagementAcceptInvitation(userId, groupId);
    }

    @RequestMapping(value = "/rejectInvitation", method = RequestMethod.POST)
    public int rejectInvitation(@RequestParam("userId") int userId, @RequestParam("groupId") int groupId){
        return groupsManagement.groupManagementRejectInvitation(userId, groupId);
    }

    @RequestMapping(value = "/addExistingSpot", method = RequestMethod.POST)
    public int addExistingSpot(@RequestParam("spotId") int spotId, @RequestParam("groupId") int groupId){
        return groupsManagement.groupManagementSpotAddExisting(spotId, groupId);
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
        return groupsManagement.groupManagementSpotCreateThenAdd(spotLatLon, spotAddress, groupId, spotName, country, city);
    }

    @RequestMapping(value = "/leaveGroup", method = RequestMethod.POST)
    public int leaveGroup(@RequestParam("userId") int userId, @RequestParam("groupId") int groupId){
        return groupsManagement.groupManagementLeaveGroup(userId, groupId);
    }

    @RequestMapping(value = "/kickFromGroup", method = RequestMethod.POST)
    public int kickFromGroup(@RequestParam("userId") int userId, @RequestParam("groupId") int groupId, @RequestParam("reason") String reason){
        return groupsManagement.groupManagementKickFromGroup(userId, groupId, reason);
    }

    @RequestMapping(value = "/getTemplateById", method = RequestMethod.POST)
    public GroupApplicationsTemplate getTemplateById(@RequestParam("templateId") int templateId, @RequestParam("groupId") int groupId){
        return groupsManagement.getTemplateById(templateId, groupId);
    }

    @RequestMapping(value = "/getTemplates", method = RequestMethod.POST)
    public List<GroupApplicationsTemplate> getTemplates(@RequestParam("groupId") int groupId){
        return groupsManagement.getTemplates(groupId);
    }

    @RequestMapping(value = "/createTemplate", method = RequestMethod.POST)
    public int updateGroupInfo(@RequestParam("groupId") int groupId, @RequestParam("templateName") String templateName, @RequestParam("tmplApps") List<TemplateApp> templateApps){
        return groupsManagement.createTemplate(groupId, templateName, templateApps);
    }

    @RequestMapping(value = "/editTemplate", method = RequestMethod.POST)
    public int editTemplate(@RequestParam("templateId") int templateId, @RequestParam("templateName") String templateName, @RequestParam("newTmplApps") List<TemplateApp> templateApps){
        return groupsManagement.editTemplate(templateId, templateName, templateApps);
    }

    @RequestMapping(value = "/getAppsByWsId", method = RequestMethod.POST)
    public List<TemplateApp> getAppsByWsId(@RequestParam("wsId") int wsId, @RequestParam("groupId") int groupId){
        return groupsManagement.getAppsByWsId(groupId, wsId);
    }

    @RequestMapping(value = "/removeAppsFromWs", method = RequestMethod.POST)
    public int removeAppsFromWs(@RequestParam("wsId") int wsId, @RequestParam("removedApps") List<Integer> list){
        return groupsManagement.removeAppsFromWs(wsId, list);
    }

    @RequestMapping(value = "/addAppsToWs", method = RequestMethod.POST)
    public int addAppsToWs(@RequestParam("wsId") int wsId, @RequestParam("addedApps") List<Integer> list){
        return groupsManagement.addAppsToWs(wsId, list);
    }

}
