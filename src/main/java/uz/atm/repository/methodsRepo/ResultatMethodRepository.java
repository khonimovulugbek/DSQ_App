package uz.atm.repository.methodsRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.atm.model.methods.resultat.ResultatMethod;

import java.util.Optional;

@Repository
public interface ResultatMethodRepository extends JpaRepository<ResultatMethod, Long> {

    @Query(value = "select rm.* from resultat_method rm where rm.lot_id = :lotId order by rm.request_id desc limit 1;", nativeQuery = true)
    Optional<ResultatMethod> findByPayload_LotId(Long lotId);
}
