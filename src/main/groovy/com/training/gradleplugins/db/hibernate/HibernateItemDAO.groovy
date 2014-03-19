package com.training.gradleplugins.db.hibernate;


import com.google.common.base.Optional
import com.training.gradleplugins.core.Item
import com.training.gradleplugins.db.ItemDAO
import com.yammer.dropwizard.hibernate.AbstractDAO
import org.hibernate.SessionFactory

import java.util.List

public class HibernateItemDAO extends AbstractDAO<Item> implements ItemDAO {
    def HibernateItemDAO(SessionFactory factory) {
        super(factory)
    }

    def Optional<Item> findById(Long id) {
        return Optional.fromNullable(get(id))
    }

    def Item create(Item item) {
        return persist(item)
    }

    def List<Item> findAll() {
        list(namedQuery("com.training.gradleplugins.core.Item.findAll"))
    }
}