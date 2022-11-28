package uz.atm.exceptions;

import org.springframework.core.NestedRuntimeException;

/**
 * Author: Shoxruh Bekpulatov
 * Time: 10/26/22 3:21 PM
 **/
public class InvalidTokenException extends NestedRuntimeException {
    public InvalidTokenException(String msg) {
        super(msg);
    }
}
