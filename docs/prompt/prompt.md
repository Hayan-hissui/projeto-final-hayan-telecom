# Prompt de Planejamento e Organização — Projeto Hayan Telecom (Android Studio)

## 1. Contexto e Objetivo
Atue como um Arquiteto de Software Android sênior e especialista em Jetpack Compose. Você está auxiliando no desenvolvimento do aplicativo **Hayan Telecom**, um projeto acadêmico desenvolvido em Kotlin[cite: 2]. O objetivo deste prompt é analisar o repositório atual e estruturar o plano técnico e arquitetural da aplicação com base estritamente nos documentos de planejamento do projeto.

## 2. Documentos de Referência Obrigatórios
Para realizar esta análise e planejar a implementação, você **deve ler obrigatoriamente** o conteúdo dos seguintes arquivos presentes no repositório:
- **`CANVAS.md`**: Define o escopo geral, regras de trabalho com IA, restrições e o caminho técnico baseado em Room e API Asaas[cite: 1].
- **`prd.md`**: Produto Minimum Viable (MVP), regras de negócio, requisitos funcionais (RF01 a RF10) e não funcionais, além do tratamento de erros[cite: 2].
- **`hayan-telecom-especificacao-telas.pdf`** (ou as especificações visuais fornecidas): Define a identidade visual exata, cores, tipografia, fluxo e layout das telas[cite: 3].

## 3. Diretrizes Técnicas Inegociáveis
- **Escopo Fechado:** Não adicione nenhuma funcionalidade, tela, rota ou biblioteca que não esteja explicitamente prevista no PRD[cite: 2].
- **Simplicidade (Manutenibilidade):** O código deve ser limpo e estruturado de forma simples, garantindo que estudantes do ensino médio consigam compreender, explicar e modificar o projeto com facilidade[cite: 2].
- **Identidade Visual:**
    - Cor primária: `#424F8F` (centralizada em `Color.kt`)[cite: 3].
    - Tipografia: Títulos em **Manrope** e textos em **DM Sans**[cite: 3].
    - Componentes: Cantos arredondados (~12-16dp) em cartões e botões, com altura de botão padrão de ~48dp[cite: 3].
- **Estratégia de Dados (Protótipo):** Nesta fase, utilize **dados locais/mockados** estruturados com suporte ao **Room** para persistência, garantindo que a aplicação funcione de forma autônoma[cite: 2, 3]. A arquitetura deve prever futura expansão para integração com a API do Asaas (Sandbox) via Retrofit[cite: 1, 2].
- **Segurança:** Nenhuma chave de API (Asaas) deve ser exposta ou fixada diretamente no código-fonte[cite: 2].

## 4. Escopo de Telas Obrigatórias
O aplicativo deve contemplar rigorosamente as seguintes telas acessíveis por uma barra de navegação inferior fixa com **4 itens** (*Início, Meu plano, Boletos, Minha conta*[cite: 3]):
1. **Entrar (Login):** Autenticação por e-mail/CPF e senha com tratamento de credenciais inválidas[cite: 2, 4].
2. **Cadastro:** Criação de conta demonstrativa (nome, e-mail e senha)[cite: 2, 5].
3. **Início:** Resumo do plano atual (ativo/suspenso) e status da mensalidade com atalho rápido para o boleto[cite: 2, 6, 7].
4. **Meu plano:** Detalhes contratuais, titular, código do cliente (`HT-001284`) e endereço[cite: 3, 8].
5. **Boletos:** Listagem de mensalidades separadas entre "Em aberto" e "Pago"[cite: 9].
6. **Detalhe do boleto:** Visualização de vencimento, valor, código de barras e opção de acesso/download do boleto (pagamento exclusivamente via boleto bancário)[cite: 2, 3, 10].
7. **Minha conta:** Dados cadastrais do usuário e opção de encerramento de sessão (*Sair da conta*)[cite: 10].

## 5. Formato de Resposta Esperado (Output)
Apresente um relatório técnico detalhado contendo:
1. **Diagnóstico do Repositório:** Análise da estrutura atual de pastas e o que precisa ser reorganizado.
2. **Arquitetura de Pastas Proposta:** Organização recomendada separando a Camada de Apresentação (Jetpack Compose), Modelos de Dados e Persistência local (Room).
3. **Plano de Implementação em Marcos:** Ordem lógica e incremental de desenvolvimento alinhada ao cronograma do projeto.
4. **Exemplos de Código Inicial:** Exemplo de configuração do arquivo `Color.kt` com a cor `#424F8F` e a modelagem inicial de dados para orientar o grupo no Android Studio.





Prompt 2

# Prompt de Implementação — Retrofit e Integração de Dados | Hayan Telecom

## 1. Contexto

Você está trabalhando no projeto Android **Hayan Telecom**, desenvolvido em Kotlin, Jetpack Compose e Room.

Repositório: `https://github.com/Hayan-hissui/projeto-final-hayan-telecom/tree/hayan`

Seu objetivo é implementar a integração com a API do Asaas utilizando Retrofit, conectando os dados remotos à interface existente e mantendo a persistência local com Room.

Antes de modificar qualquer arquivo, analise a estrutura atual do projeto e leia obrigatoriamente:

- `PRD.md`
- `CANVAS.md`
- `AGENTS.md`
- `README.md`
- `docs/prompt/output.md`
- `docs/USO_DE_IA.md`

Consulte também os arquivos Kotlin relacionados à interface, navegação, modelos, banco de dados, DAOs, repositório e dependências Gradle.

## 2. Objetivos da implementação

Implemente as seguintes funcionalidades:

1. Configurar o Retrofit e o conversor Gson.
2. Criar os serviços necessários para comunicação com a API do Asaas.
3. Criar DTOs para representar as respostas da API.
4. Integrar os dados remotos ao repositório existente.
5. Conectar as telas atuais aos dados fornecidos pelo repositório.
6. Persistir localmente no Room os dados necessários para consultas posteriores.
7. Implementar estados de carregamento, sucesso, erro e ausência de dados na interface.
8. Atualizar `docs/prompt/output.md` com um relatório detalhado de todas as modificações realizadas.

## 3. Regras obrigatórias

- Preserve a identidade visual e a navegação existentes.
- Não recrie telas que já estão implementadas.
- Não remova funcionalidades existentes sem justificativa técnica.
- Não adicione funcionalidades fora do escopo do PRD.
- Mantenha o código simples, organizado e compreensível para estudantes do ensino médio.
- Respeite os comentários de fronteira e as regras de documentação do projeto.
- Não invente endpoints, campos ou respostas da API. Consulte a documentação oficial do Asaas e valide os contratos utilizados.
- Não exponha chaves de API, tokens ou outras credenciais no código-fonte, nos arquivos de documentação ou no Git.
- Não utilize credenciais reais. A integração deve utilizar o ambiente Sandbox.
- Não substitua os dados existentes por valores fictícios apresentados como dados reais da API.
- Preserve os dados locais quando a API estiver indisponível.

## 4. Arquitetura e organização

Mantenha a arquitetura atual e amplie-a apenas quando necessário.

Organize a integração remota dentro de `data/remote`, utilizando uma estrutura semelhante a:

- `AsaasApiService.kt`: definição dos endpoints Retrofit.
- `RetrofitClient.kt`: configuração e instância do Retrofit.
- `dto/`: modelos de resposta e requisição da API.
- `mapper/`: conversão entre DTOs e modelos utilizados pelo aplicativo.

Adapte os nomes e a estrutura às convenções já presentes no projeto.

O `HayanRepository` deve continuar centralizando o acesso aos dados, coordenando as consultas remotas e a persistência local.

Evite duplicar lógica de negócio nas telas.

## 5. Integração com a API

Implemente a integração necessária para as funcionalidades previstas no PRD:

### Autenticação
- Preserve o fluxo de login e cadastro existente.
- Não trate a chave de API do Asaas como uma credencial de usuário.
- Não simule autenticação remota se a API não oferecer esse recurso.
- Se for necessária uma autenticação própria de clientes, mantenha-a separada da autenticação administrativa do Asaas.

### Plano e dados do cliente
- Utilize os dados disponíveis na API ou no modelo de dados existente.
- Não presuma que a API do Asaas fornece informações de planos de internet.
- Caso os dados do plano não estejam disponíveis remotamente, mantenha a fonte local existente e documente essa limitação.

### Boletos e cobranças
- Consulte as cobranças do cliente autenticado.
- Converta as respostas da API para os modelos utilizados pelo aplicativo.
- Mantenha a listagem e os detalhes dos boletos funcionando.
- Implemente a ação de pagamento conforme os recursos realmente disponíveis na API e o escopo do PRD.
- Não declare uma cobrança paga sem confirmação válida da API ou do fluxo de pagamento implementado.

## 6. Persistência e sincronização

- Utilize Room como armazenamento local.
- Atualize os dados locais após consultas remotas bem-sucedidas.
- Utilize os dados armazenados quando não houver conexão ou quando a API falhar.
- Evite apagar dados locais válidos durante uma sincronização malsucedida.
- Preserve os DAOs e as entidades existentes sempre que possível.
- Caso seja necessária uma migração do banco, implemente-a de forma segura.

## 7. Interface e tratamento de erros

Conecte as telas existentes ao repositório, mantendo o padrão visual atual.

Implemente:

- Indicadores de carregamento durante consultas remotas.
- Mensagens claras para falhas de conexão e erros da API.
- Estado vazio quando não houver cobranças.
- Atualização da interface após sincronização ou pagamento confirmado.
- Uso de cor e tipografia já definidas no tema do aplicativo.

Não permita que falhas de rede ou banco de dados encerrem inesperadamente o aplicativo.

## 8. Segurança

A API do Asaas utiliza credenciais de acesso que não devem ser distribuídas em um aplicativo Android público.

Não coloque uma chave secreta diretamente no código Kotlin, no `BuildConfig`, no `local.properties` como se isso garantisse proteção em produção, nem em arquivos versionados.

Se a integração exigir uma chave privada, identifique a necessidade de um backend intermediário seguro. Para desenvolvimento acadêmico, utilize somente credenciais Sandbox e siga as configurações seguras já existentes no projeto.

Não invente uma solução de segurança nem afirme que uma chave embutida no APK está protegida.

## 9. Testes e validação

Após implementar:

1. Verifique a sincronização do Gradle.
2. Compile o aplicativo.
3. Corrija erros de compilação introduzidos pelas alterações.
4. Verifique a navegação e as telas afetadas.
5. Teste o tratamento de falhas de rede.
6. Verifique a persistência e leitura dos dados pelo Room.
7. Informe quais testes foram executados e quais não puderam ser realizados.

Não declare que o aplicativo foi testado em dispositivo físico ou que a API funcionou se isso não tiver sido efetivamente verificado.

## 10. Atualização obrigatória do output.md

Ao terminar a implementação, atualize `docs/prompt/output.md`.

O relatório deve registrar:

- Resumo das modificações.
- Arquivos criados, alterados ou removidos.
- Dependências adicionadas ou modificadas.
- Endpoints utilizados e suas finalidades.
- Como o Retrofit foi configurado.
- Como a integração se conecta ao repositório, Room e interface.
- Tratamento de erros e estratégias de persistência.
- Decisões técnicas e limitações encontradas.
- Testes executados e respectivos resultados.
- Pendências que ainda precisam ser resolvidas.

Preserve o histórico relevante já existente no documento. Acrescente uma nova seção intitulada **"Implementação Retrofit e Integração com API"**, com a data da execução.

## 11. Resultado esperado

Ao final, o aplicativo deverá manter sua interface atual e utilizar o Retrofit para consultar os dados remotos previstos no escopo, persistindo as informações necessárias no Room e apresentando estados adequados ao usuário.

Execute as alterações diretamente nos arquivos do projeto. Não responda apenas com exemplos de código ou um plano: implemente, valide e documente o trabalho realizado.

Se encontrar uma limitação que impeça uma integração real, implemente somente o que puder ser feito com segurança, documente a limitação no `output.md` e não invente resultados.



# Prompt 4 — Refatoração de UI e Estabilização da Arquitetura MVVM

## 1. Contexto e Status Atual
Você concluiu a migração das telas remanescentes para o padrão MVVM e estabilizou o fluxo de navegação. O projeto agora possui uma arquitetura clara:
- **UI (Compose)**: Observa estados via `StateFlow` e delega ações aos ViewModels.
- **ViewModels**: Gerenciam estado de UI, carregamento e erros, interagindo com o Repositório.
- **Data (Repository/Room/Retrofit)**: Centraliza a lógica de dados e sincronização remota com o Asaas Sandbox.

## 2. Ações Realizadas (Resumo)
1. **Refatoração de Telas**:
   - `ProfileScreen.kt`: Migrada para utilizar `ProfileViewModel`.
   - `InvoiceDetailScreen.kt`: Refatorada para receber `boletoId` e gerenciar dados via `InvoicesViewModel`.
2. **Navegação e Injeção**:
   - `NavGraph.kt`: Centralizou a criação de ViewModels via `ViewModelFactory`.
   - Corrigidas assinaturas de callback em `LoginScreen` e `CadastroScreen` para evitar erros de tipagem.
   - Implementado `SnackbarHost` no `Scaffold` principal para exibição global de erros vindos dos ViewModels.
3. **Estabilização**:
   - Limpeza de imports e correção de delegados `by` (adicionado `import androidx.compose.runtime.getValue`).
   - Sincronização de fluxos de autenticação (`loginSuccess`, `cadastroSuccess`) com `LaunchedEffect` para navegação.

## 3. Próximos Passos (Pendentes para o Grupo)
1. **Validação de Sincronização Remota**: Testar se o `repository.sincronizarCobrancasRemotas()` está populando corretamente o Room ao entrar na `HomeScreen` ou `InvoicesScreen`.
2. **Testes de UI**: Verificar se o `Snackbar` exibe corretamente as mensagens de erro ao falhar o login ou pagamento.
3. **Polimento**: Revisar textos e strings para garantir que seguem o tom de voz da Hayan Telecom definido no PRD.
4. **Build Final**: Executar `./gradlew assembleDebug` para garantir que nenhuma regressão de compilação foi introduzida.

## 4. Diretrizes para Continuidade
- Mantenha o `NavGraph.kt` como o ponto central de coordenação entre navegação e ciclo de vida dos ViewModels.
- Não remova o `ViewModelFactory` manual, pois ele é a base da injeção de dependência atual do projeto.
- Certifique-se de que qualquer nova funcionalidade de dados passe obrigatoriamente pelo `HayanRepository`.
