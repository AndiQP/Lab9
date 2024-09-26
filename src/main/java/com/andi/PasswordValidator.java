package com.andi;


public class PasswordValidator {

    private NotificationService ns;

    //Void constructor
    public PasswordValidator(){
    }

    //Constructor with NotificationService parameter
    public PasswordValidator(NotificationService ns){
        this.ns = ns;
    }

    //Getter & Setter
    public NotificationService getNs() {
        return ns;
    }
    public void setNs(NotificationService ns) {
        this.ns = ns;
    }

    //Methods

    public boolean isValidPassword(String password){

        boolean uppercase = false;

        //Refactor: To handle null and empty strings
        if(password==null || password.equals(""))
            return false;

        // To check for the uppercase Letter(included the spanish letter 'Ñ')
        for(int i = 0; i < password.length(); i++){
            if((password.toCharArray()[i] >= 'A' && password.toCharArray()[i] <= 'Z') || password.toCharArray()[i] == 'Ñ')
                uppercase = true;
        }

        if(password.length()>=8 && uppercase)
            ns.sendNotification("Congrats! Your password is validated");
        else ns.sendNotification("You can't use this password!");

        //To check the length
        return password.length()>=8 && uppercase;
    }
}
