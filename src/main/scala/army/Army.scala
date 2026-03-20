package army

import soldier.Soldier

import scala.collection.mutable.ArrayBuffer

class Army(val name: String) {
  var soldiers: ArrayBuffer[Soldier] = new ArrayBuffer[Soldier]
  def join(soldier: Soldier): Unit = {
    soldiers.addOne(soldier)
  }
  
  def leave(soldier: Soldier): Unit = {
    val index: Int = soldiers.indexOf(soldier)
    soldiers.remove(index)
  }
}
