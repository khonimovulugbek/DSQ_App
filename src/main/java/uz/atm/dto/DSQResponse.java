package uz.atm.dto;

/**
 * Author : Khonimov Ulugbek
 * Date : 28.11.2022
 * Time : 2:23 PM
 */

public class DSQResponse<T> {
    public T body;

    public AppErrorDto error;

    public boolean isUnAuthorized;

    public DSQResponse(T body) {
        this.body = body;
        this.isUnAuthorized = false;
    }

    public DSQResponse(boolean isUnAuthorized) {
        this.isUnAuthorized = isUnAuthorized;
    }

    public DSQResponse(T body, boolean isUnAuthorized) {
        this.body = body;
        this.isUnAuthorized = isUnAuthorized;
    }

    public DSQResponse(AppErrorDto error, boolean isUnAuthorized) {
        this.error = error;
        this.isUnAuthorized = isUnAuthorized;
    }

    public DSQResponse(AppErrorDto error) {
        this.error = error;
    }
}




