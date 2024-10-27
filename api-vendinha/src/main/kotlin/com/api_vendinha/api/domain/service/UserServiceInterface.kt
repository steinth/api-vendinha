package com.api_vendinha.api.domain.service

import com.api_vendinha.api.domain.dtos.request.UserRequestDto
import com.api_vendinha.api.domain.dtos.response.UserResponseDto


interface UserServiceInterface {

    fun save(userRequestDto: UserRequestDto): UserResponseDto

    fun listUsers(): List<UserResponseDto>

    fun update(
        id:Long,
        userRequestDto: UserRequestDto
    ): UserResponseDto

    fun findUser(id: Long): UserResponseDto
    fun changeStatus(id: Long, status:Boolean): UserResponseDto
}
