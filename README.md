(Nyx)Intrusion Detection System

Description:- Intrusion Detection System made using Java based on Snort Technology and Snort rules files (downloded from snort site using web based gui)
For more detailed description read the Documentation and if you want to expand on the project (I don't have any other code other than that hosted here). If you want to work on JADE agent communication tutorial, I have written it at https://wordpress.com/post/neppramod.wordpress.com/141

Used Plugins and Packages
Web Server: -> apache-tomcat-6.0.14.zip
Agent Technology:    -> jade 3.5
Packet Capture:      -> jpcap-0.7-1.i386.rpm
                Dependency: libnet-0.10.11.tar.gz
                Dependency: libpcap-0.9.8.tar.gz (Main package used for Packet Capturing. For Microsoft Operating System similar package is Winpcap)
                
Web based User Interface : jsf-api.jar (1.2)
                           jsf-impl.jar
                           jstl-1.2.jar
                           
Note:- Sorry for not maintaining the static paths to our home directories.
Tested on Fedora 7, Fedora 8, Fedora 5. But it should work on other platforms also. For windows install winpcap instead of libpcap


1. Install jpcap, dependencies are libnet and libpcap. So install them using
	a. unzip
	b. ./configure
	c. make
	d. make install

2. Unzip jade 3.5, apache 6, and RichFaces to some directory
3. Include the jar files of jade in the CLASSPATH while compling java
4. Start the application by starting the MainGui from Nyx_final for administrative controls. Start the eth0 interface to capture packets and compare
5. Start the agent ""java jade.Boot" after including jar of jade directory and check some rules to execute
6. To execute web based GUI, in the include jars of JSF. Execute index.html to start the applications
7. nyx.log, settings.txt and login.txt are the files created in the home directory so you may even have to create some

Note :- If you want to compile the project eclipse or Netbeans can be used. Add the necessary jar as you compile

Unless specified every file of the Project falls Under GNU GPL Licence (see GNU Licence.txt). Jade 3.5 falls under GNU Lesser Licence
