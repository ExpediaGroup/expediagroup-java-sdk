pluginManagement {
    repositories {
        mavenCentral()
        mavenLocal()
        gradlePluginPortal()
    }
}


rootProject.name = "exemplar"

include("exemplar-sdk")
include("exemplar-server")
include("exemplar-playground-java")
