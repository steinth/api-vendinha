package com.api_vendinha.api.controller

import com.api_vendinha.api.domain.dtos.request.UserRequestDto
import com.api_vendinha.api.domain.dtos.response.UserResponseDto
import com.api_vendinha.api.domain.service.UserServiceInterface
import org.springframework.web.bind.annotation.*

// Marca a classe como um controlador REST do Spring, que irá lidar com requisições HTTP e retornar respostas diretamente no corpo da resposta.
@RestController
// Define o caminho base para todos os endpoints dentro deste controlador. Neste caso, todos os endpoints começam com "/user".
@RequestMapping("/user")
class UserController (
    // Injeção de dependência do serviço de usuário. O controlador usa este serviço para processar dados relacionados a usuários.
    val userService: UserServiceInterface
) {
    // Mapeia este metodo para responder a requisições POST no caminho "/user/save".
    @PostMapping("/save")
    // O metodo recebe um objeto `UserRequestDto` no corpo da requisição, e retorna um objeto `UserResponseDto` após chamar o serviço para salvar o usuário.
    fun save(@RequestBody userRequestDto: UserRequestDto) : UserResponseDto {
        // Chama o metodo `save` do serviço de usuário passando o DTO recebido e retorna o resultado.
        return userService.save(userRequestDto)
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody userRequestDto: UserRequestDto
    ):UserResponseDto{
        return userService.update(id, userRequestDto)
    }

    @GetMapping("/{id}")
    fun findUser(@PathVariable id: Long):UserResponseDto{
        return userService.findUser(id)
    }

    @PutMapping("/{id}/status/{status}")
    fun changeStatus(
        @PathVariable id: Long,
        @PathVariable status:Boolean
    ):UserResponseDto{
        return userService.changeStatus(id, status)
    }
}
