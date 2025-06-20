
# 🚀 Sistema NESBUS – Integração Front (Bubble) + Back (Spring Boot) + Ngrok

O NESBUS é um sistema para gerenciamento de viagens de pacientes, composto por:

- **Front-end:** criado no **Bubble**, onde os usuários interagem, fazem solicitações e administradores aprovam.
- **Back-end:** desenvolvido em **Java com Spring Boot**, responsável pelos dados dos Usuários e Viagens
- **Ngrok:** usado durante o desenvolvimento para permitir que o Bubble envie e receba dados da API mesmo localmente.

---

## 📌 Como Funciona

```
[ Usuário ]
   |
   v
[ Bubble (Interface) ]
   |
   | 
   v
[ Ngrok (exposição segura) ]
   |
   v
[ Spring Boot (API REST local) ]
   |
   v
[ Banco de Dados ]
```

---

## 🎨 Front-end com Bubble

No Bubble ocorre:

- Solicitações de viagens (com ou sem acompanhante)
- Aprovação ou rejeição de solicitações
- Visualizações de todos os dados
- Controle de vagas disponíveis
- Marcar viagens como realizadas


Bubble se comunica diretamente com a API do Spring usando chamadas HTTP (GET, POST, PATCH...), usando o link do **Ngrok** para acessar o back-end.

---

## 🧠 Back-end com Spring Boot

A API desenvolvida em Java com Spring Boot é responsável por:

- CRUD de usuários
- CRUD de viagens
- Expor os dados para o Bubble via JSON

### Exemplo de Endpoints:

| Ação              | Método | URL                 |
|-------------------|--------|---------------------|
| Criar viagem      | POST   | `api/viagem`        |
| Listar viagens    | GET    | `api/viagem/listar` |
| Criar usuários    | GET    | `api/usuario`       |

---

## 🌐 Conexão via Ngrok

Ngrok é usado para gerar um **link público** que aponta para o seu back-end local (`localhost:8080`). Isso permite que o Bubble consiga fazer requisições mesmo que o servidor esteja rodando apenas no seu computador.
![img_1.png](img_1.png)