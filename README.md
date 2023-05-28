# LP5
1. rmic AddServerImpl.java rmiregistry
2. idlj -fall ReverseModule.idl javac *.java ReverseModule/*.java orbd -ORBInitialPort 8000 java ReverseServer orbd - ORBInitialPort 8000 -ORBInitialHost localhost
3. javac -cp ".\mpj-v0_44\lib\mpj.jar" Sum.java  export MPJ_HOME=/home/..../mpj-v0_44 export $PATH=$MPJ_HOME/bin:$PATH .\mpj-v0_44\bin\mpjrun.sh -np 4 Sum
4. java –version
5. update-java-alternatives –list
6. sudo update-java-alternatives --set /usr/lib/jvm/java-1.8.0-openjdk-amd64
7. sudo apt-get install openjdk-8-jdk
8. sudo update-alternatives --config java
9. Glassfish server version must be 4.1.1

 
