# Running SMART locally (without GeoTagger)

The following User Guide is based on Mac Operating System. 

## Install Ecplise and WebSphere Application Server(WAS) Liberty runtime  
1.	Follow the steps in [here](https://developer.ibm.com/wasdev/downloads/liberty-profile-using-eclipse/).  
2.	Download Eclipse, and WebSphere Developer Tools for Eclipse  
3.	WAS Liberty runtime can be downloaded in [here](https://developer.ibm.com/wasdev/downloads/liberty-profile-using-non-eclipse-environments/).  
4.	Alternatively you can install WAS Liberty runtime within Eclipse. In eclipse select `File`->`new`->`other`; search for "server", select `server` and go to `next`; select `IBM`-> `WebSphere Application Server Liberty Profile` as server type and go to `next`; select `Choose an exisiting installation` if you have already downloaded WAS Liberty runtime seperately, otherwise select `install from an archive or a repository`, then select the `Full Platform` version of WAS Liberty runtime. After selecting `Manually define a new server`, it is *important* that the server name is left as `defaultServer` as this will be assumed to be the case in the future.
5.	A reference can be found in [here](https://developer.ibm.com/wasdev/docs/developing-applications-wdt-liberty-profile/).  
6.	Make sure Eclipse, and WebSphere Developer Tools for Eclipse, and WAS Liberty runtime are all properly installed

##Clone 3 projects, SMART-engine, SMART-ui, and SMART-config from Gitlab repository:
If you have set up ssh for gitlab:
```bash
	$ git clone git@mrlgit.au.ibm.com:information-interaction/SMART-config.git
	$ git clone https://mrlgit.au.ibm.com/information-interaction/SMART-ui.git
	$ git clone https://mrlgit.au.ibm.com/information-interaction/SMART-config.git
```
Otherwise:
```bash
	$ git clone https://mrlgit.au.ibm.com/information-interaction/SMART-engine.git
	$ git clone https://mrlgit.au.ibm.com/information-interaction/SMART-ui.git
	$ git clone https://mrlgit.au.ibm.com/information-interaction/SMART-config.git
```

##Customize and run the deployment script
* Modify environment variables `ENGINE_DIR`, `UI_DIR`, `CONFIG_DIR`, and `WAS` in the script according to your setup.
```bash
#!/bin/bash

# change according to your setup
#######################################################
ENGINE_DIR="/Users/ruichen/Documents/IBM/SMART-engine/"
UI_DIR="/Users/ruichen/Documents/IBM/SMART-ui/"
CONFIG_DIR="/Users/ruichen/Documents/IBM/SMART-config/"
WAS_DIR="/Users/ruichen/Documents/IBM/WebSphereLiberty/"
#######################################################

DIR="$(pwd)"
cd $ENGINE_DIR
mvn clean package
cd $UI_DIR
mvn clean package
cp $CONFIG_DIR/cav.properties $WAS_DIR/usr/servers/defaultServer/cav.properties
cp $UI_DIR/target/project-smart-ui.war $WAS_DIR/usr/servers/defaultServer/dropins/project-smart-ui.war
cp $ENGINE_DIR/target/cav-1.0-SNAPSHOT.war $WAS_DIR/usr/servers/defaultServer/dropins/cav.war
cd $WAS_DIR/usr/servers/defaultServer/dropins/
rm -rf war
mkdir war
mv cav.war war/cav.war 
cd war
mkdir cav
mv cav.war cav/cav.war
cd cav
unzip cav.war 
rm cav.war
cd $DIR
```

# Customize run configuration
1.	Open the `cav.properties` file under `WebSphereLiberty/usr/servers/defaultServer/`. 
2.	replace `CONSUMER_KEY`, `CONSUMER_SECRET`, with your own ones.
3.	Add your own twitter handle with plus comma "," after `list_of_users` and optionally `list_of_admins`.
4.	Note that because of the code implementation, comma seperated entires in 'cav.properties' all MUST END with a comma ",".
