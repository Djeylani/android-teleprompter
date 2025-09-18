#!/usr/bin/env sh

# Gradle wrapper script
# This script is used to invoke the Gradle build tool.

set -e

# Determine the directory of the script
DIR="$(cd "$(dirname "$0")" && pwd)"

# Determine the Gradle wrapper jar file
GRADLE_WRAPPER_JAR="$DIR/gradle/wrapper/gradle-wrapper.jar"

# Check if the Gradle wrapper jar file exists
if [ ! -f "$GRADLE_WRAPPER_JAR" ]; then
    echo "Gradle wrapper jar not found. Please run 'gradle wrapper' to generate it."
    exit 1
fi

# Execute the Gradle wrapper
exec java -jar "$GRADLE_WRAPPER_JAR" "$@"