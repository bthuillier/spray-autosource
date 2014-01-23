package fr.bthuillier.spray.autosources.directives

import spray.routing.Directives._
import play.api.libs.json._
import spray.routing.{Directive1, Directive, Route}

/**
 *
 * User: benjaminthuillier
 * Date: 23/01/14
 * Time: 14:20
 *
 */
trait AutosourcesDirectives[T] {
  import spray.httpx.PlayJsonSupport._
  implicit def format: Format[T]

  def unmarshalling = entity(as[T])

  def autosource(prefix: String): Route = {
    pathPrefix(prefix) {
      get { complete(collections) } ~
      post {
        unmarshalling { t =>
          complete(update(t)) }} ~
      path(Segment) { id =>
        get {
          isDefined(find(id)) { obj =>
            complete(obj)}} ~
        delete {
          isDefined(del(id)) { i =>
            complete(Json.obj("id" -> i))}} ~
        put {
          unmarshalling { t =>
            isDefined(update(t)) { obj =>
              complete(obj) }}}}}
  }

  def isDefined[X](xOpt: Option[X]): Directive1[X] = provide(xOpt).flatMap {
    case Some(x) => provide(x)
    case None    => reject
  }

  def create(obj: T): T

  def update(obj: T): Option[T]

  def del(id: String): Option[String]

  def find(id: String): Option[T]

  def collections: List[T]

}
