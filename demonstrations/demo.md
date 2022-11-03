# Démonstration du prototype 

### Etape 1 : Obtenir le contenu du répertoire bronze.

```
hdfs dfs -ls /user/bronze/json/
```

### Etape 2 : Obtenir le contenu du répertoire silver.

```
hdfs dfs -ls /user/silver/pollution/
```

### Etape 3 : Lancer le traitement.

Allez sur l'interface graphique de Airflow, ouvrir le dag **data_pipeline_pollution**.

Puis lancer le dag.

### Etape 4 : Afficher le résultat du traitement/DAG.

```
hdfs dfs -ls /user/bronze/json/
```

```
hdfs dfs -ls /user/bronze/json/2022-11-04/
```

```
hdfs dfs -ls /user/silver/pollution/
```

### Etape 5 : Vider la table pollution. 

Sur la machine epinode-factory, il faut vider la table pollution.

```
mysql -u epinode -p 
password : epinode

use epinode;

truncate pollution;

select * from pollution;
```

### Etape 6 : Lancer le traitement d'ingestion dans MySQL.

Allez sur l'interface graphique de Airflow, ouvrir le dag **data_to_mysql**.

Lancer le dag.

### Etape 7 : Vérifier le contenu de la table pollution.

Sur la machine epinode-factory, il faut vérifier le contenu de la table pollution.

```
select * from pollution;
```

### Etape 8 : Regarder les dashboards.

Se connecter à l'adresse IP suivante : 

```
http://172.31.254.20:9090/
```

Puis allez dans la VM Dashboard POWER BI :

```
Mot de passe : dashboard
```

Montrer le fichier co2.pbix

Rafraîchir le graphique.
