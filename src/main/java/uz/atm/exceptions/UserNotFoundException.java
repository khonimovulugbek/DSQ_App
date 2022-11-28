package uz.atm.exceptions;

import lombok.NoArgsConstructor;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 11:16
 */
@NoArgsConstructor
public class UserNotFoundException extends RuntimeException {
    private String message;

    public UserNotFoundException(String message) {
        this.message = message;
    }
}
