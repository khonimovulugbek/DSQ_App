package uz.atm.dto.enums;

/**
 * Author : Khonimov Ulugbek
 * Date : 28.11.2022
 * Time : 2:25 PM
 */

public enum Session {

    INSTANCE;
    String value;

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}




