package uz.atm.dto;

import lombok.*;

/**
 * Author : Khonimov Ulugbek
 * Date : 28.11.2022
 * Time : 2:27 PM
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DsqError {

    private String path;

    private String error;

    private Long timestamp;

    private Integer status;
}





