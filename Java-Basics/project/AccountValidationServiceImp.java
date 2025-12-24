package service;

public class AccountValidationServiceImp implements AccountValidationService {

    @Override
    public boolean usernameValidation(String username){
        if(username.length()<3){
            System.out.println("username should be greater than 3 letters");
            return false;
        }
        char firstChar = username.charAt(0);
        if(firstChar>='A' && firstChar<='Z'){
            System.out.println("username should start with capital letter");
            return false;
        }

    return true;
    }

    @Override
    public boolean passwordValidation(String password){
        if(password.length()<8){
            System.out.println("password should be greater than 8 letters");
            return false;
        }
        if (!(password.contains("@")||password.contains("!")||password.contains("#")||password.contains("&"))){
            System.out.println("the password should have special letters");
            return false;
        }

        boolean hasDigit = false;
        for (int i = 0;i<password.length();i++){
            if(Character.isDigit(password.charAt(i))){
                hasDigit = true;
                break;
            }
        }

        if (!hasDigit){
            System.out.println("the password should have digits");
            return false;

        }
        return true;

    }


    @Override
    public boolean ageValidation(int age){
        if (age<18){
            System.out.println("the age should be greater than 18");
            return false;
        }
        return true;

    }

    @Override
    public boolean phonenumberValidation(String phonenumber){
        if (!phonenumber.startsWith("20")){
            System.out.println("phonenumber should start with Egypt format");
            return false;
        }

        boolean isDigit = true;
        for (int i = 0;i<phonenumber.length();i++){
            if(!Character.isDigit(phonenumber.charAt(i))){
                isDigit = false;
                break;
            }
        }
        if (!isDigit){
            System.out.println("the phonenumber should be digit only");
            return false;
        }
        return true;
    }


}

