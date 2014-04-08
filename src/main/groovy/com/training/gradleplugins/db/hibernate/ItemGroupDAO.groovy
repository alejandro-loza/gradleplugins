package com.training.gradleplugins.db.hibernate

import com.training.gradleplugins.core.ItemGroup
import com.yammer.dropwizard.hibernate.AbstractDAO
import org.hibernate.SessionFactory

/**
 * Created by pinky on 4/04/14.
 */
class ItemGroupDAO extends AbstractDAO<ItemGroup> {

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    ItemGroupDAO(SessionFactory sessionFactory) {
        super(sessionFactory)
    }

    def List<ItemGroup> findAll() {
        list(namedQuery("com.training.gradleplugins.core.ItemGroup.findAll"))
    }



}
