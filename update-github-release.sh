#!/bin/bash

nextVersion=$1
today=$(date "+%Y%m%d")
git tag v"$today" v"$nextVersion"
git push --tags
gh release edit v"$nextVersion" --title v"$today" --tag v"$today"
