import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, SparkSession}

object Main {
  def main(args: Array[String]): Unit = {
    firstExample()
  }

  def firstExample(): Unit = {
    val sparkSession = SparkSession.builder().appName("My first Spark APP").master("local").getOrCreate()
    val schema = StructType(
      Seq(
        StructField("nom", StringType),
        StructField("prenom", StringType),
        StructField("age", IntegerType)
      )
    )
    val data: DataFrame = sparkSession
      .read
      .schema(schema)
      .option("header", true)
      .csv("data")

    data.show()
    data.printSchema()
  }

  // learning spark sql function and rdd
  def crud(): Unit = {
    val spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .config("spark.master", "local")
      .getOrCreate()

    val df = spark.read.option("multiline", "true").json("hdfs://localhost:9000/user/yohan/test/example.json")

    val names = df.select("name")

    val data = spark.range(0, 5)
    data.write.format("delta").save("/tmp/delta-table")

    names.show()

    names.distinct().show()

    //names.write.json("hdfs://localhost:9000/user/yohan/test/namesssss.json")

    spark.stop()
  }

  // example loop while
  def loopingWhile(): Unit = {
    var i: Int = 0
    while (i < 10) {
      println(i)
      i += 1
    }
  }

  // example loop for
  def loopingFor(): Unit = {
    println("Boucle for")
    for (i <- 0 to 9) println(i)

  }

  // example function with if
  def max(x: Int, y: Int): Int = if (x > y) x else y


  // example of anonymous function with list
  def anonymousFunction(): Unit = {
    val list = List("bleu", "blanc", "rouge", "vert")
    val listWithB = list.filter(s => s.startsWith("b"))
    println(listWithB)
    val countB = list.count(s => s.startsWith("b"))
    println("Combien d'élément qui commence par b ? " + countB)
  }

  // example of function with few arguments specified
  def currying(): Unit = {

    def divs(m: Int)(n: Int) = (n % m == 0)

    val param1 = divs(2) _

    print(param1(4))

  }

  def datastructures(): Unit = {
    val array = new Array[String](3)
    array(0) = "Hello"
    array(1) = " "
    array(2) = "World"
    array.foreach(s => print(s))
    println()
    //List of String
    val list = List("Hello", " ", "I am ", " learning ", "Scala!")
    list.foreach(s => print(s))
    println()
    //List of Any
    val listOfAny = List("It's ", "a list ", 'o', 'f', " any : ", 62)
    listOfAny.foreach(s => print(s))

    println(listOfAny(0))

    val listOfInt = List(1, 2, 3, 43, 23, 24, 54)

    // print all element > 10
    listOfInt.filter(_ > 10).foreach(s => println(s))

    //List in scala are immutable
    val listIsImmutable = 1 :: 2 :: 3 :: Nil
    val listCanYetBeModifiedLikeThis = listIsImmutable ::: 4 :: Nil
    listCanYetBeModifiedLikeThis.foreach(s => println(s))

  }
}