package com.atdc.spring05.controller;

import com.atdc.spring05.mapper.PictureMapper;
import com.atdc.spring05.pojo.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class PictureController {
    @Autowired
    PictureMapper pictureMapper;
    @RequestMapping("/list")
    public String list(Model model) {
        Collection<Picture> allpicature =pictureMapper.queryPictureList();
        model.addAttribute("emps", allpicature);
        return "list";
    }
}
