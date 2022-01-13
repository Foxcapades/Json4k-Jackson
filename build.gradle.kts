plugins {
  `java-library`
  `maven-publish`
  kotlin("jvm") version "1.6.10"
  id("org.jetbrains.dokka") version "1.6.10"
  signing
}

group = "io.foxcapades.lib"
version = "1.0.0"

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib"))
  implementation(kotlin("stdlib-jdk8"))
  implementation("io.foxcapades.lib:json4k:1.0.2")
  implementation("com.fasterxml.jackson.core:jackson-databind:2.13.1")
}


kotlin {
  jvmToolchain {
    (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(8))
  }
}

java {
  withJavadocJar()
  withSourcesJar()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
  kotlinOptions {
    jvmTarget = "1.8"
  }
}

tasks.withType<org.jetbrains.dokka.gradle.DokkaTask>().configureEach {
  dokkaSourceSets.configureEach {
    includeNonPublic.set(false)
    jdkVersion.set(8)
  }
}

publishing {
  repositories {
    maven {
      name = "nexus"
      url  = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")

      credentials {
        username = project.findProperty("nexus.user") as String?
        password = project.findProperty("nexus.pass") as String?
      }
    }
  }

  publications {
    create<MavenPublication>("maven") {
      from(components["java"])

      pom {
        name.set("Json4k")
        description.set("Json creation abstraction for Kotlin.")
        url.set("https://github.com/Foxcapades/Json4k")
        developers {
          developer {
            id.set("epharper")
            name.set("Elizabeth Paige Harper")
            email.set("foxcapades.io@gmail.com")
            url.set("https://github.com/foxcapades")
            organization.set("Foxcapades IO")
          }
        }
        licenses {
          license {
            name.set("MIT")
          }
        }
        scm {
          connection.set("scm:git:git://github.com/Foxcapades/Json4k.git")
          developerConnection.set("scm:git:ssh://github.com/Foxcapades/Json4k.git")
          url.set("https://github.com/Foxcapades/Json4k")
        }
      }
    }
  }
}

signing {
  useGpgCmd()

  sign(configurations.archives.get())
  sign(publishing.publications["maven"])
}