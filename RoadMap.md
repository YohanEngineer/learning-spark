# Road map maîtrise du prototype

### Introduction

Dans cette road map je vous indique les étapes à suivre pour avoir une certaine maîtrise des technologies du prototype.

### Pré-requis

Vous devez avoir sur votre ordinateur les technologies suivantes d'installées.

<ul>
<li> Java 1.8
<li> Docker Desktop
<li> Python 3.8 ou 3.9 ou 3.10
<li> IntelliJ Ultimate Edition </li>
<li>Un projet avec Scala 2.11.11 et les dépendances Spark Core et Spark SQL </li>
</ul>

Pour chaque étape, je met une ou plusieurs ressources utiles dont j'ai moi même tiré profit.

#### Manipuler des fichiers et des dataframes avec Spark Scala :

L'objectif est de réussir à lire des fichiers json, csv, avro, parquet hébergés sur votre ordinateur local.
De les transformer ensuite en dataframe. De manipuler ces dataframe, faire des filtres, les transformer en table,
faire des requêtes sql dessus. Une fois vos dataframes transformés, il faut les écrire sur votre ordinateur local toujours avec un des format spécifiés auparavant.


[sparkbyexamples](https://sparkbyexamples.com/)

### Manipuler HDFS en utilisant les commandes 

En vous connectant sur cluster Hadoop d'intégration. Il se trouve dans le dossier PDS puis Epinode. A vous d'allumer les 4 machines si elles sont éteintes et de regarder l'adresse ip publique du namenode pour s'y connecter.

```bash
ssh administrator@172......
```

Le password : toto

L'objectif est de réussir depuis le namenode à uploader des fichiers dans HDFS, créer des répertoires, lire le contenu des fichiers, les déplacer d'un répertoire à un autre. Télécharger des fichiers d'HDFS sur le namenode.

[HDFS DFS Commands](https://hadoop.apache.org/docs/r3.3.1/hadoop-project-dist/hadoop-common/FileSystemShell.html)

### Manipuler HDFS en utilisant Spark/Scala 

[Spark Read Files from HDFS (TXT, CSV, AVRO, PARQUET, JSON)](https://sparkbyexamples.com/spark/spark-read-write-files-from-hdfs-txt-csv-avro-parquet-json/)

### Faire un build de votre projet Scala, déployer le jar sur le namenode et faire un Spark-Submit en utilisant Yarn.

La manipulation faite précédemment depuis votre ordinateur via IntelliJ vers le namenode doit maintenant être faite avec un jar déployé sur le namenode.
Vous devez utiliser la commande Spark Submit pour que le jar soit lancé via le ressource manager Yarn.

### Apprendre à utiliser Docker

[Apprendre Docker](https://www.youtube.com/watch?v=eGz9DS-aIeY)

### Apprendre à utiliser Spring Boot avec MongoDB

[Apprendre Mongo avec Spring](https://www.youtube.com/watch?v=ssj0CGxv60k&list=WL&index=13&t=3s&ab_channel=Amigoscode)
