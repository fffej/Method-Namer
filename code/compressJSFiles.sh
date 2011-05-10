#!/bin/bash
java -jar /home/jeff/apps/yuicompressor-2.4.6/build/yuicompressor-2.4.6.jar -o '.js$:-min.js' $*
