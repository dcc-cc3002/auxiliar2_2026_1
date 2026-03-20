package army

import soldier.Soldier

import scala.collection.mutable.ArrayBuffer

/**
 * Represents an army that manages a collection of soldiers.
 *
 * An army has a name and maintains a mutable roster of soldiers that can
 * join or leave at any time.
 *
 * @param name the name of the army.
 */
class Army(val name: String) {
  private var soldiers: ArrayBuffer[Soldier] = new ArrayBuffer[Soldier]

  /**
   * Returns the current list of soldiers in the army.
   *
   * @return the mutable buffer containing all active soldiers.
   */
  def getSoldiers: ArrayBuffer[Soldier] = {
    soldiers
  }

  /**
   * Adds a soldier to the army roster.
   *
   * @param soldier the soldier to add.
   */
  def join(soldier: Soldier): Unit = {
    soldiers += soldier
  }

  /**
   * Removes a soldier from the army roster.
   *
   * If the soldier is not in the army, this method does nothing.
   *
   * @param soldier the soldier to remove.
   */
  def leave(soldier: Soldier): Unit = {
    val index: Int = soldiers.indexOf(soldier)
    if (index >= 0) {
      soldiers.remove(index)
    }
  }

  /**
   * Prints the army roster to standard output.
   *
   * Displays the army name followed by a comma-separated list of soldier names.
   * If the army has no soldiers, displays "(vacío)" instead.
   */
  def showRoster(): Unit = {
    val names = this.getSoldiers.map(_.name).mkString(", ")
    println(s"Integrantes de ${this.name}: [${if (names.nonEmpty) names else "(vacío)"}]")
  }
}
