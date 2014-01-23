package fr.bthuillier.spray.autosources.directives

import spray.routing.Directives._
/**
 *
 * User: benjaminthuillier
 * Date: 23/01/14
 * Time: 14:20
 *
 */
trait AutosourcesDirectives {
  def autosource(prefix: String) = pathPrefix(prefix) {
    get {
      complete("ok") } ~
    post {
      complete("ok") } ~
    path(Segment) { id =>
      get {
        complete("ok") } ~
      delete {
        complete("ok") } ~
      put {
        complete("ok") }}}
}
