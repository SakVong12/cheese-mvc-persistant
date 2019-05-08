package com.launchcode.cheesemvc.Controller;


import com.launchcode.cheesemvc.Model.Category;
import com.launchcode.cheesemvc.Model.Cheese;
import com.launchcode.cheesemvc.Model.data.CategoryDAO;
import com.launchcode.cheesemvc.Model.data.CheeseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping(value = "cheese")
public class CheeseController {

    @Autowired
    private CheeseDAO cheeseDAO;

    @Autowired
    private CategoryDAO categoryDAO;

    @RequestMapping(value = "")
    public String index(Model templateStuff) {

        templateStuff.addAttribute("title", "My Cheeses");
        templateStuff.addAttribute("cheeses", cheeseDAO.findAll());
        return "cheese/index";
    }

    @RequestMapping(value= "add")
    public String displayAddForm(Model template) {
        template.addAttribute("cheese", new Cheese());
        template.addAttribute("title", "Add Cheeses");
        template.addAttribute("categories", categoryDAO.findAll());
        return "cheese/add";
    }

    @RequestMapping(value= "add", method = RequestMethod.POST)
    public String processAddForm(Model template,
                                 @ModelAttribute @Valid Cheese newCheese, Errors errors, @RequestParam int categoryId) {
        //controller + model validation
        //an opportunity to reject/rectify invalid data
        if(errors.hasErrors()){
            //handle errors accordingly
            //re-render the form
            template.addAttribute("title", "Add Cheeses");
            template.addAttribute("categories", categoryDAO.findAll());
            return "cheese/add";
        }

        Category cat = categoryDAO.findOne(categoryId);
        newCheese.setCategory(cat);
        cheeseDAO.save(newCheese);
        return "redirect:";
    }

    @RequestMapping(value = "remove")
    public String removeCheeseForm(Model templateStuff) {
        templateStuff.addAttribute("title", "Remove Cheese");
        templateStuff.addAttribute("cheeses", cheeseDAO.findAll());
        return "cheese/remove";
    }

    // for checkbox approach
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String removeCheeseHandler(@RequestParam(required = false) int[] cheeseIDs) {
        // what happens if no checkboxes are selected?
        if (cheeseIDs == null) {
            return "redirect:remove";
        }
        cheeseDAO.deleteMany(cheeseIDs);
        return "redirect:";
    }

    @RequestMapping(value = "category", method = RequestMethod.GET)
    public String category(Model model, @RequestParam int id){

        Category cat = categoryDAO.findOne(id);
        List<Cheese> cheeses = cat.getCheeses();
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "Cheeses in Category: " + cat.getName());

        return "cheese/index";
    }

}
