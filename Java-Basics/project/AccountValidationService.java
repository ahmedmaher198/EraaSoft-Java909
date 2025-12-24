package service;

public interface AccountValidationService {
    public boolean usernameValidation(String username);
    public boolean passwordValidation(String password);
    public boolean ageValidation(int age);
    public boolean phonenumberValidation(String phonenumber);

}
