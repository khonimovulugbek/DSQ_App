package uz.atm.model.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 09:52
 */

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable implements BaseEntity, Serializable {

    @Serial
    private static final long serialVersionUID = 7156526077883281623L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP default NOW()")
    private LocalDateTime createdAt;

}
