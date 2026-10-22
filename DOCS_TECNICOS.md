# Documentação Técnica - Persistência de Dados (Cliente)

## 1. Alterações no DAO (`ClienteDao.kt`)
Foi expandida a interface de acesso a dados para suportar operações completas de persistência:
- `getClienteById(id: String)`: Consulta reativa via Flow.
- `insertCliente(cliente: Cliente)`: Operação suspensa com estratégia de substituição em conflito.
- `updateCliente(cliente: Cliente)`: Atualização de dados cadastrais.
- `deleteCliente(cliente: Cliente)`: Remoção física do registro.
- `clearClientes()`: Limpeza total da tabela.

## 2. Camada de Repositório (`HayanRepository.kt`)
O repositório agora atua como mediador para todas as operações do `ClienteDao`, garantindo que as chamadas sejam feitas no contexto `IO`.
- Adicionados métodos: `insertCliente`, `updateCliente`, `deleteCliente` e `getClienteById`.

## 3. Banco de Dados (`AppDatabase.kt`)
- A entidade `Cliente` permanece registrada.
- A versão do banco foi mantida para evitar `Destructive Migration` desnecessária, já que não houve alteração de colunas ou tipos.

## 4. Impacto na UI
- As telas que consomem `clienteFlow` (como `HomeScreen` e `ProfileScreen` via `NavGraph`) agora se beneficiam de operações de escrita mais seguras e consistentes.
- O fluxo de "Cadastro" e "Login" foi integrado ao repositório para persistir e validar dados reais no Room.
- A tela de login agora fornece feedback visual (`CircularProgressIndicator`) durante o processamento da autenticação.

## 5. Feedback e Notificações de UI
O sistema utiliza mensagens de erro em tela para notificar o usuário sobre o status das operações, seguindo o item 14 do PRD:
- **Campos Vazios**: Exibe "Preencha todos os campos obrigatórios."
- **Credenciais Inválidas**: Exibe "E-mail ou senha inválidos." (RF02).
- **Falha de Conexão/Geral**: Exibe "Não foi possível conectar ao servidor. Verifique sua internet e tente novamente."
- **Feedback de Carregamento**: O botão de entrada é desativado e exibe um indicador de progresso enquanto a autenticação é processada no banco de dados.
