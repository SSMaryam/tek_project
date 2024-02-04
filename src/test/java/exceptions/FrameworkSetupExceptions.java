package exceptions;

public class FrameworkSetupExceptions extends RuntimeException{
    public FrameworkSetupExceptions(String reason ){
        super(reason);
    }
}
