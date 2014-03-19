package com.training.gradleplugins.db;


import com.google.common.base.Optional
import com.training.gradleplugins.core.Item
import com.yammer.dropwizard.hibernate.AbstractDAO
import org.hibernate.SessionFactory

import java.util.List

public class itemDAO extends AbstractDAO<Item> {
    def itemDAO(SessionFactory factory) {
        super(factory)
    }

    def Optional<Item> findById(Long id) {
        return Optional.fromNullable(get(id))
    }

    def Item create(Item item) {
        return persist(item)
    }

    def List<Item> findAll() {
        def items = Item.findAll()
          items
//        return list(namedQuery("findAll"))
    }
}