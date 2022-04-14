package io.jmix.petclinic.app.visit;

import io.jmix.petclinic.entity.visit.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("petclinic_VisitLogService")
public class VisitLogService {

    @Autowired
    VisitLogRepository visitLogRepository;

    public List<VisitLog> findByVisit(Visit visit) {
        return visitLogRepository.findByVisitId(visit.getId());
    }

    public void saveLogEntry(VisitLog visitLog) {
        visitLogRepository.save(visitLog);
    }
}