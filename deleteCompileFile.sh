#!/bin/bash

rm -f *.class
cd controller && rm -f *.class && cd ../
cd model/view && rm -f *.class && cd ../../

cd model/fish && rm -f *.class && cd ../../
cd model/fish/behaviour && rm -f *.class && cd ../../../
cd model/gameEngine && rm -f *.class && cd ../../
cd model/sea && rm -f *.class && cd ../../
cd model/sea/populate && rm -f *.class && cd ../../../