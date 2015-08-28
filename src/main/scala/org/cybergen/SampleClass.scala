package org.cybergen

/**
 * Class org.cybergen.SampleClass
 * Created by vishnu667 on 5/8/15.
 */

class SampleClass(val min:Int =0,val max:Int) extends Serializable{

  val boolArray = (0 to max).map(math.random*_>0)

  override def toString():String = min.toString
}
