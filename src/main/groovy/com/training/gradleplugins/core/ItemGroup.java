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
                name = "com.training.gradleplugins.core.ItemGroup.findAll",
                query = "SELECT i FROM ItemGroup i"
        )

})
@Entity

@Table(name = "item_group", catalog = "winbits")
public class ItemGroup implements java.io.Serializable {

	private Long id;
	private long version;
//	private SalesDepartmentType salesDepartmentType;
	private CategoryType categoryType;
	private Brand brand;
//	private IncomeType incomeType;
//	private Seller seller;
//	private VerticalMarketingType verticalMarketingType;
//	private Provider provider;
//	private ItemStatus itemStatus;
	private ItemType itemType;
//	private DeliveryDateType deliveryDateType;
	private Vertical vertical;
//	private SubCategoryType subCategoryType;
	private Date activeEnd;
	private Date activeStart;
	private Date dateCreated;
	private boolean deleted;
	private Integer deliveryDateDays;
	private Date lastUpdated;
	private String model;
	private boolean requiresShipping;
	private Set<Item> items = new HashSet<Item>(0);
	private Set<ItemGroupProfile> itemGroupProfiles = new HashSet<ItemGroupProfile>(
			0);
//	private Set<PaymentMethodExclusions> paymentMethodExclusionses = new HashSet<PaymentMethodExclusions>(
//			0);

	public ItemGroup() {
	}

	public ItemGroup(
			CategoryType categoryType, Brand brand,
//			Seller seller, VerticalMarketingType verticalMarketingType,
//			Provider provider, ItemStatus itemStatus,
            ItemType itemType,
			Vertical vertical,
//            SubCategoryType subCategoryType,
			Date activeStart, Date dateCreated, boolean deleted,
			Date lastUpdated, String model, boolean requiresShipping) {
//		this.salesDepartmentType = salesDepartmentType;
		this.categoryType = categoryType;
		this.brand = brand;
//		this.incomeType = incomeType;
//		this.seller = seller;
//		this.verticalMarketingType = verticalMarketingType;
//		this.provider = provider;
//		this.itemStatus = itemStatus;
		this.itemType = itemType;
		this.vertical = vertical;
//		this.subCategoryType = subCategoryType;
		this.activeStart = activeStart;
		this.dateCreated = dateCreated;
		this.deleted = deleted;
		this.lastUpdated = lastUpdated;
		this.model = model;
		this.requiresShipping = requiresShipping;
	}

	public ItemGroup(CategoryType categoryType, Brand brand,
//                     IncomeType incomeType,
//			Seller seller, VerticalMarketingType verticalMarketingType,
//			Provider provider, ItemStatus itemStatus,
            ItemType itemType,
//			DeliveryDateType deliveryDateType,
            Vertical vertical,
//			SubCategoryType subCategoryType,
            Date activeEnd, Date activeStart,
			Date dateCreated, boolean deleted, Integer deliveryDateDays,
			Date lastUpdated, String model, boolean requiresShipping,
			Set<Item> items, Set<ItemGroupProfile> itemGroupProfiles
//			Set<PaymentMethodExclusions> paymentMethodExclusionses
    ) {
//		this.salesDepartmentType = salesDepartmentType;
		this.categoryType = categoryType;
		this.brand = brand;
//		this.incomeType = incomeType;
//		this.seller = seller;
//		this.verticalMarketingType = verticalMarketingType;
//		this.provider = provider;
//		this.itemStatus = itemStatus;
		this.itemType = itemType;
//		this.deliveryDateType = deliveryDateType;
		this.vertical = vertical;
//		this.subCategoryType = subCategoryType;
		this.activeEnd = activeEnd;
		this.activeStart = activeStart;
		this.dateCreated = dateCreated;
		this.deleted = deleted;
		this.deliveryDateDays = deliveryDateDays;
		this.lastUpdated = lastUpdated;
		this.model = model;
		this.requiresShipping = requiresShipping;
		this.items = items;
		this.itemGroupProfiles = itemGroupProfiles;
//		this.paymentMethodExclusionses = paymentMethodExclusionses;
	}

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
//	@JoinColumn(name = "sales_department_type_id", nullable = false)
//	public SalesDepartmentType getSalesDepartmentType() {
//		return this.salesDepartmentType;
//	}
//
//	public void setSalesDepartmentType(SalesDepartmentType salesDepartmentType) {
//		this.salesDepartmentType = salesDepartmentType;
//	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_type_id", nullable = false)
	public CategoryType getCategoryType() {
		return this.categoryType;
	}

	public void setCategoryType(CategoryType categoryType) {
		this.categoryType = categoryType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id", nullable = false)
	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "income_type_id", nullable = false)
//	public IncomeType getIncomeType() {
//		return this.incomeType;
//	}
//
//	public void setIncomeType(IncomeType incomeType) {
//		this.incomeType = incomeType;
//	}
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "seller_id", nullable = false)
//	public Seller getSeller() {
//		return this.seller;
//	}
//
//	public void setSeller(Seller seller) {
//		this.seller = seller;
//	}
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "vertical_marketing_type_id", nullable = false)
//	public VerticalMarketingType getVerticalMarketingType() {
//		return this.verticalMarketingType;
//	}
//
//	public void setVerticalMarketingType(
//			VerticalMarketingType verticalMarketingType) {
//		this.verticalMarketingType = verticalMarketingType;
//	}
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "provider_id", nullable = false)
//	public Provider getProvider() {
//		return this.provider;
//	}
//
//	public void setProvider(Provider provider) {
//		this.provider = provider;
//	}
//
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
	@JoinColumn(name = "item_type_id", nullable = false)
	public ItemType getItemType() {
		return this.itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "delivery_date_type_id")
//	public DeliveryDateType getDeliveryDateType() {
//		return this.deliveryDateType;
//	}
//
//	public void setDeliveryDateType(DeliveryDateType deliveryDateType) {
//		this.deliveryDateType = deliveryDateType;
//	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vertical_id", nullable = false)
	public Vertical getVertical() {
		return this.vertical;
	}

	public void setVertical(Vertical vertical) {
		this.vertical = vertical;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "sub_category_type_id", nullable = false)
//	public SubCategoryType getSubCategoryType() {
//		return this.subCategoryType;
//	}
//
//	public void setSubCategoryType(SubCategoryType subCategoryType) {
//		this.subCategoryType = subCategoryType;
//	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "active_end", length = 0)
	public Date getActiveEnd() {
		return this.activeEnd;
	}

	public void setActiveEnd(Date activeEnd) {
		this.activeEnd = activeEnd;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "active_start", nullable = false, length = 0)
	public Date getActiveStart() {
		return this.activeStart;
	}

	public void setActiveStart(Date activeStart) {
		this.activeStart = activeStart;
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

	@Column(name = "delivery_date_days")
	public Integer getDeliveryDateDays() {
		return this.deliveryDateDays;
	}

	public void setDeliveryDateDays(Integer deliveryDateDays) {
		this.deliveryDateDays = deliveryDateDays;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_updated", nullable = false, length = 0)
	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Column(name = "model", nullable = false)
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "requires_shipping", nullable = false)
	public boolean isRequiresShipping() {
		return this.requiresShipping;
	}

	public void setRequiresShipping(boolean requiresShipping) {
		this.requiresShipping = requiresShipping;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "itemGroup")
	public Set<Item> getItems() {
		return this.items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "itemGroup")
	public Set<ItemGroupProfile> getItemGroupProfiles() {
		return this.itemGroupProfiles;
	}

	public void setItemGroupProfiles(Set<ItemGroupProfile> itemGroupProfiles) {
		this.itemGroupProfiles = itemGroupProfiles;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "itemGroup")
//	public Set<PaymentMethodExclusions> getPaymentMethodExclusionses() {
//		return this.paymentMethodExclusionses;
//	}
//
//	public void setPaymentMethodExclusionses(
//			Set<PaymentMethodExclusions> paymentMethodExclusionses) {
//		this.paymentMethodExclusionses = paymentMethodExclusionses;
//	}

}
