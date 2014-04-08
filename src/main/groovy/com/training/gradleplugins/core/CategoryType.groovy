package com.training.gradleplugins.core

import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.Version
import javax.validation.constraints.NotNull


@Entity
@Embeddable
@Table(name = 'category_type')
class CategoryType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Version
    @Column(nullable = false)
    Long version = 0

    @NotNull
    @Column(nullable = false, name = 'name')
    String name

    @Column(nullable = false, name = 'description')
    String description



}
