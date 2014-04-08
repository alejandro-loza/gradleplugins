package com.training.gradleplugins.resources

import com.training.gradleplugins.core.Item
import com.training.gradleplugins.db.ItemDAO
import com.yammer.dropwizard.hibernate.UnitOfWork
import com.yammer.metrics.annotation.Timed

import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/items")
@Produces(MediaType.APPLICATION_JSON)


class ItemsResource implements Serializable{
    private final ItemDAO itemDAO

    ItemsResource(ItemDAO itemDAO) {
        this.itemDAO = itemDAO
    }

    @GET
    @Timed
    @UnitOfWork
    List<Item> listItems() {
        itemDAO.findAll()
    }

    @POST
    @Timed
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    Item add(@Valid Item item) {
        println "ITEM -> ${item.dump()}"
        item.id = itemDAO.create(item)
        item
    }
}
