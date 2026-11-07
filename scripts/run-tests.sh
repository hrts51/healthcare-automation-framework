#!/usr/bin/env bash
set -e
mvn clean test -Dbrowser="${BROWSER:-chrome}" -Dheadless="${HEADLESS:-false}" -Dbase.url="${BASE_URL:-http://localhost:8080}"
