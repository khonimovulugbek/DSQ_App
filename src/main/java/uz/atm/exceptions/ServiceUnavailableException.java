package uz.atm.exceptions;

import org.springframework.core.NestedRuntimeException;

/**
 * Author: Shoxruh Bekpulatov
 * Time: 10/26/22 3:16 PM
 **/
public class ServiceUnavailableException extends NestedRuntimeException {
    public ServiceUnavailableException(String msg) {
        super(msg);
    }
}
