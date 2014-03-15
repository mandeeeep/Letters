package com.letters.controllers;

import com.letters.dao.LetterDAO;
import com.letters.models.Letter;
import com.letters.template.LetterTemplate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Mandeep Raj Shrestha
 */
@Controller
public class LetterController {

    LetterDAO letterDao;
    @Autowired
    LetterTemplate letterTemplate;

    @RequestMapping("/")
    public String list(ModelMap model) {
        List<Letter> letters = letterTemplate.list();
        model.addAttribute("letters", letters);
        return "view";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") String id, ModelMap model) {
        letterTemplate.delete(Integer.parseInt(id));
        return "redirect:/";
    }
}
