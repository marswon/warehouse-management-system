package com.repertory.controller;

import com.repertory.bean.UsersEntity;
import com.repertory.dao.ItemDao;
import com.repertory.dao.UsersDao;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by Finderlo on 2016/11/5.
 */
@Controller
public class LoginController {

    @RequestMapping("/logincheck")
    String logincheck(@Valid UsersEntity usersEntity , Model model, HttpSession session){
        UsersDao usersDao = new UsersDao();
        if (usersDao.checkLogin(usersEntity)){
            UsersEntity users = usersDao.queryById(usersEntity.getUsersId());
            model.addAttribute("users",users);
            return "home";
        }else {
            return "error";
        }

    }

}
