prompt pra criação do prd: preciso que você me ajude com essa atividade, tenho que preencher esse prd de acordo com o canvas, que é o meu documento de requisitos: dai eu enviei os arquivos de template pra o chat conseguir editar com base neles.


prompt do codigo no android studio: Crie o boilerplate mínimo e compilável para o projeto Android em Kotlin chamado Hayan Telecom, usando o Canvas do projeto abaixo como contexto.

IMPORTANTE:

* Neste momento NÃO implemente regras de negócio.
* NÃO crie entidades Room.
* NÃO crie DAOs.
* NÃO crie interfaces Retrofit.
* NÃO crie ViewModels.
* NÃO implemente funcionalidades reais.
* NÃO implemente login, pagamento, instalação ou qualquer outra regra de negócio.
* O objetivo deste commit é somente criar a infraestrutura/casca inicial do projeto.
* Não use Hilt, Koin ou qualquer outra biblioteca de injeção de dependências.

Contexto do projeto

Nome do app: Hayan Telecom

O aplicativo futuramente permitirá que clientes da Hayan Telecom consultem informações do seu plano, verifiquem se ele está ativo, façam renovação quando necessário e enviem uma solicitação de instalação.

Por enquanto, nada disso deve ser implementado. Apenas prepare a estrutura para que essas funcionalidades possam ser desenvolvidas posteriormente.

Tech Stack

* Kotlin
* Jetpack Compose
* Material 3
* Navigation Compose
* Room Database
* Retrofit 2
* Gson Converter
* Kotlin Coroutines
* Kotlin Flow
* KSP para o Room

Pacote principal

Use:

com.example.hayantelecom

Não utilize com.example.petshop.

Estrutura de pacotes

Crie exatamente esta estrutura inicial:

com.example.hayantelecom/
├── data/
│   ├── local/
│   ├── remote/
│   └── repository/
├── model/
├── ui/
│   ├── theme/
│   │   ├── Color.kt
│   │   ├── Type.kt
│   │   └── Theme.kt
│   ├── navigation/
│   │   ├── NavGraph.kt
│   │   └── NavTarget.kt
│   └── features/
└── MainActivity.kt

As pastas podem permanecer vazias quando não houver código necessário neste momento.

Gradle

Configure o projeto para utilizar:

* Android Application
* Kotlin Android
* Kotlin Compose
* KSP

No Gradle do aplicativo, adicione somente as dependências necessárias para:

* Jetpack Compose
* Material 3
* Navigation Compose
* Room Runtime
* Room KTX
* Room Compiler via KSP
* Retrofit
* Gson Converter
* Kotlin Coroutines Android

Não implemente Room ainda. Apenas deixe as dependências e o plugin KSP configurados.

Não crie:

* Entity
* DAO
* Database
* Repository concreto
* API Service
* Retrofit Instance

MainActivity

Crie uma MainActivity simples usando:

ComponentActivity
enableEdgeToEdge()
setContent

A Activity deve utilizar o tema do aplicativo e chamar o NavGraph.

O aplicativo deve abrir normalmente e mostrar apenas uma tela placeholder com o texto:

“Hayan Telecom”

Essa tela serve somente para confirmar que a infraestrutura está funcionando.

Navegação

Crie uma sealed class ou enum chamada:

NavTarget.kt

Ela deve possuir apenas uma rota:

Home

Por exemplo, a rota pode ser:

“home”

Não crie outras telas ou rotas ainda.

NavGraph

Crie um NavHost básico utilizando Navigation Compose.

O NavHost deve iniciar na rota Home e mostrar uma tela simples contendo:

Text(“Hayan Telecom”)

Não crie telas de login, pagamento, plano, instalação ou perfil neste momento.

Tema

Mantenha o tema baseado no template padrão do Jetpack Compose + Material 3.

Crie:

Color.kt
Type.kt
Theme.kt

Não é necessário definir uma identidade visual completa agora. Pode manter as cores padrão do template caso ainda não exista uma definição final de cores no Canvas.

Regras importantes

1. O projeto precisa compilar.
2. Não adicione código desnecessário.
3. Não invente entidades ou modelos.
4. Não implemente funcionalidades do Canvas ainda.
5. Não crie ViewModel.
6. Não crie DAO.
7. Não crie Entity.
8. Não crie Retrofit Service.
9. Não crie Repository implementado.
10. Não adicione Hilt ou Koin.
11. Faça somente a infraestrutura inicial.
12. Antes de alterar arquivos, explique brevemente quais arquivos serão criados ou modificados.
13. Não faça alterações fora do necessário para esse boilerplate.
14. Preserve o código padrão do projeto quando ele já estiver correto.
15. Se alguma dependência já estiver configurada corretamente, não duplique a dependência.

Objetivo do primeiro commit

Ao finalizar, o projeto deve:

* abrir no Android Studio;
* sincronizar o Gradle;
* compilar;
* executar no emulador ou celular;
* abrir a tela inicial;
* mostrar “Hayan Telecom”;
* possuir a estrutura de pastas preparada para os próximos commits.

Este é apenas o commit inicial de infraestrutura. As entidades e funcionalidades serão desenvolvidas posteriormente por cada integrante do grupo.

Canvas do projeto:

Nome: Hayan Telecom

Integrantes:

* Hayan Matheus
* Alberto Vinicius
* Gabriel Fernando

Turma:
3º ano A — Ensino Médio

Funcionalidades futuras do MVP:

* Mostrar se o plano está ativo ou não.
* Renovar o plano caso não esteja ativo.
* Enviar requisição de instalação.

Neste momento, NÃO implemente nenhuma dessas funcionalidades.

cria um prompt pedindo pro gemini do android studio criar 3 endidades conforme esse documento que te mandei, antes de mandar o prompt me manda as endidades escolhidas que voce acha que se encaixam, pra eu conferir.
Com base no PRD do projeto Hayan Telecom, crie apenas as 3 entidades principais do sistema:

Cliente
Campos:
id
nome
email
Plano
Campos:
id
nome
valorMensalidade
status
Cobranca
Campos:
id
clienteId
valor
dataVencimento
status
codigoBoleto

Contexto do projeto:

Aplicativo Android em Kotlin.
Interface utilizando Jetpack Compose.
Arquitetura simples e fácil de entender para todos os integrantes.
Retrofit será utilizado para comunicação com API.
Room será utilizado para persistência local.
O projeto utiliza Kotlin e Android Jetpack.
A integração de cobranças utiliza a API do Asaas em ambiente Sandbox.

Regras importantes:

Crie somente essas 3 entidades.
Não crie outras entidades, como Pagamento, Contrato, Técnico ou Usuário.
Não implemente regras de negócio.
Não implemente telas.
Não implemente login.
Não implemente Retrofit ou chamadas de API neste momento.
Não implemente DAOs, Repository ou ViewModel, a menos que sejam estritamente necessários para que as entidades do Room sejam configuradas corretamente.
Não adicione campos que não foram solicitados.
Mantenha o código simples e fácil de explicar.
Siga a estrutura de pastas já existente no projeto.
Antes de alterar qualquer arquivo, analise a estrutura atual do projeto para evitar criar arquivos duplicados ou modificar arquivos desnecessariamente.
Caso o projeto já possua alguma configuração do Room, aproveite a configuração existente em vez de criar outra.
As entidades devem ser compatíveis com o Room.
Use @Entity e @PrimaryKey quando apropriado.
Os IDs devem ser identificadores únicos.
Em Cobranca, clienteId deve representar o relacionamento da cobrança com o cliente.
O campo status deve ser simples e compatível com a implementação atual do projeto.
codigoBoleto deve representar a informação necessária para identificar/acessar o boleto quando disponível.

Importante:
Não altere o restante do projeto sem necessidade. Não crie funcionalidades além das 3 entidades solicitadas.

Antes de fazer as alterações, explique brevemente quais arquivos você pretende criar ou modificar. Depois, implemente somente o necessário.
