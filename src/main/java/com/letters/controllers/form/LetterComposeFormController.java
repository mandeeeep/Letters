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
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author Mandeep Raj Shrestha
 */
@Controller
@RequestMapping("/add")
public class LetterComposeFormController {

    LetterValidator letterValidator;
    @Autowired
    LetterTemplate letterTemplate;

    @Autowired
    public LetterComposeFormController(LetterValidator letterValidator) {
        this.letterValidator = letterValidator;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(
            @ModelAttribute("letter") Letter letter,
            BindingResult result, SessionStatus status) {

        letterValidator.validate(letter, result);

        if (result.hasErrors()) {
            //if validator failed
            return "add";
        } else {
            status.setComplete();
            letterTemplate.insert(letter);
            //form success
            return "redirect:/";
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(ModelMap model) {

        Letter lett = new Letter();

        //Make "Insert TO" as default radio button selected value
        lett.setTo("Insert TO");
        //Make "Insert FROM" as default radio button selected value
        lett.setFrom("Insert FROM");
        //Make "Insert SUBJECT" as default radio button selected value
        lett.setSubject("Insert SUBJECT");
        //Make "Insert BODY" as default radio button selected value
        lett.setBody("Insert BODY");

        //command object
        model.addAttribute("letter", lett);

        //return form view
        return "add";
    }

}
