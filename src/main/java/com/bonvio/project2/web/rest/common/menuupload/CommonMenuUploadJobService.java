package com.bonvio.project2.web.rest.common.menuupload;

import com.bonvio.project2.classes.cafe.clients.MenuPosition;
import com.bonvio.project2.classes.cafe.waiters.internal.OrderForWaiter;
import com.bonvio.project2.classes.common.menuupload.Ingredient;
import com.bonvio.project2.classes.common.menuupload.MenuCategory;
import com.bonvio.project2.classes.common.menuupload.MenuPositionRecipe;
import com.bonvio.project2.dao.cafe.barman.implementation.CafeBarmanOrdersDaoImpl;
import com.bonvio.project2.dao.common.menuupload.implementation.CommonMenuUploadJobDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Arti on 12.08.2014.
 */

@RestController
@RequestMapping("/app_libmenuupload/job")
public class CommonMenuUploadJobService {

    @Autowired(required = true)
    public CommonMenuUploadJobDaoImpl dao;

    @RequestMapping(value = "/getCategories", method = RequestMethod.POST)
    public LinkedList<MenuCategory> getCategories(HttpServletRequest request) {
        return dao.getCategories(request.getRemoteAddr());
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public int addCategory(@RequestParam("catName") String catName, @RequestParam("catCode") String catCode, @RequestParam("catType") String catType, HttpServletRequest request) {
        return dao.addCategory(catName, catCode, catType, request.getRemoteAddr());
    }

    @RequestMapping(value = "/deleteCategory", method = RequestMethod.POST)
    public int addCategory(@RequestParam("catId") int catId, HttpServletRequest request) {
        return dao.deleteCategory(catId, request.getRemoteAddr());
    }

    @RequestMapping(value = "/ingredientAdd", method = RequestMethod.POST)
    public int uploadIngredient(@RequestParam("ingredientName") String ingrName, HttpServletRequest request) {
        return dao.ingredientUpload(ingrName, request.getRemoteAddr());
    }

    @RequestMapping(value = "/ingredientRemove", method = RequestMethod.POST)
    public int removeIngredients(@RequestParam("ingredientId") int ingrId, HttpServletRequest request) {
        return dao.ingredientsRemove(ingrId, request.getRemoteAddr());
    }

    @RequestMapping(value = "/addPositionWithoutRecipe", method = RequestMethod.POST)
    public ModelAndView addPositionWithoutRecipe(
            @RequestParam("language") String language,
            @RequestParam("name") String name,
            @RequestParam("file") MultipartFile file,
            @RequestParam("price") int price,
            @RequestParam("description") String description,
            @RequestParam("category") String category,
            @RequestParam("quantity") Double quantity,
            @RequestParam("units") String units,
            @RequestParam("included") boolean included,
            HttpServletRequest request
    ) {
        ModelAndView mav = new ModelAndView();
        try {
            if (name.length() < 1) {
//                mav.addObject("positionWithoutRecipeUploadError", "Недопустимое название");
//            } else if (file.getSize() == 0) {
//                mav.addObject("positionWithoutRecipeUploadError", "Добавьте изображение");
            } else {
                dao.addPositionWithoutRecipe(language, name, file, price, description, category, quantity, units, included, request.getRemoteAddr());
//                mav.addObject("positionWithoutRecipeUploadError", "");
            }
            mav.setViewName("app_libmenuupload/app_libmenuupload");
        } catch (Exception e) {
//            mav.addObject("positionWithoutRecipeUploadError", "Внутренняя ошибка сервера");
        }
        return mav;
    }

    @RequestMapping(value = "/addPositionWithRecipe", method = RequestMethod.POST)
    public int addPositionWithRecipe(@RequestParam("position") MenuPositionRecipe position, @RequestParam("spotId") int spotId) {
        return dao.addPositionWithRecipe(position, spotId);
    }

    @RequestMapping(value = "/removePosition", method = RequestMethod.POST)
    public int removePosition(@RequestParam("positionId") int positionId, @RequestParam("spotId") int spotId) {
        return dao.removePositionById(positionId, spotId);
    }

    @RequestMapping(value = "/ingredientsShowAll", method = RequestMethod.POST)
    public List<Ingredient> showIngredients(HttpServletRequest request) {
        return dao.ingredientsShowAll(request.getRemoteAddr());
    }

    @RequestMapping(value = "/ingredientsShowByNamePart", method = RequestMethod.POST)
    public List<Ingredient> showIngredientsByNamePart(@RequestParam("namePart") String namePart, HttpServletRequest request) {
        return dao.ingredientsShowByNamePart(namePart, request.getRemoteAddr());
    }

    @RequestMapping(value = "/getRecipeByPositionId", method = RequestMethod.POST)
    public MenuPositionRecipe getRecipeByPositionId(@RequestParam("positionId") int positionId, @RequestParam("spotId") int spotId, HttpServletResponse response) {
        return dao.recipeGetById(positionId, spotId, response);
    }

    @RequestMapping(value = "/removeRecipeById", method = RequestMethod.POST)
    public int removeRecipe(@RequestParam("recipeId") int recipeId, @RequestParam("spotId") int spotId) {
        return dao.removeRecipeById(recipeId, spotId);
    }

    @RequestMapping(value = "/removeIngrFromRecipe", method = RequestMethod.POST)
    public int addIngrToRecipe(@RequestParam("ingrId") int ingrId, @RequestParam("ingrQuantity") double ingrQuantity, @RequestParam("ingrUnits") String ingrUnits, @RequestParam("positionId") int positionId, @RequestParam("spotId") int spotId) {
        return dao.addIngrToRecipe(ingrId, ingrQuantity, ingrUnits, positionId, spotId);
    }

    @RequestMapping(value = "/addIngrsToRecipe", method = RequestMethod.POST)
    public int removeIngrFromRecipe(@RequestParam("ingredientId") int ingrId, @RequestParam("positionId") int positionId, @RequestParam("spotId") int spotId) {
        return dao.removeIngrFromRecipe(ingrId, positionId, spotId);
    }


}