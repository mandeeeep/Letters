package com.letters.controllers.form;

import com.letters.models.Letter;
import com.letters.template.LetterTemplate;
import com.letters.validators.LetterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author Mandeep Raj Shrestha
 */
@Controller
@RequestMapping("/edit")
public class LetterEditFormController {

    LetterValidator letterValidator;
    @Autowired
    LetterTemplate letterTemplate;

    @Autowired
    public LetterEditFormController(LetterValidator letterValidator) {
        this.letterValidator = letterValidator;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(
            @ModelAttribute("letter") Letter letter,
            BindingResult result, SessionStatus status) {

        letterValidator.validate(letter, result);

        if (result.hasErrors()) {
            //if validator failed
            return "update";
        } else {
            status.setComplete();
            letterTemplate.update(letter);
            //form success
            return "redirect:/";
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(@RequestParam("id") String id,
            @ModelAttribute Letter letter, ModelMap model) {
        letter = letterTemplate.get(Integer.parseInt(id));
        model.addAttribute("letter", letter);        
        return "update";
    }

}
