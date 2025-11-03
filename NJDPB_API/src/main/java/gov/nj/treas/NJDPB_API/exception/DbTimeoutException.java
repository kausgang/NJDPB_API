package gov.nj.treas.NJDPB_API.exception;

import java.util.concurrent.TimeoutException;

public class DbTimeoutException extends TimeoutException {
    public DbTimeoutException(String message) {
        super(message);
    }
}
