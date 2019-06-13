package com.roberthorrox.apiserver

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration

class ApiserverConfig() : Configuration() {
    @JsonProperty("template")
    var template: String=""

    @JsonProperty("defaultName")
    var defaultName: String="Stranger"
}