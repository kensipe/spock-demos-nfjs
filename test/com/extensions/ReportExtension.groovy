package com.extensions

import org.spockframework.runtime.AbstractRunListener
import org.spockframework.runtime.extension.AbstractAnnotationDrivenExtension
import org.spockframework.runtime.model.FeatureInfo
import org.spockframework.runtime.model.SpecInfo

/**
 * This is oen of the examples pillaged from peter n. example code from 2011 which provides
 * an example of spock extensions
 *
 */
class ReportExtension extends AbstractAnnotationDrivenExtension<Report> {

    @Override
    void visitSpecAnnotation(Report annotation, SpecInfo spec) {
        spec.addListener(new AbstractRunListener() {
            @Override
            void afterFeature(FeatureInfo feature) {
                println "feature details: ${feature.name}"
                for (block in feature.blocks) {
                    for (text in block.texts) {
                        println text
                    }
                }
            }
        })
    }
}
