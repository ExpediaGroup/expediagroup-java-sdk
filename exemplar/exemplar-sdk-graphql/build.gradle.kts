plugins {
    id("com.apollographql.apollo") version "4.3.1"
}

version = "0.0.1-SNAPSHOT"
group = "com.expediagroup"

dependencies {
    api("com.expediagroup:expediagroup-sdk-graphql:0.0.8-alpha")
    implementation("com.apollographql.adapters:apollo-adapters-core:0.7.0")

    implementation(platform("com.fasterxml.jackson:jackson-bom:2.18.2"))
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    runtimeOnly("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

    implementation("org.slf4j:slf4j-api:2.0.17")
}

apollo {
    service("exemplar") {
        /* Schema & operations files configurations */
        srcDir("src/main/graphql")
        schemaFile.set(file("src/main/resources/schema.graphqls"))
        packageName.set("com.expediagroup.sdk.exemplar.graphql")

        /* Generated models configurations */
        generateInputBuilders.set(true)
        generateMethods.set(listOf("equalsHashCode", "toString"))

        /**** Custom Scalars Mappings ****/
        mapScalar("Date", "java.time.LocalDate", "com.apollographql.adapter.core.JavaLocalDateAdapter")
        mapScalar("BigDecimal", "java.math.BigDecimal", "com.apollographql.adapter.core.BigDecimalAdapter")
    }
}

