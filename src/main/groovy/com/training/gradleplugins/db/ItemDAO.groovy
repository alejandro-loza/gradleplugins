package com.training.gradleplugins.db

import com.google.common.base.Optional
import com.training.gradleplugins.core.Item
import com.training.gradleplugins.db.jdbi.ItemMapper
import com.training.gradleplugins.db.jdbi.OptionalItemMapper
import org.skife.jdbi.v2.sqlobject.Bind
import org.skife.jdbi.v2.sqlobject.SqlQuery
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper

public interface ItemDAO {

    @RegisterMapper(OptionalItemMapper)
    @SqlQuery("select * from item where id = :itemId")
    Optional<Item> findById(@Bind('itemId') Long id)

    Item create(Item item)

    @RegisterMapper(ItemMapper)
    @SqlQuery("select * from item")
    List<Item> findAll()

}