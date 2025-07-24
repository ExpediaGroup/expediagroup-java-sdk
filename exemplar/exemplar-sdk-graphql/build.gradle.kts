plugins {
    id("com.apollographql.apollo") version "4.3.1"
}

version = "0.0.1-SNAPSHOT"
group = "com.expediagroup"

apply("../gradle-tasks/sdk-properties.gradle.kts")

dependencies {
    // Pulling the GraphQL SDK as an API dependency to allow users to use the SDK internals without needing to add it explicitly.
    api("com.expediagroup:expediagroup-sdk-graphql:0.0.8-alpha")

    // This dependency is required if you have custom scalars in your GraphQL schema, and you want to register adapters from Apollo Kotlin.
    implementation("com.apollographql.adapters:apollo-adapters-core:0.7.0")

    // Don't force SLF4J implementation, as it is provided by the SDK user.
    implementation("org.slf4j:slf4j-api:2.0.17")
}

/**
 * The SDK is designed to work with Apollo Kotlin Generated code.
 * See https://www.apollographql.com/docs/kotlin for more details.
 */
apollo {
    service("exemplar") {
        srcDir("src/main/graphql")
        schemaFile.set(file("src/main/resources/schema.graphqls"))
        packageName.set("com.expediagroup.sdk.exemplar.graphql.generated")

        generateInputBuilders.set(true)
        generateMethods.set(listOf("equalsHashCode", "toString"))

        /**
         * This is where you can register custom scalar adapters.
         * The adapters are used to convert GraphQL scalar types to Kotlin/Java types.
         * For example, if you have a custom scalar type `Date`, you can map it to `java.time.LocalDate` using a custom adapter.
         *
         * see https://www.apollographql.com/docs/kotlin/essentials/custom-scalars
         */
        mapScalar("Date", "java.time.LocalDate", "com.apollographql.adapter.core.JavaLocalDateAdapter")
        mapScalar("BigDecimal", "java.math.BigDecimal", "com.apollographql.adapter.core.BigDecimalAdapter")
    }
}
