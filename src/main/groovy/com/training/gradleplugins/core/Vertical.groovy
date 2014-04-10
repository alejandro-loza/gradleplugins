package com.training.gradleplugins.core

import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery
import javax.persistence.Table

@Entity
@Embeddable
@Table(name = 'vertical')
@NamedQueries([
        @NamedQuery(
                name = "com.training.gradleplugins.core.Vertical.findAll",
                query = "SELECT v FROM Vertical v"
        )
])
class Vertical  implements Serializable{

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= 'id')
    Long id

    @JsonIgnore
    @Column(nullable = false)
    Long version = 0


    @Column(name = 'name', nullable = false, unique = true)
    String name
    @Column(name = 'base_url', nullable = false, unique = true)
    String baseUrl

    @Column(name = 'logo', nullable = true)
    String logo

    @Column(name = 'max_per_vertical', nullable = false)
    BigDecimal maxPerVertical = 0.0

}