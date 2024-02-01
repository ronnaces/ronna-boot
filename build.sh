#!/bin/bash
################################################
# Build docker image with Dockerfile
# @author KunLong-Luo
# @version 2.0.2
# @since 2022-08-29 14:10:00
################################################

################################################
# Define constants
################################################
SHORT=d:p:f:h:
LONG=dev:,prod:,default:,help:,
VERSION="latest"
NAMESPACE="ronnaces"
DOCKER_FILE_PATH="./boot-entrypoint"
REGISTRY_URL_DEV="hub.ronnaces.com"
REGISTRY_URL_PROD="139.196.199.6:5000"

################################################
# Define member variables
################################################
SCRIPT_NAME=$(basename "$0")
OPTIONS=$(getopt -o $SHORT --long $LONG --name "$SCRIPT_NAME" -- "$@")
CURRENT_DATE="$(date +'%Y%m%d')"
BUILDER="$(git config user.name)"
REGISTRY_URL_DEFAULT="${REGISTRY_URL_DEV}"
SERVICE_NAME="$(pwd | awk -F '/' '{print $NF}')"
#TAG="${BUILDER}"-"${CURRENT_DATE}"-"${VERSION}"
TAG="${VERSION}"
IMAGE="${REGISTRY_URL_DEFAULT}"/"${NAMESPACE}"/"${SERVICE_NAME}":"${TAG}"

################################################
# Define functions
################################################
package() {
  mvn clean package -Dmaven.test.skip=true
}

does_fail() {
  if [[ $? -eq 0 ]]; then
    echo -e "\e[92mSuccess!\e[0m"
  else
    echo -e "\e[91mError!\e[0m"
    exit 1
  fi
}

build() {
  docker -v
  docker build -t "${IMAGE}" ${DOCKER_FILE_PATH}
}

push() {
  docker push "${IMAGE}"
}

print_image() {
  echo -e "\e[93m${IMAGE}\e[0m"
}

exec() {
  package
  does_fail
  build
  does_fail
  push
  does_fail
  print_image
}

usage() {
  cat <<EOF
Usage: build [options]
Options: [defaults in brackets after descriptions]

Help options:
  --help                   print this message

Standard options:
  -f | --default           release to the default environment.
  -d | --dev               release to the development environment.
  -p | --prod              release to the production environment.
EOF
  exit 0
}

# shellcheck disable=SC2120
ui() {
  eval set -- "${OPTIONS}"
  while :; do
    if [ -n "${1}" ]; then
      case "${1}" in
      -d | --dev)
#        IMAGE="${REGISTRY_URL_DEV}"/"${NAMESPACE}"/"${SERVICE_NAME}":"${TAG}"
        IMAGE="${SERVICE_NAME}":"${TAG}"
        echo -e "\e[93m即将发布到测试环境！\e[0m"
        exec
        shift 2
        ;;
      -p | --prod)
        IMAGE="${REGISTRY_URL_PROD}"/"${NAMESPACE}"/"${SERVICE_NAME}":"${TAG}"
        echo -e "\e[93m即将发布到生产环境！\e[0m ${IMAGE}"
        exec
        shift 2
        ;;
      -f | --default)
        echo -e "\e[93m即将发布到默认环境！\e[0m"
        exec
        shift 2
        ;;
      -h | --help)
        usage
        exit 0
        ;;
      --)
        shift
        break
        ;;
      *)
        echo -e "\e[93mInvalid Option\e[0m"
        exit 1
        ;;
      esac
    else
      echo -e "\e[93m即将发布到默认环境！\e[0m"
      exec
    fi
  done
}

################################################
# The Main function
################################################
main() {
  ui
}

main
