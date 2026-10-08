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