package com.training.gradleplugins.resources

import com.training.gradleplugins.core.Vertical
import com.training.gradleplugins.db.hibernate.VerticalDAO
import com.yammer.dropwizard.hibernate.UnitOfWork
import com.yammer.metrics.annotation.Timed

import javax.ws.rs.*
import javax.ws.rs.core.MediaType

/**
 * Created by pinky on 3/04/14.
 */
@Path("/verticales")
@Produces(MediaType.APPLICATION_JSON)

class VerticalResource implements Serializable {
    private final VerticalDAO verticalDAO

    VerticalResource(VerticalDAO verticalDAO) {
        this.verticalDAO = verticalDAO
    }

    @GET
    @Timed
    @UnitOfWork
    List<Vertical> listVerticals() {
        verticalDAO.obtainAll()
    }
}
