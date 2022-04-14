package io.jmix.petclinic.screen.visit.visitlog;

import io.jmix.core.SaveContext;
import io.jmix.petclinic.app.visit.VisitLogService;
import io.jmix.ui.screen.*;
import io.jmix.petclinic.app.visit.VisitLog;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@UiController("petclinic_VisitLog.edit")
@UiDescriptor("visit-log-edit.xml")
@EditedEntityContainer("visitLogDc")
public class VisitLogEdit extends StandardEditor<VisitLog> {

    @Autowired
    VisitLogService visitLogService;

    @Install(target = Target.DATA_CONTEXT)
    private Set<Object> commitDelegate(SaveContext saveContext) {
        visitLogService.saveLogEntry(getEditedEntity());
        return Set.of(getEditedEntity());
    }
}