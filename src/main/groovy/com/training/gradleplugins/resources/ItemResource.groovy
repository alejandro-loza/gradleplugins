package com.training.gradleplugins.resources

import com.sun.jersey.api.NotFoundException
import com.training.gradleplugins.core.Item
import com.training.gradleplugins.db.ItemDAO
import com.yammer.dropwizard.hibernate.UnitOfWork
import com.yammer.metrics.annotation.Timed

import javax.ws.rs.GET
import javax.ws.rs.PUT
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

    @PUT
    @Timed
    @UnitOfWork
    Item update(@PathParam("id") Long itemId, Item item){
        final getItem = itemDAO.findById(itemId)


//        try {
        if (!getItem.isPresent()) {
            throw new NotFoundException("No found item.")
        }
        else{

            Item queryItem =getItem.get()
            println "query item :${queryItem.dump()}"
            println "item :${item.dump()}"

                if(item.priority){
                    queryItem.priority =  item.priority
                }

                if(item.attributeValue){
                    queryItem.attributeValue =  item.attributeValue
                }
                if(item.attributeLabel){
                    queryItem.attributeLabel =  item.attributeLabel
                }
                if(item.attributeTypeId){
                    queryItem.attributeTypeId =  item.attributeTypeId
                }
                if(item.attributeTypeId){
                    queryItem.attributeTypeId =  item.attributeTypeId
                }
                if(item.itemGroupId){
                    queryItem.itemGroupId =  item.itemGroupId
                }
                if(item.statusId){
                    queryItem.statusId =  item.statusId
                }
//
                queryItem.dateCreated =  queryItem.dateCreated
                queryItem.lastUpdated = item.lastUpdated.toDate()
                queryItem.version =  item.version ++
//
                queryItem.id = itemDAO.update(queryItem, itemId)

            queryItem
        }
//        }
//       catch (Exception e) {
//
//            throw new WebApplicationException(e)
//
        }

}
