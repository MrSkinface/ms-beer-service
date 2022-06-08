package ua.mike.micro.beerservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by mike on 08.06.2022 10:29
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class UniqueConstraintException extends RuntimeException {

    public UniqueConstraintException(String message) {
        super(message);
    }
}
