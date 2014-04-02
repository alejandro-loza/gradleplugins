package com.training.gradleplugins.db

import com.google.common.base.Optional
import com.training.gradleplugins.core.Item
import com.training.gradleplugins.db.jdbi.ItemMapper
import com.training.gradleplugins.db.jdbi.OptionalItemMapper
import org.joda.time.DateTime
import org.skife.jdbi.v2.GeneratedKeys
import org.skife.jdbi.v2.sqlobject.Bind
import org.skife.jdbi.v2.sqlobject.BindBean
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys
import org.skife.jdbi.v2.sqlobject.SqlQuery
import org.skife.jdbi.v2.sqlobject.SqlUpdate
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper

import javax.persistence.Column

public interface ItemDAO  {

    @RegisterMapper(OptionalItemMapper)
    @SqlQuery("select * from item where id = :itemId")
    Optional<Item> findById(@Bind('itemId') Long id)

    @SqlUpdate("insert into item(version, attribute_name, attribute_label, attribute_value, attribute_type_id, date_created, last_updated, deleted, item_group_id, status_id, priority) values (:version, :attributeName, :attributeLabel, :attributeValue, :attributeTypeId, :normalDateCreated, :normalLastUpdated, :deleted, :itemGroupId, :statusId, :priority)")
    @GetGeneratedKeys
    Long create (@BindBean Item item)

    @RegisterMapper(OptionalItemMapper)
    @SqlQuery("delete from item where id = :itemId")
    Optional<Item> delete(@Bind('itemId') Item item)


    @SqlUpdate("update item SET version =:version  , attribute_name:attributeName, attribute_label:attributeLabel, attribute_value:attributeValue, attribute_type_id:attributeTypeId, date_created:dateCreated, last_updated:lastUpdated, deleted= deleted, item_group_id: itemGroupId, status_id:statusId, priority:priority WHERE id=:itemId")
    @GetGeneratedKeys
    Long update (@BindBean Item item, @Bind('itemId') Long id)

    @RegisterMapper(ItemMapper)
    @SqlQuery("select * from item")
    List<Item> findAll()

}
