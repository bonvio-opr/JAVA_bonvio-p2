/**
 * Created by Arti on 29.04.2014.
 */

define( ['jquery', 'knockout',
        "text!./templates/work-area-template.html",
        'controls/common/page-header/PageHeader',
        'controls/common/page-footer/PageFooter',
        'controls/common/page-left/PageLeft',
        'controls/common/page-right/PageRight'],
    function ( $, ko, WorkAreaTemplate, PageHeader, PageFooter, PageLeft, PageRight) {
        function WorkArea( $container  ) {
            var self = this;
            self.$parentContainer = $container;
            self.$container = $( WorkAreaTemplate );

            self.currentUserCredentials = ko.observable(null);
            self.currentUserNotificationsQuantity = ko.observable(null);
            self.defaultWs = ko.observable(null);
            self.currentWs = ko.observable(null);
            self.minimizedWsList = ko.observableArray([]);
            self.privateWsList = ko.observableArray([]);

            self.requests = {
                getUserDefaultWorkspace: 'getUserPrivateWorkspace',
                getCurrentUserCredentials: 'getCurrentUserCredentials',
                getCurrentUserPrivateWorkspace: 'getCurrentUserPrivateWorkspace',
                getCurrentUserAdditionalWorkspaces: 'getCurrentUserAdditionalWorkspaces',
                getUserUnitAccessRights: 'getUserUnitAccessRights/',
                getCurrentUserNotifications: '' //XXX: implement getting notifications;
            };
            self.bindModel();
            self.pHeader    =       new PageHeader  ($(document).find("#pageHeader" ),   self);
            self.pHeader.bindModel();
            self.pFooter    =       new PageFooter  ($(document).find("#pageFooter" ),   self);
            self.pFooter.bindModel();
            self.pLeft      =       new PageLeft    ($(document).find("#pageLeft"   ),   self);
            self.pLeft.bindModel();
            self.pRight     =       new PageRight   ($(document).find("#pageRight"  ),   self);
            self.pRight.bindModel();
            $.proxy(self.init, self);
            $.proxy(self.openDefaultWorkspace, self);
            $.proxy(self.openWorkspace, self);
            self.init();
        }

        WorkArea.prototype.createWorkspaceInstance = function(wsId, wsName, wsUnits, wsOpenUnit, wsCurrentProcesses, wsProcessCounter) {
            return {
                wsId: wsId,
                wsName: wsName,
                wsUnits: wsUnits,
                wsOpenUnit: wsOpenUnit, //unitName, unitId, unitState
                wsCurrentProcesses: wsCurrentProcesses,
                wsProcessCounter: wsProcessCounter
            }
        };

        WorkArea.prototype.getWsInstanceFromListById = function(wsId) {
            var self = this;
            if(wsId===0)
                return self.defaultWs();
            for(var i=0; i<self.privateWsList().length; i++) {
                if(self.privateWsList()[i].wsId === wsId) {return self.privateWsList()[i];}
            }
            return null;
        };

        WorkArea.prototype.init = function() {
            var self = this;
            //XXX: implement getting notifications;
            self.currentUserNotificationsQuantity(5);
            //Opens current user's default WS
            self.openDefaultWorkspace();
            $.ajax({
                type: 'GET',
                url: self.requests.getCurrentUserCredentials,
                dataType: 'json',
                success: function(d) {
                    self.currentUserCredentials(d.secondName + ' ' + d.firstName + ' (ID='+ d.userId+'; phone='+ d.userNumber+'); ');
                },
                error: function() {console.log('error');}
            });
            $.ajax({
                type: 'GET',
                url: self.requests.getCurrentUserAdditionalWorkspaces,
                dataType: 'json',
                success: function(d) {
                    for(var i= 0; i<d.length; i++) {
                        console.log(d[i]);
                        self.privateWsList.push(self.createWorkspaceInstance(
                                d[i].wsId,
                                d[i].wsName ,
                                d[i].wsUnits,
                                {unitName: '', unitId: '', unitState: 0},
                                [],
                                1)
                        );
                    }
                },
                error: function() {console.log('error');}
            });

        };

        WorkArea.prototype.openUnit = function(unitCode, wsId) {
            var self = this;
            $.ajax({
                type: 'get',
                url: self.requests.getUserUnitAccessRights+wsId+'/'+unitCode+'/',
                dataType: 'json',
                success: function(d) {
                    if(d===1) {
                        $('#pageFooter span')
                            .filter('.active')
                            .removeClass('active');
                        var unitId = self.currentWs().wsProcessCounter,
                            newProcess = {
                                unitName: unitCode,
                                unitId: unitId,
                                unitState: 1
                            };
                        (self.currentWs().wsCurrentProcesses).push(newProcess);
                        self.currentWs().wsProcessCounter++;
                        var currWs = self.currentWs();
                        currWs.wsOpenUnit = newProcess;
                        self.currentWs(currWs);
                        self.currentWs.valueHasMutated();
//                        self.maximizeUnit(unitName, unitId);
                    } else {
                        console.log('access restricted');
                        alert('ACCESS RESTRICTED !');
                    }
                    $('#pageFooter span:last').addClass('active');
                },
                error: function() {
                    console.log('error');
                }
            });
            self.currentWs.valueHasMutated();
        };

        /*WorkArea.prototype.closeUnitById = function(id) {
            var self = this;
            for(var i=0; i<self.currentWs().wsCurrentProcesses.length; i++) {
                if(self.currentWs().wsCurrentProcesses[i].unitId === id) {
                    self.currentWs().wsCurrentProcesses.splice(i, 1)
                }
            }
        };*/

        WorkArea.prototype.addUnit = function(unit) {

        };

        WorkArea.prototype.closeUnit = function() {
            var self = this;
            var currentOpenUnit = self.currentWs().wsOpenUnit;
            var t= self.currentWs().wsCurrentProcesses;
            for(var p=0;p< t.length; p++) {
                if(t[p].unitId===currentOpenUnit.unitId && t[p].unitName===currentOpenUnit.unitName) {
                    t.splice(p, 1);
                    var currWsTmp = self.currentWs();
                    currWsTmp.wsOpenUnit = {unitName:'', unitId:'', unitState: 0};
                    self.currentWs(currWsTmp);
                    break;
                }
            }
            self.currentWs.valueHasMutated();
            $('#pageFooter span').filter('.active').remove();
        };

        WorkArea.prototype.minimizeUnit = function() {
            var self = this;
            var currentOpenUnit = self.currentWs().wsOpenUnit;
            var t= self.currentWs().wsCurrentProcesses;
            for(var p=0;p< t.length; p++) {
                if(t[p].unitId===currentOpenUnit.unitId && t[p].unitName===currentOpenUnit.unitName) {
                    var currWsTmp = self.currentWs();
                    t[p].unitState = 1 - t[p].unitState;
                    currWsTmp.wsOpenUnit = {unitName:'', unitId:'', unitState: 0};
                    self.currentWs(currWsTmp);
                    break;
                }
            }
            self.currentWs.valueHasMutated();
            $('#pageFooter span').filter('.active').removeClass('active');
        };

        WorkArea.prototype.changeState = function(unitName, unitId) {
            var self = this;
            var t= self.currentWs();
            if(t.wsOpenUnit.unitName===unitName && t.wsOpenUnit.unitId===unitId && t.wsOpenUnit.unitState === 1) {
                self.minimizeUnit();
                self.currentWs.valueHasMutated();
            } else {
                t.wsOpenUnit = {unitName: unitName, unitId: unitId, unitState: 1};
                self.currentWs(t);
                self.currentWs.valueHasMutated();
            }
        };

        WorkArea.prototype.getFooterPlateClass = function(state) {
            if(state===1) {
                return 'active';
            }
            return '';
        };

        WorkArea.prototype.maximizeUnit = function(unitName, unitId, index) {
            var self = this;
            var t= self.currentWs();
            Object.defineProperty(t, "wsOpenUnit", {unitName: unitName, unitId: unitId, unitState: 1});
            self.currentWs(t);
            self.currentWs.valueHasMutated();
        };

        WorkArea.prototype.openWorkspace = function(data, elem) {
            var self = this;
            $('#pageLeft p').addClass('wsinactive');
            $(elem)
                .removeClass('wsinactive')
                .addClass('wsactive');
            if (self.currentWs().wsId === data) {
            } else  {
                var ws = self.getWsInstanceFromListById(data);
                if(ws !== null) {
                    self.minimizedWsList.push(self.currentWs());
                    self.currentWs(ws);
                } else {
                }
            }
//            $('#pageFooter span').filter(':not(.inactive)').filter(':not(.active)').remove();
            self.currentWs.valueHasMutated();
        };

        WorkArea.prototype.openDefaultWorkspace = function(elem) {
            var self = this;
            if ((self.currentWs() === self.defaultWs())&&(self.defaultWs() !== null)) {
            } else {
                //First time loading
                if(self.defaultWs() === null) {
                    $.ajax({
                        type: 'GET',
                        url: self.requests.getCurrentUserPrivateWorkspace,
                        dataType: 'json',
                        success: function(d) {
                            self.defaultWs(
                                self.createWorkspaceInstance(
                                    d[0].wsId,
                                    d[0].wsName,
                                    d[0].wsUnits,
                                    {unitName: '', unitId: '', unitState: 0},
                                    [],
                                    1
                                )
                            );
                            self.currentWs(
                                self.createWorkspaceInstance(
                                    d[0].wsId,
                                    d[0].wsName,
                                    d[0].wsUnits,
                                    {unitName: '', unitId: '', unitState: 0},
                                    [],
                                    1
                                )
                            );
                            console.log(self.currentWs());
                        },
                        error: function() {console.log('error: couldnt get default workspace');}
                    });
                //If default WS was already preloaded: we have only to show
                } else {
                    $('#pageLeft p').addClass('wsinactive');
                    self.openWorkspace(0);
                }
                $(elem)
                    .removeClass('wsinactive')
                    .addClass('wsactive');
            }
//            $('#pageFooter span').filter(':not(.inactive)').filter(':not(.active)').remove();
            self.currentWs.valueHasMutated();
        };


        /* Do not change any code after that note - any methods have2be added before */

        WorkArea.prototype.bindModel = function() {
            var self = this;
            self.$parentContainer.append( self.$container );
            ko.applyBindings( self, self.$parentContainer[0] );
        };

        return WorkArea;
    }
);
