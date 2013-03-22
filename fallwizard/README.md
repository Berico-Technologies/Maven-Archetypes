# Fallwizard Archetype

Generates a Fallwizard (Spring + Dropwizard) project with a lot of the annoying artifacts you will typically want in a deployment.

## Usage

From the shell, execute the following command:

```bash
mvn archetype:generate                                                               \
  -DarchetypeRepository=nexus.bericotechnologies.com/content/repositories/release    \
  -DarchetypeGroupId=com.berico.archetype                                            \
  -DarchetypeArtifactId=fallwizard-archetype                                         \
  -DarchetypeVersion=1.0.0-RELEASE                                                   
```

Follow the instructions displayed in the prompt.
