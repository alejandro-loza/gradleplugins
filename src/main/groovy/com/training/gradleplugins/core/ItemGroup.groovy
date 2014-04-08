package com.training.gradleplugins.core

import org.joda.time.DateTime

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.MapsId
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery
import javax.persistence.OneToOne
import javax.persistence.Table
import javax.persistence.Version
import javax.validation.constraints.NotNull


@Entity
@Table(name = 'item_group')
@NamedQueries([
        @NamedQuery(
                name = "com.training.gradleplugins.core.ItemGroup.findAll",
                query = "SELECT i FROM ItemGroup i"
        )

])
class ItemGroup implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Version
    @Column(nullable = false)
    Long version = 0

    @NotNull
    @Column(name = 'active_start',nullable = false)
    DateTime activeStart

    @Column(name = 'active_end',nullable = true)
    DateTime activeEnd


    @Column(name = 'date_created',nullable = false)
    DateTime dateCreated

    @Column(name = 'last_updated',nullable = false)
    DateTime lastUpdated

    @Column(name = 'status_id',nullable = false)
    Long status
    @Column(name = 'delivery_date_type_id',nullable = true)
    Long deliveryDateType

    @Column(name = 'delivery_date_days',nullable = true)
    Integer deliveryDateDays

    @Column(name = 'income_type_id',nullable = false)
    Long incomeType

    @Column(name = 'deleted',nullable = false)
    Boolean deleted = false
    @Column(name = 'requires_shipping',nullable = false)
    Boolean requiresShipping = false

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }
    @Column(name = 'model',nullable = false)
    String model

    @Column(name = 'vertical_marketing_type_id',nullable = false)
    Long verticalMarketingType

    @Column(name = 'sales_department_type_id',nullable = false)
    Long salesDepartmentType

    @Column(name = 'category_type_id',nullable = false)
    Long categoryType

    @Column(name = 'sub_category_type_id',nullable = false)
    Long subCategoryType

    @Column(name = 'item_type_id',nullable = false)
    Long itemType
    @Column(name = 'seller_id',nullable = false)
    Long seller


//    @Embedded
//    @AttributeOverrides(
//            @AttributeOverride(name="vertical", column = @Column(name="vertical_id") )
//    )
//    Vertical vertical
    @MapsId @ManyToOne
    @JoinColumn(name = "vertical_id")
    Vertical vertical


    @Column(name = 'provider_id',nullable = false)
    Long provider


    @MapsId @ManyToOne
    @JoinColumn(name = "brand_id",nullable = false)
    Brand brand

//    @Column(name = 'ref',nullable = false)
//  String ref
    ItemGroup() {
    }
//  static transients = ['ref', 'avaliable', 'available', 'defaultProfile']
//  static hasMany = [paymentMethodExclusions: PaymentMethod, items: Item, itemGroupProfiles: ItemGroupProfile]
//
//  static constraints = {
//    activeEnd nullable: true
////    activeStart validator: {it > DateTime.now()}
//    deliveryDateType nullable: true
//    deliveryDateDays nullable: true, min: 0
//  }



}
