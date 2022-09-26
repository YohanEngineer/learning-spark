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
}