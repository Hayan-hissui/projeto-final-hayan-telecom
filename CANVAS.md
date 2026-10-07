# 🎯 Canvas do Projeto Final — App Android

> **Como usar:** este é o primeiro documento do projeto. Preencha em grupo, em uma única aula, **antes de escrever qualquer linha de código**. Cada bloco tem no máximo 5 linhas — se não couber, o projeto está grande demais.
> Depois de preenchido e validado pelo professor, ele vira a base do [`PRD.md`](PRD.md).

| | |
|---|---|
| **Integrantes (3 a 4)** |Hayan Matheus, Alberto Vinicius e Gabriel Fernando|
| **Turma** | 3º ano A — Ensino Médio |
| **Repositório** | `https://github.com/Hayan-hissui/projeto-final-hayan-telecom` |
| **Data de preenchimento** | 09/09/2026 |
| **Entrega final** | **10/12/2026** |

---

## 🧩 Bloco 1 — Nome e pitch do app

**Nome do app:** _Hayan Telecom_

**Pitch em uma frase:**
> "O app Hayan Telecom ajuda clientes a gerenciar seus boletos e o status do plano atual"
---

## 😖 Bloco 2 — Problema

-
Qual dor real vocês estão resolvendo? Descrevam uma situação concreta que alguém vive hoje.
-
Clientes precisam entrar em contato com a empresa para saber informações básicas sobre seu plano.
A empresa recebe muitas solicitações relacionadas a status do plano e cobranças. Isso aumenta a demanda do atendimento
e diminui a produtividade da equipe.

**Como esse problema é resolvido hoje (sem o app)?**

-
Principalmente por WhatsApp, redes sociais ou atendimento direto.
O cliente precisa esperar um funcionário consultar as informações
e responder. O app centraliza essas informações em um único lugar.


---

## 👥 Bloco 3 — Público-alvo

Para quem é o app? Sejam específicos (idade, contexto, com que frequência usariam).

- **Perfil principal:** Clientes de provedores de internet.
- **Quando/onde usam:** Principalmente em casa, quando precisam consultar o plano ou uma cobrança.
- **Uma pessoa real que testaria o app:** _Jorge, dono da empresa._

---

## 💡 Bloco 4 — Solução em uma tela

Descreva o que a **tela principal** mostra e o que o usuário consegue fazer nela.

- **A tela principal lista:**
- Nome e informações básicas do cliente.
- Plano contratado e situação atual: ativo ou suspenso.
- Valor da mensalidade e situação da cobrança.
- Acesso à tela de detalhes da cobrança.


- **A ação principal do usuário é:** Consultar a situação do plano e verificar se existe uma cobrança pendente.
- **Depois de agir, o usuário vê:** Uma tela com os detalhes da cobrança, incluindo valor, vencimento e situação.

---

## ✅ Bloco 5 — Funcionalidades do MVP

Máximo de **4 funcionalidades**. Se tiver mais, corte. Lembre: *qualidade acima de complexidade*.

| # | Funcionalidade | Essencial? | Quem faz |
|---|---|---|---|
| F1 |	Visualizar o status do plano e dados da cobrança| Sim |Alberto|
| F2 |	Realizar pagamento da mensalidade| Sim |Hayan|
| F3 | Realizar login/cadastro| Sim |Gabriel|

---

## 🚫 Bloco 6 — Fora do escopo

O que o app **não** vai fazer nesta entrega. Escrever isso aqui protege vocês de perder o prazo.

- ❌ Não terá solicitação de instalação.
- ❌ Não terá atendimento por chat ou WhatsApp integrado.
- ❌ Não terá sistema completo de suporte ao cliente.
- ❌ Não terá outros meios de pagamento inicialmente, como Pix ou cartão.

*Sugestões comuns de coisas a deixar de fora: login/cadastro, notificações push, chat, mapa, pagamento, modo offline completo, sincronização em nuvem.*

---

## ⚙️ Bloco 7 — Caminho técnico

Marque **uma** opção (as três valem a mesma nota):

- [ ] **Opção A — Room:** dados salvos no próprio celular (lista de compras, agenda, diário de treino, controle financeiro)
- [ ] **Opção B — Retrofit:** dados vindos de uma API pública (notícias, filmes, feed, clima)
- [X] **Opção C — Desafio:** API + salvar dados localmente

**Se escolheu B ou C — qual API?** _(link da documentação + precisa de chave? é gratuita?)_
Asaas API (gratuita) https://docs.asaas.com/?utm_source=chatgpt.com
Desenvolvimento: será utilizado o Sandbox do Asaas, que permite testar a integração sem movimentar
dinheiro real. O Sandbox possui uma chave de API própria e é separado da produção. 

Chave: sim, é necessária uma chave de API. Durante o desenvolvimento será utilizada a
chave do Sandbox. Em produção será utilizada uma chave própria de produção. 

Custo: o projeto será desenvolvido inicialmente no Sandbox, sem pagamentos reais. Caso o sistema
seja colocado em produção futuramente, serão avaliados os custos e condições do serviço escolhido.

**Bibliotecas que o grupo vai usar:**
- Retrofit: comunicação entre o aplicativo e a API/backend.
- Room: armazenamento local dos dados necessários.
- Jetpack Compose: construção da interface.
- Android Jetpack: componentes e recursos de desenvolvimento Android.
- Kotlin: linguagem principal do projeto.

**Onde entra o `try/catch`?** _(qual operação pode falhar: banco vazio, internet caindo, API fora do ar, campo em branco)_

- Pode falhar:
- conexão com a internet
- comunicação com a API
- API ou servidor indisponível
- login com dados inválidos
- consulta das cobranças
- acesso aos dados do boleto
- erro ao salvar ou consultar dados no banco local.
  
- O usuário vê a mensagem:
- "E-mail ou senha inválidos."
- "Não foi possível conectar ao servidor. Verifique sua internet e tente novamente."
- "Não foi possível carregar suas cobranças. Tente novamente."
- "Não foi possível acessar o boleto no momento. Tente novamente mais tarde."

---

## 🎨 Bloco 8 — Identidade visual

| Item | Definição do grupo |
|---|---|
| Nome exibido (`strings.xml`) |Hayan Telecom|
| Cor principal (hex, em `Color.kt`) | `#424f8f` |
| Ideia do ícone (512×512) |Logo oficial da Hayan Telecom|
| `applicationId` | `br.edu.ifpe.hayantelecom` |
| Versão inicial | `1.0` (versionCode `1`) |

---

## 👤 Bloco 9 — Equipe, papéis e riscos

| Integrante | Papel principal | Responsável por |
|---|---|---|
|Hayan| Dev / telas |Interface, navegação e tela principal|
|Gabriel e Alberto| Dev / dados (Room ou Retrofit) |API, Retrofit, Room e gerenciamento dos dados|
|Hayan| Design e identidade visual |Integração com boletos, identidade visual e testes|
|Todos| Documentação, build e entrega | Organização dos arquivos do projeto e realização de testes|

> Todos programam. O "papel" define quem **responde** por aquela parte, não quem trabalha sozinho.

**Riscos — o que pode dar errado e o plano B:**

| Risco | Plano B |
|---|---|
|Dificuldade na integração com a API de boletos|Utilizar o Sandbox e a documentação oficial do serviço|
|API ou internet indisponível|Exibir uma mensagem de erro e utilizar dados locais quando possível|
|Falta de tempo para concluir o sistema de pagamento|Priorizar login, consulta do plano, cobranças e acesso ao boleto|

---

## 🤖 Bloco 10 — Acordo de trabalho com IA

A implementação pode ser feita com o **Gemini no Android Studio**. Vocês orientam, ele digita — e cada integrante precisa saber explicar o que entrou no projeto. Regras completas em [`docs/USO_DE_IA.md`](docs/USO_DE_IA.md).

**Três regras que vamos escrever no nosso `AGENTS.md`** _(o arquivo que diz à IA como trabalhar no nosso projeto)_:

1. A IA não deve adicionar funcionalidades que não estejam no PRD.
2. Toda mudança feita pela IA deve ser lida e entendida pelo grupo.
3. O código deve continuar simples para que todos consigam explicar o projeto.

**Combinados do grupo:**

- [X] Ninguém clica *Accept* no Agent Mode sem ler a mudança inteira.
- [X] Quem aceitou o código escreve o comentário de fronteira do arquivo.
- [X] Antes de cada marco, revisamos juntos: alguém aqui não entende alguma parte?
- Outro combinado nosso:
  Nenhuma nova funcionalidade será adicionada sem verificar primeiro se ela cabe no prazo do projeto.
**Como vamos garantir que todos entendem tudo** _(ex.: quem implementa apresenta o arquivo aos outros; revezar as partes; revisar o pull request do colega)_:
- O integrante responsável por uma parte deverá explicar o código aos demais.
- O grupo fará revisões antes de cada marco.

-

---

## 🗓️ Bloco 11 — Marcos até 10/12

| Marco | Prazo | Como se comprova no GitHub |
|---|---|---|
| M1 — Canvas preenchido + repositório criado | 16/09 | `CANVAS.md` no `main` |
| M2 — PRD aprovado + telas rascunhadas | 30/09 | `PRD.md` + imagens em `docs/` |
| M3 — Funcionalidade base rodando | 21/10 | tela principal lista dados + 1 ação + `try/catch` |
| M4 — Dados completos (Room/Retrofit) e erros tratados | 11/11 | commits da camada de dados |
| M5 — Identidade visual + `.apk` de release testado | 25/11 | ícone, cores, `.apk` testado por 2 pessoas de fora |
| M6 — `.aab` + material de loja + `README.md` | 02/12 | pasta `loja/` + `README.md` completo |
| **Entrega e apresentação** | **10/12** | tag `v1.0` no repositório |

---

## 🏁 Bloco 12 — Definição de pronto

O grupo só considera o app pronto quando **todas** estas frases forem verdadeiras:

- [ ] O app abre e não fecha sozinho depois de 5 minutos de uso.
- [ ] A tela principal mostra dados reais (não texto de exemplo fixo no código).
- [ ] A ação principal funciona e o resultado aparece na tela.
- [ ] Quando algo falha, aparece uma mensagem clara — o app não quebra.
- [ ] O app tem nome, ícone e cor próprios (nada de ícone padrão do Android).
- [ ] Duas pessoas de fora do grupo instalaram o `.apk` e conseguiram usar sem explicação.
- [ ] O `README.md` explica o que o app faz, com o que foi feito e como gerar o build.
- [ ] O `docs/USO_DE_IA.md` e o `AGENTS.md` estão preenchidos.
- [ ] **Cada integrante consegue abrir o projeto e fazer uma mudança pequena sozinho** — trocar um texto, acrescentar um campo, mudar a ordem da lista.
- [ ] Todo arquivo nosso tem o comentário de fronteira escrito por nós.

---

## ✍️ Validação do professor

| | |
|---|---|
| Data | |
| Situação | ( ) Aprovado ( ) Aprovado com ajustes ( ) Refazer |
| Observações | |
