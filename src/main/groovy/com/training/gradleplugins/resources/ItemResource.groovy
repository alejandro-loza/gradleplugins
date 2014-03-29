package com.training.gradleplugins.resources

import com.sun.jersey.api.NotFoundException
import com.training.gradleplugins.core.Item
import com.training.gradleplugins.db.ItemDAO
import com.yammer.dropwizard.hibernate.UnitOfWork
import com.yammer.metrics.annotation.Timed

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

/**
 * Created by pinky on 19/03/14.
 */
@Path("/items/{id}")
@Produces(MediaType.APPLICATION_JSON)
class ItemResource {
    private final ItemDAO itemDAO

    ItemResource(ItemDAO itemDAO) {
        this.itemDAO = itemDAO
    }

    @GET
    @Timed
    @UnitOfWork
    Item getItem(@PathParam("id") Long itemId) {

        final item = itemDAO.findById(itemId)
        if (!item.isPresent()) {
            throw new NotFoundException("No such item.")
        }
        item.get()
    }

}
