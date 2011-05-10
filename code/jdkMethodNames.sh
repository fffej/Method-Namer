#!/bin/bash
find  ~/Desktop/docs/api/ -type f | sed s/\\/home\\/jeff\\/Desktop\\/docs\\/api\\///g | sed s/\\//\\./g | sed s/\\.html//g
