package com.training.gradleplugins.db.hibernate


import com.training.gradleplugins.core.ItemGroupProfile
import com.yammer.dropwizard.hibernate.AbstractDAO
import org.hibernate.SessionFactory

/**
 * Created by pinky on 4/04/14.
 */
class ItemGroupProfileDAO extends AbstractDAO<ItemGroupProfile> {

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    ItemGroupProfileDAO(SessionFactory sessionFactory) {
        super(sessionFactory)
    }

    def List<ItemGroupProfile> obtainAll() {
        list(namedQuery("com.training.gradleplugins.core.ItemGroupProfile.findAll"))
    }

}
