package io.jmix.petclinic.app.visit;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.JmixId;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.JmixProperty;
import io.jmix.core.metamodel.annotation.Store;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@DynamoDBTable(tableName = "visit-logs")
@JmixEntity(name = "petclinic_VisitLog", annotatedPropertiesOnly = true)
public class VisitLog {

    @JmixProperty
    @JmixGeneratedValue
    @JmixId
    private UUID id;

    @JmixProperty(mandatory = true)
    @NotNull
    private UUID visitId;

    @JmixProperty
    private String title;

    @InstanceName
    @JmixProperty
    private String description;

    @DynamoDBAttribute
    public UUID getVisitId() {
        return visitId;
    }

    public void setVisitId(UUID visitId) {
        this.visitId = visitId;
    }

    @DynamoDBAttribute
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @DynamoDBAttribute
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}