#!/usr/bin/env bash

MYDIR=$(dirname $(readlink -m "$0"))
BACKEND_RESOURCES_DIR=$MYDIR/src/main/resources/static

# Build frontend
pushd $MYDIR/frontend
rm -rf dist
yarn install
yarn build
popd

# Copy frontend resources to backend resources directory
cp -R $MYDIR/frontend/dist/* $BACKEND_RESOURCES_DIR

# Build backend
# TODO

