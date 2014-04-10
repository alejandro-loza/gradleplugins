package com.training.gradleplugins.core

import org.hibernate.annotations.ManyToAny
import org.hibernate.metamodel.relational.state.ManyToOneRelationalState
import org.joda.time.DateTime

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.MapsId
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table
import javax.persistence.Version
import javax.validation.constraints.NotNull


@Entity
@Table(name = 'item_group_profile')
@NamedQueries([
        @NamedQuery(
                name = "com.training.gradleplugins.core.ItemGroupProfile.findAll",
                query = "SELECT i FROM ItemGroupProfile i"
        )

])

class ItemGroupProfile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Version
    @Column(nullable = false)
    Long version = 0

    @NotNull
    @Column(name = 'name', nullable = false)
    String name

    @NotNull
    @Column(name = 'short_description', nullable = false)
    String shortDescription

    @NotNull
    @Column(name = 'long_description', nullable = false)
    String longDescription

    @NotNull
    @Column(name = 'conditions', nullable = false)
    String conditions

    @NotNull
    @Column(name = 'details', nullable = false)
    String details

    @NotNull
    @Column(name = 'max_per_order', nullable = false)
    Integer maxPerOrder = 1

    @NotNull
    @Column(name = 'max_per_user', nullable = false)
    Integer maxPerUser = -1

    @NotNull
    @Column(name = 'min_per_order', nullable = false)
    Integer minPerOrder = 1

    @NotNull
    @Column(name = 'active_start', nullable = false)
    DateTime activeStart

    @NotNull
    @Column(name = 'active_end', nullable = false)
    DateTime activeEnd

    @NotNull
    @Column(name = 'status_id', nullable = false)
    Long status

    @Column(name = 'date_created', nullable = false)
    DateTime dateCreated

    @Column(name = 'last_updated', nullable = false)
    DateTime lastUpdated

    @Column(name = 'deleted', nullable = false)
    Boolean deleted = false


    @Column(name = 'marketing_sale', nullable = false)
    Boolean marketingSale = false


    @Column(name = 'vertical_id',nullable = false)
    Long vertical

//
    @MapsId @ManyToOne
    @JoinColumn(name = "item_group_id", nullable = false)
//    @Column(name = 'item_group_id', nullable = false)
    ItemGroup itemGroup
//  static belongsTo = [itemGroup: ItemGroup]
//  static hasMany = [skuProfiles: SkuProfile]
    @Column(name = 'cashback', nullable = false)
    BigDecimal cashback = 0


}
