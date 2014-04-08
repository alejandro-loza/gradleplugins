package com.training.gradleplugins.db.hibernate


import com.training.gradleplugins.core.Vertical
import com.yammer.dropwizard.hibernate.AbstractDAO
import org.hibernate.SessionFactory

/**
 * Created by pinky on 3/04/14.
 */
class VerticalDAO extends AbstractDAO<Vertical> {
    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    VerticalDAO(SessionFactory sessionFactory) {
        super(sessionFactory)
    }

    def List<Vertical> obtainAll() {
        list(namedQuery("com.training.gradleplugins.core.Vertical.findAll"))
    }
}
