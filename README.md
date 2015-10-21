# Running SMART locally (without GeoTagger)

The following User Guide is based on Mac Operating System. 

## Install Ecplise and WebSphere Application Server(WAS) Liberty runtime  
1.	Follow the steps in [here](https://developer.ibm.com/wasdev/downloads/liberty-profile-using-eclipse/)  
2.	Download Eclipse, and WebSphere Developer Tools for Eclipse  
3.	WAS Liberty runtime can be downloaded in [here](https://developer.ibm.com/wasdev/downloads/liberty-profile-using-non-eclipse-environments/)  
4.	Alternatively you can install WAS Liberty runtime within Eclipse. In eclipse select `File`->`new`->`other`; search for "server", select `server` and go to `next`; select `IBM`-> `WebSphere Application Server Liberty Profile` as server type and go to `next`; select `Choose an exisiting installation` if you have already downloaded WAS Liberty runtime seperately, otherwise select `install from an archive or a repository`, then select the `Full Platform` version of WAS Liberty runtime. After selecting `Manually define a new server`, it is *important* that the server name is left as `defaultServer` as this will be assumed to be the case in the future.
5.	A reference can be found in [here](https://developer.ibm.com/wasdev/docs/developing-applications-wdt-liberty-profile/)  
6.	Make sure Eclipse, and WebSphere Developer Tools for Eclipse, and WAS Liberty runtime are all properly installed

##Clone 3 projects, SMART-engine, SMART-ui, and SMART-config from Gitlab repository:
If you have set up ssh for gitlab:
$ git clone https://mrlgit.au.ibm.com/information-interaction/SMART-engine.git
$ git clone https://mrlgit.au.ibm.com/information-interaction/SMART-ui.git
$ git clone https://mrlgit.au.ibm.com/information-interaction/SMART-config.git

```bash
#!/bin/bash

# mkdir SMART
# cd SMART
# git clone git@mrlgit.au.ibm.com:information-interaction/SMART-engine.git
# git clone git@mrlgit.au.ibm.com:information-interaction/SMART-ui.git
# git clone git@mrlgit.au.ibm.com:information-interaction/SMART-config.git
# cd SMART-engine

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
To install ansible run these commands:
	
	$ sudo apt-get install software-properties-common
	$ sudo apt-add-repository ppa:ansible/ansible
	$ sudo apt-get update
	$ sudo apt-get install ansible

## Playbooks
There are 3 playbooks used for deployment. These playbooks are used for creating a new instance on openstack and installing all the required packages and dependencies for crawling and analysing Tweets.

## Plays:
* `nova.yml` using module nova_compute to create a new instance on openstack(the parameters nodename and flavorid need to be provided).
* `mount.yml` for volume to be attached to the instance, format it to ext4 and mount it under `/mnt/data`, then create directory couchdb.
* `apps.yml` install packages and dependencies on instance for crawling, analysing and storing tweets.

To run these plays more conveniently, we provide the script `install_instance.sh`.

## Basic Procedures

1.	Add key-pairs to Nectar through Dashboard and store the private key at `~/ansible_playbook/nectar.key`.
2.	Modify the `nova.yml` file, and replace `login_username`, `login_password`, `login_tenant_name`, `key_name` (You can find those information in the `OpenStack RC File` downloaded from Nectar).
3.	Run the `ansible_playbook/install_instance.sh` script, there will be 3 options on your screen.
4.	Enter `1` to create instance，enter node name and flavor id based on the suggesions given.
5.	If you want to create more than one instance，please repeat step 1 and 2.
6.	Find the recently built instance in the Nectar Dashboard, record their IP addresses and add them to the file `/etc/ansible/hosts`, every node would have a unique name and its coorsponding IP address. e.g.
	* [node4]
	* node4 ansible_ssh_host=144.6.227.100
7.	Create a new volume from the Nectar Dashboard, and attach it to the relative instance.
8.	Repeat step 3
9.	Enter `2` to mount. Then enter host name following the suggestions (the hosts defined in `/etc/ansible/hosts`).
10.	Repeat step 3
11.	Enter `3` to install required software packages and dependencies. Then enter host name following the suggestions (the hosts defined in `/etc/ansible/hosts`).

# test run

	
1.	Open the `cav.properties` file under `WebSphereLiberty/usr/servers/defaultServer/`. 
2.	replace `CONSUMER_KEY`, `CONSUMER_SECRET`, with your own ones.
3.	Add your own twitter handle with plus comma `,` after `list_of_users` and optionally `list_of_admins`.
4.	Note that because of the code implementation, comma seperated entires in 'cav.properties' all MUST END with a comma `,`.
