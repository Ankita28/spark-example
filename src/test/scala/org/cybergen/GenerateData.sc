

val set1 = (0 to 30 ).toArray

(0 to 100 ).foreach(i => {
  println(set1((math.random*1000%30).toInt)+","+i)
}
)