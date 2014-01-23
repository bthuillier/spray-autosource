package fr.bthuillier.spray.autosources.directives

import play.api.libs.json.Format

/**
 *
 * User: benjaminthuillier
 * Date: 23/01/14
 * Time: 23:36
 *
 */
class ReactiveMongoAutosourcesDirectives[T](implicit val format: Format[T]) extends AutosourcesDirectives[T] {

  def create(obj: T): T = ???

  def update(obj: T): Option[T] = ???

  def del(id: String): Option[String] = ???

  def find(id: String): Option[T] = ???

  def collections: List[T] = ???
}
