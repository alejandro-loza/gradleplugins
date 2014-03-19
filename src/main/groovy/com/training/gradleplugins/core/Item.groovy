package com.training.gradleplugins.core

//import org.apache.commons.io.FilenameUtils
import org.joda.time.DateTime

class Item {

  Integer priority
  String attributeName
  String attributeLabel
  String attributeValue
//  ItemStatus status
  DateTime dateCreated
  DateTime lastUpdated
  Boolean deleted = false

////  AttributeType attributeType
//
//  String ref
////  SkuProfile skuProfile
//  static transients = ['ref', 'skuProfile', 'available']
//  static hasMany = [skus: Sku, images: Image]
//  static belongsTo = [itemGroup: ItemGroup]
//
//  static constraints = {
//    attributeName maxSize: 25, blank: false
//    attributeLabel maxSize: 25
//
//  }
//
//  static hibernateFilters = {
//    enabledFilter(condition: 'deleted=0', default: true)
//  }
//
//  boolean isAvailable() {
//    itemGroup.isAvailable()
//  }
//
//  def thumbnail() {
//    def thumb = images.findAll {                       d
//      it.imageType.enum == ImageTypeEnum.THUMB
//    }.min { FilenameUtils.getBaseName(it.url) }
//    thumb
//  }
}
