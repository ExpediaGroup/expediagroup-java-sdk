#!/bin/bash

nextVersion=$1
today=$(date "+%Y%m%d%H%M%S")
git tag v"$today" "$nextVersion"
git push --tags
gh release edit "$nextVersion" --title v"$today" --tag v"$today"
