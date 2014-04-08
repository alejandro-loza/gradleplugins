package com.training.gradleplugins.core

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.Version
import javax.validation.constraints.NotNull

@Entity
@Table(name = 'item_type')
class ItemType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Version
    @Column(nullable = false)
    Long version = 0

    @NotNull
    @Column(name = 'name', nullable = false, unique = true)
    String name

    @Column(name = 'description')
    String description

}
