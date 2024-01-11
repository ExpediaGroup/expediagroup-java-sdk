#!/bin/bash

tags=$(git tag -l "v*")
latest_tag=$(echo "$tags" | grep -E '^v[0-9]+$' | sort -Vr | head -n 1)
today="v$(date "+%Y%m%d%H%M%S")"

echo "tags: $tags"
echo "latest: $latest_tag"
echo "today: $today"

#gh release create "$today" --draft --generate-notes --latest --notes-start-tag "$latest_tag" -title "$today"

