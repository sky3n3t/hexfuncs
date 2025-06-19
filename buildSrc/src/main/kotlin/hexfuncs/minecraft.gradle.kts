// A convention plugin that should be applied to all Minecraft-related subprojects, including common.

@file:Suppress("UnstableApiUsage")

package hexfuncs

import kotlin.io.path.div
import libs

plugins {
    id("hexfuncs.java")

    `maven-publish`
    id("dev.architectury.loom")
    id("at.petra-k.pkpcpbp.PKJson5Plugin")
}

val modId: String by project
val platform: String by project

base.archivesName = "${modId}-$platform"

loom {
    silentMojangMappingsLicense()
    accessWidenerPath = project(":common").file("src/main/resources/hexfuncs.accesswidener")

    mixin {
        // the default name includes both archivesName and the subproject, resulting in the platform showing up twice
        // default: hexfuncs-common-common-refmap.json
        // fixed:   hexfuncs-common.refmap.json
        defaultRefmapName = "${base.archivesName.get()}.refmap.json"
    }
}

pkJson5 {
    autoProcessJson5 = true
    autoProcessJson5Flattening = true
}

dependencies {
    minecraft(libs.minecraft)

    mappings(loom.layered {
        officialMojangMappings()
        parchment(libs.parchment)
    })

    annotationProcessor(libs.bundles.asm)
}

sourceSets {
    main {
        kotlin {
            srcDir(file("src/main/java"))
        }
        resources {
            srcDir(file("src/generated/resources"))
        }
    }
}
