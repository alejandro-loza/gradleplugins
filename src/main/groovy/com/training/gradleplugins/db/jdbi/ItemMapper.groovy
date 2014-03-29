package com.training.gradleplugins.db.jdbi

import com.training.gradleplugins.core.Item
import org.joda.time.DateTime
import org.skife.jdbi.v2.StatementContext
import org.skife.jdbi.v2.tweak.ResultSetMapper

import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Timestamp

/**
 * Created by pinky on 19/03/14.
 */
class ItemMapper implements ResultSetMapper<Item> {
    @Override
    Item map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        def item = new Item()
        def metaData = r.metaData
        metaData.columnCount.times {
            def columnName = metaData.getColumnName(it + 1)
            def matcher = columnName =~ /_(\w)/
            def propertyName = matcher.find() ? matcher.replaceAll(matcher.group(1).toUpperCase()) : columnName
            def property = item.metaClass.properties.find { it.name == propertyName }
            if (property) {
                println "PROPERTY NAME -> ${propertyName} , ${property.type}"
                def propertyValue = r.getObject(columnName)
                if (propertyValue instanceof Timestamp) {
                    propertyValue = new DateTime(propertyValue.time)
                }
                item."$propertyName" = propertyValue
            }
        }
//        new Item(id: r.getLong('id'),
//                attributeName: r.getString('attribute_name'),
//                attributeValue: r.getString('attribute_value'))
        item
    }
}
