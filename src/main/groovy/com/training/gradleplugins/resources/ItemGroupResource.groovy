package com.training.gradleplugins.resources

import com.training.gradleplugins.core.ItemGroup
import com.training.gradleplugins.db.hibernate.ItemGroupDAO
import com.yammer.dropwizard.hibernate.UnitOfWork
import com.yammer.metrics.annotation.Timed

import javax.ws.rs.*
import javax.ws.rs.core.MediaType

/**
 * Created by pinky on 19/03/14.
 */
@Path("/itemGroup")
@Produces(MediaType.APPLICATION_JSON)
class ItemGroupResource {
    private final ItemGroupDAO itemDAO

    ItemGroupResource(ItemGroupDAO itemDAO) {
        this.itemDAO = itemDAO
    }

    @GET
    @Timed
    @UnitOfWork
    List<ItemGroup> listItems() {
        itemDAO.findAll()
    }



}
