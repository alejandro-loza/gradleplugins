package com.training.gradleplugins.db

import com.google.common.base.Optional
import com.training.gradleplugins.core.Item
import com.training.gradleplugins.db.jdbi.ItemMapper
import org.skife.jdbi.v2.sqlobject.SqlQuery
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper

@RegisterMapper(ItemMapper)
public interface ItemDAO {

    Optional<Item> findById(Long id)

    Item create(Item item)

    @SqlQuery("select id, attribute_name, attribute_value from item")
    List<Item> findAll()

}