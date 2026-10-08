# 📡 Hayan Telecom — App Android

> Aplicativo Android desenvolvido em **Kotlin** e **Jetpack Compose** para clientes de provedores de internet consultarem o status do seu plano, verificarem mensalidades, acessarem boletos e realizarem o pagamento.

---

## 👥 Equipe do Projeto
- **Hayan Matheus** — Interface, navegação, tela principal, boletos e identidade visual
- **Alberto Vinicius** — Estrutura de dados, Room, Retrofit e lógica de planos e cobranças
- **Gabriel Fernando** — Estrutura de dados, Room, tela de login, cadastro e minha conta

**Turma:** 3º ano A — Ensino Médio  
**Entrega Final:** 10/12/2026

---

## 🚀 Funcionalidades da Versão 1.0 (MVP)

1. **🔐 Autenticação (Login e Cadastro)**
   - Autenticação com e-mail/CPF e senha.
   - Validação de campos obrigatórios e tratamento de credenciais inválidas.
   - Encerramento de sessão (*Sair da conta*).

2. **📊 Início (Dashboard)**
   - Saudação personalizada e código do cliente (`HT-001284`).
   - Resumo do plano contratado e status atual (*Ativo / Suspenso*).
   - Card de cobrança pendente com atalho direto para consulta do boleto.

3. **📶 Meu Plano**
   - Detalhes da velocidade contratada e valor mensal.
   - Informações do titular (Nome, CPF, Código e Endereço de Instalação).

4. **📄 Boletos e Cobranças**
   - Listagem organizada entre mensalidades *"Em aberto"* e *"Histórico de pagamentos"*.
   - Detalhes do boleto com exibição do valor, data de vencimento e linha digitável.
   - Copiar código de barras para a área de transferência.
   - Simulação de pagamento da mensalidade (integração Asaas Sandbox / Room).

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Kotlin
- **Interface Gráfica:** Jetpack Compose + Material 3
- **Navegação:** Navigation Compose
- **Persistência Local:** Room Database + KSP
- **Comunicação Remota:** Retrofit 2 + Gson Converter
- **Asincronismo:** Kotlin Coroutines & Flow
- **Arquitetura:** MVVM simplificado com Repositório

---

## 🎨 Identidade Visual

- **Nome exibido:** Hayan Telecom
- **Cor Primária:** `#424F8F` (`BluePrimary`)
- **`applicationId`:** `br.edu.ifpe.hayantelecom`

---

## 💻 Como Executar o Projeto

1. Abra o **Android Studio** (versão Ladybug ou superior recomendada).
2. Selecione **Open** e escolha a pasta do projeto.
3. Aguarde a sincronização do Gradle (*Gradle Sync*).
4. Conecte um dispositivo Android físico ou inicie um emulador (Android 7.0 / API 24+).
5. Clique no botão **Run 'app'** (`Shift + F10`).

---

## 📂 Estrutura de Pastas

```text
br.edu.ifpe.hayantelecom/
├── data/
│   ├── local/              # Room (AppDatabase, DAOs)
│   ├── remote/             # Retrofit (API Asaas)
│   └── repository/         # HayanRepository (Gestão de Dados)
├── model/                  # Entidades (Cliente, Plano, Cobranca)
├── ui/
│   ├── theme/              # Color.kt (#424F8F), Type.kt, Theme.kt
│   ├── navigation/         # NavGraph.kt e NavTarget.kt
│   ├── components/         # BottomBar, TopBar, StatusChip
│   └── features/
│       ├── auth/           # LoginScreen, CadastroScreen
│       ├── home/           # HomeScreen
│       ├── plan/           # PlanScreen
│       ├── invoices/       # InvoicesScreen, InvoiceDetailScreen
│       └── profile/        # ProfileScreen
└── MainActivity.kt
```
