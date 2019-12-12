package com.thyme.thymepagination.controller;


import com.thyme.thymepagination.models.User;
import com.thyme.thymepagination.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/user")
public class HomeController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public String Index() {
        return "home";
    }


    @GetMapping(value = "/add")
    public ModelAndView getAddUserPage(Model model) {
        ModelAndView modelAndView = new ModelAndView("index");
        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new User());
        }
        //getting genders
        List<String> genList = HomeController.getGenders();
        modelAndView.addObject("genders", genList);
        return modelAndView;
    }

    @PostMapping(value = "/save")
    //BindResult will catch Model Error
    public ModelAndView saveUser(@Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView;

        if (result.hasErrors()) {
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.User",result);
//            redirectAttributes.addFlashAttribute("user",user);
//            return "redirect:/user/add";
            modelAndView = new ModelAndView("index");
            modelAndView.addObject("user", user);
            modelAndView.addObject("genders", HomeController.getGenders());
            return modelAndView;

        } else {
            //   redirectAttributes.addFlashAttribute("flash",new FlashMessage("user successfully added!", FlashMessage.Status.SUCCESS));
            modelAndView = new ModelAndView("viewAllUser");
            userService.saveUser(user);
            //getting all users
            List<User> users = userService.getAllUser();
            modelAndView.addObject("msg", "User added Successfully!!!!!");
            modelAndView.addObject("allUser", users);
            return modelAndView;
        }
    }

    @GetMapping(value = "/getAll")
    public ModelAndView getAllUser(Model model,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(name = "sorter", required = false, defaultValue = "id") String sortBy) {
        ModelAndView modelAndView = new ModelAndView("viewAllUser");
        //getting all users
        Page<User> users = userService.getAllUser(PageRequest.of(page, 2, Sort.Direction.ASC, sortBy));
        //List<User> users = userService.getAllUser();
        modelAndView.addObject("allUser", users);
        modelAndView.addObject("currentPage", page);
        //debug
        System.out.println("Page_NO : " + page);
        return modelAndView;
    }

    @GetMapping(value = "delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("viewAllUser");
        //deleting user
        userService.deleteUser(id);
        //getting all users
        List<User> users = userService.getAllUser();
        modelAndView.addObject("allUser", users);
        return modelAndView;
    }

    public static List<String> getGenders() {
        List<String> genList = new ArrayList<>();
        genList.add("Male");
        genList.add("Female");
        return genList;
    }


}