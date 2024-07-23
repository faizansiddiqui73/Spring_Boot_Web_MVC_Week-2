package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<PasswordValidation, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if (password == null) {
            return false;
        } else {
            boolean checkPassword = isValidPassword(password);
            return checkPassword;
        }
    }

    private boolean isValidPassword(String password) {
        /*
        a. contains one uppercase letter
        b. contains one lowercase letter
        c. contains one special character
        d. minimum length is 10 characters
         */
        boolean hasUppercCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialCharacter = false;
        String specialCharacters = "!@#$%^&*()-+";

        if (password.length() < 10) {
            return false;
        }
        char[] c = password.toCharArray();
        for (char c1 : c) {
            if (Character.isUpperCase(c1)) {
                hasUppercCase = true;
            } else if (Character.isLowerCase(c1)) {
                hasLowerCase = true;
            } else if (specialCharacters.indexOf(c1) >= 0) {
                hasSpecialCharacter = true;
            }
            //early exit if all condition met true
            if (hasUppercCase && hasLowerCase && hasSpecialCharacter) {
                return true;
            }
        }
        return hasUppercCase && hasLowerCase && hasSpecialCharacter;

    }
}
       /* public static boolean isValidPassword(String password) {
            if (password.length() < 10) {
                return false;
            }

            String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);

            return matcher.matches();
        }
    }*/
