# AMP Quickstart Archetype

Generates an AMP Quick Start project with a properly wired Spring Application Context, necessary Maven dependencies, and an example application.

## Usage

From the shell, execute the following command:

```bash
mvn archetype:generate                                                               \
  -DarchetypeRepository=nexus.bericotechnologies.com/content/repositories/releases   \
  -DarchetypeGroupId=com.berico.archetype                                            \
  -DarchetypeArtifactId=amp-quickstart                                               \
  -DarchetypeVersion=3.1.0                                                   
```

Follow the instructions displayed in the prompt.
