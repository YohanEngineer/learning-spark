# Hadoop Cluster with YARN and Spark configured

### The cluster location

This hadoop cluster is running on 4 VMs in the school hypervisor vSphere. You can find it under this path :

```bash
ESIPE-Creteil/Etudiants/ING3/Data/Hadoop Cluster
```


### Hardware configuration

In order to create the cluster, you have to setup 4 VMs with the following hardware and software:
<ul>
<li> CPU : 4
<li> RAM : 4 GB
<li> HDD : 32 GB
<li> Linux Ubuntu 18.04.4-live-server </li>
<li> Java 1.8 </li>
</ul>

### Network

In order to create the cluster, you have to set up the network of the cluster like in this screen :

![alt text](https://github.com/YohanEngineer/learningSpark/blob/main/Hadoop%20network.png)

For this cluster, we used and configured the network with NETPLAN. We configured the YAML
file of netplan that can be found here in each VM :

```bash 
/etc/netplan/50-cloud-init.yaml
```

Open it with :

```bash 
sudo nano /etc/netplan/50-cloud-init.yaml
```

Then fill each VM with it's configuration.




#### Namenode :

```yaml
# This file is generated from information provided by the datasource$
# to it will not persist across an instance reboot.  To disable clou$
# network configuration capabilities, write a file
# /etc/cloud/cloud.cfg.d/99-disable-network-config.cfg with the foll$
# network: {config: disabled}
network:
  ethernets:
    ens160:
      dhcp4: true
    ens192:
      addresses:
        - 192.168.1.100/24
      nameservers:
        addresses: [ 8.8.8.8,8.8.4.4 ]

  version: 2
```

#### Data node 1 :

```yaml
# This file is generated from information provided by the datasource$
# to it will not persist across an instance reboot.  To disable clou$
# network configuration capabilities, write a file
# /etc/cloud/cloud.cfg.d/99-disable-network-config.cfg with the foll$
# network: {config: disabled}
network:
  ethernets:
    ens192:
      addresses:
        - 192.168.1.141/24
      nameservers:
        addresses: [ 8.8.8.8,8.8.4.4 ]
  version: 2
```

#### Data node 2 :

```yaml
# This file is generated from information provided by the datasource$
# to it will not persist across an instance reboot.  To disable clou$
# network configuration capabilities, write a file
# /etc/cloud/cloud.cfg.d/99-disable-network-config.cfg with the foll$
# network: {config: disabled}
network:
  ethernets:
    ens192:
      addresses:
        - 192.168.1.113/24
      nameservers:
        addresses: [ 8.8.8.8,8.8.4.4 ]
  version: 2
```

#### Data node 3 :

```yaml
# This file is generated from information provided by the datasource$
# to it will not persist across an instance reboot.  To disable clou$
# network configuration capabilities, write a file
# /etc/cloud/cloud.cfg.d/99-disable-network-config.cfg with the foll$
# network: {config: disabled}
network:
  ethernets:
    ens192:
      addresses:
        - 192.168.1.118/24
      nameservers:
        addresses: [ 8.8.8.8,8.8.4.4 ]
  version: 2
```
To make ubuntu acknowledge the new configuration make this two commands :

```bash 
sudo netplan apply
sudo reboot 
```

YOU ARE THE KING/QUEEN :crown: , you sucessfully set up the network of your cluster. Now, let's get some fun.


### Installation of Hadoop

[Hadoop installation with Spark By Example Website](https://sparkbyexamples.com/hadoop/apache-hadoop-installation/)

### Installation of Spark

[Installation of Spark with Spark By Example Website](https://sparkbyexamples.com/spark/spark-setup-on-hadoop-yarn/)

### Useful commands 

#### HDFS

```bash 
start-dfs.sh
```

```bash 
hdfs dfs -mkdir /user/

hdfs dfs -mkdir /user/test

hdfs dfs -put example.json /user/test

hdfs dfs -ls

hdfs dfs -cat myfile.csv

hdfs dfs -rm -r example.json /user/test/…
```

```bash 
stop-dfs.sh
```

#### Setting Spark Master

Make sure HDFS is running well.

Then use this command :

```bash 
hdfs dfs -mkdir -p /spark-logs
```

To launch spark master use the following command :

```bash 
/spark/sbin/start-master.sh --ip 192.168.1.100
```

#### Setting Spark Worker

On each datanode run the following command :

```bash 
/home/administrator/spark/bin/spark-class org.apache.spark.deploy.worker.Worker spark://192.168.1.100:7077 --cores 2 --memory 3G
```

#### Spark-Submit


To submit an application use the following command :

```bash 
spark-submit --master spark://192.168.1.100:7077 --class Main --deploy-mode cluster hdfs://192.168.1.100:9000/user/administrator/testing.jar
```