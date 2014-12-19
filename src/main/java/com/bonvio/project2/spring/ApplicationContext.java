package com.bonvio.project2.spring;

import com.bonvio.project2.dao.cafe.barman.implementation.CafeBarmanMenuDaoImpl;
import com.bonvio.project2.dao.cafe.barman.implementation.CafeBarmanOrdersDaoImpl;
import com.bonvio.project2.dao.cafe.barman.implementation.CafeBarmanPagesDaoImpl;
import com.bonvio.project2.dao.cafe.clients.implementation.CafeClientsOrderDaoImpl;
import com.bonvio.project2.dao.cafe.clients.implementation.CafeClientsPagesDaoImpl;
import com.bonvio.project2.dao.cafe.clients.implementation.CafeClientsUserDaoImpl;
import com.bonvio.project2.dao.cafe.events.implementation.CafeEventsDaoImpl;
import com.bonvio.project2.dao.cafe.kitchen.implementation.CafeKitchenOrdersDaoImpl;
import com.bonvio.project2.dao.cafe.kitchen.implementation.CafeKitchenPagesDaoImpl;
import com.bonvio.project2.dao.cafe.waiters.implementation.CafeWaitersOrdersDaoImpl;
import com.bonvio.project2.dao.cafe.waiters.implementation.CafeWaitersPagesDaoImpl;
import com.bonvio.project2.dao.common.dbfhandling.implementation.CommonDBFHandlingDaoImpl;
import com.bonvio.project2.dao.common.groups.implementation.GroupsManagementDaoImpl;
import com.bonvio.project2.dao.common.groups.implementation.PointManagmentDaoImpl;
import com.bonvio.project2.dao.common.menuupload.CommonMenuUploadPagesDao;
import com.bonvio.project2.dao.common.menuupload.implementation.CommonMenuUploadJobDaoImpl;
import com.bonvio.project2.dao.common.menuupload.implementation.CommonMenuUploadPagesDaoImpl;
import com.bonvio.project2.dao.common.messenger.implementation.CommonMessengerDaoImpl;
import com.bonvio.project2.dao.common.printing.CommonPrintingDao;
import com.bonvio.project2.dao.common.printing.implementation.CommonPrintingDaoImpl;
import com.bonvio.project2.dao.common.workspace.implementation.FileManagerDaoImpl;
import com.bonvio.project2.dao.common.workspace.implementation.PagesMainDaoImpl;
import com.bonvio.project2.dao.settings.profile.implementation.SettingsProfileManagementDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ApplicationContext {


    @Autowired
    public DataSource dataSource;

    //unit Settings: PROFILE (настройка профиля)
    @Bean public SettingsProfileManagementDaoImpl getSettingsProfileManagementDaoImpl() {return new SettingsProfileManagementDaoImpl(dataSource);}

    //unit Commons: WORKSPACE (основное приложение, оболочка)
    @Bean public PagesMainDaoImpl getPagesMainDaoImpl() {return new PagesMainDaoImpl(dataSource);}

    //unit FileManager
    @Bean public FileManagerDaoImpl getFileManagerDaoImpl (){return new FileManagerDaoImpl (dataSource);}

    //unit Commons: MENU UPLOAD (обновление позиций меню)
    @Bean public CommonMenuUploadJobDaoImpl getCommonMenuUploadJobDaoImpl() {return new CommonMenuUploadJobDaoImpl(dataSource);}
    @Bean public CommonMenuUploadPagesDaoImpl getCommonMenuUploadPagesDaoImpl() {return new CommonMenuUploadPagesDaoImpl(dataSource);}

    //unit Commons: GroupsManagement
    @Bean public GroupsManagementDaoImpl getGroupsManagementDaoImpl() {return new GroupsManagementDaoImpl(dataSource);}
    @Bean public PointManagmentDaoImpl getPointManagmentDaoImpl () {return  new PointManagmentDaoImpl(dataSource);}

    //unit Commons: Printing
    @Bean public CommonPrintingDaoImpl getCommonPrintingDaoImpl() {return new CommonPrintingDaoImpl(dataSource);}

    //unit Commons: DBFHandling (обработка DBF)
    @Bean public CommonDBFHandlingDaoImpl getCommonDBFHandlingDaoImpl() {return new CommonDBFHandlingDaoImpl(dataSource);}

    //unit Commons: MESSENGER
    @Bean public CommonMessengerDaoImpl getMessengerDaoImpl() {return new CommonMessengerDaoImpl(dataSource);}

    //unit Cafe: EVENTS
    @Bean public CafeEventsDaoImpl getCafeEventsDaoImpl() {return new CafeEventsDaoImpl(dataSource);}

    //unit Cafe: CLIENTS
    @Bean public CafeClientsOrderDaoImpl getOrderDaoImpl() {return new CafeClientsOrderDaoImpl(dataSource);}
    @Bean public CafeClientsUserDaoImpl getUserDaoImpl() {return new CafeClientsUserDaoImpl(dataSource);}
    @Bean public CafeClientsPagesDaoImpl getPagesDaoImpl() {return new CafeClientsPagesDaoImpl(dataSource);}

    //unit Cafe: WAITERS (официанты)
    @Bean public CafeWaitersPagesDaoImpl getCafeWaitersPagesDaoImpl() {return new CafeWaitersPagesDaoImpl(dataSource);}
    @Bean public CafeWaitersOrdersDaoImpl getCafeWaitersOrdersDaoImpl() {return new CafeWaitersOrdersDaoImpl(dataSource);}

    //unit Cafe: BARMAN (бармены)
    @Bean public CafeBarmanOrdersDaoImpl getCafeBarmanOrdersDaoImpl() {return new CafeBarmanOrdersDaoImpl(dataSource);}
    @Bean public CafeBarmanMenuDaoImpl getCafeBarmanMenuDaoImpl() {return new CafeBarmanMenuDaoImpl(dataSource);}
    @Bean public CafeBarmanPagesDaoImpl getCafeBarmanPagesDaoImpl() {return new CafeBarmanPagesDaoImpl(dataSource);}

    //unit Cafe: KITCHEN (кухня, повары)
    @Bean public CafeKitchenOrdersDaoImpl getCafeKitchenOrdersDaoImpl() {return new CafeKitchenOrdersDaoImpl(dataSource);}
    @Bean public CafeKitchenPagesDaoImpl getCafeKitchenPagesDaoImpl() {return new CafeKitchenPagesDaoImpl(dataSource);}






}
