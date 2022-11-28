package uz.atm.exceptions;

import org.springframework.core.NestedRuntimeException;

/**
 * Author: Shoxruh Bekpulatov
 * Time: 11/1/22 4:15 PM
 **/
public class DsqException extends NestedRuntimeException {
    public DsqException(String msg) {
        super(msg);
    }
}
