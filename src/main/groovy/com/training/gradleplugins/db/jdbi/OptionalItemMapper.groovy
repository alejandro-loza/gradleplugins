package com.training.gradleplugins.db.jdbi

import com.google.common.base.Optional
import com.training.gradleplugins.core.Item
import org.skife.jdbi.v2.StatementContext
import org.skife.jdbi.v2.tweak.ResultSetMapper

import java.sql.ResultSet
import java.sql.SQLException

/**
 * Created by pinky on 19/03/14.
 */
class OptionalItemMapper implements ResultSetMapper<Optional<Item>> {

    final ItemMapper itemMapper = new ItemMapper()

    @Override
    Optional<Item> map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        def item = itemMapper.map(index, r, ctx)
        Optional.of(item)
    }
}
