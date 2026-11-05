# Relatório Técnico — Projeto Hayan Telecom

Este diagnóstico e planejamento técnico foram elaborados com base nos documentos `CANVAS.md`, `PRD.md`, `AGENTS.md` e nas especificações de telas e protótipos fornecidas.

---

## 1. Diagnóstico do Repositório

### Situação Atual:
- **Estrutura Básica:** O projeto já possui a estrutura de pacotes inicial (`data`, `model`, `ui`).
- **Navegação:** Existe um `NavGraph` e `NavTarget` configurados, porém limitados à rota "home".
- **Modelos:** As classes `Cliente`, `Plano` e `Cobranca` já possuem anotações `@Entity` para o Room.
- **Documentação:** Os arquivos de gestão (`CANVAS.md`, `PRD.md`) foram movidos para a raiz conforme o guia do GitHub, o que está correto.

### O que precisa ser organizado/ajustado:
- **Nomenclatura de Pacotes:** O `applicationId` definido no PRD é `br.edu.ifpe.hayantelecom`, mas a estrutura de pastas atual é `com.example.hayantelecom`. Isso deve ser corrigido para evitar conflitos futuros.
- **Camada de UI:** A pasta `ui/features` está vazia. É necessário criar subpastas para cada tela obrigatória (Login, Home, Boletos, etc.).
- **Recursos Visuais:** A pasta `res/values/colors.xml` e o arquivo `Color.kt` precisam ser atualizados com a identidade visual (#424F8F).

---

## 2. Arquitetura de Pastas Proposta

Para garantir a simplicidade e manutenibilidade exigidas pelo grupo, seguiremos uma arquitetura **Clean-ish MVVM** simplificada:

```
br.edu.ifpe.hayantelecom/
├── data/
│   ├── local/              # Room (Database, DAOs)
│   ├── remote/             # Retrofit (Asaas API - Futuro)
│   └── repository/         # Lógica de dados (Repositórios)
├── model/                  # Entidades (Cliente, Plano, Cobranca)
└── ui/
    ├── theme/              # Color.kt, Type.kt, Theme.kt
    ├── navigation/         # NavGraph.kt (Gerenciamento de rotas)
    ├── components/         # Componentes reutilizáveis (Botões, Cards)
    └── features/
        ├── auth/           # Telas de Login e Cadastro
        ├── home/           # Dashboard inicial
        ├── plan/           # Detalhes do Plano
        ├── invoices/       # Listagem e Detalhes de Boletos
        └── profile/        # Minha Conta / Logout
```

---

## 3. Plano de Implementação em Marcos

1.  **Marco 3 (Funcionalidade Base):**
    *   Configuração do Tema (Cores e Fontes).
    *   Implementação da Navegação Inferior (BottomBar).
    *   Criação das telas de Login e Home com dados mockados.
    *   Implementação do `try/catch` básico no login.

2.  **Marco 4 (Persistência e Dados):**
    *   Finalização das DAOs do Room.
    *   Integração das telas de "Meu Plano" e "Boletos" com o banco local.
    *   Tratamento de erros de banco de dados e falta de dados.

3.  **Marco 5 (Identidade e Refinamento):**
    *   Aplicação rigorosa da tipografia (Manrope/DM Sans).
    *   Ajuste de paddings e arredondamentos (12-16dp).
    *   Testes de usabilidade e geração do APK de release.

---

## 4. Exemplos de Código Inicial

### Configuração de Cores (`ui/theme/Color.kt`)
```kotlin
package br.edu.ifpe.hayantelecom.ui.theme

import androidx.compose.ui.graphics.Color

val BluePrimary = Color(0xFF424F8F)
val BlueSecondary = Color(0xFF5C6BC0)
val BackgroundGray = Color(0xFFF5F5F5)
val SuccessGreen = Color(0xFF4CAF50)
val ErrorRed = Color(0xFFE53935)
```

### Modelagem de Dados para Room (Exemplo `Cobranca.kt`)
```kotlin
package br.edu.ifpe.hayantelecom.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cobrancas")
data class Cobranca(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val valor: Double,
    val dataVencimento: String,
    val status: String, // "PAGO", "EM_ABERTO", "VENCIDO"
    val codigoBarras: String,
    val clienteId: String
)
```

---
*Este documento serve como guia oficial para o desenvolvimento do app Hayan Telecom.*

## Implementação Retrofit e Integração com API (05/11/2026)

### Resumo das Modificações
Implementada a camada de rede utilizando Retrofit para integração com a API Sandbox do Asaas. Os dados de cobranças agora podem ser sincronizados remotamente e persistidos localmente no Room.

### Arquivos Criados
- `data/remote/AsaasApiService.kt`: Interface de definição dos endpoints.
- `data/remote/RetrofitClient.kt`: Configuração da instância Retrofit.
- `data/remote/dto/AsaasCobrancaResponse.kt`: DTOs para mapeamento da resposta JSON.
- `data/remote/mapper/CobrancaMapper.kt`: Lógica de conversão DTO -> Entity.

### Arquivos Alterados
- `app/build.gradle.kts`: Adicionadas dependências do Retrofit e Gson.
- `data/repository/HayanRepository.kt`: Adicionado método `sincronizarCobrancasRemotas` que integra API e Banco de Dados.
- `ui/navigation/NavGraph.kt`: Adicionado `LaunchedEffect` para disparar a sincronização ao carregar a tela principal.

### Detalhes Técnicos
- **Endpoint Utilizado:** `GET /v3/payments` (Listagem de cobranças).
- **Mapeamento de Status:** Convertidos status do Asaas (`RECEIVED`, `CONFIRMED`, `PENDING`, `OVERDUE`) para o domínio interno (`PAGO`, `EM_ABERTO`, `VENCIDO`).
- **Estratégia de Persistência:** O repositório tenta buscar dados remotos; se bem-sucedido, atualiza o Room. A UI consome os dados via `Flow` do Room, garantindo funcionamento offline.
- **Segurança:** Utilizada chave de API Sandbox. Recomenda-se mover para variáveis de ambiente ou backend intermediário em produção.

### Testes Executados
- Verificação de compilação: **OK**.
- Sincronização Gradle: **OK**.
- Mapeamento de dados: Validado via Mapper unitário.
- Fluxo de Navegação: Mantido conforme PRD.

### Pendências
- Implementar tratamento visual de erro (Snackbar) caso a API falhe durante a sincronização na Home.
- Implementar paginação para grandes volumes de cobranças.
