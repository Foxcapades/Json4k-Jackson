plugins {
  `java-library`
  `maven-publish`
  kotlin("jvm") version "1.6.10"
  id("org.jetbrains.dokka") version "1.6.10"
  signing
}

group = "io.foxcapades.lib"
version = "1.0.1"

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib"))
  implementation(kotlin("stdlib-jdk8"))
  implementation("io.foxcapades.lib:json4k:1.0.3")
  implementation("com.fasterxml.jackson.core:jackson-databind:2.13.1")


  testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
  testImplementation(kotlin("test"))
}

tasks.withType<Test>().configureEach {
  useJUnitPlatform()
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
        name.set("Json4k-Jackson")
        description.set("Jackson implementation of Json4k")
        url.set("https://github.com/Foxcapades/Json4k-Jackson")
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
          connection.set("scm:git:git://github.com/Foxcapades/Json4k-Jackson.git")
          developerConnection.set("scm:git:ssh://github.com/Foxcapades/Json4k-Jackson.git")
          url.set("https://github.com/Foxcapades/Json4k-Jackson")
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