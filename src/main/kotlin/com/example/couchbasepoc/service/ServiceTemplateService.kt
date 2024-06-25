package com.example.couchbasepoc.service

import com.couchbase.client.java.Cluster
import com.couchbase.client.java.json.JsonArray
import com.couchbase.client.java.query.QueryOptions
import com.example.couchbasepoc.model.Service
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.couchbase.core.CouchbaseTemplate
import org.springframework.data.couchbase.core.query.N1QLExpression
import org.springframework.data.couchbase.core.query.QueryCriteria.where
import kotlin.jvm.optionals.getOrNull

@org.springframework.stereotype.Service
@Qualifier("ServiceTemplateService")
class ServiceTemplateService(
    private val couchbaseTemplate: CouchbaseTemplate,
    private val cluster: Cluster,
) : ServiceService {
    override fun create(service: Service) {
        couchbaseTemplate.insertById(Service::class.java).inCollection("services").one(service)
    }

    override fun findAll(): List<Service> {
        return couchbaseTemplate.findByQuery(Service::class.java).inCollection("services").all()
    }

    override fun findByName(name: String): Service? =
        couchbaseTemplate.findByQuery(Service::class.java).inCollection("services").matching(where("name").`is`(name)).one().getOrNull()

    override fun findByLineupId(lineupId: String): List<Service> {
        val result = cluster.query("SELECT meta(s).id, s.* " +
                "FROM `bucket`.`_default`.`lineups` AS l " +
                "UNNEST l.channels AS lc " +
                "JOIN `bucket`.`_default`.`services` AS s ON KEYS lc.channelId " +
                "WHERE meta(l).id = '$lineupId'")
            .rowsAs(Service::class.java)
        return result
    }
}