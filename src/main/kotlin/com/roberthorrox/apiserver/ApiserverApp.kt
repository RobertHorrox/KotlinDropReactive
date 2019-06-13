package com.roberthorrox.apiserver


import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import com.roberthorrox.apiserver.resources.ApiserverResource
import com.roberthorrox.apiserver.health.TemplateHealthCheck

class ApiserverApp() : Application<ApiserverConfig>() {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ApiserverApp().run(*args)
        }
    }

    override fun initialize(bootstrap: Bootstrap<ApiserverConfig>) {
        // Don't do anything
    }

    override fun run(config: ApiserverConfig, env: Environment) {
        val resource =  ApiserverResource(config.template, config.defaultName)
        val healthCheck = TemplateHealthCheck(config.template)

        env.healthChecks().register("template", healthCheck)
        env.jersey().register(resource)
    }

}