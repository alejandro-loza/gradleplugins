package com.training.gradleplugins.core

import org.joda.time.DateTime

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery
import javax.persistence.Table

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
class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @Column(nullable = false)
    Integer priority

    @Column(name = 'attribute_name', nullable = false)
    String attributeName

    @Column(name = 'attribute_label', nullable = false)
    String attributeLabel

    @Column(name = 'attribute_value', nullable = false)
    String attributeValue

    @Column(name = 'attribute_type_id', nullable = false)
    Long attributeTypeId

    @Column(name = 'date_created', nullable = false)
    DateTime dateCreated

    @Column(name = 'last_updated', nullable = false)
    DateTime lastUpdated

    @Column(name = 'deleted', nullable = false)
    Boolean deleted = false

    @Column(name = 'item_group_id', nullable = false)
    Long itemGroupId

    @Column(name = 'status_id', nullable = false)
    Long statusId
}
