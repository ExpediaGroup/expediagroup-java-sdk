#!/bin/bash

release_notes=$1
echo "$release_notes" &> release-notes.txt
previous_tag=$(./get-latest-tag.sh)
today="v$(date "+%Y%m%d%H%M%S")"

echo "today: $today"

git tag "$today"
git push --tags
gh release create "$today" --draft --generate-notes --latest --notes-file release-notes.txt --notes-start-tag "$previous_tag" --title "$today"

tags=("v1.0.0" "v1.0.1" "v1.1.0" "v2.0.0")

for tag in "${tags[@]}"; do
    if [ $(git tag -l "$tag") ]; then
        git push origin --delete "$tag"
        echo "Deleted $tag"
    fi
done

git push origin --delete v1.0.0
git push origin --delete v1.0.1
git push origin --delete v1.1.0
git push origin --delete v2.0.0
