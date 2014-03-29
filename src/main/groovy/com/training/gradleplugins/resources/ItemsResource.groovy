package com.training.gradleplugins.resources

import com.training.gradleplugins.core.Item
import com.training.gradleplugins.db.ItemDAO
import com.training.gradleplugins.db.hibernate.HibernateItemDAO
import com.yammer.dropwizard.hibernate.UnitOfWork
import com.yammer.dropwizard.jersey.params.LongParam
import com.yammer.metrics.annotation.Timed
import org.hibernate.Hibernate

import javax.validation.Valid
import javax.ws.rs.Consumes
import javax.ws.rs.FormParam
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.xml.ws.Response

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
