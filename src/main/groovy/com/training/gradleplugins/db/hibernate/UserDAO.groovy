package com.training.gradleplugins.db.hibernate

import com.training.gradleplugins.core.User
import com.yammer.dropwizard.hibernate.AbstractDAO
import org.hibernate.SessionFactory

/**
 * Created by pinky on 2/04/14.
 */
class UserDAO extends AbstractDAO<User>{


    UserDAO(SessionFactory sessionFactory) {
        super(sessionFactory)
    }

   def  nomickaUser(){
//       namedQuery("com.training.gradleplugins.core.User.nomickaUser")
    }
}
