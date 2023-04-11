package com.example;


import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.util.List;

/**
 * My custom Maven plugin.
 */
@Mojo(name = "dependency-counter", defaultPhase = LifecyclePhase.COMPILE)
public class MyPlugin extends AbstractMojo {

    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    MavenProject project;

    @Parameter(property = "scope")
    String scope;

    /**
     * The greeting to display.
     */
    @Parameter(property = "greeting", defaultValue = "Hello, world!")
    private String greeting;


    @Parameter(property = "dto", defaultValue = "com.yorker.backend.dto")
    private String dto;

    @Parameter(property = "name", defaultValue = "Name")
    private String name;

    /**
     * {@inheritDoc}
     */
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Scope: " + scope);
        getLog().info(greeting);
        List<Dependency> dependencies = project.getDependencies();
        long numDependencies = dependencies.stream()
                .filter(d -> (scope == null || scope.isEmpty()) || scope.equals(d.getScope()))
                .count();
        getLog().info("Number of dependencies: " + numDependencies);

        DTOGenerator.dtoGenerator(name, null);
    }

}
