package io.jmix.petclinic.screen.visit.visitlog;

import io.jmix.core.Metadata;
import io.jmix.petclinic.app.visit.VisitLogService;
import io.jmix.petclinic.entity.visit.Visit;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.screen.*;
import io.jmix.petclinic.app.visit.VisitLog;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@UiController("petclinic_VisitLog.browse")
@UiDescriptor("visit-log-browse.xml")
@LookupComponent("visitLogsTable")
public class VisitLogBrowse extends StandardLookup<VisitLog> {

    private Visit visit;
    @Autowired
    private CollectionContainer<VisitLog> visitLogsDc;
    @Autowired
    private VisitLogService visitLogService;
    @Autowired
    private Metadata metadata;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        visitLogsDc.setItems(
            visitLogService.findByVisit(visit)
        );
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    @Install(to = "visitLogsTable.create", subject = "newEntitySupplier")
    private VisitLog visitLogsTableCreateNewEntitySupplier() {
        final VisitLog visitLog = metadata.create(VisitLog.class);
        visitLog.setVisitId(visit.getId());
        return visitLog;
    }
}