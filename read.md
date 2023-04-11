Dependency Counter Maven Plugin

Build and install the plugin mvn clean install

add this to your project

<plugin>
				<groupId>com.example</groupId>
				<artifactId>counter-maven-plugin</artifactId>
				<version>1.0-SNAPSHOT</version>
				<executions>
					<execution>
						<goals>
							<goal>dependency-counter</goal>
						</goals>
						<configuration>
							<scope>test</scope>
						</configuration>
					</execution>
				</executions>
			</plugin>

to execute the plugin run
mvn ahmad-plugin:dependency-counter