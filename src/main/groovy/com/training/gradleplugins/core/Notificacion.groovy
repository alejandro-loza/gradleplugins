package com.training.gradleplugins.core

import com.fasterxml.jackson.annotation.JsonProperty

class Notificacion {

    @JsonProperty('myText')
    String text

    Notificacion() {}

}