package com.training.gradleplugins.resources


import com.training.gradleplugins.core.ItemGroupProfile
import com.training.gradleplugins.db.hibernate.ItemGroupProfileDAO
import com.yammer.dropwizard.hibernate.UnitOfWork
import com.yammer.metrics.annotation.Timed

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

/**
 * Created by pinky on 19/03/14.
 */
@Path("/itemGroupProfiles")
@Produces(MediaType.APPLICATION_JSON)
class ItemGroupProfileResource {
    private final ItemGroupProfileDAO itemDAO

    ItemGroupProfileResource(ItemGroupProfileDAO itemDAO) {
        this.itemDAO = itemDAO
    }

    @GET
    @Timed
    @UnitOfWork
    List<ItemGroupProfile> listItems() {
        itemDAO.obtainAll()
    }
}
