package model.inputvalidation;

import model.exceptions.*;

public class InputValidation {




    public static boolean checkEmail(String email) throws InvalidEmailException {

        String[] splitAlpha = email.split("@");

        if (splitAlpha.length != 2) {

            throw new InvalidEmailException("Invalid Email");

        }

        if (    !splitAlpha[1].contains(".") || splitAlpha[1].contains("..") ||
                splitAlpha[0].contains("..") || splitAlpha[1].contains("@")) {

            throw new InvalidEmailException("Invalid Email");

        }

        String[] splitDomain = splitAlpha[1].split(".");

        if (splitDomain.length > 0 && splitDomain[splitDomain.length - 1].contains("[0-9]")) {

            throw new InvalidEmailException(splitDomain[splitDomain.length - 1 ] + "Invalid Email");

        }

        return true;

    }



}
