package edu.fiuba.algo3.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ModelDependenciesTest {
    private final String MODEL = "..modelo..";
    private final String JAVA_LANG = "java..";
    private final String JUNIT = "org.junit..";
    private final String LOG4J = "org.apache.logging.log4j..";
    private final String JSON = "org.json.simple..";
    private final String JSONSchema = "com.networknt.schema..";
    private final String ObjectMapper = "com.fasterxml.jackson.databind..";
    private final String COLOR = "javafx.scene.paint..";

    @Test
    public void elModeloSoloPuedeReferenciarClasesDelModeloAdemasJavaAdemasJunit() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("edu.fiuba.algo3");

        String[] listOfPackages = {MODEL, JAVA_LANG, JUNIT, LOG4J, JSON, JSONSchema, ObjectMapper, COLOR};

        ArchRule myRule = classes().that().resideInAPackage(MODEL)
                .should().onlyDependOnClassesThat().resideInAnyPackage(listOfPackages);

        myRule.check(importedClasses);
    }

}
