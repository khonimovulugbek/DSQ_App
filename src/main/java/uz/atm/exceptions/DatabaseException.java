package uz.atm.exceptions;

/**
 * Author: Shoxruh Bekpulatov
 * Time: 10/26/22 3:10 PM
 **/
public class DatabaseException extends RuntimeException {
    public DatabaseException(String message) {
        super(message);
    }
}
