#!/bin/bash
find ~/Desktop/spring-framework-3.1.0.M1/docs/javadoc-api/ -type f | sed s/\\/home\\/jeff\\/Desktop\\/spring-framework-3\\.1\\.0\\.M1\\/docs\\/javadoc-api\\///g | sed s/\\//\\./g | sed s/\\.html//g
