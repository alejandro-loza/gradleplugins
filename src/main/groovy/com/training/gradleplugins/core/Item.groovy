package com.training.gradleplugins.core

import com.fasterxml.jackson.annotation.JsonIgnore
import org.joda.time.DateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery
import javax.persistence.Table
import javax.validation.constraints.NotNull
import java.sql.Timestamp

@Entity
@Table(name = 'item')
@NamedQueries([
        @NamedQuery(
                name = "com.training.gradleplugins.core.Item.findAll",
                query = "SELECT i FROM Item i"
        ),
        @NamedQuery(
                name = "com.training.gradleplugins.core.Item.findById",
                query = "SELECT i FROM Item i WHERE i.id = :id"
        )
])
class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Column(nullable = false)
    Long version = 0

    @NotNull
    @Column(nullable = false)
    Integer priority

    @NotNull
    @Column(name = 'attribute_name', nullable = false)
    String attributeName

    @NotNull
    @Column(name = 'attribute_label', nullable = false)
    String attributeLabel

    @NotNull
    @Column(name = 'attribute_value', nullable = false)
    String attributeValue

    @Column(name = 'attribute_type_id', nullable = false)
    Long attributeTypeId = 1L

    @Column(name = 'date_created', nullable = false)
    DateTime dateCreated = DateTime.now()

    @Column(name = 'last_updated', nullable = false)
    DateTime lastUpdated = DateTime.now()

    @Column(name = 'deleted')
    Boolean deleted = false

    @NotNull
    @Column(name = 'item_group_id', nullable = false)
    Long itemGroupId

    @Column(name = 'status_id', nullable = false)
    Long statusId = 1L

    @JsonIgnore
    Date getNormalDateCreated() {
      dateCreated?.toDate()
    }

    void setNormalDateCreated(Date date) {
        dateCreated = new DateTime(date.time)
    }
//    void setNormalDateCreated(DateTime date) {
//        dateCreated = new Timestamp(date.getMillis()) as DateTime
//    }

    @JsonIgnore
    Date getNormalLastUpdated() {
        lastUpdated?.toDate()
    }

    void setLastUpdated(Date date) {
        lastUpdated = new DateTime(date.time)
    }
//    void setLastUpdated(DateTime date) {
//        lastUpdated = new Timestamp(date.getMillis()) as DateTime
//    }
}
