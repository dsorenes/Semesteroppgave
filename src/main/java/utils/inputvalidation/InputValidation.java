package utils.inputvalidation;

import utils.exceptions.*;

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

    public static boolean checkName(String name) throws InvalidNameException {

        if (name.length() < 3) {

            throw new InvalidNameException("A name can not be shorter that 3 characters");

        }

        if (name.matches("[0-9]")) {

            throw new InvalidNameException("Only letters are allowed");

        }

        if (name.length() > 20) {

            throw new InvalidNameException("A name can not be longer that 20 characters");

        }

        return true;

    }

    public static boolean checkNumber(String number) throws InvalidNumberException {

        if (!number.matches("-?\\d+(\\.\\d+)?")) {

            throw new InvalidNumberException("Invalid number");

        }

        return true;

    }

    public static boolean checkAddress(String address) throws InvalidAddressException {

        if (address.split(" ").length>2) {

            throw new InvalidAddressException("Invalid adress");
        }

        if (!address.matches("[A-Za-z0-9'\\.\\-\\s\\,]\n")) {

            throw new InvalidAddressException("Invalid adress");

        }

        return true;

    }

}
