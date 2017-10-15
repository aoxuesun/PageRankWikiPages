import org.apache.spark._
import org.apache.spark.graphx._
import org.apache.spark.rdd.RDD
import java.lang.System.currentTimeMillis

object ord extends Ordering[(VertexId, Double)] { def compare(a:(VertexId, Double), b:(VertexId, Double)) = a._2 compare b._2}

val graph = GraphLoader.edgeListFile(sc, "hdfs://ec2-52-207-68-106.compute-1.amazonaws.com:9000/input/modifiedRelations.txt")

val startTime = System.currentTimeMillis()
val ranks = graph.staticPageRank(3)
val endTime = System.currentTimeMillis()
println("time: " + (endTime - startTime))
