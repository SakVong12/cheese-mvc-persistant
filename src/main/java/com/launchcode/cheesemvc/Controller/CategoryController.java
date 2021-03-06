package com.launchcode.cheesemvc.Controller;

import com.launchcode.cheesemvc.Model.Category;
import com.launchcode.cheesemvc.Model.data.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "category")
public class CategoryController {

    @Autowired
    private CategoryDAO categoryDao;

    @RequestMapping(value = "") // /category/
    public String index(Model templateVariables) {
        templateVariables.addAttribute("title", "All Categories");
        templateVariables.addAttribute("categories", categoryDao.findAll());
        return "category/index";
    }

    @RequestMapping(value = "add") // /category/add
    public String add(Model templateVariables) {
        templateVariables.addAttribute("title", "Add Category");
        templateVariables.addAttribute("category", new Category());
        return "category/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(
            Model templateVariables,
            @ModelAttribute @Valid Category category,
            Errors errors
    ) {
        if (errors.hasErrors()) return "category/add";
        categoryDao.save(category);
        return "redirect:";
    }
}