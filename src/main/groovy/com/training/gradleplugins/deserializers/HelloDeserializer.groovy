package com.training.gradleplugins.deserializers

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.training.gradleplugins.core.Notificacion
import com.training.gradleplugins.core.Notification

import javax.persistence.criteria.Root

/**
 * Created by pinky on 28/03/14.
 */
class HelloDeserializer extends JsonDeserializer <Notification> {

    @Override
    Notification deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
//        super.deserialize(jp, dc, bean);
//        Notification c = (Notification)bean;
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        JsonNode rootNode = mapper.readValue(jp, JsonNode.class);
//        // Use tree model to construct custom
//        // Is it inefficient because it needs a second pass to the JSON string to construct the tree?
//        c.setCustom(custom);
//        return c;


               if (jp.getCurrentToken() == VALUE_TEXT) {
                return new Notification(jsonParser.getTextValue() as String);
            }

            throw deserializationContext.mappingException("Expected JSON text");


    }
}
