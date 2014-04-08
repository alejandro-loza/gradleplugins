package com.training.gradleplugins.core

import org.joda.time.DateTime

import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.MapsId
import javax.persistence.OneToOne
import javax.persistence.Table
import javax.persistence.Version
import javax.validation.constraints.NotNull

@Entity
@Embeddable
@Table(name = 'brand')
class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Version
    @Column(nullable = false)
    Long version = 0

    @NotNull
    @Column(name = 'name', nullable = false)
    String name


    @Column(name = 'deleted', nullable = false)
    Boolean deleted = false

    @Column(name = 'logo', nullable = true)
    String logo

    @Column(name = 'description', nullable = true)
    String description

    @Column(name = 'vertical_id', nullable = true)
    Long vertical

    @Column(name = 'date_created', nullable = false)
    DateTime dateCreated
    @Column(name = 'last_updated', nullable = false)
    DateTime lastUpdated

//  static constraints = {
//    name maxSize: 25, blank: false
//    logo url: true, nullable: true
//    description maxSize: 100, nullable: true
//  }



}
