#!/bin/bash

release_notes=$1
echo "$release_notes" &> release-notes.txt
previous_tag=$(./get-latest-tag.sh)
today="v$(date "+%Y%m%d%H%M%S")"

echo "today: $today"

git tag "$today"
git push --tags
gh release create "$today" --draft --generate-notes --latest --notes-file release-notes.txt --notes-start-tag "$previous_tag" --title "$today"

git push origin --delete v1.0.0 v1.0.1 v1.1.0 v2.0.0
