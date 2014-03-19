package com.training.gradleplugins.resources

import com.training.gradleplugins.core.Item
import com.training.gradleplugins.db.ItemDAO
import com.training.gradleplugins.db.hibernate.HibernateItemDAO
import com.yammer.dropwizard.hibernate.UnitOfWork
import com.yammer.metrics.annotation.Timed

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/items")
@Produces(MediaType.APPLICATION_JSON)
class GradlepluginsResource {
    private final ItemDAO itemDAO

    GradlepluginsResource(ItemDAO itemDAO) {
        this.itemDAO = itemDAO
    }

    @GET
    @Timed
    @UnitOfWork
    public List<Item> listItems() {
        def items = itemDAO.findAll()
        items.each {
            println "$it.id  $it.attributeValue"
        }
        items
    }
}
