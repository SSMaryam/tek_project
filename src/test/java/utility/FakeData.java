package utility;

public class FakeData {
    public static String emailAddress(String firstName, String lastName){
        int random = (int)(Math.random()*10000);
        return firstName + lastName + random + "@gmail.com";
    }
}
