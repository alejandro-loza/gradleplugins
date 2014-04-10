package com.training.gradleplugins.core;// default package
// Generated 10/04/2014 12:23:33 PM by Hibernate Tools 3.4.0.CR1

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@NamedQueries({
        @NamedQuery(
                name = "com.training.gradleplugins.core.Item.findAll",
                query = "SELECT i FROM Item i"
        )
        ,
        @NamedQuery(
                name = "com.training.gradleplugins.core.Item.findById",
                query = "SELECT i FROM Item i WHERE i.id = :id"
        )
})
@Entity
@Table(name = "item", catalog = "winbits")

public class Item implements java.io.Serializable {

	private Long id;
	private long version;
//	private AttributeType attributeType;
//	private ItemStatus itemStatus;
	private ItemGroup itemGroup;
	private String attributeLabel;
	private String attributeName;
	private String attributeValue;
	private Date dateCreated;
	private boolean deleted;
	private Date lastUpdated;
	private int priority;
//	private Set<Image> images = new HashSet<Image>(0);
//	private Set<Sku> skus = new HashSet<Sku>(0);

	public Item() {
	}

	public Item(
//            AttributeType attributeType, ItemStatus itemStatus,
			ItemGroup itemGroup, String attributeLabel, String attributeName,
			String attributeValue, Date dateCreated, boolean deleted,
			Date lastUpdated, int priority) {
//		this.attributeType = attributeType;
//		this.itemStatus = itemStatus;
		this.itemGroup = itemGroup;
		this.attributeLabel = attributeLabel;
		this.attributeName = attributeName;
		this.attributeValue = attributeValue;
		this.dateCreated = dateCreated;
		this.deleted = deleted;
		this.lastUpdated = lastUpdated;
		this.priority = priority;
	}

/*	public Item(
//            AttributeType attributeType, ItemStatus itemStatus,
			ItemGroup itemGroup, String attributeLabel, String attributeName,
			String attributeValue, Date dateCreated, boolean deleted,
			Date lastUpdated, int priority//,
//            Set<Image> images, Set<Sku> skus
    ) {
//		this.attributeType = attributeType;
//		this.itemStatus = itemStatus;
		this.itemGroup = itemGroup;
		this.attributeLabel = attributeLabel;
		this.attributeName = attributeName;
		this.attributeValue = attributeValue;
		this.dateCreated = dateCreated;
		this.deleted = deleted;
		this.lastUpdated = lastUpdated;
		this.priority = priority;
//		this.images = images;
//		this.skus = skus;
	}*/

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Version
	@Column(name = "version", nullable = false)
	public long getVersion() {
		return this.version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "attribute_type_id", nullable = false)
//	public AttributeType getAttributeType() {
//		return this.attributeType;
//	}
//
//	public void setAttributeType(AttributeType attributeType) {
//		this.attributeType = attributeType;
//	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "status_id", nullable = false)
//	public ItemStatus getItemStatus() {
//		return this.itemStatus;
//	}
//
//	public void setItemStatus(ItemStatus itemStatus) {
//		this.itemStatus = itemStatus;
//	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_group_id", nullable = false)
	public ItemGroup getItemGroup() {
		return this.itemGroup;
	}

	public void setItemGroup(ItemGroup itemGroup) {
		this.itemGroup = itemGroup;
	}

	@Column(name = "attribute_label", nullable = false, length = 25)
	public String getAttributeLabel() {
		return this.attributeLabel;
	}

	public void setAttributeLabel(String attributeLabel) {
		this.attributeLabel = attributeLabel;
	}

	@Column(name = "attribute_name", nullable = false, length = 25)
	public String getAttributeName() {
		return this.attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	@Column(name = "attribute_value", nullable = false)
	public String getAttributeValue() {
		return this.attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_created", nullable = false, length = 0)
	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Column(name = "deleted", nullable = false)
	public boolean isDeleted() {
		return this.deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_updated", nullable = false, length = 0)
	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Column(name = "priority", nullable = false)
	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
//	public Set<Image> getImages() {
//		return this.images;
//	}
//
//	public void setImages(Set<Image> images) {
//		this.images = images;
//	}
//
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
//	public Set<Sku> getSkus() {
//		return this.skus;
//	}
//
//	public void setSkus(Set<Sku> skus) {
//		this.skus = skus;
//	}

}
