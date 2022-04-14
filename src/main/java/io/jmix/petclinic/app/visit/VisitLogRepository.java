package io.jmix.petclinic.app.visit;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

@EnableScan
public interface VisitLogRepository extends CrudRepository<VisitLog, UUID> {

    List<VisitLog> findByVisitId(UUID visitId);
}