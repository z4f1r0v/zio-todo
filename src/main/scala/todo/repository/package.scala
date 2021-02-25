package todo

import zio._

package object repository {
  type TodoRepository = Has[TodoRepository.Service]
}
