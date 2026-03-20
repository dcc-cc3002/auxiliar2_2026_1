package soldier

import army.Army

/**
 * Represents a soldier that can belong to an army and engage in combat.
 *
 * A soldier has health points that decrease when attacked. When hp drops
 * to 0 or below, the soldier dies and automatically leaves their army.
 * A soldier can belong to at most one army at a time.
 *
 * @param name   the name of the soldier.
 * @param hp     the health points of the soldier. Reaching 0 or below means death.
 * @param attack the damage inflicted on another soldier per attack.
 */
class Soldier(val name: String, var hp: Int, val attack: Int) {
  private var isAlive: Boolean = true
  var army: Army = null

  /**
   * Attacks another soldier, reducing their hp by this soldier's attack value.
   *
   * If the target's hp drops to 0 or below, the target dies and leaves their army.
   *
   * @param soldier the target soldier to attack.
   */
  def attackSoldier(soldier: Soldier): Unit = {
    soldier.hp -= attack
    if (soldier.hp <= 0) {
      soldier.die()
      soldier.leaveArmy()
    }
  }

  /** Marks this soldier as dead. */
  private def die(): Unit = {
    isAlive = false
  }

  /**
   * Joins the given army.
   *
   * If the soldier already belongs to an army, they leave it first
   * before joining the new one.
   *
   * @param newArmy the army to join.
   */
  def joinArmy(newArmy: Army): Unit = {
    if (army != null) {
      this.leaveArmy()
    }
    newArmy.join(this)
    army = newArmy
  }

  /**
   * Leaves the current army.
   *
   * If the soldier does not belong to any army, this method does nothing.
   */
  def leaveArmy(): Unit = {
    if (army != null) {
      army.leave(this)
      army = null
    }
  }
}
