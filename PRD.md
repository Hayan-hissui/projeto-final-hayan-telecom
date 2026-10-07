PRD — Hayan Telecom
1. Visão geral
Nome do produto: Hayan Telecom
Plataforma: Android
Versão inicial: 1.0
Application ID: br.edu.ifpe.hayantelecom
Equipe: Hayan Matheus, Alberto Vinicius e Gabriel Fernando
Turma: 3º ano A — Ensino Médio
Entrega final: 10/12/2026

Pitch
O app Hayan Telecom ajuda clientes a gerenciar seus boletos e consultar o status do plano atual.

2. Problema
Clientes de provedores de internet precisam entrar em contato com a empresa para consultar informações básicas sobre seu plano e suas cobranças.

Atualmente, essas informações são solicitadas principalmente por WhatsApp, redes sociais ou atendimento direto. O cliente precisa aguardar um funcionário consultar os dados e responder.

Isso gera:

aumento da demanda sobre a equipe de atendimento;

demora para o cliente obter informações simples;

repetição de solicitações;

menor produtividade da empresa.

O Hayan Telecom busca centralizar essas informações em um aplicativo Android, permitindo que o cliente consulte seus dados sem depender do atendimento para tarefas básicas.

3. Objetivo do produto
O objetivo do Hayan Telecom é permitir que clientes de um provedor de internet consultem, de maneira simples e centralizada:

seus dados básicos;

o plano contratado;

o status atual do plano;

o valor da mensalidade;

a situação da cobrança;

os detalhes do boleto;

a possibilidade de realizar o pagamento da mensalidade.

O aplicativo deve reduzir a necessidade de contato com a empresa para consultas relacionadas ao plano e às cobranças.

4. Público-alvo
Público principal
Clientes de provedores de internet que precisam consultar informações sobre seu plano ou suas cobranças.

Contexto de uso
O aplicativo será utilizado principalmente em casa, pelo celular, quando o cliente precisar:

verificar se o plano está ativo;

consultar o valor da mensalidade;

verificar se existe cobrança pendente;

consultar informações do boleto;

realizar o pagamento.

Usuário de teste
Uma das pessoas que poderá testar o aplicativo é Jorge, dono da empresa.

5. Proposta de valor
O Hayan Telecom transforma consultas que atualmente dependem do atendimento da empresa em ações que o próprio cliente pode realizar pelo celular.

A proposta principal é:

"Consulte seu plano e suas cobranças de forma rápida, sem precisar entrar em contato com a empresa."

6. Escopo do MVP
O MVP será composto por três funcionalidades principais.

F1 — Visualização do plano e cobrança
O usuário poderá visualizar:

nome e informações básicas do cliente;

plano contratado;

status do plano: ativo ou suspenso;

valor da mensalidade;

situação da cobrança.

Responsável: Alberto

F2 — Pagamento da mensalidade
O usuário poderá realizar o pagamento da mensalidade através da integração definida para o projeto.

A integração será desenvolvida inicialmente utilizando o Sandbox do Asaas, evitando movimentações financeiras reais durante o desenvolvimento.

Responsável: Hayan

F3 — Login e cadastro
O usuário poderá realizar login para acessar seus dados.

O sistema deverá validar os dados informados e impedir o acesso quando as credenciais forem inválidas.

Responsável: Gabriel

7. Fluxo principal do usuário
O fluxo principal esperado é:

O usuário abre o aplicativo.

O aplicativo apresenta a tela de login.

O usuário informa suas credenciais.

O sistema valida os dados.

Após o login, o usuário acessa a tela principal.

A tela principal apresenta seus dados, plano e situação da cobrança.

O usuário pode acessar os detalhes da cobrança.

O usuário visualiza valor, vencimento e situação do boleto.

Quando disponível, o usuário pode realizar o pagamento.

8. Tela principal
A tela principal será o principal ponto de consulta do aplicativo.

Ela deverá apresentar:

Dados do cliente
Nome do cliente;

Informações básicas necessárias para identificação.

Plano
Nome ou descrição do plano;

Status atual;

Informação se está ativo ou suspenso.

Cobrança
Valor da mensalidade;

Situação da cobrança;

Informação sobre cobrança pendente, quando houver.

Ações
A principal ação será:

Consultar a situação do plano e verificar se existe uma cobrança pendente.

O usuário também poderá acessar os detalhes da cobrança.

9. Tela de detalhes da cobrança
Ao selecionar uma cobrança, o usuário deverá visualizar informações como:

valor;

data de vencimento;

situação da cobrança;

informações disponíveis do boleto;

ação para realizar o pagamento, quando aplicável.

Caso os dados não possam ser carregados, o aplicativo deverá informar o problema ao usuário de forma clara.

10. Autenticação
O aplicativo terá uma tela de login.

O sistema deverá:

receber os dados de acesso;

validar os campos obrigatórios;

verificar as credenciais;

permitir o acesso quando os dados forem válidos;

informar o usuário quando os dados forem inválidos.

Erro de autenticação
Quando o usuário informar dados incorretos, deverá aparecer uma mensagem semelhante a:

"E-mail ou senha inválidos."

11. Integração com dados e pagamentos
O projeto utilizará a API do Asaas para integração relacionada às cobranças.

A documentação utilizada será:

https://docs.asaas.com/

Durante o desenvolvimento será utilizado o Sandbox do Asaas, que permite testar a integração sem movimentação de dinheiro real.

A API exige uma chave de acesso. Durante o desenvolvimento será utilizada uma chave específica do ambiente Sandbox.

A chave não deverá ser inserida diretamente no código-fonte ou publicada no repositório.

12. Arquitetura e tecnologias
Linguagem
Kotlin

Interface
Jetpack Compose

Dados remotos
Retrofit

Dados locais
Room

Plataforma
Android

Componentes adicionais
Android Jetpack

A arquitetura deverá ser mantida simples para que todos os integrantes consigam compreender e explicar o funcionamento do projeto.

13. Uso do Room
O Room será utilizado para armazenar localmente os dados necessários ao funcionamento do aplicativo.

O armazenamento local poderá ser utilizado para manter informações que sejam necessárias quando houver indisponibilidade temporária da comunicação com o servidor.

O banco local não deve substituir a fonte oficial dos dados da conta e das cobranças quando uma consulta atualizada à API estiver disponível.

14. Tratamento de erros
Operações que dependem de rede, API ou banco de dados poderão falhar.

O aplicativo deverá utilizar tratamento de exceções, incluindo try/catch quando apropriado, para evitar que erros façam o aplicativo fechar inesperadamente.

Situações que devem ser tratadas
ausência de conexão com a internet;

API indisponível;

servidor indisponível;

dados de login inválidos;

falha na consulta de cobranças;

falha no acesso aos dados do boleto;

erro ao salvar dados localmente;

erro ao consultar dados armazenados localmente;

campos obrigatórios vazios.

Mensagens esperadas
Falha de conexão:

"Não foi possível conectar ao servidor. Verifique sua internet e tente novamente."

Falha ao carregar cobranças:

"Não foi possível carregar suas cobranças. Tente novamente."

Falha ao acessar boleto:

"Não foi possível acessar o boleto no momento. Tente novamente mais tarde."

As mensagens devem ser claras e compreensíveis para usuários que não possuem conhecimento técnico.

15. Fora do escopo
As seguintes funcionalidades não fazem parte da versão 1.0:

solicitação de instalação;

atendimento por chat;

integração com WhatsApp;

sistema completo de suporte ao cliente;

notificações push;

mapa ou acompanhamento de técnico;

outras funcionalidades não previstas neste PRD;

outros meios de pagamento inicialmente, como Pix ou cartão.

Qualquer nova funcionalidade deverá ser avaliada pelo grupo antes de ser adicionada e somente poderá entrar no projeto se houver tempo suficiente para sua implementação, testes e documentação.

16. Identidade visual
Nome exibido
Hayan Telecom

Cor principal
#424f8f

A cor principal deverá ser centralizada no arquivo Color.kt.

Ícone
O aplicativo utilizará a logo oficial da Hayan Telecom como ícone.

O ícone deverá substituir o ícone padrão fornecido pelo Android.

17. Requisitos funcionais
RF01 — Login
O sistema deve permitir que o usuário informe suas credenciais para acessar sua conta.

RF02 — Validação de login
O sistema deve informar quando as credenciais fornecidas forem inválidas.

RF03 — Visualização do cliente
O sistema deve apresentar as informações básicas do cliente autenticado.

RF04 — Visualização do plano
O sistema deve apresentar o plano contratado pelo cliente.

RF05 — Visualização do status
O sistema deve apresentar se o plano está ativo ou suspenso.

RF06 — Visualização da cobrança
O sistema deve apresentar o valor e a situação da mensalidade.

RF07 — Detalhes da cobrança
O sistema deve permitir acessar informações detalhadas da cobrança.

RF08 — Pagamento
O sistema deve permitir iniciar o processo de pagamento da mensalidade através da integração definida para o projeto.

RF09 — Tratamento de erros
O sistema deve apresentar mensagens claras quando uma operação não puder ser concluída.

RF10 — Persistência local
O sistema deve utilizar o Room para armazenar os dados locais necessários ao funcionamento do aplicativo.

18. Requisitos não funcionais
RNF01 — Plataforma
O aplicativo deverá funcionar em dispositivos Android compatíveis com a configuração definida no projeto.

RNF02 — Usabilidade
As informações principais devem estar disponíveis de maneira simples e objetiva.

RNF03 — Estabilidade
O aplicativo não deve fechar inesperadamente durante o uso normal.

RNF04 — Tratamento de falhas
Falhas de comunicação ou acesso aos dados não devem causar o encerramento do aplicativo.

RNF05 — Segurança
Informações sensíveis, como chaves de API, não devem ser armazenadas diretamente no código-fonte público.

RNF06 — Manutenibilidade
O código deverá permanecer simples e organizado para que todos os integrantes consigam compreender as principais partes do projeto.

RNF07 — Identidade
O aplicativo deverá possuir nome, ícone e identidade visual próprios.

19. Critérios de aceitação do MVP
O MVP será considerado funcional quando:

o aplicativo abrir normalmente;

o usuário conseguir realizar login;

a tela principal apresentar dados reais;

o plano contratado for apresentado;

o status do plano for apresentado;

a situação da cobrança for apresentada;

o usuário conseguir acessar os detalhes da cobrança;

a ação de pagamento funcionar conforme a integração implementada;

erros de comunicação apresentarem mensagens claras;

o aplicativo não fechar quando uma operação falhar;

os dados necessários forem persistidos utilizando Room;

a interface utilizar a identidade visual definida;

o aplicativo utilizar a logo da Hayan Telecom;

duas pessoas externas ao grupo conseguirem instalar e utilizar o APK sem explicações.

20. Segurança e dados sensíveis
As chaves de acesso da API não deverão ser incluídas diretamente no código-fonte publicado no GitHub.

O ambiente de desenvolvimento deverá utilizar as credenciais do Sandbox.

Informações sensíveis deverão ser tratadas de maneira que não sejam expostas no repositório.

A integração com o ambiente de produção não faz parte da entrega inicial do projeto.

21. Divisão da equipe
Integrante	Papel principal	Responsabilidades
Hayan	Dev / telas	Interface, navegação e tela principal
Alberto	Dev / dados	API, Retrofit, Room e gerenciamento dos dados
Gabriel	Dev / dados	API, Retrofit, Room e gerenciamento dos dados
Hayan	Design	Identidade visual, integração com boletos e testes
Todos	Documentação	Documentação, build e entrega

Todos os integrantes deverão programar e compreender as partes principais do projeto.

O responsável por uma parte deverá apresentar e explicar o código aos demais integrantes.

22. Acordo de desenvolvimento com IA
A implementação poderá utilizar o Gemini no Android Studio.

A IA será utilizada como ferramenta de apoio ao desenvolvimento, mas os integrantes continuam responsáveis pelo código produzido.

Regras
A IA não deve adicionar funcionalidades que não estejam previstas no PRD.

Toda mudança feita pela IA deverá ser lida e entendida pelo grupo.

O código deverá permanecer simples o suficiente para que todos consigam explicar o projeto.

Nenhum integrante deverá aceitar uma alteração no Agent Mode sem ler a mudança inteira.

O integrante que aceitar uma alteração deverá escrever o comentário de fronteira do arquivo, conforme as regras do projeto.

Antes de cada marco, o grupo deverá revisar o projeto em conjunto.

23. Marcos do projeto
Marco	Prazo	Entrega
M1	16/09/2026	Canvas preenchido + repositório criado
M2	30/09/2026	PRD aprovado + telas rascunhadas
M3	21/10/2026	Funcionalidade base funcionando
M4	11/11/2026	Room/Retrofit + tratamento de erros
M5	25/11/2026	Identidade visual + APK de release testado
M6	02/12/2026	AAB + material de loja + README
Entrega	10/12/2026	Tag v1.0 no repositório

24. Definição de pronto
O Hayan Telecom será considerado pronto quando:

 O aplicativo abrir e permanecer estável durante o uso.

 A tela principal apresentar dados reais.

 O usuário conseguir realizar a ação principal.

 O resultado da ação aparecer corretamente na interface.

 Falhas apresentarem mensagens claras.

 O aplicativo possuir nome próprio.

 O aplicativo possuir ícone próprio.

 O aplicativo utilizar a cor definida pelo grupo.

 Duas pessoas externas ao grupo conseguirem instalar e utilizar o APK.

 O README.md explicar o funcionamento e o processo de build.

 docs/USO_DE_IA.md estiver preenchido.

 AGENTS.md estiver preenchido.

 Cada integrante conseguir realizar uma alteração simples no projeto sozinho.

 Os arquivos do projeto possuírem os comentários de fronteira exigidos.

 O grupo conseguir explicar as principais partes do código.

25. Riscos e planos de contingência
Risco	Plano B
Dificuldade na integração com a API de boletos	Utilizar o Sandbox e consultar a documentação oficial
API indisponível	Exibir mensagem de erro e utilizar dados locais quando possível
Internet indisponível	Informar o usuário e utilizar dados locais disponíveis
Falta de tempo para concluir o pagamento	Priorizar login, consulta do plano, cobranças e acesso ao boleto
Erros no banco local	Tratar exceções e apresentar mensagem ao usuário
Problemas causados por novas funcionalidades	Não adicionar funcionalidades fora do PRD sem avaliar o prazo

26. Resultado esperado
Ao final do projeto, o Hayan Telecom deverá ser um aplicativo Android funcional que permita ao cliente de um provedor consultar seu plano e suas cobranças em um único lugar.

O sistema deverá reduzir a necessidade de contato com a empresa para consultas básicas e oferecer uma experiência simples para visualizar informações da conta e realizar o pagamento da mensalidade.

A versão 1.0 deverá priorizar estabilidade, simplicidade e compreensão do código pela equipe, evitando funcionalidades adicionais que possam comprometer o prazo de entrega.
