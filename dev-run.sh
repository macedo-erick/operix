#!/usr/bin/env bash
set -euo pipefail

export HOST_UID
export HOST_GID
HOST_UID="$(id -u)"
HOST_GID="$(id -g)"

cd "$(dirname "$0")"

docker compose -f compose-dev.yaml up --build "$@"
