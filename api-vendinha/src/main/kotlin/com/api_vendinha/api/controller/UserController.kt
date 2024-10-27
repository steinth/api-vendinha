package com.api_vendinha.api.controller

import com.api_vendinha.api.domain.dtos.request.UserRequestDto
import com.api_vendinha.api.domain.dtos.response.UserResponseDto
import com.api_vendinha.api.domain.service.UserServiceInterface
import org.springframework.web.bind.annotation.*


@CrossOrigin("*")
@RestController
@RequestMapping("/user")
class UserController (
    val userService: UserServiceInterface
) {
    @PostMapping("/save")
    fun save(@RequestBody userRequestDto: UserRequestDto) : UserResponseDto {
        return userService.save(userRequestDto)
    }

    @GetMapping("/list")
    fun listUsers():List<UserResponseDto>{
        return userService.listUsers()
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
