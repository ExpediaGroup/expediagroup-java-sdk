#!/bin/bash

today="v$(date "+%Y%m%d%H%M%S")"

echo "today: $today"

git tag "$today"
git push --tags
gh release create "$today" --draft --generate-notes --latest --notes-file release-notes.txt --title "$today"

git push --delete v1.0.0
