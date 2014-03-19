package com.training.gradleplugins.db.jdbi

import com.training.gradleplugins.core.Item
import org.skife.jdbi.v2.StatementContext
import org.skife.jdbi.v2.tweak.ResultSetMapper

import java.sql.ResultSet
import java.sql.SQLException

/**
 * Created by pinky on 19/03/14.
 */
class ItemMapper implements ResultSetMapper<Item> {
    @Override
    Item map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        new Item(id: r.getLong('id'),
                attributeName: r.getString('attribute_name'),
                attributeValue: r.getString('attribute_value'))
    }
}
