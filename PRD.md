# 📄 PRD — Documento de Requisitos do Produto

| | |
|---|---|
| **App** | Hayan Telecom |
| **Grupo** | 3º ano A — Ensino Médio |
| **Autores** | Hayan Matheus, Alberto Vinicius e Gabriel Fernando |
| **Versão do documento** | 1.0 |
| **Última atualização** | 23/09/2026 |
| **Status** | ( ) Rascunho ( ) Em revisão ( ) Aprovado |

---

## 1. Visão do produto

**Pitch:**
> O app Hayan Telecom ajuda clientes a verificar seu plano sem precisar de ir até o estabelecimento presencial ou enviar mensagens.

**Problema:**
Os clientes da Hayan Telecom as vezes moram a uma distância considerável do local do estabelecimento, ou seja, é bem provável que suas rotinas sejam afetadas ao irem ao estabelecimento.

**Por que vale a pena fazer isso:**
O cliente consegue verificar informações do seu plano sem precisar ir até o estabelecimento ou mandar mensagem.

---

## 2. Público e cenário de uso

**Usuário-alvo:**

Clientes, ou possíveis clientes da Hayan Telecom.

**História de uso:**
> "O cliente está em casa e precisa saber se seu plano está ativo. Ele abre o app, olha o status do plano e, caso esteja suspenso, pode acessar a opção de renovação."

---

## 3. Objetivos e não-objetivos

**Objetivos desta versão (v1.0):**

1. Mostrar se o plano está ativo ou não.
2. Permitir renovar o plano caso ele não esteja ativo.
3. Permitir enviar uma requisição de instalação.

**Não-objetivos (fora do escopo):**

- ❌ Não vamos fazer todas as funcionalidades agora, pois primeiro vamos trabalhar na interface.
- ❌ Não vamos fazer chat ou atendimento pelo aplicativo.
- ❌ Não vamos adicionar outras funções que não estejam no MVP.

---

## 4. Requisitos funcionais

| ID | História de usuário | Critério de aceite | Prioridade |
|---|---|---|---|
| RF01 | Como usuário, quero ver meu perfil para saber qual conta estou usando. | Ao abrir o app, o nome e a foto do usuário aparecem na tela principal. | Must |
| RF02 | Como usuário, quero ver se meu plano está ativo para saber sua situação. | Ao abrir a tela principal, aparece claramente se o plano está ativo ou não. | Must |
| RF03 | Como usuário, quero renovar meu plano caso ele não esteja ativo. | Quando o plano estiver suspenso, a opção de renovação aparece e mostra o valor da cobrança. | Must |
| RF04 | Como usuário, quero enviar uma requisição de instalação. | Ao acessar a opção de instalação, o usuário consegue preencher e enviar a requisição. | Should |
| RF05 | Como usuário, quero acessar as opções do app pela tela principal. | A tela principal possui acesso para as outras funções do app. | Could |

---

## 5. Requisitos não funcionais

| ID | Requisito | Como será verificado |
|---|---|---|
| RNF01 | O app não pode fechar sozinho durante o uso normal. | Usar o app por 5 minutos sem ele fechar. |
| RNF02 | Quando alguma operação der erro, o app deve tratar o erro. | Testar as operações e verificar se o app continua funcionando. |
| RNF03 | Nenhuma falha pode fechar o app. | Fazer testes de erro e verificar se aparece uma mensagem. |
| RNF04 | O app roda a partir do Android `[DEFINIR]`. | Instalar em um celular e testar. |
| RNF05 | Os textos visíveis ficam em `strings.xml`. | Revisar o código. |
| RNF06 | Todo arquivo do pacote do app tem comentário de fronteira escrito pelo grupo. | Revisar o código. |
| RNF07 | Qualquer integrante consegue localizar e alterar qualquer parte do app. | Fazer uma mudança pequena no projeto. |
| RNF08 | O app deve ser simples de usar. | Uma pessoa de fora do grupo deve conseguir usar as funções principais. |

---

## 6. Telas e navegação

**Mapa de navegação:**

```text
[Tela Principal]
      │
      ├── Perfil do usuário
      │
      ├── Status do plano
      │
      ├── Renovação → [Valor da cobrança]
      │
      └── Instalação → [Formulário de instalação]
```

| Tela | O que mostra | Ações disponíveis |
|---|---|---|
| Principal | Perfil do usuário, status do plano e acesso às outras funções. | Ver informações, acessar renovação e instalação. |
| Renovação | Valor da cobrança do plano. | Ver o valor e renovar o plano. |
| Instalação | Formulário de requisição de instalação. | Preencher e enviar a requisição. |

**Rascunhos das telas:**

- `docs/telas/01-principal.png`
- `docs/telas/02-renovacao.png`
- `docs/telas/03-instalacao.png`

---

## 7. Dados

### Se Opção A ou C (Room)

**Entidade principal:** `[DEFINIR]`

| Campo | Tipo | Obrigatório | Observação |
|---|---|---|---|
| `id` | Long | sim | chave primária, autogerada |
| `nome` | String | sim | nome do usuário |
| `statusPlano` | String | sim | mostra se o plano está ativo ou não |
| `valorPlano` | Double | sim | valor da cobrança |
| `foto` | String | não | foto do usuário |

**Operações necessárias:** (x) inserir (x) listar ( ) atualizar ( ) excluir

### Se Opção B ou C (Retrofit)

Não definido no Canvas.

---

## 8. Arquitetura e tecnologias

| Item | Escolha |
|---|---|
| Linguagem | Kotlin |
| Interface | `[DEFINIR]` |
| Persistência | `[DEFINIR]` |
| Rede | `[DEFINIR]` |
| Outras bibliotecas | `[DEFINIR]` |
| `minSdk` / `targetSdk` | `[DEFINIR]` / `[DEFINIR]` |

**Organização de pastas do projeto:**

```text
app/src/main/java/br/edu/ifpe/hayan_telecom/
├── ui/        # telas
├── data/      # dados
└── MainActivity.kt
```

---

## 9. Tratamento de erros

| Situação de falha | O que o app faz | Mensagem para o usuário |
|---|---|---|
| Campo obrigatório em branco | Não envia e pede para preencher. | "Preencha os campos obrigatórios." |
| Erro ao salvar os dados | Mostra uma mensagem e continua na tela. | "Não foi possível salvar. Tente novamente." |
| Lista vazia | Mostra que não há dados. | "Nenhum dado encontrado." |
| Erro ao carregar dados | Mantém a tela e mostra uma mensagem. | "Não foi possível carregar os dados." |

---

## 10. Identidade visual e publicação

| Item | Definição | Onde fica |
|---|---|---|
| Nome do app | Hayan Telecom | `strings.xml` |
| Cor principal | `#______` | `Color.kt` |
| Cor secundária | `#______` | `Color.kt` |
| Ícone 512×512 | `[DEFINIR]` | `loja/icone-512.png` |
| `applicationId` | `br.edu.ifpe.hayan_telecom` | `build.gradle.kts` |
| `versionName` / `versionCode` | `1.0` / `1` | `build.gradle.kts` |

**Material da loja:**

| Artefato | Limite | Conteúdo |
|---|---|---|
| Título | 30 caracteres | Hayan Telecom |
| Descrição curta | 80 caracteres | Aplicativo para consultar o plano e solicitar serviços. |
| Descrição completa | — | A definir durante o projeto. |
| Imagem de destaque | 1024×500 | A definir. |
| Screenshots | mín. 2 | `loja/screenshots/` |
| Esboço de privacidade | — | A definir. |
| Arquivo `.aab` | — | `loja/app-release.aab` |

---

## 11. Plano de testes

| # | O que testar | Passos | Resultado esperado | OK? |
|---|---|---|---|---|
| T1 | Abrir o app pela primeira vez | Instalar e abrir | Tela principal aparece. | |
| T2 | Ver o status do plano | Abrir o app e olhar a tela principal | O status do plano aparece. | |
| T3 | Renovação | Acessar a renovação quando o plano estiver suspenso | O valor da cobrança aparece. | |
| T4 | Requisição de instalação | Abrir o formulário, preencher e enviar | A requisição é enviada. | |
| T5 | Teste com usuário externo | Pessoa de fora usa o app sem explicação | Consegue usar as funções principais. | |

**Testado em:** `[DEFINIR 2 aparelhos]`

---

## 12. Cronograma

| Marco | Prazo | Responsável | Status |
|---|---|---|---|
| M1 — Canvas + repositório | 16/09 | Grupo | Concluído |
| M2 — PRD aprovado + telas | 30/09 | Grupo | Em andamento |
| M3 — Funcionalidade base | 21/10 | Grupo | |
| M4 — Dados e erros tratados | 11/11 | Grupo | |
| M5 — Identidade + `.apk` testado | 25/11 | Grupo | |
| M6 — `.aab` + loja + README | 02/12 | Grupo | |
| **Entrega e apresentação** | **10/12** | Grupo | |

---

## 13. Riscos

| Risco | Impacto | Plano B |
|---|---|---|
| A funcionalidade ficar maior do que o esperado | Alto | Manter somente as funções do MVP. |
| Integrante ficar sem computador | Médio | Outro integrante continua a parte necessária e depois compartilha as mudanças. |
| Problemas durante a implementação | Médio | Simplificar a funcionalidade e manter o que já estiver funcionando. |

---

## 14. Como vamos orientar a implementação com IA

**Recursos que vamos usar:**

- (x) Chat
- (x) Agent Mode
- (x) Explain Code
- (x) Ask Gemini no Logcat
- (x) Generate Unit Tests
- ( ) Transform UI

**Regras que colocamos no `AGENTS.md`:**

- A IA não deve adicionar funcionalidades que não estejam no PRD.
- Toda mudança feita pela IA deve ser lida e entendida pelo grupo.
- O código deve continuar simples para que todos consigam explicar o projeto.

**Divisão do perímetro explicável:**

| Parte do código | Responsável |
|---|---|
| Telas (`ui/`) | Hayan Matheus |
| Dados (`data/`) | Alberto Vinicius |
| Identidade visual e recursos | Gabriel Fernando |
| Build e artefatos de loja | Grupo |

**Decisões que o grupo tomou contra a sugestão da IA:**

- Manter o projeto simples e focado nas funções do Canvas.
- Não adicionar funções que não sejam necessárias para o MVP.
- Priorizar uma interface fácil de entender.

---

## 15. Histórico de versões deste documento

| Versão | Data | Autor | O que mudou |
|---|---|---|---|
| 1.0 | 23/09/2026 | Hayan Matheus, Alberto Vinicius e Gabriel Fernando | Versão inicial |
