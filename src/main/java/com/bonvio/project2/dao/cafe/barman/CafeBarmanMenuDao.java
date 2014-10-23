package com.bonvio.project2.dao.cafe.barman;

import com.bonvio.project2.classes.cafe.clients.MenuPosition;

import java.util.List;

/**
 * Created by Arti on 30.07.2014.
 */
public interface CafeBarmanMenuDao {
    public String getCategoryNameByPositionMenuIdAndSpotId(int menuPositionId, int spotId);
    public List<MenuPosition> getMenuPositionsByCategoryId(int categoryId);
    public MenuPosition getPositionFullInfoByPositionId(int positionId);
}
