package uz.atm.services.dsqService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author : Khonimov Ulugbek
 * Date : 28.11.2022
 * Time : 2:41 PM
 */

public abstract class AbstractService<R extends JpaRepository> {

    protected R repository;

    protected ObjectMapper mapper = new ObjectMapper();

    protected ModelMapper modelMapper = new ModelMapper();

    public AbstractService(R repository) {
        this.repository = repository;
    }

}





