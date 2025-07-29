pluginManagement {
    repositories {
        mavenCentral()
        mavenLocal()
        gradlePluginPortal()
    }
}

rootProject.name = "exemplar"

include("exemplar-sdk-rest")
include("exemplar-sdk-graphql")
include("exemplar-server")
include("exemplar-playground-java")
