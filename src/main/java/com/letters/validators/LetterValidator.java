package com.letters.validators;

import com.letters.models.Letter;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Mandeep Raj Shrestha
 */
public class LetterValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        //just validate the Customer instances
        return Letter.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "to",
                "required.to", "TO field name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "from",
                "required.from", "FROM field is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject",
                "required.subject", "SUBJECT field name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "body",
                "required.body", "BODY field name is required.");

    }

}
