# API VENDAS

### DOCUMENTAÇÃO

## Iniciar o Serviço

Essas instruções ajudarão você a executar uma cópia do projeto em sua máquina local para desenvolvimento e testes. Para informações sobre como implantar o projeto em um sistema ativo, consulte a seção de implantação.

## Design de Software
- SOLID

## Framework
- SPRING FRAMEWORK

## ORM
- HIBERNATE


## Funcionalidades para o usuário

### Criar Usuário
- **Método**: POST
- **URL**: `/user`
- **Campos**:
    1. `name`
    2. `email`
    3. `password`
    4. `is_active`
    5. `cpf_cnpj`

**Exemplo de `curl`**:

```bash
curl --location 'http://localhost:8081/user/save' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "John Doe",
    "email": "john.doe@example.com",
    "password": "password123",
    "is_active": true,
    "cpf_cnpj": "12345678901"
}'
```
### Atualizar Usuário
- **Método**: PUT
- **URL**: `/user/{id}`
- **Campos**:
    1. `name`
    2. `email`
    3. `password`
    4. `is_active`
    5. `cpf_cnpj`

**Exemplo de `curl`**:

```bash
curl --location --request PUT 'http://localhost:8081/user/1' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Carlos Rafael",
    "email": "john.doe@example.com",
    "password": "password123",
    "is_active": true,
    "cpf_cnpj": "12345678901"
}'
```
### Encontrar Usuário pelo ID
- **Método**: GET
- **URL**: `/user/{id}`

**Exemplo de `curl`**:

```bash
curl --location 'http://localhost:8081/user/1'
```

### Inativar ou Ativar usuário pelo ID
- **Método**: PUT
- **URL**: `/user/{id}/status/{status}`
- **Campos**:
    1. `is_active`

**Exemplo de `curl`**:

```bash
curl --location --request PUT 'http://localhost:8081/user/1/status/false' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID.7e3e6227=node0ov95b8jfvk8j1ei56yaq9htyk0.node0' \
--data ''
```
