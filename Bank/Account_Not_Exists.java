package Bank;

class Account_Not_Exists extends Exception{
    public Account_Not_Exists(String message){
        super(message);
    }
}
