package fr.bthuillier.spray.autosources.directives

import spray.routing.Directives._
import play.api.libs.json._
import spray.routing.Route

/**
 *
 * User: benjaminthuillier
 * Date: 23/01/14
 * Time: 14:20
 *
 */
trait AutosourcesDirectives {
  def autosource[T](prefix: String, obj: T)(implicit format: Format[T]): Route = pathPrefix(prefix) {
    import spray.httpx.PlayJsonSupport._
    get {
      complete(obj) } ~
    post {
      entity(as[T]) { t =>
      complete(t) }} ~
    path(Segment) { id =>
      get {
        complete(obj) } ~
      delete {
        complete(Json.obj("id" -> id)) } ~
      put {
        entity(as[T]) { t =>
        complete(t) }}}}
}
