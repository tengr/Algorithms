# Running SMART locally (without GeoTagger)

The following User Guide is based on Mac Operating System. 

## Install Ecplise and WAS Liberty runtime  
Follow the steps in [here](https://developer.ibm.com/wasdev/downloads/liberty-profile-using-eclipse/).  
* Download **Eclipse** and **WebSphere Developer Tools for Eclipse**  
* **WAS Liberty runtime** can be downloaded in [here](https://developer.ibm.com/wasdev/downloads/liberty-profile-using-non-eclipse-environments/).  
* Alternatively you can install **WAS Liberty runtime** within **Eclipse**. In Eclipse select `File`->`new`->`other`; search for "server", select `server` and go to `next`; select `IBM`-> `WebSphere Application Server Liberty Profile` as server type and go to `next`; select `Choose an exisiting installation` if you have already downloaded WAS Liberty runtime seperately, otherwise select `install from an archive or a repository`, then select the `Full Platform` version of WAS Liberty runtime. After selecting `Manually define a new server`, it is *important* that the server name is left as `defaultServer` as this will be assumed to be the case in the future.
* A reference can be found in [here](https://developer.ibm.com/wasdev/docs/developing-applications-wdt-liberty-profile/).  
* Make sure **Eclipse**, and **WebSphere Developer Tools for Eclipse**, and **WAS Liberty runtime** are all properly installed

##Clone projects from Gitlab:
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

## Run deployment script
* Modify environment variables `ENGINE_DIR`, `UI_DIR`, `CONFIG_DIR`, and `WAS_DIR` in the script according to your setup.
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

## Customize run configuration
1.	Open file `cav.properties` under `*WebSphereLiberty/usr/servers/defaultServer/`. 
2.	Replace the value of `CONSUMER_KEY`and `CONSUMER_SECRET` with your own ones.
3.	Make sure that you have a valid Twitter account. You can get those values by creating an app at https://apps.twitter.com/
4.	Add your own twitter handle plus a comma "," to `list_of_users` and optionally `list_of_admins`.
5.	Note that because of the code implementation, comma seperated entires in `cav.properties` all MUST END with a comma ",".

## Future deployment
* There is no need to build `SMART-ui` more than once as the same `project-smart-ui.war` will be used throughout (in the current stage of development) 
* `cav.properties`in `SMART-config` does not need to be copied again.
* The script that you run every time you make some change in the code and want to see the change should be
```bash
#!/bin/bash

DIR="$(pwd)"
cd $ENGINE_DIR
mvn clean package
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
* Note that you might need to restart the WebSphere Application Server for your change to take effect.

## Caveats
* Try running in an incognito-mode browser 
* Authentication issues are known to occur. Try removing the files `engineConfig.json` and `${twitter_handle}.oauth.properties` under `$WAS_DIR/usr/servers/defaultServer/`. They are generated by successful previous authentication
* Make sure entries `is_file`, `is_gnip` and `is_csv` all exist in `cav.properties`
* Make sure you use a set of consumer key and secret only for one app.
